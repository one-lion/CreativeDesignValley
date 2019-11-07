package com.lwz.ctb.creativedesignvalley.Util;

import android.content.Context;

/**
 * Created by 林伟洲-软件工程 on 2019/11/1.
 * decribe: 用于搜索栏的工具
 */

public class ScreenUtil {
    // dp转为px
    public static int dp2px(Context context, float dpValue) {
        if (null == context) {
            return 0;
        }
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    // 获取屏幕的宽度
    public static int getScreenWidth(Context context) {
        if (null == context) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
