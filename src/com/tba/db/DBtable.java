package com.tba.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBtable {
	//����
	public DBtable() throws SQLException {

	}
	//���ݸ���
	public void Updata(String sql) throws SQLException{
		DBConnTB db = new DBConnTB();

		db.executeUpdate(sql);
		
	}
	//���ݵ���
	public ResultSet Output(String table){
		
		DBConnTB dbtb = new DBConnTB();
		ResultSet rs=dbtb.executeQuery("select * from "+table);
		dbtb.close();
		return rs;
		
	}
	//�ع���
	public void reBuild() throws SQLException{
		DBConnTB dbtb = new DBConnTB();
		String sql="";
		dbtb.executeUpdate(sql);
		dbtb.close();
	}
	//�����������
	public void Clearup() throws SQLException{
		
	}


}
