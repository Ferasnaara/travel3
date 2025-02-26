package com.example.traviling.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traviling.R;
import com.example.traviling.Traveling;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    ArrayList<Traveling>list;
    Context context ;

    public MyAdapter(Context context, ArrayList<Traveling> list) {
        this.context = context;
        list = list;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setList(ArrayList<Traveling> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(context).inflate(R.layout.activity_main,parent,false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        Traveling product=list.get(position);
        holder.Name.setText(product.getName());
        holder.Price.setText(product.getPhone());
    }
    @Override
    public int getItemCount()
    {
        return list.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Name,Price;
        ImageView proPicture;



        @SuppressLint("WrongViewCast")
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name=itemView.findViewById(R.id.btnSignupSignup);
            Price=itemView.findViewById(R.id.btnBackSignup);
            proPicture=itemView.findViewById(R.id.btnBackSignup);
        }
    }
}
