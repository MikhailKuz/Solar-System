package com.example.newtimes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10; 
import javax.microedition.khronos.opengles.GL11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;
public class Planet
{
   
	private int[ ] textures = new int[1];
	int m_BumpmapID;
	boolean resourceIdBump=false;
	
     FloatBuffer m_VertexData;
     FloatBuffer m_NormalData;
     FloatBuffer m_ColorData;
     FloatBuffer m_TextureData;
     float m_Scale;
     float m_Squash;
     float m_Radius;
     int m_Stacks, m_Slices;
     public float[] m_Pos = {0.0f, 0.0f, 0.0f};
     
     
  public Planet(int stacks, int slices, float radius, float squash, GL10 gl, Context
    		 context, boolean imageId,boolean imageIdBump, int resourceId, int resourceIdBump)
    		 {
    		 this.m_Stacks = stacks;
    		 this.m_Slices = slices;
    		 this.m_Radius = radius;
    		 this.m_Squash = squash;
    		 this.resourceIdBump=imageIdBump;
    		 init(m_Stacks,m_Slices,radius,squash, gl, context, imageId,imageIdBump, resourceId, resourceIdBump);
    		 }
public void setPosition(float x, float y, float z)
{
m_Pos[0] = x;
m_Pos[1] = y;
m_Pos[2] = z;
}




private void init(int stacks,int slices, float radius, float squash, GL10 gl,
Context context, boolean imageId,boolean imageIdBump, int resourceId, int resourceIdBump) 
{
	 
		float[] vertexData; 
		float[] normalData; 	
		float[] colorData; 
		float[] textData=null; 
		float colorIncrement=0f; 
		float blue=0f; 
		float red=1.0f; 
		int vIndex=0; 
		int cIndex=0; 
		int nIndex=0; 
		int tIndex=0; 
		
		if(imageId == true)
		createTexture(gl, context, resourceId, imageId);
		
		if (imageIdBump!=false)
			m_BumpmapID = createTexture(gl, context, resourceIdBump, imageId);
		
		m_Scale=radius; 
		m_Squash=squash; 
		colorIncrement=1.0f/(float)stacks; 
		m_Stacks = stacks; 
		m_Slices = slices; 
		
		 
		
		vertexData = new float[ 3*((m_Slices*2+2) * m_Stacks)]; 
		colorData = new float[ (4*(m_Slices*2+2) * m_Stacks)]; 
		normalData = new float[3*((m_Slices*2+2) * m_Stacks)]; 
		
		if(imageId == true) 
		textData = new float [2 * ((m_Slices*2+2) * (m_Stacks))]; 
		
		int phiIdx, thetaIdx; 
		
		for(phiIdx=0; phiIdx < m_Stacks; phiIdx++) 
		{ 
		
		float phi0 = (float)Math.PI * ((float)(phiIdx+0) * 
		(1.0f/(float)(m_Stacks)) - 0.5f); 
		
		float phi1 = (float)Math.PI * ((float)(phiIdx+1) * (1.0f/(float)
				(m_Stacks)) - 0.5f);
				float cosPhi0 = (float)Math.cos(phi0);
				float sinPhi0 = (float)Math.sin(phi0);
				float cosPhi1 = (float)Math.cos(phi1);
				float sinPhi1 = (float)Math.sin(phi1);
				float cosTheta, sinTheta;
				
				for(thetaIdx=0; thetaIdx < m_Slices; thetaIdx++)
				{
				float theta = (float) (2.0f*(float)Math.PI * ((float)thetaIdx) *
				(1.0/(float)(m_Slices-1)));
				cosTheta = (float)Math.cos(theta);
				sinTheta = (float)Math.sin(theta);
				
				vertexData[vIndex+0] = m_Scale*cosPhi0*cosTheta;
				vertexData[vIndex+1] = m_Scale*(sinPhi0*m_Squash);
				vertexData[vIndex+2] = m_Scale*(cosPhi0*sinTheta);
				vertexData[vIndex+3] = m_Scale*cosPhi1*cosTheta;
				vertexData[vIndex+4] = m_Scale*(sinPhi1*m_Squash);
				vertexData[vIndex+5] = m_Scale*(cosPhi1*sinTheta);
				
				normalData[nIndex + 0] = cosPhi0*cosTheta; 
				normalData[nIndex + 1] = sinPhi0;
				normalData[nIndex + 2] = cosPhi0*sinTheta;
				normalData[nIndex + 3] = cosPhi1*cosTheta; 
				normalData[nIndex + 4] = sinPhi1;
				normalData[nIndex + 5] = cosPhi1*sinTheta;
				if(textData != null)
		{ 
		float texX = (float)thetaIdx * 
		(1.0f/(float)(m_Slices-1)); 
		textData [tIndex + 0] = texX; 
		textData [tIndex + 1] = (float)(phiIdx+0) * 
		(1.0f/(float)(m_Stacks)); 
		textData [tIndex + 2] = texX; 
		textData [tIndex + 3] = (float)(phiIdx+1) * 
		(1.0f/(float)(m_Stacks)); 
		} 
		colorData[ cIndex+0] = (float )red; 
		colorData[ cIndex+1] = (float )0f; 
		colorData[cIndex+2] = (float)blue; 
		colorData[cIndex+4] = (float)red; 
		colorData[cIndex+5] = (float)0f; 
		colorData[cIndex+6] = (float)blue; 
		colorData[cIndex+3] = (float)1.0; 
		colorData[cIndex+7] = (float)1.0; 
		cIndex+=2*4; 
		vIndex+=2*3; 
		nIndex+=2*3; 
		if(textData!=null) 
		tIndex+= 2*2; 
		blue+=colorIncrement; 
		red-=colorIncrement; 
		
		vertexData[vIndex+0] = vertexData[vIndex+3] = 
		vertexData[vIndex-3]; 
		vertexData[vIndex+1] = vertexData[vIndex+4] = 
		vertexData[vIndex-2]; 
		vertexData[vIndex+2] = vertexData[vIndex+5] = 
		vertexData[vIndex-1]; 
		
		normalData[nIndex+0] = normalData[nIndex+3] = 
		normalData[nIndex-3]; 
		normalData[nIndex+1] = normalData[nIndex+4] = 
		normalData[nIndex-2]; 
		normalData[nIndex+2] = normalData[nIndex+5] = 
		normalData[nIndex-1]; 
		if(textData!= null) 
		{ 
		textData [tIndex + 0] = textData [tIndex + 2] = 
		textData [tIndex -2]; 
		textData [tIndex + 1] = textData [tIndex + 3] = 
		textData [tIndex -1]; 
		}
		} 
		} 
		
		
		
		m_Pos[0]= 0.0f; 
		m_Pos[1]= 0.0f; 
		m_Pos[2]= 0.0f; 
		m_VertexData = makeFloatBuffer(vertexData);
		m_ColorData = makeFloatBuffer(colorData);
		m_NormalData = makeFloatBuffer(normalData);
		if(textData!= null) 
		m_TextureData = makeFloatBuffer(textData); 
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

protected static FloatBuffer makeFloatBuffer(float[] arr)
{
   ByteBuffer bb = ByteBuffer.allocateDirect(arr.length*4);
   bb.order(ByteOrder.nativeOrder());
   FloatBuffer fb = bb.asFloatBuffer();
   fb.put(arr);
   fb.position(0);
   return fb;
}
protected static FloatBuffer makeFloatBuffer(float[] arr,float[] arr2)
{
   ByteBuffer bb = ByteBuffer.allocateDirect(arr.length*4);
   bb.order(ByteOrder.nativeOrder());
   FloatBuffer fb = bb.asFloatBuffer();
   fb.put(arr);
   fb.put(arr2);
   fb.position(0);
   return fb;
}

static float lightAngle=0.0f;
public void multiTextureBumpMap(GL10 gl, int mainTexture, int normalTexture)
{
float x,y,z;
lightAngle+=.3f; 
if(lightAngle>180)
lightAngle=0;

x = (float) Math.sin(lightAngle * (3.14159 / 180.0f)); 
y = 0.0f;
z = (float) Math.cos(lightAngle * (3.14159 / 180.0f));

x = x * 0.5f + 0.5f;
y = y * 0.5f + 0.5f;
z = z * 0.5f + 0.5f;
gl.glActiveTexture(GL10.GL_TEXTURE0); 
gl.glBindTexture(GL10.GL_TEXTURE_2D, mainTexture);
gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL11.GL_COMBINE);
gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL11.GL_COMBINE_RGB, GL11.GL_DOT3_RGB); 
gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL11.GL_SRC0_RGB, GL11.GL_TEXTURE); 
gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL11.GL_SRC1_RGB, GL11.GL_PREVIOUS); 
gl.glActiveTexture(GL10.GL_TEXTURE1); 
gl.glBindTexture(GL10.GL_TEXTURE_2D, normalTexture);
gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE, GL10.GL_MODULATE);

}

