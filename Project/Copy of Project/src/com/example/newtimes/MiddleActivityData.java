package com.example.newtimes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;



public class MiddleActivityData extends ActionBarActivity {
    
   
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState); 
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	setContentView(R.layout.middle_activity_data);
    	
    	final Button b001 = (Button)findViewById(R.id.button21);
    	final EditText e01 = (EditText)findViewById(R.id.editText21);
    	final EditText e02 = (EditText)findViewById(R.id.editText1);
    	final RadioButton r1 = (RadioButton)findViewById(R.id.radio0); 
    	final RadioButton r2 = (RadioButton)findViewById(R.id.radio1);
    	final RadioButton r3 = (RadioButton)findViewById(R.id.radio2); 
    	final RadioButton r4 = (RadioButton)findViewById(R.id.radio3);
    	final RadioButton r5 = (RadioButton)findViewById(R.id.radio4);

    	
b001.setOnClickListener(new View.OnClickListener() {
    		
    		@Override public void onClick(View v) {
    			try{
    				Constants.zvalue=Float.parseFloat(e01.getText().toString());
    			}catch(Exception e){
    				Constants.zvalue=Constants.zvaluedefault;
    			}
    			
    			
    		
    			if (r1.isChecked()) Constants.onbackground=true; 
    			if (r2.isChecked()) Constants.onbackground=false;
    			if (r3.isChecked()) Constants.onincrdis=true; 
    			if (r4.isChecked()){
    				Constants.onincrspeed=true;
    				Constants.orbitalIncrementE=Constants.REALorbitalIncrementE/100;
    				Constants.orbitalIncrementV=Constants.REALorbitalIncrementV/100;
    				Constants.orbitalIncrementM=Constants.REALorbitalIncrementM/100;
    				Constants.orbitalIncrementMars=Constants.REALorbitalIncrementMars/100;
    				Constants.orbitalIncrementU=Constants.REALorbitalIncrementU/100;
    				Constants.orbitalIncrementJ=Constants.REALorbitalIncrementJ/100;
    				Constants.orbitalIncrementN=Constants.REALorbitalIncrementN/100;
    				Constants.orbitalIncrementS=Constants.REALorbitalIncrementS/100;
    				Constants.orbitalIncrementP=Constants.REALorbitalIncrementP/100;
    				Constants.orbitalIncrementSun=Constants.REALorbitalIncrementSun/100;
    				
    				Constants.ownIncrementE=Constants.REALownIncrementE/100;
    				Constants.ownIncrementV=Constants.REALownIncrementV/100;
    				Constants.ownIncrementM=Constants.REALownIncrementM/100;
    				Constants.ownIncrementMars=Constants.REALownIncrementMars/100;
    				Constants.ownIncrementU=Constants.REALownIncrementU/100;
    				Constants.ownIncrementJ=Constants.REALownIncrementJ/100;
    				Constants.ownIncrementN=Constants.REALownIncrementN/100;
    				Constants.ownIncrementS=Constants.REALownIncrementS/100;
    				Constants.ownIncrementP=Constants.REALownIncrementP/100;

    				
    			}
    			
    			if (r5.isChecked()) {
    				Constants.onchange=true;
    				Constants.ownIncrementE/=Constants.minif*5;
    				Constants.ownIncrementV/=Constants.minif*3.5;
    				Constants.ownIncrementM/=Constants.minif*4.5;
    				Constants.ownIncrementMars/=Constants.minif*3;
    				Constants.ownIncrementU/=Constants.minif;
    				Constants.ownIncrementJ/=Constants.minif;
    				Constants.ownIncrementN/=Constants.minif;
    				Constants.ownIncrementS/=Constants.minif;
    				Constants.ownIncrementP/=Constants.minif;
    				
    				Constants.orbitalIncrementE/=10*Constants.mconst;
    				Constants.orbitalIncrementV/=10*Constants.mconst;
    				Constants.orbitalIncrementM/=10*Constants.mconst;
    				Constants.orbitalIncrementMars/=10*Constants.mconst;
    				Constants.orbitalIncrementU/=10*Constants.mconst;
    				Constants.orbitalIncrementJ/=10*Constants.mconst;
    				Constants.orbitalIncrementN/=10*Constants.mconst;
    				Constants.orbitalIncrementS/=10*Constants.mconst;
    				Constants.orbitalIncrementP/=10*Constants.mconst;
    				Constants.orbitalIncrementSun/=10*Constants.mconst;
    				
    				Constants.increment=Constants.orbitalIncrementE;
    				Constants.radius=Constants.nvnradiusE;
    				Constants.radior=Constants.radorE;
    			}
    			
                  try{
                	  int f = 0;
					if (e02.getText().length() == 0)
						Constants.quality=70;
					else{
    				f=(int) Float.parseFloat(e02.getText().toString());
    				
    				if (f>1)
    					Constants.quality=f;
    				else
    					Constants.quality=100;
					}
    			}catch(Exception e){
    				Constants.quality=100;
    			}
    			
    			startActivity(new Intent(MiddleActivityData.this, ApplicationMainActivity.class));
    			
    			
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
