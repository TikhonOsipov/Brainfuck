package com.tixon.brainfuck.Interpreter;

import java.util.ArrayList;

/**
 * Created by tikhon on 29/12/15.
 */
public class Memory {
    private ArrayList<Long> memory;
    private int dataPointer;

    public Memory() {
        memory = new ArrayList<>();
        memory.add(0l);
        dataPointer = 0;
    }

    public void clear() {
        memory.clear();
        memory.add(0l);
        dataPointer = 0;
    }

    public long getValue() {
        return memory.get(dataPointer);
    }

    public void increaseDataPointer() {
        dataPointer++;
        if(dataPointer >= memory.size()) {
            memory.add(0l);
        }
    }

    public void decreaseDataPointer() {
        dataPointer--;
    }

    //увеличить значение в ячейке "+"
    public void increaseValue() {
        memory.set(dataPointer, memory.get(dataPointer) + 1);
    }

    //уменьшить значение в ячейке "-"
    public void decreaseValue() {
        memory.set(dataPointer, memory.get(dataPointer) - 1);
    }

    //печать "."
    public String print() {
        return Character.toString((char) memory.get(dataPointer).longValue());
    }

    //ввод ","
    public void input(char c) {
        memory.set(dataPointer, (long) c);
    }

    public String printRaw() {
        return String.valueOf(memory.get(dataPointer));
    }

    public void inputRaw(String s) {
        memory.set(dataPointer, Long.parseLong(s));
    }
}
