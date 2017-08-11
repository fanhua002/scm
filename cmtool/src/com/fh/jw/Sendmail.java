package com.fh.jw;

/******************************/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/********************************/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;

import com.apache.mail.*;

public class Sendmail {

	private String username;
	private String password;
	private String strpath;

	// String src = "svn://172.17.3.161/XGD-CXYW/scm/branches";
	static ArrayList<String> namelist = GetAuthor.receiver;

	// public static void main(String[] args) throws EmailException {

	// Sendmail emailname = new Sendmail();
	// emailname.GetEmailName(sendmial);

	// }

	public ArrayList<String> SendmergeMail(String srcjTextField,
			String relbranch, String otherbranches, String trkjTextField,
			String jComboBox1) throws EmailException {

		// 从srcjTextField中截取到"branches"字符的路径
		String str = srcjTextField;
		strpath = str.substring(0, str.indexOf("branches")) + "branches";

		// 调动getauthor方法，获取上线分支的开发人员名单
		GetAuthor name = new GetAuthor();
		namelist = name.GetReceiver(strpath);

		// 调用HashSet函数删除重复的名字
		HashSet<String> hSet = new HashSet<String>(namelist);
		namelist.clear();
		namelist.addAll(hSet);

		String user = getPass("UserName", username);
		String pass = getPass("PassWord", password);

		java.util.Date utilDate = new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ImageHtmlEmail email = new ImageHtmlEmail();
		// smtp host
		email.setHostName("mail.xinguodu.com");
		// 登陆邮件服务器的用户名和密码
		email.setAuthentication(user, pass);

		for (String s : namelist) {

			email.addTo(s + "@xinguodu.com");
			// email.addTo("yushishan" + "@xinguodu.com");
		}
		// email.addTo("yushishan" + "@xinguodu.com");
		// 抄送人员
		email.addCc("cx-cszx@xgd.com");
		email.addCc("fanhua@xinguodu.com");
		email.addCc("yushishan@xinguodu.com");
		email.addCc("luoxiaoli@xinguodu.com");

		email.setFrom(user + "@xinguodu.com", "Me");

		// email.setSubject("测试邮件发送功能");
		email.setSubject("请开发同事从发布主干合并代码到其他开发分支");
		email.setCharset("UTF-8");
		// 邮件内容
		String relativelyPath = System.getProperty("user.dir");
		email.setMsg("各位好：" + "\r\n" + " " + jComboBox1 + "子系统的\n  "
				+ srcjTextField + "/" + relbranch + "\r\n\n" + "  " + "分支"
				+ formatter.format(utilDate)
				+ "已具备上线条件，且代码已合并到发布主干。请开发同事从发布主干合并代码到其他开发分支，谢谢！" + "\r\n\n\n"
				+ "  " + "上线的分支：" + srcjTextField + "/" + relbranch + "\r\n"
				+ "  " + "已合并到发布主干：" + trkjTextField + "\r\n\n\n" + "   "
				+ "开发同事处理的，正在开发中的分支：" + "\r\n" + otherbranches + "\r\n\n\n\n "
				+ "具体操作示例请参考以下链接：" + "\r\n\n"
				+ "http://172.20.5.148:8080/demo/");

		email.send();
		System.out.println("\n Send email successful!");

		return namelist;
	}

	public void SendmergeMailToScmGroup(String srcjTextField, String relbranch,
			String otherbranches, String trkjTextField, String jComboBox1)
			throws EmailException {

		// 从srcjTextField中截取到"branches"字符的路径
		String str = srcjTextField;
		strpath = str.substring(0, str.indexOf("branches")) + "branches";

		String user = getPass("UserName", username);
		String pass = getPass("PassWord", password);

		java.util.Date utilDate = new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ImageHtmlEmail email = new ImageHtmlEmail();
		// smtp_host and smtp_port
		email.setHostName("mx1.jlpay.com");
		email.setSmtpPort(587);
		email.setFrom(user + "@jlpay.com", user + "@jlpay.com");
		// 登陆邮件服务器的用户名和密码
		email.setAuthentication(user, pass);
		// 发送邮件给指定接收人
		email.addTo("yushishan" + "@jlpay.com");
		email.addTo("chenzaifang" + "@jlpay.com");
		email.addTo("fanhua" + "@jlpay.com");
		email.addTo("luoxiaoli" + "@jlpay.com");
		email.setSubject("发布主干代码同步到其他开发分支【提醒】");
		email.setCharset("UTF-8");
		// 邮件内容
		email.setMsg("各位好：" + "\r\n" + " " + jComboBox1 + "子系统的\n  "
				+ srcjTextField + "/" + relbranch + "\r\n\n" + "  " + "分支"
				+ formatter.format(utilDate)
				+ "已具备上线条件，且代码已合并到发布主干，请将发布主干代码同步到其他开发分支，谢谢！" + "\r\n\n\n"
				+ "  " + "上线的分支：" + srcjTextField + "/" + relbranch + "\r\n"
				+ "  " + "已合并到发布主干：" + trkjTextField + "\r\n\n\n" + "   "
				+ "正在开发中的分支：" + "\r\n" + otherbranches + "\r\n\n\n\n "
				+ "具体操作示例请参考以下链接：" + "\r\n\n"
				+ "http://172.20.5.148:8080/demo/");

		email.send();
		System.out.println("\n Send email successful!");

		// return namelist;
	}

	private String getPass(String str1, String str2) {
		File xfile = new File(".\\data\\config.dat");
		if (xfile.exists()) {
			if (xfile.exists()) {
				FileReader fr = null;
				BufferedReader br = null;
				try {
					fr = new FileReader(xfile);
					br = new BufferedReader(fr);
					String line = "";
					while ((line = br.readLine()) != null) {
						if (str1.equals("UserName")) {
							if (line.startsWith("UserName@")) {
								str2 = (line.substring(line.indexOf("@") + 1));
							}
						} else if (str1.equals("PassWord")) {
							if (line.startsWith("PassWord@")) {
								str2 = (line.substring(line.indexOf("@") + 1));
							}
						}
					}
					br.close();
					fr.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return str2;
	}

}
