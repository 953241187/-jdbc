package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.edu.zucc.model.dingdan;
import cn.edu.zucc.model.manjian;
import cn.edu.zucc.model.user;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;

public class yaoqiu11 {

	public void createdingdan(dingdan p) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql="insert into dingdan(dingdan_id,user_id,address_id,Ding_state,pingjia_time) values(?,?,?,'选购中',?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getDingdan_id());
			pst.setInt(2, p.getUser_id());
			pst.setInt(3, p.getAddress_id());
			pst.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));
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
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void createpingjia(dingdan p) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update dingdan set pingjia_comment=? where dingdan_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getPingjia_comment());
			pst.setInt(2, p.getDingdan_id());
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

	public void querenxiadan(dingdan ding) throws BaseException{
		
		Connection conn=null;
//		int manjianid;
//		float manjianmoney=0;
//		float youhuimoney=0;
		int i=0;
		int j=0;
		float yuanshimoney=0;
		float jiesuanmoney=0;
		int manjianid[] = new int[100];
		float manjianmoney[] =new float [100];
		float youhuimoney[]=new float [100];
		
		try {
			conn=DBUtil.getConnection();
			String sql="select manjian_id,manjian_money,youhui_money from manjian order by manjian_money desc";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){

				
				manjianid[i]=rs.getInt(1);
				manjianmoney[i]=rs.getFloat(2);
				youhuimoney[i]=rs.getFloat(3);
				i++;
			}
			rs.close();
			
			sql="select yuanshi_money,jiesuan_money from dingdan where dingdan_id=? ";
			java.sql.PreparedStatement pst =conn.prepareStatement(sql);
			pst.setInt(1, ding.getDingdan_id());
			
			rs=pst.executeQuery();
			while(rs.next()){
				yuanshimoney=rs.getFloat(1);
				jiesuanmoney=rs.getFloat(2);
				for(j=0;j<i;j++)
				{
					if(yuanshimoney>=manjianmoney[j])
					{
						jiesuanmoney=jiesuanmoney-youhuimoney[j];
						break;
					}
				}
			}
			rs.close();
			
			sql="update dingdan set jiesuan_money=?,manjian_id=? where dingdan_id=?";
			pst=conn.prepareStatement(sql);
			pst.setFloat(1,jiesuanmoney);
			pst.setFloat(2,manjianid[j]);
			pst.setInt(3,ding.getDingdan_id());
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

	public void huiyuanchongzhi(user user) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update user set shifouhuiyuan=? where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setInt(2,user.getUser_id());
	
			pst.execute();
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


	public void quxiaodingdan(dingdan ding) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update dingdan set ding_state=? where dingdan_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setString(1, "订单已经取消");
			pst.setInt(2,ding.getDingdan_id());
			pst.execute();
			
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

	public void jieshoudingdan(dingdan ding)  throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update dingdan set ding_state=? where dingdan_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setString(1, "商家已接单");
			pst.setInt(2,ding.getDingdan_id());
			pst.execute();
			
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
