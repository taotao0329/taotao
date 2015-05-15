package com.chinasoft.common.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOUtil
{
	
	/**
	 * 获取输入流字节数组
	 * @param inStream
	 * @return
	 */
	public static byte[] getByteArray(InputStream inStream) 
	{
		
		InputStream is = null;
		ByteArrayOutputStream os= null;
		BufferedOutputStream bos = null;
		try
		{
			is  = new BufferedInputStream(inStream);
			os = new ByteArrayOutputStream();
			bos = new BufferedOutputStream(os);
			byte buffer[] = new byte[1024];
			int read = 0;
			while((read = is.read(buffer)) != -1)
			{
				bos.write(buffer, 0, read);
			}
			
			bos.flush();
			byte retData[] = os.toByteArray();
			return retData;
		}
		catch(IOException ex)
		{
			throw new IOperationException("Could not get data from InputStream", ex);
		}finally
		{
			if(bos!=null)
			{
				try
				{
					bos.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			if(is!=null)
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			if(os!=null)
			{
				try
				{
					os.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
