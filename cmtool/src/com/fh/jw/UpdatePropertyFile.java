package com.fh.jw;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Java读写修改Property文件
 * @author fanhua
 * @date 2015-8-26上午09:19:03
 * @version 1.0
 */
public class UpdatePropertyFile {

	/**
	 * 根据KEY，读取文件对应的值
	 * @param filePath文件路径，即文件所在包的路径，例如：java/util/config.properties
	 * @param key键
	 * @return key对应的值
	 */
	public static String readData(String filePath, String key) {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			in.close();
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 读取Properties的全部信息
	 */
	public static void GetAllProperties(String filePath) {
		Properties pps = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			pps.load(in);
			Enumeration<?> en = pps.propertyNames(); // 得到配置文件的名字
			while (en.hasMoreElements()) {
				String strKey = (String) en.nextElement();
				String strValue = pps.getProperty(strKey);
				System.out.println(strKey + "=" + strValue);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取Properties的全部信息并且根据key值进行判断，如果对应的key是相等，替换掉
	 * @param filePath文件路径，即文件所在包的路径，例如：java/util/config.properties
	 * @param key键
	 * @return key对应的值
	 */
	public static void GetAllProperties(String filePath,String key,String values) {
		Properties pps = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			pps.load(in);
			Enumeration<?> en = pps.propertyNames(); // 得到配置文件的名字
			while (en.hasMoreElements()) {
				String strKey = (String) en.nextElement();
				String strValue = pps.getProperty(strKey);
//				判断如果在对应的配置文件中找到对应的key，将其数值设置为当前的数值
				if(strKey.toString().equals(key.toString()))
				{
					System.out.println("原始key:"+strKey+"    原始values:"+strValue);
					writeData(filePath,key,values);					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 修改或添加键值对 如果key存在，修改, 反之，添加。
	 * @param filePath 文件路径，即文件所在包的路径，例如：java/util/config.properties
	 * @param key 键
	 * @param value 键对应的值
	 */
	public static void writeData(String filePath, String key, String value) {
		Properties prop = new Properties();
		try {
			File file = new File(filePath);
			if (!file.exists())
				file.createNewFile();
			InputStream fis = new FileInputStream(file);
			prop.load(fis);
			// 一定要在修改值之前关闭fis
			fis.close();
			OutputStream fos = new FileOutputStream(filePath);
			prop.setProperty(key, value);
			// 保存，并加入注释
			prop.store(fos, "Update '" + key + "' value");
			System.out.println("更新values："+value);
			
			fos.close();
		} catch (IOException e) {
			System.err.println("Visit " + filePath + " for updating " + value
					+ " value error");
		}
	}
	
	public static void main(String[] args) {
		// System.out.println(Test0826.readData("D:\\xgd_rel\\acc\\acc_job_provider\\1.2.7\\apps\\pjjialian-pmacc-ptjob-ps\\resources\\config.properties","settle.type.day"));
		// Test0826.writeData("D:\\xgd_rel\\acc\\acc_job_provider\\1.2.7\\apps\\pjjialian-pmacc-ptjob-ps\\resources\\config.properties","settle.type.day", "1");
		// Test0826.GetAllProperties("D:\\xgd_rel\\acc\\acc_job_provider\\1.2.7\\apps\\pjjialian-pmacc-ptjob-ps\\resources\\config.properties");
		FindPropertyFile lf = new FindPropertyFile();
		List<Object> ls = lf.listPropertiesFile("D:\\xgd_rel\\acc\\acc_job_provider\\1.2.7\\apps\\pjjialian-pmacc-ptjob-ps\\resources");
		for (int i = 0; i < ls.size(); i++) {
//			System.out.println("配置文件：" + ls.get(i).toString());
			UpdatePropertyFile.GetAllProperties(ls.get(i).toString(),"settle.type.day", "9999");
		}
	}
}
