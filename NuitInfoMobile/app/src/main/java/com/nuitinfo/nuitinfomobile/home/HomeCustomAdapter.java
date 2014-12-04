package com.nuitinfo.nuitinfomobile.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.volley.toolbox.ImageLoader;
import com.nuitinfo.model.News;
import com.nuitinfo.nuitinfomobile.R;

import java.util.ArrayList;

/**
 * Created by tspecker on 04/12/14.
 */
public class HomeCustomAdapter extends BaseAdapter {


    private final Context mContext;
    private final ImageLoader mImgLoader;
    private ArrayList<News.Article> mArticles;

    public HomeCustomAdapter(Context mContext, ImageLoader mImgLoader, ArrayList<News.Article> articles) {
        this.mContext = mContext;
        this.mImgLoader = mImgLoader;
        this.mArticles = articles;
    }


    @Override
    public int getCount() {
        return (mArticles == null || mArticles.size() <= 0) ? 0 : mArticles.size();
    }

    @Override
    public News.Article getItem(int position) {
        News.Article item = null;
        if (mArticles != null && mArticles.size() > 0) {
            item = mArticles.get(position);
        }
        return item;
    }

    @Override
    public long getItemId(int position) {
        return (long) mArticles.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        News.Article item = mArticles.get(position);

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

    private void setupView(ViewHolder vh, News.Article item) {
        // TODO
    }

    private class ViewHolder {
    }
}
