import java.io.*;
import java.net.*;
public class TCPClient {
    
public static void main(String[] args) {
// TODO Auto-generated method stub
       String data=null;
       String kdata=null;
       try{
      Socket st=new Socket("192.168.1.106",6666);//向服务器发起连接,本机IP
      PrintWriter out=new PrintWriter(st.getOutputStream(),true);//创建一个向Socket中写文本行的流，自动刷新
      
      BufferedReader in=new BufferedReader(new InputStreamReader(st.getInputStream()));//创建一个从socket中读文本行的流
      BufferedReader kin=new BufferedReader(new InputStreamReader(System.in));//创建一个键盘读文本行的流
      
      do{
      System.out.print("客户端发出的字符串：");
      kdata=kin.readLine();//从键盘中读取一行字符
      out.println(kdata);//向服务器发送过去
      data=in.readLine();//读取服务器的响应
      System.out.println("客户端收到的字符串："+data);
      out.flush();//清除缓存区
      }while(!kdata.equals("bye"));//发送“bye”就结束通信
      out.close();//关闭Socket输出流
      in.close();//关闭Socket输入流
      st.close();
       }catch(Exception e) {
      System.out.println("Whoops!It didn't work!"+e);
       }
       
}


}