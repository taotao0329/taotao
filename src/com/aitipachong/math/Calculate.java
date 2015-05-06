package com.aitipachong.math;

public class Calculate
{
	/**
	 * 加法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int Addition(int a, int b)
	{
		return a + b;
	}

	/**
	 * 减法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int Subtraction(int a, int b)
	{
		return a - b;
	}
	
	/**
	 * 乘法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int Multiplication(int a, int b)
	{
		return a * b;
	}
	
	/**
	 * 除法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int Division(int a, int b)
	{
		if(Math.abs(b) == 0) return 0;
		return a / b;
	}
}
