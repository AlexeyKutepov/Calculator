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
    private Queue<String> operationStack;
    private boolean isClear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textViewMain);
        operationStack = new LinkedList<>();
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
        if (isClear) {
            textView.setText("");
            isClear = false;
        }
        textView.setText(textView.getText() + "0");
    }

    public void onClickButtonOne(View view) {
        if (isClear) {
            textView.setText("");
            isClear = false;
        }
        textView.setText(textView.getText() + "1");
    }

    public void onClickButtonTwo(View view) {
        if (isClear) {
            textView.setText("");
            isClear = false;
        }
        textView.setText(textView.getText() + "2");
    }

    public void onClickButtonThree(View view) {
        if (isClear) {
            textView.setText("");
            isClear = false;
        }
        textView.setText(textView.getText() + "3");
    }

    public void onClickButtonFour(View view) {
        if (isClear) {
            textView.setText("");
            isClear = false;
        }
        textView.setText(textView.getText() + "4");
    }

    public void onClickButtonFive(View view) {
        if (isClear) {
            textView.setText("");
            isClear = false;
        }
        textView.setText(textView.getText() + "5");
    }

    public void onClickButtonSix(View view) {
        if (isClear) {
            textView.setText("");
            isClear = false;
        }
        textView.setText(textView.getText() + "6");
    }

    public void onClickButtonSeven(View view) {
        if (isClear) {
            textView.setText("");
            isClear = false;
        }
        textView.setText(textView.getText() + "7");
    }

    public void onClickButtonEight(View view) {
        if (isClear) {
            textView.setText("");
            isClear = false;
        }
        textView.setText(textView.getText() + "8");
    }

    public void onClickButtonNine(View view) {
        if (isClear) {
            textView.setText("");
            isClear = false;
        }
        textView.setText(textView.getText() + "9");
    }

    public void onClickButtonPoint(View view) {
        if (isClear) {
            textView.setText("");
            isClear = false;
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
        textView.setText(calculate());
    }

    public void onClickButtonDel(View view) {
        operationStack = new LinkedList<>();
        textView.setText("");
        isClear = false;
    }

    public void onClickButtonDivision(View view) {
        if (!textView.getText().toString().isEmpty()) {
            operationStack.add(textView.getText().toString());
            isClear = true;
            operationStack.add(Operations.DIVISION.toString());
        }
    }

    public void onClickButtonMultiplication(View view) {
        if (!textView.getText().toString().isEmpty()) {
            operationStack.add(textView.getText().toString());
            isClear = true;
            operationStack.add(Operations.MULTIPLICATION.toString());
        }
    }

    public void onClickButtonMinus(View view) {
        if (!textView.getText().toString().isEmpty()) {
            operationStack.add(textView.getText().toString());
            isClear = true;
            operationStack.add(Operations.MINUS.toString());
        }
    }

    public void onClickButtonPlus(View view) {
        if (!textView.getText().toString().isEmpty()) {
            operationStack.add(textView.getText().toString());
            isClear = true;
            operationStack.add(Operations.PLUS.toString());
        }
    }

    private String calculate() {
        Double result = 0.0;
//        while (!operationStack.isEmpty()) {
//
//        }
        operationStack = new LinkedList<>();
        isClear = true;
        operationStack.add(result.toString());
        return result.toString();
    }
}
