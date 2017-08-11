package com.ytc.agendaafrica.fragments;


import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.ytc.agendaafrica.R;
import com.ytc.agendaafrica.Services.SyncService;
import com.ytc.agendaafrica.adapters.GoogleCardsAgendaAdapter;
import com.ytc.agendaafrica.models.agenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class agendaFragment extends Fragment {


    private GoogleCardsAgendaAdapter mGoogleCardsAdapter;
    List<agenda> prayersdata ;

    public agendaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prayer, container, false);

        ListView listView = (ListView) view.findViewById(R.id.aspirationlist);

        prayersdata = getallchurchList();

        mGoogleCardsAdapter = new GoogleCardsAgendaAdapter(getActivity(),
                prayersdata);

        if (prayersdata.size()!=0) {
            listView.setClipToPadding(false);
            listView.setDivider(null);
            Resources r = getResources();
            int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    16, r.getDisplayMetrics());
            listView.setDividerHeight(px);
            listView.setFadingEdgeLength(0);
            listView.setFitsSystemWindows(true);
            px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16,
                    r.getDisplayMetrics());
            listView.setPadding(px, px, px, px);
            listView.setScrollBarStyle(ListView.SCROLLBARS_OUTSIDE_OVERLAY);


            listView.setAdapter(mGoogleCardsAdapter);
        }

        return view;
    }








    private static ArrayList<agenda> getallchurchList() {
        ArrayList<agenda> list = new ArrayList<>();

        list.add(new agenda(1,"A prosperous Africa","Based on inclusive growth and sustainable development to eradicate poverty in one generation and build shared prosperity through social and economic transformation of the continent."));
        list.add(new agenda(2,"An integrated Africa","Politically united, based on the ideals of Pan-Africanism and the vision of Africa’s Renaissance motivated by development based on self-reliance and self-determination of African people, with democratic and people-centred governance."));
        list.add(new agenda(3,"A good Africa","Africa shall have a universal culture of GOOD governance, democratic values, gender equality, respect for human rights, justice and the rule of law."));
        list.add(new agenda(4,"A peaceful and secure Africa","Mechanisms  for  peaceful  prevention  and  resolution  of  conflicts  will  be functional  at  all  levels.  As  a  first  step,  dialogue-centred  conflict  prevention  and resolution will be actively promoted in such a way that by 2020 all guns will be silent. A culture of peace and tolerance shall be nurtured in Africa’s children and youth through peace education."));
        list.add(new agenda(5,"A cultural Africa","A strong cultural identity, common heritage, values and ethics. Pan-Africanism and the common history, destiny, identity, heritage, respect for religious diversity and consciousness of African people’s and her diaspora’s will be entrenched."));
        list.add(new agenda(6,"An African People","All  the  citizens  of  Africa  will  be  actively  involved  in  decision  making  in  all aspects. Africa shall be an inclusive continent where no child, woman or man will  be  left  behind  or  excluded,  on  the  basis  of  gender,  political  affiliation, religion, ethnic affiliation, locality, age or other factors."));
        list.add(new agenda(7,"A global Africa","Africa  shall  be  a  strong,  united,  resilient,  peaceful  and  influential  global  player  and partner  with  a  significant  role  in  world  affairs.  We  affirm  the  importance  of  African unity and solidarity in the face of continued external interference including, attempts to divide the continent and undue pressures and sanctions on some countries."));
        return list;
    }

}