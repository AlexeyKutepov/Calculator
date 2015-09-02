package ru.software.kutepov.calculator;

/**
 * Перечисление операций
 */
public enum Operations {
    PLUS("+") {
        public boolean isOperation(String str) {return "+".equals(str); }
    },
    MINUS("-") {
        public boolean isOperation(String str) {return "-".equals(str); }
    },
    DIVISION("/") {
        public boolean isOperation(String str) {return "/".equals(str); }
    },
    MULTIPLICATION("*") {
        public boolean isOperation(String str) {return "*".equals(str); }
    };

    String operation;
    Operations(String operation) {
        this.operation = operation;
    }

    public static boolean check(String str) {
        return PLUS.isOperation(str) || MINUS.isOperation(str) || DIVISION.isOperation(str) || MULTIPLICATION.isOperation(str);
    }

    public abstract boolean isOperation(String str);
}
