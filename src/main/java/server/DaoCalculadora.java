package server;

import utils.MySQLConnection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCalculadora {

    Connection conn;

    PreparedStatement pste;
    CallableStatement cstn;
    ResultSet rs;

    private final String insertar = "INSERT INTO operations(type, first_number, second_number, result) values (?,?,?,?)";

    public boolean insertarOperacion(Methods opertations, String r, String firstNumber, String secondNumber, String response){
        try {
            conn = new MySQLConnection().getConnection();
            String query = insertar;
            pste = conn.prepareStatement(query);
            pste.setString(1,opertations.getR());
            pste.setDouble(2, opertations.getFirstNumber());
            pste.setDouble(3, opertations.getSecondNumber());
            pste.setString(4, opertations.getOpera());
            return pste.executeUpdate() == 1;
        }catch (SQLException e) {
            Logger.getLogger(DaoCalculadora.class.getName())
                    .log(Level.SEVERE, "Error -> ", e);
            return false;
        }finally {
            closeConnection();
        }
    }

    public static boolean guardar(Methods operations){
        DaoCalculadora daocal = new DaoCalculadora();
        ResultAction resulte = new ResultAction();
        if (daocal.guardar(operations)){
            resulte.setResult(true);
            resulte.setMessage("Operacion resgistrada correctamente");
            resulte.setStatus(200);
            return true;
        }else {
            resulte.setResult(false);
            resulte.setMessage("Error al registrar operacion");
            resulte.setStatus(400);
            return false;
        }
    }

    public void closeConnection(){
        try{
            if(conn != null){
                conn.close();
            }
            if(pste != null){
                pste.close();
            }
            if(cstn != null){
                cstn.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e){

        }
    }

}
