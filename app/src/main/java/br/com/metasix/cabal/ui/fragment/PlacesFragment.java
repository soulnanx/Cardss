package br.com.metasix.cabal.ui.fragment;

import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import br.com.metasix.cabal.R;
import br.com.metasix.cabal.adapter.CategoryAdapter;
import br.com.metasix.cabal.app.App;
import br.com.metasix.cabal.callback.Callback;
import br.com.metasix.cabal.entity.Category;
import br.com.metasix.cabal.enums.StatusEnum;
import br.com.metasix.cabal.task.SearchAddressAsyncTask;
import br.com.metasix.cabal.ui.helper.UIHelperPlaces;
import br.com.metasix.cabal.util.DistanceUtil;
import br.com.metasix.cabal.util.KeyboardUtil;

/**
 * Created by renan on 5/4/15.
 */
public class PlacesFragment extends Fragment {

    private static final float ZOOM_DEFAULT = 15.0f;
    private static final double DISTANCE_UPDATE = 1000;
    private static final int MAX_RESULT_TEXT = 1;

    public static final int NAME_ITEM = R.string.places_fragment;
    public static final int ICON_ITEM = R.drawable.ic_places_menu;

    private View view;
    private UIHelperPlaces ui;
    private SupportMapFragment mMapaFragment;
    private App app;
    private LatLng lastUpdate;
    private LatLng currentPosition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_places, container, false);
        init();
        setEvents();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ui.map = mMapaFragment.getMap();
        ui.map.setMyLocationEnabled(true);
        ui.map.getUiSettings().setZoomControlsEnabled(false);
        ui.map.setOnMyLocationChangeListener(onMyLocationChangeListener());
        ui.map.setOnCameraChangeListener(onCameraChangeListener());
    }

    private void setEvents() {
    }

    private void init() {
        app = (App) getActivity().getApplication();
        mMapaFragment = SupportMapFragment.newInstance();
        getChildFragmentManager().beginTransaction().add(R.id.places_map, mMapaFragment).commit();
        ui = new UIHelperPlaces(view);
        ui.myLocation.setOnClickListener(onMyLocationClickListener());
        ui.editSearch.setOnEditorActionListener(onEditorActionListener());
        loadValues();
    }

    private void checkLocation(StatusEnum status){
        if(status == StatusEnum.INICIO){
            statusInicioByText();
        }else if(status == StatusEnum.EXECUTANDO){
            statusExecutando();
        }else if(status == StatusEnum.EXECUTADO){
            statusExecutado();
        }
    }

    private void statusInicioByText() {
        if(app.isInternetConnection(getActivity())){
            SearchAddressAsyncTask searchAddressAsyncTask = new SearchAddressAsyncTask(getActivity(), ui.editSearch.getText().toString(),
                    onSearchAddressCallback(), MAX_RESULT_TEXT);
            searchAddressAsyncTask.execute();
            app.registerTask(searchAddressAsyncTask);
            checkLocation(StatusEnum.EXECUTANDO);
        }else{
            checkLocation(StatusEnum.EXECUTADO);
        }
    }

    private void statusExecutando() {
        ui.progress.setVisibility(View.VISIBLE);
    }

    private void statusExecutado() {
        ui.progress.setVisibility(View.GONE);
    }

    private void loadValues() {
        ui.spinner.setAdapter(new CategoryAdapter(PlacesFragment.this.getActivity(), R.layout.item_category_spinner, Category.getFakeList()));
    }

    private GoogleMap.OnMyLocationChangeListener onMyLocationChangeListener() {
        return new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                LatLng current = new LatLng(location.getLatitude(), location.getLongitude());
                if(currentPosition == null){
                    updateMapPosition(current, ZOOM_DEFAULT);
                    currentPosition = current;
                }
            }
        };
    }

    private GoogleMap.OnCameraChangeListener onCameraChangeListener() {
        return new GoogleMap.OnCameraChangeListener() {
            @Override
            public void onCameraChange(CameraPosition cameraPosition) {
                LatLng current = cameraPosition.target;
                if(lastUpdate == null){
                    lastUpdate = current;
                    //TODO Buscar Locais
                }else{
                    double distance = DistanceUtil.calcDistanceBetweenTwoPointsInMeters(lastUpdate, current);
                    if(distance > DISTANCE_UPDATE){
                        lastUpdate = current;
                        //TODO Buscar Locais
                    }
                }
            }
        };
    }

    private View.OnClickListener onMyLocationClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPosition != null){
                    updateMapPosition(currentPosition, ZOOM_DEFAULT);
                }
            }
        };
    }

    private TextView.OnEditorActionListener onEditorActionListener() {
        return new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId){
                    case EditorInfo.IME_ACTION_SEARCH:
                        checkLocation(StatusEnum.INICIO);
                        KeyboardUtil.hideKeyboard(getActivity(), ui.editSearch);
                        return true;
                }
                return false;
            }
        };
    }

    private Callback onSearchAddressCallback() {
        return new Callback() {
            @Override
            public void onReturn(Exception error, Object... objects) {
                if(error == null){
                    List<Address> address = (List<Address>) objects[0];
                    if(!address.isEmpty()){
                        updateMapPosition(new LatLng(address.get(0).getLatitude(),
                                address.get(0).getLongitude()), ZOOM_DEFAULT);
                    }
                    checkLocation(StatusEnum.EXECUTADO);
                }
            }
        };
    }

    private void updateMapPosition(LatLng latLng, float zoom) {
        CameraUpdate center = CameraUpdateFactory.newLatLngZoom(latLng, zoom);
        ui.map.animateCamera(center);
    }
}
