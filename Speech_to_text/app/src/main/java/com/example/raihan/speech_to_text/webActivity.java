package com.example.raihan.speech_to_text;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class webActivity extends AppCompatActivity {
    TextView show_data;
    String t1="";
    String n1="";

    TextToSpeech tt;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_data=(TextView) findViewById(R.id.showdata);
        bt1=(Button)findViewById(R.id.button);
        fetchingData();

        tt = new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener(){

            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR)
                    tt.setLanguage(Locale.UK);

            }
        });





    }


    void fetchingData(){



        String myURL="http://mdomarfaruk.com/api/wiki.php?search=Bangladesh";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(myURL, new Response.Listener<JSONArray>(){

            @Override
            public void onResponse(JSONArray response){


                //  String[] news_title= new String[response.length()];

                for(int i=0;i<response.length();i++){


                    try {
                        JSONObject jsonObject=(JSONObject) response.get(i);
                        t1=t1+ jsonObject.getString("title")+"\n";
                        // n1=n1+ jsonObject.getString("news"+"\n ");
                        // int foo = Integer.parseInt(jsonObject.getString("0"));
                        //news_title[i]=jsonObject.getString("foo");

                    } catch (JSONException e) {

                        e.printStackTrace();
                    }


                }
                show_data.setText(t1) ;
                // lv.setAdapter(new ArrayAdapter(getApplicationContext(),R.layout.mylistview,R.id.textviewforlist,news_title));


            }



        },new Response.ErrorListener(){
            @Override

            public  void onErrorResponse(VolleyError error){

                VolleyLog.d("volley Log", error);
            }

        });



        com.example.raihan.speech_to_text.AppController.getInstance().addToRequestQueue(jsonArrayRequest);

        Toast.makeText(getApplicationContext(),"Data add",Toast.LENGTH_LONG).show();
    }




    public void speak_my_text(View vv){
        String sentence = show_data.getText().toString();
        //sentence = "Hi I am ashike";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Toast.makeText(this,sentence,Toast.LENGTH_SHORT).show();
            tt.speak(sentence,TextToSpeech.QUEUE_FLUSH,null,null);
        }

    }








}

