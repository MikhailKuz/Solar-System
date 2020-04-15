package com.example.newtimes;

import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class Ring {
	
     float firstrad;
     float secrad;
     float quality;
    
     private int[ ] textures = new int[1];
 	
     FloatBuffer m_VertexData;
     FloatBuffer m_NormalData;
     FloatBuffer m_ColorData;
     FloatBuffer m_TextureData;
     public float[] m_Pos = {0.0f, 0.0f, 0.0f};
     
     public Ring(float firstrad,float secrad,float quality, GL10 gl, Context context, boolean imageId, int resourceId){
    	 this.firstrad=firstrad;
    	 this.secrad=secrad;
    	 this.quality=quality;
    	 
    	 init(firstrad,secrad,quality, gl, context, imageId, resourceId);
     }
     
     private void init(float firstrad,float secrad,float quality, GL10 gl,Context context, boolean imageId, int resourceId){

 		float[] vertexData; 
 		float[] normalData; 	
 		float[] colorData; 
 		float[] textData=null; 
 		int vIndex=0; 
		int cIndex=0; 
		int nIndex=0; 
		int tIndex=0; 
		if(imageId == true) 
		createTexture(gl, context, resourceId, imageId); 
		
		vertexData = new float[ (int) (3*quality)]; 
		colorData = new float[ (int) (4*quality)]; 
		normalData = new float[(int) (3*quality)]; 
		
		if(imageId == true) 
		textData = new float [(int) (2 * quality)];
		
		float angleincr=360/(quality/2)/10;
		float angle=angleincr;
		
		for (int i=1;i<(quality/2);i++){
			
			vertexData[vIndex+0]=(float) (Math.cos(angle)*secrad);
			vertexData[vIndex+1]=0f;
			vertexData[vIndex+2]=-((float) (Math.sin(angle)*secrad));
			vertexData[vIndex+3]=(float) (Math.cos(angle)*firstrad);
			vertexData[vIndex+4]=0f;
			vertexData[vIndex+5]=-((float) (Math.sin(angle)*firstrad));
			
			
			colorData[cIndex+0]=0f;
			colorData[cIndex+1]=1f;
			colorData[cIndex+2]=1f;
			colorData[cIndex+3]=1f;
			colorData[cIndex+4]=1f;
			colorData[cIndex+5]=1f;
			colorData[cIndex+6]=1f;
			colorData[cIndex+7]=1f;
			
			normalData[nIndex + 0] = (float) (Math.cos(angle)*secrad); 
			normalData[nIndex + 1] = 0f;
			normalData[nIndex + 2] = -((float) (Math.sin(angle)*secrad));
			normalData[nIndex + 3] = (float) (Math.cos(angle)*firstrad); 
			normalData[nIndex + 4] = 0f;
			normalData[nIndex + 5] = -((float) (Math.sin(angle)*firstrad));
			
			
	
			textData [tIndex + 0] = 1.0f; 
			textData [tIndex + 1] = 1.0f; 
			textData [tIndex + 2] = 0.0f; 
			textData [tIndex + 3] = 0.0f; 
			
			cIndex+=2*4; 
			vIndex+=2*3; 
			nIndex+=2*3; 
			if(textData!=null) 
			tIndex+= 2*2; 
			angle+=angleincr;
			
		}
		
		
		m_Pos[0]= 0.0f; 
		m_Pos[1]= 0.0f; 
		m_Pos[2]= 0.0f; 
		m_VertexData = Planet.makeFloatBuffer(vertexData);
		m_ColorData = Planet.makeFloatBuffer(colorData);
		m_NormalData = Planet.makeFloatBuffer(normalData);
		if(textData!= null) 
		m_TextureData = Planet.makeFloatBuffer(textData);
     }
     
     public int createTexture(GL10 gl, Context contextRegf, int resource, boolean
    			imageID)
    			{
    			Bitmap tempImage = BitmapFactory.decodeResource(
    			contextRegf.getResources(), resource); 
    			if (imageID == true) {
    			gl.glGenTextures(1, textures, 0);
    			gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
    			}
    			GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, tempImage, 0);
    			
    			gl.glTexParameterf(GL10.GL_TEXTURE_2D,
    			GL10.GL_TEXTURE_MIN_FILTER,
    			GL10.GL_LINEAR);
    			gl.glTexParameterf(GL10.GL_TEXTURE_2D,
    			GL10.GL_TEXTURE_MAG_FILTER,
    			GL10.GL_LINEAR);
    			
    			tempImage.recycle(); 
    			return resource;
    			}
     
     public void setPosition(float x, float y, float z)
     {
     m_Pos[0] = x;
     m_Pos[1] = y;
     m_Pos[2] = z;
     }

     public void draw(GL10 gl)
     {
    	 gl.glEnable(GL10.GL_BLEND);
    	 gl.glBlendFunc(GL10.GL_ONE, GL10.GL_ONE);    
    	 gl.glFrontFace(GL11.GL_CW);
    	 gl.glMatrixMode(GL10.GL_MODELVIEW);
    	 gl.glEnable(GL10.GL_CULL_FACE);
    	 gl.glCullFace(GL10.GL_BACK);
    	 gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
    	 gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
    	 gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
    	 if(m_TextureData != null)
    	 {
    	 gl.glEnable(GL10.GL_TEXTURE_2D); 
    	 gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
    	 gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
    	 gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_TextureData);
    	 }
    	 gl.glMatrixMode(GL10.GL_MODELVIEW);
    	 gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexData);
    	 gl.glNormalPointer(GL10.GL_FLOAT, 0, m_NormalData);
    	 gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorData);
    	 gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, (int) quality);
    	 gl.glDisable(GL10.GL_BLEND);
    	 gl.glDisable(GL10.GL_TEXTURE_2D);
    	 gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
    	 gl.glFrontFace(GL11.GL_CCW);
     }
}
