package com.example.login.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.model.Usuario;
import com.example.login.ui.registro.RegistrarActivity;

public class MainActivity extends AppCompatActivity {
    private EditText user,pas;
    private Button entrar, registrar;
    private Usuario usuario;
    private ViewModelMain vmm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        vmm = ViewModelProviders.of(this).get(ViewModelMain.class);

        vmm.getMLDUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                user.setText(usuario.getMail());
                pas.setText(usuario.getPass());
            }
        });

    }

    private void inicializar(){
        user=findViewById(R.id.etUsuario);
        pas=findViewById(R.id.etPass);
        entrar=findViewById(R.id.btnIngresar);
        registrar=findViewById(R.id.btnRegistrarse);
    }

    public void logear(View view){
        Usuario usuario=vmm.login(this,user.getText().toString(),pas.getText().toString());
        if(usuario!=null){
            Intent intent=new Intent(getApplicationContext(), RegistrarActivity.class);
            intent.putExtra("login","correcto");
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Usuario o Contraseña Incorrecto",Toast.LENGTH_LONG).show();
        }
    }

    public void registrar(View view){
        startActivity(new Intent(getApplicationContext(), RegistrarActivity.class));
    }
}
