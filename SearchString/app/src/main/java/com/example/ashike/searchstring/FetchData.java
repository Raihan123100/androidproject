package com.example.ashike.searchstring;


import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class FetchData extends AsyncTask<Void,Void,Void>{
    String data = "";
    String SingleObject = "";
    String TotalObject = "";
    @Override
    protected Void doInBackground(Void... params) {
        try {
            URL url = new URL("https://api.myjson.com/bins/18kof3");

            HttpURLConnection httpconnection1 =(HttpURLConnection) url.openConnection();
            InputStream in1 = httpconnection1.getInputStream();
            BufferedReader buf1 = new BufferedReader(new InputStreamReader(in1));
            String line="";
            while(line!=null){
                line = buf1.readLine();
                data = data + line;
            }

            JSONArray JA1 = new JSONArray(data);
            for(int i=0;i<JA1.length();i++){
                JSONObject JO1 = (JSONObject) JA1.get(i);
                SingleObject = "Name.." + JO1.get("Title") + "\n" +
                                "Description.." + JO1.get("Description") + "\n" +
                                "Age.." + JO1.get("Age") + "\n";
                TotalObject += SingleObject + "\n\n";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.texx.setText(this.TotalObject);
    }
}
