package br.com.metasix.cabal.app;

import android.app.Application;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import br.com.metasix.cabal.entity.Card;
import br.com.metasix.cabal.enums.CardType;

/**
 * Created by renan on 4/30/15.
 */
public class App extends Application{

    Toolbar toolbar;
    List<Card> myCards;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public void init(){
        myCards = new ArrayList<Card>();

    }
}
