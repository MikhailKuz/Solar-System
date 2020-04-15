package com.example.newtimes;

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.opengl.GLSurfaceView;

class SolarSystemRenderer implements GLSurfaceView.Renderer 
{
	
	
	 public volatile static float mAngle;
	
	static float angle = 0.0f; 
	static float angleE = 0.0f;
	static float angleV = 0.0f;
	static float angleM = 0.0f;
	static float angleMars = 0.0f;
	static float angleU = 0.0f;
	static float angleJ = 0.0f;
	static float angleN = 0.0f;
	static float angleS = 0.0f;
	static float angleP = 0.0f;
	static float angleSun = 0.0f;
	
	static float ownangleE = 0.0f;
	static float ownangleV = 0.0f;
	static float ownangleM = 0.0f;
	static float ownangleMars = 0.0f;
	static float ownangleU = 0.0f;
	static float ownangleJ = 0.0f;
	static float ownangleN = 0.0f;
	static float ownangleS = 0.0f;
	static float ownangleP = 0.0f;
	static float ownangleSun = 0.0f;
	
	static float klS1=1.125f;
	static float krS2=1f/3f;
	static float klU1=0.25f/0.265f;
	static float krU2=0.385f/0.265f;
	static float kor=0.5f/(Constants.nvnradiusE);
	
	float quality=0f;
	
	
	public final static int SS_SUNLIGHT = GL10.GL_LIGHT1;
	final Random random = new Random();
	
	
	public final static int X_VALUE = 0;
	public final static int Y_VALUE = 1;
	public final static int Z_VALUE = 2;
	Planet m_Earth,m_Venus,m_Mercury,m_Mars,m_Uranus,m_Jupiter,m_Neptune,m_Saturn,m_Pluton;
	Planet m_Sun;
	Square mSquare;
	Ring mRingS,mRingU;
	
	float[] m_Eyeposition = {0.0f, 0.0f, 0.0f};
	public Context myContext;
	
	
	public static float getAngle() {
        return mAngle;
    }

    public static void setAngle(float angle) {
        mAngle = angle;
    }
	
	
	public SolarSystemRenderer(Context context)
	{
	this.myContext = context;

	}
	
