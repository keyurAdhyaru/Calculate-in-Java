package io.dreamdreamdevelopers.calculatorjava;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtZero;
    TextView txtOne;
    TextView txtTwo;
    TextView txtThree;
    TextView txtFour;
    TextView txtFive;
    TextView txtSix;
    TextView txtSeven;
    TextView txtEight;
    TextView txtNine;
    TextView txtDot;
    TextView txtPlus;
    TextView txtMinus;
    TextView txtMultiply;
    TextView txtDivide;
    TextView txtOpen;
    TextView txtClose;
    TextView txtClear;
    ImageView imgBack;
    TextView txtEquals;
    TextView txtResult;
    TextView txtExpression;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        txtResult.setOnClickListener(this);
        txtExpression.setOnClickListener(this);
        txtOne.setOnClickListener(this);
        txtTwo.setOnClickListener(this);
        txtThree.setOnClickListener(this);
        txtFour.setOnClickListener(this);
        txtFive.setOnClickListener(this);
        txtSix.setOnClickListener(this);
        txtSeven.setOnClickListener(this);
        txtEight.setOnClickListener(this);
        txtNine.setOnClickListener(this);
        txtZero.setOnClickListener(this);
        txtEquals.setOnClickListener(this);
        txtDot.setOnClickListener(this);
        txtClose.setOnClickListener(this);
        txtClear.setOnClickListener(this);
        txtOpen.setOnClickListener(this);
        txtPlus.setOnClickListener(this);
        txtMultiply.setOnClickListener(this);
        txtMinus.setOnClickListener(this);
        txtDivide.setOnClickListener(this);
    }

    void appendString(String data, Boolean cancheck) {
        if (!txtResult.getText().toString().isEmpty()) {
            txtExpression.setText("");
        }

        if (cancheck) {
            txtResult.setText("");
            txtExpression.append(data);
        } else {
            txtExpression.append(txtResult.getText());
            txtExpression.append(data);
            txtResult.setText("");
        }
    }

    void init() {
        txtZero = findViewById(R.id.tvZero);
        txtOne = findViewById(R.id.tvOne);
        txtTwo = findViewById(R.id.tvTwo);
        txtThree = findViewById(R.id.tvThree);
        txtFour = findViewById(R.id.tvFour);
        txtFive = findViewById(R.id.tvFive);
        txtSix = findViewById(R.id.tvSix);
        txtSeven = findViewById(R.id.tvSeven);
        txtEight = findViewById(R.id.tvEight);
        txtNine = findViewById(R.id.tvNine);

        txtPlus = findViewById(R.id.tvPlus);
        txtMinus = findViewById(R.id.tvMinus);
        txtMultiply = findViewById(R.id.tvMul);
        txtDivide = findViewById(R.id.tvDivide);
        txtDot = findViewById(R.id.tvDot);

        imgBack = findViewById(R.id.tvBack);
        txtEquals = findViewById(R.id.tvEquals);
        txtClear = findViewById(R.id.tvClear);
        txtOpen = findViewById(R.id.tvOpen);
        txtClose = findViewById(R.id.tvClose);

        txtResult = findViewById(R.id.tvResult);
        txtExpression = findViewById(R.id.tvExpression);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvZero:
                appendString("0", true);
                break;
            case R.id.tvOne:
                appendString("1", true);
                break;
            case R.id.tvTwo:
                appendString("2", true);
                break;
            case R.id.tvThree:
                appendString("3", true);
                break;
            case R.id.tvFour:
                appendString("4", true);
                break;
            case R.id.tvFive:
                appendString("5", true);
                break;
            case R.id.tvSix:
                appendString("6", true);
                break;
            case R.id.tvSeven:
                appendString("7", true);
                break;
            case R.id.tvEight:
                appendString("8", true);
                break;
            case R.id.tvNine:
                appendString("9", true);
                break;
            case R.id.tvDot:
                appendString(".", true);
                break;
            case R.id.tvPlus:
                appendString("+", false);
                break;
            case R.id.tvMinus:
                appendString("-", false);
                break;
            case R.id.tvMul:
                appendString("*", false);
                break;
            case R.id.tvDivide:
                appendString("/", false);
                break;
            case R.id.tvOpen:
                appendString("(", false);
                break;
            case R.id.tvClose:
                appendString(")", false);
                break;

            case R.id.tvClear:
                txtResult.setText("");
                txtExpression.setText("");
                break;
            case R.id.tvBack:
                String str = txtExpression.getText().toString();
                if (!str.isEmpty()) {
                    txtExpression.setText(str.substring(0, str.length() - 1));
                }
                txtResult.setText("");
                break;
            case R.id.tvEquals:
                try{
                ExpressionBuilder expressionBuilder = new ExpressionBuilder(txtExpression.getText().toString());
                Double result = expressionBuilder.build().evaluate();
                txtResult.setText(result.toString());
                }catch (Exception e){
                    Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
        }
    }
}