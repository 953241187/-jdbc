package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;
import cn.edu.zucc.model.address;
import cn.edu.zucc.util.BaseException;

public class yaoqiu6 {

	public List<address> loadaddress() throws BaseException {
		List<address> result=new ArrayList<address>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select address_id,province,city,area,address,link_people,phone from address order by address_id";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				address p=new address();
				p.setAddress_id(rs.getInt(1));
				p.setProvince(rs.getString(2));
				p.setCity(rs.getString(3));
				p.setArea(rs.getString(4));
				p.setAddress(rs.getString(5));
				p.setLink_people(rs.getString(6));
				p.setPhone(rs.getString(7));
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

	public void createaddress(address p) throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into address(address_id,province,city,area,address,link_people,phone) values(?,?,?,?,?,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, p.getAddress_id());
			pst.setString(2, p.getProvince());
			pst.setString(3,p.getCity());
			pst.setString(4,p.getArea());
			pst.setString(5,p.getAddress());
			pst.setString(6,p.getLink_people());
			pst.setString(7,p.getPhone());
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

	public void deleteaddress(int address_id)  throws BaseException{
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from address where address_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, address_id);
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
