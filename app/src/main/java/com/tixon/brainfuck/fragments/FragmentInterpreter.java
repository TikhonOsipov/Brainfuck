package com.tixon.brainfuck.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.tixon.brainfuck.Interpreter.Interpreter;
import com.tixon.brainfuck.R;

/**
 * Created by tikhon on 29/12/15.
 */
public class FragmentInterpreter extends Fragment {
    EditText etInput, etSourceCode, etConsole;
    Button bStart;
    Interpreter interpreter;

    public FragmentInterpreter() {
        interpreter = new Interpreter();
    }

    public static FragmentInterpreter newInstance() {
        FragmentInterpreter fragment = new FragmentInterpreter();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_interpreter, container, false);
        etInput = (EditText) v.findViewById(R.id.interpreter_et_input);
        etSourceCode = (EditText) v.findViewById(R.id.interpreter_et_source);
        etConsole = (EditText) v.findViewById(R.id.interpreter_et_console);
        bStart = (Button) v.findViewById(R.id.interpreter_button_start);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interpreter.setData(etSourceCode.getText().toString(),
                        etInput.getText().toString());
                String result = interpreter.interpretate();
                etConsole.setText(result);
            }
        });
        return v;
    }
}
