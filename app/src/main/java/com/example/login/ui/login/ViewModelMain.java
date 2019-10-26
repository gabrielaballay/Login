package com.example.login.ui.login;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.login.model.Usuario;
import com.example.login.request.ApiClient;

public class ViewModelMain extends ViewModel {
    private MutableLiveData<Usuario> mldUsuario;

    public LiveData<Usuario> getMLDUsuario(){
        if(mldUsuario == null){
            mldUsuario = new MutableLiveData<>();
        }
        return mldUsuario;
    }

    public Usuario login(Context context, String email, String password){
        Usuario usuario = ApiClient.login(context,email,password);
        if(usuario!=null) {
            mldUsuario.setValue(usuario);
        }
        return usuario;
    }
}
