package com.example.multiplelistfilterarraylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Dish> indianDishList;
    private List<Dish> americanDishList;
    private List<Dish> spanishDishList;
    private List<Dish> filteredDishList;
    private RecyclerView indianRecyclerView;
    private RecyclerView americanRecyclerView;
    private RecyclerView spanishRecyclerView;
    private EditText searchEditText;
    private DishAdapter indianDishAdapter;
    private DishAdapter americanDishAdapter;
    private DishAdapter spanishDishAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initialize dish lists
        indianDishList = generateIndianDishList();
        americanDishList = generateAmericanDishList();
        spanishDishList = generateSpanishDishList();

        // Initialize filtered dish list with all dishes
        filteredDishList = new ArrayList<>();
        filteredDishList.addAll(indianDishList);
        filteredDishList.addAll(americanDishList);
        filteredDishList.addAll(spanishDishList);

        // Initialize RecyclerViews and set adapters
        indianRecyclerView = findViewById(R.id.indianRecyclerView);
        indianRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        indianDishAdapter = new DishAdapter(filteredDishList);
        indianRecyclerView.setAdapter(indianDishAdapter);

        americanRecyclerView = findViewById(R.id.americanRecyclerView);
        americanRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        americanDishAdapter = new DishAdapter(filteredDishList);
        americanRecyclerView.setAdapter(americanDishAdapter);

        spanishRecyclerView = findViewById(R.id.spanishRecyclerView);
        spanishRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        spanishDishAdapter = new DishAdapter(filteredDishList);
        spanishRecyclerView.setAdapter(spanishDishAdapter);

        // Initialize search EditText and add TextWatcher
        searchEditText = findViewById(R.id.searchEditText);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Filter all dish lists based on the search input
                filterDishLists(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not needed
            }
        });

    }

    private List<Dish> generateIndianDishList() {
        // Generate a list of Indian dishes
        List<Dish> indianDishList = new ArrayList<>();
        indianDishList.add(new Dish(1, "Biryani"));
        indianDishList.add(new Dish(2, "Butter Chicken"));
        indianDishList.add(new Dish(3, "Tandoori Chicken"));
        return indianDishList;
    }

    private List<Dish> generateAmericanDishList() {
        // Generate a list of American dishes
        List<Dish> americanDishList = new ArrayList<>();
        americanDishList.add(new Dish(1, "Hamburger"));
        americanDishList.add(new Dish(2, "Hotdog"));
        return americanDishList;
    }

    private List<Dish> generateSpanishDishList() {
        // Generate a list of Spanish dishes
        List<Dish> spanishDishList = new ArrayList<>();
        spanishDishList.add(new Dish(1, "Paella"));

        return spanishDishList;
    }

//    private void filterDishLists(String searchText) {
//
//        filteredDishList.clear();
//
//        // Filter the Indian dish list
//        for (Dish dish : indianDishList) {
//            if (dish.getDishName().toLowerCase().contains(searchText.toLowerCase())) {
//                filteredDishList.add(dish);
//            }
//        }
//        indianDishAdapter.notifyDataSetChanged();
//
//        // Filter the American dish list
//        for (Dish dish : americanDishList) {
//            if (dish.getDishName().toLowerCase().contains(searchText.toLowerCase())) {
//                filteredDishList.add(dish);
//            }
//        }
//        americanDishAdapter.notifyDataSetChanged();
//
//        // Filter the Spanish dish list
//        for (Dish dish : spanishDishList) {
//            if (dish.getDishName().toLowerCase().contains(searchText.toLowerCase())) {
//                filteredDishList.add(dish);
//            }
//        }
//        spanishDishAdapter.notifyDataSetChanged();
//    }

    private void filterDishLists(String searchText) {
        filteredDishList.clear();

        // Filter the Indian dish list
        for (int i = 0; i < indianDishList.size(); i++) {
            Dish dish = indianDishList.get(i);
            if (dish.getDishName().toLowerCase().contains(searchText.toLowerCase())) {
                filteredDishList.add(dish);
            }
        }
        indianDishAdapter.notifyDataSetChanged();

        // Filter the American dish list
        for (int i = 0; i < americanDishList.size(); i++) {
            Dish dish = americanDishList.get(i);
            if (dish.getDishName().toLowerCase().contains(searchText.toLowerCase())) {
                filteredDishList.add(dish);
            }
        }
        americanDishAdapter.notifyDataSetChanged();

        // Filter the Spanish dish list
        for (int i = 0; i < spanishDishList.size(); i++) {
            Dish dish = spanishDishList.get(i);
            if (dish.getDishName().toLowerCase().contains(searchText.toLowerCase())) {
                filteredDishList.add(dish);
            }
        }
        spanishDishAdapter.notifyDataSetChanged();
    }
}