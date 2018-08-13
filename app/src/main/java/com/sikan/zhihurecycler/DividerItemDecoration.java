package com.sikan.zhihurecycler;

import android.content.Context;

import com.yanyusong.y_divideritemdecoration.Y_Divider;
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder;
import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration;

/**
 * Created by Administrator
 *
 * @time 2018/8/13
 */

public class DividerItemDecoration extends Y_DividerItemDecoration {

    public DividerItemDecoration(Context context) {
        super(context);
    }

    @Override
    public Y_Divider getDivider(int itemPosition) {
        Y_Divider divider = null;

        if(itemPosition!=0&&itemPosition%5==0){
            divider = new Y_DividerBuilder()
                    .setBottomSideLine(true, 0xfff5f5f5, 0, 0, 0)
                    .create();
        }else if((itemPosition+1)%5==0){
            divider = new Y_DividerBuilder()
                    .setBottomSideLine(true, 0xfff5f5f5, 0, 0, 0)
                    .create();
        }else{
            divider = new Y_DividerBuilder()
                    .setBottomSideLine(true, 0xfff5f5f5, 10, 0, 0)
                    .create();
        }
        return divider;
    }
}