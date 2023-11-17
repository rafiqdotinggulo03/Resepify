package com.example.resepify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;


import com.example.resepify.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                fragment = new FragmentHome();
            } else if (itemId == R.id.navigation_explore) {
                fragment = new FragmentExplore();
            } else if (itemId == R.id.navigation_account) {
                fragment = new FragmentAccount();
            }
            if (fragment != null) {
                switchFragment(fragment);
                return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navigationBar.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        if(savedInstanceState == null){
            binding.navigationBar.setSelectedItemId(R.id.navigation_home);
        }

    }

    private void switchFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container_layout, fragment, fragment.getClass().getSimpleName()).commit();
    }
}