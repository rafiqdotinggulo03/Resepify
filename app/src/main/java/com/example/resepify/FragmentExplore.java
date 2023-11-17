package com.example.resepify;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentExplore extends Fragment {
    private RecyclerView exploreRv;
    private ArrayList<ListData> exploreItemList = new ArrayList<>();
    public FragmentExplore() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.explore_fragment, container, false);
        exploreRv = rootView.findViewById(R.id.explore_rv);
        exploreItemList = getExploreItemList();
        showRecyclerList();
        return rootView;
    }

    private ArrayList<ListData> getExploreItemList(){
        String[] dataName = getResources().getStringArray(R.array.listName);
        String[] dataTime = getResources().getStringArray(R.array.time);
        ArrayList<ListData> exploreItemArrayList = new ArrayList<>();
        for (int i=0; i<dataName.length; i++){
            ListData listData = new ListData();
            listData.setRecipe_name(dataName[i]);
            listData.setRecipe_time(dataTime[i]);
            exploreItemArrayList.add(listData);
        }
        return exploreItemArrayList;
    };

    private void showRecyclerList(){
        exploreRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        DataAdapter dataAdapter = new DataAdapter(exploreItemList);
        exploreRv.setAdapter(dataAdapter);
        dataAdapter.setOnItemClickCallback(this::showSelectedListdata);
    }
    private void showSelectedListdata(ListData listData){
        Intent intent = new Intent(getActivity(), DetailActivity.class);

        intent.putExtra("recipe_name", listData.getRecipe_name());
        intent.putExtra("recipe_time", listData.getRecipe_time());

        startActivity(intent);
    }
}