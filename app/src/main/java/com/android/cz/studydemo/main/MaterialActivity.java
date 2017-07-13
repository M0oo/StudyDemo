package com.android.cz.studydemo.main;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.cz.studydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MaterialActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.mm_img)
    public ImageView mm_img;
    @BindView(R.id.collaps_bar)
    public CollapsingToolbarLayout collaps_bar;
    @BindView(R.id.float_btn)
    public FloatingActionButton float_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        if(bar != null){
            bar.setDisplayHomeAsUpEnabled(true); //设置左边的图标为返回键
        }
        collaps_bar.setTitle("Material Design");

    }

    @OnClick(R.id.float_btn)
    public void showSnackToast(){
        Snackbar.make(float_btn,"Click the Floatacitonbutton",Snackbar.LENGTH_LONG)
                .setAction("Cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MaterialActivity.this,"do something",Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: //系统默认的返回id
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
