package com.fh.jw;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.SQLException;


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
public class RelAddNewSysDialog extends javax.swing.JDialog {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabel1;
	//private ArrayList fList=null;
	private JLabel jLabel5;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JButton jButton2;
	private JButton jButton1;
	private JTextField releasepath;
	private JTextField testpath;
	private JTextField buildpath;
	private JTextField codepath;
	private JTextField tagpath;
	private JTextField trunkpath;
	private JTextField sysidjTextField;
	private JLabel jLabel7;
	private JLabel jLabel6;
	private JLabel jLabel8;
	private JLabel jLabel9;

	
	/**
	 * Auto-generated main method to display this JDialog
	 */
	public static void main(String[] args) {
//		MainFrame frame = new MainFrame();
//		FindBaselineDialog inst = new FindBaselineDialog(frame);
//		inst.setVisible(true);
	}


	public RelAddNewSysDialog(RelManageJPanel fr) {
		super(VsMainFrame.mf);		
		initGUI();
		this.setLocationRelativeTo(this);
	}
		

	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
			}

			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("请输入子系统名：");
				jLabel1.setBounds(20, 16, 102, 25);
			}

			{
				jLabel9 = new JLabel();
				getContentPane().add(jLabel9);
				jLabel9.setText("发布包路径：");
				jLabel9.setBounds(20, 179, 81, 19);
			}
			{
				jLabel8 = new JLabel();
				getContentPane().add(jLabel8);
				jLabel8.setText("测试包路径：");
				jLabel8.setBounds(20, 148, 76, 19);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				jLabel5.setText("发布基线路径：");
				jLabel5.setBounds(20, 116, 90, 19);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("测试基线路径：");
				jLabel6.setBounds(20, 85, 91, 19);
			}
			{
				jLabel7 = new JLabel();
				getContentPane().add(jLabel7);
				jLabel7.setText("源代码分支路径：");
				jLabel7.setBounds(20, 54, 96, 19);
			}
			
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("发布主干路径：");
				jLabel3.setBounds(20, 210, 90, 19);
			}
			{
				sysidjTextField = new JTextField();
				getContentPane().add(sysidjTextField);
				sysidjTextField.setText("");
				sysidjTextField.setBounds(126, 18, 349, 21);
			}
			{
				tagpath = new JTextField();
				getContentPane().add(tagpath);
				tagpath.setText("");
				tagpath.setBounds(126, 115, 349, 21);
			}
			{
				codepath = new JTextField();
				getContentPane().add(codepath);
				codepath.setText("");
				codepath.setBounds(126, 53, 349, 21);
			}
			{
				buildpath = new JTextField();
				getContentPane().add(buildpath);
				buildpath.setText("");
				buildpath.setBounds(126, 84, 349, 21);
			}
			{
				testpath = new JTextField();
				getContentPane().add(testpath);
				testpath.setText("");
				testpath.setBounds(126, 147, 349, 21);
			}
			{
				releasepath = new JTextField();
				getContentPane().add(releasepath);
				releasepath.setText("");
				releasepath.setBounds(126, 178, 349, 21);
			}
			
			{
				trunkpath = new JTextField();
				getContentPane().add(trunkpath);
				trunkpath.setText("");
				trunkpath.setBounds(126, 209, 349, 21);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("确定添加");
				jButton1.setBounds(394, 265, 81, 23);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
//						System.out.println("jButton1.actionPerformed, event="+evt);
						//TODO add your code for jButton1.actionPerformed
						addsystoxgd_release();
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("重置");
				jButton2.setBounds(295, 265, 61, 22);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						sysidjTextField.setText("");
						tagpath.setText("");
						codepath.setText("");
						buildpath.setText("");
						testpath.setText("");
						releasepath.setText("");
						trunkpath.setText("");
						
					}
				});
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("");
				jLabel2.setBounds(25, 244, 450, 15);
			}
			
			this.setSize(547, 335);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 添加数据到xgd_release表里面
	 * @throws SQLException
	 */
	protected void addsystoxgd_release() {
		// TODO Auto-generated method stub
		XgdReleaseBean xd=new XgdReleaseBean();
		String sysid=sysidjTextField.getText().toString();
		String code=codepath.getText().toString();
		String build=buildpath.getText().toString();
		String tag=tagpath.getText().toString();
		String test=testpath.getText().toString();
		String rel=releasepath.getText().toString();
		String trunk=trunkpath.getText().toString();
		if(sysid.equals(""))
		{
			jLabel1.setForeground(Color.red);
		}
		else
		{
			jLabel1.setForeground(Color.black);
		}
		if(code.equals(""))
		{
			jLabel7.setForeground(Color.red);
		}
		else
		{
			jLabel7.setForeground(Color.black);
		}
		if(build.equals(""))
		{
			jLabel6.setForeground(Color.red);
		}
		else
		{
			jLabel6.setForeground(Color.black);
		}
		if(tag.equals(""))
		{
			jLabel5.setForeground(Color.red);
		}
		else
		{
			jLabel5.setForeground(Color.black);
		}
		if(test.equals(""))
		{
			jLabel8.setForeground(Color.red);
		}
		else
		{
			jLabel8.setForeground(Color.black);
		}
		if(rel.equals(""))
		{
			jLabel9.setForeground(Color.red);
		}
		else
		{
			jLabel9.setForeground(Color.black);
		}
		if(trunk.equals(""))
		{
			jLabel3.setForeground(Color.red);
		}
		else
		{
			jLabel3.setForeground(Color.black);
		}
		if(!(sysid.equals("")||code.equals("")||build.equals("")||tag.equals("")||test.equals("")||rel.equals("")||trunk.equals("")))
		{
			xd.setSysid(sysidjTextField.getText().toString());
			xd.setCodepath(codepath.getText().toString());
			xd.setBuildpath(buildpath.getText().toString());
			xd.setTagpath(tagpath.getText().toString());
			xd.setTestpath(testpath.getText().toString());
			xd.setReleasepath(releasepath.getText().toString());
			xd.setTrunkpath(trunkpath.getText().toString());
			int row=DataConnect.addRsforxgdrelease(xd);
			if(row!=0)
			{
				jLabel2.setText("添加新的子系统成功");
			}
		}else
		{
			jLabel2.setText("添加新的子系统失败,请检查录入信息是否缺失!");
		}
	}

//	private void showDialog(String msg,String title,int type)
//	{
//		JOptionPane.showMessageDialog(VsMainFrame.mf,msg,title, type);
//	}	
}
