package com.example.serap.multilevelexpandablelistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.serap.multilevelexpandablelistview.MultiLevelExpandableListActivity;
import com.example.serap.multilevelexpandablelistview.R;

/**
 * Created by serap on 14.11.2015.
 */
public class SecondLevelAdapter extends BaseExpandableListAdapter {

  MultiLevelExpandableListActivity activity;

  public SecondLevelAdapter(MultiLevelExpandableListActivity activity) {
    this.activity = activity;
  }

  @Override
  public int getGroupCount() {
    return 1;
  }

  @Override
  public int getChildrenCount(int groupPosition) {
    return 5;
  }

  @Override
  public Object getGroup(int groupPosition) {
    return groupPosition;
  }

  @Override
  public Object getChild(int groupPosition, int childPosition) {
    return childPosition;
  }

  @Override
  public long getGroupId(int groupPosition) {
    return groupPosition;
  }

  @Override
  public long getChildId(int groupPosition, int childPosition) {
    return childPosition;
  }

  @Override
  public boolean hasStableIds() {
    return true;
  }

  @Override
  public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
      ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      LayoutInflater inflater =
          (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.multi_level_expandable_list_view_item, parent, false);
      viewHolder = new ViewHolder(convertView);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }
    showLevel2TextView(viewHolder, parent);

    return convertView;
  }

  private void showLevel2TextView(ViewHolder viewHolder, ViewGroup parent) {
    LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
    params.setMargins(10, 5, 5,5);
    viewHolder.textView.setLayoutParams(params);
    viewHolder.textView.setText("Level 2");
    viewHolder.textView.setBackgroundColor(parent.getResources().getColor(R.color.colorPrimary));
  }

  @Override
  public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
      View convertView, ViewGroup parent) {
    ViewHolder viewHolder;
    if (convertView == null) {
      LayoutInflater inflater =
          (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.multi_level_expandable_list_view_item, parent, false);
      viewHolder = new ViewHolder(convertView);
      convertView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) convertView.getTag();
    }
    setLevel3TextView(viewHolder, parent);

    return convertView;
  }

  private void setLevel3TextView(ViewHolder viewHolder, ViewGroup parent) {
    LinearLayout.LayoutParams params =
        new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);
    params.setMargins(20, 5, 5, 5);
    viewHolder.textView.setLayoutParams(params);
    viewHolder.textView.setText("Level 3");
    viewHolder.textView.setBackgroundColor(
        parent.getResources().getColor(R.color.colorYellow));
  }

  @Override
  public boolean isChildSelectable(int groupPosition, int childPosition) {
    return true;
  }

  static class ViewHolder {

    @Bind(R.id.tv_title) TextView textView;

    public ViewHolder(View view) {
      ButterKnife.bind(this, view);
    }
  }
}
