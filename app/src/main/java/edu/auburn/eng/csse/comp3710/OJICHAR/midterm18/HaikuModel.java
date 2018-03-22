package edu.auburn.eng.csse.comp3710.OJICHAR.midterm18;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;




/**
 * Created by DOMINUS on 3/17/18.
 */

public class HaikuModel  extends Application {

    private  Context appContext;


    private static final String TAG = "HAIKUMODEL";


    @Override
    public void onCreate()
    {//Always called before anything else in the app
        //so in the rest of your code safe to call MyApplicationClass.getContext();
        super.onCreate();
        appContext = this;


    }


    public HaikuModel() {


    }


    public Context getContext()
    {
        return appContext;
    }





    private void readAndDisplayAdjFile() {
        AssetManager mgr = this.getContext().getAssets();
        InputStream is = null;
        int size = 0;
        byte[] adj;


        try {
            is = mgr.open("adjectives.txt");
            size = is.available();
            adj = new byte[size];
            is.read(adj);
            is.close();

            for (int i = 0; i < size; i++){
                Log.d(TAG, "onCreate:items" + adj[i]);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    private void readAndDisplayNounsFile() {
        AssetManager mgr = this.getContext().getAssets();
        InputStream is = null;
        int size = 0;
        byte[] nouns;


        try {
            is = mgr.open("nouns.txt");
            size = is.available();
            nouns = new byte[size];
            is.read(nouns);
            is.close();

            for (int i = 0; i < size; i++){
                Log.d(TAG, "onCreate:items" + nouns[i]);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    

}
