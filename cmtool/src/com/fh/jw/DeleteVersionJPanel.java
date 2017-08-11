package com.fh.jw;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import com.fh.jw.DateChooserJButton;
import com.fh.jw.Delete;

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
public class DeleteVersionJPanel extends JPanel {

	protected JTextArea jTextArea_del;
	private JScrollPane JScrollPane_del;
	private JLabel jLabel2;
	private Container jPanel1;
	private JTextField jTextField1;
	private JLabel jLabel3;
	private JLabel jLabel1;
	private JButton jButton1;
	private DateChooserJButton dateChooserJButton1;
	private JLabel jLabel4;
	private JButton jButton2;
	private Delete delete;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.getContentPane().add(new UpPropertiesJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

	public DeleteVersionJPanel() {
		super();
		initGUI();
	}

	private void initGUI() {
		// TODO Auto-generated method stub
		try {

			this.setPreferredSize(new java.awt.Dimension(546, 361));
			this.setLayout(null);
			{
				jPanel1 = new JPanel();
				this.add(jPanel1);
				jPanel1.setBounds(1, 1, 556, 457);
				jPanel1.setLayout(null);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("\u8f93\u5165\u53c2\u6570\uff1a");
					jLabel1.setBounds(8, 0, 85, 37);
					jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 16));
					jLabel1.setForeground(new java.awt.Color(0, 0, 255));
					jLabel1.setBackground(new java.awt.Color(0, 0, 0));
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2);
					jLabel2.setText("\u65e5  \u671f:");
					jLabel2.setBounds(26, 74, 55, 17);
					jLabel2.setFont(new java.awt.Font("黑体", 0, 14));
				}
				{
					jTextField1 = new JTextField();
					jPanel1.add(jTextField1);
					jTextField1.setText("svn://jialiansvn.xgd.com/xgd_rel/card");
					jTextField1.setBounds(93, 40, 443, 24);
					jTextField1.setFont(new java.awt.Font("微软雅黑", 0, 14));
					// jTextField1.addInputMethodListener((InputMethodListener)
					// this);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3);
					jLabel3.setText("svn\u8def\u5f84:");
					jLabel3.setBounds(26, 43, 67, 17);
					jLabel3.setFont(new java.awt.Font("黑体", 0, 16));
				}
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("\u5220 \u9664");
					jButton1.setBounds(434, 392, 102, 38);
					jButton1.setFont(new java.awt.Font("黑体", 1, 16));
					jButton1.setForeground(new java.awt.Color(255, 0, 0));
					jButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Date date = dateChooserJButton1.getDate();
							int res;
							res = JOptionPane.showConfirmDialog(null, "请再次确认是否删除!",null,JOptionPane.YES_NO_OPTION);
							if(res == JOptionPane.NO_OPTION){
								JOptionPane.showMessageDialog(null, "未删除！");
							}else if(res == JOptionPane.YES_OPTION){
								delete = new Delete();
								delete.deleteVersionFile(jTextArea_del.getText()
										.toString());
								JOptionPane.showMessageDialog(null, "已删除！");
							}
							
							// System.out.println(jTextField1.getText()+"/");
						}
					});

					// jPanel1.add(getDateChooserJButton_IL(),
					// java.awt.BorderLayout.CENTER);

				}
				{
					dateChooserJButton1 = new DateChooserJButton();
					jPanel1.add(dateChooserJButton1);
					dateChooserJButton1.setText("dateChooserJButton1");
					dateChooserJButton1.setBounds(93, 69, 150, 22);
					dateChooserJButton1
							.setFont(new java.awt.Font("微软雅黑", 0, 14));
				}
				{
					jLabel4 = new JLabel();
					jPanel1.add(jLabel4);
					jLabel4.setText("\u5220\u9664\u7684\u7248\u672c\u5982\u4e0b\uff1a");
					jLabel4.setFont(new java.awt.Font("黑体", 0, 14));
					jLabel4.setBounds(26, 119, 128, 17);
				}
				{
					jButton2 = new JButton();
					jPanel1.add(jButton2);
					jButton2.setText("查找");
					jButton2.setForeground(new java.awt.Color(255, 0, 0));
					jButton2.setFont(new java.awt.Font("黑体", 1, 16));
					jButton2.setBounds(434, 102, 102, 38);
					jButton2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Date date = dateChooserJButton1.getDate();
							delete = new Delete();
							ArrayList<String> arraylist = delete
									.deleteFileOldThan(jTextField1.getText(),
											date);
							String stradd = "";
						
							
							if (arraylist.size() == 0){
								JOptionPane.showMessageDialog(null, "需要删除的版本为空！");
							}
							else {
							
								for (int i = 0; i < arraylist.size(); i++) {
									stradd = stradd + arraylist.get(i).toString()
											+ "\n";									
								}
								JOptionPane.showMessageDialog(null, "已查询完成！");
							}						
							
							jTextArea_del.setText(stradd);
						}
					});
				}
				
				{
					JScrollPane_del = new JScrollPane();
					jPanel1.add(JScrollPane_del);
					JScrollPane_del.setBounds(26, 151, 510, 223);
					{
						jTextArea_del = new JTextArea();
						JScrollPane_del.setViewportView(jTextArea_del);
						jTextArea_del.setText("");
						jTextArea_del.setBounds(26, 151, 510, 223);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
