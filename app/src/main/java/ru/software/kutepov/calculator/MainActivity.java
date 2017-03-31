package ru.software.kutepov.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Deque<Operations> operationStack;
    private Deque<Double> valueStack;
    private boolean isStart = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textViewMain);
        operationStack = new LinkedList<>();
        valueStack = new LinkedList<>();
    }

    public void onClickButtonZero(View view) {
        printToTextView("0");
    }

    public void onClickButtonOne(View view) {
        printToTextView("1");
    }

    public void onClickButtonTwo(View view) {
        printToTextView("2");
    }

    public void onClickButtonThree(View view) {
        printToTextView("3");
    }

    public void onClickButtonFour(View view) {
        printToTextView("4");
    }

    public void onClickButtonFive(View view) {
        printToTextView("5");
    }

    public void onClickButtonSix(View view) {
        printToTextView("6");
    }

    public void onClickButtonSeven(View view) {
        printToTextView("7");
    }

    public void onClickButtonEight(View view) {
        printToTextView("8");
    }

    public void onClickButtonNine(View view) {
        printToTextView("9");
    }

    public void onClickButtonPoint(View view) {
        printToTextView(".");
    }

    public void onClickButtonResult(View view) {
        if (!textView.getText().toString().isEmpty()) {
            if (!isStart) {
                if (operationStack.isEmpty()) {
                    valueStack.clear();
                }
                valueStack.add(Double.valueOf(textView.getText().toString()));
                isStart = true;
            }
            int openBracketCount = 0;
            int closeBracketCount = 0;
            for (Operations operation: operationStack) {
                if (operation == Operations.OPEN_BRACKET) {
                    openBracketCount++;
                } else if (operation == Operations.CLOSE_BRACKET) {
                    closeBracketCount++;
                }
            }
            if (closeBracketCount < openBracketCount) {
                for (int i = 0; i < openBracketCount - closeBracketCount; i++) {
                    operationStack.add(Operations.CLOSE_BRACKET);
                }
            }
            Double result = calculate(operationStack, valueStack);
            valueStack.add(result);
            textView.setText(doubleToString(result));
        }
    }

    public void onClickButtonDel(View view) {
        operationStack.clear();
        valueStack.clear();
        isStart = true;
        textView.setText("0");
    }

    public void onClickButtonDivision(View view) {
        onOperationButtonClick(Operations.DIVISION);
    }

    public void onClickButtonMultiplication(View view) {
        onOperationButtonClick(Operations.MULTIPLICATION);
    }

    public void onClickButtonMinus(View view) {
        onOperationButtonClick(Operations.MINUS);
    }

    public void onClickButtonPlus(View view) {
        onOperationButtonClick(Operations.PLUS);
    }

    public void onClickButtonSin(View view) {
        onOperationButtonClick(Operations.SIN);
    }

    public void onClickButtonCos(View view) {
        onOperationButtonClick(Operations.COS);
    }

    public void onClickButtonTan(View view) {
        onOperationButtonClick(Operations.TAN);
    }

    public void onClickButtonLn(View view) {
        onOperationButtonClick(Operations.LN);
    }

    public void onClickButtonLog(View view) {
        onOperationButtonClick(Operations.LOG);
    }

    public void onClickButtonExp(View view) {
        onOperationButtonClick(Operations.EXP);
    }

    public void onClickButtonInvolution(View view) {
        onOperationButtonClick(Operations.INVOLUTION);
    }

    public void onClickButtonRoot(View view) {
        onOperationButtonClick(Operations.ROOT);
    }

    public void onClickButtonPlusMinus(View view) {
        onOperationButtonClick(Operations.PLUS_MINUS);
    }

    public void onClickButtonFactorial(View view) {
        onOperationButtonClick(Operations.FACTORIAL);
    }

    public void onClickButtonOpenBracket(View view) {
        onOperationButtonClick(Operations.OPEN_BRACKET);
    }

    public void onClickButtonCloseBracket(View view) {
        onOperationButtonClick(Operations.CLOSE_BRACKET);
    }

    /**
     * Выполнение операции
     * @param operation операция
     */
    private void onOperationButtonClick(Operations operation) {
        if (!textView.getText().toString().isEmpty()) {
            if (!isStart) {
                valueStack.add(Double.valueOf(textView.getText().toString()));
                if (operation == Operations.CLOSE_BRACKET) {
                    operationStack.add(operation);
                }
                if (valueStack.size() > 1) {
                    Double result = calculate(operationStack, valueStack);
                    valueStack.add(result);
                    textView.setText(doubleToString(result));
                }
                if (operation == Operations.OPEN_BRACKET) {
                    operationStack.add(Operations.MULTIPLICATION);
                }
                if (operation != Operations.CLOSE_BRACKET) {
                    operationStack.add(operation);
                }
            } else {
                if (!operationStack.isEmpty()) {
                    if (operation == Operations.OPEN_BRACKET) {
                        operationStack.add(operation);
                    } else if (operation == Operations.CLOSE_BRACKET) {
                        operationStack.add(operation);
                        Double result = calculate(operationStack, valueStack);
                        valueStack.add(result);
                        textView.setText(doubleToString(result));
                    } else {
                        ((LinkedList<Operations>) operationStack).set(operationStack.size() - 1, operation);
                    }
                } else {
                    if (!valueStack.isEmpty() && operation == Operations.OPEN_BRACKET) {
                        operationStack.add(Operations.MULTIPLICATION);
                    }
                    operationStack.add(operation);
                }
            }
            if (operation == Operations.SIN
                    || operation == Operations.COS
                    || operation == Operations.TAN
                    || operation == Operations.LN
                    || operation == Operations.LOG
                    || operation == Operations.EXP
                    || operation == Operations.ROOT
                    || operation == Operations.PLUS_MINUS
                    || operation == Operations.FACTORIAL) {
                if (valueStack.size() > 0) {
                    Double result = calculate(operationStack, valueStack);
                    valueStack.add(result);
                    textView.setText(doubleToString(result));
                }
            }
            isStart = true;
        }
    }

    /**
     * Подсчёт результата
     * @param operationStack стек операций
     * @param valueStack стек значений
     * @return результат
     */
    private Double calculate(Deque<Operations> operationStack, Deque<Double> valueStack) {
        if (valueStack.isEmpty()) return 0.0;
        Double result = valueStack.pollLast();
        int closeBracketCount = 0;
        while (!operationStack.isEmpty()) {
            if (operationStack.peekLast() == Operations.CLOSE_BRACKET) {
                closeBracketCount++;
                operationStack.pollLast();
                continue;
            }
            if (operationStack.peekLast() == Operations.OPEN_BRACKET) {
                if (closeBracketCount > 0) {
                    operationStack.pollLast();
                    closeBracketCount--;
                    continue;
                } else {
                    return result;
                }
            }
            switch (operationStack.pollLast()) {
                case PLUS:
                    result = valueStack.isEmpty()?result:(valueStack.pollLast() + result);
                    break;
                case MINUS:
                    result = valueStack.isEmpty()?result:(valueStack.pollLast() - result);
                    break;
                case DIVISION:
                    result = valueStack.isEmpty()?result:(valueStack.pollLast() / result);
                    break;
                case MULTIPLICATION:
                    result = valueStack.isEmpty()?result:(valueStack.pollLast() * result);
                    break;
                case INVOLUTION:
                    result = Math.pow(valueStack.isEmpty()?1:valueStack.pollLast(), result);
                    break;
                case SIN:
                    result = Math.sin(result);
                    break;
                case COS:
                    result = Math.cos(result);
                    break;
                case TAN:
                    result = Math.tan(result);
                    break;
                case LN:
                    result = Math.log(result);
                    break;
                case LOG:
                    result = Math.log10(result);
                    break;
                case EXP:
                    result = Math.exp(result);
                    break;
                case ROOT:
                    result = Math.sqrt(result);
                    break;
                case PLUS_MINUS:
                    result = result * (-1);
                    break;
                case FACTORIAL:
                    result = (double) factorial(result.intValue());
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    /**
     * Вывод в TextView
     * @param value данные
     */
    private void printToTextView(String value) {
        if (isStart) {
            textView.setText("");
            isStart = false;
        }
        if (".".equals(value)) {
            if (!textView.getText().toString().contains(".")) {
                if (textView.getText().toString().isEmpty()) {
                    textView.setText("0.");
                } else {
                    textView.setText(textView.getText() + value);
                }
            }
        } else {
            if ("0".equals(textView.getText())) {
                textView.setText("");
            }
            textView.setText(textView.getText() + value);
        }
    }

    /**
     * Поиск факториала
     * @param n число
     * @return результат
     */
    private long factorial(int n) {

        if (n < 0) return n;

        long factorial = 1;
        for(int i = 2; i <= n; i++)
            factorial *= i;

        return factorial;
    }

    /**
     * Преобразование дробного числа в строку с отбрасыванием лишних нулей
     * @param d число с дробной частью
     * @return результат
     */
    private String doubleToString(Double d) {
        if ((d - d.intValue()) > 0) {
            return d.toString();
        } else {
            return d.intValue() + "";
        }
    }


}
