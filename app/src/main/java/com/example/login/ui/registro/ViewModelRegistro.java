package com.example.login.ui.registro;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.login.model.Usuario;
import com.example.login.request.ApiClient;

public class ViewModelRegistro extends ViewModel {
    private MutableLiveData<Usuario> mldUsuario;
    private ApiClient apiClient=new ApiClient();

    public LiveData<Usuario> getMLDUsuario(){
        if(mldUsuario == null){
            mldUsuario = new MutableLiveData<>();
        }
        return mldUsuario;
    }

    public void guardar(Context context, Usuario usuario){
        apiClient.guardar(context, usuario);
    }

    public void cargar(Context context){
        Usuario usuario=ApiClient.leer(context);
        mldUsuario.setValue(usuario);
    }
}
