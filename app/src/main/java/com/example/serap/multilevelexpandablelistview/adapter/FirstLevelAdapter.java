package com.example.serap.multilevelexpandablelistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.serap.multilevelexpandablelistview.CustomExpandableListView;
import com.example.serap.multilevelexpandablelistview.MultiLevelExpandableListActivity;
import com.example.serap.multilevelexpandablelistview.R;

/**
 * Created by serap on 14.11.2015.
 */
public class FirstLevelAdapter extends BaseExpandableListAdapter {

  MultiLevelExpandableListActivity activity;

  public FirstLevelAdapter(MultiLevelExpandableListActivity activity) {
    this.activity = activity;
  }


  @Override
  public int getGroupCount() {
    return 35;
  }

  @Override
  public int getChildrenCount(int groupPosition) {
    return 3;
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

    viewHolder.textView.setText("Level 1");
    viewHolder.textView.setBackgroundColor(parent.getResources().getColor(R.color.colorAccent));

    return convertView;


  }

  @Override
  public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
      View convertView, ViewGroup parent) {


    CustomExpandableListView level2ExpandableListView;
    level2ExpandableListView = new CustomExpandableListView(activity);

    level2ExpandableListView.setAdapter(new SecondLevelAdapter(activity));

    level2ExpandableListView.setGroupIndicator(null);

    return level2ExpandableListView;
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



























