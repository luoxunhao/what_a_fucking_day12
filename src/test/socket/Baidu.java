package test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Baidu {
    public static void main(String args[]) throws UnknownHostException, IOException{
        try {
            Socket s = new Socket("localhost",8080); // localhost 8080
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
            OutputStream out = s.getOutputStream();
            StringBuffer sb = new StringBuffer("GET /seckill/time/now HTTP/1.1\r\n");  // GET /HelloSpringMVC/seckill/time/now
            //sb.append("User-Agent: Java/1.6.0_20\r\n");
            sb.append("Host: localhost:8080\r\n");
            sb.append("Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2\r\n");
            sb.append("Connection: Close\r\n");
            sb.append("\r\n");
            out.write(sb.toString().getBytes());
            String json ="";
            String tmp = "";
            while((tmp = br.readLine())!=null){
                System.out.println(tmp);
                json += tmp;
            }

            System.out.println(json);
            out.close();
            br.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   