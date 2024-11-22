/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author FP
 */
public class ListaDepartamentos {
    public static void main(String[] args) {
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session = sesion.openSession();
        Query q = session.createQuery("from Departamentos");
        List <Departamentos> lista = q.list();
        
        //Obtenemos un Iterador y recorremos la lista
        Iterator <Departamentos> iter = lista.iterator();
        System.out.println("Numero de departamentos: " + lista.size());
        
        while (iter.hasNext()) {
            //Extraer el objeto
            Departamentos depar = (Departamentos) iter.next();
            System.out.println(depar.getDepNo() + ", " + depar.getDnombre());
        }
        
        System.out.println("");
        
        Query q2 = session.createQuery("from Departamentos");
        
        q2.setFetchSize(10);
        Iterator iter2 = q2.iterate();
        
        while (iter2.hasNext()) {
            Departamentos depar2 = (Departamentos) iter2.next();
            System.out.println(depar2.getDepNo() + ", " + depar2.getDnombre());
        }
        
        System.out.println("");
        
        /*Query q3 = session.createQuery("from Empleados as ");
        List <Empleados> lista2 = q3.list();
        Iterator <Empleados> iter3 = lista3.iterator();
        
        while (iter3.hasNext()) {
            //Extraer el objeto
            Empleados emp = (Empleados) iter3.next();
            System.out.println(emp.getApellido() + ", " + emp.getSalario());
        }*/
        
        String hql = "from Empleados where empNo = :numemple";
        Query q4 = session.createQuery(hql);
        
        q4.setParameter("numemple", (short) 7369);
        Empleados emp2 = (Empleados) q4.uniqueResult();
        System.out.println(emp2.getApellido() + ", " + emp2.getOficio());
        
        System.out.println("");
        
        String hql2 = "from Empleados emp where emp.departamentos.depNo = :ndep and emp.oficio = :ofi";
        Query q5 = session.createQuery(hql2);
        
        q5.setParameter("ndep", (byte) 30);
        q5.setParameter("ofi", "VENDEDOR");
        
        List <Empleados> lista3 = q5.list();
        Iterator <Empleados> iter4 = lista3.iterator();
        
        while(iter4.hasNext()) {
            Empleados emp3 = (Empleados) iter4.next();
            System.out.println(emp3.getApellido() + ", " + emp3.getSalario());
        }
        
        System.out.println("");
        
        /*SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = "1991-02-22";
        Date fecha = null;
        try {
            fecha = formatoDelTexto.parse(strFecha);
        } catch(ParseException ex) {
            ex.printStackTrace();
        }
        String hql3 = "from Empleados where fechaAlt = :fechalta";
        
        Query q6 = session.createQuery(hql3);
        q6.setDate("fechalta", fecha);
        
        System.out.println("");
        
        List <Byte> numeros = new ArrayList <Byte> ();
        numeros.add((byte) 10);
        numeros.add((byte) 20);
        
        String hql4 = "from Empleados emp where emp.departamentos.depNo in (:listadep) order by emp.departamentos.depNo";
        Query q7 = session.createQuery(hql4);
        q7.setParameter("listadep", numeros);*/
        
        //CONSULTAS SOBRE CLASES NO ASOCIADAS
        String hql5 = "from Empleados e, Departamentos d where e.departamentos.depNo = d.depNo order by Apellido";
        Query q8 = session.createQuery(hql5);
        Iterator iter5 = q8.iterate();
        
        while (iter5.hasNext()) {
            Object [] par = (Object[]) iter5.next();
            Empleados em = (Empleados) par[0];
            Departamentos de = (Departamentos) par[1];
            System.out.println(em.getApellido() + " " + em.getSalario() + " " + de.getDnombre() + " " + de.getLoc());
        }
        
        System.out.println("");
        
        String hql6 = "select avg(em.salario) from Empleados as em";
        Query q9 = session.createQuery(hql6);
        Double suma = (Double) q9.uniqueResult();
        System.out.println("Salario medioa: " + suma);
        
        System.out.println("");
        
        String hql7 = "select e.departamentos.depNo, avg(salario), count(empNo) from Empleados e group by e.departamentos.depNo";
        Query q10 = session.createQuery(hql7);
        Iterator iter6 = q10.iterate();
        
        while (iter6.hasNext()) {
            Object [] par = (Object[]) iter6.next();
            Byte depar = (Byte) par[0];
            Double media = (Double) par[1];
            Long cuenta = (Long) par[2];
            System.out.println("Dept: " + depar + " Media: " + media + " NºEmp: " + cuenta);
        }
        
        System.out.println("");
        
        String hql8 = "select new empresa.Totales(count(e.empNo),d.depNo,avg(e.salario),d.dnombre) from Empleados as e right join e.departamentos as d group by d.depNo, d.dnombre";
        Query q11 = session.createQuery(hql8);
        Iterator iter7 = q11.iterate();
        
        while (iter7.hasNext()) {
            Totales tot = (Totales) iter7.next();
            System.out.println("Nº Dep: " + tot.getNumero() + "Salario medio: " + tot.getMedia() + "Nº Emple: " + tot.getCuenta());
        }
        
        System.out.println("");
        
        String hql9 = "select d.depNo, count(e.empNo),avg(e.salario),d.dnombre from Empleados as e right join e.departamentos as d group by d.depNo, d.dnombre";
        Query q12 = session.createQuery(hql9);
        
        List <Object[]> filas = q12.list(); //Todas las filas
        for (int i = 0; i < filas.size(); i++) {
            Object[] filaActual = filas.get(i);
            System.out.println("Nº Dep: " + filaActual[0] + "Nombre: " + filaActual[3] + " Salario medio: " + filaActual[2] + "Nº Emple: " + filaActual[1]);
        }
        
        session.close();
        System.exit(0);
    }
}
