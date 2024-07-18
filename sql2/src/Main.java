import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/estudiantes";
        String user="root";
        String password="123456";
        String update="update estudiantes set b1 = ? where cedula = ?";
        Connection conexion = null;
        PreparedStatement statement = null;

        try{
            conexion = DriverManager.getConnection(url, user, password);
            statement = conexion.prepareStatement(update);

            statement.setInt(1, 9);
            statement.setString(2, "3300010840");
            System.out.println(update);
            int n = statement.executeUpdate();
            System.out.println("Se modificaron: "+n+" lineas");


        }catch (Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();

        } finally {
            try {
                if(statement != null){
                    statement.close();
                }
                if (conexion != null){
                    conexion.close();
                }
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}