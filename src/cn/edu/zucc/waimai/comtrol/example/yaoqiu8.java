package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.model.manjian;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.model.qishou;
import cn.edu.zucc.model.user;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;

public class yaoqiu8 {

	public List<manjian> loadmanjian() throws BaseException{
		List<manjian> result=new ArrayList<manjian>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select manjian_id,manjian_money,youhui_money,shifou from manjian order by manjian_id";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				manjian p=new manjian();
				p.setManjian_id(rs.getInt(1));
				p.setManjian_money(rs.getFloat(2));
				p.setYouhui_money(rs.getFloat(3));
				p.setShifou(rs.getInt(4));
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

	public void deletemanjian(int manjian_id)throws BaseException {
		// TODO Auto-generated method stub
		
	}

	public void createmanjian(manjian pub)throws BaseException  {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into manjian(manjian_id,manjian_money,youhui_money,shifou) values(?,?,?,1)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, pub.getManjian_id());
			pst.setFloat(2,pub.getManjian_money());
			pst.setFloat(3,pub.getYouhui_money());
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
