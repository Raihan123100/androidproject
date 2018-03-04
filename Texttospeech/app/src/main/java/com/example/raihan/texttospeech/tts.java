package com.example.raihan.texttospeech;

import android.speech.tts.TextToSpeech;

import java.util.Locale;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Raihan on 12/26/2017.
 */

public class tts {

   public void  ttss(){
     final  TextToSpeech t1;
       t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
           @Override
           public void onInit(int status) {
               if(status != TextToSpeech.ERROR) {
                   t1.setLanguage(Locale.UK);
               }
           }
       });

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String toSpeak = ed1.getText().toString();
               Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
               t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
           }
       });
   }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }






   }






}
