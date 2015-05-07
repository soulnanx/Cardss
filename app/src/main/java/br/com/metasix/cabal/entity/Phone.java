package br.com.metasix.cabal.entity;

/**
 * Created by renan on 5/6/15.
 */
public class Phone {
    private long id;
    private String title;
    private String number;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
