package com.tba.form;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.ictclas4j.bean.SegResult;
import org.ictclas4j.segment.SegTag;

import com.tba.analyzer.AttributePick;
import com.tba.analyzer.HospitalMatch;
import com.tba.analyzer.ResultRank;
import com.tba.db.DBConnTB;
import com.tba.db.DBTieba;
import com.tba.db.DBfinalresult;
import com.tba.db.DBresult;
import com.tba.spider.ReadDate;

//����
public class Main {

	public static void main(String[] args) throws Exception {

		UserInterfaceForm mf = new UserInterfaceForm();
		DBConnTB db = new DBConnTB();
		DBTieba dbt = new DBTieba();
		DBresult dbr = new DBresult();
		DBfinalresult dbf = new DBfinalresult();
		HospitalMatch mt = new HospitalMatch();
		//ResultRank rr = new ResultRank();
		


		
       //ƥ��ҽԺ��Ϣ
		mt.select();
		//rr.ranking();
		//rr.PN();
	
		
		//������յĽ��
		String sql = "select * from finalresult  order by rate desc";
		ResultSet rs = db.executeQuery(sql);
		String finalresult = "";
		
		while (rs.next()) {

			finalresult += rs.getString(3) + "\t\t\t"
					+ String.valueOf(rs.getInt(4)) + "  "
					+ String.valueOf(rs.getInt(5)) + "  " + rs.getString(2)
					+ "\n";
			System.out.println(finalresult);
		}

		//��ʾ���
		//mf.showtext(finalresult);

	/*	
		DBTieba tb=new DBTieba();
		tb.Input("��������");
		tb.Input("1������");
		tb.Input("��������");
		tb.Input("�������ҿ���");
		tb.Input("������ʳ");
		tb.Input("һ������");
		tb.Input("����a");
		tb.Input("2������");
		tb.Input("����ʳ��");
		tb.Input("����ʳƷ");
		tb.Input("�����۲�");
		tb.Input("1������");
	*/
	}

}
