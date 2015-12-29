package com.alleyz.layout.customWidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alleyz.layout.R;

/**
 * Created by Mr on 2015/12/22.
 */
public class MyView extends TextView {

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray tas=context.obtainStyledAttributes(attrs, R.styleable.MyView);
        int color=tas.getColor(R.styleable.MyView_mv_color, 0xfff);
        String text="[自定义的文字]";
        CharSequence cs=tas.getText(R.styleable.MyView_mv_text);
        if(cs!=null)
            text=cs.toString()+text;
        setText(text);
        setBackgroundColor(color);
        tas.recycle();//必须
    }
}
