package com.example.drawenavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.drawenavigation.Adapter.AdapterContacts;
import com.example.drawenavigation.Model.Contacts;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener, SearchView.OnQueryTextListener {
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    DrawerLayout dl;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ListView listView;
    ArrayList<Contacts> contactsArrayList;
    AdapterContacts adapterContacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //nav bottom
        bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //drawer nav
        dl=findViewById(R.id.nav_drawer);
        navigationView=(NavigationView)findViewById(R.id.nav_view);
        toggle=new ActionBarDrawerToggle(this,dl,toolbar,R.string.open,R.string.close);
        dl.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.user:
                        Toast.makeText(MainActivity.this, "UserName", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.location:
                        Toast.makeText(MainActivity.this, "Location", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.cart:
                        Toast.makeText(MainActivity.this, "Cart", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return true;
            }
        });
        //searchview
        listView=findViewById(R.id.list_view);

        contactsArrayList=new ArrayList<>();
        contactsArrayList.add(new Contacts("Hoang Van Vinh","Vinh haong",R.drawable.admin));
        contactsArrayList.add(new Contacts("Hoang Van Vinh","Vinh haong",R.drawable.admin));
        contactsArrayList.add(new Contacts("Hoang Van Vinh","Vinh haong",R.drawable.admin));
        contactsArrayList.add(new Contacts("Hoang Van Vinh","Vinh haong",R.drawable.admin));
        contactsArrayList.add(new Contacts("Hoang Van Vinh","Vinh haong",R.drawable.admin));
        adapterContacts=new AdapterContacts(this,contactsArrayList,R.layout.item_listview);
        listView.setAdapter(adapterContacts);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Toast.makeText(this, "yeu thich", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_setting:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(this, "searchView", Toast.LENGTH_SHORT).show();
                return true;
        }
            return super.onOptionsItemSelected(item);
        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.navigation_home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.navigation_sms:
                Toast.makeText(this, "SMS", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.navigation_notifications:
                Toast.makeText(this, "Notifition", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.location:
                Toast.makeText(this, "Location", Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
