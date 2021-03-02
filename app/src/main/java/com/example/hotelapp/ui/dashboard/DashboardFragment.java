package com.example.hotelapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hotelapp.Adapter.ListViewAdapter;
import com.example.hotelapp.Client.RestClient;
import com.example.hotelapp.Model.Room;
import com.example.hotelapp.R;
import com.example.hotelapp.RestService.RoomService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ListView listView = root.findViewById(R.id.roomList);
        ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity().getApplicationContext());
        listView.setAdapter(listViewAdapter);

        RoomService roomService = RestClient.getRetrofitInstance().create(RoomService.class);
        roomService.getRoom().enqueue(new Callback<List<Room>>() {
            @Override
            public void onResponse(Call<List<Room>> call, Response<List<Room>> response) {
                ArrayList<Room> room = (ArrayList<Room>) response.body();

                for(int i = 0; i<room.size(); i++) {
                    String cname = room.get(i).getCottageName();
                    double rprice = room.get(i).getPrice();
                    String rloc = room.get(i).getLocation();
                    String rimg = room.get(i).getImg();
                    int rid = room.get(i).getRoomId();
                    String rav = room.get(i).getAvailability();
                    int cid = room.get(i).getCustomerId();
                    int cap = room.get(i).getCapacity();
                    listViewAdapter.addAll(new Room(rid, rav, rprice, cname, cid, rloc, cap, rimg));
                }

            }

            @Override
            public void onFailure(Call<List<Room>> call, Throwable t) {
                System.out.println(t.fillInStackTrace());
            }
        });

//
//        listViewAdapter.addAll(new Room("Gazipur", "Shohag Palli", R.drawable.hotel));
        return root;
    }
}