package cn.edu.zucc.waimai.itf;

import java.util.List;

import cn.edu.zucc.model.product;
import cn.edu.zucc.model.productor;
import cn.edu.zucc.util.BaseException;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu1;

public interface IPyaoqiu1 {
	


	List<product> searchproduct(String text, String string) throws BaseException;;

}
