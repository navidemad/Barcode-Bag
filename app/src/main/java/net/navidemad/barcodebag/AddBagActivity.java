package net.navidemad.barcodebag;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBagActivity extends AppCompatActivity {

    static final String TAG = AddBagActivity.class.getSimpleName();

    static final String IDENTIFIER = "id";

    private Card card = null;

    private EditText title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bag);
        readIntent();
        setupView();
    }

    private void readIntent() {
        Log.d(TAG, "readIntent");
        final Intent intent = getIntent();
        if (intent != null) {
            Log.d(TAG, "intent is present");
            long id = intent.getLongExtra(IDENTIFIER, -1);
            if (id != -1) {
                Log.d(TAG, "IDENTIFIER " + IDENTIFIER + " is present and is " + id);
                this.card = Card.findById(Card.class, id);
            }
        }
    }

    private void setupView() {
        setupForm();
        setupSaveButton();
        setupDeleteButton();
    }

    private void setupForm() {
        this.title = (EditText) findViewById(R.id.edittext_title);
        fillFormWithCard(this.card);
    }

    private void fillFormWithCard(@Nullable Card card) {
        if (card != null) {
            if (this.title != null) {
                this.title.setText(card.title);
            }
        }
    }

    private void setupSaveButton() {
        final Button saveBtn = (Button) findViewById(R.id.btn_save);
        if (saveBtn != null) {
            if (this.title != null) {
                final AddBagActivity self = this;
                saveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (self.card == null) {
                            self.card = new Card();
                        }
                        self.card.title = self.title.getText().toString().trim();
                        self.card.save();
                        self.end();
                    }
                });
            }
        }
    }

    private void setupDeleteButton() {
        final Button deleteBtn = (Button) findViewById(R.id.btn_delete);
        if (deleteBtn != null) {
            if (this.card != null) {
                final AddBagActivity self = this;
                deleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        self.card.delete();
                        self.end();
                    }
                });
            } else {
                deleteBtn.setVisibility(View.GONE);
            }
        }
    }

    private void end() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

}