public void multiTexture(GL10 gl, int tex0, int tex1)
{
float combineParameter= GL10.GL_MODULATE; 

gl.glActiveTexture(GL10.GL_TEXTURE0); 
gl.glBindTexture(GL10.GL_TEXTURE_2D, tex0); 

gl.glActiveTexture(GL10.GL_TEXTURE1);
gl.glBindTexture(GL10.GL_TEXTURE_2D, tex1);

gl.glTexEnvf(GL10.GL_TEXTURE_ENV, GL10.GL_TEXTURE_ENV_MODE,
combineParameter ); 
}

public void draw(GL10 gl)
{
	if (resourceIdBump!=true){	
		gl.glDisable(GL10.GL_BLEND);
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
gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, (m_Slices+1)*2*(m_Stacks-1)+2);
gl.glDisable(GL10.GL_TEXTURE_2D);

gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	}else{
		
		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glCullFace(GL10.GL_BACK);
		gl.glEnable(GL10.GL_LIGHTING);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
		gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
		if(m_TextureData != null)
		{
		gl.glEnable(GL10.GL_TEXTURE_2D); 
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
		gl.glClientActiveTexture(GL10.GL_TEXTURE0);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_TextureData);
		}
		gl.glClientActiveTexture(GL10.GL_TEXTURE1);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, m_TextureData);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexData);
		gl.glNormalPointer(GL10.GL_FLOAT, 0, m_NormalData);
		gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorData);
		
		multiTextureBumpMap(gl, m_BumpmapID, textures[0]);
		gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, (m_Slices+1)*2*(m_Stacks-1)+2);
		gl.glDisable(GL10.GL_TEXTURE_2D);
		gl.glDisable(GL10.GL_BLEND);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	}
}



}



