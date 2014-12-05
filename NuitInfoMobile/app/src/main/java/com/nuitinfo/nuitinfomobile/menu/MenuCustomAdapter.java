package com.nuitinfo.nuitinfomobile.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nuitinfo.model.Menu;
import com.nuitinfo.nuitinfomobile.R;

import java.util.ArrayList;

/**
 * Created by tspecker on 04/12/14.
 */
public class MenuCustomAdapter extends BaseAdapter {


    private final Context mContext;
    private ArrayList<Menu.CustomMenuItem> mMenus;

    public MenuCustomAdapter(Context mContext, ArrayList<Menu.CustomMenuItem> menus) {
        this.mContext = mContext;
        this.mMenus = menus;
    }


    @Override
    public int getCount() {
        return (mMenus == null || mMenus.size() <= 0) ? 0 : mMenus.size();
    }

    @Override
    public Menu.CustomMenuItem getItem(int position) {
        Menu.CustomMenuItem item = null;
        if (mMenus != null && mMenus.size() > 0) {
            item = mMenus.get(position);
        }
        return item;
    }

    @Override
    public long getItemId(int position) {
        return (long) mMenus.get(position).image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Menu.CustomMenuItem item = mMenus.get(position);

        View v = convertView;
        ViewHolder vh = null;

        // LayoutInflator to call my custom item
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (v == null) {
            v = new View(mContext);
            v = inflater.inflate(R.layout.home_custom_item, parent, false);

            // setup ViewHolder
            vh = new ViewHolder();
            // populate View Holder
            findViews(v, vh);
            // store view inside a tag
            v.setTag(vh);
        } else {
            vh = ((ViewHolder) v.getTag());
        }

        setupView(vh, item);

        return v;
    }

    private void findViews(View v, ViewHolder vh) {
        // TODO
    }

    private void setupView(ViewHolder vh, Menu.CustomMenuItem item) {
        // TODO
    }

    private class ViewHolder {
    }
}
