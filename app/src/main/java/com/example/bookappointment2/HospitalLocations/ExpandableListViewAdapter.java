package com.example.bookappointment2.HospitalLocations;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.bookappointment2.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    List<String>listDataGroup;
    HashMap<String,List<String>>listDataChild;

    public ExpandableListViewAdapter(Context context, List<String> listDataGroup, HashMap<String, List<String>> listDataChild) {
        this.context = context;
        this.listDataGroup = listDataGroup;
        this.listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return listDataGroup.size();
    }

    //There can have many child in a group, how can we understand win which group we are in
    @Override
    public int getChildrenCount(int i) {
        return listDataChild.get(listDataGroup.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {

        return listDataGroup.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {


        return listDataChild.get(listDataGroup.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {

        return i;
    }

    @Override
    public long getChildId(int i, int i1) {

        return i1;
    }

    @Override
    public boolean hasStableIds() {

        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String headerText= (String) getGroup(i);

        if(view==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view=layoutInflater.inflate(R.layout.group_row_list,null);

        }

        TextView groupTextView=view.findViewById(R.id.textViewGroup);
        groupTextView.setText(headerText);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        String childText= (String) getChild(i,i1);

        if(view==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.child_row_list,null);
        }
        TextView childTextView=view.findViewById(R.id.textViewChild);
        childTextView.setText(childText);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {

        return true;
    }
}
