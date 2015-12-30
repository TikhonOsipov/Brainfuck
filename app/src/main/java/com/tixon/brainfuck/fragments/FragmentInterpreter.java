package com.tixon.brainfuck.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.tixon.brainfuck.Interpreter.Interpreter;
import com.tixon.brainfuck.R;
import com.tixon.brainfuck.views.CodeEditText;

/**
 * Created by tikhon on 29/12/15.
 */
public class FragmentInterpreter extends Fragment {
    EditText etInput, etConsole;
    CodeEditText etSourceCode;
    Button bStart;
    Interpreter interpreter;

    private boolean isDataSet;

    public FragmentInterpreter() {
        interpreter = new Interpreter();
        isDataSet = false;
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
        etConsole = (EditText) v.findViewById(R.id.interpreter_et_console);
        etSourceCode = (CodeEditText) v.findViewById(R.id.interpreter_et_source);

        bStart = (Button) v.findViewById(R.id.interpreter_button_start);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isDataSet) {
                    interpreter.setData(etSourceCode.getText().toString(),
                            etInput.getText().toString());
                    interpreter.prepareForDebug();
                    isDataSet = true;
                }
                debug();

                //String result = interpreter.interpretate();
                //etConsole.setText(result);
            }
        });
        return v;
    }

    private void debug() {
        int codePointer = interpreter.getCodePointer();
        interpreter.debug();
        try {
            etSourceCode.selectSpannable(codePointer, codePointer + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
