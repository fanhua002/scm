package com.fh.jw;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class UserPwdJPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JButton jButton1;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JTextArea jTextArea1;
	private JLabel jLabel3;
	private JTextField jTextzhUser;
	private JTextArea jTextEmailContext;
	private JTextField jTextPwd;
	private JLabel jLabel2;
	private JTextField jTextUser;
	private JLabel jLabel1;
	private JFileChooser jFileChooser1;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new UserPwdJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public UserPwdJPanel() {
		super();
		initGUI();
	}
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(567, 462));
			this.setLayout(null);
			{				
				jPanel1 = new JPanel();
				this.add(jPanel1);
				jPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				jPanel1.setLayout(null);
				jPanel1.setBounds(0, 0, 567, 462);
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("生成密码");
					jButton1.setBounds(446, 23, 88, 24);
					jButton1.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							jTextPwd.setText(getCharAndNumr(6));
							jTextEmailContext.setText(setjTextEmailContext());
							jTextArea1.setText(setjTextContext());
							}
						});
					
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("请输入用户名：");
					jLabel1.setBounds(14, 25, 98, 19);
				}
				{
					jTextUser = new JTextField();
					GridLayout jTextField1Layout = new GridLayout(1, 1);
					jTextField1Layout.setColumns(1);
					jTextField1Layout.setHgap(5);
					jTextField1Layout.setVgap(5);
					jTextUser.setLayout(jTextField1Layout);
					jPanel1.add(jTextUser);
					jTextUser.setText("");
					jTextUser.setBounds(103, 23, 142, 24);
				}
				
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("密码：");
					jLabel2.setBounds(56, 59, 56, 19);
				}
				{
					jFileChooser1 = new JFileChooser();
					jPanel1.add(jFileChooser1); // jFileChooser1.setCurrentDirectory(f);
					jFileChooser1
							.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					jFileChooser1.setBounds(84, -182, 63, 28);
				}
				{
					jTextPwd = new JTextField();
					jPanel1.add(jTextPwd);
					GridLayout jTextField2Layout = new GridLayout(1, 1);
					jTextField2Layout.setHgap(5);
					jTextField2Layout.setVgap(5);
					jTextField2Layout.setColumns(1);
					jTextPwd.setText("");
					jTextPwd.setLayout(jTextField2Layout);
					jTextPwd.setBounds(102, 63, 140, 24);
				}
				{
					jTextEmailContext = new JTextArea();
					jPanel1.add(jTextEmailContext);
					jTextEmailContext.setText("");
					jTextEmailContext.setBounds(63, 120, 423, 158);
				}
				{
					jTextzhUser = new JTextField();
					jPanel1.add(jTextzhUser);
					GridLayout jTextField3Layout = new GridLayout(1, 1);
					jTextField3Layout.setHgap(5);
					jTextField3Layout.setVgap(5);
					jTextField3Layout.setColumns(1);
					jTextzhUser.setText("");
					jTextzhUser.setLayout(jTextField3Layout);
					jTextzhUser.setBounds(322, 23, 106, 24);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jPanel1.add(getJLabel4());
					jPanel1.add(getJLabel5());
					jPanel1.add(getJTextArea1());
					jLabel3.setText("中文名：");
					jLabel3.setBounds(269, 25, 58, 19);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getCharAndNumr(int length)   
	{   
	    String val = "";   
	           
	    Random random = new Random();   
	    for(int i = 0; i < length; i++)   
	    {   
	        String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字   
	               
	        if("char".equalsIgnoreCase(charOrNum))  
	        {   
	            int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; //取得大写字母还是小写字母   
	            val += (char) (choice + random.nextInt(26));   
	        }   
	        else if("num".equalsIgnoreCase(charOrNum)) // 数字   
	        {   
	            val += String.valueOf(random.nextInt(10));   
	        }   
	    }
	    return val;   
	}
	
	private String setjTextEmailContext()   
	{   
	    String val = "";
	    val=val+jTextzhUser.getText()+",已为您分配svn和bugzilla的用户,请妥善保管！\n"
	    		+"svn用户名："+jTextUser.getText()+"\n"
	    		+"密码："+jTextPwd.getText()+"\n\n"
	    		+"bugzilla首页：http://jialiansvn.xgd.com/bugzilla/\n"
	    		+"用户名："+jTextUser.getText()+"@jlpay.com\n"
	    		+"密码："+jTextPwd.getText()+"\n";
	    return val;   
	}
	
	private String setjTextContext()   
	{   
	    String val = "";
	    val=val+"如果是xinguodu.com邮箱后缀，请登录172.20.5.161机器,在/etc/scmbug/daemon.conf文件中\n"
	    +"追加:'"+jTextUser.getText()+"' => '"+jTextUser.getText()+"@xinguodu.com'\n"
	    +"重启服务:/etc/init.d/scmbug-server restart\n";
	    return val;   
	}
	
	private JLabel getJLabel4() {
		if(jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("\u90ae\u4ef6\u5185\u5bb9\uff1a");
			jLabel4.setBounds(14, 96, 70, 19);
		}
		return jLabel4;
	}
	
	private JLabel getJLabel5() {
		if(jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("scmbug\u64cd\u4f5c\uff1a");
			jLabel5.setBounds(14, 295, 88, 19);
		}
		return jLabel5;
	}
	
	private JTextArea getJTextArea1() {
		if(jTextArea1 == null) {
			jTextArea1 = new JTextArea();
			jTextArea1.setText("");
			jTextArea1.setBounds(63, 320, 423, 128);
		}
		return jTextArea1;
	}
}
