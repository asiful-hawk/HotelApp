package com.example.hotelapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hotelapp.Model.Room;
import com.example.hotelapp.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import retrofit2.http.Url;

public class ListViewAdapter extends ArrayAdapter {

    public ListViewAdapter(@NonNull Context context) {
        super(context, R.layout.room_item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View cardView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (cardView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            cardView = inflater.inflate(R.layout.room_item, parent, false);
            holder = new ViewHolder(cardView);

            cardView.setTag(holder);
        } else {
            holder = (ViewHolder) cardView.getTag();
        }

        Room model = (Room) getItem(position);

        String imageUri = model.getImg();
        Picasso.with(getContext().getApplicationContext()).load(imageUri).into(holder.roomImageView);

        holder.hotelName.setText(model.getCottageName());
        holder.description.setText("Just a few 0.2 miles from City centre, "+Html.fromHtml("<b>"+model.getLocation()+"</b>"));
        holder.roomRev.setText("Book without Credit Card Details now!");
        holder.roomPrice.setText(Html.fromHtml(String.valueOf(model.getPrice()))+"0 BDT");
        holder.roomCap.setText("For a total of "+ Html.fromHtml("<b>"+model.getCapacity()+"</b>") + " members for 1 night");


        return cardView;
    }

    static class ViewHolder {
        ImageView roomImageView;
        TextView hotelName, description, roomPrice, roomCap, roomRev;

        public ViewHolder(View view) {
            roomImageView = view.findViewById(R.id.roomImage);
            hotelName = view.findViewById(R.id.hotelName);
            description = view.findViewById(R.id.roomDesc);
            roomPrice = view.findViewById(R.id.roomPrice);
            roomCap = view.findViewById(R.id.roomCap);
            roomRev = view.findViewById(R.id.roomRev);

        }
    }


}

