/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biblioteca;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class insercionLibro {

    public static final String cadenaConexion = "jdbc:mysql://localhost:3306/biblioteca";

    public static void visualizarLibros() {
        try (Connection con = DriverManager.getConnection(cadenaConexion, "root", "fp.2023"); Statement sentencia = con.createStatement();) {
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
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        String cadenaConexion = "jdbc:mysql://localhost:3306/biblioteca";
        try (Connection con = DriverManager.getConnection(cadenaConexion, "root", "fp.2023"); Statement sentencia = con.createStatement();) {
            String isbn = "123";
            String titulo = "";
            int numeroEjemplares = 0;
            String nombreAutor = "";
            String nombreEditorial = "";
            String nombreTema = "";

            String selectLibro = "SELECT * FROM Libro WHERE isbn = '" + isbn + "';";
            ResultSet sentenciaSelect = sentencia.executeQuery(selectLibro);
            if (sentenciaSelect.next()) {
                System.out.println("El libro ya existe");
                visualizarLibros();
            } else {
                if (!existeAutor(nombreAutor, con)) {
                    altaAutor(nombreAutor, con);
                }
                int idAutor = buscarAutor(nombreAutor, con);

                if (!existeTema(nombreTema)) {
                    altaTema(nombreTema);
                }
                int idTema = buscarTema(nombreTema);

                if (!existeEditorial(nombreEditorial)) {
                    altaEditorial(nombreEditorial);
                }
                int idEditorial = buscarEditorial(nombreEditorial);

                altaLibro(isbn, titulo, numeroEjemplares, idAutor, idEditorial, idTema);
                visualizarLibros();
            }

        } catch (SQLException e) {
            System.out.println("Conexcion incorrecta");
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
        String sentenciaInsert = "INSERT INTO autor (nombreAutor) values (" + nombreAutor + ")";
        con.createStatement().executeUpdate(sentenciaInsert);
    }

    private static int buscarAutor(String nombreAutor, Connection con) throws SQLException {
        String sentenciaAutor = "SELECT * FROM autor WHERE nombreAutor = '" + nombreAutor + "'";
        ResultSet sentenciaSelect = con.createStatement().executeQuery(sentenciaAutor);
        return sentenciaSelect.getInt("idAutor");
    }
}
