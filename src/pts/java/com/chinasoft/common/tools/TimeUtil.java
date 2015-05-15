package com.chinasoft.common.tools;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil implements Serializable
{
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * String -----Date
	 * @param time
	 * @return
	 */
	public static Date formatDate(String time)
	{
		Date date = new Date();
		try
		{
			date = df.parse(time);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			return date;
	}//formatDate
	/**
	 * Date ------ String
	 * @param date
	 * @return
	 */
	public static String formatStr(Date date)
	{
		String str = "";
		try
		{
			str = df.format(date);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return str;
	}//formatStr
	/**
	 * String --------TimeStamp
	 * @param time
	 * @return
	 */
	public static Timestamp formatTimeStamp(String time)
	{
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try
		{
			ts = Timestamp.valueOf(time);
		}
		catch (Exception e)
		{
			throw new IOperationException("ERR.", e);
		}
		return ts;
	}//formatTimeStamp
	/**
	 * 
	 * @param timeStamp
	 * @return
	 */
	public static String formatStr(Timestamp timeStamp)
	{
		String str = "";
		try
		{
			str = df.format(timeStamp);
		}catch(Exception e)
		{
			throw new IOperationException("err.",e);
		}
		return str;
	}//formatStr
	/**
	 * stamp -----Date
	 * @param stamp
	 * @return
	 */
	public static Date formatTimeStamp(Timestamp stamp)
	{
		Date date = stamp;
		return date;
	}//formatTimeStamp
	/**
	 * date ------ Timestamp
	 * @param date
	 * @return
	 */
	public static Timestamp formatDate(Date date)
	{
		Timestamp stamp = new Timestamp(date.getTime());
		return stamp;
	}//formatDate
	
	/**
	 * 
	 * @param befor Date
	 * @param after Date
	 * @return 1 -1 0
	 */
	public static int compareDate(Date befor,Date after)
	{
		//befor > after
		if(befor.getTime()>after.getTime())
		{
			return 1;
		}else if(befor.getTime()<after.getTime())
		{
			// after > befor
			return -1;
		}else
		{
			// befor==after
			return 0;
		}
	}//compareTo
}
