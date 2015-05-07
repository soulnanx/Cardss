package br.com.metasix.cabal.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.metasix.cabal.R;
import br.com.metasix.cabal.ui.activity.DrawerLayoutMain;
import br.com.metasix.cabal.ui.helper.UIHelperMyCards;

/**
 * Created by renan on 5/4/15.
 */
public class MyCardsFragment extends Fragment {

    public static final int NAME_ITEM = R.string.my_cards_fragment;
    public static final int ICON_ITEM = android.R.drawable.ic_menu_myplaces;

    private View view;
    private UIHelperMyCards ui;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_my_cards, container, false);
        init();
        setEvents();

        return view;
    }

    private void setEvents() {
    }

    private void init() {
        ui = new UIHelperMyCards(view);
        ((DrawerLayoutMain)getActivity()).getSupportActionBar().setTitle(R.string.my_cards_fragment);
    }


}
