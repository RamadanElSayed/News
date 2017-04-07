package com.example.ramadan.news;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.ramadan.news.ConnectToAPI.ConnectAPI;
import com.example.ramadan.news.adapter.AdapterNews;
import com.example.ramadan.news.adapter.MyApp;
import com.example.ramadan.news.dataProcess.DataEncrpt;
import com.example.ramadan.news.dataProcess.ParsingDataFromJsonFile;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    final  static  String url=" https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=f0ef0040cf6b4bb49c85209accd11271";
    ParsingDataFromJsonFile parsedata=new ParsingDataFromJsonFile();
    RecyclerView recyclerView;
    ArrayList<DataEncrpt> arrayList;
AdapterNews adapterNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

























        final AlertDialog.Builder builderconfirm = new AlertDialog.Builder(this);
        builderconfirm.setTitle("Internet:?");
        builderconfirm.setMessage("Please check your connection of internet");
        builderconfirm.setIcon(android.R.drawable.ic_dialog_alert);
        builderconfirm.setPositiveButton("Try again.. ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                final Dialog dialogDelete = builderconfirm.create();

                boolean isConnected = MyApp.ConnectivityReceiver.isConnected();

                if (isConnected == false) {
                    dialogDelete.show();
                    dialogDelete.setCancelable(false);

                    dialogDelete.setCanceledOnTouchOutside(false);
                    return;

                } else {
                    dialogDelete.dismiss();

                    ConnectAPI connectAPI=new ConnectAPI();

                    try {
                        arrayList=parsedata.JsonProcess(connectAPI.execute(url).get());

                        recyclerMain();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        final Dialog dialogDelete = builderconfirm.create();

        boolean isConnected = MyApp.ConnectivityReceiver.isConnected();

        if (isConnected == false) {
            dialogDelete.show();
            dialogDelete.setCancelable(false);

            dialogDelete.setCanceledOnTouchOutside(false);
            //return;

        }

        else if(isConnected==true)
        {
            ConnectAPI connectAPI=new ConnectAPI();

            try {
                arrayList=parsedata.JsonProcess(connectAPI.execute(url).get());

                recyclerMain();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        //First Step
        // Class connect to ApI or Server then return data from server
        // then send data to class json to parse data to json object .
        // then send data to recycler view

    }



    private void recyclerMain() {

        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapterNews = new AdapterNews(arrayList, getApplicationContext(), this);

        recyclerView.setAdapter(adapterNews);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapterNews.notifyDataSetChanged();

    }
}
