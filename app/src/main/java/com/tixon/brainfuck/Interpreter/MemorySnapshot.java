package com.tixon.brainfuck.Interpreter;

/**
 * Created by tikhon on 21/01/16.
 */
public class MemorySnapshot {
    private String name;
    private long memoryValue;
    private int dataPointer;

    public MemorySnapshot(String name, long memoryValue, int dataPointer) {
        this.name = name;
        this.memoryValue = memoryValue;
        this.dataPointer = dataPointer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMemoryValue() {
        return memoryValue;
    }

    public void setMemoryValue(long memoryValue) {
        this.memoryValue = memoryValue;
    }

    public int getDataPointer() {
        return dataPointer;
    }

    public void setDataPointer(int dataPointer) {
        this.dataPointer = dataPointer;
    }
}
