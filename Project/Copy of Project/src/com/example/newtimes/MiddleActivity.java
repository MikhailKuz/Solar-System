package com.example.newtimes;

import java.io.PrintStream;
import java.util.Scanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MiddleActivity extends ActionBarActivity {
    public static int k=0;
    public static float [] [] kord=new float [10][3];
    public static float [] mas=new float [10];
    public static float [] speed= new float [10];
   
    public static Scanner in = new Scanner(System.in);
	public static PrintStream out = System.out;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState); 
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	setContentView(R.layout.middle_activity);
    	final Button b01 = (Button)findViewById(R.id.button1);
    	final Button b02 = (Button)findViewById(R.id.button2);
    	
    	final EditText e1 = (EditText)findViewById(R.id.editText1);
    	final EditText e2 = (EditText)findViewById(R.id.EditText2);
    	final EditText e3 = (EditText)findViewById(R.id.EditText3);
    	final EditText e4 = (EditText)findViewById(R.id.EditText4);
    	final TextView v1 = (TextView)findViewById(R.id.textView1);
    	final ImageView i1 = (ImageView)findViewById(R.id.imageView1);
    	
    	
    	
    	b01.setOnClickListener(new View.OnClickListener() {
    		
    		@Override public void onClick(View v) {
    			
    			if (k!=10){
    			    try{
    			    	if (e1.getText().length() == 0)
    			    	{
    			    		if (k==0) kord[k][0]=Constants.koordE[0];
        			    	if (k==1) kord[k][0]=Constants.koordV[0];
        			    	if (k==2) kord[k][0]=Constants.koordM[0];
        			    	if (k==3) kord[k][0]=Constants.koordMars[0];
        			    	if (k==4) kord[k][0]=Constants.koordU[0];
        			    	if (k==5) kord[k][0]=Constants.koordJ[0];
        			    	if (k==6) kord[k][0]=Constants.koordN[0];
        			    	if (k==7) kord[k][0]=Constants.koordS[0];
        			    	if (k==8) kord[k][0]=Constants.koordP[0];
        			    	if (k==9) kord[k][0]=Constants.koordSun[0];
    			    	}else
    					kord[k][0]=Float.parseFloat(e1.getText().toString());
    					
    			    } catch (Exception e){
    			    	if (k==0) kord[k][0]=Constants.koordE[0];
    			    	if (k==1) kord[k][0]=Constants.koordV[0];
    			    	if (k==2) kord[k][0]=Constants.koordM[0];
    			    	if (k==3) kord[k][0]=Constants.koordMars[0];
    			    	if (k==4) kord[k][0]=Constants.koordU[0];
    			    	if (k==5) kord[k][0]=Constants.koordJ[0];
    			    	if (k==6) kord[k][0]=Constants.koordN[0];
    			    	if (k==7) kord[k][0]=Constants.koordS[0];
    			    	if (k==8) kord[k][0]=Constants.koordP[0];
    			    	if (k==9) kord[k][0]=Constants.koordSun[0];
    			    	
    			    }
    			    try{
    			    	if (e2.getText().length() == 0)
    			    	{
    			    		if (k==0) kord[k][2]=Constants.koordE[2];
        			    	if (k==1) kord[k][2]=Constants.koordV[2];
        			    	if (k==2) kord[k][2]=Constants.koordM[2];
        			    	if (k==3) kord[k][2]=Constants.koordMars[2];
        			    	if (k==4) kord[k][2]=Constants.koordU[2];
        			    	if (k==5) kord[k][2]=Constants.koordJ[2];
        			    	if (k==6) kord[k][2]=Constants.koordN[2];
        			    	if (k==7) kord[k][2]=Constants.koordS[2];
        			    	if (k==8) kord[k][2]=Constants.koordP[2];
        			    	if (k==9) kord[k][2]=Constants.koordSun[2];
        			    	
    			    	}else
    			    	kord[k][2]=-Float.parseFloat(e2.getText().toString());
    			    	
    			    } catch(Exception e){
    			    	if (k==0) kord[k][2]=Constants.koordE[2];
    			    	if (k==1) kord[k][2]=Constants.koordV[2];
    			    	if (k==2) kord[k][2]=Constants.koordM[2];
    			    	if (k==3) kord[k][2]=Constants.koordMars[2];
    			    	if (k==4) kord[k][2]=Constants.koordU[2];
    			    	if (k==5) kord[k][2]=Constants.koordJ[2];
    			    	if (k==6) kord[k][2]=Constants.koordN[2];
    			    	if (k==7) kord[k][2]=Constants.koordS[2];
    			    	if (k==8) kord[k][2]=Constants.koordP[2];
    			    	if (k==9) kord[k][2]=Constants.koordSun[2];
    			    }
    			    	kord[k][1]=0f;
    			
    			    	try{	
        			    	if (e3.getText().length()==0){
        			    		if (k==0) mas[k]=-1;
            			    	if (k==1) mas[k]=-1;
            			    	if (k==2) mas[k]=-1;
            			    	if (k==3) mas[k]=-1;
            			    	if (k==4) mas[k]=-1;
            			    	if (k==5) mas[k]=-1;
            			    	if (k==6) mas[k]=-1;
            			    	if (k==7) mas[k]=-1;
            			    	if (k==8) mas[k]=-1;
            			    	if (k==9) mas[k]=-1;
        			    	}else
        			    	mas[k]=Float.parseFloat(e3.getText().toString());
        			    } catch(Exception e){
        			    	if (k==0) mas[k]=-1;
        			    	if (k==1) mas[k]=-1;
        			    	if (k==2) mas[k]=-1;
        			    	if (k==3) mas[k]=-1;
        			    	if (k==4) mas[k]=-1;
        			    	if (k==5) mas[k]=-1;
        			    	if (k==6) mas[k]=-1;
        			    	if (k==7) mas[k]=-1;
        			    	if (k==8) mas[k]=-1;
        			    	if (k==9) mas[k]=-1;
        			    }
        			    try{
        			    	if (e4.getText().length()==0){
        			    		if (k==0) speed[k]=-1;
            			    	if (k==1) speed[k]=-1;
            			    	if (k==2) speed[k]=-1;
            			    	if (k==3) speed[k]=-1;
            			    	if (k==4) speed[k]=-1;
            			    	if (k==5) speed[k]=-1;
            			    	if (k==6) speed[k]=-1;
            			    	if (k==7) speed[k]=-1;
            			    	if (k==8) speed[k]=-1;
            			    	if (k==9) speed[k]=-1;
        			    	}else
        			    	speed[k]=Float.parseFloat(e4.getText().toString());
        			    } catch(Exception e){
        			    	if (k==0) speed[k]=-1;
        			    	if (k==1) speed[k]=-1;
        			    	if (k==2) speed[k]=-1;
        			    	if (k==3) speed[k]=-1;
        			    	if (k==4) speed[k]=-1;
        			    	if (k==5) speed[k]=-1;
        			    	if (k==6) speed[k]=-1;
        			    	if (k==7) speed[k]=-1;
        			    	if (k==8) speed[k]=-1;
        			    	if (k==9) speed[k]=-1;
        			    }
    			
    			    
    			e1.setText("");
    			e2.setText("");
    			e3.setText("");
    			e4.setText("");
    			}
    			k++;
    			if (k==10){
    				startActivity(new Intent(MiddleActivity.this, ApplicationMainActivity.class));
    			}
    			switch(k){
    			case 1:v1.setText("бемепю");i1.setImageResource(R.drawable.venusstart);break;
    			case 2:v1.setText("лепйспхи");i1.setImageResource(R.drawable.mercuriqstart);break;
    			case 3:v1.setText("люпя");i1.setImageResource(R.drawable.marsstaart);break;
    			case 4:v1.setText("спюм");i1.setImageResource(R.drawable.uranstart);break;
    			case 5:v1.setText("чохреп");i1.setImageResource(R.drawable.upiterstart);break;
    			case 6:v1.setText("меорсм");i1.setImageResource(R.drawable.neptunstart);break;
    			case 7:v1.setText("яюрспм");i1.setImageResource(R.drawable.saturnstaart);break;
    			case 8:v1.setText("оксрнм");i1.setImageResource(R.drawable.plutonstart);break;
    			case 9:
    			       v1.setText("янкмже");
    			       i1.setImageResource(R.drawable.sunstart);
    			       e1.setEnabled(false);
    			       e2.setEnabled(false);
    			       break;
    		      
    			
    			
    			}
    			
    			}
    			
    			
    		});
    	
b02.setOnClickListener(new View.OnClickListener() {
    		
    		@Override public void onClick(View v) {

    		Constants.ondefault=true;	
    		startActivity(new Intent(MiddleActivity.this, MiddleActivityData.class));
    			
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
