package com.example.newtimes;

public class Constants {
	
	static boolean ondefault =false;
	static float zvaluedefault=4f;
	static float zvalue=4f;
	static float zx=0f;
	static float xvalue=0f;
	static float yvalue=0f;
	static int quality=100;
	static boolean onbackground=false;
	static boolean onincrdis=false;
	static boolean onincrspeed=false;
	static boolean onanglch=false;
	static boolean onchange=false; 
	
	static float incresvalue1=5f;
	static float incresvalue2=50f;
	static float incresvalue3=250f;
	static float incresvalue4=1000f;
	static float incresvalue5=10000f;
	static float incresvalue6=1000000f;
	static float mconst=57.255f;
	static float minif=2f;
	static float increment=0f;
	static float radius=0f;
	static float radior=0f;
	
	static float REALorbitalIncrementE= (float) (((Math.PI*2)/(365.2564*24*60))*25000);   
	static float REALorbitalIncrementV= (float) (((Math.PI*2)/(224.7*24*60))*25000);  
	static float REALorbitalIncrementM= (float) (((Math.PI*2)/(0.24085*365.2564*24*60))*25000);  
	static float REALorbitalIncrementMars= (float) (((Math.PI*2)/(1.88*365.2564*24*60))*25000);  
	static float REALorbitalIncrementU= (float) (((Math.PI*2)/(84.02*365.2564*24*60))*25000);  
	static float REALorbitalIncrementJ= (float) (((Math.PI)/(11.86*365.2564*24*60))*25000);  
	static float REALorbitalIncrementN= (float) (((Math.PI)/(164.78*365.2564*24*60))*25000);  
	static float REALorbitalIncrementS= (float) (((Math.PI)/(29.46*365.2564*24*60))*25000);  
	static float REALorbitalIncrementP= (float) (((Math.PI)/(248.09*365.2564*24*60))*25000);  
	static float REALorbitalIncrementSun= 0.05f; 
	
	static float REALownIncrementE= (float) (REALorbitalIncrementE*24*60); 
	static float REALownIncrementV= (float) (REALorbitalIncrementV*24*60);  
	static float REALownIncrementM= (float) (REALorbitalIncrementM*24*60);  
	static float REALownIncrementMars= (float) (REALorbitalIncrementMars*24*60);  
	static float REALownIncrementU= (float) (REALorbitalIncrementU*24*60);  
	static float REALownIncrementJ= (float) (REALorbitalIncrementJ*24*60);  
	static float REALownIncrementN= (float) (REALorbitalIncrementN*24*60);  
	static float REALownIncrementS= (float) (REALorbitalIncrementS*24*60);  
	static float REALownIncrementP= (float) (REALorbitalIncrementP*24*60);  
	
	static float[] REALkoordE={1f,0.0f,0.0f}; //au=149 597 870 700 метрам                                              
	static float[] REALkoordV={0.72f,0.0f,0.0f}; 
	static float[] REALkoordM={0.0f,0.0f,0.39f};
	static float[] REALkoordMars={0.0f,0.0f,1.52f};
	static float[] REALkoordU={-19.22f,0.0f,0.0f};
	static float[] REALkoordJ={-5.2f,0.0f,0.0f};
	static float[] REALkoordN={(float) -(Math.cos(45)*30),0.0f,(float) -(Math.cos(45)*30f)};
	static float[] REALkoordS={(float) (Math.cos(45)*9.54f),0.0f,(float) (Math.cos(45)*9.54f)};
	static float[] REALkoordP={(float) -(Math.cos(45)*39.5f),0.0f,(float) (Math.cos(45)*39.5f)};
	static float[] REALkoordSun={0f,0f,0f};
	
	
	static float orbitalIncrementE= (float) (((Math.PI*2)/(365.2564*24*60))*25000);   
	static float orbitalIncrementV= (float) (((Math.PI*2)/(224.7*24*60))*25000);  
	static float orbitalIncrementM= (float) (((Math.PI*2)/(0.24085*365.2564*24*60))*25000);  
	static float orbitalIncrementMars= (float) (((Math.PI*2)/(1.88*365.2564*24*60))*25000);  
	static float orbitalIncrementU= (float) (((Math.PI*2)/(84.02*365.2564*24*60))*250000);  
	static float orbitalIncrementJ= (float) (((Math.PI)/(11.86*365.2564*24*60))*100000);  
	static float orbitalIncrementN= (float) (((Math.PI)/(164.78*365.2564*24*60))*2500000);  
	static float orbitalIncrementS= (float) (((Math.PI)/(29.46*365.2564*24*60))*100000);  
	static float orbitalIncrementP= (float) (((Math.PI)/(248.09*365.2564*24*60))*2500000);  
	static float orbitalIncrementSun= 0.08f; 
	
