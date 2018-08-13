package com.sikan.zhihurecycler;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator
 *
 * @time 2018/8/13
 */

public class SpaceItemDecoration extends DividerItemDecoration {
    int mSpace;
    int position;

    private Context context;
    public SpaceItemDecoration(Context context, int orientation, int space, Drawable drawable, int postion) {
        super(context, orientation);
        super.setDrawable(drawable);
        this.context=context;
        this.mSpace = space;
        this.position = postion;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int pos = parent.getChildAdapterPosition(view);

        Log.i("getItemOffsets", "parent.getChildAdapterPosition(view):" + parent.getChildAdapterPosition(view)+"  "+(pos % position == 0));
        if (pos != 0 && pos % position == 0) {
            outRect.bottom = 0;
        }else if ((pos + 1) % position == 0) {
            outRect.bottom = 0;
        } else {
            outRect.bottom = mSpace;
        }
    }

}
