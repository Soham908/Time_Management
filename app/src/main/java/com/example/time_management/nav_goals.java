package com.example.time_management;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link nav_goals#newInstance} factory method to
 * create an instance of this fragment.
 */
public class nav_goals extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public nav_goals() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment nav_goals.
     */
    // TODO: Rename and change types and number of parameters
    public static nav_goals newInstance(String param1, String param2) {
        nav_goals fragment = new nav_goals();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
//        view = getView();
        view = inflater.inflate(R.layout.fragment_nav_goals, container, false);
        Button addBtn;
        TextView goal;

        ArrayList<String> lapList = new ArrayList<>();
//        assert view != null;
        ListView lapListView = view.findViewById(R.id.lapList);
        ArrayAdapter<String> lapAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, lapList);
        lapListView.setAdapter(lapAdapter);

        goal = view.findViewById(R.id.goalInput);
        addBtn = view.findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s;
                s = (String) goal.getText();
                lapList.add(s);
                lapAdapter.notifyDataSetChanged();

            }
        });

        return inflater.inflate(R.layout.fragment_nav_goals, container, false);
    }

}