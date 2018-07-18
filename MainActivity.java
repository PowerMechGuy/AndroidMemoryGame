package com.apparatus.memory;

import android.app.*;
import android.os.*;
import android.view.View.OnClickListener;
import android.view.*;
import android.widget.Button;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener
{
	
	//for our hiscore (phase 4)
	SharedPreferences prefs; 
    String dataName = "MyData"; 
    String intName = "MyInt";
	int defaultInt = 0; 
    //both activities can see this
	public static int hiScore;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		//for our high score (phase 4) 
		//initialize our two SharedPreferences objects
		prefs = getSharedPreferences(dataName,MODE_PRIVATE);
		//Either load our High score or
		//if not available our default of 0 
		hiScore = prefs.getInt(intName, defaultInt);
		//Make a reference to the Hiscore textview in our layout 
		TextView textHiScore =(TextView) findViewById(R.id.textHiScore);
		//Display the hi score 
		textHiScore.setText("Hi: "+ hiScore);
		
		//Make a button from the button in our layout
		Button button =(Button) findViewById(R.id.button);
		//Make each it listen for clicks 
		button.setOnClickListener(this);
		
		
		
    }
	
	public void onClick(View view)
	{
		Intent i;
		i = new Intent(this, GameActivity.class);
		startActivity(i);
		
	}
}