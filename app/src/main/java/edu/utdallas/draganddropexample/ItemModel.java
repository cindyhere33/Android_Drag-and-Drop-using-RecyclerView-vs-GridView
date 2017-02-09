package edu.utdallas.draganddropexample;

import android.graphics.drawable.Drawable;

import java.util.Comparator;

/**
 * Created by sxk159231 on 2/6/2017.
 */

public class ItemModel implements Comparable<ItemModel> {

    Drawable drawable;
    int tag;

    ItemModel(Drawable drawable, int tag){
        this.drawable = drawable;
        this.tag = tag;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public int getTag() {
        return tag;
    }


    public int compare(ItemModel lhs, ItemModel rhs) {
        if(lhs.getTag()<rhs.getTag()) return 1;
        else if(lhs.getTag() == rhs.getTag()) return 0;
        else return -1;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public int compareTo(ItemModel another) {
        if(getTag()<another.getTag()) return -1;
        else if(getTag() == another.getTag()) return 0;
        else return 1;
    }
}
