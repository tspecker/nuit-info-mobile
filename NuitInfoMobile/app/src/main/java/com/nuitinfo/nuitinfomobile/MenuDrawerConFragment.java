package com.nuitinfo.nuitinfomobile;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by tiby on 05/12/2014.
 */
public class MenuDrawerConFragment extends Fragment {

    private static final String TAG = "MenuDrawerConFragment";
    private static final String ARG_SECTION_NUMBER = "section_number";

    public Button btLogout = null ;
    public ListView menuitem = null ;

    public MenuDrawerConFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.menu_drawer_con_fragment, container, false);
        InitComponant(rootView);

        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        menuitem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return rootView;
    }

    public static MenuDrawerConFragment newInstance(int sectionNumber) {
        MenuDrawerConFragment fragment = new MenuDrawerConFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }




    public void InitComponant(View v){

        btLogout = (Button)v.findViewById(R.id.btnLoginMenu);
        menuitem = (ListView)v.findViewById(R.id.lsvMenu);

    }
}
