package com.fh.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Java_Excel {
	public static void main(String[] args) {

		System.out.println("-------------");
		// readXml("E:/test.xlsx");
		readXml("e:/工作资源/环境动态配置初始数据模板.xlsx");
	}

	@SuppressWarnings("resource")
	public static void readXml(String fileName) {
		boolean isE2007 = false; // 判断是否是excel2007格式
		String[] string = new String[6];
		String conf_list = null;
		String confenv_list = null;
		FileWriter fw1 = null;
		FileWriter fw2 = null;
		
		String str1="E:\\test\\conf_list.txt";
		String str2="E:\\test\\confenv_list.txt";
		File F1 = new File(str1); 
		if(F1.exists())
		F1.delete();                                      //如果txt文件已存在，则先删除原有的，再重新创建，保证写入前文件为空。
		File f1 = new File(str1);
		
		File F2 = new File(str2); 
		if(F2.exists())
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
					default:
						// System.out.println("unsuported sell type");
						break;
					}
					System.out.println("第" + j + "个值是:" + string[i]);
					i++;j++;
				}

				conf_list = "insert into config_manager."+string[5]+"(sysname,key123,notes,userid) values('" + string[1] + "','"
							+ string[2] + "','" + string[4] + "',4);";
				
				confenv_list = "insert into config_manager."+string[5]+"_env_mid(envid,sysid,value123,userid) select 4, a.sysid, '"
						+ string[3] + "',4 from config_manager.tradengine a where a.key123='" + string[2] + "' and a.sysname='" + string[1] + "';";
				if((row.getRowNum())>0&&(string[0]!=null))  //过滤掉第一行跟空行
				{
					System.out.println("插入配置表数据：" + conf_list);
					System.out.println("插入配置环境中间表数据：" + confenv_list);
					
					try {
						fw1 = new FileWriter(f1, true);  //追加写入txt文件中。
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
						fw1.flush();pw1.close();fw1.close();
						fw2.flush();pw2.close();fw2.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				string[0] = null;string[1] = null;string[2] = null;string[3] = null;string[4] = null;string[5]=null;
				System.out.println();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}