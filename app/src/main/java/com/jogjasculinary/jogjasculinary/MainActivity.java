package com.jogjasculinary.jogjasculinary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

import com.jogjasculinary.jogjasculinary.fragment.CartFragment;
import com.jogjasculinary.jogjasculinary.fragment.HomeFragment;
import com.jogjasculinary.jogjasculinary.fragment.ProfileFragment;
import com.jogjasculinary.jogjasculinary.fragment.SearchFragment;
import com.jogjasculinary.jogjasculinary.helper.BottomNavigationBehavior;


public class MainActivity extends AppCompatActivity {

    HomeFragment home;
    SearchFragment search;
    CartFragment cart;
    ProfileFragment profil;

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        // load the store fragment by default
        toolbar.setTitle("Home");
        loadFragment(new HomeFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            ProfileFragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolbar.setTitle("Home");
                    home = new HomeFragment();
                    loadFragment(home);
                    return true;
                case R.id.navigation_search:
                    toolbar.setTitle("Search");
                    search = new SearchFragment();
                    loadFragment(search);
                    return true;
                case R.id.navigation_cart:
                    toolbar.setTitle("Cart");
                    cart = new CartFragment();
                    loadFragment(cart);
                    return true;
                case R.id.navigation_profile:
                    toolbar.setTitle("Profile");
                    profil = new ProfileFragment();
                    loadFragment(profil);
                    return true;
            }

            return false;
        }
    };

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
