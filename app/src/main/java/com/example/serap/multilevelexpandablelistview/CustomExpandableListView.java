package com.example.serap.multilevelexpandablelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

public class CustomExpandableListView extends ExpandableListView {

  public CustomExpandableListView(Context context) {
    super(context);
  }

  public CustomExpandableListView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public CustomExpandableListView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    widthMeasureSpec = MeasureSpec.makeMeasureSpec(960,

        MeasureSpec.AT_MOST);

    heightMeasureSpec = MeasureSpec.makeMeasureSpec(600,

        MeasureSpec.AT_MOST);

    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  }
}
