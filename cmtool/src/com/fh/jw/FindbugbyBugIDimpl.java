package com.fh.jw;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

public class FindbugbyBugIDimpl {
	private FindbugbyBugidJPanel cuep;
	private static FindbugbyBugIDimpl checkUcmCqSevice;
	public static FindbugbyBugIDimpl getCheckUcmCqSevice(FindbugbyBugidJPanel cuep)
	{
		if(checkUcmCqSevice==null)
		{
			checkUcmCqSevice=new FindbugbyBugIDimpl(cuep);
		}
		return checkUcmCqSevice;
	}

	public FindbugbyBugIDimpl(FindbugbyBugidJPanel cuep) {
		this.cuep = cuep;
	}
	public FindbugbyBugIDimpl()
	{
		
	}
	
	public void checkCQ(String bugid) throws SQLException {
		 List<Map<String, Object>> ls = new ArrayList<Map<String, Object>>();
    	 ls=DataConnect.getListFromRs(bugid);
		delToCdTable();//
		addToCdTable(ls);//
		}
		
	private void addToCdTable(List<Map<String, Object>> ls) {
		DefaultTableModel tableModel = (DefaultTableModel) cuep.getCdTable().getModel();
		for (int i = 0; i < ls.size(); i++) {
			String login_name = (String) ls.get(i).get("login_name");
			String realname = (String) ls.get(i).get("realname");
			String bug_when = (String) ls.get(i).get("bug_when");
			String thetext = (String) ls.get(i).get("thetext");
			String cds[] = { realname, login_name,bug_when, thetext};
			tableModel.addRow(cds);
		}
		cuep.fitTableColumns(cuep.getCdTable());
	}
	
	private void delToCdTable()
	{
		cuep.delTableColumns(cuep.getCdTable());
	}

}
