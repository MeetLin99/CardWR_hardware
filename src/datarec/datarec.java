package datarec;
import java.sql.*;
import java.io.*;
import java.util.Scanner;

class DbUtil {
    private String url="jdbc:mysql://localhost:3306/cardwr?serverTimezone=UTC&characterEncoding=utf-8";
    private String name="root";
    private String pass="0000";
    private String jdbcName="com.mysql.cj.jdbc.Driver";
    public Connection getCon() throws Exception{
        Class.forName(jdbcName); //加载驱动
        Connection con=DriverManager.getConnection(url,name,pass); //创立连接
        System.out.println("数据库已经正常连接，欢迎使用");
        return con;
    }
}

class write{


    public void write(Connection con) throws Exception{ //ResultSet
    int num1=100001;
    int num2=001;
    while(true) {
        Scanner scanner = new Scanner(System.in);

        //while (scanner.hasNext()){ //接受一行数据
        // System.out.println("卡号为："+scanner.nextLine());
        //}

        String sql = "INSERT INTO readers(number,icnumber,rfidno) VALUES (?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql); //设置通道

        pstmt.setInt(1, num1); //按顺序添加
        pstmt.setInt(2, Integer.parseInt(scanner.nextLine()));
        pstmt.setInt(3, num2);

        pstmt.executeUpdate(); //执行更新(可返回bool)
        num1 += 1;
        System.out.println("成功");
    }
   }
}

public class datarec{
    public static void main(String[] args) {

        DbUtil db = new DbUtil();
        Connection con=null;
        try {
            con=db.getCon();
        } catch (Exception e) {
            e.printStackTrace();
        }


        write wr = new write();
        try {
            wr.write(con);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}