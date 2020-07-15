package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.model.dingdan;
import cn.edu.zucc.model.youhuichiyou;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;

public class yaoqiu10 {

	public List<youhuichiyou> loadlingquan() throws BaseException{
		List<youhuichiyou> result=new ArrayList<youhuichiyou>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select youhuiquan_id,user_id,dingdan_id \r\n" + 
					"from youhuichiyou \r\n" + 
					"order by youhuiquan_id";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				youhuichiyou p=new youhuichiyou();
				p.setYouhuiquan_id(rs.getInt(1));
				p.setUser_id(rs.getInt(2));
				p.setDingdan_id(rs.getInt(3));
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

	public void createlingquan(youhuichiyou p) throws BaseException{
		Connection conn=null;
		float money=0;
		float yuanshimoney=0;
		try {
			conn=DBUtil.getConnection();
		
			String sql="insert into youhuichiyou(youhuiquan_id,user_id,dingdan_id,productor_id) values(?,?,?,1)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getYouhuiquan_id());
			pst.setInt(2, p.getUser_id());
			pst.setInt(3, p.getDingdan_id());
			pst.execute();
//			pst.close();
			
			sql="update dingdan set youhuiquan_id=? where dingdan_id=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1,p.getYouhuiquan_id());
			pst.setInt(2, p.getDingdan_id());
			pst.execute();
//			pst.close();
			
			
			sql="select youhui_money from youhuiquan where youhuiquan_id=?";
			pst =conn.prepareStatement(sql);
			pst.setInt(1, p.getYouhuiquan_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				money=rs.getFloat(1);
			}
			rs.close();
			
			
			sql="select yuanshi_money from dingdan where dingdan_id=?";
			pst =conn.prepareStatement(sql);
			pst.setInt(1, p.getDingdan_id());
			
			rs=pst.executeQuery();
			while(rs.next()){
				yuanshimoney=rs.getFloat(1);
			}
			rs.close();
			
			sql="update dingdan set jiesuan_money=? where dingdan_id=?";
			pst=conn.prepareStatement(sql);
			pst.setFloat(1,yuanshimoney-money);
			pst.setInt(2,p.getDingdan_id());
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
