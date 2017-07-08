package com.example.giusseppe.retrofitrest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.giusseppe.retrofitrest.Interface.PersonaInterface;
import com.example.giusseppe.retrofitrest.Service.PersonaService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String  baseURL ="https://github.com/GiusseppeMorote/";
    List<PersonaService>listadoPersonas = new ArrayList<>();

    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView = (ListView) findViewById(R.id.lvLista);




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create())
                .build();


        //Llamar al Interface
        PersonaInterface personaInterface = retrofit.create(PersonaInterface.class);

        //retornamos la llamada del  call

        Call<List<PersonaService>>lista = personaInterface.getPersonas();
        //le hacemos una llamada asyn
        lista.enqueue(new Callback<List<PersonaService>>() {
            @Override
            public void onResponse(Call<List<PersonaService>> call, Response<List<PersonaService>> response) {
                //verifico si la respuesta es exitosa
                if(response.isSuccessful()){
                    //retorna la lista de las personas Body();
                    listadoPersonas = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<PersonaService>> call, Throwable t) {

            }
        });
    }


}
