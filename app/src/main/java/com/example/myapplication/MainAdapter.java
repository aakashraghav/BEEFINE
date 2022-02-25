package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    ArrayList<MainModel> mainModels;
    Context context;

    public MainAdapter(Context context,ArrayList<MainModel> mainModels){
        this.context = context;
        this.mainModels= mainModels;
    }
    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // create view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //set logo to imageview
        holder.imageView.setImageResource(mainModels.get(position).getlangLogo());
        //set name to Textview
        holder.readMoreText.setText(mainModels.get(position).getLangName());


    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
     // initialize variable
        ImageView imageView;
        TextView readMoreText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Assign variable
            imageView = itemView.findViewById(R.id.imageView);
            readMoreText = itemView.findViewById(R.id.readMoreText);

        }
    }
}
