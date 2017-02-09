package edu.utdallas.draganddropexample;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by sxk159231 on 6/8/2016.
 */
public class GridAdapter extends BaseAdapter {

    private Context context;
    private List<ItemModel> items;
    private LayoutInflater inflater;
    private final String TAG = "GridAdapter";

    GridAdapter(List<ItemModel> objects, Context context) {
        this.context = context;
        this.items = objects;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View v = inflater.inflate(R.layout.griditem, parent, false);
        final ImageView iv = (ImageView) v.findViewById(R.id.iv);
        iv.setImageDrawable(items.get(position).getDrawable());
        iv.setTag(position);
        iv.setOnDragListener(dragListener);
        iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(ClipData.newPlainText("", ""), shadowBuilder, v, 0);
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim);
                v.startAnimation(animation);
                ((ImageView) v).setColorFilter(Color.RED, PorterDuff.Mode.OVERLAY);
                return false;
            }
        });
        return v;
    }


    View.OnDragListener dragListener2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            // Log.d(TAG, "Drag event triggered for " + v.getTag());
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d(TAG, "Tag : " + v.getTag() + ": Entered action drag");
                    ((ImageView) v).setColorFilter(Color.BLUE, PorterDuff.Mode.OVERLAY);
                    Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim);
                    v.startAnimation(animation);
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d(TAG, "Tag : " + v.getTag() + ": Exited action drag");
                    ((ImageView) v).clearColorFilter();
                    return true;
                case DragEvent.ACTION_DROP:
                    Log.d(TAG, "Dropping at " + v.getTag());
                    View view = (View) event.getLocalState();
                    Integer tagtemp = (Integer) v.getTag();
                    v.setTag(view.getTag());
                    view.setTag(tagtemp);
                    ((ImageView) v).clearColorFilter();
                    ((ImageView) view).clearColorFilter();
                    ((ImageView) v).setImageDrawable((Drawable) getItem((Integer) v.getTag()));
                    ((ImageView) view).setImageDrawable((Drawable) getItem((Integer) view.getTag()));
                    return true;

                default:
                    return true;
            }
        }
    };


    private View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch(event.getAction()){
                case DragEvent.ACTION_DRAG_STARTED: return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d(TAG, "Tag : " + v.getTag() + ": Entered action drag");
                    ((ImageView) v).setColorFilter(Color.BLUE, PorterDuff.Mode.OVERLAY);
                    Animation animation = AnimationUtils.loadAnimation(context, R.anim.anim);
                    v.startAnimation(animation);
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d(TAG, "Tag : " + v.getTag() + ": Exited action drag");
                    ((ImageView) v).clearColorFilter();
                    return true;
                case DragEvent.ACTION_DROP:
                    Log.d(TAG, "Dropping at " + v.getTag());
                    View view = (View) event.getLocalState();
                    Integer toPosition = (Integer)v.getTag();
                    Integer fromPosition = (Integer) view.getTag();
                    ((ImageView) v).clearColorFilter();
                    ((ImageView) view).clearColorFilter();
                    moveItems(fromPosition, toPosition);
                    return true;
            }
            return false;
        }
    };


    private void moveItems(int fromPosition, int toPosition){
        if(fromPosition == toPosition) return;
        if(fromPosition<toPosition){
            items.get(fromPosition).setTag(toPosition);
            for(int i=fromPosition+1; i<toPosition; i++){
                (items.get(i)).setTag(i-1);
            }
        }
        else {
            items.get(fromPosition).setTag(toPosition);
            for(int i = fromPosition-1;i>=toPosition;i--){
                items.get(i).setTag(i+1);
            }
        }
        Collections.sort(items);
        notifyDataSetChanged();
    }

}




