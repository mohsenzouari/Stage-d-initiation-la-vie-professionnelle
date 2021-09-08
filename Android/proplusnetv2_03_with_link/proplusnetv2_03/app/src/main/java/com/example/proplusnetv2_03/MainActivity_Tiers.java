package com.example.proplusnetv2_03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity_Tiers extends AppCompatActivity {

    private MyAdapter_Tiers myAdapter;
    private RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tiers);

        //Retrofit

        GetData_Tiers service = RetrofitClient_Tiers.getRetrofitInstance().create(GetData_Tiers.class);
        Call<List<Tiers>> call = service.getAllTiers();
        call.enqueue(new Callback<List<Tiers>>() {

            @Override
            public void onResponse(Call<List<Tiers>> call, Response<List<Tiers>> response) {
                loadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Tiers>> call, Throwable throwable) {
                Toast.makeText(MainActivity_Tiers.this, "Unable to load users", Toast.LENGTH_SHORT).show();
            }
        });



     //Filtrage

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


                GetData_Tiers service = RetrofitClient_Tiers.getRetrofitInstance().create(GetData_Tiers.class);
                Call<List<Tiers>> call = service.getAllTiers();
                call.enqueue(new Callback<List<Tiers>>() {

                    @Override
                    public void onResponse(Call<List<Tiers>> call, Response<List<Tiers>> response) {
                        loadDataList(response.body());
                        filter(s.toString(),response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Tiers>> call, Throwable throwable) {
                        Toast.makeText(MainActivity_Tiers.this, "Unable to load users", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });



    }



    //Retrofit

    private void loadDataList(List<Tiers> usersList) {

        myRecyclerView = findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter_Tiers(usersList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity_Tiers.this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(myAdapter);



        //passer

        final List<Tiers> usersListt =usersList;
        myAdapter.setOnItemClickListener(new MyAdapter_Tiers.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String PCodeTiers = usersListt.get(position).getCodeTiers();
                Intent i = new Intent(MainActivity_Tiers.this, DetailsActivity.class);
                i.putExtra("name", PCodeTiers);
                startActivity(i);

            }
        });


        //*passer





    }




    //Filtrage

    private void filter(String text, List<Tiers> usersList) {
        List<Tiers> filteredList= new ArrayList<Tiers>();

        for (Tiers item : usersList ) {
            if (item.getCodeTiers().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        myAdapter.filterList(filteredList);

    }





}
