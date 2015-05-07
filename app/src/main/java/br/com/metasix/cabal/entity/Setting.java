package br.com.metasix.cabal.entity;

/**
 * Created by renan on 5/6/15.
 */
public class Setting {
    private boolean pushNotification;

    public boolean isPushNotification() {
        return pushNotification;
    }

    public void setPushNotification(boolean pushNotification) {
        this.pushNotification = pushNotification;
    }
}
