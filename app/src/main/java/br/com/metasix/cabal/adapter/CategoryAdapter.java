package br.com.metasix.cabal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.metasix.cabal.R;
import br.com.metasix.cabal.entity.Category;
import br.com.metasix.cabal.pojo.ItemMenu;

/**
 * Created by renan on 4/30/15.
 */
public class CategoryAdapter extends ArrayAdapter<Category>  {

    private int resource;

    public CategoryAdapter(Context context, int resource, List<Category> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent){
        Holder holder;
        Category item = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resource, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.icon.setImageDrawable(getContext().getResources().getDrawable(item.getResource()));
        holder.label.setText(item.getTitle());

        return convertView;
    }

    class Holder {
        ImageView icon;
        TextView label;

        public Holder(View v){
            icon = (ImageView) v.findViewById(R.id.item_img);
            label = (TextView) v.findViewById(R.id.item_txt_name);
        }

    }
}
