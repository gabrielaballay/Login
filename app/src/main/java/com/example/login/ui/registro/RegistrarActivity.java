package com.example.login.ui.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.model.Usuario;
import com.example.login.request.ApiClient;


public class RegistrarActivity extends AppCompatActivity {
    private EditText apellido,nombre,dni,mail,pass;
    private ViewModelRegistro vmr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        inicializa();
        Bundle logeado= getIntent().getExtras();
        vmr= ViewModelProviders.of(this).get(ViewModelRegistro.class);
        vmr.getMLDUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                apellido.setText(usuario.getApellido());
                nombre.setText(usuario.getNombre());
                dni.setText(usuario.getDni()+"");
                mail.setText(usuario.getMail());
                pass.setText(usuario.getPass());

            }
        });
        if(logeado!=null){
            vmr.cargar(this);
        }
    }

    private void inicializa(){
        apellido=findViewById(R.id.etApellido);
        nombre=findViewById(R.id.etNombre);
        dni=findViewById(R.id.etDni);
        mail=findViewById(R.id.etMail);
        pass=findViewById(R.id.etPassword);
    }

    public void guardar(View view){
        if(apellido.getText().toString().isEmpty()||nombre.getText().toString().isEmpty()||dni.getText().toString().isEmpty()
        ||mail.getText().toString().isEmpty()||pass.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"Debe completar todos los Campos",Toast.LENGTH_LONG).show();
        }else{
            Usuario usuario=new Usuario();
            usuario.setApellido(apellido.getText().toString());
            usuario.setNombre(nombre.getText().toString());
            usuario.setDni(Long.parseLong(dni.getText().toString()));
            usuario.setMail(mail.getText().toString());
            usuario.setPass(pass.getText().toString());
            vmr.guardar(getApplicationContext(),usuario);
        }
    }
}
