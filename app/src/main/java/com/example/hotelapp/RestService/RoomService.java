package com.example.hotelapp.RestService;

import com.example.hotelapp.Model.Room;
import com.example.hotelapp.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RoomService {
    @GET("api/room")
    Call<List<Room>> getRoom();

    @GET("api/user")
    Call<User> userLog(@Query("email") String email, @Query("password") String password);
}
