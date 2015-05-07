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
import br.com.metasix.cabal.entity.Card;
import br.com.metasix.cabal.enums.CardType;

/**
 * Created by renan on 4/30/15.
 */
public class CardAdapter extends ArrayAdapter<Card>  {

    private int resource;

    public CardAdapter(Context context, int resource, List<Card> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        Card item = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resource, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.card.setImageDrawable(
                getContext().getResources().getDrawable(
                        CardType.fromId(item.getCardType()).getResource()));

        holder.title.setText(CardType.fromId(item.getCardType()).getTitle());
        holder.number.setText(item.getNumber());

        setStatus(item, holder);

        notifyDataSetChanged();
        return convertView;
    }

    private void setStatus(Card card, Holder holder) {
        if (Card.ACTIVE == card.getStatus()){
            holder.status.setVisibility(View.VISIBLE);
            holder.status.setText(R.string.card_blocked);
        } else {
            holder.balance.setVisibility(View.VISIBLE);
            holder.balance.setText(card.getBalance());
        }

    }

    class Holder {
        ImageView card;
        TextView title;
        TextView balance;
        TextView status;
        TextView number;

        public Holder(View v){
            card = (ImageView) v.findViewById(R.id.item_my_cards_card_im);
            title = (TextView) v.findViewById(R.id.item_my_cards_title_tv);
            balance = (TextView) v.findViewById(R.id.item_my_cards_balance_tv);
            status = (TextView) v.findViewById(R.id.item_my_cards_status_tv);
            number = (TextView) v.findViewById(R.id.item_my_cards_number_tv);
        }

    }
}
