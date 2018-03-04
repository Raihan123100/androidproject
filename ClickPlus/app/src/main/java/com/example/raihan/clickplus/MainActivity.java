package com.example.raihan.clickplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        tv=(TextView)findViewById(R.id.textView);


        b1.setOnClickListener(new View.OnClickListener(){





            @Override


            public void onClick(View v){



           String count     =tv.getText().toString();

                int intcount=Integer.parseInt(count);
                intcount++;


                tv.setText(String.valueOf(intcount));








            }
        }




        );




        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv.setText(String.valueOf(0));

            }
        });







    }
}
