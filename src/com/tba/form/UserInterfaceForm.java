package com.tba.form;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.tba.db.DBTieba;
import com.tba.spider.ReadDate;

public class UserInterfaceForm extends JFrame {

	JTextArea textShow;
	JTextField textEdit;
	boolean flag = true ;
	public UserInterfaceForm() {
		super("�ҵĴ���");
		this.setBounds(100, 100, 560, 390);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setResizable(false);
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JTextField textField = new JTextField();
		textField.setBorder(null);
		panel1.add(textField);
		panel1.add(new JLabel("���ɣ�"));
		textEdit = new JTextField(20);
		textEdit.setText("��������������");
		panel1.add(textEdit);
		JButton btn = new JButton("����");

		panel1.add(btn);
		this.add(panel1,"North");
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		textShow = new JTextArea(16,50);
		textShow.setLineWrap(true);
		textShow.setWrapStyleWord(true);
		panel2.add(new JScrollPane(textShow));
		this.add(panel2,"Center");
		btn.requestFocus(true);
		btn.addActionListener(new MyActionListenser());
		textEdit.addFocusListener(new MyFocusListenser());
		this.setVisible(true);
	}
	//תΪURL
	private String strToURL(String str){
		str = str.replace("��", "");
		str = str.replace("��", "");
		return "http://tieba.baidu.com/f?kw="+str;
	}
	//��������Ƿ�Ϸ�
	private boolean checkStr(String str){
		int length = str.length();
		for(int i=0;i<length;i++){
			char ch = str.charAt(i);
			if (!( ch >= 'A' && ch <= 'z' // ��ĸ
					|| ch >= '\u4E00' && ch <= '\u9FA5'//����
					|| ch >= '0' && ch <= '9')){
				return false;
			}
		}
		return true;
	}
	//���URL�Ƿ����
	private boolean URLexists(String URLName) {
		try {

			//���ô����Ƿ�Ӧ���Զ�ִ�� HTTP �ض�����Ӧ����Ϊ 3xx �����󣩡�

			HttpURLConnection.setFollowRedirects(false);

			//�� URL �����õ�Զ�̶��������

			HttpURLConnection con = (HttpURLConnection) new URL(URLName).openConnection();

			/* ���� URL ����ķ����� GET POST HEAD OPTIONS PUT DELETE TRACE ���Ϸ���֮һ�ǺϷ��ģ�����ȡ����Э������ơ�*/

			con.setRequestMethod("HEAD");

			//�� HTTP ��Ӧ��Ϣ��ȡ״̬��(HttpURLConnection.HTTP_OK=200,˵��������URL)

			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);

		} catch (Exception e) {

			e.printStackTrace();

			return false;

		}
	}
	//�������ı���
	private class MyFocusListenser implements FocusListener{

		public void focusGained(FocusEvent e) {
			if (!textEdit.getText().equals("") && flag) {
				textEdit.setText("");
				flag = false ;
			}

		}

		
		public void focusLost(FocusEvent e) {
			if (textEdit.getText().equals("")) {
				textEdit.setText("��������������");
				flag = true ;
			}
		}

	}
    //���� �ռ�������Ϣ  ����DBTieba����
	private class MyActionListenser implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			if (!checkStr(textEdit.getText())) {
				JOptionPane.showMessageDialog(null,
						"ֻ�����뺺�֡����ֺ���ĸ", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			}else {
				String URL = strToURL(textEdit.getText());
				if (URLexists(URL)) {
//					JOptionPane.showMessageDialog(null,"���ɴ���", "��ʾ��Ϣ",
//							JOptionPane.INFORMATION_MESSAGE);
					
					//DBTieba dbt=new DBTieba();
					try {
						//dbt.Build();
						//dbt.Input(textEdit.getText().toString());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null,"���ɲ�����", "��ʾ��Ϣ",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

	}
	
	public  void showtext(String s){
    	
    	
    	textShow.append(s+"\n");
    	
    	
    }


}
  
