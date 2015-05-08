package br.com.metasix.cabal.ui.helper;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;

import br.com.metasix.cabal.R;

/**
 * Created by renan on 5/4/15.
 */
public class UIHelperPlaces {

    public Spinner spinner;
    public GoogleMap map;
    public View myLocation;
    public View progress;
    public TextView editSearch;

    public UIHelperPlaces(View view) {
        this.spinner = (Spinner) view.findViewById(R.id.spinner);
        this.myLocation = view.findViewById(R.id.places_my_location);
        this.progress = view.findViewById(R.id.places_progress);
        this.editSearch = (TextView) view.findViewById(R.id.places_edit_search);
    }
}
