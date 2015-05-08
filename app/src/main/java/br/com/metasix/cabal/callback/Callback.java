package br.com.metasix.cabal.callback;

/**
 * Created by c31433 on 18/07/2014.
 */
public interface Callback {
    public void onReturn(Exception error, Object... objects);
}