package com.pragyan;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class main extends Activity {
    /** Called when the activity is first created. */
    
    MediaPlayer splashsound;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        splashsound = MediaPlayer.create(this,R.raw.logo_noise);
        splashsound.start();
        Thread PragTimer = new Thread(){
        	  public void run() {
        		  try{
        			  int PragTimer=0;
        			  while(PragTimer<5000)
        			  { sleep(100);
        			     PragTimer=PragTimer+100;
        			  }
        			  startActivity(new Intent("com.pragyan.CLEARSCREEN"));
        		  }catch (InterruptedException e)
        		  { e.printStackTrace();
        		  }
                  finally{finish();
        		  }
        	  }
        };
    PragTimer.start();
    }
    
    
}