package com.example.newtimes;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.opengl.GLSurfaceView;
import android.view.WindowManager;


public class ApplicationMainActivity extends ActionBarActivity {

	final SolarSystemRenderer sRenderer = new SolarSystemRenderer(this);
	 private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
	 private float mPreviousX;
	 private float mPreviousY;
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
    	WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	final GLSurfaceView view = new GLSurfaceView(this);
    	view.setEGLConfigChooser(8,8,8,8,16,0); 
        view.setRenderer(sRenderer);
        

        
        
       view.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event != null) {           
                    
                    final float x = 
                        (event.getX() / (float) v.getWidth()) * 2 - 1;
                    final float y = 
                        -((event.getY() / (float) v.getHeight()) * 2 - 1);
                    
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        view.queueEvent(new Runnable() {
                            @Override
                            public void run() {
                                sRenderer.handleTouchPress(
                                    x, y);
                            }
                        });
                    } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                       view.queueEvent(new Runnable() {
                            @Override
                            public void run() {
                            	  float dx = x - mPreviousX;
                                  float dy = y - mPreviousY;
                                  
                                  
           SolarSystemRenderer.setAngle(SolarSystemRenderer.getAngle() +((dx + dy) * TOUCH_SCALE_FACTOR));
                                          
                                  
                            }
                        });
                    }                    

                    mPreviousX = x;
                    mPreviousY = y;
                    return true;                    
                } else {
                    return false;
                }
            }
        });
       

       requestWindowFeature(Window.FEATURE_NO_TITLE);
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       
        setContentView(view);
        
    }
         
    
    
   
   







	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
