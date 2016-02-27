package com.iquarkt.buttonclick1;

//import android.support.v7.app.ActionBarActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity
{
    private RelativeLayout relLayout = null;
    private Button myButton = null;
    private int clickCount  = 0;
    private String TAG = "ClickMe";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        if(savedInstanceState != null)
        {
            clickCount = savedInstanceState.getInt("clickCount");
        }

        this.myButton  = (Button)this.findViewById(R.id.button1);
        this.relLayout = (RelativeLayout)this.findViewById(R.id.layout1);

        myButton.setText("Click Me: "+clickCount);

        this.myButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ++clickCount;
                myButton.setText("Click Me: " + clickCount);
                Log.i(TAG, "Click count: "+clickCount);

                // toggle the background color
                if (clickCount % 2 == 0) {
                    relLayout.setBackgroundColor(0xFFFF0000);
                } else {
                    relLayout.setBackgroundColor(0xFF0000FF);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("clickCount", clickCount);
        super.onSaveInstanceState(outState);
    }
}

