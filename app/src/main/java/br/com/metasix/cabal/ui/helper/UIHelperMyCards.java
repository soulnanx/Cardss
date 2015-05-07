package br.com.metasix.cabal.ui.helper;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import br.com.metasix.cabal.R;

public class UIHelperMyCards {

    public ListView cards;
    public TextView lastUpdate;

    public UIHelperMyCards(View v) {
        cards = (ListView) v.findViewById(R.id.cards_lv);
        lastUpdate = (TextView) v.findViewById(R.id.last_update_tv);
    }
}