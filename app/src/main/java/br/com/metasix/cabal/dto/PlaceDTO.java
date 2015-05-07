package br.com.metasix.cabal.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan on 5/6/15.
 */
public class PlaceDTO {
    private long id;
    private String address;
    private double latitude;
    private double longitude;
    private long idProduct;

    public static List<PlaceDTO> getFakeList(){
        List<PlaceDTO> l = new ArrayList<PlaceDTO>();


        return l;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }
}
