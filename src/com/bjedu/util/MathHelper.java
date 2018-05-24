package com.bjedu.util;

import java.math.BigDecimal;

public class MathHelper {
	/**
	 * 四舍五入
	 * 
	 * @param v 原数字
	 * @param scale 保留小数位数
	 * @return  四舍五入后的数字
	 */
	public static double round(double v,int scale){
		BigDecimal b = new BigDecimal(v);
		BigDecimal one = new BigDecimal(1);
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	
	/**
	 * nulltozero
	 * 
	 * @param num 原数字
	 * @return  返回数字
	 */
	public static double repNull(Double num){
		if(num == null){
			return 0d;
		}
		return num;
	}
	
	/**
	 * nulltozero
	 * 
	 * @param num 原数字
	 * @return  返回数字
	 */
	public static boolean equalInt(String numOne,String numTwo){
		if(StringHelper.isEmpty(numOne) || StringHelper.isEmpty(numTwo)){
			return false;
		}
		try {
			int num1 = Integer.parseInt(numOne);
			int num2 = Integer.parseInt(numTwo);
			if(num1 == num2){
				return true;
			}
			return false;
		}catch(Exception e){
			return false;
		}
	
	}
}
