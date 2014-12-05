package com.nuitinfo.nuitinfomobile;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.nuitinfo.nuitinfomobile.menu.MenuCustomAdapter;

/**
 * Created by tiby on 05/12/2014.
 */
public class MenuDrawerUnconFragment extends Fragment {

    private static final String TAG = "MenuDrawerConFragment";
    private static final String ARG_SECTION_NUMBER = "section_number";

    public Button btLogin = null ;
    public ListView menuitem = null ;

    public MenuDrawerUnconFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.menu_drawer_con_fragment, container, false);
        InitComponant(rootView);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        menuitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectItem(position);
            }
        });

        menuitem.setAdapter(new MenuCustomAdapter(getActivity().getApplicationContext(),
                new MenuI));


        return rootView;
    }

    public static MenuDrawerUnconFragment newInstance(int sectionNumber) {
        MenuDrawerUnconFragment fragment = new MenuDrawerUnconFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }




    public void InitComponant(View v){

        btLogin = (Button)v.findViewById(R.id.btnLoginMenu);
        menuitem = (ListView)v.findViewById(R.id.lsvMenu);


    }
}
