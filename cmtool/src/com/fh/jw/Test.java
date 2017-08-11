package com.fh.jw;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
	private ArrayList<String> ls=new ArrayList<String>();
	public static void main(String[] args) {
		
	}
	
	private ArrayList<String> getFilePath(String filepath)
	{
//		调用运行cmd命令
		String str=RuncmdCommand.runCMD("svn ls "+filepath);
//		若不是一个文件，递归查找
		if((!(str.indexOf(".tar.gz")>=0))&&(!(str.indexOf(".php")>=0)))
		{
			String[] ss=str.split("\n");
			for(int i=0;i<ss.length;i++)
			{
				getFilePath(filepath+ss[i].toString());
			}
		}
		else
			ls.add(filepath);
		return ls;
	}
	
//	测试更新xgd_release表中trunkpath字段
	private void testupdateTrunkpath()
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list=DataConnect.getListFromRsfor_xgd_release();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<list.size();i++)
		{
			String str = RuncmdCommand.runCMD("svn ls " + (list.get(i)).get("codepath").toString().replaceAll("branches","trunk/src"));
			if(str.indexOf("svn: warning: W160013:")>=0)
			{
				System.out.println(str);
			}
			else
			{
				XgdReleaseBean xgd=new XgdReleaseBean();
				xgd.setSysid(list.get(i).get("sysid").toString());
				xgd.setTrunkpath((list.get(i)).get("codepath").toString().replaceAll("branches","trunk/src"));
				DataConnect.updateTrunkpath(xgd);
			}
		}
	}
	
	private double getMin(double i,double j,double k)
	{
		double a=52300;
		double b=38;
		double c=0.72;
		return Math.sqrt(Math.pow((i-a),2)+Math.pow((j-b),2)+Math.pow((k-c),2));
	}
}
