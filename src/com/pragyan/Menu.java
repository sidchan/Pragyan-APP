package com.pragyan;


import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.format.DateFormat;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu extends Activity {
	TextView tv;
	CharSequence tdy;
	CharSequence pragyan;
	 Date now;
	 Date dest;
	 long diffInMis;
	 Calendar cal;
	 public int currentimageindex=0;
		Timer timer;
		TimerTask task;
		ImageView slidingimage;
		private int[] IMAGE_IDS = {
				R.drawable.splash0, R.drawable.splash1, R.drawable.splash2,	
				R.drawable.splash3
			};
     public void onCreate (Bundle savedInstanceState)
     {
    	 super.onCreate(savedInstanceState);
         setContentView(R.layout.menu);
         final Handler mHandler = new Handler();

         // Create runnable for posting
         final Runnable mUpdateResults = new Runnable() {
             public void run() {
             	
             	AnimateandSlideShow();
             	
             }
         };
         int delay = 1000; // delay for 1 sec.

         int period = 8000; // repeat every 4 sec.

         Timer timer = new Timer();

         timer.scheduleAtFixedRate(new TimerTask() {

         public void run() {

         	 mHandler.post(mUpdateResults);

         }

         }, delay, period);
      	

         // Create runnable for posting
        
        now=new Date();
          tdy= DateFormat.format("yyyy-MM-dd hh:mm:ss", now.getTime());
              int year=112;
          int month=01;
          int date=22;
          int hour=00;
          int min=00;
          int sec=00;	
          dest = new Date(year,month,date,hour,min,sec);
          pragyan= DateFormat.format("yyyy-MM-dd hh:mm:ss", dest.getTime());
          diffInMis= dest.getTime() - now.getTime();
          tv=(TextView) findViewById(R.id.textView1);
         Prag counter=new Prag(diffInMis,1000);
       
    
     	
        counter.start();
     	
           	 
         
     }

     private void AnimateandSlideShow() {
     	
     	
     	slidingimage = (ImageView)findViewById(R.id.imageView1);
    		slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);
    		
    		currentimageindex++;
     }
     
    
public class Prag extends CountDownTimer{
	
	public Prag(long millisInFuture,long countDownInterval)
	{super(millisInFuture,countDownInterval);
	}
	public void onFinish()
	{tv.setText("Prayan is here !!");
	}
	public void onTick(long millisUntilFinished)
	{long days= millisUntilFinished/86400;
	long rem=millisUntilFinished%86400;
	long hours=rem/3600;
	long rem2=rem%3600;
	long mins=rem2/60;
	long sec=rem2%60;
	
	
		tv.setText("Days left for pragyan :"+days/1000+"\nSeconds left for Pragyan:"+millisUntilFinished/1000);
	}
	
	
}
}
