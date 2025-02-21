import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //;Trust Server Certificate=True
        //Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=Northwind;Encrypt=true;integratedSecurity=true");

        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "D6o9fFrzZHBTpspTZbac";
        //String sql = "select sname from student where sid = 1";
        //String sql = "select * from student";
        //Class.forName("org.postgresql.Driver");
        //String sql = "insert into student values(5, 'Eldey', 60)";
        //String sql = "update student set sname = 'Idun' where sid = 5";
        //String sql = "delete from student where sid = 5";

        String sql = "insert into student values(?, ?, ?)";

        Connection con = DriverManager.getConnection(url, uname, pass);

        System.out.println("Connection established");

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, 5);
        statement.setString(2, "Eldey");
        statement.setInt(3, 60);

        boolean status = statement.execute();
        System.out.println(status);

        //Statement statement = con.createStatement();

        //boolean status = statement.execute(sql);
        //System.out.println(status);


//        ResultSet resultSet =  statement.executeQuery(sql);
//        if(resultSet.next()){
//            System.out.println(resultSet.getString("sname"));
//        }

//        while(resultSet.next()){
//            System.out.print(resultSet.getInt(1) + " - ");
//            System.out.print(resultSet.getString(2) + " - ");
//            System.out.println(resultSet.getInt(3));
//        }

        con.close();
        System.out.println("Connection closed");
    }
}
