package com.tixon.brainfuck.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.tixon.brainfuck.Interpreter.History;
import com.tixon.brainfuck.Interpreter.Memory;
import com.tixon.brainfuck.R;
import com.tixon.brainfuck.adapters.MemoryStepRecyclerAdapter;

/**
 * Created by tikhon on 31/12/15.
 */
public class FragmentStepByStep extends Fragment implements View.OnClickListener {

    Button incValue, decValue, incPointer, decPointer,
            bCycleStart, bCycleEnd, bInput, bOutput, bInputRaw, bOutputRaw;
    EditText etCode;
    RecyclerView recyclerView;

    private Memory memory;
    private History history;
    private LinearLayoutManager layoutManager;
    private MemoryStepRecyclerAdapter adapter;

    public FragmentStepByStep() {
        history = new History();
        memory = new Memory();
    }

    public static FragmentStepByStep newInstance() {
        FragmentStepByStep fragment = new FragmentStepByStep();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_step_by_step, container, false);

        etCode = (EditText) v.findViewById(R.id.etCodeSBS);

        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new MemoryStepRecyclerAdapter(memory);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewMemorySBS);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

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
        history.addOperation("+", memory);
        memory.increaseValue();
    }

    public void decreaseValue() {
        Log.d("myLogs", "decrease value");
        history.addOperation("-", memory);
        memory.decreaseValue();
    }

    public void increaseDataPointer() {
        Log.d("myLogs", "increase data pointer");
        history.addOperation(">", memory);
        memory.increaseDataPointer();
    }

    public void decreaseDataPointer() {
        Log.d("myLogs", "decrease data pointer");
        history.addOperation("<", memory);
        memory.decreaseDataPointer();
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
        adapter.notifyDataSetChanged();
        etCode.setText(history.getCode());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_step_by_step, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sbs_undo:
                if(!history.isEmpty()) {
                    history.undo(memory);
                }
                break;
            default: break;
        }
        adapter.notifyDataSetChanged();
        etCode.setText(history.getCode());
        return super.onOptionsItemSelected(item);
    }
}
