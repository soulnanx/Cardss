package br.com.metasix.cabal.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.metasix.cabal.R;
import br.com.metasix.cabal.ui.helper.UIHelperPhones;
import br.com.metasix.cabal.ui.helper.UIHelperPlaces;

/**
 * Created by renan on 5/4/15.
 */
public class PhonesFragment extends Fragment {

    public static final int NAME_ITEM = R.string.phones_fragment;
    public static final int ICON_ITEM = R.drawable.ic_phone_menu;

    private View view;
    private UIHelperPhones ui;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_phones, container, false);
        init();
        setEvents();
        return view;
    }

    private void setEvents() {
    }

    private void init() {
        ui = new UIHelperPhones(view);

    }
}
