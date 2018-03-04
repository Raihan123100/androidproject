package com.example.raihan.speech_to_text;

import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


private TextView txvResult;
    MediaPlayer mysound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mysound = MediaPlayer.create(this,R.raw.a);
        txvResult=(TextView)findViewById(R.id.textView);
       // mysound.start();

    }

public  void getSpeechInput(View view){

    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

    if (intent.resolveActivity(getPackageManager())!=null) {

        startActivityForResult(intent, 1);
    }

    else{
        Toast.makeText(this,"your device don't supported ",Toast.LENGTH_SHORT).show();
    }

}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK && null != data){

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    txvResult.setText(result.get(0));
                     Toast.makeText(getApplicationContext(),txvResult.getText(),Toast.LENGTH_SHORT).show();
                }

                if (txvResult.getText().equals("web"))
                {

                    // Toast.makeText(getApplicationContext(),"hi anis",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(MainActivity.this,webActivity.class);
                    startActivity(i);

                }

                else if(txvResult.getText().equals("caption")) {
                    Intent j=new Intent(MainActivity.this,captionActivity.class);
                    startActivity(j);
                }

                        break;
        }
    }
}