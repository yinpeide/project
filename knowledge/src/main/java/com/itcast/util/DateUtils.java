package com.itcast.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	public static final String YYYY_MM_DD ="yyyy-MM-dd";
	
	/**
	 * 日期 格式化字符串
	 * @param date
	 * @param format
	 * @return
	 */ 
    public static String format(Date date, String format) {
        if (date == null)
            return "";
        return new java.text.SimpleDateFormat(format).format(date);
    }
    /**
     * 
     * @param date
     *            带豪秒级的日期
     * @param format
     *            格式化字符串
     * @return
     */
    public static String format(Timestamp date, String format) {
        if (date == null)
            return "";
        return new java.text.SimpleDateFormat(format).format(date);
    }

    /**
     * 
     * @param 字符串格式的date转换为 sql格式的
     *            日期字符串
     * @return
     */
    public static Date format(String date) {
        return java.sql.Date.valueOf(date);
    }

    /**
     * 将java.util.Date转化为java.sql.Date
     * 
     * @param date
     *            java.util.Date的时间
     * @return
     */
    public static java.sql.Date converlUtilDate(Date date) {
        java.sql.Date sqlDate = null;
        sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    /**
     * 将java.sql.Date转化为java.util.Date
     * 
     * @param date
     *            java.sql.Date的时间
     * @return
     */
    public static Date convertSqlDate(java.sql.Date date) {
        Date utilDate = null;
        utilDate = new Date(date.getTime());
        return utilDate;
    } 
    
	/**
	 * 日期类型转化为字符串类型
	 * @param date
	 * @param str str为要转换的日期类型格式
	 * @return
	 */
	public static String dateToStr(Date date,String str){
		String s = format(date,str);
	    return s;	
	}
	
	/**
	 * 日期类型转换为默认的字符串类型
	 * @param date
	 * @return
	 */
	public static String dateToStrDefault(Date date){
        String dateStr = "";
        if (date != null) {
            dateStr = format(date,YYYY_MM_DD);
        }
        return dateStr;
	}
	
	/**
	 * 字符串类型转换为date类型
	 * @param str
	 * @param sdf
	 * @return
	 */
	public static Date strToDate(String str,SimpleDateFormat sdf){
		Date date = null;
			try {
				if(null != sdf){
					date = sdf.parse(str);
				}else{
					date = new SimpleDateFormat(YYYY_MM_DD).parse(str);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return date;
	}
	
//	public static void main(String[] args){
//		Date date = DateUtils.strToDate("2014-12-12", null);
//		String str = DateUtils.dateToStr(date, "yyyyMMddHHmmssSSS");
//		System.out.println(date);
//		System.out.println(str);
//	}

}
