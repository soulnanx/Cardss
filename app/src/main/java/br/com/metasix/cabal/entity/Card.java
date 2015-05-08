package br.com.metasix.cabal.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.metasix.cabal.enums.CardType;

/**
 * Created by renan on 5/6/15.
 */
public class Card {

    private String number;
    private String token;
    private int cardType;

    private int status;
    private String balance;
    private String lastUpdate;

    public static final int ACTIVE = 1;
    public static final int BLOCKED = 2;
    public static final int NEW = 0;

    public Card(String token, String number, int cardType, String lastUpdate) {
        this.number = number;
        this.token = token;
        this.cardType = cardType;
        this.lastUpdate = lastUpdate;
    }

    public Card(String token, String number, int cardType, String lastUpdate, int status) {
        this.number = number;
        this.token = token;
        this.cardType = cardType;
        this.lastUpdate = lastUpdate;
        this.status = status;
    }

    public Card(String token, String lastUpdate, String balance, int status) {
        this.token = token;
        this.lastUpdate = lastUpdate;
        this.balance = balance;
        this.status = status;
    }

    public static List<Card> getFakeListStored(){
        List<Card> l = new ArrayList<>();

        l.add(new Card( "as654", "3214", CardType.REFEICAO.getId(), "25/05/15 14hs00", ACTIVE));
        l.add(new Card("as321", "3255", CardType.ALIMENTACAO.getId(), "25/05/15 14hs00", BLOCKED));
        l.add(new Card("as987","3217", CardType.COMBUSTIVEL.getId(), "25/05/15 14hs00", NEW));

        return l;
    }

    public static List<Card> getFakeListFromService(){
        List<Card> l = new ArrayList<>();

        l.add(new Card("as654", "25/05/15 14hs00", "R$ 250,25", ACTIVE));
        l.add(new Card("as321", "25/05/15 14hs00", "R$ 450,25", ACTIVE));
        l.add(new Card("as987", "25/05/15 14hs00", "R$ 70,25", BLOCKED));

        return l;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        return token.equals(card.token);

    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }
}
