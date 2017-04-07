package com.example.ramadan.news.adapter;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by ramadan on 4/2/2017.
 */
public class MyApp extends Application {
    private static MyApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    public static synchronized MyApp getInstance() {
        return mInstance;
    }
//    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
//        ConnectivityReceiver.connectivityReceiverListener = listener;
//    }

    /**
     * Created by Ramadan El-Sayed on 12/11/2016.
     */
    public static class ConnectivityReceiver extends BroadcastReceiver {


        public static ConnectivityReceiverListener connectivityReceiverListener;

        public ConnectivityReceiver() {
            super();
        }

        @Override
        public void onReceive(Context context, Intent arg1) {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null
                    && activeNetwork.isConnectedOrConnecting();

            if (connectivityReceiverListener != null) {
                connectivityReceiverListener.onNetworkConnectionChanged(isConnected);
            }
        }

        public static boolean isConnected() {
            MyApp myApp=new MyApp();
            ConnectivityManager cm = (ConnectivityManager) myApp.getInstance().getApplicationContext()
                    .getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null
                    && activeNetwork.isConnectedOrConnecting();
        }


        public interface ConnectivityReceiverListener {
            void onNetworkConnectionChanged(boolean isConnected);
        }
    }
}

