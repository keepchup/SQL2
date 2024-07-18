import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/estudiantes";
        String user="root";
        String password="123456";
        String update="DELETE FROM estudiantes where cedula = ?";
        Connection conexion = null;
        PreparedStatement statement = null;
        String cedula="3300010840";
        try{
            conexion = DriverManager.getConnection(url, user, password);
            statement = conexion.prepareStatement(update);

            statement.setString(1, cedula);
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