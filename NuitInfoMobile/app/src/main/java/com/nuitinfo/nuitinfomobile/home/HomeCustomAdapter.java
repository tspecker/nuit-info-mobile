package com.nuitinfo.nuitinfomobile.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.volley.toolbox.ImageLoader;
import com.nuitinfo.nuitinfomobile.R;

import java.util.ArrayList;

/**
 * Created by tspecker on 04/12/14.
 */
public class HomeCustomAdapter extends BaseAdapter {


    private final Context mContext;
    private final ImageLoader mImgLoader;
    private ArrayList<User> mUser;

    public HomeCustomAdapter(Context mContext, ImageLoader mImgLoader, ArrayList<User> user) {
        this.mContext = mContext;
        this.mImgLoader = mImgLoader;
        this.mUser = user;
    }


    @Override
    public int getCount() {
        return (mUser == null || mUser.size() <= 0) ? 0 : mUser.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return (long) mUser.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User item = mUser.get(position);

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

    private void setupView(ViewHolder vh, User item) {
        // TODO
    }

    private class ViewHolder {
    }
}
