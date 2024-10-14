/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principioJDBC;
import java.sql.*;

/**
 *
 * @author FP
 */
public class Principal {
    public static void main(String[] args) {
        String cadenaConexion = "";
        try (Connection con = DriverManager.getConnection("","root", "fp.2023");) {
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
