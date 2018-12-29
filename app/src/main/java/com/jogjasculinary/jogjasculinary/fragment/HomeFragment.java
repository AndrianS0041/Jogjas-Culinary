package com.jogjasculinary.jogjasculinary.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jogjasculinary.jogjasculinary.R;


    public class HomeFragment extends Fragment {

        public HomeFragment() {
            // Required empty public constructor
        }

        public static com.jogjasculinary.jogjasculinary.fragment.CartFragment newInstance(String param1, String param2) {
            com.jogjasculinary.jogjasculinary.fragment.CartFragment fragment = new com.jogjasculinary.jogjasculinary.fragment.CartFragment();
            Bundle args = new Bundle();
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_home, container, false);
        }
    }

