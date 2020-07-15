package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;
import cn.edu.zucc.util.BusinessException;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.itf.IPyaoqiu3;

public class yaoqiu3 implements IPyaoqiu3{

	public List<productor> loadAllPublisher()throws BaseException {
		List<productor> result=new ArrayList<productor>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select productor_id,productor_name,productor_star from productor order by productor_id";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				productor p=new productor();
				p.setProductor_id(rs.getString(1));
				p.setProductor_name(rs.getString(2));
				p.setProductor_star(rs.getString(3));
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

	public void deletePublisher(String id) throws BaseException  {
		if(id==null || "".equals(id) ||id.length()>20){
			throw new BusinessException("商家编号必须是1-20个字");
		}
			Connection conn=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select productor_name from productor where productor_id=?";
				java.sql.PreparedStatement pst=conn.prepareStatement(sql);
				pst.setString(1, id);
				java.sql.ResultSet rs=pst.executeQuery();
				if(!rs.next()) throw new BusinessException("商家不存在");
				String publisherName=rs.getString(1);
				rs.close();
				pst.close();
				sql="select count(*) from product where productor_id=?";
				pst=conn.prepareStatement(sql);
				pst.setString(1, id);
				rs=pst.executeQuery();
				rs.next();
				int n=rs.getInt(1);
				pst.close();
				pst=conn.prepareStatement("delete from productor where productor_id=?");
				pst.setString(1, id);
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

	public void createPublisher(productor p) throws BaseException {
		if(p.getProductor_id()==null || "".equals(p.getProductor_id()) || p.getProductor_id().length()>20){
			throw new BusinessException("商家编号必须是1-20个字");
		}
		if(p.getProductor_name()==null || "".equals(p.getProductor_name()) || p.getProductor_name().length()>50){
			throw new BusinessException("商家名称必须是1-50个字");
		}
		//if(p.getProductor_star()==null || "".equals(p.getAddress()) || p.getAddress().length()>100){
			//throw new BusinessException("出版地址必须是1-100个字");
		//}
		
		
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from productor where productor_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,p.getProductor_id());
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("商家编号已经被占用");
			rs.close();
			pst.close();
			sql="select * from productor where productor_name=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getProductor_name());
			rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("商家名称已经存在");
			rs.close();
			pst.close();
			sql="insert into productor(productor_id,productor_name,productor_star) values(?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getProductor_id());
			pst.setString(2, p.getProductor_name());
			pst.setString(3,p.getProductor_star());
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

	public void deletemanjian(int manjian_id)  throws BaseException{
		// TODO Auto-generated method stub
		
	}
}