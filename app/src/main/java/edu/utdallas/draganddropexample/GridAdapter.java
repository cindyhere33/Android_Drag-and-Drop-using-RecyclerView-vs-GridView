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

import java.util.List;

/**
 * Created by sxk159231 on 6/8/2016.
 */
public class GridAdapter extends BaseAdapter {

    Context context;
    List<Drawable> drawables;
    LayoutInflater inflater;
    private final String TAG = "GridAdapter";

    public GridAdapter(List<Drawable> objects, Context context) {
        this.context = context;
        this.drawables = objects;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return drawables.size();
    }

    @Override
    public Object getItem(int position) {
        return drawables.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View v = inflater.inflate(R.layout.griditem, null);
        final ImageView iv = (ImageView) v.findViewById(R.id.iv);
        iv.setImageDrawable(drawables.get(position));
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


    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            // Log.d(TAG, "Drag event triggered for " + v.getTag());
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                                /*View view = (View)event.getLocalState();
                                GridView owner = (GridView) v.getParent();
                                view.setVisibility(View.INVISIBLE);
                                owner.inflate(context, R.layout.griditem, null);
                                ImageView iv = (ImageView)owner.findViewById(R.id.iv);
                                iv.setTag(view.getTag());
                                iv.setImageDrawable(((ImageView)view).getDrawable());
*/
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



      /*
        iv.setOnLongClickListener(new View.OnLongClickListener() {

            // Defines the one method for the interface, which is called when the View is long-clicked
            public boolean onLongClick(View v) {

                // Create a new ClipData.
                // This is done in two steps to provide clarity. The convenience method
                // ClipData.newPlainText() can create a plain text ClipData in one step.

                // Create a new ClipData.Item from the ImageView object's tag
                ClipData.Item item = new ClipData.Item(v.getTag().toString());

                // Create a new ClipData using the tag as a label, the plain text MIME type, and
                // the already-created item. This will create a new ClipDescription object within the
                // ClipData, and set its MIME type entry to "text/plain"
                ClipData dragData = new ClipData(v.getTag().toString(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);

                // Instantiates the drag shadow builder.
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(iv);

                // Starts the drag

                v.startDrag(dragData,  // the data to be dragged
                        myShadow,  // the drag shadow builder
                        null,      // no need to use local data
                        0          // flags (not currently used, set to 0)
                );
                v.setOnDragListener(new View.OnDragListener() {
                    @Override
                    public boolean onDrag(View vv, DragEvent event) {
                        Log.d(TAG, "Testing on Drag");
                        // Defines a variable to store the action type for the incoming event
                        final int action = event.getAction();
                        ImageView v = (ImageView) vv;
                        Log.d(TAG, "in On Drag");
                        Log.d(TAG, "Event Descriptions : " + event.toString());

                        // Handles each of the expected events
                        switch (action) {

                            case DragEvent.ACTION_DRAG_STARTED:
                                Log.d(TAG, "Event : Action Started drag");

                                // Determines if this View can accept the dragged data
                                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {

                                    // As an example of what your application might do,
                                    // applies a blue color tint to the View to indicate that it can accept
                                    // data.
                                    v.setColorFilter(Color.BLUE);

                                    // Invalidate the view to force a redraw in the new tint
                                    v.invalidate();

                                    // returns true to indicate that the View can accept the dragged data.
                                    return true;

                                }

                                // Returns false. During the current drag and drop operation, this View will
                                // not receive events again until ACTION_DRAG_ENDED is sent.
                                return false;

                            case DragEvent.ACTION_DRAG_ENTERED:
                                Log.d(TAG, "Event : Action drag entered");

                                // Applies a green tint to the View. Return true; the return value is ignored.

                                v.setColorFilter(Color.GREEN);

                                // Invalidate the view to force a redraw in the new tint
                                v.invalidate();

                                return true;

                            case DragEvent.ACTION_DRAG_LOCATION:
                                Log.d(TAG, "Event : Action drag location");
                                // Ignore the event
                                return true;

                            case DragEvent.ACTION_DRAG_EXITED:
                                Log.d(TAG, "Event : Action drag exited");
                                // Re-sets the color tint to blue. Returns true; the return value is ignored.
                                v.setColorFilter(Color.BLUE);

                                // Invalidate the view to force a redraw in the new tint
                                v.invalidate();

                                return true;

                            case DragEvent.ACTION_DROP:
                                Log.d(TAG, "Event : Action drop");
                                // Gets the item containing the dragged data
                                ClipData.Item item = event.getClipData().getItemAt(0);

                                // Gets the text data from the item.
                                CharSequence dragData = item.getText();

                                // Displays a message containing the dragged data.
                                Toast.makeText(context, "Dragged data is " + dragData, Toast.LENGTH_LONG).show();

                                // Turns off any color tints
                                v.clearColorFilter();

                                // Invalidates the view to force a redraw
                                v.invalidate();

                                // Returns true. DragEvent.getResult() will return true.
                                return true;

                            case DragEvent.ACTION_DRAG_ENDED:
                                Log.d(TAG, "Action drag ended");
                                // Turns off any color tinting
                                v.clearColorFilter();

                                // Invalidates the view to force a redraw
                                v.invalidate();

                                // Does a getResult(), and displays what happened.
                                if (event.getResult()) {
                                    Toast.makeText(context, "The drop was handled.", Toast.LENGTH_LONG).show();

                                } else {
                                    Toast.makeText(context, "The drop didn't work.", Toast.LENGTH_LONG).show();

                                }

                                // returns true; the value is ignored.
                                return false;

                            // An unknown action type was received.
                            default:
                                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                                break;
                        }

                        return true;
                    }
                });
                return false;
            }
        });

        return v;
    }
*/
}




