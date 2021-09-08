package com.example.t5;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextWatcher;
import android.widget.Toast;
import android.widget.EditText;
import android.text.Editable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);
        Call<List<RetrofitRessource>> call = service.getAllRessources();
        call.enqueue(new Callback<List<RetrofitRessource>>() {

            @Override
            public void onResponse(Call<List<RetrofitRessource>> call, Response<List<RetrofitRessource>> response) {
                loadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetrofitRessource>> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();
            }
        });


        EditText editText = findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(final Editable s) {


                GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);
                Call<List<RetrofitRessource>> call = service.getAllRessources();
                call.enqueue(new Callback<List<RetrofitRessource>>() {

                    @Override
                    public void onResponse(Call<List<RetrofitRessource>> call, Response<List<RetrofitRessource>> response) {
                        loadDataList(response.body());
                        filter(s.toString(),response.body());
                    }

                    @Override
                    public void onFailure(Call<List<RetrofitRessource>> call, Throwable throwable) {
                        Toast.makeText(MainActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
    }




    private void filter(String text, List<RetrofitRessource> usersList) {
        List<RetrofitRessource> filteredList= new ArrayList<RetrofitRessource>();

        for (RetrofitRessource item : usersList ) {
            if (item.getIdObjet().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        myAdapter.filterList(filteredList);











    }






    private void loadDataList(List<RetrofitRessource> usersList) {

        myRecyclerView = findViewById(R.id.recyclerView);
                myAdapter = new MyAdapter(usersList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                myRecyclerView.setLayoutManager(layoutManager);
                myRecyclerView.setAdapter(myAdapter);

                final List<RetrofitRessource> usersListt =usersList;
                myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                        String UrlRessource = usersListt.get(position).getCheminComplet();
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(UrlRessource));
                        startActivity(intent);
                    }
                });

                }




}
