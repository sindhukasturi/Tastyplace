package com.resturant.tastyplace;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView menuRecyclerView;
    private MenuAdapter menuAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        // Initialize RecyclerView for menu
        menuRecyclerView = view.findViewById(R.id.menuRecyclerView);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<RestaurantMenuItem> menuItems = new ArrayList<>();
        menuItems.add(new RestaurantMenuItem("Spaghetti Carbonara", "Creamy pasta with bacon", R.drawable.spaghetti));
        menuItems.add(new RestaurantMenuItem("Margherita Pizza", "Classic pizza with fresh basil", R.drawable.pizza));
        menuItems.add(new RestaurantMenuItem("Caesar Salad", "Crispy romaine with parmesan", R.drawable.salad));

        menuAdapter = new MenuAdapter(menuItems);
        menuRecyclerView.setAdapter(menuAdapter);

        return view;
    }
}
