package com.nuitinfo.nuitinfomobile;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by tiby on 05/12/2014.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private static final String ARG_SECTION_NUMBER = "section_number";
    ListView lvNews = null ;


    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        InitComponant(rootView);
        Toast.makeText(getActivity().getApplicationContext(),"home",Toast.LENGTH_LONG).show();
        lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return rootView;
    }

    public static HomeFragment newInstance(int sectionNumber) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }




    public void InitComponant(View v){
        lvNews = (ListView)v.findViewById(R.id.lvNews);
    }
}
