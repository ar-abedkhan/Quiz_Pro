package com.abedkhan.quizpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class profileAdapter  extends RecyclerView.Adapter<profileViewHolder> {

    List<country_data> countrylist;
    Context context;


    public profileAdapter(List<country_data> countrylist, Context context) {
        this.countrylist = countrylist;
        this.context = context;
    }

    @NonNull
    @Override
    public profileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.profilelist,parent,false);

        profileViewHolder profileViewHolder=new profileViewHolder(view);

        return profileViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull profileViewHolder holder, int position) {




        String countryname=countrylist.get(position).getCountryname();
        String population=countrylist.get(position).getPopulation();
        String area=countrylist.get(position).getArea();
        String countryflag=countrylist.get(position).getMap();

        holder.countryName.setText(countryname);
        holder.population.setText(population);
        holder.area.setText(area);
        Glide.with(context).load(countryflag).into(holder.countryIMG);

    }

    @Override
    public int getItemCount() {

        return countrylist.size();
    }
}
