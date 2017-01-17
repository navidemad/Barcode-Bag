package net.navidemad.barcodebag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class BagActivity extends AppCompatActivity {

    static final String TAG = BagActivity.class.getSimpleName();

    static final int PICK_CARD_REQUEST = 1;

    ArrayAdapter<Card> cardsAdapter;
    Button infoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);
        setupView();
    }

    private void setupView() {
        setupListview();
        setupAddButton();
        setupCounter();
    }

    private void setupListview() {
        this.cardsAdapter = new CardsAdapter(this, Card.listAll(Card.class));
        final ListView listview = (ListView) findViewById(R.id.listview_bag_cards);
        if (listview != null) {
            listview.setAdapter(cardsAdapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    final Card card = ((CardsAdapter)parent.getAdapter()).getItem(position);
                    Intent intent = new Intent(view.getContext(), AddBagActivity.class);
                    intent.putExtra(AddBagActivity.IDENTIFIER, card.getId());
                    startActivityForResult(intent, PICK_CARD_REQUEST);
                }
            });
        }
    }

    private void setupCounter() {
        this.infoBtn = (Button) findViewById(R.id.btn_my_bag);
        updateCounter();
    }

    private void updateCounter() {
        if (this.infoBtn != null) {
            this.infoBtn.setText(getString(R.string.my_bag, Card.count(Card.class)));
        }
    }

    private void setupAddButton() {
        final Button addBtn = (Button) findViewById(R.id.btn_add_a_card);
        if (addBtn != null) {
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick");
                    Intent intent = new Intent(v.getContext(), AddBagActivity.class);
                    startActivityForResult(intent, PICK_CARD_REQUEST);
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CARD_REQUEST) {
            if (resultCode == RESULT_OK) {
                Log.d(TAG, "onActivityResult");
                cardsAdapter.clear();
                cardsAdapter.addAll(Card.listAll(Card.class));
                cardsAdapter.notifyDataSetChanged();
                updateCounter();
            }
        }
    }
}
