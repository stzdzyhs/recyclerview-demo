package com.devbeacon.rvdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * this class enables RecyclerView to set a Empty Label like ListView.setEmptyView(),
 * but in a more resource save way.
 * Free to use and hope it's useful
 *
 * devbeacon, 2909820123@qq.com
 */
public class RecyclerViewEmpty extends RecyclerView {

    public RecyclerViewEmpty(@NonNull Context context) {
        super(context);
        createLabelPaint();
    }

    public RecyclerViewEmpty(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, R.attr.recyclerViewStyle);
        createLabelPaint();
    }

    public RecyclerViewEmpty(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createLabelPaint();
    }

    /**
     * the empty label
     */
    String emptyLabel;

    /**
     * the paint
     */
    protected Paint labelPaint;
    int strWidth=0;


    /**
     * set empty label
     * @param s
     */
    public void setEmptyLabel(String s) {
        this.emptyLabel = s;
        strWidth = (int)this.labelPaint.measureText(this.emptyLabel);
    }

    /**
     * set empty label by res id
     * @param resStr
     */
    public void setEmptyLabel(int resStr) {
        String s = this.getContext().getString(resStr);
        setEmptyLabel(s);
    }

    public String getEmptyLabel() {
        return emptyLabel;
    }

    protected void createLabelPaint() {
        labelPaint = new Paint();
        labelPaint.setColor(Color.GRAY);
        labelPaint.setStyle(Paint.Style.FILL);

        int ts = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                20, getResources().getDisplayMetrics());
        labelPaint.setTextSize(ts);
    }


    @Override
    public void onDraw(Canvas canvas) {
        Adapter a = this.getAdapter();
        if(a==null || a.getItemCount()<1) {
            int x= (this.getWidth()-strWidth)>>1;
            int y = this.getHeight()>>1 ;
            canvas.drawText(this.emptyLabel, x, y, labelPaint);
        }
        else {
            super.onDraw(canvas);
        }
    }

}
