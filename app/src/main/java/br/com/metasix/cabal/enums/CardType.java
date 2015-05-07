package br.com.metasix.cabal.enums;

import br.com.metasix.cabal.R;

/**
 * Created by renan on 5/7/15.
 */
public enum CardType {
    REFEICAO(11, "Cabal Vale Refeição", android.R.drawable.ic_dialog_alert),
    ALIMENTACAO(12, "Cabal Vale Alimentação", android.R.drawable.ic_dialog_alert),
    COMBUSTIVEL(13, "Cabal Combustivel", android.R.drawable.ic_dialog_alert),
    CONTROLE(14, "Cabal Controle", android.R.drawable.ic_dialog_alert),
    PREMIACAO(11, "Cabal Premiação", android.R.drawable.ic_dialog_alert),
    PRESENTE(44, "Cabal Presente", android.R.drawable.ic_dialog_alert);

    private int id;
    private String title;
    private int resource;

    private CardType(int id, String title, int resource) {
        this.id = id;
        this.title = title;
        this.resource = resource;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public int getResource() {
        return resource;
    }

    public static CardType fromId(int id) {
        for ( CardType type : CardType.values() ) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }


}