	public static Scanner in = new Scanner(System.in);
	public static PrintStream out = System.out;
		
private void initGeometry(GL10 gl) {
	
	          
	       if (Constants.onchange==true){
	    	    angle = 0.0f; 
	    		angleE = 0.0f;
	    		angleV = 0.0f;
	    		angleM = 90.0f;
	    		angleMars = 0.0f;
	    		angleU = 150.0f;
	    		angleJ = 107.0f;
	    		angleN = 90.0f;
	    		angleS = 0.0f;
	    		angleP = 0.0f;
	    		angleSun = 0.0f;
	       }
	       
	       if (Constants.quality<100)
	    	   quality=Constants.quality+(900/(100/Constants.quality));
	       else
	    	   quality=1000f;	
	        
	       int residSun;
			if (Constants.onchange==true)
			residSun=com.example.newtimes.R.drawable.sun_perfect;
			else residSun=com.example.newtimes.R.drawable.sun;
			
			
			if(Constants.ondefault ==true){
			mSquare = new Square();
			mSquare.createTexture(gl, this.myContext, Constants.residstar, true);
			mRingS=new Ring(0.55f,1.0f,quality,gl,myContext,true,Constants.residrings);
			mRingS.setPosition(0f, 0f, 0f);
			mRingU=new Ring(0.65f,0.9f,quality,gl,myContext,true,Constants.residringu);
			mRingU.setPosition(0f, 0f, 0f);
			m_Earth = new Planet(Constants.quality, Constants.quality, Constants.nvnradiusE, 1f-Constants.oblatnessE, gl, myContext, true,false, Constants.residEarth,Constants.residBumpE);
			m_Earth.setPosition(0.0f,0.0f,0.0f);
			m_Venus = new Planet(Constants.quality, Constants.quality, Constants.nvnradiusV, 1f-Constants.oblatnessV, gl, myContext, true,false,Constants.residVenus,Constants.residBumpV);
			m_Venus.setPosition(0.0f,0.0f,0.0f);
			m_Mercury = new Planet(Constants.quality, Constants.quality, Constants.nvnradiusM, 1f-Constants.oblatnessM, gl, myContext, true,false, Constants.residMercury,0);
			m_Mercury.setPosition(0.0f,0.0f,0.0f);
			m_Mars = new Planet(Constants.quality, Constants.quality, Constants.nvnradiusMars, 1f-Constants.oblatnessMars, gl, myContext, true, false,Constants.residMars,0);
			m_Mars.setPosition(0.0f,0.0f,0.0f);
			m_Uranus = new Planet(Constants.quality, Constants.quality,Constants.nvnradiusU, 1f-Constants.oblatnessU, gl, myContext, true,false, Constants.residUranus,0);
			m_Uranus.setPosition(0.0f,0.0f,0.0f);
			m_Jupiter = new Planet(Constants.quality, Constants.quality, Constants.nvnradiusJ, 1f-Constants.oblatnessJ, gl, myContext, true,false, Constants.residJupiter,0);
			m_Jupiter.setPosition(0.0f,0.0f,0.0f);
			m_Neptune = new Planet(Constants.quality, Constants.quality, Constants.nvnradiusN, 1f-Constants.oblatnessN, gl, myContext, true,false, Constants.residNeptune,0);
			m_Neptune.setPosition(0.0f,0.0f,0.0f);
			m_Saturn = new Planet(Constants.quality, Constants.quality, Constants.nvnradiusS, 1f-Constants.oblatnessS, gl, myContext, true,false, Constants.residSaturn,0);
			m_Saturn.setPosition(0.0f,0.0f,0.0f);
			m_Pluton = new Planet(Constants.quality, Constants.quality, Constants.nvnradiusP, 1f-Constants.oblatnessP, gl, myContext, true,false, Constants.residPluton,0);
			m_Pluton.setPosition(0.0f,0.0f,0.0f);
			m_Sun = new Planet(Constants.quality, Constants.quality, Constants.nvnradiusSun, 1.0f , gl, myContext, true,false, residSun,0);
			m_Sun.setPosition(0.0f,0.0f,0.0f);
			
			m_Eyeposition[X_VALUE] = Constants.xvalue;
			m_Eyeposition[Y_VALUE] = Constants.yvalue;
			m_Eyeposition[Z_VALUE] = Constants.zvalue;
			}else
			{
				if (Constants.quality<100)
			    	   quality=Constants.quality+(900/(100/Constants.quality));
			       else
			    	   quality=1000f;	
				
			    float rE;
				float rV;
				float rMer;
				float rM;
				float rU;
				float rJ;
				float rN;
				float rS;
				float rP;
				float rSun;
				
				 float sE;
					float sV;
					float sMer;
					float sM;
					float sU;
					float sJ;
					float sN;
					float sS;
					float sP;
					float sSun;
				
				if (MiddleActivity.mas[0]==-1)
					rE=Constants.nvnradiusE;
				else rE=Helper.vnradius(MiddleActivity.mas[0],Constants.plotE);
				if (MiddleActivity.mas[1]==-1)
					rV=Constants.nvnradiusV;
				else rV=Helper.vnradius(MiddleActivity.mas[1],Constants.plotV);
				if (MiddleActivity.mas[2]==-1)
					rMer=Constants.nvnradiusM;
				else rMer=Helper.vnradius(MiddleActivity.mas[2],Constants.plotM);
				if (MiddleActivity.mas[3]==-1)
					rM=Constants.nvnradiusMars;
				else rM=Helper.vnradius(MiddleActivity.mas[3],Constants.plotMars);
				if (MiddleActivity.mas[4]==-1)
					rU=Constants.nvnradiusU;
				else rU=Helper.vnradius(MiddleActivity.mas[4],Constants.plotU);
				if (MiddleActivity.mas[5]==-1)
					rJ=Constants.nvnradiusJ;
				else rJ=Helper.vnradius(MiddleActivity.mas[5],Constants.plotJ);
				if (MiddleActivity.mas[6]==-1)
					rN=Constants.nvnradiusN;
				else rN=Helper.vnradius(MiddleActivity.mas[6],Constants.plotN);
				if (MiddleActivity.mas[7]==-1)
					rS=Constants.nvnradiusS;
				else rS=Helper.vnradius(MiddleActivity.mas[7],Constants.plotS);
				if (MiddleActivity.mas[8]==-1)
					rP=Constants.nvnradiusP;
				else rP=Helper.vnradius(MiddleActivity.mas[8],Constants.plotP);
				if (MiddleActivity.mas[9]==-1)
					rSun=Constants.nvnradiusSun;
				else rSun=Helper.vnradius(MiddleActivity.mas[9],Constants.plotSun);
//----------------------------------------------------------------------------------------------------------------
				
				if (MiddleActivity.speed[0]==-1)
					sE=Constants.orbitalIncrementE;
				else sE=Helper.orbitincr(Constants.spedE, MiddleActivity.kord[0][0], MiddleActivity.kord[0][1], MiddleActivity.kord[0][2]);
				if (MiddleActivity.speed[1]==-1)
					sV=Constants.orbitalIncrementV;
				else sV=Helper.orbitincr(Constants.spedV, MiddleActivity.kord[1][0], MiddleActivity.kord[1][1], MiddleActivity.kord[1][2]);
				if (MiddleActivity.speed[2]==-1)
					sMer=Constants.orbitalIncrementM;
				else sMer=Helper.orbitincr(Constants.spedM, MiddleActivity.kord[2][0], MiddleActivity.kord[2][1], MiddleActivity.kord[2][2]);
				if (MiddleActivity.speed[3]==-1)
					sM=Constants.orbitalIncrementMars;
				else sM=Helper.orbitincr(Constants.spedMars, MiddleActivity.kord[3][0], MiddleActivity.kord[3][1], MiddleActivity.kord[3][2]);
				if (MiddleActivity.speed[4]==-1)
					sU=Constants.orbitalIncrementU;
				else sU=Helper.orbitincr(Constants.spedU, MiddleActivity.kord[4][0], MiddleActivity.kord[4][1], MiddleActivity.kord[4][2]);
				if (MiddleActivity.speed[5]==-1)
					sJ=Constants.orbitalIncrementJ;
				else sJ=Helper.orbitincr(Constants.spedJ, MiddleActivity.kord[5][0], MiddleActivity.kord[5][1], MiddleActivity.kord[5][2]);
				if (MiddleActivity.speed[6]==-1)
					sN=Constants.orbitalIncrementN;
				else sN=Helper.orbitincr(Constants.spedN, MiddleActivity.kord[6][0], MiddleActivity.kord[6][1], MiddleActivity.kord[6][2]);
				if (MiddleActivity.speed[7]==-1)
					sS=Constants.orbitalIncrementS;
				else sS=Helper.orbitincr(Constants.spedS, MiddleActivity.kord[7][0], MiddleActivity.kord[7][1], MiddleActivity.kord[7][2]);
				if (MiddleActivity.speed[8]==-1)
					sP=Constants.orbitalIncrementP;
				else sP=Helper.orbitincr(Constants.spedP, MiddleActivity.kord[8][0], MiddleActivity.kord[8][1], MiddleActivity.kord[8][2]);
				if (MiddleActivity.speed[9]==-1)
					sSun=Constants.orbitalIncrementSun;
				else sSun=Helper.orbitincr(Constants.spedSun, MiddleActivity.kord[9][0], MiddleActivity.kord[9][1], MiddleActivity.kord[9][2]);
				
				Constants.orbitalIncrementE=sE;
				Constants.orbitalIncrementV=sV;
				Constants.orbitalIncrementM=sMer;
				Constants.orbitalIncrementMars=sM;
				Constants.orbitalIncrementU=sU;
				Constants.orbitalIncrementJ=sJ;
				Constants.orbitalIncrementN=sN;
				Constants.orbitalIncrementS=sS;
				Constants.orbitalIncrementP=sP;
				Constants.orbitalIncrementSun=sSun;
				
				
				mSquare = new Square();
				mSquare.createTexture(gl, this.myContext, Constants.residstar, true);
				mRingS=new Ring(rS+rS*krS2,rS+rS*krS2+rS*klS1,quality,gl,myContext,true,Constants.residrings);
				mRingS.setPosition(0f, 0f, 0f);
				mRingU=new Ring(rU+rU*krU2,rU+rU*krU2+rU*klU1,quality,gl,myContext,true,Constants.residringu);
				mRingU.setPosition(0f, 0f, 0f);
				m_Earth = new Planet(Constants.quality, Constants.quality, rE, 1f-Constants.oblatnessE, gl, myContext, true,false, Constants.residEarth,Constants.residBumpE);
				m_Earth.setPosition(0.0f,0.0f,0.0f);
				m_Venus = new Planet(Constants.quality, Constants.quality, rV, 1f-Constants.oblatnessV, gl, myContext, true,false, Constants.residVenus,Constants.residBumpV);
				m_Venus.setPosition(0.0f,0.0f,0.0f);
				m_Mercury = new Planet(Constants.quality, Constants.quality, rMer, 1f-Constants.oblatnessM, gl, myContext, true,false, Constants.residMercury,0);
				m_Mercury.setPosition(0.0f,0.0f,0.0f);
				m_Mars = new Planet(Constants.quality, Constants.quality, rM, 1f-Constants.oblatnessMars, gl, myContext, true,false, Constants.residMars,0);
				m_Mars.setPosition(0.0f,0.0f,0.0f);
				m_Uranus = new Planet(Constants.quality, Constants.quality, rU, 1f-Constants.oblatnessU, gl, myContext, true,false, Constants.residUranus,0);
				m_Uranus.setPosition(0.0f,0.0f,0.0f);
				m_Jupiter = new Planet(Constants.quality, Constants.quality, rJ, 1f-Constants.oblatnessJ, gl, myContext, true, false,Constants.residJupiter,0);
				m_Jupiter.setPosition(0.0f,0.0f,0.0f);
				m_Neptune = new Planet(Constants.quality, Constants.quality, rN,1f- Constants.oblatnessN, gl, myContext, true,false, Constants.residNeptune,0);
				m_Neptune.setPosition(0.0f,0.0f,0.0f);
				m_Saturn = new Planet(Constants.quality,Constants.quality,rS, 1f-Constants.oblatnessS, gl, myContext, true,false, Constants.residSaturn,0);
				m_Saturn.setPosition(0.0f,0.0f,0.0f);
				m_Pluton = new Planet(Constants.quality, Constants.quality, rP, 1f-Constants.oblatnessP, gl, myContext, true, false,Constants.residPluton,0);
				m_Pluton.setPosition(0.0f,0.0f,0.0f);
				m_Sun = new Planet(Constants.quality, Constants.quality, rSun, 1.0f, gl, myContext, true,false, residSun,0);
				m_Sun.setPosition(MiddleActivity.kord[9][0],MiddleActivity.kord[9][1],MiddleActivity.kord[9][2]);
				
				float [] arraymax={
						Math.max(Math.abs(MiddleActivity.kord[0][0]), Math.abs(MiddleActivity.kord[0][2])),
						Math.max(Math.abs(MiddleActivity.kord[1][0]), Math.abs(MiddleActivity.kord[1][2])),
						Math.max(Math.abs(MiddleActivity.kord[2][0]), Math.abs(MiddleActivity.kord[2][2])),
						Math.max(Math.abs(MiddleActivity.kord[3][0]), Math.abs(MiddleActivity.kord[3][2])),
						Math.max(Math.abs(MiddleActivity.kord[4][0]), Math.abs(MiddleActivity.kord[4][2])),
						Math.max(Math.abs(MiddleActivity.kord[5][0]), Math.abs(MiddleActivity.kord[5][2])),
						Math.max(Math.abs(MiddleActivity.kord[6][0]), Math.abs(MiddleActivity.kord[6][2])),
						Math.max(Math.abs(MiddleActivity.kord[7][0]), Math.abs(MiddleActivity.kord[7][2])),
						Math.max(Math.abs(MiddleActivity.kord[8][0]), Math.abs(MiddleActivity.kord[8][2])),
						Math.max(Math.abs(MiddleActivity.kord[9][0]), Math.abs(MiddleActivity.kord[9][2]))
						};
				 float zx = 0;
				 
				 for (int i=0;i<10;i++)
					 if (arraymax[i]>zx)
						 zx=arraymax[i];
				 zx=8f;
				 
			     Constants.zx=zx;
				
				m_Eyeposition[X_VALUE] = Constants.xvalue;
				m_Eyeposition[Y_VALUE] = Constants.yvalue;
				m_Eyeposition[Z_VALUE] = Constants.zvalue;
				Constants.onincrdis=true;
			}
			
			
}




	
private void initLighting(GL10 gl)
	{
	float[] sunPos={0.0f, 0.0f, 0.0f, 1.0f};
	
	float[] white={1.0f, 1.0f, 1.0f, 1.0f};
	float[] yellow={1.0f, 1.0f, 0.0f, 1.0f};
	float[] mycolor={0.6f,0.6f,0.6f,1.0f};
	
	gl.glLightfv(SS_SUNLIGHT, GL10.GL_POSITION, Planet.makeFloatBuffer(sunPos));
	gl.glLightfv(SS_SUNLIGHT, GL10.GL_DIFFUSE, Planet.makeFloatBuffer(white));
	gl.glLightfv(SS_SUNLIGHT, GL10.GL_SPECULAR, Planet.makeFloatBuffer(yellow));
	
	
	gl.glPushMatrix();
	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, Planet.makeFloatBuffer(white));
	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, Planet.makeFloatBuffer(yellow));
	gl.glMaterialf(GL10.GL_FRONT_AND_BACK, GL10.GL_SHININESS, 128);
	gl.glPopMatrix();
	gl.glLightModelfv(GL10.GL_LIGHT_MODEL_AMBIENT, Planet.makeFloatBuffer(mycolor));
	
	gl.glShadeModel(GL10.GL_SMOOTH);
	gl.glLightModelf(GL10.GL_LIGHT_MODEL_TWO_SIDE, 0.0f);
	gl.glEnable(GL10.GL_LIGHTING);
	gl.glEnable(SS_SUNLIGHT);
	
	}
 


