import java.io.*;
import java.net.*;
public class TCPServer {

public static void main(String[] args) {
// TODO Auto-generated method stub
       String data=null;//存放接受的字符串
       try{
      ServerSocket ss=new ServerSocket(2222); //写个Socket端口“6666”，随便取的，不过要在0~65535之内（1~1032，是署名端口号，不可挪做他用）
      Socket st=ss.accept();  //创建一个倾听的Socket
      System.out.println("Server has connected");
      BufferedReader in=new BufferedReader(new InputStreamReader(st.getInputStream()));//创建一个从Socket中读文本行的流
      PrintWriter out=new PrintWriter(st.getOutputStream(),true);//创建一个向Socket中写文本行的流，自动刷新
      do{
      data=in.readLine();//读取客户机发送的一行文本
      System.out.println("服务端收到的字符串是："+data);//在屏幕中打印出来
      System.out.println("服务端发回的字符串是："+data);
      out.println(data);
      out.flush();//清空缓存区
      }while(!data.equals("bye"));//接收到“bye”就结束通信
      out.close();//关闭Socket输出流
      in.close();//关闭Socket输入流
      st.close();//关闭Socket
      ss.close();//关闭SocketServer
       }catch(Exception e){
      System.out.println("Whoops!It didn't work!"+e);
       }
}

}