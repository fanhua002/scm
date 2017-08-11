package com.fh.jw;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPanel;
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
public class UpPropertiesJPanel extends javax.swing.JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanel1;
	private JButton jButton1;
	private JButton jButton2;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBox1;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private String env="test";
	@SuppressWarnings("rawtypes")
	private ComboBoxModel jComboBox1Model;
	private JFileChooser jFileChooser1;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new UpPropertiesJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public UpPropertiesJPanel() {
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
				jPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
				jPanel1.setLayout(null);
				jPanel1.setBounds(0, 0, 567, 462);
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("\u66ff\u6362\u914d\u7f6e\u6587\u4ef6");
					jButton1.setBounds(382, 155, 117, 24);
					jButton1.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							replacePropertiesFile(jTextField1.getText().toString(),env);
							}
						});
					
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("请输入编译包的路径：");
					jLabel1.setBounds(14, 25, 126, 19);
				}
				{
					jTextField1 = new JTextField();
					GridLayout jTextField1Layout = new GridLayout(1, 1);
					jTextField1Layout.setColumns(1);
					jTextField1Layout.setHgap(5);
					jTextField1Layout.setVgap(5);
					jTextField1.setLayout(jTextField1Layout);
					jPanel1.add(jTextField1);
					jTextField1.setText("");
					jTextField1.setBounds(9, 50, 450, 24);
					getParelPath("ViewPath", jTextField1);//
				}
				
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("\u8bf7\u9009\u62e9\u90e8\u7f72\u7684\u73af\u5883\uff1a");
					jLabel2.setBounds(14, 86, 113, 19);
				}
				{
					jComboBox1Model = 
							new DefaultComboBoxModel(
									new String[] { "测试环境", "开发环境" });
					jComboBox1 = new JComboBox();
					jPanel1.add(jComboBox1);
					jComboBox1.setModel(jComboBox1Model);
					jComboBox1.setBounds(14, 111, 136, 24);
					jComboBox1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							System.out.println("jComboBox1.actionPerformed, event="+evt);
							//TODO add your code for jComboBox1.actionPerformed
							System.out.println(jComboBox1Model.getSelectedItem());
							if(jComboBox1Model.getSelectedItem().toString().equals("开发环境"))
							{
								env="dev";
							}
							if(jComboBox1Model.getSelectedItem().toString().equals("测试环境"))
							{
								env="test";
							}
						}
					});
				}
				{
					jButton2 = new JButton();
					jPanel1.add(jButton2);
					jButton2.setText("选择目录");
					jButton2.setBounds(471, 50, 88, 24);
					jButton2.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							File f = new File(jTextField1.getText().toString());
							jFileChooser1.setCurrentDirectory(f);
							int returnVal = jFileChooser1.showOpenDialog(UpPropertiesJPanel.this);// 参数指参昭哪个对象显示，为NULL时屏幕居中。
							if (returnVal == JFileChooser.APPROVE_OPTION)// 跟据反回值判断是点的哪个打开还是取消.
							{
								File file = jFileChooser1.getSelectedFile();
								jTextField1.setText(file.getPath());// JOptionPane.showMessageDialog(null,
																// "在对话框内显示的描述性的文字"+returnVal,
																// "标题条文字串",
																// JOptionPane.ERROR_MESSAGE);
							}
							//TODO add your code for jButton2.mouseClicked
						}
					});
				}
				{
					jFileChooser1 = new JFileChooser();
					jPanel1.add(jFileChooser1); // jFileChooser1.setCurrentDirectory(f);
					jFileChooser1
							.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					jFileChooser1.setBounds(84, -182, 63, 28);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void replacePropertiesFile(String filepath,String env)
	{
		// 查找属性文件的类
		FindPropertyFile lf;
		// 截取xgd_rel后的完整路径
		String subpath = filepath.substring(filepath.indexOf("xgd_rel") + 8);
		// 根据\\分割字符
		String[] names = subpath.split("\\\\");
		//得到系统名
		String sys=names[0].toString();
		//返回子系统的查询结果
		String syschild=names[1].toString();
		// 将系统名放到数据库中进行查询
		try {
			List<Map<String, Object>> listtest = new ArrayList<Map<String, Object>>();
			listtest = DataConnect.getListFromRs(sys,syschild);
//			得到数据库中的key与values数值
			for (int i = 0; i < listtest.size(); i++) {
				String key = (String) listtest.get(i).get("key123");
				String values = (String) listtest.get(i).get(env);
//				查找该路径下的属性文件
				lf = new FindPropertyFile();
				List<Object> ls = lf.listPropertiesFile(filepath);
//				将数据库中的键值对写入到属性文件中
				for (int j = 0; j < ls.size(); j++) {
					// System.out.println("配置文件：" + ls.get(i).toString());
					UpdatePropertyFile.GetAllProperties(ls.get(j).toString(),key, values);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/*
	 * 设置默认个人路径
	 */
	private void getParelPath(String str, JTextField jtf) {
		File xfile = new File(".\\data\\config.dat");
		if (xfile.exists()) {
			if (xfile.exists()) {
				FileReader fr = null;
				;
				BufferedReader br = null;
				try {
					fr = new FileReader(xfile);
					br = new BufferedReader(fr);
					String line = "";
					while ((line = br.readLine()) != null) {
						if (str.equals("parel")) {
							if (line.startsWith("parel@")) {
								jtf.setText(line
										.substring(line.indexOf("@") + 1));
							}
						} else if (str.equals("dViewPath")) {
							if (line.startsWith("dViewPath@")) {
								jtf.setText(line
										.substring(line.indexOf("@") + 1));
							}
						} else if (str.equals("tViewPath")) {
							if (line.startsWith("tViewPath@")) {
								jtf.setText(line
										.substring(line.indexOf("@") + 1));
							}
						}else if (str.equals("ViewPath")) {
							if (line.startsWith("ViewPath@")) {
								jtf.setText(line
										.substring(line.indexOf("@") + 1));
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

}
