package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;
import cn.edu.zucc.model.dingdan;
import cn.edu.zucc.model.manjian;
import cn.edu.zucc.model.product;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.util.BaseException;

public class dingdan9 {

	public List<dingdan> loadalldingdan() throws BaseException{
		List<dingdan> result=new ArrayList<dingdan>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select dingdan_id,user_id,yuanshi_money,qishou_id,youhuiquan_id,jiesuan_money,address_id,Ding_state,pingjia_time,pingjia_comment,manjian_id from dingdan order by dingdan_id";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				dingdan p=new dingdan();
				p.setDingdan_id(rs.getInt(1));
				p.setUser_id(rs.getInt(2));
				p.setYuanshi_money(rs.getFloat(3));
				p.setQishou_id(rs.getInt(4));
				p.setYouhuiquan_id(rs.getInt(5));
				p.setJiesuan_money(rs.getFloat(6));
				p.setAddress_id(rs.getInt(7));
				p.setDing_state(rs.getString(8));
				p.setPingjia_time(rs.getDate(9));
				p.setPingjia_comment(rs.getString(10));
				p.setManjian_id(rs.getInt(11));
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

	public void createtime() throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into dingdan(pingjia_time) values(?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
			
			pst.execute();
			pst.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void querenxiadan() throws BaseException{
		List<manjian> result=new ArrayList<manjian>();
		Connection conn=null;
		float manjianmoney=0;
		float youhuimoney=0;
		try {
			conn=DBUtil.getConnection();
			String sql="select manjian_id,manjian_money,youhui_money from manjian oder by manjianmoney desc";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){

				manjian b =new manjian();
				b.setManjian_id(rs.getInt(1));
				manjianmoney=rs.getFloat(2);
				youhuimoney=rs.getFloat(3);
				result.add(b);
			}
			rs.close();
			sql="select yuanshi_monney from dingdan ";
			
			
			
			
			
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