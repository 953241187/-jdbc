package cn.edu.zucc.wai;

import cn.edu.zucc.waimai.comtrol.example.yaoqiu1;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu2;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu3;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu4;
import cn.edu.zucc.waimai.comtrol.example.yaoqiu5;
import cn.edu.zucc.waimai.itf.IPyaoqiu1;
import cn.edu.zucc.waimai.itf.IPyaoqiu2;
import cn.edu.zucc.waimai.itf.IPyaoqiu3;
import cn.edu.zucc.waimai.itf.IPyaoqiu4;
import cn.edu.zucc.waimai.itf.IPyaoqiu5;

public class waimaiUtil {
	public static IPyaoqiu1 qiu1= new yaoqiu1();
	public static IPyaoqiu2 qiu2= new yaoqiu2();
	public static IPyaoqiu3 qiu3= new yaoqiu3();
	public static IPyaoqiu4 qiu4= new yaoqiu4();
	public static IPyaoqiu5 qiu5= new yaoqiu5();
	public static Object userManager;
}
