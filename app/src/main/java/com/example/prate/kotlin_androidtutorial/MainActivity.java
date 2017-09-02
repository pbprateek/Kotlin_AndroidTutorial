package com.example.prate.kotlin_androidtutorial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FirstFragment fragment=new FirstFragment();
        FragmentTransaction fragmentTransactio=getSupportFragmentManager().beginTransaction();
        fragmentTransactio.replace(R.id.frame,fragment,"Frag");
        fragmentTransactio.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.chapter1) {
            FirstFragment fragment=new FirstFragment();
            FragmentTransaction fragmentTransactio=getSupportFragmentManager().beginTransaction();
            fragmentTransactio.replace(R.id.frame,fragment,"Frag");
            fragmentTransactio.commit();
        } else if (id == R.id.chapter2) {
            SecondFragment fragment2=new SecondFragment();
            FragmentTransaction fragmentTransactio=getSupportFragmentManager().beginTransaction();
            fragmentTransactio.replace(R.id.frame,fragment2,"Frag");
            fragmentTransactio.commit();

        }  else if (id == R.id.nav_send2) {
            AboutFragment fragment=new AboutFragment();
            FragmentTransaction fragmentTransactio=getSupportFragmentManager().beginTransaction();
            fragmentTransactio.replace(R.id.frame,fragment,"Frag");
            fragmentTransactio.commit();

        } else if (id == R.id.nav_send) {
            Intent sendIntent = new Intent();
            sendIntent.setData(Uri.parse("mailto:"));
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, "feedback");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Feedback");
            sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "pbpratek2@gmail.com" });
            sendIntent.setType("text/plain");

// Verify that the intent will resolve to an activity
            if (sendIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(sendIntent);
            }

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
