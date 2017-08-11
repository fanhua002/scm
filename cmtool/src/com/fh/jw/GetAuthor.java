package com.fh.jw;

import java.util.ArrayList;

public class GetAuthor {

	static ArrayList<String> receiver = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "svn://172.17.3.161/XGD-CXYW/scm/branches";
		GetAuthor Author = new GetAuthor();
		Author.GetReceiver(src);
	}
	

	/**
	 * 通过代码log信息，获取开发人员姓名，并过滤掉重复
	 * 
	 * @param src
	 * @return receiver
	 */
	public ArrayList<String> GetReceiver(String src) {

		System.out.println("源代码分支路径：=" + src);
		String subfolder = RuncmdCommand.runCMD("svn log -l300 -q  " + src);
		subfolder = subfolder.trim();
		if (!subfolder.equals("")) {
			for (String path : subfolder.split("\n")) {
				int start = 0, end = 0;
				start = path.indexOf("|");
				if (start >= 0 && start < path.length() - 1) {
					end = path.indexOf("|", start + 1);
					if (end > start + 1) {
						String name = path.substring(start + 1, end);
						name = name.trim();
						 System.out.println(name);
						receiver.add(name);
					}
				}
			}

		}

		return receiver;
	}
}
