package com.lwz.ctb.creativedesignvalley.Widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 可设置是否能滑动的ViewPager
 * Created by 林伟洲-软件工程 on 2019/11/7.
 */

public class ControlScrollViewPager extends ViewPager {

    private boolean isCanScroll = true;

    public ControlScrollViewPager(Context context) {
        super(context);
    }

    public ControlScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public void setScanScroll(boolean isCanScroll){

        this.isCanScroll = isCanScroll;

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return  false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }
}
