package com.chinasoft.common.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理类
 * 
 * @author Administrator
 */
public class StringUtil
{
	private static final String	BASE_STR	= "0123456789qazwsxedcrfvtgbyhnujmikolpPLOKMIJNUHBYGVTFCRDXESZWAQ_";


	/**
	 * 某个字符的个数
	 * 
	 * @param base
	 * @param search
	 * @return
	 */
	public static int count(String base, String search)
	{
		int count = 0;
		int pos = 0;
		while (base.indexOf(search, pos) >= 0)
		{
			pos = base.indexOf(search, pos) + 1;
			count++;
		}
		return count;
	}// count

	/**
	 * 替换字符串
	 * 
	 * @param original
	 * @param regex
	 * @param replace
	 * @return
	 */
	public static StringBuffer replaceRegex(StringBuffer base, String regex, String replace)
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(base);
		StringBuffer result = new StringBuffer();
		boolean sign = matcher.find();
		while (sign)
		{
			matcher.appendReplacement(result, replace);
			sign = matcher.find();
		}
		matcher.appendTail(result);
		return result;
	}// replaceRegex

	/**
	 * 随机数
	 * 
	 * @param count
	 * @return
	 */
	public static String getRandom(int count)
	{
		StringBuffer resu = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < count; i++)
		{
			int index = random.nextInt(BASE_STR.length());
			resu.append(BASE_STR.charAt(index));
		}
		return resu.toString();
	}// getRandom
	
	/**
	 * 根据指定长度 分隔字符串
	 *
	 * @param str
	 *            需要处理的字符串
	 * @param length
	 *            分隔长度
	 *
	 * @return 字符串集合
	 */
	public static List<String> splitString(String str, int length) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < str.length(); i += length) {
			int endIndex = i + length;
			if (endIndex <= str.length()) {
				list.add(str.substring(i, i + length));
			} else {
				list.add(str.substring(i, str.length() - 1));
			}
		}
		return list;
	}//splitString
	
	/**
	 * 将字符串List转化为字符串，以分隔符间隔.
	 *
	 * @param list
	 *            需要处理的List.
	 *
	 * @param separator
	 *            分隔符.
	 *
	 * @return 转化后的字符串
	 */
	public static String toString(List<String> list, String separator) {
		StringBuffer stringBuffer = new StringBuffer();
		for (String str : list) {
			stringBuffer.append(separator + str);
		}
		stringBuffer.deleteCharAt(0);
		return stringBuffer.toString();
	}//toString
}
