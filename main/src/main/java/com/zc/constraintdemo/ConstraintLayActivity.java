package com.zc.constraintdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zc.mydemoin58.R;

public class ConstraintLayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_lay);
    }

    public void cOut(int[] mNums) {
        mNums = sort(mNums);
        if (mNums[0] == 0) {
            for (int i = 1; i < mNums.length; i++) {
                if (mNums[i] != 0) {
                    mNums[0] = mNums[i];
                    mNums[i] = 0;
                    break;
                }
            }
        }
        Log.e("打印", mNums.toString());
    }

    public int[] sort(int[] mNums) {
        int index = -1;
        int min = 0;
        for (int i = 0; i < mNums.length - 1; i++) {
            for (int j = i + 1; j < mNums.length; j++) {
                min = mNums[i];
                if (min > mNums[j]) {
                    min = mNums[j];
                    index = j;
                }
            }
            if (index != i) {
                mNums[index] = mNums[i];
                mNums[i] = min;
            }
        }
        return mNums;
    }
}
