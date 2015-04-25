package com.example.matthew.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;


public class FrontPageActivity extends ActionBarActivity {
    ImageButton eventbutton;
    ImageButton calendarbutton;
    ImageButton forumbutton;
    ImageButton welfarebutton;
    ImageButton timetablebutton;
    ImageButton videobutton;
    ImageButton markbutton;
    ImageButton facebookbutton;

    RelativeLayout background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frontpage_layout);

        background = (RelativeLayout) findViewById(R.id.frontpage_layout);
        eventbutton = (ImageButton) findViewById(R.id.event);
        calendarbutton = (ImageButton) findViewById(R.id.calendar);
        forumbutton = (ImageButton) findViewById(R.id.forum);
        welfarebutton = (ImageButton) findViewById(R.id.welfare);
        timetablebutton = (ImageButton) findViewById(R.id.timetable);
        videobutton = (ImageButton) findViewById(R.id.video);
        markbutton = (ImageButton) findViewById(R.id.mark);
        facebookbutton = (ImageButton) findViewById(R.id.facebook);

        eventbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), EventListActivity.class);
                startActivity(intent);
            }
        });
        calendarbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //Intent intent = new Intent(view.getContext(), EventListActivity.class);
                //startActivity(intent);
            }
        });
    }



    //@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_front_page, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }
}
