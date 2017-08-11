package com.fh.jw;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
public class ExcelToSql extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;
	protected static String Excelfile = null;
	protected static String Env = null;
	protected static String Excel_path = null;
	private JPanel jPanel1;
	private JButton jButton1;
	private JButton jButton2;
	@SuppressWarnings("rawtypes")
	private JComboBox jComboBox1;
	private JLabel jLabel2;
	private static JTextField jTextField1;
	private JLabel jLabel1;
	@SuppressWarnings("rawtypes")
	private ComboBoxModel jComboBox1Model;
	private JFileChooser jFileChooser1;
	private static String userid;

	/**
	 * Auto-generated main method to display this JPanel inside a new JFrame.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ExcelToSql());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public ExcelToSql() {
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
				jPanel1.setBounds(0, 0, 555, 407);
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("生成SQL文件");
					jButton1.setBounds(108, 128, 155, 34);
					jButton1.setFont(new java.awt.Font("微软雅黑", 1, 16));
					jButton1.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							JavaExcelToSql(jTextField1.getText().toString());
						}
					});
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("请选择文件：");
					jLabel1.setBounds(14, 37, 94, 19);
					jLabel1.setFont(new java.awt.Font("黑体", 0, 14));
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
					jTextField1.setBounds(108, 36, 346, 24);
					getExcelPath("ExcelPath", jTextField1);
				}

				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("\u8bf7\u9009\u62e9\u73af\u5883:");
					jLabel2.setBounds(14, 83, 94, 19);
					jLabel2.setFont(new java.awt.Font("黑体", 0, 14));
				}

				{
					jComboBox1Model = new DefaultComboBoxModel(new String[] {
							"开发环境", "开发联调环境", "测试环境", "测试镜像环境" });
					jComboBox1 = new JComboBox();
					jPanel1.add(jComboBox1);
					jComboBox1.setModel(jComboBox1Model);
					jComboBox1.setBounds(108, 80, 204, 24);
					jComboBox1.setFont(new java.awt.Font("黑体", 0, 14));
					jComboBox1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
							Env = jComboBox1Model.getSelectedItem().toString();
							switch (Env) {
							case "开发环境":
								if (Env.equals("开发环境")) {
									Env = "1";
									System.out.println("所选环境是： 开发环境");
								}

							case "开发联调环境":
								if (Env.equals("开发联调环境")) {
									Env = "2";
									System.out.println("所选环境是：开发联调环境");
								}

							case "测试环境":
								if (Env.equals("测试环境")) {
									Env = "3";
									System.out.println("所选环境是：测试环境");
								}

							case "测试镜像环境":
								if (Env.equals("测试镜像环境")) {
									Env = "4";
									System.out.println("所选环境是：测试镜像环境");
								}
								break;
							default:
								System.out.println("选择有误！");
							}
						}
					});
				}

				{
					jButton2 = new JButton();
					jPanel1.add(jButton2);
					jButton2.setText("浏览");
					jButton2.setBounds(466, 37, 64, 23);
					jButton2.setFont(new java.awt.Font("黑体", 0, 14));
					jButton2.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							File f = new File(jTextField1.getText().toString());
							jFileChooser1.setCurrentDirectory(f);
							FileNameExtensionFilter filter = new FileNameExtensionFilter(
									"表格文件(*.xlsx)", "xlsx");
							jFileChooser1.setFileFilter(filter);
							int returnVal = jFileChooser1
									.showOpenDialog(ExcelToSql.this);// 参数指参昭哪个对象显示，为NULL时屏幕居中。
							if (returnVal == JFileChooser.APPROVE_OPTION)// 跟据反回值判断是点的哪个打开还是取消.
							{
								File file = jFileChooser1.getSelectedFile();
								// 将excel文件的路径添加进去。
								jTextField1.setText(file.getPath());
							}
						}
					});
				}
				{
					jFileChooser1 = new JFileChooser();
					jPanel1.add(jFileChooser1);
					jFileChooser1.setFileSelectionMode(JFileChooser.FILES_ONLY);// 打开文件的浏览方式
					jFileChooser1.setBounds(84, -182, 63, 28);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	通过配置文件获取用户名
	private static String getUserName(String string)throws Exception {
		// TODO Auto-generated method stub 获取Excel文件路径
		File xfile = new File(".\\data\\config.dat");
		String strname="fanhua";
		if (xfile.exists()) {
			if (xfile.exists()) {
				FileReader fr = null;
				BufferedReader br = null;
				try {
					fr = new FileReader(xfile);
					br = new BufferedReader(fr);
					String line = "";
					while ((line = br.readLine()) != null) {
						if (string.equals("UserName")) {
							if (line.startsWith("UserName@")) {
								strname=line.substring(line.indexOf("@") + 1);
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
		return strname;
	}

//	通过配置文件获取excel文件所在的路径
	private void getExcelPath(String string, JTextField jTextField1)
			throws Exception {
		// TODO Auto-generated method stub 获取Excel文件路径
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
						if (string.equals("ExcelPath")) {
							if (line.startsWith("ExcelPath@")) {
								jTextField1.setText(line.substring(line
										.indexOf("@") + 1));
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

	// TODO Auto-generated method stub 将excel中的文件生产sql语句
	@SuppressWarnings("resource")
	private static void JavaExcelToSql(String fileName) {
		boolean isE2007 = false; // 判断是否是excel2007格式
		String[] string = new String[6];
		String conf_list = null;
		String confenv_list = null;
		FileWriter fw1 = null;
		FileWriter fw2 = null;
		String strpath = jTextField1
				.getText()
				.toString()
				.substring(0,
						jTextField1.getText().toString().lastIndexOf("\\"));
		String str1 = strpath + "\\conf_list.txt";
		String str2 = strpath + "\\confenv_list.txt";
		try {
			userid=DataConnect.getListFromRsforUsername(getUserName("UserName"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		File F1 = new File(str1);
		if (F1.exists())
			F1.delete(); // 如果txt文件已存在，则先删除原有的，再重新创建，保证写入前文件为空。
		File f1 = new File(str1);
		File F2 = new File(str2);
		if (F2.exists())
			F2.delete();
		File f2 = new File(str2);

		if (fileName.endsWith("xlsx"))
			isE2007 = true;
		try {
			InputStream input = new FileInputStream(fileName); // 建立输入流
			Workbook wb = null;
			// 根据文件格式(2003或者2007)来初始化
			if (isE2007)
				wb = new XSSFWorkbook(input);
			else
				wb = new HSSFWorkbook(input);
			Sheet sheet = wb.getSheetAt(0); // 获得第一个表单
			Iterator<Row> rows = sheet.rowIterator(); // 获得第一个表单的迭代器
			while (rows.hasNext()) {
				Row row = rows.next(); // 获得行数据
				double p = 0;
				String q = null;
				int i = 0;
				int j = 1;
				System.out.println("第" + row.getRowNum() + "行：  "); // 获得行号从0开始,打印出第几行
				Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器
				while (cells.hasNext()) {
					Cell cell = cells.next();
					System.out.print("Cell #" + cell.getColumnIndex() + ": ");
					switch (cell.getCellType()) { // 根据cell中的类型来输出数据
					case HSSFCell.CELL_TYPE_NUMERIC:
						p = cell.getNumericCellValue();
						q = String.valueOf((int) p);
						System.out.print(q + "  ");
						string[i] = q;
						break;
					case HSSFCell.CELL_TYPE_STRING:
						q = cell.getStringCellValue();
						System.out.print(q + "  ");
						string[i] = q;
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						q = String
								.valueOf((Boolean) cell.getBooleanCellValue());
						System.out.print(q + "  ");
						string[i] = q;
						break;
					default:
						break;
					}
					System.out.println("第" + j + "个值是:" + string[i]);
					i++;
					j++;
				}

				conf_list = "insert into config_manager." + string[1]
						+ "(sysname,key123,notes,userid) values('" + string[2]
						+ "','" + string[3] + "','" + string[5] + "'," + Env
						+ ");";

				confenv_list = "insert into config_manager." + string[1]
						+ "_env_mid(envid,sysid,value123,userid) select " + Env
						+ ", a.sysid, '" + string[4]
						+ "',"+userid+" from config_manager." + string[1]
						+ " a where a.key123='" + string[3]
						+ "' and a.sysname='" + string[2] + "';";
				if ((row.getRowNum()) > 0 && (string[0] != null)) // 过滤掉第一行跟空行
				{
					System.out.println("插入配置表数据：" + conf_list);
					System.out.println("插入配置环境中间表数据：" + confenv_list);
					try {
						fw1 = new FileWriter(f1, true); // 追加写入txt文件中。
						fw2 = new FileWriter(f2, true);
					} catch (IOException e) {
						e.printStackTrace();
					}
					PrintWriter pw1 = new PrintWriter(fw1);
					pw1.println(conf_list);
					pw1.flush();
					PrintWriter pw2 = new PrintWriter(fw2);
					pw2.println(confenv_list);
					pw2.flush();
					try {
						fw1.flush();
						pw1.close();
						fw1.close();
						fw2.flush();
						pw2.close();
						fw2.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				string[0] = null;
				string[1] = null;
				string[2] = null;
				string[3] = null;
				string[4] = null;
				string[5] = null;
			}
			JOptionPane.showMessageDialog(null, "已完成，请在路径：" + strpath + " 查看！");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
