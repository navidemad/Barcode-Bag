package net.navidemad.barcodebag.models;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.orm.SugarRecord;

public class Card extends SugarRecord {

    public Record record;

    public Card(String title, int drawable, String data) {
        record = new Record(title, drawable, data);
    }

    public class Record extends BaseObservable {

        public final ObservableField<String> title = new ObservableField<>();
        public final ObservableField<Integer> drawable = new ObservableField<>();
        public final ObservableField<String> data = new ObservableField<>();

        public Record(String title, int drawable, String data) {
            this.title.set(title);
            this.drawable.set(drawable);
            this.data.set(data);
        }

    }

}

