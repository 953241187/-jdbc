package cn.edu.zucc.waimai.comtrol.example;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.edu.zucc.util.DBUtil;
import cn.edu.zucc.util.DbException;
import cn.edu.zucc.model.youhuiquan;
import cn.edu.zucc.util.BaseException;

public class yaoqiu9 {


	public List<youhuiquan> loadyouhui() throws BaseException{
		List<youhuiquan> result=new ArrayList<youhuiquan>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select youhuiquan_id,youhui_money,start_time,hui_end_time from youhuiquan order by youhuiquan_id";
			java.sql.Statement st=conn.createStatement();
			java.sql.ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				youhuiquan p=new youhuiquan();
				p.setYouhuiquan_id(rs.getInt(1));
				p.setYouhui_money(rs.getFloat(2));
				p.setStart_time(rs.getDate(3));
				p.setHui_end_time(rs.getDate(4));
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

	public void deleteyouhuiquan(youhuiquan pub) throws BaseException{
		
	}
		

	public void createyouhui(youhuiquan pub,String a,String b) throws BaseException, ParseException{
		SimpleDateFormat sdf= new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into youhuiquan(youhuiquan_id,youhui_money,jidanyaoqiu,start_time,hui_end_time) values(?,?,1,?,?)";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst=conn.prepareStatement(sql);
			pst.setInt(1, pub.getYouhuiquan_id());
			pst.setFloat(2,pub.getYouhui_money());
			java.util.Date psDate=sdf.parse(a);
			java.util.Date pfDate=sdf.parse(b);
			pst.setDate(3,new java.sql.Date(psDate.getTime()) );
			pst.setDate(4,new java.sql.Date( pfDate.getTime()));
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

	public void deleteyouhuiquan(int youhuiquan_id)  throws BaseException{
		// TODO Auto-generated method stub
		
	}
	}