public void onDrawFrame(GL10 gl) 
{
	float paleYellow[]={1.0f, 1.0f, 0.3f, 1.0f}; 
	float white[]={1.0f, 1.0f, 1.0f, 1.0f};
	float black[]={0.0f, 0.0f, 0.0f, 0.0f}; 

    if ((Constants.ondefault==true)&(Constants.onchange==false)){ 
	
	float[] sunPos={Constants.koordSun[0], Constants.koordSun[1], Constants.koordSun[2], 1.0f};
	
	gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
	gl.glClearColor(0.0f,0.0f,0.0f,1.0f);
	gl.glPushMatrix(); 
	if (Constants.onanglch!=true)
	gl.glTranslatef(-m_Eyeposition[X_VALUE], -m_Eyeposition[Y_VALUE],-m_Eyeposition[Z_VALUE]);
	gl.glLightfv(SS_SUNLIGHT, GL10.GL_POSITION, Planet.makeFloatBuffer(sunPos)); 
	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, Planet.makeFloatBuffer(white));
	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, Planet.makeFloatBuffer(white));
	
	gl.glPushMatrix();
	if (Constants.onbackground==true)
	 mSquare.draw(gl); 
	gl.glPopMatrix();
	
	gl.glPushMatrix(); 
	angleS+=Constants.orbitalIncrementS;
	ownangleS+=Constants.ownIncrementS;
    gl.glRotatef(angleS,0.0f,1.0f,0.0f);
	gl.glTranslatef((float) (Constants.koordS[0]),0.0f,(float) (Constants.koordS[0]));  
	gl.glRotatef(-angleS,0.0f,1.0f,0.0f);
    gl.glRotatef(-(90f-Constants.taxisS), 0.0f, 0.0f, 1.0f);
    gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
	mRingS.draw(gl);
	gl.glPopMatrix();
	
	gl.glPushMatrix(); 
	angleU+=Constants.orbitalIncrementU;
	ownangleU+=Constants.ownIncrementU;
	gl.glRotatef(angleU,0.0f,1.0f,0.0f);
	gl.glTranslatef(Constants.koordU[0],Constants.koordU[1],Constants.koordU[2]);  
	gl.glRotatef(-angleU,0.0f,1.0f,0.0f);
    gl.glRotatef(-(90f-Constants.taxisU), 0.0f, 0.0f, 1.0f);
    gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
    mRingU.draw(gl);
	gl.glPopMatrix();
	
	gl.glPushMatrix(); 
	angleE+=Constants.orbitalIncrementE;
	ownangleE+=Constants.ownIncrementE;
	gl.glRotatef(angleE,0.0f,1.0f,0.0f);
	gl.glTranslatef(Constants.koordE[0],Constants.koordE[1],Constants.koordE[2]);  
	gl.glRotatef(-angleE,0.0f,1.0f,0.0f);
	gl.glRotatef(-(90f-Constants.taxisE), 0.0f, 0.0f, 1.0f);
	gl.glRotatef(ownangleE, 0.0f, 1.0f, 0.0f);
    executePlanet(m_Earth, gl); 
	gl.glPopMatrix(); 
	
	gl.glPushMatrix(); 
	angleV+=Constants.orbitalIncrementV;
	ownangleV+=Constants.ownIncrementV;
	gl.glRotatef(angleV,0.0f,1.0f,0.0f);
	gl.glTranslatef(Constants.koordV[0],Constants.koordV[1],Constants.koordV[2]);  
	gl.glRotatef(-angleV,0.0f,1.0f,0.0f);
    gl.glRotatef(-(90f-Constants.taxisV), 0.0f, 0.0f, 1.0f);
    gl.glRotatef(ownangleV, 0.0f, 1.0f, 0.0f);
    executePlanet(m_Venus, gl); 
	gl.glPopMatrix();
	
	gl.glPushMatrix(); 
	angleM+=Constants.orbitalIncrementM;
	ownangleM+=Constants.ownIncrementM;
	gl.glRotatef(angleM,0.0f,1.0f,0.0f);
	gl.glTranslatef(Constants.koordM[0],Constants.koordM[1],Constants.koordM[2]);  
	gl.glRotatef(-angleM,0.0f,1.0f,0.0f);
    gl.glRotatef(-(90f-Constants.taxisM), 0.0f, 0.0f, 1.0f);
    gl.glRotatef(ownangleM, 0.0f, 1.0f, 0.0f);
	executePlanet(m_Mercury, gl); 
	gl.glPopMatrix();
	
	gl.glPushMatrix(); 
	angleMars+=Constants.orbitalIncrementMars;
	ownangleMars+=Constants.ownIncrementMars;
	gl.glRotatef(angleMars,0.0f,1.0f,0.0f);
	gl.glTranslatef(Constants.koordMars[0],Constants.koordMars[1],Constants.koordMars[2]);  
	gl.glRotatef(-angleMars,0.0f,1.0f,0.0f);
    gl.glRotatef(-(90f-Constants.taxisMars), 0.0f, 0.0f, 1.0f);
    gl.glRotatef(ownangleMars, 0.0f, 1.0f, 0.0f);
    executePlanet(m_Mars, gl); 
	gl.glPopMatrix();
	
	gl.glPushMatrix(); 
	gl.glRotatef(angleU,0.0f,1.0f,0.0f);
	gl.glTranslatef(Constants.koordU[0],Constants.koordU[1],Constants.koordU[2]);  
	gl.glRotatef(-angleU,0.0f,1.0f,0.0f);
    gl.glRotatef(-(90f-Constants.taxisU), 0.0f, 0.0f, 1.0f);
    gl.glRotatef(ownangleU, 0.0f, 1.0f, 0.0f);
    gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
    executePlanet(m_Uranus, gl); 
	gl.glPopMatrix();
	
	gl.glPushMatrix(); 
	angleJ+=Constants.orbitalIncrementJ;
	ownangleJ+=Constants.ownIncrementJ;
	gl.glRotatef(angleJ,0.0f,1.0f,0.0f);
	gl.glTranslatef(Constants.koordJ[0],Constants.koordJ[1],Constants.koordJ[2]); 
	gl.glRotatef(-angleJ,0.0f,1.0f,0.0f);
	gl.glRotatef(-(90f-Constants.taxisJ), 0.0f, 0.0f, 1.0f);
    gl.glRotatef(ownangleJ, 0.0f, 1.0f, 0.0f);
    executePlanet(m_Jupiter, gl); 
	gl.glPopMatrix();
	
	gl.glPushMatrix(); 
	angleN+=Constants.orbitalIncrementN;
	ownangleN+=Constants.ownIncrementN;
	gl.glRotatef(angleN,0.0f,1.0f,0.0f);
	gl.glTranslatef(Constants.koordN[0],Constants.koordN[1],Constants.koordN[2]);  
	gl.glRotatef(-angleN,0.0f,1.0f,0.0f);
    gl.glRotatef(-(90f-Constants.taxisN), 0.0f, 0.0f, 1.0f);
	gl.glRotatef(ownangleN, 0.0f, 1.0f, 0.0f);
    executePlanet(m_Neptune, gl); 
	gl.glPopMatrix();
	
	gl.glPushMatrix(); 
	
	gl.glRotatef(angleS,0.0f,1.0f,0.0f);
	gl.glTranslatef(Constants.koordS[0],Constants.koordS[1],Constants.koordS[2]);  
	gl.glRotatef(-angleS,0.0f,1.0f,0.0f);
    gl.glRotatef(-(90f-Constants.taxisS), 0.0f, 0.0f, 1.0f);
    gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
    gl.glRotatef(ownangleS, 0.0f, 1.0f, 0.0f);
   
    executePlanet(m_Saturn, gl); 
	gl.glPopMatrix();
	
	gl.glPushMatrix(); 
	angleP+=Constants.orbitalIncrementP;
	ownangleP+=Constants.ownIncrementP;
	gl.glRotatef(angleP,0.0f,1.0f,0.0f);
	gl.glTranslatef(Constants.koordP[0],Constants.koordP[1],Constants.koordP[2]);  
	gl.glRotatef(-angleP,0.0f,1.0f,0.0f);
    gl.glRotatef(-(90f-Constants.taxisP), 0.0f, 0.0f, 1.0f);
    gl.glRotatef(ownangleP, 0.0f, 1.0f, 0.0f);
    executePlanet(m_Pluton, gl); 
	gl.glPopMatrix();
	
	
	
	angleSun+=Constants.orbitalIncrementSun;
	gl.glRotatef(angleSun, 1.0f, 1.0f, 0.0f);
	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_EMISSION, Planet.makeFloatBuffer(paleYellow));
	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, Planet.makeFloatBuffer(black)); 
	executePlanet(m_Sun, gl); 
	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_EMISSION, Planet.makeFloatBuffer(black)); 
	gl.glPopMatrix(); 
	
    }else if ((Constants.ondefault==true)&(Constants.onchange!=false)){
    	float[] sunPos={Constants.koordSun[0], Constants.koordSun[1], Constants.koordSun[2], 1.0f};
    	
    	gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    	gl.glClearColor(0.0f,0.0f,0.0f,1.0f);
    	gl.glPushMatrix(); 
    	if (Constants.onanglch!=true)
    	gl.glTranslatef(-m_Eyeposition[X_VALUE], -m_Eyeposition[Y_VALUE],-m_Eyeposition[Z_VALUE]);
    	gl.glLightfv(SS_SUNLIGHT, GL10.GL_POSITION, Planet.makeFloatBuffer(sunPos)); 
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, Planet.makeFloatBuffer(white));
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, Planet.makeFloatBuffer(white));
    	
    	
    	
    	gl.glPushMatrix();
    	if (Constants.onbackground==true)
    	 mSquare.draw(gl); 
    	gl.glPopMatrix();
    	
    	
    	
    	gl.glPushMatrix(); 
    	angleE+=Constants.orbitalIncrementE;
    	ownangleE+=Constants.ownIncrementE;
        float xvalueE=(float) Math.cos(angleE)*Constants.radorE;
	    float yvalueE=0f;
	    float zvalueE=(float) -Math.sin(angleE)*Constants.radorE;
	    gl.glTranslatef(xvalueE,yvalueE,zvalueE);  
    	gl.glRotatef(-(90f-Constants.taxisE), 0.0f, 0.0f, 1.0f);
    	gl.glRotatef(ownangleE, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Earth, gl); 
    	gl.glPopMatrix(); 
    	
    	gl.glPushMatrix(); 
    	angleV+=Constants.orbitalIncrementV;
    	ownangleV+=Constants.ownIncrementV;
    	float xvalueV=(float) Math.cos(angleV)*Constants.radorV;
	    float yvalueV=0f;
	    float zvalueV=(float) -Math.sin(angleV)*Constants.radorV;
	    gl.glTranslatef(xvalueV,yvalueV,zvalueV);  
        gl.glRotatef(-(90f-Constants.taxisV), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleV, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Venus, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleM+=Constants.orbitalIncrementM;
    	ownangleM+=Constants.ownIncrementM;
    	float xvalueM=(float) Math.cos(angleM)*Constants.radorM;
	    float yvalueM=0f;
	    float zvalueM=(float) -Math.sin(angleM)*Constants.radorM;
	    gl.glTranslatef(xvalueM,yvalueM,zvalueM);  
        gl.glRotatef(-(90f-Constants.taxisM), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleM, 0.0f, 1.0f, 0.0f);
    	executePlanet(m_Mercury, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleMars+=Constants.orbitalIncrementMars;
    	ownangleMars+=Constants.ownIncrementMars;
    	float xvalueMars=(float) Math.cos(angleMars)*Constants.radorMars;
	    float yvalueMars=0f;
	    float zvalueMars=(float) -Math.sin(angleMars)*Constants.radorMars;
	    gl.glTranslatef(xvalueMars,yvalueMars,zvalueMars);  
        gl.glRotatef(-(90f-Constants.taxisMars), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleMars, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Mars, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleU+=Constants.orbitalIncrementU;
    	ownangleU+=Constants.ownIncrementU;
    	float xvalueU=(float) Math.cos(angleU)*Constants.radorU;
	    float yvalueU=0f;
	    float zvalueU=(float) -Math.sin(angleU)*Constants.radorU;
	    gl.glTranslatef(xvalueU,yvalueU,zvalueU);  
        gl.glRotatef(-(90f-Constants.taxisU), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleU, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
        executePlanet(m_Uranus, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleJ+=Constants.orbitalIncrementJ;
    	ownangleJ+=Constants.ownIncrementJ;
    	float xvalueJ=(float) Math.cos(angleJ)*Constants.radorJ;
	    float yvalueJ=0f;
	    float zvalueJ=(float) -Math.sin(angleJ)*Constants.radorJ;
	    gl.glTranslatef(xvalueJ,yvalueJ,zvalueJ);  
    	gl.glRotatef(-(90f-Constants.taxisJ), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleJ, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Jupiter, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleN+=Constants.orbitalIncrementN;
    	ownangleN+=Constants.ownIncrementN;
    	float xvalueN=(float) Math.cos(angleN)*Constants.radorN;
	    float yvalueN=0f;
	    float zvalueN=(float) -Math.sin(angleN)*Constants.radorN;
	    gl.glTranslatef(xvalueN,yvalueN,zvalueN);  
        gl.glRotatef(-(90f-Constants.taxisN), 0.0f, 0.0f, 1.0f);
    	gl.glRotatef(ownangleN, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Neptune, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleS+=Constants.orbitalIncrementS;
    	ownangleS+=Constants.ownIncrementS;
    	float xvalueS=(float) Math.cos(angleS)*Constants.radorS;
	    float yvalueS=0f;
	    float zvalueS=(float) -Math.sin(angleS)*Constants.radorS;
	    gl.glTranslatef(xvalueS,yvalueS,zvalueS);  
        gl.glRotatef(-(90f-Constants.taxisS), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(ownangleS, 0.0f, 1.0f, 0.0f);
       
        executePlanet(m_Saturn, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	gl.glTranslatef(xvalueS,yvalueS,zvalueS);  
        gl.glRotatef(-(90f-Constants.taxisS), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
    	mRingS.draw(gl);
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
	    gl.glTranslatef(xvalueU,yvalueU,zvalueU);  
        gl.glRotatef(-(90f-Constants.taxisU), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
        mRingU.draw(gl);
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleP+=Constants.orbitalIncrementP;
    	ownangleP+=Constants.ownIncrementP;
    	float xvalueP=(float) Math.cos(angleP)*Constants.radorP;
	    float yvalueP=0f;
	    float zvalueP=(float) -Math.sin(angleP)*Constants.radorP;
	    gl.glTranslatef(xvalueP,yvalueP,zvalueP);  
        gl.glRotatef(-(90f-Constants.taxisP), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleP, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Pluton, gl); 
    	gl.glPopMatrix();
    	
    	
    	
    	angleSun+=Constants.orbitalIncrementSun;
    	gl.glRotatef(angleSun, 1.0f, 1.0f, 0.0f);
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_EMISSION, Planet.makeFloatBuffer(paleYellow));
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, Planet.makeFloatBuffer(black)); 
    	executePlanet(m_Sun, gl); 
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_EMISSION, Planet.makeFloatBuffer(black)); 
    	gl.glPopMatrix(); 
    }else{
    	float[] sunPos={Constants.koordSun[0], Constants.koordSun[1], Constants.koordSun[2], 1.0f};
    	
    	gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    	gl.glClearColor(0.0f,0.0f,0.0f,1.0f);
    	gl.glPushMatrix(); 
    	if (Constants.onanglch!=true)
    	gl.glTranslatef(-m_Eyeposition[X_VALUE], -m_Eyeposition[Y_VALUE],-m_Eyeposition[Z_VALUE]);
    	gl.glLightfv(SS_SUNLIGHT, GL10.GL_POSITION, Planet.makeFloatBuffer(sunPos)); 
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, Planet.makeFloatBuffer(white));
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, Planet.makeFloatBuffer(white));
    	
    	gl.glPushMatrix();
    	if (Constants.onbackground==true)
    	 mSquare.draw(gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleS+=Constants.orbitalIncrementS;
    	ownangleS+=Constants.ownIncrementS;
        gl.glRotatef(angleS,0.0f,1.0f,0.0f);
    	gl.glTranslatef(MiddleActivity.kord[7][0],MiddleActivity.kord[7][1],MiddleActivity.kord[7][2]);  
    	gl.glRotatef(-angleS,0.0f,1.0f,0.0f);
        gl.glRotatef(-(90f-Constants.taxisS), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
    	mRingS.draw(gl);
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleU+=Constants.orbitalIncrementU;
    	ownangleU+=Constants.ownIncrementU;
    	gl.glRotatef(angleU,0.0f,1.0f,0.0f);
    	gl.glTranslatef(MiddleActivity.kord[4][0],MiddleActivity.kord[4][1],MiddleActivity.kord[4][2]);  
    	gl.glRotatef(-angleU,0.0f,1.0f,0.0f);
        gl.glRotatef(-(90f-Constants.taxisU), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
        mRingU.draw(gl);
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleE+=Constants.orbitalIncrementE;
    	ownangleE+=Constants.ownIncrementE;
    	gl.glRotatef(angleE,0.0f,1.0f,0.0f);
    	gl.glTranslatef(MiddleActivity.kord[0][0],MiddleActivity.kord[0][1],MiddleActivity.kord[0][2]);  
    	gl.glRotatef(-angleE,0.0f,1.0f,0.0f);
    	gl.glRotatef(-(90f-Constants.taxisE), 0.0f, 0.0f, 1.0f);
    	gl.glRotatef(ownangleE, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Earth, gl); 
    	gl.glPopMatrix(); 
    	
    	gl.glPushMatrix(); 
    	angleV+=Constants.orbitalIncrementV;
    	ownangleV+=Constants.ownIncrementV;
    	gl.glRotatef(angleV,0.0f,1.0f,0.0f);
    	gl.glTranslatef(MiddleActivity.kord[1][0],MiddleActivity.kord[1][1],MiddleActivity.kord[1][2]);  
    	gl.glRotatef(-angleV,0.0f,1.0f,0.0f);
        gl.glRotatef(-(90f-Constants.taxisV), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleV, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Venus, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleM+=Constants.orbitalIncrementM;
    	ownangleM+=Constants.ownIncrementM;
    	gl.glRotatef(angleM,0.0f,1.0f,0.0f);
    	gl.glTranslatef(MiddleActivity.kord[2][0],MiddleActivity.kord[2][1],MiddleActivity.kord[2][2]);  
    	gl.glRotatef(-angleM,0.0f,1.0f,0.0f);
        gl.glRotatef(-(90f-Constants.taxisM), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleM, 0.0f, 1.0f, 0.0f);
    	executePlanet(m_Mercury, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleMars+=Constants.orbitalIncrementMars;
    	ownangleMars+=Constants.ownIncrementMars;
    	gl.glRotatef(angleMars,0.0f,1.0f,0.0f);
    	gl.glTranslatef(MiddleActivity.kord[3][0],MiddleActivity.kord[3][1],MiddleActivity.kord[3][2]);  
    	gl.glRotatef(-angleMars,0.0f,1.0f,0.0f);
        gl.glRotatef(-(90f-Constants.taxisMars), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleMars, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Mars, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	gl.glRotatef(angleU,0.0f,1.0f,0.0f);
    	gl.glTranslatef(MiddleActivity.kord[4][0],MiddleActivity.kord[4][1],MiddleActivity.kord[4][2]);  
    	gl.glRotatef(-angleU,0.0f,1.0f,0.0f);
        gl.glRotatef(-(90f-Constants.taxisU), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleU, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
        executePlanet(m_Uranus, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleJ+=Constants.orbitalIncrementJ;
    	ownangleJ+=Constants.ownIncrementJ;
    	gl.glRotatef(angleJ,0.0f,1.0f,0.0f);
    	gl.glTranslatef(MiddleActivity.kord[5][0],MiddleActivity.kord[5][1],MiddleActivity.kord[5][2]); 
    	gl.glRotatef(-angleJ,0.0f,1.0f,0.0f);
    	gl.glRotatef(-(90f-Constants.taxisJ), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleJ, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Jupiter, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleN+=Constants.orbitalIncrementN;
    	ownangleN+=Constants.ownIncrementN;
    	gl.glRotatef(angleN,0.0f,1.0f,0.0f);
    	gl.glTranslatef(MiddleActivity.kord[6][0],MiddleActivity.kord[6][1],MiddleActivity.kord[6][2]);  
    	gl.glRotatef(-angleN,0.0f,1.0f,0.0f);
        gl.glRotatef(-(90f-Constants.taxisN), 0.0f, 0.0f, 1.0f);
    	gl.glRotatef(ownangleN, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Neptune, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	
    	gl.glRotatef(angleS,0.0f,1.0f,0.0f);
    	gl.glTranslatef(MiddleActivity.kord[7][0],MiddleActivity.kord[7][1],MiddleActivity.kord[7][2]);  
    	gl.glRotatef(-angleS,0.0f,1.0f,0.0f);
        gl.glRotatef(-(90f-Constants.taxisS), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(20f, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(ownangleS, 0.0f, 1.0f, 0.0f);
       
        executePlanet(m_Saturn, gl); 
    	gl.glPopMatrix();
    	
    	gl.glPushMatrix(); 
    	angleP+=Constants.orbitalIncrementP;
    	ownangleP+=Constants.ownIncrementP;
    	gl.glRotatef(angleP,0.0f,1.0f,0.0f);
    	gl.glTranslatef(MiddleActivity.kord[8][0],MiddleActivity.kord[8][1],MiddleActivity.kord[8][2]);  
    	gl.glRotatef(-angleP,0.0f,1.0f,0.0f);
        gl.glRotatef(-(90f-Constants.taxisP), 0.0f, 0.0f, 1.0f);
        gl.glRotatef(ownangleP, 0.0f, 1.0f, 0.0f);
        executePlanet(m_Pluton, gl); 
    	gl.glPopMatrix();
    	
    	
    	
    	angleSun+=Constants.orbitalIncrementSun;
    	gl.glRotatef(angleSun, 1.0f, 1.0f, 0.0f);
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_EMISSION, Planet.makeFloatBuffer(paleYellow));
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, Planet.makeFloatBuffer(black)); 
    	executePlanet(m_Sun, gl); 
    	gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_EMISSION, Planet.makeFloatBuffer(black)); 
    	gl.glPopMatrix(); 
    }
    	
	
	if (Constants.onincrdis==true){
		m_Eyeposition[Z_VALUE] = Constants.zvalue;
	}else
		if (Constants.onchange==true){
			angle+=Constants.increment;
		    Constants.xvalue=(float) Math.cos(angle)*Constants.radior;
		    Constants.yvalue=0f;
		    Constants.zvalue=(float) -Math.sin(angle)*Constants.radior;
		    
		    Constants.zvalue+=kor*Constants.radius;
		    m_Eyeposition[X_VALUE]=Constants.xvalue;
			m_Eyeposition[Y_VALUE]=Constants.yvalue;
			m_Eyeposition[Z_VALUE]=Constants.zvalue;
		}else
	if (Constants.onincrspeed==true){
		Constants.orbitalIncrementE=Constants.TemporbitalIncrementE;
		Constants.orbitalIncrementV=Constants.TemporbitalIncrementV;
		Constants.orbitalIncrementM=Constants.TemporbitalIncrementM;
		Constants.orbitalIncrementMars=Constants.TemporbitalIncrementMars;
		Constants.orbitalIncrementU=Constants.TemporbitalIncrementU;
		Constants.orbitalIncrementJ=Constants.TemporbitalIncrementJ;
		Constants.orbitalIncrementN=Constants.TemporbitalIncrementN;
		Constants.orbitalIncrementS=Constants.TemporbitalIncrementS;
		Constants.orbitalIncrementP=Constants.TemporbitalIncrementP;
		Constants.orbitalIncrementSun=Constants.TemporbitalIncrementSun;
		
		Constants.ownIncrementE=Constants.TempownIncrementE;
		Constants.ownIncrementV=Constants.TempownIncrementV;
		Constants.ownIncrementM=Constants.TempownIncrementM;
		Constants.ownIncrementMars=Constants.TempownIncrementMars;
		Constants.ownIncrementU=Constants.TempownIncrementU;
		Constants.ownIncrementJ=Constants.TempownIncrementJ;
		Constants.ownIncrementN=Constants.TempownIncrementN;
		Constants.ownIncrementS=Constants.TempownIncrementS;
		Constants.ownIncrementP=Constants.TempownIncrementP;
	}
	
	
	
	
}

private void executePlanet(Planet m_Planet, GL10 gl)
{
float posX, posY, posZ;
posX = m_Planet.m_Pos[0]; 
posY = m_Planet.m_Pos[1];
posZ = m_Planet.m_Pos[2];
gl.glPushMatrix();
gl.glTranslatef(posX, posY, posZ);
gl.glEnable(GL10.GL_BLEND);                                                                    //-------------------------------------------------------------
m_Planet.draw(gl); 
gl.glPopMatrix();

}




public void onSurfaceChanged(GL10 gl, int width, int height) 
{
	gl.glViewport(0, 0, width, height);
	
	float aspectRatio;
	float zNear =.01f;
	float zFar =400;
	float fieldOfView = 30.0f/57.3f; 
	float size;
	
	gl.glEnable(GL10.GL_NORMALIZE);
	if (kor==0.5f/(Constants.nvnradiusE)){
		kor=0.3f/(Constants.nvnradiusE);
	}
	else kor=0.5f/(Constants.nvnradiusE);
	aspectRatio=(float)width/(float)height; 
	gl.glMatrixMode(GL10.GL_PROJECTION); 
	size = zNear * (float)(Math.tan((double)(fieldOfView/2.0f))); 
	gl.glLoadIdentity();
	gl.glFrustumf(-size, size, -size /aspectRatio, size /aspectRatio, zNear, zFar);
	gl.glMatrixMode(GL10.GL_MODELVIEW);
	gl.glEnable(GL10.GL_FRONT); 
	gl.glShadeModel(GL10.GL_SMOOTH); 
	gl.glEnable(GL10.GL_DEPTH_TEST);
	gl.glDepthMask(true);
	
}

public void onSurfaceCreated(GL10 gl, EGLConfig config) {

gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
gl.glEnable(GL10.GL_CULL_FACE);
gl.glCullFace(GL10.GL_BACK);
gl.glShadeModel(GL10.GL_SMOOTH);
gl.glEnable(GL10.GL_DEPTH_TEST);

initGeometry(gl);
initLighting(gl);
}

public void handleTouchPress(float normalizedX, float normalizedY) {
	
	if (Constants.onincrdis==true){
	int zvl=(int) Constants.zvalue;
	if ((zvl!=4) & (zvl!=10) & (zvl!=25) & (zvl!=50) & (zvl!=75) & (zvl!=100))
		Constants.zvalue=4;
	else{
	switch(zvl){
	case 4:Constants.zvalue=10f;break;
	case 10:Constants.zvalue=25f;break;
	case 25:Constants.zvalue=50f;break;
	case 50:Constants.zvalue=75f;break;
	case 75:Constants.zvalue=100f;break;
	case 100:Constants.zvalue=4f;break;
	}
	}
	}
	
	if (Constants.onincrspeed==true){
    
	float sp0=Constants.REALorbitalIncrementE/100;
	float sp1=Constants.REALorbitalIncrementE*Constants.incresvalue1/100;
	float sp2=Constants.REALorbitalIncrementE*Constants.incresvalue2/100;
	float sp3=Constants.REALorbitalIncrementE*Constants.incresvalue3/100;
	float sp4=Constants.REALorbitalIncrementE*Constants.incresvalue4/100;
	float sp5=Constants.REALorbitalIncrementE*Constants.incresvalue5/100;
	float sp6=Constants.REALorbitalIncrementE*Constants.incresvalue6/100;
	
	
	
	if (Constants.orbitalIncrementE==sp0){
		Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue1/100;
		Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue1/100;
		Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue1/100;
		Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue1/100;
		Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue1/100;
		Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue1/100;
		Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue1/100;
		Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue1/100;
		Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue1/100;
		Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue1/100;
		
		Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue1/100;
		Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue1/100;
		Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue1/100;
		Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue1/100;
		Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue1/100;
		Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue1/100;
		Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue1/100;
		Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue1/100;
		Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue1/100;
		
	}else if(Constants.orbitalIncrementE==sp1){
		Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue2/100;
		Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue2/100;
		Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue2/100;
		Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue2/100;
		Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue2/100;
		Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue2/100;
		Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue2/100;
		Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue2/100;
		Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue2/100;
		Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue2/100;
		
		Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue2/100;
		Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue2/100;
		Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue2/100;
		Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue2/100;
		Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue2/100;
		Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue2/100;
		Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue2/100;
		Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue2/100;
		Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue2/100;
		
	}else if(Constants.orbitalIncrementE==sp2){
		Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue3/100;
		Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue3/100;
		Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue3/100;
		Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue3/100;
		Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue3/100;
		Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue3/100;
		Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue3/100;
		Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue3/100;
		Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue3/100;
		Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue3/100;
		
		Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue3/100;
		Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue3/100;
		Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue3/100;
		Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue3/100;
		Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue3/100;
		Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue3/100;
		Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue3/100;
		Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue3/100;
		Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue3/100;
		
	}else if(Constants.orbitalIncrementE==sp3){
		Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue4/100;
		Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue4/100;
		Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue4/100;
		Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue4/100;
		Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue4/100;
		Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue4/100;
		Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue4/100;
		Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue4/100;
		Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue4/100;
		Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue4/100;
		
		Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue4/100;
		Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue4/100;
		Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue4/100;
		Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue4/100;
		Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue4/100;
		Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue4/100;
		Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue4/100;
		Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue4/100;
		Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue4/100;
		
	}else if(Constants.orbitalIncrementE==sp4){
		Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue5/100/100;
		Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue5/100/100;
		Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue5/100/100;
		Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue5/100/100;
		Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue5/100/100;
		Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue5/100;
		Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue5/100;
		Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue5/100;
		Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue5/100;
		Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue5/100;
		
		Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue5/100;
		Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue5/100;
		Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue5/100;
		Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue5/100;
		Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue5/100;
		Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue5/100;
		Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue5/100;
		Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue5/100;
		Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue5/100;
		
	}else if(Constants.orbitalIncrementE==sp5){
		Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue6/100;
		Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue6/100;
		Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue6/100;
		Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue6/100;
		Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue6/100;
		Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue6/100;
		Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue6/100;
		Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue6/100;
		Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue6/100;
		Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue6/100;
		
		Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue6/100;
		Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue6/100;
		Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue6/100;
		Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue6/100;
		Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue6/100;
		Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue6/100;
		Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue6/100;
		Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue6/100;
		Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue6/100;
		
	}else if(Constants.orbitalIncrementE==sp6){
		Constants.TemporbitalIncrementE=Constants.sTemporbitalIncrementE;
		Constants.TemporbitalIncrementV=Constants.sTemporbitalIncrementV;
		Constants.TemporbitalIncrementM=Constants.sTemporbitalIncrementM;
		Constants.TemporbitalIncrementMars=Constants.sTemporbitalIncrementMars;
		Constants.TemporbitalIncrementU=Constants.sTemporbitalIncrementU;
		Constants.TemporbitalIncrementJ=Constants.sTemporbitalIncrementJ;
		Constants.TemporbitalIncrementN=Constants.sTemporbitalIncrementN;
		Constants.TemporbitalIncrementS=Constants.sTemporbitalIncrementS;
		Constants.TemporbitalIncrementP=Constants.sTemporbitalIncrementP;
		Constants.TemporbitalIncrementSun=Constants.sTemporbitalIncrementSun;
		
		Constants.TempownIncrementE=Constants.sTempownIncrementE;
		Constants.TempownIncrementV=Constants.sTempownIncrementV;
		Constants.TempownIncrementM=Constants.sTempownIncrementM;
		Constants.TempownIncrementMars=Constants.sTempownIncrementMars;
		Constants.TempownIncrementU=Constants.sTempownIncrementU;
		Constants.TempownIncrementJ=Constants.sTempownIncrementJ;
		Constants.TempownIncrementN=Constants.sTempownIncrementN;
		Constants.TempownIncrementS=Constants.sTempownIncrementS;
		Constants.TempownIncrementP=Constants.sTempownIncrementP;
	}else {
		Constants.TemporbitalIncrementE=Constants.sTemporbitalIncrementE;
		Constants.TemporbitalIncrementV=Constants.sTemporbitalIncrementV;
		Constants.TemporbitalIncrementM=Constants.sTemporbitalIncrementM;
		Constants.TemporbitalIncrementMars=Constants.sTemporbitalIncrementMars;
		Constants.TemporbitalIncrementU=Constants.sTemporbitalIncrementU;
		Constants.TemporbitalIncrementJ=Constants.sTemporbitalIncrementJ;
		Constants.TemporbitalIncrementN=Constants.sTemporbitalIncrementN;
		Constants.TemporbitalIncrementS=Constants.sTemporbitalIncrementS;
		Constants.TemporbitalIncrementP=Constants.sTemporbitalIncrementP;
		Constants.TemporbitalIncrementSun=Constants.sTemporbitalIncrementSun;
		
		Constants.TempownIncrementE=Constants.sTempownIncrementE;
		Constants.TempownIncrementV=Constants.sTempownIncrementV;
		Constants.TempownIncrementM=Constants.sTempownIncrementM;
		Constants.TempownIncrementMars=Constants.sTempownIncrementMars;
		Constants.TempownIncrementU=Constants.sTempownIncrementU;
		Constants.TempownIncrementJ=Constants.sTempownIncrementJ;
		Constants.TempownIncrementN=Constants.sTempownIncrementN;
		Constants.TempownIncrementS=Constants.sTempownIncrementS;
		Constants.TempownIncrementP=Constants.sTempownIncrementP;
	}
	}
	
	if (Constants.onchange==true){
		if (Constants.increment==Constants.orbitalIncrementE){
			Constants.increment=Constants.orbitalIncrementV;
			Constants.radius=Constants.nvnradiusV;
			Constants.radior=Constants.radorV;
			angle=angleV;
			return;
		}
		if (Constants.increment==Constants.orbitalIncrementV){
			Constants.increment=Constants.orbitalIncrementM;
			Constants.radius=Constants.nvnradiusM;
			Constants.radior=Constants.radorM;
			angle=angleM;
			return;
		}
		if (Constants.increment==Constants.orbitalIncrementM){
			Constants.increment=Constants.orbitalIncrementMars;
			Constants.radius=Constants.nvnradiusMars;
			Constants.radior=Constants.radorMars;
			angle=angleMars;
			return;
		}
		if (Constants.increment==Constants.orbitalIncrementMars){
			Constants.increment=Constants.orbitalIncrementU;
			Constants.radius=Constants.nvnradiusU+0.6f;
			Constants.radior=Constants.radorU;
			angle=angleU;
			return;
		}
		if (Constants.increment==Constants.orbitalIncrementU){
			Constants.increment=Constants.orbitalIncrementJ;
			Constants.radius=Constants.nvnradiusJ-0.05f;
			Constants.radior=Constants.radorJ;
			angle=angleJ;
			return;
		}
		if (Constants.increment==Constants.orbitalIncrementJ){
			Constants.increment=Constants.orbitalIncrementN;
			Constants.radius=Constants.nvnradiusN;
			Constants.radior=Constants.radorN;
			angle=angleN;
			return;
		}
		if (Constants.increment==Constants.orbitalIncrementN){
			Constants.increment=Constants.orbitalIncrementS;
			Constants.radius=Constants.nvnradiusS+0.15f;
			Constants.radior=Constants.radorS;
			angle=angleS;
			return;
		}
		if (Constants.increment==Constants.orbitalIncrementS){
			Constants.increment=Constants.orbitalIncrementP;
			Constants.radius=Constants.nvnradiusP;
			Constants.radior=Constants.radorP;
			angle=angleP;
			return;
		}
		if (Constants.increment==Constants.orbitalIncrementP){
			Constants.increment=Constants.orbitalIncrementE;
			Constants.radius=Constants.nvnradiusE;
			Constants.radior=Constants.radorE;
			angle=angleE;
			return;
		}
	}
	
}
public void handleTouchDrag(float normalizedX, float normalizedY) {
	if (Constants.onincrdis==true){
		int zvl=(int) Constants.zvalue;
		if ((zvl!=4) & (zvl!=10) & (zvl!=25) & (zvl!=50) & (zvl!=75) & (zvl!=100))
			Constants.zvalue=4;
		else{
		switch(zvl){
		case 4:Constants.zvalue=10f;break;
		case 10:Constants.zvalue=25f;break;
		case 25:Constants.zvalue=50f;break;
		case 50:Constants.zvalue=75f;break;
		case 75:Constants.zvalue=100f;break;
		case 100:Constants.zvalue=4f;break;
		}
		}
		}
		
		if (Constants.onincrspeed==true){
	    
		float sp0=Constants.REALorbitalIncrementE/100;
		float sp1=Constants.REALorbitalIncrementE*Constants.incresvalue1/100;
		float sp2=Constants.REALorbitalIncrementE*Constants.incresvalue2/100;
		float sp3=Constants.REALorbitalIncrementE*Constants.incresvalue3/100;
		float sp4=Constants.REALorbitalIncrementE*Constants.incresvalue4/100;
		float sp5=Constants.REALorbitalIncrementE*Constants.incresvalue5/100;
		float sp6=Constants.REALorbitalIncrementE*Constants.incresvalue6/100;
		
		
		
		if (Constants.orbitalIncrementE==sp0){
			Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue1/100;
			Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue1/100;
			Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue1/100;
			Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue1/100;
			Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue1/100;
			Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue1/100;
			Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue1/100;
			Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue1/100;
			Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue1/100;
			Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue1/100;
			
			Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue1/100;
			Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue1/100;
			Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue1/100;
			Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue1/100;
			Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue1/100;
			Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue1/100;
			Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue1/100;
			Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue1/100;
			Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue1/100;
			
		}else if(Constants.orbitalIncrementE==sp1){
			Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue2/100;
			Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue2/100;
			Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue2/100;
			Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue2/100;
			Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue2/100;
			Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue2/100;
			Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue2/100;
			Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue2/100;
			Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue2/100;
			Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue2/100;
			
			Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue2/100;
			Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue2/100;
			Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue2/100;
			Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue2/100;
			Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue2/100;
			Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue2/100;
			Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue2/100;
			Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue2/100;
			Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue2/100;
			
		}else if(Constants.orbitalIncrementE==sp2){
			Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue3/100;
			Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue3/100;
			Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue3/100;
			Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue3/100;
			Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue3/100;
			Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue3/100;
			Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue3/100;
			Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue3/100;
			Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue3/100;
			Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue3/100;
			
			Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue3/100;
			Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue3/100;
			Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue3/100;
			Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue3/100;
			Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue3/100;
			Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue3/100;
			Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue3/100;
			Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue3/100;
			Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue3/100;
			
		}else if(Constants.orbitalIncrementE==sp3){
			Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue4/100;
			Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue4/100;
			Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue4/100;
			Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue4/100;
			Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue4/100;
			Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue4/100;
			Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue4/100;
			Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue4/100;
			Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue4/100;
			Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue4/100;
			
			Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue4/100;
			Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue4/100;
			Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue4/100;
			Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue4/100;
			Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue4/100;
			Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue4/100;
			Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue4/100;
			Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue4/100;
			Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue4/100;
			
		}else if(Constants.orbitalIncrementE==sp4){
			Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue5/100/100;
			Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue5/100/100;
			Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue5/100/100;
			Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue5/100/100;
			Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue5/100/100;
			Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue5/100;
			Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue5/100;
			Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue5/100;
			Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue5/100;
			Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue5/100;
			
			Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue5/100;
			Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue5/100;
			Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue5/100;
			Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue5/100;
			Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue5/100;
			Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue5/100;
			Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue5/100;
			Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue5/100;
			Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue5/100;
			
		}else if(Constants.orbitalIncrementE==sp5){
			Constants.TemporbitalIncrementE=Constants.REALorbitalIncrementE*Constants.incresvalue6/100;
			Constants.TemporbitalIncrementV=Constants.REALorbitalIncrementV*Constants.incresvalue6/100;
			Constants.TemporbitalIncrementM=Constants.REALorbitalIncrementM*Constants.incresvalue6/100;
			Constants.TemporbitalIncrementMars=Constants.REALorbitalIncrementMars*Constants.incresvalue6/100;
			Constants.TemporbitalIncrementU=Constants.REALorbitalIncrementU*Constants.incresvalue6/100;
			Constants.TemporbitalIncrementJ=Constants.REALorbitalIncrementJ*Constants.incresvalue6/100;
			Constants.TemporbitalIncrementN=Constants.REALorbitalIncrementN*Constants.incresvalue6/100;
			Constants.TemporbitalIncrementS=Constants.REALorbitalIncrementS*Constants.incresvalue6/100;
			Constants.TemporbitalIncrementP=Constants.REALorbitalIncrementP*Constants.incresvalue6/100;
			Constants.TemporbitalIncrementSun=Constants.REALorbitalIncrementSun*Constants.incresvalue6/100;
			
			Constants.TempownIncrementE=Constants.REALownIncrementE*Constants.incresvalue6/100;
			Constants.TempownIncrementV=Constants.REALownIncrementV*Constants.incresvalue6/100;
			Constants.TempownIncrementM=Constants.REALownIncrementM*Constants.incresvalue6/100;
			Constants.TempownIncrementMars=Constants.REALownIncrementMars*Constants.incresvalue6/100;
			Constants.TempownIncrementU=Constants.REALownIncrementU*Constants.incresvalue6/100;
			Constants.TempownIncrementJ=Constants.REALownIncrementJ*Constants.incresvalue6/100;
			Constants.TempownIncrementN=Constants.REALownIncrementN*Constants.incresvalue6/100;
			Constants.TempownIncrementS=Constants.REALownIncrementS*Constants.incresvalue6/100;
			Constants.TempownIncrementP=Constants.REALownIncrementP*Constants.incresvalue6/100;
			
		}else if(Constants.orbitalIncrementE==sp6){
			Constants.TemporbitalIncrementE=Constants.sTemporbitalIncrementE;
			Constants.TemporbitalIncrementV=Constants.sTemporbitalIncrementV;
			Constants.TemporbitalIncrementM=Constants.sTemporbitalIncrementM;
			Constants.TemporbitalIncrementMars=Constants.sTemporbitalIncrementMars;
			Constants.TemporbitalIncrementU=Constants.sTemporbitalIncrementU;
			Constants.TemporbitalIncrementJ=Constants.sTemporbitalIncrementJ;
			Constants.TemporbitalIncrementN=Constants.sTemporbitalIncrementN;
			Constants.TemporbitalIncrementS=Constants.sTemporbitalIncrementS;
			Constants.TemporbitalIncrementP=Constants.sTemporbitalIncrementP;
			Constants.TemporbitalIncrementSun=Constants.sTemporbitalIncrementSun;
			
			Constants.TempownIncrementE=Constants.sTempownIncrementE;
			Constants.TempownIncrementV=Constants.sTempownIncrementV;
			Constants.TempownIncrementM=Constants.sTempownIncrementM;
			Constants.TempownIncrementMars=Constants.sTempownIncrementMars;
			Constants.TempownIncrementU=Constants.sTempownIncrementU;
			Constants.TempownIncrementJ=Constants.sTempownIncrementJ;
			Constants.TempownIncrementN=Constants.sTempownIncrementN;
			Constants.TempownIncrementS=Constants.sTempownIncrementS;
			Constants.TempownIncrementP=Constants.sTempownIncrementP;
		}else {
			Constants.TemporbitalIncrementE=Constants.sTemporbitalIncrementE;
			Constants.TemporbitalIncrementV=Constants.sTemporbitalIncrementV;
			Constants.TemporbitalIncrementM=Constants.sTemporbitalIncrementM;
			Constants.TemporbitalIncrementMars=Constants.sTemporbitalIncrementMars;
			Constants.TemporbitalIncrementU=Constants.sTemporbitalIncrementU;
			Constants.TemporbitalIncrementJ=Constants.sTemporbitalIncrementJ;
			Constants.TemporbitalIncrementN=Constants.sTemporbitalIncrementN;
			Constants.TemporbitalIncrementS=Constants.sTemporbitalIncrementS;
			Constants.TemporbitalIncrementP=Constants.sTemporbitalIncrementP;
			Constants.TemporbitalIncrementSun=Constants.sTemporbitalIncrementSun;
			
			Constants.TempownIncrementE=Constants.sTempownIncrementE;
			Constants.TempownIncrementV=Constants.sTempownIncrementV;
			Constants.TempownIncrementM=Constants.sTempownIncrementM;
			Constants.TempownIncrementMars=Constants.sTempownIncrementMars;
			Constants.TempownIncrementU=Constants.sTempownIncrementU;
			Constants.TempownIncrementJ=Constants.sTempownIncrementJ;
			Constants.TempownIncrementN=Constants.sTempownIncrementN;
			Constants.TempownIncrementS=Constants.sTempownIncrementS;
			Constants.TempownIncrementP=Constants.sTempownIncrementP;
		}
		}
		
		if (Constants.onchange==true){
			
		}
		
}

}