package com.tba.analyzer;

/*
 ���ѷִʵ��ֶ�  ����������ȡ  ����ȡ����,����,���ݴʵȴ�
 
  ��/r ��/v 100/m ��/q ƻ��/n "
   m
   100
 */
public class AttributePick {

	private String resultstr = "";
	private String midstr = "";
	private String judgestr = "";
	private int former = 0;
	private int later = 0;

	public String picking(String Sourcestr, String attribute) {

		resultstr = "";
		while (Sourcestr.indexOf("/") != -1) {

			former = Sourcestr.indexOf("/");
			midstr = Sourcestr.substring(0, former + 1);

			Sourcestr = Sourcestr.substring(former);
			later = Sourcestr.indexOf(" ");

			judgestr = Sourcestr.substring(0, later);

			if (judgestr.contains(attribute)) {
				resultstr = resultstr + midstr;
			}
			Sourcestr = Sourcestr.substring(later + 1);

		}
		return resultstr;

	}
}
