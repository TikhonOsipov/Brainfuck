package com.tixon.brainfuck.Interpreter;

/**
 * Created by tikhon on 29/12/15.
 */
public class Interpreter {
    //commands
    public static final char LEFT_BRACKET = '[';
    public static final char RIGHT_BRACKET = ']';
    public static final char INC_DATA_POINTER = '>';
    public static final char DEC_DATA_POINTER = '<';
    public static final char INC_MEM_VALUE = '+';
    public static final char DEC_MEM_VALUE = '-';
    public static final char PRINT = '.';
    public static final char INPUT = ',';
    public static final char PRINT_RAW = ':';
    public static final char INPUT_RAW = ';';

    private Code code;
    private Memory memory;
    private String[] input;
    private int inputPointer;
    private String output;

    public Interpreter(String codeString, String inputString) {
        this();
        code = new Code(codeString);
        input = inputString.split(" ");
    }

    public Interpreter() {
        memory = new Memory();
        inputPointer = 0;
        output = "";
    }

    public void setData(String codeString, String inputString) {
        code = new Code(codeString);
        input = inputString.split(" ");
    }

    public String interpretate() {
        memory.clear();
        inputPointer = 0;
        output = "";
        while(code.hasNext()) {
            performCommand(code.getCommand());
        }
        return output;
    }

    private void performCommand(char command) {
        switch (command) {
            case LEFT_BRACKET:
                code.setCodePointerAtRight(memory.getValue());
                break;
            case RIGHT_BRACKET:
                code.setCodePointerAtLeft();
                break;
            case INC_DATA_POINTER:
                memory.increaseDataPointer();
                code.increaseCodePointer();
                break;
            case DEC_DATA_POINTER:
                memory.decreaseDataPointer();
                code.increaseCodePointer();
                break;
            case INC_MEM_VALUE:
                memory.increaseValue();
                code.increaseCodePointer();
                break;
            case DEC_MEM_VALUE:
                memory.decreaseValue();
                code.increaseCodePointer();
                break;
            case PRINT:
                output += memory.print();
                code.increaseCodePointer();
                break;
            case INPUT:
                memory.input(input[inputPointer].charAt(0));
                code.increaseCodePointer();
                inputPointer++;
                break;
            case PRINT_RAW:
                output += memory.printRaw();
                code.increaseCodePointer();
                break;
            case INPUT_RAW:
                memory.inputRaw(input[inputPointer]);
                code.increaseCodePointer();
                inputPointer++;
                break;
            default: break;
        }
    }

}
