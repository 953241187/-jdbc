package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;
import cn.edu.zucc.util.BusinessException;
import cn.edu.zucc.model.dingdan;
import cn.edu.zucc.model.dingdanxq;
import cn.edu.zucc.model.product;
import cn.edu.zucc.util.BaseException;

public class dingdanxq8 {

	public List<product> loaddingdanxq() throws BaseException{
		List<product> result=new ArrayList<product>();
		//List<dingdanxq> result1=new ArrayList<dingdanxq>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select dingdanxq.product_id,product_name,product_price,ding_conut,user_id\r\n" + 
					"from dingdanxq,product\r\n" + 
					"where dingdanxq.product_id=product.product_id" ;
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){

				product b =new product();
				b.setProduct_id(rs.getString(1));
				b.setProduct_name(rs.getString(2));
				b.setProduct_price(rs.getFloat(3));
				b.setDing_count(rs.getInt(4));
				b.setUser_id(rs.getInt(5));
				result.add(b);
			}
//			st.close();
//			rs.close();
//			sql="insert into dingdan(user_id,manjian_id,qishou_id,address_id) values(?,1,1,1)";
//			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
//			pst=conn.prepareStatement(sql);
//			product b =new product();
//			//pst.setString(1, b.getProduct_id());
//			pst.setInt(1, b.getUser_id());
//			pst.execute();
//			pst.close();
////			sql="select ding_conut from product";
////			java.sql.Statement st1=conn.createStatement();
////			java.sql.ResultSet rs1=st1.executeQuery(sql);
////			while(rs.next()){
////
////				dingdanxq p =new dingdanxq();
////				p.setDing_count(rs.getInt(1));
////				result1.add(p);
////			}
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

	

	public void createding(dingdanxq p,dingdan q) throws BaseException{
		Connection conn=null;
		int user=0;
		try {
			conn=DBUtil.getConnection();
			
			String sql="select user_id from dingdan where dingdan_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, p.getProduct_id());
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				user=rs.getInt(1);
			}
			rs.close();
			
			sql="insert into dingdanxq(product_id,dingdan_id,user_id,ding_conut) values(?,1,?,?)";
			pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getProduct_id());
			pst.setInt(2, user);
			pst.setInt(3, p.getDing_count());
			pst.execute();
			
			sql="intsert into dingdan(user_id,dingdan_id) values(?,?)";
			java.sql.PreparedStatement pst1=conn.prepareStatement(sql);
			pst1=conn.prepareStatement(sql);
			pst.setInt(1, q.getUser_id());
			pst.setInt(2, q.getDingdan_id());
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



	public List<dingdanxq> loaddingdanxq1() throws BaseException{
		
		return null;
	}



	public void createding1(dingdanxq p) throws BaseException{
		Connection conn=null;
		float price=0;
		float huiyuanprice=0;
		float zong=0;
		try {
			conn=DBUtil.getConnection();
			String sql="select product_price from product where product_id=?";
		    java.sql.PreparedStatement pst =conn.prepareStatement(sql);
			pst.setString(1, p.getProduct_id());
			
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()){
				price=rs.getFloat(1);
			}
			rs.close();
//			sql="select ding_conut from prodcut where product_id=?";
//			pst =conn.prepareStatement(sql);
//			pst.setString(1, p.getProduct_id());
//			rs=pst.executeQuery();
//		
			
						
			sql="insert into dingdanxq(product_id,dingdan_id,ding_conut,ding_price,dan_youhui) values(?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getProduct_id());
			pst.setInt(2, p.getDingdan_id());
			pst.setInt(3, p.getDing_count());
			pst.setFloat(4, price);
			pst.setFloat(5, p.getDing_count()*price);
			pst.execute();
			pst.close();
			
			sql="select sum(dan_youhui) from dingdanxq where dingdan_id=?";
			pst =conn.prepareStatement(sql);
			pst.setInt(1, p.getDingdan_id());
			rs=pst.executeQuery();
			while(rs.next()){
				zong=rs.getFloat(1);
			}
			rs.close();
			
			
			sql="update dingdan set yuanshi_money=? where dingdan_id=?";
			pst=conn.prepareStatement(sql);
			pst.setFloat(1,zong);
			pst.setInt(2,p.getDingdan_id());
			pst.execute();
//			pst.close();
			
			
//			sql="insert into dingdan(yuanshi_money) values(?)";
//			pst=conn.prepareStatement(sql);
//			pst.setFloat(1, zong);
////			pst.execute();
////			pst.close();

			
//			sql="select leibie_id from product where product_id=?";
//		    pst =conn.prepareStatement(sql);
//		    
//			rs=pst.executeQuery();
//			while(rs.next()){
//				huiyuanprice=rs.getFloat(1);
//			}
//			rs.close();
			pst.close();
	
			
//			sql="update dingdanxq set ding_price=? where product_id=? and ";
			
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
