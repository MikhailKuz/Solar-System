package com.example.newtimes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class StartActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState); 
    	
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	setContentView(R.layout.start_activity);
    	
    	
    	final TextView t1=(TextView)findViewById(R.id.textView200);
    	t1.setOnClickListener(new View.OnClickListener() {
    		@Override public void onClick(View v) {
    			
    			} 
    		});
    	
    	final TextView t2=(TextView)findViewById(R.id.textView1);
    	t2.setOnClickListener(new View.OnClickListener() {
    		@Override public void onClick(View v) {
    			
    			} 
    		});
    	
    	final Button b1 = (Button)findViewById(R.id.button01);
    	b1.setOnClickListener(new View.OnClickListener() {
    		@Override public void onClick(View v) {
    			startActivity(new Intent(StartActivity.this, MiddleActivity.class));
    			} 
    		});
    	
    	

    final Button b2 = (Button)findViewById(R.id.button001);
	b2.setOnClickListener(new View.OnClickListener() {
		@Override public void onClick(View v) {
			int k;
			k=t1.getVisibility();
			if (k==0)
			t1.setVisibility(4);
			else t1.setVisibility(0);
			
			int k2;
			k2=t2.getVisibility();
			if (k2==0)
			t2.setVisibility(4);
			else t2.setVisibility(0);
			
			int k3;
			k3=b1.getVisibility();
			if (k3==0)
				b1.setVisibility(4);
			else
				b1.setVisibility(0);
			
			
			} 
		});
	  
	
	
 
	
	
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
