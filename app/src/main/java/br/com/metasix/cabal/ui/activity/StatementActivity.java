package br.com.metasix.cabal.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;

import br.com.metasix.cabal.R;

/**
 * Created by renan on 5/8/15.
 */
public class StatementActivity extends ActionBarActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);
        init();
    }

    private void init() {

    }
}
