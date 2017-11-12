package co.com.kallsonys.util;

import java.util.List;

public class ArrayUtil {

	
	public static String converListToString(List<Integer> lstInteger){
		
		String strLst="";
		
		if(lstInteger != null && !lstInteger.isEmpty()){
			
			for(Integer integ : lstInteger){
				strLst = strLst + String.valueOf(integ) + ",";
			}
			
			strLst = strLst.substring(0, strLst.length() - 1);
		}
		
		return strLst;
	}
}
