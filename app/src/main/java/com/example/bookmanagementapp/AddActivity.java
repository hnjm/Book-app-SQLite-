package com.example.bookmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bookmanagementapp.databinding.ActivityAddBinding;
import com.example.bookmanagementapp.databinding.ActivityMainBinding;

public class AddActivity extends AppCompatActivity {

    ActivityAddBinding binding;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dbHelper = new DBHelper(this);

        binding.addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bookTitle = binding.titleBook.getText().toString();
                String bookAuthor = binding.author.getText().toString();
                String bookPages = binding.page.getText().toString();

                if (bookTitle.equals("") || bookAuthor.equals("") || bookPages.equals("")){
                    Toast.makeText(AddActivity.this, "Empty spaces not allowed !", Toast.LENGTH_LONG).show();
                }
                else {
                    boolean checkBook = dbHelper.checkBookName(bookTitle);
                    if (checkBook == false) {
                        boolean addTheBook = dbHelper.addData(bookTitle, bookAuthor, bookPages);
                        if (addTheBook == true){
                            Toast.makeText(AddActivity.this, "Book Added!", Toast.LENGTH_LONG).show();
                            binding.titleBook.setText("");
                            binding.author.setText("");
                            binding.page.setText("");
                        } else {
                            Toast.makeText(AddActivity.this, "Book not Added!", Toast.LENGTH_LONG).show();
                            binding.titleBook.setText("");
                            binding.author.setText("");
                            binding.page.setText("");
                        }
                    } else {
                        Toast.makeText(AddActivity.this, "Book name already exists!", Toast.LENGTH_LONG).show();
                    }

                }


            }
        });


    }
}