package edu.utdallas.draganddropexample;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sxk159231 on 2/9/2017.
 */

public class RecyclerViewActivity extends Activity {


    RecyclerView rvhome;
    RecyclerAdapter adapter;
    ItemTouchHelper itemTouchHelper;
    List<ItemModel> items;

    private final String TAG = getClass().getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        rvhome = (RecyclerView) findViewById(R.id.rvHome);

        Resources res = getResources();
        items = Arrays.asList(new ItemModel(res.getDrawable(R.drawable.a), 0),
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


        //RecyclerViewDragManager dragDropManager = new RecyclerViewDragManager();
        rvhome.setHasFixedSize(false);
        GridLayoutManager mLayoutManager;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mLayoutManager = new GridLayoutManager(this, 5);
        } else
            mLayoutManager = new GridLayoutManager(this, 3);

        rvhome.setLayoutManager(mLayoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(items);
        // RecyclerView.Adapter wrappedAdapter = dragDropManager.createWrappedAdapter(adapter);
        rvhome.setAdapter(adapter);
        // disable change animations
        ((SimpleItemAnimator) rvhome.getItemAnimator()).setSupportsChangeAnimations(false);

        // [OPTIONAL]
        // dragDropManager.setInitiateOnTouch(true);
        // dragDropManager.setInitiateOnLongPress(true);
        // dragDropManager.setInitiateOnMove(true);

        // dragDropManager.attachRecyclerView(rvhome);




















  /*      adapter = new RecyclerAdapter(items);
/*        itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(rvhome);
        rvhome.setAdapter(new RecyclerAdapter(items));*/
    }


/*

    ItemTouchHelper.Callback itemTouchHelperCallback = new ItemTouchHelper.Callback() {
        @TargetApi(Build.VERSION_CODES.M)


        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            Log.i(TAG, "OnMove : viewHolder:" + viewHolder.getAdapterPosition() + "; target: " + target.getAdapterPosition());
            viewHolder.itemView.setMinimumHeight(130);
            viewHolder.itemView.setMinimumWidth(130);

            viewHolder.itemView.setElevation(30);
            return true;
        }

        @Override
        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int fromPos, RecyclerView.ViewHolder target, int toPos, int x, int y) {
            super.onMoved(recyclerView, viewHolder, fromPos, target, toPos, x, y);
            Collections.swap(items, viewHolder.getAdapterPosition(), target.getAdapterPosition());
            adapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
            Log.i(TAG, "OnMoved : viewHolder:" + viewHolder.getAdapterPosition() + "; target: " + target.getAdapterPosition() + "; toPos: " + toPos + " ; x = " + x + "; y = " + y);
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            //TODO
        }

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.UP | ItemTouchHelper.DOWN);
        }

        @Override
        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder current, RecyclerView.ViewHolder target) {
            return true;
        }

        @Override
        public boolean isLongPressDragEnabled() {
            return true;
        }

        @Override
        public boolean isItemViewSwipeEnabled() {
            return false;
        }

        @Override
        public long getAnimationDuration(RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
            Log.i(TAG, "getAnimationDuration; animationType" + animationType + "; animateDx = " + animateDx + "; animateDy = " + animateDy);
            return super.getAnimationDuration(recyclerView, animationType, animateDx, animateDy);
        }

*/
/*        @Override
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            super.onSelectedChanged(viewHolder, actionState);
        }

        @Override
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(RecyclerViewActivity.this);
            SharedPreferences.Editor editor = sharedPrefs.edit();
            super.clearView(recyclerView, viewHolder);
        }*//*

    };
*/



}
