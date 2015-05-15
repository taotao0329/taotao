package com.chinasoft.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.chinasoft.entities.Permiss;
import com.chinasoft.service.IPermissService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@Controller("perssAction")
@Scope("prototype")
public class PermissonAction extends ActionSupport
{
	
	@Autowired
	private IPermissService perService;
	
	/** 结果 */
	private List<Permiss> list;
	
	/** save */
	private Permiss pms;
	
	/** 查看复选框 */
	private Map<String,String> mapLook;
	/** 执行复选框 */
	private Map<String,String> mapExe;
	
	/** 接收查看复选框结果 */
	private String [] isLook;
	
	/** 接收执行复选结果 */
	private String [] isExe;
	
	/** 超链接 传递参数 */
	private long code;
	
	public String access()
	{
		/** setUp1 将JF过来的人 全部入库 */
		String users = "张三,李四,王五,二蛋";
		String[] arr = users.split(",");
		for(int i=0; i<arr.length;i++)
		{
			Permiss p = new Permiss();
			p.setPowName(arr[i]);
			p.setCreateTime(new Timestamp(System.currentTimeMillis()));
			p.setIsExe(0);
			p.setIsLook(0);
			p.setUserType(0);
//			perService.savePermiss(p);
		}
		/** setUp1 end */
//		maps = new HashMap<String, String>();
//		maps.put("0", "查看权限");
//		maps.put("1", "执行权限");
		
		mapLook = new HashMap<String, String>();
		mapLook.put("1", "查看权限");
		mapExe = new HashMap<String, String>();
		mapExe.put("1", "执行权限");
		list = perService.getAccess();
		return Action.SUCCESS;
	}//access
	public String deletePer()
	{
		perService.deletePer(code);
		return "ok";
	}
	public String savePermiss()
	{
		/*if(null !=exeorLook && exeorLook.length>0)
		{
			//0,1
			for(String s:exeorLook)
			{
				//查看
				if(s.equals("0"))
				{
					pms.setIsLook(1);
				}else if(s.equals("1"))
				{
					pms.setIsExe(1);
				}
			}
		}*/
		setPermiss();
		/** !项目人员 */
		pms.setUserType(1);
		pms.setCreateTime(new Timestamp(System.currentTimeMillis()));
		pms.setOperTime(new Timestamp(System.currentTimeMillis()));
		pms.setRecord("current User");
		perService.savePermiss(pms);
		return "ok";
	}//savePermiss
	private void setPermiss()
	{
		if(null != isLook)
		{
			pms.setIsLook(1);
		}
		else
		{
			pms.setIsLook(0);
		}
		if(null !=isExe)
		{
			pms.setIsExe(1);
		}
		else
		{
			pms.setIsExe(0);
		}
	}//setPermiss
	
	public String getPermiss()
	{
		pms = perService.getPermiss(code);
//		maps = new HashMap<String, String>();
//		maps.put("0", "查看权限");
//		maps.put("1", "执行权限");
		mapLook = new HashMap<String, String>();
		mapLook.put("1", "查看权限");
		mapExe = new HashMap<String, String>();
		mapExe.put("1", "执行权限");
		return "get";
	}//getPermiss
	
	public String updatePermiss()
	{
		setPermiss();
		perService.updatePermiss(pms);
		return "ok";
	}//updatePermiss
	public List<Permiss> getList()
	{
		return list;
	}

	public void setList(List<Permiss> list)
	{
		this.list = list;
	}

	public Permiss getPms()
	{
		return pms;
	}

	public void setPms(Permiss pms)
	{
		this.pms = pms;
	}

	
	

	public Map<String, String> getMapLook()
	{
		return mapLook;
	}
	public void setMapLook(Map<String, String> mapLook)
	{
		this.mapLook = mapLook;
	}
	public Map<String, String> getMapExe()
	{
		return mapExe;
	}
	public void setMapExe(Map<String, String> mapExe)
	{
		this.mapExe = mapExe;
	}
	public String[] getIsLook()
	{
		return isLook;
	}
	public void setIsLook(String[] isLook)
	{
		this.isLook = isLook;
	}
	public String[] getIsExe()
	{
		return isExe;
	}
	public void setIsExe(String[] isExe)
	{
		this.isExe = isExe;
	}
	public long getCode()
	{
		return code;
	}

	public void setCode(long code)
	{
		this.code = code;
	}
	
	
	
	
}
