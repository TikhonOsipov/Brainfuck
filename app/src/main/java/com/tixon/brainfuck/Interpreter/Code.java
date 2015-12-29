package com.tixon.brainfuck.Interpreter;

import java.util.ArrayList;

/**
 * Created by tikhon on 29/12/15.
 */
public class Code {
    private int codePointer;
    private ArrayList<Character> sourceCode;

    public Code(String codeString) {
        codePointer = 0;
        sourceCode = new ArrayList<>();
        convertString(codeString);
    }
    
    private void convertString(String codeString) {
        //удалить перевод строк
        while(codeString.contains("\n")) {
            codeString = codeString.replace("\n", "");
        }

        //удалить пробелы
        while(codeString.contains(" ")) {
            codeString = codeString.replace(" ", "");
        }

        for(int i = 0; i < codeString.length(); i++) {
            sourceCode.add(codeString.charAt(i));
        }
    }

    public void increaseCodePointer() {
        codePointer++;
    }

    public void setCodePointerAtRight(long memoryValue) {
        if(memoryValue == 0) {
            codePointer = findRightBracket() + 1;
        } else {
            codePointer++;
        }
    }

    public void setCodePointerAtLeft() {
        codePointer = findLeftBracket();
    }

    private int findRightBracket() {
        int balance = 1;
        int index = -1;
        for(int i = codePointer + 1; i < sourceCode.size(); i++) {
            if(sourceCode.get(i) == '[') {
                balance++;
            } else if(sourceCode.get(i) == ']') {
                balance--;
            }

            if(balance == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    private int findLeftBracket() {
        int balance = 1;
        int index = -1;
        for(int i = codePointer - 1; i >= 0; i--) {
            if(sourceCode.get(i) == '[') {
                balance--;
            } else if(sourceCode.get(i) == ']') {
                balance++;
            }

            if(balance == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    public char getCommand() {
        return sourceCode.get(codePointer);
    }

    public boolean hasNext() {
        return codePointer < sourceCode.size();
    }
}
