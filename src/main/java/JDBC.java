import java.sql.*;

public class JDBC {

    static Connection con;
    Statement stmt;

    public static void forName(String className)throws ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public static Connection getConnection(String url)throws SQLException {
         con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/edpProject","root","root");
        return con;
    }

    public Statement createStatement()throws SQLException {
        stmt=con.createStatement();
        return stmt;
    }

    public ResultSet executeQuery(String sql)throws SQLException{
        ResultSet rs=stmt.executeQuery(sql);              // "select * from user");

        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2));
        }

        return rs;
    }

    public void executeUpdate(String sql) throws SQLException {
        // insert the data
        stmt.executeUpdate(sql);
    }

    public void close()throws SQLException{
        con.close();
    }
}
