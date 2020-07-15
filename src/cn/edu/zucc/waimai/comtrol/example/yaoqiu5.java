package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.waimai.comtrol.example.yaoqiu5;

import cn.edu.zucc.model.guanxinxi;
import cn.edu.zucc.util.BusinessException;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;
import cn.edu.zucc.waimai.itf.IPyaoqiu5;

public class yaoqiu5 implements IPyaoqiu5{
	public static guanxinxi currentUser=null;
	public List<guanxinxi> loadAllUsers(boolean withDeletedUser) throws BaseException{
		List<guanxinxi> result=new ArrayList<guanxinxi>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from guanxinxi order by yuangong_id";
			
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				guanxinxi u=new guanxinxi();
				u.setYuangong_id(rs.getInt(1));
				u.setYuangong_name(rs.getString(2));
				u.setPassword(rs.getString(3));
				result.add(u);
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
	
	public void createUser(guanxinxi user)throws BaseException{

		
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from guanxinxi where yuangong_id =?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1,user.getYuangong_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("µÇÂ½ÕËºÅÒÑ¾­´æÔÚ");
			rs.close();
			pst.close();
			sql="insert into guanxinxi(yuangong_id,password,yuangong_name) values(?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, user.getYuangong_id());
			pst.setString(3, user.getYuangong_name());
			pst.setString(2,user.getPassword());//Ä¬ÈÏÃÜÂëÎªÕËºÅ
		
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
	
	


	public guanxinxi loadUser(String userid)throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from guanxinxi where yuangong_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,userid);
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("µÇÂ½ÕËºÅ²» ´æÔÚ");
			guanxinxi u=new guanxinxi();
			u.setYuangong_id(rs.getInt(1));
			u.setYuangong_name(rs.getString(2));
			u.setPassword(rs.getString(3));
		
			rs.close();
			pst.close();
			return u;
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

	public void resetUserPwd(String userid) throws BaseException{
		// TODO Auto-generated method stub
		
	}

	public void deleteUser(String userid) throws BaseException{
		// TODO Auto-generated method stub
		
	}


}