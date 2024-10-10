/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escrituraEmpleados;

/**
 *
 * @author FP
 */
public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private String ciudad;
    
    public Empleado() {
        
    }
    
    public Empleado(int id, String nombre, String apellido, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getCiudad() {
        return ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
