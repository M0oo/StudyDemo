package com.android.cz.studydemo.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.cz.studydemo.Notification.NotificationActivity;
import com.android.cz.studydemo.R;
import com.android.cz.studydemo.TestToolBarActivity;
import com.android.cz.studydemo.tablayout.TabLayoutActivity;
import com.android.cz.studydemo.weixintab.TintDrawableActivity;
import com.android.cz.studydemo.weixintab.WeiXinTabActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyvlerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        recyvlerView = (RecyclerView) findViewById(R.id.recyvlerView);
        //设置布局方向
        //1.LinearLayoutManager  线性布局，可以横向或纵向
        //2.GridLayoutManager    网格布局，类似GridView
        //3.StaggeredGridLayoutManager   流式布局
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyvlerView.setLayoutManager(manager);
        //设置添加/删除item的动画
        DefaultItemAnimator anim = new DefaultItemAnimator();
        recyvlerView.setItemAnimator(anim);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        recyvlerView.setAdapter(adapter);
        //设置divider
        recyvlerView.addItemDecoration(new LinearDividerItemDecoration(this,LinearDividerItemDecoration.VERTICAL_LIST));

        adapter.setListener(new RecyclerViewAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view) {
                int position = (int) view.getTag();
                String s = InitDatas.init().listDatas.get(position);
                if(s.equals("TabLayout")){
                    startActivity(new Intent(MainActivity.this, TabLayoutActivity.class));
                }else if(s.equals("Notifacation")){
                    startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                }else if (s.equals("Weixin")){
                    startActivity(new Intent(MainActivity.this, WeiXinTabActivity.class));
                }
                else if (s.equals("TintDrawable")){
                    startActivity(new Intent(MainActivity.this, TintDrawableActivity.class));
                }
                else if (s.equals("Material")){
                    startActivity(new Intent(MainActivity.this, MaterialActivity.class));
                }


                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        });

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.action_to_testboolbar){
            startActivity(new Intent(MainActivity.this,TestToolBarActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
