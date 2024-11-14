/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FP
 */
public class Principal {
    public static void main(String[] args) throws ParseException {
        //Obtener la sesión actual
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //Crear la sesion
        Session sesion = sessionFactory.openSession();
        //Crear la transaccion de la sesion
        Transaction tx = sesion.beginTransaction();
        
        System.out.println("Inserto una fila en la tabla DEPARTAMENTOS");        
        //Insercion de un departamento con método save()
        //Departamentos d = new Departamentos((byte)62,"MARKETING","GUADALAJARA");
        //Con esto realizamos la insercion en la BBDD
        //sesion.save(d);
        
        //Insertar un empleado, necesitamos un objeto de tipo departamentos
        Departamentos d = new Departamentos((byte)62);
        /*
        Date fecha = new Date();
        java.sql.Date formatoFechaSQL = new java.sql.Date(fecha.getTime());
        */
        String fecha2 = "14/11/2024";
        SimpleDateFormat ffecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = ffecha.parse(fecha2);
                
        Empleados e = new Empleados((short)4455, d, "GALLARDO", "VENDEDOR", (short)7499, fecha, (float) 1500, (float) 100);
        
        sesion.save(e);
        tx.commit();
        System.out.println("Empleado insertado");
        sesion.close();
        sessionFactory.close();
    }
}
