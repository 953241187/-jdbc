package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.model.address;
import cn.edu.zucc.model.qishou;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;

public class yaoqiu7 {

	public List<qishou> loadqishou() throws BaseException{
		List<qishou> result=new ArrayList<qishou>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select qishou_id,qishou_name,ruzhi_date,qishou_shengf from qishou order by qishou_id";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				qishou p=new qishou();
				p.setQishou_id(rs.getInt(1));
				p.setQishou_name(rs.getString(2));
				p.setRuzhi_date(rs.getDate(3));
				p.setQishou_shengf(rs.getString(4));
				result.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}

	public void createqishou(qishou p) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into qishou(qishou_id,qishou_name,ruzhi_date,qishou_shengf) values(?,?,?,'新人员工')";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getQishou_id());
			pst.setString(2, p.getQishou_name());
			pst.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
		
	}

	public void deleteQishou(int qishou_id) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from qishou where qishou_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, qishou_id);
			pst.execute();
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

}
