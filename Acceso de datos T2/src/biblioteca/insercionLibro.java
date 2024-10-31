/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.sql.*;

/**
 *
 * @author FP
 */
public class insercionLibro {

    public static final String CADENA_CONEXION = "jdbc:mysql://localhost:3306/biblioteca";

    public static void visualizarLibros() {
        try (Connection con = DriverManager.getConnection(CADENA_CONEXION, "root", "fp.2023"); Statement sentencia = con.createStatement();) {
            String selectLibro = "SELECT * FROM Libro NATURAL JOIN (Autor, Editorial, Tema)";
            ResultSet sentenciaSelect = sentencia.executeQuery(selectLibro);
            while (sentenciaSelect.next()) {
                System.out.println(sentenciaSelect.getString("ISBN") + " ");
                System.out.println(sentenciaSelect.getString("titulo") + " ");
                System.out.println(sentenciaSelect.getInt("numeroEjemplares") + " ");
                System.out.println(sentenciaSelect.getString("nombreAutor") + " ");
                System.out.println(sentenciaSelect.getString("nombreEditorial") + " ");
                System.out.println(sentenciaSelect.getString("direccion") + " ");
                System.out.println(sentenciaSelect.getString("telefono") + " ");
                System.out.println(sentenciaSelect.getString("nombreTema") + " ");
                System.out.println("");
                System.out.println("------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Conexcion incorrecta");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(CADENA_CONEXION, "root", "fp.2023"); Statement sentencia = con.createStatement();
                CallableStatement procedimiento = con.prepareCall("{CALL altaEditorial(?,?,?)}");) {
            String isbn = "123";
            String titulo = "Iker";
            int numeroEjemplares = 7;
            String nombreAutor = "";
            String nombreEditorial = "Trillas";
            String nombreTema = "Biología";

            String selectLibro = "SELECT * FROM libro WHERE isbn = '" + isbn + "';";
            ResultSet sentenciaSelect = sentencia.executeQuery(selectLibro);
            if (sentenciaSelect.next()) {
                System.out.println("El libro ya existe");
                visualizarLibros();
            } else {
                if (!existeAutor(nombreAutor, con)) {
                    altaAutor(nombreAutor, con);
                }
                int idAutor = buscarAutor(nombreAutor, con);
                
                if (buscarTema(nombreTema, con) == 0) {
                    altaTema(nombreTema, con);
                }
                int idTema = buscarTema(nombreTema, con);
                
                if (!existeEditorial(nombreEditorial, con)) {
                    procedimiento.setString(1, nombreEditorial);
                    //Pedir datos de la editorial
                    String direccion = "Calle Nueva";
                    String telefono = "23456781";
                    procedimiento.setString(2, direccion);
                    procedimiento.setString(3, telefono);
                    procedimiento.execute();
                }
                int idEditorial = buscarEditorial(nombreEditorial, con);
                altaLibro(isbn, titulo, numeroEjemplares, idAutor, idEditorial, idTema, con);
                visualizarLibros();
            }
        } catch (SQLException e) {
            System.out.println("Error en la comprobacion de datos");
            System.out.println(e.getMessage());
        }
    }

    private static boolean existeAutor(String nombreAutor, Connection con) throws SQLException {
        String sentenciaAutor = "SELECT * FROM autor WHERE nombreAutor = '" + nombreAutor + "'";
        ResultSet sentenciaSelect = con.createStatement().executeQuery(sentenciaAutor);
        if (!sentenciaSelect.next()) {
            return false;
        } else {
            return true;
        }
    }
    
    private static void altaAutor(String nombreAutor, Connection con) throws SQLException {
        String sentenciaInsert = "INSERT INTO autor VALUES (NULL, '" + nombreAutor + "')";
        con.createStatement().executeUpdate(sentenciaInsert);
    }

    private static int buscarAutor(String nombreAutor, Connection con) throws SQLException {
        String sentenciaAutor = "SELECT * FROM autor WHERE nombreAutor = '" + nombreAutor + "'";
        ResultSet sentenciaSelect = con.createStatement().executeQuery(sentenciaAutor);
        sentenciaSelect.next();
        return sentenciaSelect.getInt("idAutor");
    }

    private static int buscarTema(String nombreTema, Connection con) {
        int devolver = -1;
        try (PreparedStatement selectTema = con.prepareStatement("SELECT idTema FROM tema WHERE nombreTema=?")){
            selectTema.setString(1, nombreTema);
            ResultSet salida = selectTema.executeQuery();
            if (salida.next()) {
                devolver = salida.getInt("idTema");
            }
        } catch (SQLException ex) {
            System.out.println("Error en la sentencia preparada de BuscarTema");
        }
        return devolver;
    }

    private static void altaTema(String nombreTema, Connection con) {
        try(PreparedStatement sentenciaInsert = con.prepareStatement("INSERT INTO tema(nombreTema) VALUES (?) ")){
           sentenciaInsert.setString(1, nombreTema);
           sentenciaInsert.execute();
        } catch (SQLException ex) {
            System.out.println("Error en el alta del tema");
        }
    }

    private static boolean existeEditorial(String nombreEditorial, Connection con) throws SQLException {
        String sentenciaEditorial = "SELECT * FROM editorial WHERE nombreEditorial = '" + nombreEditorial + "'";
        ResultSet sentenciaSelect = con.createStatement().executeQuery(sentenciaEditorial);
        if (!sentenciaSelect.next()) {
            return false;
        } else {
            return true;
        }
    }

    private static int buscarEditorial(String nombreEditorial, Connection con) throws SQLException {
        String sentenciaEditorial = "SELECT * FROM editorial WHERE nombreEditorial = '" + nombreEditorial + "'";
        ResultSet sentenciaSelect = con.createStatement().executeQuery(sentenciaEditorial);
        return sentenciaSelect.getInt("idEditorial");
    }

    private static void altaLibro(String bn, String titulo, int numeroEjemplares, int idAutor, int idEditorial, int idTema, Connection con) {
        try(PreparedStatement sentenciaInsert = con.prepareStatement("INSERT INTO libro VALUES (?,?,?,?,?,?) ")){
           sentenciaInsert.setString(1, bn);
           sentenciaInsert.setString(2, titulo);
           sentenciaInsert.setInt(3, numeroEjemplares);
           sentenciaInsert.setInt(4, idAutor);
           sentenciaInsert.setInt(5, idEditorial);
           sentenciaInsert.setInt(6, idTema);
           sentenciaInsert.execute();
        } catch (SQLException ex) {
            System.out.println("Error en el alta del tema");
        }
    }
}
