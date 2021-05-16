package com.lena.geek.calc;

public class Calc {
    double firstArg;
    private Boolean isOperatorSelected = false;
    private Boolean isPointSelected = false;
    private char symb;
    private StringBuilder inputStr = new StringBuilder();
    private String words[];
    double equals;

    public void setFirstArg(int firstArg) {
        this.firstArg = firstArg;
    }
    public void Calc() {
        isOperatorSelected = false;
    }

    public void onClick(int buttonId) {
            switch (buttonId) {
                case R.id.button_0:
                    if (inputStr.length() != 0) {
                        inputStr.append(0);
                    }
                    break;
                case R.id.button_1:
                    inputStr.append(1);
                    break;
                case R.id.button_2:
                    inputStr.append(2);
                    break;
                case R.id.button_3:
                    inputStr.append(3);
                    break;
                case R.id.button_4:
                    inputStr.append(4);
                    break;
                case R.id.button_5:
                    inputStr.append(5);
                    break;
                case R.id.button_6:
                    inputStr.append(6);
                    break;
                case R.id.button_7:
                    inputStr.append(7);
                    break;
                case R.id.button_8:
                    inputStr.append(8);
                    break;
                case R.id.button_9:
                    inputStr.append(9);
                    break;
                case R.id.button_multiply:
                    if (!isOperatorSelected && inputStr.length() != 0) {
                        firstArg = Double.valueOf(String.valueOf(inputStr));
                        inputStr.append('*');
                        symb = '*';
                        isOperatorSelected = true;
                    }
                    break;
                case R.id.button_divide:
                    if (!isOperatorSelected && inputStr.length() != 0) {
                        firstArg = Double.valueOf(String.valueOf(inputStr));
                        inputStr.append(':');
                        symb = ':';
                        isOperatorSelected = true;
                    }
                    break;
                case R.id.button_minus:
                    if (!isOperatorSelected && inputStr.length() != 0) {
                        firstArg = Double.valueOf(String.valueOf(inputStr));
                        inputStr.append('-');
                        symb = '-';
                        isOperatorSelected = true;
                    }
                    break;
                case R.id.button_plus:
                    if (!isOperatorSelected && inputStr.length() != 0) {
                        firstArg = Double.valueOf(String.valueOf(inputStr));
                        inputStr.append('+');
                        symb = '+';
                        isOperatorSelected = true;
                    }
                    break;
                case R.id.button_point:
                    if (!isPointSelected && inputStr.length() != 0 || isOperatorSelected ) {
                        inputStr.append('.');
                        isPointSelected = true;
                    }
                    break;
                case R.id.button_clear:
                    inputStr.setLength(0);
                    isOperatorSelected = false;
                    isPointSelected = false;
                    break;
            }
        }


    public String getText() {
        return inputStr.toString();
    }

    public String getFirstArg() {
        return String.valueOf(firstArg);
    }

    public String getOperation() {
        return String.valueOf(symb);
    }

    public String getSecondArg() {
        if (isOperatorSelected) {
            words = String.valueOf(inputStr).split("[" + getOperation() + "]");
            return words[1];
        }
        return words[0];
    }

    public String equals() {
        switch (symb) {
            case '+':
                equals = Double.valueOf(getFirstArg()) + Double.valueOf(getSecondArg());
                break;
            case '-':
                equals = Double.valueOf(getFirstArg()) - Double.valueOf(getSecondArg());
                break;
            case '*':
                equals = Double.valueOf(getFirstArg()) * Double.valueOf(getSecondArg());
                break;
            case ':':
                equals = Double.valueOf(getFirstArg()) / Double.valueOf(getSecondArg());
                break;
        }
        return String.valueOf(equals);
    }
    public void clearInputStr() {
        inputStr.setLength(0);
    }

    public void setIsOperatorSelected(Boolean isOperatorSelected) {
        this.isOperatorSelected = isOperatorSelected;
    }

}

