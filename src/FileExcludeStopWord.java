 import java.io.BufferedReader;
  import java.io.BufferedWriter;
  import java.io.File;
  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.io.FileOutputStream;
  import java.io.InputStreamReader;
  import java.io.OutputStreamWriter;
  import java.util.*;
 
 import org.ictclas4j.bean.SegResult;  
 import org.ictclas4j.segment.SegTag;
 //import ICTCLAS.I3S.AC.ICTCLAS50;
 
 public class FileExcludeStopWord {
     //ͣ�ôʴʱ�
     public static final String stopWordTable = "." + File.separator + "srcFile" + File.separator + "StopWordTable.txt";
 
     public static void main(String[] args) {
 
         //Դ�ļ���Ŀ���ļ�
         String srcFile = "." + File.separator + "srcFile" + File.separator + "����5.txt";
         String destFile = "." + File.separator + "destFile" + File.separator + "����5.txt";
         new FileExcludeStopWord().fileExcludeStopWord(srcFile, destFile);
     }
     
     public void fileExcludeStopWord(String srcFile,String destFile){
         try {
             //��ȡԭ�ļ���ͣ�ôʱ�
             BufferedReader srcFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(srcFile))));
             BufferedReader StopWordFileBr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(stopWordTable))));
             
             //��ȥ��ͣ�ôʵ��ı���Ϣ��������ļ�
             BufferedWriter destFileBw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(destFile))));
             
             //�������ͣ�ôʵļ���
             Set<String> stopWordSet = new HashSet<String>();
             
             //��ʼ��ͣ�ôʼ�
             String stopWord = null;
             for(; (stopWord = StopWordFileBr.readLine()) != null;){
                 stopWordSet.add(stopWord);        
             }            
             
             String paragraph = null;
             for(; (paragraph = srcFileBr.readLine()) != null;){
                 //�Զ�����ı����зִ�
                 SegTag segTag = new SegTag(1);// �ִ�·������Ŀ          
                 SegResult segResult = segTag.split(paragraph);
                 String spiltResultStr = segResult.getFinalResult();    
                 //�õ��ִʺ�Ĵʻ����飬�Ա�����Ƚ�
                 String[] resultArray = spiltResultStr.split(" ");
                                 
                 //����ͣ�ô�            
                 for(int i = 0; i< resultArray.length; i++){
                     //System.out.println(resultArray[i]);
                     if(stopWordSet.contains(resultArray[i])){
                         resultArray[i] = null;
                     }
                     //System.out.println(resultArray[i]);    
                 }
                 
                 //�ѹ��˺���ַ���������뵽һ���ַ�����
                 StringBuffer finalStr = new StringBuffer();
                 for(int i = 0; i< resultArray.length; i++){
                     if(resultArray[i] != null){
                         finalStr = finalStr.append(resultArray[i]).append(" ");
                     }
                 }
                 
                 //�����˺���ı���Ϣд�뵽ָ���ļ���
                 destFileBw.write(finalStr.toString());
                 destFileBw.newLine();
                 //�������ȥͣ�ô�֮��Ľ��
                 System.out.println(finalStr);
             }
             
             //�ر�������
             destFileBw.close();
             StopWordFileBr.close();
             srcFileBr.close();            
             
         } catch (FileNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch(Exception e){
             e.printStackTrace();
        }
     }
}