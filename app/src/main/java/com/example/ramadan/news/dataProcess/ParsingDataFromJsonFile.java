package com.example.ramadan.news.dataProcess;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ramadan on 4/2/2017.
 */
public class ParsingDataFromJsonFile {
    ArrayList<DataEncrpt>myList;
    public ArrayList<DataEncrpt>JsonProcess(String jsonFile)
    {

        myList=new ArrayList<>();
        try {
            // get json file to parse it and take object to access
            JSONObject MainObject=new JSONObject(jsonFile);
            // get array of data in side the previous object
            // and that depend on the shape of data in json file
            JSONArray jsonArray=MainObject.getJSONArray("articles");
            // step by step to get data
            for (int i=0;i<jsonArray.length();i++)
            {
                // get data in side every index in array zero bassed
                JSONObject objectfromindex=jsonArray.getJSONObject(i);
                // get data and passing it class of encrpt with the same of arrangement of prameters
                DataEncrpt encrpt=new DataEncrpt(objectfromindex.getString(GetKey.urlkey),objectfromindex.getString(GetKey.imagekey),
                        objectfromindex.getString(GetKey.desckey),objectfromindex.getString(GetKey.titlekey));

                // add it in the arraylist to use it
                myList.add(encrpt);
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }
        return myList;
    }


    // function to get data to avoid if you want to read data to pass json file .
    // only return data
    public ArrayList<DataEncrpt>alldatafromJsonFile()
    {
        return myList;
    }








}
