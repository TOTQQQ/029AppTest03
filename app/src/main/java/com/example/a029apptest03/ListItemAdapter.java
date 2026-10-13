package com.example.a029apptest03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListItemAdapter extends BaseAdapter {

    private final Context context;
    private final List<String> items;
    private final Set<Integer> selectedPositions = new HashSet<>();

    public ListItemAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public String getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_exp4, parent, false);
        }

        TextView tvText = convertView.findViewById(R.id.item_text);
        tvText.setText(items.get(position));

        convertView.setActivated(selectedPositions.contains(position));

        return convertView;
    }

    public void toggleSelection(int position) {
        if (selectedPositions.contains(position)) {
            selectedPositions.remove(position);
        } else {
            selectedPositions.add(position);
        }
        notifyDataSetChanged();
    }

    public void clearSelection() {
        selectedPositions.clear();
        notifyDataSetChanged();
    }

    public int getSelectedCount() {
        return selectedPositions.size();
    }

    public Set<Integer> getSelectedPositions() {
        return new HashSet<>(selectedPositions);
    }

    public List<String> getSelectedNames() {
        List<String> names = new ArrayList<>();
        for (int pos : selectedPositions) {
            names.add(items.get(pos));
        }
        return names;
    }

    public void removeSelectedItems() {
        List<Integer> sortedPositions = new ArrayList<>(selectedPositions);
        java.util.Collections.sort(sortedPositions, java.util.Collections.reverseOrder());
        for (int pos : sortedPositions) {
            items.remove(pos);
        }
        selectedPositions.clear();
        notifyDataSetChanged();
    }
}
