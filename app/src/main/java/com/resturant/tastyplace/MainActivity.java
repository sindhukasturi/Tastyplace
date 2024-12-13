package com.resturant.tastyplace;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import com.resturant.tastyplace.R;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the default fragment
        loadFragment(new HomeFragment());

         bottomNavigationView =findViewById(R.id.bottomNavigationView);

        // Using a more explicit listener approach with anonymous class
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.about:
                        selectedFragment = new AboutFragment();
                        break;
                }

                // If a valid fragment is selected, load it
                if (selectedFragment != null) {
                    loadFragment(selectedFragment);
                }
                return true;
            }
        });
    }

    /**
     * Method to load the selected fragment into the container
     *
     * @param fragment Fragment to load
     * @return true if fragment is successfully loaded, false otherwise
     */
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
