package com.example.listviewreal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    UserListAdapter adapter;
    ListView listView;
    ArrayList<User> users;

    private  Button Name;
    private Button Sex;
    private Button Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);

        Gson gson = new Gson();
        InputStream stream = null;
        try {
            stream = getAssets().open("User.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        User[] users_arr = gson.fromJson(new InputStreamReader(stream), User[].class);

        users = new ArrayList<>(Arrays.asList(users_arr));

        adapter = new UserListAdapter(this, users);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

//        Name = findViewById(R.id.sort_n);
//        Name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Collections.sort(users, new CompareName());
//            }
//        });
//
//        Sex = findViewById(R.id.sort_s);
//        Sex.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Collections.sort(users, new CompareSex());
//            }
//        });
//
//        Phone = findViewById(R.id.sort_p);
//        Phone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Collections.sort(users, new ComparePhoneNumber());
//            }
//        });
//
//        adapter = new UserListAdapter(this, users);
//        adapter.notifyDataSetChanged();
//        listView.setAdapter(adapter);

    }
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.sort_n: {
                Collections.sort(users, new CompareName());
                break;
            }
            case R.id.sort_p: {
                Collections.sort(users, new ComparePhoneNumber());
                break;
            }
            case R.id.sort_s: {
                Collections.sort(users, new CompareSex());
                break;
            }

        }

        adapter = new UserListAdapter(this, users);
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }
}