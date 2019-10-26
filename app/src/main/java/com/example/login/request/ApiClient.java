package com.example.login.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.login.model.Usuario;

public class ApiClient {
    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context){
        if(sp==null){
            sp=context.getSharedPreferences("datos",0);
        }
        return sp;
    }

    public void guardar(Context context, Usuario usuario){
        SharedPreferences sp=conectar(context);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("apellido",usuario.getApellido());
        editor.putString("nombre",usuario.getNombre());
        editor.putLong("dni",usuario.getDni());
        editor.putString("mail",usuario.getMail());
        editor.putString("pass",usuario.getPass());
        editor.commit();
    }

    public static Usuario leer(Context context){
        SharedPreferences sp=conectar(context);

        String apellido=sp.getString("apellido","-1");
        String nombre =sp.getString("nombre","-1");
        long dni=sp.getLong("dni",-1);
        String mail=sp.getString("mail","-1");
        String pass=sp.getString("pass","-1");
        Usuario usuario=new Usuario(apellido,nombre,dni,mail,pass);

        return usuario;
    }

    public static Usuario login(Context context,String email,String password){
        Usuario usuario=null;
        SharedPreferences sp=conectar(context);
        String apellido=sp.getString("apellido","-1");
        String nombre =sp.getString("nombre","-1");
        long dni=sp.getLong("dni",-1);
        String mail=sp.getString("mail","-1");
        String pass=sp.getString("pass","-1");
        if(email.equals(mail)&&password.equals(pass)){
            usuario=new Usuario(apellido,nombre,dni,mail,pass);
        }
        return usuario;
    }
}
