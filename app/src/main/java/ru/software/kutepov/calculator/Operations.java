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
    },
    LN("ln") {
        public boolean isOperation(String str) {return "ln".equals(str); }
    },
    LOG("log") {
        public boolean isOperation(String str) {return "log".equals(str); }
    },
    EXP("exp") {
        public boolean isOperation(String str) {return "exp".equals(str); }
    },
    INVOLUTION("involution") {
        public boolean isOperation(String str) {return "involution".equals(str); }
    },
    ROOT("root") {
        public boolean isOperation(String str) {return "root".equals(str); }
    },
    PLUS_MINUS("plus_minus") {
        public boolean isOperation(String str) {return "plus_minus".equals(str); }
    },
    FACTORIAL("factorial") {
        public boolean isOperation(String str) {return "factorial".equals(str); }
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
                || TAN.isOperation(str)
                || LN.isOperation(str)
                || LOG.isOperation(str)
                || EXP.isOperation(str)
                || INVOLUTION.isOperation(str)
                || ROOT.isOperation(str)
                || PLUS_MINUS.isOperation(str)
                || FACTORIAL.isOperation(str);
    }

    public abstract boolean isOperation(String str);
}
