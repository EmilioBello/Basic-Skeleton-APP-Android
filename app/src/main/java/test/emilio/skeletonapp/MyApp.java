package test.emilio.skeletonapp;

import android.app.Application;
import android.content.Context;

import test.emilio.skeletonapp.model.realm.ADRealm;


public class MyApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        //get Context
        context = getApplicationContext();

        //realm init
        ADRealm realm = new ADRealm();
        realm.init(context);
    }

    public static Context getContext() {
        return context;
    }

    /*protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }*/
}