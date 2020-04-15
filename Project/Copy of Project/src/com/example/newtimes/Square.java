package com.example.newtimes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

class Square
{
	private FloatBuffer m_VertexData;
	private FloatBuffer m_ColorData;
	private ByteBuffer mIndexBuffer;
	private FloatBuffer m_NormalData;
	private int[ ] textures = new int[1];
	FloatBuffer m_TextureData;
public Square()
{
		
float vertices[] ={
		-90.0f, -90.0f,-100.0f,
		90.0f, -90.0f,-100.0f,
		-90.0f, 90.0f,-100.0f,
		90.0f, 90.0f,-100.0f
		};
		float maxColor=1.0f;
		float colors[] = 
		{
		maxColor,maxColor, 1.0f,maxColor,
		1.0f, maxColor,maxColor,maxColor,
		1.0f, 1.0f, 1.0f,maxColor,
		maxColor, 1.0f,maxColor,maxColor
		};
		byte indices[] = 
		{
		0, 3, 1,
		0, 2, 3
		};
		float normal[]={
				1.0f,1.0f,1.0f,
				1.0f,1.0f,1.0f,
				1.0f,1.0f,1.0f,
				-1.0f,-1.0f,-1.0f
				
		};
		float[] textureCoords =
			{
			0.0f, 0.0f,
			1.0f, 0.0f,
			0.0f, 1.0f,
			1.0f, 1.0f
			};
		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4); 
		vbb.order(ByteOrder.nativeOrder());
		m_VertexData=Planet.makeFloatBuffer(vertices);
		m_ColorData=Planet.makeFloatBuffer(colors);
		m_NormalData=Planet.makeFloatBuffer(normal);
		m_TextureData=Planet.makeFloatBuffer(textureCoords);
		mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
		mIndexBuffer.put(indices);
		mIndexBuffer.position(0);
		
		}
		public void draw(GL10 gl)
		{
		
			gl.glVertexPointer(3, GL10.GL_FLOAT, 0, m_VertexData);
			gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glColorPointer(4, GL10.GL_FLOAT, 0, m_ColorData);
			gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
			gl.glEnable(GL10.GL_TEXTURE_2D); 
			gl.glNormalPointer(GL10.GL_FLOAT, 0, m_NormalData);
			gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);
			
			gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]); 
			gl.glTexCoordPointer(2, GL10.GL_FLOAT,0, m_TextureData); 
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY); 
			gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4); 
			gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
			gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY); 
		
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
		
		}