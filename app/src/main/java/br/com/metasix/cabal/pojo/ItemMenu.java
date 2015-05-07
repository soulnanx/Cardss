package br.com.metasix.cabal.pojo;

import java.util.ArrayList;
import java.util.List;

import br.com.metasix.cabal.R;
import br.com.metasix.cabal.ui.fragment.MyCardsFragment;
import br.com.metasix.cabal.ui.fragment.NewPlaceFragment;
import br.com.metasix.cabal.ui.fragment.PhonesFragment;
import br.com.metasix.cabal.ui.fragment.PlacesFragment;
import br.com.metasix.cabal.ui.fragment.SettingsFragment;

public class ItemMenu {

    private String fragmentName;
    private int label;
    private int icon;

    private ItemMenu(Class fragment) {
        this.fragmentName =  fragment.getName();
        try {
            this.label = fragment.getDeclaredField("NAME_ITEM").getInt(Integer.class);
            this.icon = fragment.getDeclaredField("ICON_ITEM").getInt(Integer.class);
        } catch (Exception e) {
            this.label = R.string.default_item_menu;
            this.icon = android.R.drawable.ic_media_play;
        }
    }

    public static ArrayList<ItemMenu> getItemsMenu(){
        ArrayList<ItemMenu> list = new ArrayList<ItemMenu>();
        list.add(new ItemMenu(MyCardsFragment.class));
        list.add(new ItemMenu(PlacesFragment.class));
        list.add(new ItemMenu(NewPlaceFragment.class));
        list.add(new ItemMenu(PhonesFragment.class));
        list.add(new ItemMenu(SettingsFragment.class));

        return list;
    }

    public String getFragmentName() {
        return fragmentName;
    }

    public int getLabel() {
        return label;
    }

    public int getIcon() {
        return icon;
    }

}