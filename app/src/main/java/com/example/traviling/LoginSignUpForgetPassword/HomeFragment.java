package com.example.traviling.LoginSignUpForgetPassword;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traviling.Adapter.RecentsAdapter;
import com.example.traviling.Adapter.TopPlacesAdapter;
import com.example.traviling.R;
import com.example.traviling.model.RecentsData;
import com.example.traviling.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("Nilgiri hills", "India", "From $200", R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("kashmir hills", "India", "From $300", R.drawable.topplaces));
        recentsDataList.add(new RecentsData("Nilgiri hills", "India", "From $200", R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("kashmir hills", "India", "From $300", R.drawable.topplaces));
        recentsDataList.add(new RecentsData("Nilgiri hills", "India", "From $200", R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("kashmir hills", "India", "From $300", R.drawable.topplaces));

        setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("BigBen", "London", " $500", R.drawable.bigben));
        topPlacesDataList.add(new TopPlacesData("Madrid", "Spain", "$1000 - $5000", R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("BigBen", "London", "$500", R.drawable.bigben));
        topPlacesDataList.add(new TopPlacesData("Madrid", "Spain", "$1000 - $5000", R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("BigBen", "London", "$500", R.drawable.bigben));
        topPlacesDataList.add(new TopPlacesData("Madrid", "Spain", "$1000 - $5000", R.drawable.topplaces));

        setTopPlacesRecycler(topPlacesDataList);
    }

    private void setRecentRecycler(List<RecentsData> recentsDataList) {

        recentRecycler = recentRecycler.findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this.recentsAdapter);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList) {

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this,topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);


    }

}