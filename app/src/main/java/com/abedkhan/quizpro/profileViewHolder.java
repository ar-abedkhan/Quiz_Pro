package com.abedkhan.quizpro;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class profileViewHolder extends RecyclerView.ViewHolder {
           ImageView countryIMG;
           TextView countryName,population,area;

    public profileViewHolder(@NonNull View itemView) {
        super(itemView);

        countryIMG=itemView.findViewById(R.id.countryimage);
        countryName=itemView.findViewById(R.id.countryname);
        population=itemView.findViewById(R.id.population);
        area=itemView.findViewById(R.id.area);

    }
}