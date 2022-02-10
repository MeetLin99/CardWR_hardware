package datarec;
import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

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
    int num1=1001;
    int num2=1;


    String content2=""; //定位卡机content2
    String sql1 = "select location from readersinfo where rfidno="+num2;
    //content2 = con.executeQuery(sql1);
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(sql1);
    while(rs.next())
        content2 = rs.getString("location");



    Date date = new Date();//获取当前的日期
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String daten = df.format(date);//获取String类型的时间


    while(true) {
        Scanner scanner = new Scanner(System.in);
        //while (scanner.hasNext()){ //接受一行数据
        // System.out.println("卡号为："+scanner.nextLine());
        //}
        String sql = "INSERT INTO lost_record(id,content,status,title,type_code,cardid) VALUES (?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql); //设置通道
        pstmt.setInt(1, num1); //按顺序添加
        pstmt.setString(2, content2);
        pstmt.setInt(3, 0);
        pstmt.setString(4, daten);
        pstmt.setInt(5, 1);
        pstmt.setInt(6, Integer.parseInt(scanner.nextLine()));

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