/*
 private void init(int stacks,int slices, float radius, float squash, GL10 gl,
Context context, boolean imageId, int resourceId) // 1
{
	 
		float[] vertexData; 
		float[] normalData; 	
		float[] colorData; 
		float[] textData=null; 
		float colorIncrement=0f; 
		float blue=0f; 
		float red=1.0f; 
		int vIndex=0; //vertex index 
		int cIndex=0; //color index 
		int nIndex=0; //normal index 
		int tIndex=0; //texture index 
		if(imageId == true) 
		createTexture(gl, context, resourceId, imageId); //2 
		m_Scale=radius; 
		m_Squash=squash; 
		colorIncrement=1.0f/(float)stacks; 
		m_Stacks = stacks; 
		m_Slices = slices; 
		//Vertices 
		vertexData = new float[ 3*((m_Slices*2+2) * m_Stacks)]; 
		//Color data 
		colorData = new float[ (4*(m_Slices*2+2) * m_Stacks)]; 
		//Normal pointers for lighting 
		normalData = new float[3*((m_Slices*2+2) * m_Stacks)]; 
		if(imageId == true) //3 
		textData = new float [2 * ((m_Slices*2+2) * (m_Stacks))]; 
		int phiIdx, thetaIdx; 
		//Latitude 
		for(phiIdx=0; phiIdx < m_Stacks; phiIdx++) 
		{ 
		//Starts at -1.57 and goes up to +1.57 radians. 
		///The first circle. 
		float phi0 = (float)Math.PI * ((float)(phiIdx+0) * 
		(1.0f/(float)(m_Stacks)) - 0.5f); 
		//The next, or second one. 
		float phi1 = (float)Math.PI * ((float)(phiIdx+1) * (1.0f/(float)
				(m_Stacks)) - 0.5f);
				float cosPhi0 = (float)Math.cos(phi0);
				float sinPhi0 = (float)Math.sin(phi0);
				float cosPhi1 = (float)Math.cos(phi1);
				float sinPhi1 = (float)Math.sin(phi1);
				float cosTheta, sinTheta;
				//Longitude
				for(thetaIdx=0; thetaIdx < m_Slices; thetaIdx++)
				{
				//Increment along the longitude circle each "slice."
				float theta = (float) (2.0f*(float)Math.PI * ((float)thetaIdx) *
				(1.0/(float)(m_Slices-1)));
				cosTheta = (float)Math.cos(theta);
				sinTheta = (float)Math.sin(theta);
				//We're generating a vertical pair of points, such
				//as the first point of stack 0 and the first point of stack 1
				//above it. This is how TRIANGLE_STRIPS work,
				//taking a set of 4 vertices and essentially drawing two triangles
				//at a time. The first is v0-v1-v2 and the next is v2-v1-v3, etc.
				//Get x-y-z for the first vertex of stack.
				vertexData[vIndex+0] = m_Scale*cosPhi0*cosTheta;
				vertexData[vIndex+1] = m_Scale*(sinPhi0*m_Squash);
				vertexData[vIndex+2] = m_Scale*(cosPhi0*sinTheta);
				vertexData[vIndex+3] = m_Scale*cosPhi1*cosTheta;
				vertexData[vIndex+4] = m_Scale*(sinPhi1*m_Squash);
				vertexData[vIndex+5] = m_Scale*(cosPhi1*sinTheta);
				
				normalData[nIndex + 0] = cosPhi0*cosTheta; //2
				normalData[nIndex + 1] = sinPhi0;
				normalData[nIndex + 2] = cosPhi0*sinTheta;
				normalData[nIndex + 3] = cosPhi1*cosTheta; //3
				normalData[nIndex + 4] = sinPhi1;
				normalData[nIndex + 5] = cosPhi1*sinTheta;
				if(textData != null)
		{ 
		float texX = (float)thetaIdx * 
		(1.0f/(float)(m_Slices-1)); 
		textData [tIndex + 0] = texX; 
		textData [tIndex + 1] = (float)(phiIdx+0) * 
		(1.0f/(float)(m_Stacks)); 
		textData [tIndex + 2] = texX; 
		textData [tIndex + 3] = (float)(phiIdx+1) * 
		(1.0f/(float)(m_Stacks)); 
		} 
		colorData[ cIndex+0] = (float )red; 
		colorData[ cIndex+1] = (float )0f; 
		colorData[cIndex+2] = (float)blue; 
		colorData[cIndex+4] = (float)red; 
		colorData[cIndex+5] = (float)0f; 
		colorData[cIndex+6] = (float)blue; 
		colorData[cIndex+3] = (float)1.0; 
		colorData[cIndex+7] = (float)1.0; 
		cIndex+=2*4; 
		vIndex+=2*3; 
		nIndex+=2*3; 
		if(textData!=null) //5 
		tIndex+= 2*2; 
		blue+=colorIncrement; 
		red-=colorIncrement; 
		//Degenerate triangle to connect stacks and maintain 
		//winding order. 
		vertexData[vIndex+0] = vertexData[vIndex+3] = 
		vertexData[vIndex-3]; 
		vertexData[vIndex+1] = vertexData[vIndex+4] = 
		vertexData[vIndex-2]; 
		vertexData[vIndex+2] = vertexData[vIndex+5] = 
		vertexData[vIndex-1]; 
		
		normalData[nIndex+0] = normalData[nIndex+3] = 
		normalData[nIndex-3]; 
		normalData[nIndex+1] = normalData[nIndex+4] = 
		normalData[nIndex-2]; 
		normalData[nIndex+2] = normalData[nIndex+5] = 
		normalData[nIndex-1]; 
		if(textData!= null) //6 
		{ 
		textData [tIndex + 0] = textData [tIndex + 2] = 
		textData [tIndex -2]; 
		textData [tIndex + 1] = textData [tIndex + 3] = 
		textData [tIndex -1]; 
		}
		} 
		} 
		
		m_Pos[0]= 0.0f; 
		m_Pos[1]= 0.0f; 
		m_Pos[2]= 0.0f; 
		m_VertexData = makeFloatBuffer(vertexData);
		m_ColorData = makeFloatBuffer(colorData);
		m_NormalData = makeFloatBuffer(normalData);
		if(textData!= null) 
		m_TextureData = makeFloatBuffer(textData); 
		} 
 */

