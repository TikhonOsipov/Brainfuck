package com.tixon.brainfuck.Interpreter;

import java.util.ArrayList;

/**
 * Created by tikhon on 21/01/16.
 */
public class History {
    private ArrayList<MemorySnapshot> history;
    private StringBuilder code;
    private int position;

    public History() {
        code = new StringBuilder();
        history = new ArrayList<>();
        position = 0;
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public String getCode() {
        return code.toString();
    }

    public void addOperation(String name, Memory memory) {
        history.add(new MemorySnapshot(name, memory.getValue(), memory.getDataPointer()));
        code.append(name);
        deleteUnnecessary();
        position = history.size() - 1;

    }

    private void deleteUnnecessary() {
        /*for(int i = position; i < history.size(); i++) {
            history.remove(position);
        }*/
    }

    public void undo(Memory memory) {
        performCommand(getOpposite(history.get(position).getName()), memory);
        code.deleteCharAt(code.length() - 1);
    }

    private void performCommand(String command, Memory memory) {
        switch (command) {
            case "+":
                memory.increaseValue();
                break;
            case "-":
                memory.decreaseValue();
                break;
            case ">":
                memory.increaseDataPointer();
                break;
            case "<":
                memory.decreaseDataPointer();
                break;
            default: break;
        }
    }

    private String getOpposite(String name) {
        switch (name) {
            case "+":
                return "-";
            case "-":
                return "+";
            case ">":
                return "<";
            case "<":
                return ">";
            default:
                return "";
        }
    }
}
