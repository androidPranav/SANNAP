package com.example.admin.sannap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.admin.sannap.Adapter.TodayBodyAdapter;
import com.example.admin.sannap.BE.TodayBean;

public class TodayBody extends AppCompatActivity  {

    RecyclerView listBooking;
    ImageButton btnBody;
    TodayBodyAdapter objTodayBodyAdapter;

    TodayBean objTodayBean;

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_body);
        initialize();

        objTodayBodyAdapter=new TodayBodyAdapter(getApplicationContext());
        listBooking.setAdapter(objTodayBodyAdapter);

        btnBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(objTodayBodyAdapter.mSelectedItem<0){
                    objTodayBean.setBody("");
                } else {
                   // Log.d("BODY",objTodayBodyAdapter.mapBody.values().toString().replace("[","").replace("]",""));
                    objTodayBean.setBody(objTodayBodyAdapter.mapBody.values().toString().replace("[","").replace("]",""));
                }
                intent.putExtra("TodayBean",objTodayBean);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

        private void initialize(){

        listBooking= (RecyclerView) findViewById(R.id.body_list);
            btnBody= (ImageButton) findViewById(R.id.body_ok);
            listBooking.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listBooking.setLayoutManager(llm);

            intent=getIntent();
            objTodayBean= (TodayBean) intent.getSerializableExtra("TodayBean");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {


            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
