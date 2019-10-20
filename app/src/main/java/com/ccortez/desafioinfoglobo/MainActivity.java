package com.ccortez.desafioinfoglobo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ccortez.desafioinfoglobo.fragments.NewsListFragment;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    public Fragment currentFragment;
    public Context mContext = null;
    private static final String TAG = MainActivity.class.getSimpleName();
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        Picasso.setSingletonInstance(new Picasso.Builder(this).build());

        currentFragment = new NewsListFragment();

        loadFragment(currentFragment);

    }

    public boolean loadFragment(Fragment fragment){
        if(fragment != null){
            currentFragment = fragment;
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public boolean removeFragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
