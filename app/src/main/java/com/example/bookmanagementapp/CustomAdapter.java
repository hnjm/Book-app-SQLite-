package com.example.bookmanagementapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList bookTitle, bookAuthor, bookPages;

    CustomAdapter(Context context, ArrayList bookTitle, ArrayList bookAuthor, ArrayList bookPages){
        this.context = context;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPages = bookPages;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.show_book, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.bookTv.setText(String.valueOf(bookTitle.get(position)));
        holder.authTv.setText(String.valueOf(bookAuthor.get(position)));
        holder.pageTv.setText(String.valueOf(bookPages.get(position)));

    }

    @Override
    public int getItemCount() {
        return bookTitle.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView bookTv, authTv, pageTv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bookTv = itemView.findViewById(R.id.bookTv);
            authTv = itemView.findViewById(R.id.authTv);
            pageTv = itemView.findViewById(R.id.pageTv);
        }
    }
}
