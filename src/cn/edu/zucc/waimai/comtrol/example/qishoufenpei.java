package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.model.manjian;
import cn.edu.zucc.model.qishou;
import cn.edu.zucc.model.qishourz;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;

public class qishoufenpei {

	public List<qishourz> loadqishoufenpei() throws BaseException{
		List<qishourz> result=new ArrayList<qishourz>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select qishou_id,dingdan_id,date,user_comment,user_id from qishourz order by qishou_id";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				qishourz p=new qishourz();
				p.setQishou_id(rs.getInt(1));
				p.setDingdan_id(rs.getInt(2));
				p.setDate(rs.getDate(3));
				p.setUser_comment(rs.getString(4));
				p.setUser_id(rs.getInt(5));
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

	public void createqishoufenpei(qishourz p) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into qishourz(qishou_id,dingdan_id,user_id) values(?,?,0)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getQishou_id());
			pst.setInt(2, p.getDingdan_id());
	
			pst.execute();
			
			sql="update dingdan set qishou_id=? where dingdan_id=?";
			pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getQishou_id());
			pst.setInt(2, p.getDingdan_id());
			
			pst.execute();
//			pst.close();
			
			
			sql="update dingdan set ding_state='骑手配送中' where dingdan_id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,p.getDingdan_id());
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

	public void createqishoupingjia(qishourz p) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update qishourz set user_comment=? where qishou_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getUser_comment());
			pst.setInt(2, p.getQishou_id());
	
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

	public void qishousongda(qishourz qishou) throws BaseException{
		Connection conn=null;
		int count=0;
		int money=0;
		String state="骑手已送达";
		String sheng = null; 
		
		try {
			conn=DBUtil.getConnection();
			String sql="select count(*) from qishourz where qishou_id=?";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);
			pst.setInt(1, qishou.getQishou_id());		
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
			rs.close();
			if(count>=1&&count<3)
			{
				money=2;
				sheng="正式员工";
			}
			else if(count>=3&&count<4)
			{
				money=3;
				sheng="优秀员工";
			}
			else {
				money=4;
				sheng="完美员工";
			}
			
			sql="update qishou set qishou_shengf=? where qishou_id=? ";
			pst=conn.prepareStatement(sql);
			pst.setString(1,sheng);
			pst.setInt(2,qishou.getQishou_id());
			pst.execute();
			
			sql="update qishourz set user_id=? where Dingdan_id=? ";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,money);
			pst.setInt(2,qishou.getDingdan_id());
			pst.execute();
			
			
			
			sql="update dingdan set ding_state=? where Dingdan_id=? ";
			pst=conn.prepareStatement(sql);
			pst.setString(1,state);
			pst.setInt(2,qishou.getDingdan_id());
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
}
