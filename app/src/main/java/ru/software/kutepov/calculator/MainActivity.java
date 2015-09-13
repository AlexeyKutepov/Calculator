package ru.software.kutepov.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Queue<Operations> operationStack;
    private Queue<Double> valueStack;
    private boolean isDisplayValueNotActual = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textViewMain);
        operationStack = new LinkedList<>();
        valueStack = new LinkedList<>();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickButtonZero(View view) {
        if (isDisplayValueNotActual) {
            textView.setText("");
            isDisplayValueNotActual = false;
        }
        textView.setText(textView.getText() + "0");
    }

    public void onClickButtonOne(View view) {
        if (isDisplayValueNotActual) {
            textView.setText("");
            isDisplayValueNotActual = false;
        }
        textView.setText(textView.getText() + "1");
    }

    public void onClickButtonTwo(View view) {
        if (isDisplayValueNotActual) {
            textView.setText("");
            isDisplayValueNotActual = false;
        }
        textView.setText(textView.getText() + "2");
    }

    public void onClickButtonThree(View view) {
        if (isDisplayValueNotActual) {
            textView.setText("");
            isDisplayValueNotActual = false;
        }
        textView.setText(textView.getText() + "3");
    }

    public void onClickButtonFour(View view) {
        if (isDisplayValueNotActual) {
            textView.setText("");
            isDisplayValueNotActual = false;
        }
        textView.setText(textView.getText() + "4");
    }

    public void onClickButtonFive(View view) {
        if (isDisplayValueNotActual) {
            textView.setText("");
            isDisplayValueNotActual = false;
        }
        textView.setText(textView.getText() + "5");
    }

    public void onClickButtonSix(View view) {
        if (isDisplayValueNotActual) {
            textView.setText("");
            isDisplayValueNotActual = false;
        }
        textView.setText(textView.getText() + "6");
    }

    public void onClickButtonSeven(View view) {
        if (isDisplayValueNotActual) {
            textView.setText("");
            isDisplayValueNotActual = false;
        }
        textView.setText(textView.getText() + "7");
    }

    public void onClickButtonEight(View view) {
        if (isDisplayValueNotActual) {
            textView.setText("");
            isDisplayValueNotActual = false;
        }
        textView.setText(textView.getText() + "8");
    }

    public void onClickButtonNine(View view) {
        if (isDisplayValueNotActual) {
            textView.setText("");
            isDisplayValueNotActual = false;
        }
        textView.setText(textView.getText() + "9");
    }

    public void onClickButtonPoint(View view) {
        if (isDisplayValueNotActual) {
            textView.setText("");
            isDisplayValueNotActual = false;
        }
        if (!textView.getText().toString().contains(".")) {
            if (textView.getText().toString().isEmpty()) {
                textView.setText("0.");
            } else {
                textView.setText(textView.getText() + ".");
            }
        }
    }

    public void onClickButtonResult(View view) {
        if (!textView.getText().toString().isEmpty()) {
            if (!isDisplayValueNotActual) {
                valueStack.add(Double.valueOf(textView.getText().toString()));
                Double result = calculate(operationStack, valueStack);
                valueStack.add(result);
                textView.setText(result.toString());
            } else {
                Double result = calculate(operationStack, valueStack);
                valueStack.add(result);
                textView.setText(result.toString());
            }
            isDisplayValueNotActual = true;
        }
    }

    public void onClickButtonDel(View view) {
        operationStack.clear();
        valueStack.clear();
        textView.setText("");
        isDisplayValueNotActual = false;
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

    public void onClickPlusMinus(View view) {
        onOperationButtonClick(Operations.PLUS_MINUS);
    }

    private void onOperationButtonClick(Operations operation) {
        if (!textView.getText().toString().isEmpty()) {
            if (!isDisplayValueNotActual) {
                valueStack.add(Double.valueOf(textView.getText().toString()));
                if (valueStack.size() > 1) {
                    Double result = calculate(operationStack, valueStack);
                    valueStack.add(result);
                    textView.setText(result.toString());
                }
                operationStack.add(operation);
                if (operation == Operations.SIN
                        || operation == Operations.COS
                        || operation == Operations.TAN
                        || operation == Operations.LN
                        || operation == Operations.LOG
                        || operation == Operations.EXP
                        || operation == Operations.ROOT
                        || operation == Operations.PLUS_MINUS) {
                    if (valueStack.size() > 0) {
                        Double result = calculate(operationStack, valueStack);
                        valueStack.add(result);
                        textView.setText(result.toString());
                    }
                }
            } else {
                if (!operationStack.isEmpty()) {
                    ((LinkedList<Operations>) operationStack).set(operationStack.size() - 1, operation);
                } else {
                    operationStack.add(operation);
                }
                if (operation == Operations.SIN
                        || operation == Operations.COS
                        || operation == Operations.TAN
                        || operation == Operations.LN
                        || operation == Operations.LOG
                        || operation == Operations.EXP
                        || operation == Operations.ROOT
                        || operation == Operations.PLUS_MINUS) {
                    if (valueStack.size() > 0) {
                        Double result = calculate(operationStack, valueStack);
                        valueStack.add(result);
                        textView.setText(result.toString());
                    }
                }
            }
            isDisplayValueNotActual = true;
        }
    }

    private Double calculate(Queue<Operations> operationStack,Queue<Double> valueStack) {
        if (valueStack.isEmpty()) return 0.0;
        Double result = valueStack.poll();
        while (!operationStack.isEmpty()) {
            switch (operationStack.poll()) {
                case PLUS:
                    result += valueStack.isEmpty()?0.0:valueStack.poll();
                    break;
                case MINUS:
                    result -= valueStack.isEmpty()?0.0:valueStack.poll();
                    break;
                case DIVISION:
                    result /= valueStack.isEmpty()?1:valueStack.poll();
                    break;
                case MULTIPLICATION:
                    result *= valueStack.isEmpty()?1:valueStack.poll();
                    break;
                case INVOLUTION:
                    result = Math.pow(result, valueStack.isEmpty()?1:valueStack.poll());
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
            }
        }
        return result;
    }
}
