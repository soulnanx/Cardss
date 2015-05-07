package br.com.metasix.cabal.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.metasix.cabal.R;
import br.com.metasix.cabal.ui.helper.UIHelperNews;
import br.com.metasix.cabal.ui.helper.UIHelperSettings;

/**
 * Created by renan on 5/4/15.
 */
public class NewsFragment extends Fragment {

    public static final int NAME_ITEM = R.string.news_fragment;
    public static final int ICON_ITEM = android.R.drawable.ic_menu_myplaces;

    private View view;
    private UIHelperNews ui;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_news, container, false);
        init();
        setEvents();
        return view;
    }

    private void setEvents() {
    }

    private void init() {
        ui = new UIHelperNews(view);

    }
}
