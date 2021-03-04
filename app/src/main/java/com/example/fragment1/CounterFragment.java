package com.example.fragment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class CounterFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView mTxtCount;
    Button mBtnPlus,mBtnMinus;
    int mCount ;

    public CounterFragment() {
        // Required empty public constructor
    }

    public static CounterFragment newInstance(String param1, String param2) {
        CounterFragment fragment = new CounterFragment();
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
        View view = inflater.inflate(R.layout.fragment_counter, container, false);

        if (getArguments() !=null){
            mCount = getArguments().getInt("count",0);
        }else{
            mCount = 0;
        }
        mTxtCount = view.findViewById(R.id.txtCount);
        mBtnPlus = view.findViewById(R.id.btnPlus);
        mBtnMinus = view.findViewById(R.id.btnMinus);
        mTxtCount.setText(mCount+"");
        mBtnPlus.setOnClickListener(new btnPlusListener());
        mBtnMinus.setOnClickListener(new btnMinusListener());
        return view;

    }

    public class btnPlusListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            mCount++;
            mTxtCount.setText(mCount+"");

        }
    }
    public class btnMinusListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            mCount--;
            mTxtCount.setText(mCount+"");
        }
    }
    public  void  SetCount(int count){
        mCount = count;
        mTxtCount.setText(mCount+"");
    }
}