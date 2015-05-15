package com.chinasoft.common.tools;


import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author
 */
public class JsonUtil
{

	/**
	 * @param json {'name':'get','dateAttr':'2009-11-12'}
	 * @param bean
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public static Object jsonToBean(String json, Class bean)
	{
		// 去掉前后{}
		String str = json.substring(1, json.length() - 1);
		String[] arrs = str.split(",");
		Object obj = null;
		Method[] ms = bean.getDeclaredMethods();
		try
		{
			obj = bean.newInstance();
			for (int i = 0; i < ms.length; i++)
			{
				Method m = ms[i];
				String name = m.getName();
				if (name.startsWith("set"))
				{
					for (int j = 0; j < arrs.length; j++)
					{
						String tmp = arrs[j];
						if (name.substring(3, name.length()).equalsIgnoreCase(tmp.substring(1, tmp.indexOf("'", 2))))
						{
							int index = tmp.indexOf(":");
							m.invoke(obj, new Object[] { tmp.substring(index + 2, tmp.length() - 1) });
							break;
						}
					}
				}
			}
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}

		return obj;
	}// jsonToBean

	/**
	 * 复制字段
	 * 
	 * @param from
	 * @param to
	 */
	@SuppressWarnings("rawtypes")
	public static void copyField(Object from, Object to)
	{
		Class fromClz = from.getClass();
		Class toClz = to.getClass();
		Method[] fromMethod = fromClz.getDeclaredMethods();
		Method[] toMethod = toClz.getDeclaredMethods();
		for (int i = 0; i < fromMethod.length; i++)
		{
			Method getVal = fromMethod[i];
			// 1.get 一个对象的属性值
			String getName = getVal.getName();
			if (getName.startsWith("get"))
			{
				try
				{
					Object oldVal = getVal.invoke(from, new Object[] {});
					// 2.执行to对象的set方法
					for (int j = 0; j < toMethod.length; j++)
					{
						Method setVal = toMethod[j];
						// 3 set 一个对象的属性值
						String setName = setVal.getName();
						if (setName.startsWith("set"))
						{
							// 4 from to 对象都存在的属性
							if (getName.substring(3, getName.length()).equalsIgnoreCase(
									setName.substring(3, setName.length())))
							{
								setVal.invoke(to, oldVal);
								break;
							}
						}
					}
				}
				catch (IllegalAccessException e)
				{
					e.printStackTrace();
				}
				catch (IllegalArgumentException e)
				{
					e.printStackTrace();
				}
				catch (InvocationTargetException e)
				{
					e.printStackTrace();
				}
			}
		}
	}// copyField

	/**
	 * 执行某对象的实例方法
	 * 
	 * @param obj
	 * @param methodName
	 * @param args
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object exeMethod(Object obj, String methodName, Object[] args) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Class clz = obj.getClass();
		Class[] clzArgs = new Class[args.length];
		for (int i = 0; i < args.length; i++)
		{
			clzArgs[i] = args[i].getClass();
		}
		Method m = null;
		m = clz.getDeclaredMethod(methodName, clzArgs);
		return m.invoke(obj, args);
	}// exeMethod

	/**
	 * @param jsonStr {'name':'get','dateAttr':'2009-11-12'}
	 * @param clazz User.class
	 * @return
	 */
	public static Object getDtoFromJsonObjStr(String jsonStr, Class clazz)
	{
		return JSONObject.toBean(JSONObject.fromObject(jsonStr), clazz);
	}// getDtoFromJsonObjStr

	/**
	 * 把一个json数组串转换成普通数组
	 * @param jsonArrStr e.g. ['get',1,true,null]
	 * @return
	 */
	public static Object[] getArrFromJsonArrStr(String jsonArrStr)
	{
		return JSONArray.fromObject(jsonArrStr).toArray();
	}// getArrFromJsonArrStr

	/**
	 * 把一个json数组串转换成实体数组
	 * 
	 * @param jsonArrStr [{'name':'get'},{'name':'set'}]
	 * @param clazz
	 * @return
	 */
	public static Object[] getDtoArrFromJsonArrStr(String jsonArrStr, Class clazz)
	{
		JSONArray jsonArr = JSONArray.fromObject(jsonArrStr);
		Object[] objArr = new Object[jsonArr.size()];
		for (int i = 0; i < jsonArr.size(); i++)
		{
			objArr[i] = JSONObject.toBean(jsonArr.getJSONObject(i), clazz);
		}
		return objArr;
	}// getDtoArrFromJsonArrStr

	/**
	 * 把一个json数组串转换成实体数组，且数组元素的属性含有另外实例Bean   
	 * @param jsonArrStr  [{'data':[{'name':'get'}]},{'data':[{'name':'set'}]}]   
	 * @param clazz e.g. MyBean.class   
	 * @param classMap e.g. classMap.put("data", Person.class)   
	 * @return
	 */
	public static Object[] getDtoArrFromJsonArrStr(String jsonArrStr, Class clazz, Map classMap)
	{
		JSONArray array = JSONArray.fromObject(jsonArrStr);
		Object[] obj = new Object[array.size()];
		for (int i = 0; i < array.size(); i++)
		{
			JSONObject jsonObject = array.getJSONObject(i);
			obj[i] = JSONObject.toBean(jsonObject, clazz, classMap);
		}
		return obj;
	}//getDtoArrFromJsonArrStr

	/**
	 * 创建实例
	 * 
	 * @param className
	 * @param args
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object installObj(String className, Object[] args) throws ClassNotFoundException,
			NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{
		Class clzz = Class.forName(className);
		Class[] cls = new Class[args.length];
		for (int i = 0; i < args.length; i++)
		{
			cls[i] = args[i].getClass();
		}
		Constructor constructor = clzz.getConstructor(cls);
		return constructor.newInstance();
	}// installObj

	/**
	 * 返回指定索引的val
	 * 
	 * @param obj
	 * @param index
	 * @return
	 */
	public static Object getVal(Object obj, int index)
	{
		return Array.get(obj, index);
	}// getVal
}
