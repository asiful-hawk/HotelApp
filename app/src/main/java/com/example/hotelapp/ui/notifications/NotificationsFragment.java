package com.example.hotelapp.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.hotelapp.R;
import com.google.android.material.textview.MaterialTextView;

public class NotificationsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String name = bundle.getString("name");
            String email = bundle.getString("email");
            String pass = bundle.getString("pass");
            System.out.println(name);

        }
        return root;

    }
}
