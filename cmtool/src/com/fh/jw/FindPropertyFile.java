package com.fh.jw;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Java列出编译包中的Property文件
 * @author fanhua
 * @date 2015-8-26上午09:19:03
 * @version 1.0
 */
public class FindPropertyFile {
	private List<Object> ls=new ArrayList<Object>() ;
//	传入参数，解压包的路径
	public List<Object> listPropertiesFile(String fileName) {
		File file = new File(fileName);
//		判断如果是一个路径，对该路径进行循环
		if (file.isDirectory()) {
//			System.out.println("当前的path:"+file+",包含的属性文件如下：");
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
//				判断如果是以.properties文件结尾的，打印该文件名
				String name = files[i].getName();
				if (name.trim().toLowerCase().endsWith(".properties")) {
					ls.add(file+"\\"+name.toString());
				}
//				判断如果是一个目录，进行递归查找
				if (files[i].isDirectory()) {
					String path = files[i].getPath();
					listPropertiesFile(path);
				}
			}
		}
		return ls;
	}
	public static void main(String[] args)
	{
		FindPropertyFile lf=new FindPropertyFile();
		List<?> ls1=lf.listPropertiesFile("D:\\xgd_rel\\acc\\acc_job_provider\\1.2.7\\apps\\pjjialian-pmacc-ptjob-ps\\resources");
		for(int i=0;i<ls1.size();i++)
		{
			System.out.println(ls1.get(i).toString());
		}
	}
}
