package com.fh.jw;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.WindowConstants;

//import test.FindStreamJPanel;

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
public class VsMainFrame extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JMenuItem jMenuItem7;
	private JMenuItem jMenuItem6;
	private JSeparator jSeparator2;
	private JMenuItem helpDOC;
	private JMenuItem jMenuItem1;
	private JMenuItem vobGroup;
	// private JMenuItem versionPlan;
	private static JPopupMenu jPopupMenu1;
	private JMenuItem getRebaseFile;
	private JPanel mainPane;
	private JMenuItem persionConfig;
	private JMenu setConfig;
	private JMenuItem about;
	private JMenu help;
	private JMenuItem changOwner;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuMainCq;
	private JSeparator jSeparator1;
	private static JMenuItem cut;
	private static JMenuItem copy;
	private static JMenuItem paste;
	private JMenu jMenu2;
	private JMenu jMenuCq;
	private JMenuItem jMenuItem3;
	private JMenu jMenu1;
	private JMenuBar jMenuBar1;
	private JMenuItem addbugzillaMenu;
	private JMenu bugzillaMenu;
	private CardLayout car;
	private JMenuItem jMenuUpdateProperties;
	private JMenu jMenuProperties;
	private JMenu cleanMenu;
	private JMenuItem cleanPa;
	// private static SetConfigJPanel scjp=null;//个人设置界面
	// private static AboutVersionJPanel avjp=null;//关于版本信息
	// private static GetNoUcmFileJPanel tbp=null;//取非UCM文件
	private static FindbugbyBugidJPanel stjp = null;// 设置TRIGGER界面
	private static DeleteVersionJPanel scjp = null;// 设置删除界面
	private static RelManageJPanel screl = null;// 设置发布界面
	private static VersionDiffJPanel vdjp = null;// 设置发布版本对比界面
	
	// private static ChangOwnerJPanel cojp=null;//修改owner的界面
	// private static LockStreamJPanel lsjp=null;//锁流和标签操作界面
	// private static GetUcmFileJPanel gufjp=null;//取UCM文件
	private static UpPropertiesJPanel upprojp = null;// 设置TRIGGER界面
	private static UserPwdJPanel upjp = null;// 设置TRIGGER界面
	private static HelpJPanel hjp = null;// 帮助文档;
	private static ExcelToSql ejp = null;
	// private static GetUcmRebaseFileJPanel gurfjp=null;//提取rebase后文件.
	// private static GetCQJpanel gCQj=null;
	// //private static CheckVersionPlanJPanel cvpjp=null;
	// private static FindVobGroupJPanel fvgjp=null;
	public static VsMainFrame mf = null;
	// private cleanFilePane cfp=null;//pa_rel文件清理
	private JMenuItem cleanView = null;
	// private GetDbUcmFileJPanel cduf=null;
	private JMenuItem checkDoc = null;
	// private SendMsgPanel smp=null;
	private JMenuItem rebaseMial;
	private String Version = "VS1.0.0";
	// private MppPanel mpp=null;
	private JMenuItem createTask;
	private JMenuItem createrStream;
	// private CreaterStreamJPanel csjp;
	private JMenuItem getNdb;
	private JMenu deleteMenu;
	private JMenuItem delete;
	private JMenu relMenu;
	private JMenuItem relMenuItem;
	private JMenu ExcelToSql;
	private JMenuItem sql;

	// private GetDbPanel gndbp;
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		mf = new VsMainFrame();
		// JFrame.setDefaultLookAndFeelDecorated(false);
		// mf.setVisible(true);
		// mf.setResizable(false);
	}

	public VsMainFrame() {
		super();
		initGUI();
		this.setLocationRelativeTo(this);
		// this.setResizable(false);
		this.setVisible(true);
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			Container c = null;
			{
				c = this.getContentPane();
				this.setContentPane(c);
				c.setLayout(new BorderLayout());
				c.setBounds(0, 0, 592, 245);
			}
			this.setTitle("【 CM专用工具 " + Version + "】");
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				jMenuBar1.setBackground(new java.awt.Color(234, 236, 215));
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("操作");
					jMenu1.setFont(new java.awt.Font("宋体", 0, 12));
					jMenu1.setBackground(new java.awt.Color(236, 233, 216));

					{
						jSeparator1 = new JSeparator();
						jMenu1.add(jSeparator1);
					}
					{
						jMenuItem4 = new JMenuItem();
						jMenu1.add(jMenuItem4);
						jMenuItem4.setText("退出");
						jMenuItem4.setFont(new java.awt.Font("宋体", 0, 12));
						jMenuItem4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								int jop = JOptionPane.showConfirmDialog(
										VsMainFrame.this, "请问是否确定要退出？", "是否退出",
										JOptionPane.YES_NO_OPTION);
								if (jop == 0) {
									System.exit(-1);// 退出菜单的操作语句
								}
							}
						});
					}
				}
				
				{
					relMenu = new JMenu();
					jMenuBar1.add(relMenu);
					relMenu.setText("发布管理");
					relMenu.setPreferredSize(new java.awt.Dimension(58,
							23));
					relMenu.setBackground(new java.awt.Color(236, 233,
							216));
					relMenu.setFont(new java.awt.Font("宋体", 0, 12));
//					VersionDiffJPanel
					{
						JMenuItem diffMenuItem = new JMenuItem();
						relMenu.add(diffMenuItem);
						diffMenuItem.setText("版本对比");
						diffMenuItem.setFont(new java.awt.Font("宋体", 0, 12));
						diffMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								mainPane.removeAll();
								if (vdjp == null) {
									vdjp = new VersionDiffJPanel();
									// stjp.setVisible(false);
								}
								vdjp.setVisible(true);
								VsMainFrame.this.setSize(580, 520);
								mainPane.setSize(580, 520);
								mainPane.add(vdjp, "版本对比");
								car.addLayoutComponent(vdjp, "版本对比");
								car.show(mainPane, "版本对比");
								setTitle("【 CM专用工具 " + Version + " 】版本对比");
							}
						});
					}
					{
						relMenuItem = new JMenuItem();
						relMenu.add(relMenuItem);
						relMenuItem.setText("发布操作");
						relMenuItem.setFont(new java.awt.Font("宋体", 0, 12));
						relMenuItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								mainPane.removeAll();
								if (screl == null) {
									screl = new RelManageJPanel();
									// stjp.setVisible(false);
								}
								screl.setVisible(true);
								VsMainFrame.this.setSize(580, 520);
								mainPane.setSize(580, 520);
								mainPane.add(screl, "发布管理");
								car.addLayoutComponent(screl, "发布管理");
								car.show(mainPane, "发布管理");
								setTitle("【 CM专用工具 " + Version + " 】发布管理");
							}
						});
					}
					
					
				}
				
				{
					ExcelToSql = new JMenu();
					jMenuBar1.add(ExcelToSql);
					ExcelToSql.setText("持续集成");
					ExcelToSql.setPreferredSize(new java.awt.Dimension(58,
							23));
					ExcelToSql.setBackground(new java.awt.Color(236, 233,
							216));
					ExcelToSql.setFont(new java.awt.Font("宋体", 0, 12));
					{
						sql = new JMenuItem();
						ExcelToSql.add(sql);
						sql.setText("Excel转换SQL");
						sql.setFont(new java.awt.Font("宋体", 0, 12));
						sql.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								mainPane.removeAll();
								if (ejp == null) {
									ejp = new ExcelToSql();
									// stjp.setVisible(false);
								}
								ejp.setVisible(true);
								VsMainFrame.this.setSize(580, 520);
								mainPane.setSize(580, 520);
								mainPane.add(ejp, "Excel生成Sql");
								car.addLayoutComponent(ejp, "Excel生成Sql");
								car.show(mainPane, "Excel生成Sql");
								setTitle("【 CM专用工具 " + Version + " 】Excel生成Sql");
							}
						});
					}
				}
				
				{
					deleteMenu = new JMenu();
					jMenuBar1.add(deleteMenu);
					deleteMenu.setText("版本删除");
					deleteMenu.setPreferredSize(new java.awt.Dimension(58,
							23));
					deleteMenu.setBackground(new java.awt.Color(236, 233,
							216));
					deleteMenu.setFont(new java.awt.Font("宋体", 0, 12));
					{
						delete = new JMenuItem();
						deleteMenu.add(delete);
						delete.setText("删除版本");
						delete.setFont(new java.awt.Font("宋体", 0, 12));
						delete.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								mainPane.removeAll();
								if (scjp == null) {
									scjp = new DeleteVersionJPanel();
									// stjp.setVisible(false);
								}
								scjp.setVisible(true);
								VsMainFrame.this.setSize(580, 520);
								mainPane.setSize(580, 520);
								mainPane.add(scjp, "删除版本");
								car.addLayoutComponent(scjp, "删除版本");
								car.show(mainPane, "删除版本");
								setTitle("【 CM专用工具 " + Version + " 】删除版本");
							}
						});
					}
				}					
				
				{
					bugzillaMenu = new JMenu();
					jMenuBar1.add(bugzillaMenu);
					bugzillaMenu.setText("bugzilla");
					bugzillaMenu.setFont(new java.awt.Font("宋体", 0, 12));
					bugzillaMenu
							.setBackground(new java.awt.Color(236, 233, 216));
					{
						addbugzillaMenu = new JMenuItem();
						bugzillaMenu.add(addbugzillaMenu);
						addbugzillaMenu.setText("查询bugid");
						addbugzillaMenu.setFont(new java.awt.Font("宋体", 0, 12));
						addbugzillaMenu.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								mainPane.removeAll();
								if (stjp == null) {
									stjp = new FindbugbyBugidJPanel();// 设置TRIGGER
									// stjp.setVisible(false);
								}
								stjp.setVisible(true);
								VsMainFrame.this.setSize(580, 520);
								mainPane.setSize(580, 520);
								mainPane.add(stjp, "查询bugid");
								car.addLayoutComponent(stjp, "查询bugid");
								car.show(mainPane, "查询bugid");
								setTitle("【 CM专用工具 " + Version + " 】查询bugid");
							}
						});
					}
				}
				{
					jMenuProperties = new JMenu();
					jMenuBar1.add(jMenuProperties);
					jMenuProperties.setText("配置");
					{
						jMenuUpdateProperties = new JMenuItem();
						jMenuProperties.add(jMenuUpdateProperties);
						jMenuUpdateProperties.setText("更新配置文件");
						jMenuUpdateProperties.setFont(new java.awt.Font("宋体",
								0, 12));
						jMenuUpdateProperties
								.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent evt) {
										mainPane.removeAll();
										if (upprojp == null) {
											upprojp = new UpPropertiesJPanel();//
											// stjp.setVisible(false);
										}
										upprojp.setVisible(true);
										VsMainFrame.this.setSize(580, 520);
										mainPane.setSize(580, 520);
										mainPane.add(upprojp, "设置属性文件");
										car.addLayoutComponent(upprojp,
												"设置属性文件");
										car.show(mainPane, "设置属性文件");
										setTitle("【 CM专用工具 " + Version
												+ " 】设置属性文件");
									}
								});
					}
				}
				{
					setConfig = new JMenu();
					jMenuBar1.add(setConfig);
					setConfig.setText("设置");
					setConfig.setBackground(new java.awt.Color(236, 233, 216));
					setConfig.setFont(new java.awt.Font("宋体", 0, 12));
					{
						persionConfig = new JMenuItem();
						setConfig.add(persionConfig);
						persionConfig.setText("用户设置");
						persionConfig.setFont(new java.awt.Font("宋体", 0, 12));
						persionConfig.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								mainPane.removeAll();
								if (upjp == null) {
									upjp = new UserPwdJPanel();//
									// stjp.setVisible(false);
								}
								upjp.setVisible(true);
								VsMainFrame.this.setSize(580, 520);
								mainPane.setSize(580, 520);
								mainPane.add(upjp, "用户设置");
								car.addLayoutComponent(upjp,
										"设置用户");
								car.show(mainPane, "设置用户");
								setTitle("【 CM专用工具 " + Version
										+ " 】设置用户");
							}
						});
					}

					
				}
				
				

				{
					help = new JMenu();
					jMenuBar1.add(help);
					help.setText("帮 助");
					help.setPreferredSize(new java.awt.Dimension(38, 23));
					help.setBackground(new java.awt.Color(236, 233, 216));
					help.setFont(new java.awt.Font("宋体", 0, 12));
					{
						helpDOC = new JMenuItem();
						help.add(helpDOC);
						helpDOC.setText("帮助文档");
						helpDOC.setFont(new java.awt.Font("宋体", 0, 12));
						helpDOC.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								mainPane.removeAll();
								hjp.setVisible(true);
								VsMainFrame.this.setSize(747, 705);
								mainPane.setSize(747, 705);
								mainPane.add(hjp, "帮助文档");
								car.addLayoutComponent(hjp, "帮助文档");
								car.show(mainPane, "帮助文档");
								setTitle("【 CM专用工具 " + Version + " 】");
								// //JOptionPane.showMessageDialog(MainFrame.this,"待写!!!!!!!!!!!!!!!!","帮助文档",JOptionPane.PLAIN_MESSAGE);
							}
						});
					}
				}
			}
			{
				mainPane = new JPanel();
				getContentPane().add(mainPane);
				mainPane.setBounds(0, 0, 588, 406);
			}

			car = new CardLayout();
			mainPane.setLayout(car);
			mainPane.setPreferredSize(new java.awt.Dimension(739, 672));
			mainPane.setBackground(new java.awt.Color(245, 236, 255));
			hjp = new HelpJPanel();// 帮助文档
			hjp.setVisible(true);// 默认显示为帮助文档
			mainPane.add(hjp, "帮助文档");
			car.addLayoutComponent(hjp, "帮助文档");
			car.show(mainPane, "帮助文档");
			setTitle("【 CM专用工具 " + Version + " 】");
			pack();
			this.setSize(747, 705);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Auto-generated method for setting the popup menu for a component
	 */
	private void setComponentPopupMenu(final java.awt.Component parent,
			final javax.swing.JPopupMenu menu) {
		parent.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}

			public void mouseReleased(java.awt.event.MouseEvent e) {
				if (e.isPopupTrigger())
					menu.show(parent, e.getX(), e.getY());
			}
		});
	}

	public static JPopupMenu getJPopupMenu1() {
		return jPopupMenu1;
	}

	public void setJPopupMenu1(JPopupMenu popupMenu1) {
		jPopupMenu1 = popupMenu1;
	}

	public static JMenuItem getCopy() {
		return copy;
	}

	public static void setCopy(JMenuItem copy) {
		VsMainFrame.copy = copy;
	}

	public static JMenuItem getPaste() {
		return paste;
	}

	public static void setPaste(JMenuItem paste) {
		VsMainFrame.paste = paste;
	}

	public static JMenuItem getCut() {
		return cut;
	}

	public static void setCut(JMenuItem cut) {
		VsMainFrame.cut = cut;
	}

}
