package net.navidemad.barcodebag.adapters;

import android.support.v7.widget.RecyclerView;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.navidemad.barcodebag.R;
import net.navidemad.barcodebag.databinding.ItemCardBinding;
import net.navidemad.barcodebag.models.Card;

import java.util.List;

public class CardsRecyclerAdapter extends RecyclerView.Adapter<CardsRecyclerAdapter.BindingHolder> {

    private List<Card> mCards;

    public CardsRecyclerAdapter(List<Card> recyclerCards) {
        this.mCards = recyclerCards;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new BindingHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.bind(mCards.get(position));
    }

    @Override
    public int getItemCount() {
        return mCards.size();
    }

    public static class BindingHolder extends RecyclerView.ViewHolder {

        private ItemCardBinding binding;

        public BindingHolder(View rowView) {
            super(rowView);
            binding = DataBindingUtil.bind(rowView);
        }

        public void bind(Card card) {
            binding.setCard(card);
        }

    }

}