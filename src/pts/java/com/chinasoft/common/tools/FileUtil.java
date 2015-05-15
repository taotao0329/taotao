package com.chinasoft.common.tools;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class FileUtil
{
	
	/**
	 * 读取字节输入流
	 * @param is
	 * @param newLineChar
	 * @return
	 */
	public static String getContext(InputStream is,String newLineChar)
	{
		BufferedInputStream bis = null;
		StringBuffer resu = new StringBuffer();
		byte [] b = new byte[1024];
		int read = 0;
		try
		{
			bis = new BufferedInputStream(is);
			while((read=bis.read(b))!=-1)
			{
				resu.append(new String(b,0,read)+newLineChar);
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally
		{
			if(bis!=null)
			{
				try
				{
					bis.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return resu.toString();
	}//getContext
	/**
	 * 读取字符输入流
	 * @param reader
	 * @param newLineChar
	 * @return
	 */
	public static String getContext(Reader reader,String newLineChar)
	{
		BufferedReader br = null;
		StringBuffer resu = new StringBuffer();
		String line= "";
		try
		{
			br = new BufferedReader(reader);
			while((line=br.readLine())!=null)
			{
				resu.append(line+newLineChar);
			}
		}catch(IOException e)
		{
			throw new IOperationException(e.getMessage(),e);
		}finally
		{
			if(br!=null)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return resu.toString();
	}//getContext
	/**
	 * 读取文本文件内容
	 * @param filePath 带有完整绝对路径的文件名
	 * @param encoding 文本文件打开的编码方式
	 * @return 返回文本文件的内容
	 */
	public static String getContext(String filePath, String encoding)
	{
		BufferedReader br = null;
		String line="";
		StringBuffer resu = new StringBuffer();
		if(null == encoding || encoding.equals(""))
		{
			encoding="UTF-8";
		}
		try
		{
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),encoding));
			while((line=br.readLine())!=null)
			{
				resu.append(line+"\r\n");
			}
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally
		{
			if(br!=null)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return resu.toString();
	}//readTxt
	
	/**
	 * 写入文件 按照字符
	 * @param filePath
	 * @param text
	 * @param isAppend
	 */
	public static void writerContext(String filePath,String text,String encoding,boolean isAppend)
	{
		BufferedWriter bw = null;
		try
		{
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath,isAppend),encoding));
			bw.write(text);
			bw.flush();
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally
		{
			if(bw!=null)
			{
				try
				{
					bw.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}//writerTxt
	
	/**
	 * 复制文件
	 * @param oldPath
	 * @param newPath
	 */
	public static void copyFile(String oldPath,String newPath)
	{
		InputStream is = null;
		OutputStream os  = null;
		byte [] b = new byte[1024*10];
		int read=0;
		try
		{
			is = new FileInputStream(oldPath);
			os = new FileOutputStream(newPath);
			while((read=is.read(b))!=-1)
			{
				os.write(b, 0, read);
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}finally
		{
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
	}//copyFile
	
	/**
	 * 删除文件
	 * @param filePath
	 * @return
	 */
	public static boolean delFile(String filePath) 
	{
		boolean sign = false;
		String localPath = filePath;
		File localFile = new File(localPath);
		if(null!=localFile && localFile.exists())
		{
			localFile.delete();
			sign = true;
		}
		return sign;
	}//delFile



	public static void main(String [] args) throws IOException
	{
//		writerTxt("D:/admin.txt","winit",false);
	}
	

}
