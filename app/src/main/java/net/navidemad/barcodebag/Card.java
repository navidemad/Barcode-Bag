package net.navidemad.barcodebag;

import com.orm.SugarRecord;

public class Card extends SugarRecord {

    String title;
    int drawable;
    String data;

    public Card() {

    }

    public Card(String title, int drawable, String data) {
        this.title = title;
        this.drawable = drawable;
        this.data = data;
    }

}
