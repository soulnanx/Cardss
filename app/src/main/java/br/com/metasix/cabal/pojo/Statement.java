package br.com.metasix.cabal.pojo;

/**
 * Created by renan on 5/6/15.
 */
public class Statement {

    private String lastCharge;
    private String nextCharge;
    private String balance;
    private String average;

    public String getLastCharge() {
        return lastCharge;
    }

    public void setLastCharge(String lastCharge) {
        this.lastCharge = lastCharge;
    }

    public String getNextCharge() {
        return nextCharge;
    }

    public void setNextCharge(String nextCharge) {
        this.nextCharge = nextCharge;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }
}
