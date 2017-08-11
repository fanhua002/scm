package com.fh.jw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuncmdCommand {
	public static String runCMD(String cmd) {
		// ----------------------用于累加字符串
		String strAppend = "";
//		执行命令
		Process proc = null;
		//缓存字符串
		BufferedReader br = null;
//		缓存错误字符串
		BufferedReader errReader = null;
		try {
			proc = Runtime.getRuntime().exec(cmd);
			String line = "";
			br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			while ((line = br.readLine()) != null) {
				strAppend = strAppend + line + "\n"; // .out.print(line);
			}
			errReader = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			String errLine = "";
			while ((errLine = errReader.readLine()) != null) {
				if (errLine.indexOf("svn: E200009: Could not list all targets because some targets don't exist") >= 0) {
					strAppend = strAppend+ "※××××※  ERROR:svn路径错误，请检查！\n";
				} else {
					strAppend = strAppend + errLine + "\n";
				}
				System.out.println(errLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.print("RunCM运行出错");
			e.printStackTrace();
		} finally {
			proc.destroy();
			try {
				br.close();
				errReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return strAppend;
	}
	

}
