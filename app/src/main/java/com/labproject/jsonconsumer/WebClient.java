package com.labproject.jsonconsumer;

import com.labproject.jsonconsumer.model.Person;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Susiane on 20/08/2016.
 */
public class WebClient {
    private static final String URL_JSON ="https://s3-sa-east-1.amazonaws.com/pontotel-docs/data.json";

    public List<Person> get(){
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(URL_JSON);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();

            String line = "";
            while((line = reader.readLine()) != null){
                buffer.append(line);
            }
            String finalJson = buffer.toString();

            JSONObject parentObject = new JSONObject(finalJson);
            JSONArray parentArrey = parentObject.getJSONArray("data");


            List<Person> personList = new ArrayList<>();
            for(int i = 0; i < parentArrey.length(); i++){
                Person person = new Person();
                JSONObject finalObject = parentArrey.getJSONObject(i);
                person.setId(finalObject.getString("id"));
                person.setName(finalObject.getString("name"));
                person.setPwd(finalObject.getInt("pwd"));

                personList.add(person);
            }
            return personList;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.disconnect();
            }
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
