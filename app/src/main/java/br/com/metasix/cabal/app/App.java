package br.com.metasix.cabal.app;

import android.app.Activity;
import android.app.Application;
import android.os.AsyncTask;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.metasix.cabal.R;
import br.com.metasix.cabal.entity.Card;
import br.com.metasix.cabal.util.ConnectionDetectorUtils;

/**
 * Created by renan on 4/30/15.
 */
public class App extends Application{

    private List<AsyncTask<?,?,?>> tasks;
    Toolbar toolbar;
    List<Card> myCards;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public void init(){
        myCards = new ArrayList<Card>();
    }

    public void registerTask(AsyncTask<?,?,?> task){
        if(task != null){
            tasks.add(task);
        }
    }

    private void unRegisterTask(AsyncTask<?,?,?> task){
        if(task != null){
            task.cancel(true);
            tasks.remove(task);
        }
    }

    public boolean isInternetConnection(Activity activity){
        ConnectionDetectorUtils cd = new ConnectionDetectorUtils(this);
        if (!cd.isConnectingToInternet()) {
            Toast.makeText(activity, R.string.exception_erro_err_internet_disconnected, Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for(AsyncTask<?,?,?> task : tasks){
            unRegisterTask(task);
        }
    }
}
