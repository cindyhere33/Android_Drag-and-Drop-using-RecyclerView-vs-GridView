package edu.utdallas.draganddropexample;

/**
 * Created by sxk159231 on 2/6/2017.
 */

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<ItemModel> items;
    OnStartDragListener mDragListener;

    public interface OnStartDragListener {
        void onStartDrag(RecyclerView.ViewHolder viewHolder);
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView ivGrid;


        public ViewHolder(View v) {
            super(v);
            ivGrid = (ImageView) v.findViewById(R.id.iv);
        }
    }

    public void add(int position, ItemModel item) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = items.indexOf(item);
        items.remove(position);
        notifyItemRemoved(position);
    }

    public RecyclerAdapter(List<ItemModel> items) {
        this.items = items;
        this.mDragListener = mDragListener;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.griditem, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ItemModel item = items.get(position);
        holder.ivGrid.setImageDrawable(item.getDrawable());

       /* holder.itemView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) ==
                        MotionEvent.ACTION_DOWN) {
                    mDragListener.onStartDrag(holder);
                }
                return false;
            }
        });*/
      /*  holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(ClipData.newPlainText("", ""), shadowBuilder, v, 0);
                Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim);
                v.startAnimation(animation);
                return false;
            }
        });*/
        ;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
/*
    private View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    *//*
                    Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.anim);
                    v.startAnimation(animation);*//*
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
*//*                    if (v.getTag().equals("6") || (v.getTag().equals("7")))
                        gv.smoothScrollToPosition(16);*//*
                    *//*if(v.getTag().equals(gv.getLastVisiblePosition())) gv.smoothScrollToPosition(gv
                            .getLastVisiblePosition() + 1);*//*
                    return true;
                case DragEvent.ACTION_DRAG_LOCATION:
               *//*     int height = v.getMeasuredHeight();
                    int THRESHHOLD = 200, OFFSET = 10;
                    float y = event.getY();
                    if (height - y < THRESHHOLD) {
                        v.smoothScrollByOffset(OFFSET);
                    } else if (height - y > height - THRESHHOLD) {
//                        gv.smoothScrollByOffset(-OFFSET);
                    }*//*
                    return true;
                case DragEvent.ACTION_DROP:
                    Integer oldPos = Integer.parseInt((String) v.getTag());
                    View view = (View) event.getLocalState();
                    Integer newPos = Integer.parseInt((String) view.getTag());
                    // sortItems();
                    moveItems(oldPos, newPos);
                    return true;

                default:
                    return true;
            }
        }
    };


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }


    private void moveItems(int toPosition, int fromPosition) {
        if (fromPosition == toPosition) return;
        if (fromPosition < toPosition) {
            items.get(fromPosition).setOrder(String.valueOf(toPosition));
            for (int i = fromPosition + 1; i <= toPosition; i++) {
                (items.get(i)).setOrder(String.valueOf(i - 1));
            }
        } else {
            items.get(fromPosition).setOrder(String.valueOf(toPosition));
            for (int i = fromPosition - 1; i >= toPosition; i--) {
                items.get(i).setOrder(String.valueOf(i + 1));
            }
        }
        Collections.sort(items);
        notifyDataSetChanged();
    }*/
}
