package com.tba.analyzer;


public class OrderToMatch {
	private  double count=0;
	private double rate=0;

   //���������ֶε�ѭ��ƥ��   ������count��ƥ���������� ��rate��ƥ���ʣ�����
	public void ordertomatch(String source,String[] array){
		int index=0;

		setCount(0);setRate(0);
		for(int i=0;i<array.length;i++){
			index=source.indexOf(array[i]);
			if(index!=-1){
				source=source.substring(index+array[i].length());
				count++;
			}
		}
		setRate(count/array.length);

	}
	

	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count= count;
	}
}
