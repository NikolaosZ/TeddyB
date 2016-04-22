package Helper_Classes;

import android.app.Application;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;

/**
 * Created by pwdarby on 3/30/16.
 *
 * Works like a common storage box reachable by any activity for global variables and methods.
 */

public class tedSingleton extends Application {
    private volatile static tedSingleton mInstance = null;

    private String language;
    private String BearID;
    private String Username;
    private CognitoCachingCredentialsProvider credentials;

    private tedSingleton() {
        language = "english";
        credentials = null;

    }
    public static tedSingleton getInstance(){  //Singleton's core
        if(mInstance == null){
            mInstance = new tedSingleton();
        }
        return mInstance;
    }

    //Get and Set methods here


    public void setLanguage(String s){language = s;}
    public String getLanguage(){return this.language;}

    public void setBearID(String s){BearID = s;}
    public String getBearID(){return this.BearID;}

    public void setUsername(String s){Username = s;}
    public String getUsername(){return this.Username;}

    public void setCredentials(CognitoCachingCredentialsProvider c){credentials = c;}
    public CognitoCachingCredentialsProvider getCredentials() {return this.credentials;}

}