package com.example.hotelapp.ui.notifications;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hotelapp.R;
import com.example.hotelapp.database.DBManager;
import com.google.android.material.textview.MaterialTextView;

public class NotificationsFragment extends Fragment {
    MaterialTextView usrnm, uemail, upass, upayment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        try {
            DBManager dbManager = new DBManager(getActivity());
            dbManager.open();

            Cursor cursor = dbManager.fetch();
            cursor.moveToFirst();
            MaterialTextView usrnm = getActivity().findViewById(R.id.uname);
            usrnm.setText(cursor.getString(0));

        } catch (Exception e){
            e.printStackTrace();
        }

        return root;
    }
}