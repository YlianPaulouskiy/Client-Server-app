package com.exercise.demo.data.api;

import com.exercise.demo.data.model.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CarApi {

    String JSON_API = "http://192.168.107.126:8000/";

    /**Get all cars
     *
     * @return Call<List<Car>>
     */
    @GET("cars/all")
    Call<List<Car>> getCars();


    /** Create new car
     *
     * @param car car
     * @return Call<Car>
     */
    @POST("cars/create/")
    Call<Car> saveCar(@Body Car car);
}
