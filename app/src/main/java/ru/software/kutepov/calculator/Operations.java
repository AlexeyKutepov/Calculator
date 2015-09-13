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
    },
    SIN("sin") {
        public boolean isOperation(String str) {return "sin".equals(str); }
    },
    COS("cos") {
        public boolean isOperation(String str) {return "cos".equals(str); }
    },
    TAN("tan") {
        public boolean isOperation(String str) {return "tan".equals(str); }
    };

    String operation;
    Operations(String operation) {
        this.operation = operation;
    }

    public static boolean check(String str) {
        return PLUS.isOperation(str)
                || MINUS.isOperation(str)
                || DIVISION.isOperation(str)
                || MULTIPLICATION.isOperation(str)
                || SIN.isOperation(str)
                || COS.isOperation(str)
                || TAN.isOperation(str);
    }

    public abstract boolean isOperation(String str);
}
