package net.navidemad.barcodebag.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import net.navidemad.barcodebag.adapters.CardsRecyclerAdapter;
import net.navidemad.barcodebag.databinding.ActivityBagBinding;
import net.navidemad.barcodebag.models.Card;
import net.navidemad.barcodebag.R;

public class BagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBagBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_bag);
//        binding.setLayoutManager(new LinearLayoutManager(this));
//        binding.setAdapter(new CardsRecyclerAdapter(Card.listAll(Card.class)));
    }

//    static final int PICK_CARD_REQUEST = 1;

//    final Card card = ((CardsAdapter)parent.getAdapter()).getItem(position);
//    Intent intent = new Intent(view.getContext(), AddBagActivity.class);
//    intent.putExtra(AddBagActivity.IDENTIFIER, card.getId());
//    startActivityForResult(intent, PICK_CARD_REQUEST);

//    Intent intent = new Intent(v.getContext(), AddBagActivity.class);
//    startActivityForResult(intent, PICK_CARD_REQUEST);

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == PICK_CARD_REQUEST) {
//            if (resultCode == RESULT_OK) {
//                cardsAdapter.clear();
//                cardsAdapter.addAll(Card.listAll(Card.class));
//                cardsAdapter.notifyDataSetChanged();
//                updateCounter();
//            }
//        }
//    }

}
