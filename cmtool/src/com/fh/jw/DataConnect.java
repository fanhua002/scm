package com.fh.jw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author fanhua</br>
 * @date 2015-07-29
 * 
 */
public class DataConnect {
	private static ResultSet rs;

	public static void main(String[] args) throws SQLException {
		System.out.println(DataConnect.getListFromRsforUsername("fanhua"));
	}

	/**
	 * 写一个连接数据库的方法
	 */
	public static Connection getConnection_config_manage() {
		String userName = "root";
		String passwrod = "scm_dqa_2016";
		String url = "jdbc:mysql://172.20.5.148:3306/config_manage";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("找不到驱动！");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, userName, passwrod);
			if (conn != null) {
				// System.out.println("connection successful");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("connection fail");
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 查询xgd_release表得到所有结果集存储到list中
	 * 
	 * @return List 查询的结果集
	 * @throws SQLException
	 */
	static List<Map<String, Object>> getListFromRsfor_xgd_release()
			throws SQLException {
		String sql = "select *from xgd_release order by sysid";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			Connection conn = getConnection_config_manage();
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();// 得到结果集列的属性
			int columns = md.getColumnCount();// 得到记录有多少列
			int i;
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (i = 0; i < columns; i++) {
					map.put(md.getColumnName(i + 1),
							getValueByType(rs, md.getColumnType(i + 1),
									md.getColumnName(i + 1)));
				}
				list.add(map);
			}
			// 关闭记录集
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭声明
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭链接对象
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据sysid查询，得到结果集存储到list中
	 * 
	 * @param sysid
	 * @return List 查询的结果集
	 * @throws SQLException
	 */
	static List<Map<String, Object>> getListFromRsfor_xgd_release(
			String syschild) throws SQLException {
		String sql = "select *from xgd_release where sysid='"
				+ syschild.toString() + "'";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			Connection conn = getConnection_config_manage();
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();// 得到结果集列的属性
			int columns = md.getColumnCount();// 得到记录有多少列
			int i;
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (i = 0; i < columns; i++) {
					map.put(md.getColumnName(i + 1),
							getValueByType(rs, md.getColumnType(i + 1),
									md.getColumnName(i + 1)));
				}
				list.add(map);
			}
			// 关闭记录集
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭声明
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭链接对象
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据系统名（对应的表名）、子系统名（对应到表名里面的sysid字段）查询，得到结果集存储到list中
	 * 
	 * @param sys
	 * @param syschild
	 * @return List 查询的结果集
	 * @throws SQLException
	 */
	static List<Map<String, Object>> getListFromRs(String sys, String syschild)
			throws SQLException {
		String sql = "select *from " + sys + " where sysid='"
				+ syschild.toString() + "'";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			Connection conn = getConnection_config_manage();
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();// 得到结果集列的属性
			int columns = md.getColumnCount();// 得到记录有多少列
			int i;
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (i = 0; i < columns; i++) {
					map.put(md.getColumnName(i + 1),
							getValueByType(rs, md.getColumnType(i + 1),
									md.getColumnName(i + 1)));
				}
				list.add(map);
			}
			// 关闭记录集
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭声明
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭链接对象
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 插入记录到xgdrelease表中
	 * 
	 * @param XgdReleaseBean
	 * @return row是否插入成功
	 * @throws SQLException
	 */
	static int addRsforxgdrelease(XgdReleaseBean xgdrel) {
		int row = 0;
		String sql = "insert into xgd_release(sysid,codepath,buildpath,tagpath,testpath,releasepath,trunkpath) values(?,?,?,?,?,?,?)";
		try {
			Connection conn = getConnection_config_manage();// 连接数据库
			PreparedStatement ps = conn.prepareStatement(sql);// 2.创建Satement并设置参数
			// rs=ps.executeQuery(); // 3.ִ执行SQL语句,緊緊用于查找語句
			// sql語句中寫了幾個字段，下面就必須要有幾個字段
			ps.setString(1, xgdrel.getSysid());
			ps.setString(2, xgdrel.getCodepath());
			ps.setString(3, xgdrel.getBuildpath());
			ps.setString(4, xgdrel.getTagpath());
			ps.setString(5, xgdrel.getTestpath());
			ps.setString(6, xgdrel.getReleasepath());
			ps.setString(7, xgdrel.getTrunkpath());
			// 4.处理结果集
			row = ps.executeUpdate();
			// 关闭声明
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭链接对象
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	/**
	 * 修改xgdrelease表中trunkpath字段记录
	 * @param XgdReleaseBean
	 * @return row是否更新成功
	 * @throws SQLException
	 */
	static int updateTrunkpath(XgdReleaseBean t) {
		int row = 0;
		String sql = "update xgd_release set trunkpath=? where sysid=?";
		try {
			Connection conn = getConnection_config_manage();// 连接数据库
			PreparedStatement ps = conn.prepareStatement(sql);// 2.创建Satement并设置参数
			ps.setString(1, t.getTrunkpath());
			ps.setString(2, t.getSysid());
			row = ps.executeUpdate();
			// 关闭声明
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭链接对象
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}

	/***
	 * 
	 * @param rs
	 *            查询出来的结果集
	 * @param type
	 *            SQL type from java.sql.Types
	 * @param name
	 *            数据库记录所对应的字段名称
	 * @return 返回一条记录的一个列值
	 * @throws SQLException
	 */
	private static Object getValueByType(ResultSet rs, int type, String name)
			throws SQLException {
		switch (type) {
		case Types.NUMERIC:
			return rs.getLong(name);
		case Types.VARCHAR:
			// if(rs.getString(name)==null){
			// return "";
			// }
			return rs.getString(name);
		case Types.DATE:
			// if(rs.getDate(name)==null){
			// return System.currentTimeMillis();
			// }
			return rs.getDate(name);
		case Types.TIMESTAMP:
			return rs
					.getTimestamp(name)
					.toString()
					.substring(0, rs.getTimestamp(name).toString().length() - 2);
		case Types.INTEGER:
			return rs.getInt(name);
		case Types.DOUBLE:
			return rs.getDouble(name);
		case Types.FLOAT:
			return rs.getFloat(name);
		case Types.BIGINT:
			return rs.getLong(name);
		default:
			return rs.getObject(name);
		}
	}

	/**
	 * 根据bugid查询，得到结果集存储到list中
	 * 
	 * @param bugid
	 * @return List 查询的结果集
	 * @throws SQLException
	 */
	static List<Map<String, Object>> getListFromRs(String bugid)
			throws SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String dbName = "bugs2";
		String userName = "root";
		String passwrod = "svnserver";
		String url = "jdbc:mysql://172.17.3.161:3306/" + dbName;
		String sql = "select profiles.login_name, profiles.realname, longdescs.bug_when, longdescs.thetext from longdescs, profiles where profiles.userid = longdescs.who and longdescs.bug_id = "
				+ bugid + " order by longdescs.bug_when";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName,
					passwrod);
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData md = rs.getMetaData();// 得到结果集列的属性
			int columns = md.getColumnCount();// 得到记录有多少列
			int i;
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (i = 0; i < columns; i++) {
					map.put(md.getColumnName(i + 1),
							getValueByType(rs, md.getColumnType(i + 1),
									md.getColumnName(i + 1)));
				}
				list.add(map);
			}
			// 关闭记录集
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭声明
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭链接对象
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据用户名进行查询，得到userid
	 * 
	 * @param username
	 * @return userid 查询的结果
	 * @throws SQLException
	 */
	static String getListFromRsforUsername(String username)
			throws SQLException {
		String driver = "com.mysql.jdbc.Driver";
		String dbName = "config_manager";
		String userName = "root";
		String passwrod = "test1234";
		String url = "jdbc:mysql://172.17.3.103:3310/" + dbName;
		String sql = "select *from userinfo where username='"+username+"';";
		String restrid="";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName,
					passwrod);
			PreparedStatement ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				restrid=rs.getString("userid");
			}
			// 关闭记录集
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭声明
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// 关闭链接对象
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return restrid;
	}
}
