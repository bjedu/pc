package com.bjedu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergerMonth {
	public static void main(String[] args){
	}
	public static boolean checkMonth(String startStr,String endStr){
		return checkMonth(strToInt(startStr.split(",")),strToInt(endStr.split(",")));
	}
	
	public static List<int[]> listMonth(List list,String startStr,String endStr){
//		return checkMonth(strToInt(startStr.split(",")),strToInt(endStr.split(",")));
		int start[] = strToInt(startStr.split(","));
		int end[] = strToInt(endStr.split(","));
		for(int i=0;i<start.length;i++){
			int [] o= {start[i],end[i]};
			list.add(o);
		}
		return list;
	}
	
	
	public static boolean checkMonth(int[] startMonth,int[] endMonth){
		if(startMonth.length != endMonth.length){
			return false;
		}

		for(int i=0;i<startMonth.length;i++){
			if(startMonth[i] > endMonth[i]){
				return false;
			}
			if(startMonth[i] ==0&& endMonth[i]==0)
				continue;
			if((startMonth[i] ==0&& endMonth[i]!=0)||(startMonth[i] !=0&& endMonth[i]==0)){
				return false;
			}
			for(int j= i+1;j<startMonth.length;j++){
				if(!checkMonth(startMonth[i],endMonth[i],startMonth[j],endMonth[j]))
					return false;
			}
		}
		return true;
	}
	
	public static boolean checkMonth(int start1,int end1,int start2,int end2){
		if(start1 <= start2 && start2 <= end1){
			return false;
		}else if(start1 <= end2 && end2 <= end1){
			return false;
		}else if(start2 <= start1 && end1 <= end2){
			return false;
		}
		return true;
	}
	
	public static int[] strToInt(String[] str){
		int[] intTemp = new int[str.length];
		for(int i=0;i< str.length;i++){
			intTemp[i] = Integer.parseInt(str[i].trim());
		}
		return intTemp;
	}
	public static String mergerMonth(List<int[]> list){
		if(list.size() == 0){
			return "";
		}
		int[] allInt = new int[100];
		int count = 0;
		for(int i=0;i < list.size();i++){
			int tempInt[] = list.get(i);
			if(tempInt.length > 0 && tempInt[0] != 0 && tempInt[1]!=0){
				for(int j=tempInt[0];j<=tempInt[1];j++){
					allInt[count] = j;
					count++;
				}
			}
			
		}
		if(count == 0){
			return "";
		}
		int[] newInt = new  int[count];
		for(int i=0;i<count;i++){
			newInt[i] = allInt[i];
		}
//		if(newInt.length == 1)
//			newInt[newInt.length] = newInt[0];
		Arrays.sort(newInt);
		StringBuffer sub = new StringBuffer();
		sub.append(newInt[0]);
		int temp = newInt[0];
		for(int i=1; i < count ;i++){
			if(newInt[i]-newInt[i-1]>1){
				sub.append(",");
				sub.append(newInt[i-1]);
				sub.append(",");
				sub.append(newInt[i]);
			}
		}
		if(temp < newInt[newInt.length -1]){
			sub.append(",");
			sub.append(newInt[newInt.length -1]);
		}
		String retStr = sub.toString();
		if(StringHelper.isNotEmpty(retStr) && retStr.indexOf(",") == -1){
			retStr += ","+retStr;
		}
		return retStr;
	}

}
