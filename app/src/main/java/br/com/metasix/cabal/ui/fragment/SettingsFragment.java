package br.com.metasix.cabal.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.metasix.cabal.R;
import br.com.metasix.cabal.ui.helper.UIHelperPlaces;
import br.com.metasix.cabal.ui.helper.UIHelperSettings;

/**
 * Created by renan on 5/4/15.
 */
public class SettingsFragment extends Fragment {

    public static final int NAME_ITEM = R.string.settings_fragment;
    public static final int ICON_ITEM = R.drawable.ic_settings_menu;

    private View view;
    private UIHelperSettings ui;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_settings, container, false);
        init();
        setEvents();
        return view;
    }

    private void setEvents() {
    }

    private void init() {
        ui = new UIHelperSettings(view);

    }
}
