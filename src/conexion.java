import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class conexion {

    public conexion(){
        try{
            // Se registra el Driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/test","root","Wilson08");

            //Se  creo un Statement, para realizar la consulta
            Statement s = conexion.createStatement();

            //Se raliza la consult. Lo resultados se guarn en el
            // ResultSet rs
            ResultSet rs = s.executeQuery("select * from Estudiantes");
            //Se recorre el resultado el ResultSet, mostrando por pantall los resultados.

            while (rs.next()){
                System.out.println(rs.getString("Nombre_ES")+
                        " "+rs.getString(1));
            }
            // Se cierra la conexion con la base de datos.
            conexion.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
