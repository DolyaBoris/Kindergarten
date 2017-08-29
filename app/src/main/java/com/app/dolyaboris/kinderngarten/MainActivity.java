package com.app.dolyaboris.kinderngarten;

import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private InformationFragment informationFragment;
    private HomeFragment homeFragment;
    private AlbumFragment albumFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        informationFragment = new InformationFragment();
        homeFragment = new HomeFragment();
        albumFragment = new AlbumFragment();



        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.activity_main_bottom_navigation);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.activity_main_container_frame_layout, informationFragment)
                .commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_information:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main_container_frame_layout, informationFragment)
                        .commit();
                break;

            case R.id.action_chat_room:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main_container_frame_layout, albumFragment)
                        .commit();
                break;

            case R.id.action_home:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main_container_frame_layout, homeFragment)
                        .commit();
                break;

        }
        return false;
    }
}
