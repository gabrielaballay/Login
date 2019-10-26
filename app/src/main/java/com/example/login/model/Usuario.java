package com.example.login.model;

public class Usuario {
    private String apellido;
    private String nombre;
    private long dni;
    private String mail;
    private String pass;

    public Usuario(String apellido, String nombre, long dni, String mail, String pass) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.mail = mail;
        this.pass = pass;
    }

    public Usuario() {
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String toString(){
        return "Usuario{"+
                "apellido='"+apellido+'\''+
                ", nombre='"+nombre+'\''+
                ", dni="+dni+
                ", mail='"+mail+'\''+
                ", password='"+pass+'\''+
                '}';

    }
}
