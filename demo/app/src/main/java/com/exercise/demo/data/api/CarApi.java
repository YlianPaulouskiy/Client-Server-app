package com.exercise.demo.data.api;

import com.exercise.demo.data.model.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CarApi {

    String JSON_API = "http://localhost:8000/";

    /**Get all cars
     *
     * @return Call<List<Car>>
     */
    @GET("cars/all/?format=json")
    Call<List<Car>> getCars();


    /** Create new car
     *
     * @param mark auto mark
     * @param doorCount door amount
     * @param accounting accounting auto or not
     * @return Call<Car>
     */
    @FormUrlEncoded
    @POST("cars/create")
    Call<Car> saveCar(@Field("mark") String mark,
                @Field("doorCount") int doorCount,
                @Field("accounting") boolean accounting);
}
