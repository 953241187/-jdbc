package cn.edu.zucc.util;

import cn.edu.zucc.util.BaseException;

public class DbException extends BaseException {
	public DbException(java.lang.Throwable ex){
		super("���ݿ��������"+ex.getMessage());
	}
}

