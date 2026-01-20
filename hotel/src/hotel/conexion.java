package hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    // Atributo para la conexión
    private static Connection con;

    // Método para establecer la conexión
    public static Connection getConexion() {
        // Datos de la base de datos
        String url = "jdbc:mysql://localhost:3306/bd_hotel"; // Cambia la URL según tu configuración
        String usuario = "root";  // Cambia el usuario si es necesario
        String password = "Webos1";  // Cambia la contraseña si es necesario

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa");

        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error: No se pudo establecer la conexión a la base de datos: " + e.getMessage());
        }

        return con;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Establecer conexión
        conexion.getConexion();

        // Aquí puedes hacer consultas o trabajar con la base de datos sin cerrarla automáticamente
        // Si quieres mantener la conexión abierta, simplemente no llames a cerrarConexion()
        //conexion.cerrarConexion(); // Comenta o elimina esta línea para no cerrar la conexión
    }
}
