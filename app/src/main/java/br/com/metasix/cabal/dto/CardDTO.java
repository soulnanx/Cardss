package br.com.metasix.cabal.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renan on 5/7/15.
 */
public class CardDTO {

    private String token;
    private int status;
    private String balance;

    public CardDTO(String token, int status, String balance) {
        this.token = token;
        this.status = status;
        this.balance = balance;
    }

    public static List<CardDTO> getFakeList(){
        List<CardDTO> l = new ArrayList<CardDTO>();

        l.add(new CardDTO("A3215dds", 1, "R$ 250,00"));
        l.add(new CardDTO("A32lKKKs", 2, "R$ 880,00"));
        l.add(new CardDTO("BB215dds", 1, "R$ 5,00"));

        return l;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
