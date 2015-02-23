package com.example.matthew.myapplication;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends ActionBarActivity {

    private final String TAG = "Yolo!";
    RelativeLayout background;
    ImageButton event, calendar, forum, welfare, timetable, video, mark, facebook;
    Button yybutton, xxbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frontpage_layout);
        Log.d(TAG, "onCreate");

        //background = (LinearLayout) findViewById(R.id.linearlayout);
        background = (RelativeLayout)findViewById(R.id.frontpage_layout);
        xxbutton = (ImageButton) findViewById(R.id.xxbutton);
        yybutton = (Button) findViewById(R.id.yybutton);
        event = (ImageButton)findViewById(R.id.event);
        calendar = (ImageButton)findViewById(R.id.calendar);
        forum = (ImageButton)findViewById(R.id.forum);
        welfare = (ImageButton)findViewById(R.id.welfare);
        timetable = (ImageButton)findViewById(R.id.timetable);
        video = (ImageButton)findViewById(R.id.video);
        mark = (ImageButton)findViewById(R.id.mark);
        facebook = (ImageButton)findViewById(R.id.facebook);

        xxbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //wt happens when button is clicked
                background.setBackgroundColor(Color.parseColor("#00ff00"));
            }
        });
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        yybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(Color.parseColor("#006699"));
            }
        });



    }

    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart");
    }

    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume");
    }

    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause");
    }

    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
