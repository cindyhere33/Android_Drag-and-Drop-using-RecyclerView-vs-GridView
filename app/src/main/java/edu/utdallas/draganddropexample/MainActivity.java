package edu.utdallas.draganddropexample;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.GridView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sxk159231 on 6/8/2016.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gv = (GridView) findViewById(R.id.gridView);
        Resources res = getResources();
        List<ItemModel> items = Arrays.asList(new ItemModel(res.getDrawable(R.drawable.a), 0),
                new ItemModel(res.getDrawable(R.drawable.b), 1),
                new ItemModel(res.getDrawable(R.drawable.c), 2),
                new ItemModel(res.getDrawable(R.drawable.d), 3),
                new ItemModel(res.getDrawable(R.drawable.e), 4),
                new ItemModel(res.getDrawable(R.drawable.f), 5),
                new ItemModel(res.getDrawable(R.drawable.h), 6),
                new ItemModel(res.getDrawable(R.drawable.i), 7),
                new ItemModel(res.getDrawable(R.drawable.j), 8),
                new ItemModel(res.getDrawable(R.drawable.k), 9),
                new ItemModel(res.getDrawable(R.drawable.l), 10),
                new ItemModel(res.getDrawable(R.drawable.m), 11),
                new ItemModel(res.getDrawable(R.drawable.n), 12),
                new ItemModel(res.getDrawable(R.drawable.o), 13),
                new ItemModel(res.getDrawable(R.drawable.p), 14),
                new ItemModel(res.getDrawable(R.drawable.q), 15),
                new ItemModel(res.getDrawable(R.drawable.r), 16),
                new ItemModel(res.getDrawable(R.drawable.s), 17),
                new ItemModel(res.getDrawable(R.drawable.t), 18),
                new ItemModel(res.getDrawable(R.drawable.u), 19),
                new ItemModel(res.getDrawable(R.drawable.v), 20),
                new ItemModel(res.getDrawable(R.drawable.x), 21),
                new ItemModel(res.getDrawable(R.drawable.y), 22),
                new ItemModel(res.getDrawable(R.drawable.z), 23),
                new ItemModel(res.getDrawable(R.drawable.a1), 24),
                new ItemModel(res.getDrawable(R.drawable.a2), 25),
                new ItemModel(res.getDrawable(R.drawable.a3), 26),
                new ItemModel(res.getDrawable(R.drawable.a4), 27),
                new ItemModel(res.getDrawable(R.drawable.a5), 28),
                new ItemModel(res.getDrawable(R.drawable.a6), 29));
        gv.setAdapter(new GridAdapter(items, this));
    }
}
