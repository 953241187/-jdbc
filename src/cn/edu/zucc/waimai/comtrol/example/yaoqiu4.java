package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;
import cn.edu.zucc.util.BusinessException;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.model.user;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.itf.IPyaoqiu4;

public class yaoqiu4 implements IPyaoqiu4{

	public List<user> loadAllUsers() throws BaseException{
			List<user> result=new ArrayList<user>();
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select user_id,user_name,user_sex,phone_number,email,city,zhuce_time,shifouhuiyuan from user order by user_id";
				java.sql.Statement st=conn.createStatement();
				java.sql.ResultSet rs=st.executeQuery(sql);
				while(rs.next()){
					user p=new user();
					p.setUser_id(rs.getInt(1));
					p.setUser_name(rs.getString(2));
					p.setUser_sex(rs.getString(3));
					p.setPhone_number(rs.getString(4));
					p.setEmail(rs.getString(5));
					p.setCity(rs.getString(6));
					p.setZhuce_time(rs.getDate(7));
					p.setShifouhuiyuan(rs.getInt(8));
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

	public void createuser(user p) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into user(user_id,user_name,user_sex,phone_number,email,city) values(?,?,?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getUser_id());
			pst.setString(2, p.getUser_name());
			pst.setString(3,p.getUser_sex());
			pst.setString(4,p.getPhone_number());
			pst.setString(5,p.getEmail());
			pst.setString(6,p.getCity());
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

	public void modifyPublisher(user p)throws BaseException {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update  user set user_name=?,user_sex=?, phone_number=?,email=?,city=? where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getUser_name());
			pst.setString(2,p.getUser_sex());
			pst.setString(3, p.getPhone_number());
			pst.setString(4,p.getEmail());
			pst.setString(5,p.getCity());
			pst.setInt(6, p.getUser_id());
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

	public void deleteuser(int id) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from user where user_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
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

	public void modifyproductor(productor p) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update  productor set productor_name=?,productor_star=? where productor_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setString(3, p.getProductor_id());
			pst.setString(1,p.getProductor_name());
			pst.setString(2, p.getProductor_star());
			
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
