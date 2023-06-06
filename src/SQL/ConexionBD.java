package SQL;

import java.sql.*;

public class ConexionBD {

    public static String url = "jdbc:mysql://localhost:3306/expedientes_digitales";
    public static String usuario = "root";
    public static String contraseña = "suprema32";
    public static String clase = "com.mysql.cj.jdbc.Driver";
    String consulta;
    String resultado_consulta;
    Connection con = null;
    ResultSet rs = null ;
    Integer ultimo = 0;
    
    public static PreparedStatement sentencia_preparada;
//jdbc:mysql://localhost:3306/?user=root
    
 
    public static Connection conectar() {
        Connection conexion = null;

       try {
           Class.forName(clase).newInstance();
            
            conexion = DriverManager.getConnection(url, usuario, contraseña);
             System.out.println("conexion establecida");
       }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("No se pudo cargar el puente JDBC-ODBC.\n\n"+e);
        }
        return conexion;
    }
   public void conectar2()  //Desde java 8
    {
         try {
           Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            con = DriverManager.getConnection(url, usuario, contraseña);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("No se pudo cargar el puente JDBC-ODBC.");
        }
    }
    public ResultSet consultarAlgo(String consul) {
        conectar2();
        try {
            
            Statement sentencia = con.createStatement();
            rs = sentencia.executeQuery(consul);
             System.out.println("consulta establecida");
           
        } catch (Exception e) {
            e.printStackTrace();
            resultado_consulta = e.getMessage();
            System.out.println("consulta error");
        }
        
        return rs;
    }

    public void guardarAlgo(String consul) {
       conectar2();
        try {
            Statement sentencia = con.createStatement();
            sentencia.executeUpdate(consul);
            sentencia.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            resultado_consulta = e.getMessage();
        }
    }
    
    //guarda timestamp con prepared statement 
    public void guardarTSconPS(String consul, Timestamp tts, int i) {
        PreparedStatement pstat = null;
       conectar();
        try {
            pstat=con.prepareStatement(consul);
            pstat.setTimestamp(i,tts);
            pstat.executeUpdate();
            pstat.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            resultado_consulta = e.getMessage();
        }
    }  
    public int dalateAlgo (String tabla, String atributo, int id){
        int resultado = 0;
        Connection conexion = null;
       String sentencia_guardar = ("DELETE FROM " + tabla + " WHERE " + atributo + " = '" + id + "'");
      // sentence = "SELECT * FROM " + tabla + " WHERE " + campo + " = '" + idsel + "'";
       try{
           conexion = conectar();
           sentencia_preparada = conexion.prepareStatement(sentencia_guardar);           
           resultado = sentencia_preparada.executeUpdate();
           sentencia_preparada.close();
           
       }catch(Exception e){
       
           System.out.println(e);
       }
       return resultado;
    }

}
   /* public void desconectar() {
        try {
            con.close();
        } catch (Exception ex) {
        }
    }
*/



    
