package com.example.newtimes;

public class Helper {
 static float orbitincr (float speed,float x,float y,float z){
	 float X,Y,Z;
		float ras;
		X=x-MiddleActivity.kord[9][0];
		Y=y-MiddleActivity.kord[9][1];
		Z=z-MiddleActivity.kord[9][2];
		X=X*X;
		Y=Y*Y;
		Z=Z*Z;
		ras=((float) Math.sqrt(X+Y+Z))*100000; 
	return (((speed*1000)/ras))*1000;           //увеличили
 }
 
 
 static float vnradius (float mas,float plotn){
	 float x=0;
	 mas*=1000000000000000000000000f;
	 x=mas/plotn;
	 x=(float) Math.pow(((3*x)/(4*Math.PI)) ,1/3);
	 return x;
 }
 


}
