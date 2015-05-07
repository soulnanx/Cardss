package br.com.metasix.cabal.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import br.com.metasix.cabal.R;
import br.com.metasix.cabal.adapter.CategoryAdapter;
import br.com.metasix.cabal.entity.Category;
import br.com.metasix.cabal.ui.helper.UIHelperMyCards;
import br.com.metasix.cabal.ui.helper.UIHelperPlaces;

/**
 * Created by renan on 5/4/15.
 */
public class PlacesFragment extends Fragment {

    public static final int NAME_ITEM = R.string.places_fragment;
    public static final int ICON_ITEM = android.R.drawable.ic_menu_myplaces;

    private View view;
    private UIHelperPlaces ui;
    private Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_places, container, false);
        init();
        setEvents();
        return view;
    }

    private void setEvents() {
    }

    private void init() {
        ui = new UIHelperPlaces(view);
        spinner = (Spinner) view.findViewById(R.id.spinner);

        spinner.setAdapter(new CategoryAdapter(PlacesFragment.this.getActivity(), R.layout.item_category_spinner, Category.getFakeList()));

    }
}
