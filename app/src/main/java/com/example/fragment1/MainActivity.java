package com.example.fragment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText mEdtText;
    Button mBtnAddFragment, mBtnRemoveFragment;
    ArrayList<CounterFragment> mListCounterFragment;
    CounterFragment mCounterFragment1, mCounterFragment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListCounterFragment = new ArrayList<>();
        mBtnAddFragment = findViewById(R.id.btnAdd);
        mBtnRemoveFragment = findViewById(R.id.btnRemove);
        mEdtText = findViewById(R.id.edtCounter);

        mCounterFragment1 = (CounterFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentCounter1);
        mCounterFragment2 = (CounterFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentCounter2);

        mBtnAddFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CounterFragment counterFragment = new CounterFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("count", Integer.parseInt(mEdtText.getText().toString()));
                counterFragment.setArguments(bundle);

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.mainContainer, counterFragment);
                fragmentTransaction.commit();

                mListCounterFragment.add(counterFragment);


            }
        });
        mBtnRemoveFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .remove(mListCounterFragment.get(mListCounterFragment.size() - 1))
                        .commit();

                mListCounterFragment.remove(mListCounterFragment.size() - 1);

            }
        });

    }
}