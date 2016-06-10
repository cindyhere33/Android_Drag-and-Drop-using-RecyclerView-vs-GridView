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
        List<Drawable> drawables = Arrays.asList(res.getDrawable(R.drawable.a),
                res.getDrawable(R.drawable.b),
                res.getDrawable(R.drawable.c),
                res.getDrawable(R.drawable.d),
                res.getDrawable(R.drawable.e),
                res.getDrawable(R.drawable.f),
                res.getDrawable(R.drawable.h),
                res.getDrawable(R.drawable.i),
                res.getDrawable(R.drawable.j),
                res.getDrawable(R.drawable.k),
                res.getDrawable(R.drawable.l),
                res.getDrawable(R.drawable.m),
                res.getDrawable(R.drawable.t),
                res.getDrawable(R.drawable.u),
                res.getDrawable(R.drawable.n),
                res.getDrawable(R.drawable.o),
                res.getDrawable(R.drawable.p),
                res.getDrawable(R.drawable.q),
                res.getDrawable(R.drawable.r),
                res.getDrawable(R.drawable.s),
                res.getDrawable(R.drawable.v),
                res.getDrawable(R.drawable.a1),
                res.getDrawable(R.drawable.x),
                res.getDrawable(R.drawable.y),
                res.getDrawable(R.drawable.z),
                res.getDrawable(R.drawable.a1),
                res.getDrawable(R.drawable.a2),
                res.getDrawable(R.drawable.a3),
                res.getDrawable(R.drawable.a4),
                res.getDrawable(R.drawable.a5),
                res.getDrawable(R.drawable.a6));
        gv.setAdapter(new GridAdapter(drawables, this));
    }
}
