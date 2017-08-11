package com.fh.test;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import com.fh.jw.RuncmdCommand;

public class Test20150519 {
	public static void main(String[] args)
	{
		Test20150519 test=new Test20150519();
		System.out.println(args[0]+"/"+test.getReceiverV(args[0]));
	}
	
	
	/**
	 * 通过svn list 获取最新的版本
	 * @param srcpath
	 * @return receiver
	 */
	public void getReceiver(String srcpath) {
		String subfolder = RuncmdCommand.runCMD("svn ls " + srcpath);
//		System.out.println(subfolder);
		String[] aa =subfolder.split("\n");
		for(int i=0;i<aa.length;i++)
		{
			if(!aa.equals(""))
			{
				System.out.println(srcpath+aa[i].toString()+getReceiverV(srcpath+"/"+aa[i].toString()));
			}
		}
	}
	
	/**
	 * 通过svn list -v 获取最新的版本路径
	 * @param srcpath
	 * @return receiver
	 */
	public String getReceiverV(String srcpath) {
		String vnum="";//返回版本号
		String subfolder = RuncmdCommand.runCMD("svn list -v " + srcpath);
		String[] bb =subfolder.split("\n");
		String a=bb[0].toString().replaceAll(" ","");
		String anum="";
		anum = getNum(a, anum);
		System.out.println("anum="+anum);
		for(int i=1;i<bb.length;i++)
		{
			String b=bb[i].toString().replaceAll(" ","");
			String bnum="";
			bnum = getNum(b, bnum);
			System.out.println("bnum="+bnum);
			if(bnum.equals(anum))
			{
				String bstr=bb[i].toString();
				vnum=bstr.substring(bstr.lastIndexOf(" ")+1,bstr.length());
			}
		}
		return vnum;
	}

	/**
		C:\Users\fanhua>svn ls -v svn://172.17.3.161/xgd_rel/tags/RELEASE/tradengine/tra
		dengine_card
		    184 yushisha              二月 26 10:35 ./
		      3 fanhua                二月 14 17:59 3.14.3/
		      2 fanhua                二月 14 17:48 3.15.0/
		    184 yushisha              二月 26 10:35 3.15.2/
	    从上述svn ls -v命令中获取第一行获取到184版本，将下面184版本对应的版本号3.15.2返回出来。
	 * @param b
	 * @param bnum
	 * @return
	 */

	private String getNum(String b, String bnum) {
		if(b.indexOf("yushisha")>=0)
		{
			bnum=b.substring(0,b.indexOf("yushisha"));
		}else if(b.indexOf("fanhua")>=0)
		{
			bnum=b.substring(0,b.indexOf("fanhua"));
		}else if(b.indexOf("luoxiaol")>=0)
		{
			bnum=b.substring(0,b.indexOf("luoxiaol"));
		}
		return bnum;
	}
}
