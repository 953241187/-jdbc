package cn.edu.zucc.waimai.comtrol.example;

import cn.edu.zucc.util.BaseException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.util.BusinessException;
import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;
import cn.edu.zucc.model.product;
import cn.edu.zucc.waimai.itf.IPyaoqiu2;

public class yaoqiu2 implements IPyaoqiu2{

	public void createBook(product b)  throws BaseException {
		//if(b.getProduct_id()==null || "".equals(b.getProduct_id()) || b.getProduct_id().length()>20){
			//throw new BusinessException("条码必须是1-20个字");
		//}
		//if(b.getProduct_name()==null || "".equals(b.getProduct_name()) || b.getProduct_name().length()>50){
			//throw new BusinessException("图书名称必须是1-50个字");
		//}
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from product where product_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, b.getProduct_id());
			java.sql.ResultSet rs=pst.executeQuery();
			//if(rs.next()) throw new BusinessException("条码已经被占用");
			rs.close();
			pst.close();
			sql="insert into product(product_id,product_name,productor_id,product_price,Leibie_id,youhui_name) values(?,?,?,?,?,'上架中')";
			pst=conn.prepareStatement(sql);
			pst.setString(1, b.getProduct_id());
			pst.setString(2, b.getProduct_name());
			pst.setString(3, b.getProductor_id());
			pst.setFloat(4, b.getProduct_price());
			pst.setInt(5, b.getLeibie_id());
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

	public void modifyBook(product b) throws BaseException  {
		if(b.getProduct_name()==null || "".equals(b.getProduct_name()) || b.getProduct_name().length()>50){
			throw new BusinessException("商品名称必须是1-50个字");
		}
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from product where product_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, b.getProduct_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(!rs.next()) throw new BusinessException("商品不存在");
			rs.close();
			pst.close();
			sql="update product set product_name=?,productor_id=?,product_price=?,youhui_name=? where product_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,b.getProduct_name());
			pst.setString(2, b.getProductor_id());
			pst.setDouble(3,b.getProduct_price());
			pst.setString(4, b.getYouhui_name());
			pst.setString(5, b.getProduct_id());
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
		public List<product> searchproduct(String keyword, String bookState) throws BaseException{
			List<product> result=new ArrayList<product>();
			Connection conn=null;
			try {
				conn=cn.edu.zucc.util.DBUtil.getConnection();
				String sql="select b.product_id,b.product_name,b.productor_id,b.product_price,b.youhui_name,p.productor_name,leibie_id " +
						" from product b left outer join productor p on (b.productor_id=p.productor_id)" +
						" where  b.youhui_name='"+bookState+"' ";
				if(keyword!=null && !"".equals(keyword))
					sql+=" and (b.product_name like ? or b.product_id like ?)";
				sql+=" order by b.product_id";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				if(keyword!=null && !"".equals(keyword)){
					pst.setString(1, "%"+keyword+"%");
					pst.setString(2, "%"+keyword+"%");
					
				}
					
				java.sql.ResultSet rs=pst.executeQuery();
				while(rs.next()){
					product b=new product();
					b.setProduct_id(rs.getString(1));
					b.setProduct_name(rs.getString(2));
					b.setProductor_id(rs.getString(3));
					b.setProduct_price(rs.getFloat(4));
					b.setYouhui_name(rs.getString(5));
					b.setProductor_name(rs.getString(6));
					b.setLeibie_id(rs.getInt(7));
					result.add(b);
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

		public void deleteproduct(product book) throws BaseException {
			// TODO Auto-generated method stub
			
		}
		
	}


