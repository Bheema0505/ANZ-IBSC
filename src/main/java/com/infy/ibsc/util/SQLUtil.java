package com.infy.ibsc.util;

public class SQLUtil {

	public static String getFilterCriteria(String criteria, String columnName, long value) {
		String sql = "";
		//System.out.println("Criteria=>"+criteria+"<");
	
		if(value > 0){
			if(!StrUtil.isNullOrBlank(criteria)) {
				sql = " AND ";
			}
			sql += " "+ columnName +"="+value+" ";
		}
		return sql;
	}
	

	public static String getFilterCriteria(String criteria, String columnName, String value) {
		String sql = "";
		//System.out.println("Criteria=>"+criteria+"<");
	
		if(!StrUtil.isNullOrBlank(value)){
			if(!StrUtil.isNullOrBlank(criteria)) {
				sql = " AND ";
			}
			if(value.contains("%")) {
				sql += " "+ columnName +" LIKE '"+value+"' ";
			}else {
			sql += " "+ columnName +"='"+value+"' ";
			}
		}
		return sql;
	}

	public static String getUpdateCriteria(String criteria, String columnName, String value) {
		String sql = "";
		//System.out.println("Criteria=>"+criteria+"<");
	
		if(!StrUtil.isNullOrBlank(value)){
			if(!StrUtil.isNullOrBlank(criteria)) {
				sql = ",";
			}
			
			sql += " "+ columnName +"='"+value+"' ";
			
		}
		return sql;
	}

	public static String getUpdateCriteria(String criteria, String columnName, int value) {
		String sql = "";
		//System.out.println("Criteria=>"+criteria+"<");
	
		if(value > 0){
			if(!StrUtil.isNullOrBlank(criteria)) {
				sql = ",";
			}
			
			sql += " "+ columnName +"="+value+" ";
			
		}
		return sql;
	}

	public static String getNullableField(String value) {
		if(value != null) {
			return "'"+value+"'";
		}
		else
			return null;
	}


		public static String getUpdateCriteria(String criteria, String columnName, long value) {
		String sql = "";
		//System.out.println("Criteria=>"+criteria+"<");
	
		if(value > 0){
			if(!StrUtil.isNullOrBlank(criteria)) {
				sql = ",";
			}
			
			sql += " "+ columnName +"="+value+" ";
			
		}
		return sql;
	}
	
}
