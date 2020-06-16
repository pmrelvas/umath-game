package com.pmrelvas.udamatematica.logic;

public enum Operator {
    SUM, SUBTRACTION, MULTIPLICATION, DIVISION;

    @Override
    public String toString() {
        switch (this) {
            case SUM: return "+";
            case SUBTRACTION: return "-";
            case MULTIPLICATION: return "*";
            case DIVISION: return ":";
            default: return "";
        }
    }
}
