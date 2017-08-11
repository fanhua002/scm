package com.fh.jw;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

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
public class RelManageJPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JButton jButton1;
	// private CopyReleaseVersion fbd1;
	private RelAddNewSysDialog fbd;
	private JComboBox<String> jComboBox1;
	private JTextField rpjTextField;
	private JTextField trkjTextField;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JComboBox<String> jComboBox2;
	private JComboBox<String> jComboBox3;
	private JLabel jLabel2;
	private JButton jButton3;
	private JLabel jLabel9;
	private JLabel jLabel8;
	private JButton jButton2;
	private JButton jButton4;
	private JTextField srcjTextField;
	private JLabel jLabel6;
	private JTextField tbjTextField;
	private JTextField rbjTextField;
	private JTextField tpjTextField;
	private JLabel jLabel1;
	private JLabel jLabel7;
	private JLabel jLabel10;
	private JLabel jLabel3;
	private JFileChooser jFileChooser1;
	protected String Version;
	protected String Version1;
	private String strtime;
	ArrayList<String> branches;
	//
	public String srcpath;
	public String srcpath1;
	private JScrollPane JScrollPane_del;
	private JTextArea  jTextArea_log;
	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new RelManageJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public RelManageJPanel() {
		super();
		initGUI();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initGUI() {
		try {
			setPreferredSize(new Dimension(567, 462));
			this.setLayout(null);
			{
				jPanel1 = new JPanel();
				this.add(jPanel1);
				jPanel1.setBorder(BorderFactory
						.createBevelBorder(BevelBorder.LOWERED));
				jPanel1.setLayout(null);
				jPanel1.setBounds(0, 0, 567, 462);
				{
					ComboBoxModel jComboBox2Model = new DefaultComboBoxModel();
					jComboBox2 = new JComboBox();
					jPanel1.add(jComboBox2);
					jComboBox2.setModel(jComboBox2Model);
					jComboBox2.setBounds(115, 374, 149, 24);
					jComboBox2.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if (evt.getStateChange() == ItemEvent.SELECTED) {
								Version = jComboBox2.getSelectedItem()
										.toString();
							}

						}
					});

					ComboBoxModel jComboBox3Model = new DefaultComboBoxModel();
					jComboBox3 = new JComboBox();
					jPanel1.add(jComboBox3);
					jComboBox3.setModel(jComboBox3Model);
					jComboBox3.setBounds(387, 374, 149, 24);
					jComboBox3.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if (evt.getStateChange() == ItemEvent.SELECTED) {

							}

						}
					});

				}

				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("源代码分支路径：");
					jLabel1.setBounds(14, 48, 126, 19);
				}

				{
					jFileChooser1 = new JFileChooser();
					jPanel1.add(jFileChooser1); // jFileChooser1.setCurrentDirectory(f);
					jFileChooser1
							.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					jFileChooser1.setBounds(84, -182, 63, 28);
				}
				{
					tpjTextField = new JTextField();
					jPanel1.add(tpjTextField);
					tpjTextField.setFont(new java.awt.Font("微软雅黑", 0, 14));
					tpjTextField.setBounds(140, 143, 395, 24);
				}
				{
					rpjTextField = new JTextField();
					jPanel1.add(rpjTextField);
					rpjTextField.setFont(new java.awt.Font("微软雅黑", 0, 14));
					rpjTextField.setBounds(140, 174, 395, 24);
				}

				{
					trkjTextField = new JTextField();
					jPanel1.add(trkjTextField);
					trkjTextField.setFont(new java.awt.Font("微软雅黑", 0, 14));
					trkjTextField.setBounds(140, 208, 395, 24);
				}

				{
					rbjTextField = new JTextField();
					jPanel1.add(rbjTextField);
					// rbjTextField.setText("");
					rbjTextField.setBounds(140, 112, 395, 24);
					rbjTextField.setFont(new java.awt.Font("微软雅黑", 0, 14));
				}
				{
					tbjTextField = new JTextField();
					jPanel1.add(tbjTextField);
					// tbjTextField.setText("");
					tbjTextField.setBounds(140, 79, 395, 24);
					tbjTextField.setFont(new java.awt.Font("微软雅黑", 0, 14));
				}
				{
					srcjTextField = new JTextField();
					jPanel1.add(srcjTextField);
					// srcjTextField.setText("");
					srcjTextField.setBounds(140, 46, 395, 24);
					srcjTextField.setFont(new java.awt.Font("微软雅黑", 0, 14));
					
				}
				{
					ComboBoxModel jComboBox1Model = new DefaultComboBoxModel();
					jComboBox1 = new JComboBox();
					jPanel1.add(jComboBox1);
					jComboBox1.setModel(jComboBox1Model);
					jComboBox1.setBounds(140, 14, 284, 24);
					jComboBox1.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent evt) {
							if (evt.getStateChange() == ItemEvent.SELECTED) {
								// System.out.println("jComboBox1.itemStateChanged, event="+evt);
								// System.out.println(jComboBox1.getSelectedItem().toString());
								setTextValues(jComboBox1.getSelectedItem()
										.toString());
								addItemtoJComboBox2();
								try {							
									addItemtoJComboBox3();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							// TODO add your code for
							// jComboBox1.itemStateChanged

						}
					});
					addItemtoJComboBox1();
					// setTextValues(jComboBox1.getSelectedItem().toString());
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("\u8bf7\u9009\u62e9\u5b50\u7cfb\u7edf\uff1a");
					jLabel4.setBounds(14, 17, 101, 19);
				}
			}

			{
				jButton1 = new JButton();
				jPanel1.add(jButton1);
				jButton1.setText("创建里程碑版本");
				jButton1.setBounds(382, 216, 129, 24);
				jButton1.setBounds(215, 418, 150, 24);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AddReleaseVersion(jComboBox2.getSelectedItem()
								.toString());

					}
				});
			}

			{
				jButton2 = new JButton();
				jPanel1.add(jButton2);
				jButton2.setText("创建发布基线");
				jButton2.setBounds(41, 418, 150, 24);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(jComboBox2.getSelectedItem()
								.toString());
						addReleaseTags(jComboBox2.getSelectedItem().toString());
					}
				});
			}

			{
				jButton3 = new JButton();
				jPanel1.add(jButton3);
				jButton3.setText("添加");
				jButton3.setBounds(441, 15, 81, 23);
				jButton3.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						if (fbd == null) {
							fbd = new RelAddNewSysDialog(RelManageJPanel.this);
							fbd.setModal(true);
							fbd.setVisible(true);// fbd=null;
						} else {
							fbd.setVisible(true);// fbd=null;
						}
						jComboBox1.removeAllItems();// 先清空下拉框中所有的选项
						addItemtoJComboBox1();// 调用addItemtoJComboBox1方法，重新从数据库中查询并填充到下拉列表中。
					}
				});
			}
			{
				jLabel8 = new JLabel();
				jPanel1.add(jLabel8);
				jLabel8.setText("测试包路径：");
				jLabel8.setBounds(14, 146, 126, 19);
			}
			{
				jLabel9 = new JLabel();
				jPanel1.add(jLabel9);
				jLabel9.setText("发布包路径：");
				jLabel9.setBounds(14, 177, 126, 19);
			}
			{
				jLabel6 = new JLabel();
				jPanel1.add(jLabel6);
				jLabel6.setText("测试基线路径：");
				jLabel6.setBounds(14, 82, 108, 19);
			}
			{
				jLabel5 = new JLabel();
				jPanel1.add(jLabel5);
				jLabel5.setText("发布基线路径：");
				jLabel5.setBounds(15, 115, 126, 19);
			}
			{
				jLabel7 = new JLabel();
				jPanel1.add(jLabel7);
				jLabel7.setText("\u53d1\u5e03\u4e3b\u5e72\u8def\u5f84\uff1a");
				jLabel7.setBounds(14, 209, 101, 23);
			}
			{
				jLabel2 = new JLabel();
				jPanel1.add(jLabel2);
				jLabel2.setText("\u8bf7\u9009\u62e9\u7248\u672c\uff1a");
				jLabel2.setBounds(17, 374, 80, 22);
			}
			{
				jLabel3 = new JLabel();
				jPanel1.add(jLabel3);
				jLabel3.setText("自定义提交日志：");
				jLabel3.setBounds(14, 245, 114, 22);
			}
			
			{
				JScrollPane_del = new JScrollPane();
				jPanel1.add(JScrollPane_del);
				JScrollPane_del.setBounds(140, 244, 395, 102);
//				jTextArea_log.setBounds(140, 244, 392, 102);
				{
					jTextArea_log = new JTextArea();
					JScrollPane_del.setViewportView(jTextArea_log);
					jTextArea_log.setText("");
					jTextArea_log.setBounds(140, 244, 395, 102);
					getParelPath("Message", jTextArea_log);
				}
			}

			{
				jButton4 = new JButton();
				jPanel1.add(jButton4);
				jButton4.setText("\u53d1\u9001\u90ae\u4ef6");
				jButton4.setBounds(387, 418, 150, 24);
				jButton4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if (branches.size() > 1) {
							Sendmail mail = new Sendmail();
						//	DelRepeatReceiver mail1 = new DelRepeatReceiver();
							
							try {
						//		mail.SendmergeMail(srcjTextField.getText(),
						//				jComboBox3.getSelectedItem().toString(),getOtherBranches().toString(),
						//				trkjTextField.getText(),jComboBox1.getSelectedItem().toString());
							
								mail.SendmergeMailToScmGroup(srcjTextField.getText(),
														jComboBox3.getSelectedItem().toString(),getOtherBranches().toString(),
														trkjTextField.getText(),jComboBox1.getSelectedItem().toString());
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"只有一个分支，不需要发送邮件！");
						}

					}
				});
			}
			{
				jLabel10 = new JLabel();
				jPanel1.add(jLabel10);
				jLabel10.setText("\u8bf7\u9009\u62e9\u5206\u652f\uff1a");
				jLabel10.setBounds(307, 375, 80, 22);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getOtherBranches() {
		// TODO Auto-generated method stub
		String otherbranches="";
		for(int i=0;i<jComboBox3.getModel().getSize();i++)
		{
			if(!(jComboBox3.getModel().getElementAt(i)==jComboBox3.getModel().getSelectedItem()))
			{
				otherbranches=otherbranches+srcjTextField.getText().toString()+"/"+jComboBox3.getModel().getElementAt(i)+"\n";
			}
		}
		return otherbranches;
	}

	/**
	 * 根据sysid查询，得到结果赋给各个文本框
	 * 
	 * @param sysid
	 * @return 
	 * @return 
	 * @throws SQLException
	 */
	protected void setTextValues(String sysid) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> listtest = new ArrayList<Map<String, Object>>();
		try {
			listtest = DataConnect.getListFromRsfor_xgd_release(sysid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		srcjTextField.setText(listtest.get(0).get("codepath").toString());
		tbjTextField.setText(listtest.get(0).get("buildpath").toString());
		rbjTextField.setText(listtest.get(0).get("tagpath").toString());
		tpjTextField.setText(listtest.get(0).get("testpath").toString());
		rpjTextField.setText(listtest.get(0).get("releasepath").toString());
		trkjTextField.setText(listtest.get(0).get("trunkpath").toString());
	
	}

	/**
	 * 通过查询数据库中的xgd_release表，返回sysid值赋给jComboBox1中的下拉值。
	 * 
	 * @throws SQLException
	 */
	private void addItemtoJComboBox1() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> listtest = new ArrayList<Map<String, Object>>();
		try {
			listtest = DataConnect.getListFromRsfor_xgd_release();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < listtest.size(); i++) {
			jComboBox1.addItem(listtest.get(i).get("sysid").toString());
		}

	}

	/**
	 * 通过svn ls命令获取到版本号，将值赋给jComboBox2中的下拉值。
	 * 
	 * 
	 */
	private void addItemtoJComboBox2() {
		ArrayList<String> Versions = new ArrayList<String>();
		String subfolder = RuncmdCommand.runCMD("svn ls "
				+ tpjTextField.getText());
		if (!subfolder.equals("")) {
			for (String path : subfolder.split("\n")) {
				path = path.substring(0, path.lastIndexOf("/"));
				Versions.add(path);
			}
			jComboBox2.removeAllItems();
			for (int i = 0; i < Versions.size(); i++) {
				jComboBox2.addItem(Versions.get(i).toString());
			}

		} else {
			jComboBox2.removeAllItems();
			JOptionPane.showMessageDialog(null, "没有任何版本！");
		}

	}

	/**
	 * 通过svn ls命令获取到各分支，将值赋给jComboBox3中的下拉值。
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	private void addItemtoJComboBox3() throws Exception {
		branches = new ArrayList<String>();
		String subfolder = RuncmdCommand.runCMD("svn ls "
				+ srcjTextField.getText());
		System.out.println(subfolder);
		if (!subfolder.equals("")) {
			for (String path : subfolder.split("\n")) {
				path = path.substring(0, path.lastIndexOf("/"));
				branches.add(path);
			}
			jComboBox3.removeAllItems();
			for (int i = 0; i < branches.size(); i++) {
				jComboBox3.addItem(branches.get(i).toString());
			}

		} else {
			JOptionPane.showMessageDialog(null, "没有分支！");
		}

	}

	/*
	 * 设置默认个人路径
	 */
	private void getParelPath(String str, JTextArea jTextArea_log2) {
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
						if (str.equals("Message")) {
							if (line.startsWith("Message@")) {
								jTextArea_log2.setText(line.substring(line.indexOf("@") + 1));
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
	}


	/**
	 * 判断发布基线下是否已有版本。添加变量existed标志，判断是否找到
	 * 
	 * 
	 */
	private void tagExist() {
		boolean existed = false;
		String subfolder = RuncmdCommand.runCMD("svn ls "
				+ rbjTextField.getText());
		if (!subfolder.equals("")) {
			for (String path : subfolder.split("\n")) {
				path = path.substring(0, path.lastIndexOf("/"));
				System.out.println(path);

				if (path.equals(Version)) {
					existed = true;
					break;
				}
			}
		}

		if (existed) {
			JOptionPane.showMessageDialog(null, "发布基线已存在！");
		} else {
			RuncmdCommand.runCMD("svn cp " + "-m " + jTextArea_log.getText()
					+ " " + tbjTextField.getText() + "/" + strtime + "  "
					+ rbjTextField.getText() + "/" + Version);
			JOptionPane.showMessageDialog(null, "已创建！");
		}
	}

	/**
	 * 通过svn log命令截取到版本唯一的BuildTime，得到测试基线路径。调用方法tagExist()进行判断，如不存在则svn
	 * cp打上发布基线。
	 * 
	 * 
	 */
	public void addReleaseTags(String Version) {
		String str = RuncmdCommand.runCMD("svn log " + tpjTextField.getText()
				+ "/" + Version);
		strtime = str.substring(str.indexOf("BuildTime:") + 10,
				str.indexOf("BuildTime:") + 24);
		JOptionPane.showMessageDialog(null, "发布基线路径：" + rbjTextField.getText()
				+ "/" + Version);
		tagExist();
	}

	/*
	 * 创建里程碑版本 先判断对应版本号的里程碑是否存在，若存在则先删除原有里程碑，再拷贝替换。
	 */
	public void AddReleaseVersion(String Version) {
		boolean existed = false;
		String subfolder = RuncmdCommand.runCMD("svn ls "
				+ rpjTextField.getText());
		if (!subfolder.equals("")) {
			for (String path : subfolder.split("\n")) {
				path = path.substring(0, path.lastIndexOf("/"));
				System.out.println(path);

				if (path.equals(Version)) {
					existed = true;
					break;
				}
			}
		}
		if (existed) {
			JOptionPane.showMessageDialog(null, "里程碑已存在！");
			RuncmdCommand.runCMD("svn delete " + "-m " + "\"删除里程碑版本 \"  "
							+ rpjTextField.getText() + "/" + Version);
			JOptionPane.showMessageDialog(null, "已删除里程碑版本！");
			JOptionPane.showMessageDialog(null, "请重新创建里程碑版本！");
		} else {
			RuncmdCommand.runCMD("svn cp " + "-m " + jTextArea_log.getText()
					+ " "+ tpjTextField.getText() + "/" + Version
					+ " " + rpjTextField.getText() + "/" + Version);
			JOptionPane.showMessageDialog(null, "已创建里程碑版本！");
			JOptionPane.showMessageDialog(null,
					"里程碑版本路径：" + rpjTextField.getText() + "/" + Version);
		}
	}
}
