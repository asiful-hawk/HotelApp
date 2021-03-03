package com.example.hotelapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hotelapp.Client.RestClient;
import com.example.hotelapp.Model.User;
import com.example.hotelapp.RestService.RoomService;
import com.example.hotelapp.database.DBHelper;
import com.example.hotelapp.ui.notifications.NotificationsFragment;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AskLog extends AppCompatActivity {
    EditText usertxt;
    EditText passtxt;
    DBHelper dbHelper = new DBHelper(AskLog.this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usertxt = findViewById(R.id.userId);
        passtxt = findViewById(R.id.userPass);

        Button logBtn = findViewById(R.id.loginbtn);
        String unme = usertxt.getText().toString();
        String ps = passtxt.getText().toString();
        System.out.println(usertxt.getText().toString() + passtxt.getText().toString());
        System.out.println(unme + ps);

        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RoomService roomService = RestClient.getRetrofitInstance().create(RoomService.class);
                roomService.userLog("user@gmail.com", "1234").enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {

                        User user = response.body();

                        String uname = response.body().getName();
                        String uemail = response.body().getEmail();
                        double pay = response.body().getPayment();
                        int roomid = response.body().getRoomId();
                        Date rsfrm = response.body().getReserveFrom();
                        Date rstl = response.body().getReserveTill();
                        Bundle bundle = new Bundle();
                        bundle.putString("uname", uname);
                        bundle.putString("uemail", uemail);
                        bundle.putString("pay", String.valueOf(pay));
                        bundle.putString("roomId", String.valueOf(roomid));
                        bundle.putString("reserveDate", String.valueOf(rsfrm));
                        bundle.putString("reserveTill", String.valueOf(rstl));
                        Intent intent = new Intent(AskLog.this, NotificationsFragment.class);
                        intent.putExtras(bundle);
                        Fragment fragment = new Fragment();
                        fragment.setArguments(bundle);
                        startActivity(intent);
                        

                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        t.printStackTrace();

                    }
                });
                setContentView(R.layout.fragment_notifications);
                finish();

            }
        });
    }
    void insertData(String name, String email, double payInfo, int roomId, Date reserveFrom, Date reserveTill){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("roomId", roomId);
        values.put("paymentInfo", payInfo);
        values.put("reserveFrom", String.valueOf(reserveFrom));
        values.put("reserveTill", String.valueOf(reserveTill));
        db.insert(dbHelper.USER_TABLE, null, values);

    }


}
