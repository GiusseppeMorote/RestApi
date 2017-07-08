package com.example.giusseppe.retrofitrest.Interface;

import com.example.giusseppe.retrofitrest.Service.PersonaService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Giusseppe on 08/07/2017.
 */

public interface PersonaInterface {

    @GET("JsonPersona/blob/master/json-persona.txt")
    Call<List<PersonaService>>getPersonas();
}
