package net.navidemad.barcodebag.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.navidemad.barcodebag.BR;
import net.navidemad.barcodebag.databinding.ActivityAddBagBinding;
import net.navidemad.barcodebag.models.Card;
import net.navidemad.barcodebag.R;

public class AddBagActivity extends AppCompatActivity {

    static final String IDENTIFIER = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        readIntent();
    }

    private void readIntent() {
//        final Intent intent = getIntent();
//        if (intent != null) {
//            long id = intent.getLongExtra(IDENTIFIER, -1);
//            if (id != -1) {
//                ActivityAddBagBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_add_bag);
//                Card card = Card.findById(Card.class, id);
//                binding.setVariable(BR.card, card);
//            }
//        }
    }

//    private void setupSaveButton() {
//        final Button saveBtn = (Button) findViewById(R.id.btn_save);
//        if (saveBtn != null) {
//            if (this.title != null) {
//                final AddBagActivity self = this;
//                saveBtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if (self.card == null) {
//                            self.card = new Card();
//                        }
//                        self.card.title = self.title.getText().toString().trim();
//                        self.card.save();
//                        self.end();
//                    }
//                });
//            }
//        }
//    }
//

//            if (this.card != null) {
//                final AddBagActivity self = this;
//                deleteBtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        self.card.delete();
//                        self.end();
//                    }
//                });
//            } else {
//                deleteBtn.setVisibility(View.GONE);
//            }

//    private void end() {
//        Intent intent = new Intent();
//        setResult(RESULT_OK, intent);
//        finish();
//    }

}
