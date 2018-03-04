package com.example.ashike.searchstring;

import android.os.AsyncTask;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static TextView texx;
    TextToSpeech tt;
    Button but1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1 = (Button)findViewById(R.id.btn1);
        texx = (TextView)findViewById(R.id.text1);

        but1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                FetchData process1 = new FetchData();
                process1.execute();

            }
        });
        tt = new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener(){

            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR)
                    tt.setLanguage(Locale.UK);

            }
        });

        Button bt = (Button)findViewById(R.id.btn2);

    }

    public void speak_my_text(View vv){
        String sentence = texx.getText().toString();
        //sentence = "Hi I am ashike";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Toast.makeText(this,sentence,Toast.LENGTH_SHORT).show();
            tt.speak(sentence,TextToSpeech.QUEUE_FLUSH,null,null);
        }

    }

    /*public class doit extends AsyncTask<Void,Void,Void> {
        String words;

        @Override
        protected Void doInBackground(Void... params) {
            try {
                //Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Amir Khan").get();

                Document doc = Jsoup.connect("https://mdomarfaruk.com/api/wiki.php?search=bangladesh").get();

                Elements topics = doc.select("h");

                words = topics.text();
                public static JSONObject get

                JSONArray data = new JSONArray("https://mdomarfaruk.com/api/wiki.php?search=bangladesh");
                String sentence = "Ashike";



            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            texx.setText(words);
        }
    }*/

}
