package com.fh.jw;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

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
public class FindbugbyBugidJPanel extends javax.swing.JPanel {
	private JPanel jPanel1;
	private JButton jButton1;
	private JTextField jTextField1;
	private JLabel jLabel1;
	private TableModel jTable2Model;
	private JScrollPane jScrollPane1;
	private JTable cdTable;

	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new FindbugbyBugidJPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public FindbugbyBugidJPanel() {
		super();
		initGUI();
	}
	public JTable getCdTable()
	{
		return cdTable;
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
					jButton1.setText("查询");
					jButton1.setBounds(357, 23, 62, 24);
					jButton1.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							try {
								excuteQuery(jTextField1.getText().toString());
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							}
						});
					
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("请输入bugid：");
					jLabel1.setBounds(51, 25, 85, 19);
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
					jTextField1.setBounds(140, 23, 190, 24);
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setFont(new java.awt.Font("宋体",0,14));
					jScrollPane1.setBounds(12, 57, 536, 391);
					TableModel jTable2Model = 
							new DefaultTableModel(
									new String[][] { { "张三", "zhangsan@xinguodu.com","2015-07-30","代码重构----" }},
									new String[] { "用户名", "邮箱","日期","变更内容" });
					cdTable = new JTable();
					cdTable.setBounds(51, 115, 442, 109);
					cdTable.setModel(jTable2Model);
					cdTable.setFont(new java.awt.Font("宋体", 0, 12));
					jScrollPane1.setViewportView(cdTable);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getData(String bugid) throws SQLException
	{
		 List<Map<String, Object>> ls = new ArrayList<Map<String, Object>>();
    	 ls=DataConnect.getListFromRs("16594");
    	 
    	 for(int i=0;i<ls.size();i++)
    	 {
    		 System.out.println(ls.get(i).get("bug_when"));
    	 }
    	 jTable2Model.setValueAt("002", 1, 1);
	}

	/**  
     * JTable列表自适应宽度  
     * @param 需列表自适应宽度的JTable  
     */  
    public void fitTableColumns(JTable myTable) {
        JTableHeader header = myTable.getTableHeader();   
        int rowCount = myTable.getRowCount();
        Enumeration columns = myTable.getColumnModel().getColumns();   
        while (columns.hasMoreElements()) {   
            TableColumn column = (TableColumn) columns.nextElement();   
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());   
            int width = (int) myTable.getTableHeader().getDefaultRenderer()   
                    .getTableCellRendererComponent(myTable, column.getIdentifier(), false, false,   
                            -1, col).getPreferredSize().getWidth();   
            for (int row = 0; row < rowCount; row++) {   
                int preferedWidth = (int) myTable.getCellRenderer(row, col)   
                        .getTableCellRendererComponent(myTable, myTable.getValueAt(row, col),   
                                false, false, row, col).getPreferredSize().getWidth();   
                width = Math.max(width, preferedWidth);   
            }   
            header.setResizingColumn(column); // 此行很重要   
            column.setWidth(width + myTable.getIntercellSpacing().width);   
        }
    }
    
	/**  
     * JTable清除原有的数据
     * @param 需清除的JTable  
     */  
    public void delTableColumns(JTable myTable) {
		((DefaultTableModel)myTable.getModel()).getDataVector().removeAllElements(); 
		((DefaultTableModel)myTable.getModel()).fireTableDataChanged();
    }

	public void excuteQuery(String bugid) throws SQLException
	{
		FindbugbyBugIDimpl ccs1=FindbugbyBugIDimpl.getCheckUcmCqSevice(this);
		ccs1.checkCQ(bugid);
	}

}
