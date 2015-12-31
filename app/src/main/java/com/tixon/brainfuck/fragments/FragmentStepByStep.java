package com.tixon.brainfuck.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tixon.brainfuck.R;

/**
 * Created by tikhon on 31/12/15.
 */
public class FragmentStepByStep extends Fragment implements View.OnClickListener {

    Button incValue, decValue, incPointer, decPointer,
            bCycleStart, bCycleEnd, bInput, bOutput, bInputRaw, bOutputRaw;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_step_by_step, container, false);
        incValue = (Button) v.findViewById(R.id.button_increase_value);
        decValue = (Button) v.findViewById(R.id.button_decrease_value);
        incPointer = (Button) v.findViewById(R.id.button_increase_data_pointer);
        decPointer = (Button) v.findViewById(R.id.button_decrease_data_pointer);
        bCycleStart = (Button) v.findViewById(R.id.button_cycle_start);
        bCycleEnd = (Button) v.findViewById(R.id.button_cycle_end);
        bInput = (Button) v.findViewById(R.id.button_input);
        bOutput = (Button) v.findViewById(R.id.button_output);
        bInputRaw = (Button) v.findViewById(R.id.button_input_raw);
        bOutputRaw = (Button) v.findViewById(R.id.button_output_raw);

        incValue.setOnClickListener(this);
        decValue.setOnClickListener(this);
        incPointer.setOnClickListener(this);
        decPointer.setOnClickListener(this);
        bCycleStart.setOnClickListener(this);
        bCycleEnd.setOnClickListener(this);
        bInput.setOnClickListener(this);
        bOutput.setOnClickListener(this);
        bInputRaw.setOnClickListener(this);
        bOutputRaw.setOnClickListener(this);
        return v;
    }

    public void increaseValue() {
        Log.d("myLogs", "increase value");
    }

    public void decreaseValue() {
        Log.d("myLogs", "decrease value");
    }

    public void increaseDataPointer() {

    }

    public void decreaseDataPointer() {

    }

    public void cycleStart() {
        
    }

    public void cycleEnd() {

    }
    
    public void input() {
        
    }

    public void output() {

    }

    public void inputRaw() {

    }

    public void outputRaw() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_increase_value:
                increaseValue();
                break;
            case R.id.button_decrease_value:
                decreaseValue();
                break;
            case R.id.button_increase_data_pointer:
                increaseDataPointer();
                break;
            case R.id.button_decrease_data_pointer:
                decreaseDataPointer();
                break;
            case R.id.button_cycle_start:
                cycleStart();
                break;
            case R.id.button_cycle_end:
                cycleEnd();
                break;
            case R.id.button_input:
                input();
                break;
            case R.id.button_output:
                output();
                break;
            case R.id.button_input_raw:
                inputRaw();
                break;
            case R.id.button_output_raw:
                outputRaw();
                break;
        }
    }
}