	static float ownIncrementE= (float) (orbitalIncrementE*24*60/70); 
	static float ownIncrementV= (float) (orbitalIncrementV*24*60/150);  
	static float ownIncrementM= (float) (orbitalIncrementM*24*60/130);  
	static float ownIncrementMars= (float) (orbitalIncrementMars*24*60/70);  
	static float ownIncrementU= (float) (orbitalIncrementU*24*60);  
	static float ownIncrementJ= (float) (orbitalIncrementJ*24*60/310);  
	static float ownIncrementN= (float) (orbitalIncrementN*24*60/200);  
	static float ownIncrementS= (float) (orbitalIncrementS*24*60/360);  
	static float ownIncrementP= (float) (orbitalIncrementP*24*60/200); 
	
	static float TemporbitalIncrementE=Constants.REALorbitalIncrementE/100;
	static float TemporbitalIncrementV= Constants.REALorbitalIncrementV/100;
	static float TemporbitalIncrementM= Constants.REALorbitalIncrementM/100;
	static float TemporbitalIncrementMars= Constants.REALorbitalIncrementMars/100;
	static float TemporbitalIncrementU= Constants.REALorbitalIncrementU/100;
	static float TemporbitalIncrementJ= Constants.REALorbitalIncrementJ/100;
	static float TemporbitalIncrementN= Constants.REALorbitalIncrementN/100; 
	static float TemporbitalIncrementS= Constants.REALorbitalIncrementS/100;
	static float TemporbitalIncrementP= Constants.REALorbitalIncrementP/100;
	static float TemporbitalIncrementSun= Constants.REALorbitalIncrementSun/100;
	
	static float TempownIncrementE= Constants.REALownIncrementE/100;
	static float TempownIncrementV= Constants.REALownIncrementV/100;
	static float TempownIncrementM= Constants.REALownIncrementM/100;
	static float TempownIncrementMars= Constants.REALownIncrementMars/100;
	static float TempownIncrementU= Constants.REALownIncrementU/100;
	static float TempownIncrementJ= Constants.REALownIncrementJ/100;
	static float TempownIncrementN= Constants.REALownIncrementN/100;
	static float TempownIncrementS= Constants.REALownIncrementS/100;
	static float TempownIncrementP= Constants.REALownIncrementP/100;
	
	static float sTemporbitalIncrementE=Constants.REALorbitalIncrementE/100;
	static float sTemporbitalIncrementV= Constants.REALorbitalIncrementV/100;
	static float sTemporbitalIncrementM= Constants.REALorbitalIncrementM/100;
	static float sTemporbitalIncrementMars= Constants.REALorbitalIncrementMars/100;
	static float sTemporbitalIncrementU= Constants.REALorbitalIncrementU/100;
	static float sTemporbitalIncrementJ= Constants.REALorbitalIncrementJ/100;
	static float sTemporbitalIncrementN= Constants.REALorbitalIncrementN/100; 
	static float sTemporbitalIncrementS= Constants.REALorbitalIncrementS/100;
	static float sTemporbitalIncrementP= Constants.REALorbitalIncrementP/100;
	static float sTemporbitalIncrementSun= Constants.REALorbitalIncrementSun/100;
	
