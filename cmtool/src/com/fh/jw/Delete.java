package com.fh.jw;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.fh.jw.RuncmdCommand;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class Delete {

	private final String VERSION_PATTERN = "[1-9][\\.0-9]{0,}/$"; // 匹配数字版本并以/结尾
	private ArrayList<String> ls;
	private ArrayList<String> delVersionsPaths;

	public Delete() {
		ls = new ArrayList<String>();
	}

	/**
	 * 删除版本日期小于选择日期的版本号
	 * 
	 * @param root
	 * @param choice
	 */
	public ArrayList<String> deleteFileOldThan(String root, Date choice) {
		root = root + "/";
		// 满足删除条件的版本放到delVersionsPaths集合中。
		delVersionsPaths = new ArrayList<String>();
		ArrayList<String> allVersionsPaths = listAllVersionPaths(root);
		for (String path : allVersionsPaths) {
			Date date = getLastModifiedDate(path);
			// 如果获得版本最后修改时间小于选择日期时间，调用删除版本执行删除
			if (date != null && date.getTime() < choice.getTime()) {
				delVersionsPaths.add(path.toString());
			}
		}
		return delVersionsPaths;
	}

	/**
	 * 列出所有版本路径
	 * 
	 * @param root
	 * @return ls
	 */
	public ArrayList<String> listAllVersionPaths(String root) {
		// 获取根目录root下的子目录名，赋值给strfiles
		System.out.println("root="+root);
		String subfolder = RuncmdCommand.runCMD("svn ls " + root);
		// 如果svn ls 结果不是tar包或.php 分离出来进行遍历，如果匹配到为版本号则赋值path为版本路径，并加入列表。不然再次调用该函数
		if (!subfolder.contains(".tar.gz") && !subfolder.contains(".php")) {
			for (String path : subfolder.split("\n")) {
				if (path.matches(VERSION_PATTERN)) {
					ls.add(root + path);
				} else if(!path.equals("")){
					listAllVersionPaths(root + path);
				}
			}
		}
		return ls;
	}

	/**
	 * 获取版本路径最后修改时间
	 * 
	 * @param path
	 * @return date
	 */

	public Date getLastModifiedDate(String path) {
		Date date = null;
		String strdate = RuncmdCommand.runCMD("svn info " + path);
		String strtime = strdate.substring(strdate.indexOf("Date:") + 6,
				strdate.indexOf("Date:") + 25);
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			date = dateFormat.parse(strtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 调用svn删除命令进行删除版本
	 * 
	 * @param file
	 * 
	 */
	public void deleteVersionFile(String file) {
		for (String path : file.split("\n")) {
			path = path.substring(0, path.lastIndexOf("/"));
			RuncmdCommand.runCMD("svn del "+path+" -m "+"\"delete version \"");
		}
				
	}

}
