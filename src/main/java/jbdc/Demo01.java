package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Demo01 {
    public static void main(String[] args) {

        //thong so ket noi
        String url = "jdbc:mysql://localhost:3306/lib?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "root";
        String pass = "Passw0rd";

        try{
            //1.Load driver MySQL
            Class.forName("com.mysql.jdbc.Driver");

            //2. mo ket noi
            Connection conn = DriverManager.getConnection(url, user, pass);

            //3. kiem tra ket noi
            if(conn != null){
                System.out.println("Connection Successful");
            }else {
                System.out.println("Connection Failed");
            }

            //4. Dong ket noi
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