	static float sTempownIncrementE= Constants.REALownIncrementE/100;
	static float sTempownIncrementV= Constants.REALownIncrementV/100;
	static float sTempownIncrementM= Constants.REALownIncrementM/100;
	static float sTempownIncrementMars= Constants.REALownIncrementMars/100;
	static float sTempownIncrementU= Constants.REALownIncrementU/100;
	static float sTempownIncrementJ= Constants.REALownIncrementJ/100;
	static float sTempownIncrementN= Constants.REALownIncrementN/100;
	static float sTempownIncrementS= Constants.REALownIncrementS/100;
	static float sTempownIncrementP= Constants.REALownIncrementP/100;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	static float[] koordE={1f,0.0f,0.0f}; //au=149 597 870 700 метрам                                              
	static float[] koordV={0.72f,0.0f,0.0f}; 
	static float[] koordM={(float) -(Math.cos(45)*0.39f),0.0f,(float) -(Math.cos(45)*0.39f)};
	static float[] koordMars={(float) -(Math.cos(45)*1.52f),0.0f,(float) (Math.cos(45)*1.52f)};
	static float[] koordU={-19.22f,0.0f,0.0f};
	static float[] koordJ={-5.2f,0.0f,0.0f};
	static float[] koordN={(float) -(Math.cos(45)*25),0.0f,(float) -(Math.cos(45)*25f)};
	static float[] koordS={(float) (Math.cos(45)*9.54f),0.0f,(float) (Math.cos(45)*9.54f)};
	static float[] koordP={(float) -(Math.cos(45)*26.5f),0.0f,(float) (Math.cos(45)*26.5f)};
	static float[] koordSun={0f,0f,0f};	                                                                             
 
	static float oblatnessE=0.00335f;
	static float oblatnessV=0.0f;
	static float oblatnessM=0.0f;
	static float oblatnessMars=0.00648f;
	static float oblatnessU=0.02293f;
	static float oblatnessJ=0.06487f;
	static float oblatnessN=0.01708f;
	static float oblatnessS=0.09796f;
	static float oblatnessP=0.0f;
	
	static float taxisE=66.5f;
	static float taxisV=267.4f;
	static float taxisM=90.0f;
	static float taxisMars=64.8f;
	static float taxisU=188.5f;
	static float taxisJ=87.0f;
	static float taxisN=60.4f;
	static float taxisS=64.7f;
	static float taxisP=213.5f;
	static float taxisSun=0f;
	
	static float nvnradiusE=0.06378f;                         
	static float nvnradiusV=0.06052f;		
	static float nvnradiusM=0.02439f;
	static float nvnradiusMars=0.03488f;
	static float nvnradiusU=0.265f;
	static float nvnradiusJ=0.713f;
	static float nvnradiusN=0.24760f;
	static float nvnradiusS=0.4f;
	static float nvnradiusP=0.31f;
	static float nvnradiusSun=0.15f;
	
	static float maasE=5.97f;
	static float maasV=4.8f;
	static float maasM=0.32f;
	static float maasMars=0.63f;
	static float maasU=86f;
	static float maasJ=1876f;
	static float maasN=101f;
	static float maasS=561f;
	static float maasP=0.01f;
	static float maasSun=1989000f;
	
	static float spedE=30f;
	static float spedV=35f;
	static float spedM=48f;
	static float spedMars=24f;
	static float spedU=7f;
	static float spedJ=13f;
	static float spedN=5f;
	static float spedS=10f;
	static float spedP=5f;
	static float spedSun=0f;
	
	static float plotE=5515f;
	static float plotV=5240f;
	static float plotM=5430f;
	static float plotMars=3940f;
	static float plotU=1300f;
	static float plotJ=1330f;
	static float plotN=1760f;
	static float plotS=700f;
	static float plotP=2030f;
	static float plotSun=1409f;
	
	static float radorE=1.0f;
	static float radorV=0.72f;
	static float radorM=0.39f;
	static float radorMars=1.52f;
	static float radorU=19.22f;
	static float radorJ=5.2f;
	static float radorN=25f;
	static float radorS=9.54f;
	static float radorP=26.5f;

	static int residstar=com.example.newtimes.R.drawable.star;
	static int residEarth = com.example.newtimes.R.drawable.earth_16k;
	static int residVenus = com.example.newtimes.R.drawable.venuss;
	static int residMercury = com.example.newtimes.R.drawable.mercury;
	static int residMars = com.example.newtimes.R.drawable.mars;
	static int residUranus = com.example.newtimes.R.drawable.ura0fss1;
	static int residJupiter = com.example.newtimes.R.drawable.jupiter4k;
	static int residNeptune = com.example.newtimes.R.drawable.neptune;
	static int residSaturn = com.example.newtimes.R.drawable.saturn;
	static int residPluton = com.example.newtimes.R.drawable.plu0rss1;
	static int residrings=com.example.newtimes.R.drawable.saturnr2;
	static int residringu=com.example.newtimes.R.drawable.uranus_rings;
	static int residBumpE=com.example.newtimes.R.drawable.earthnormal;
	static int residBumpV=com.example.newtimes.R.drawable.venusnormal2k;
	
}
