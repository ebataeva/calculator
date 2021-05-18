package com.lena.geek.calc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lena.geek.calc.Calc;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "My Calc";
    private TextView textViewEquals;
    private TextView text;
    private Calc calculator;
    private static String keyCalc = "Calc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        calculator = new Calc();
        int[] buttonIds = new int[]{
                R.id.button_0,
                R.id.button_1,
                R.id.button_2,
                R.id.button_3,
                R.id.button_4,
                R.id.button_5,
                R.id.button_6,
                R.id.button_7,
                R.id.button_8,
                R.id.button_9,
                R.id.button_plus,
                R.id.button_minus,
                R.id.button_multiply,
                R.id.button_equals,
                R.id.button_clear,
                R.id.button_divide,
                R.id.button_point
        };
        init_view();
        for (final int id : buttonIds) {
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("button+", String.valueOf(id));
                    calculator.onClick(id);
                    text.setText(calculator.getText());
                    Log.d("calculator", calculator.getText());
                    Log.d("first arg", calculator.getFirstArg());
                    Log.d("calc:operation", calculator.getOperation());

                }
            });
        }

        findViewById(R.id.button_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculator.getFirstArg() != null && calculator.getSecondArg() != null) {
                    Log.d("calc:second Arg", calculator.getSecondArg());
                    Log.d("calc:equals", calculator.equals());
                    textViewEquals.setText(calculator.equals());
                    calculator.setFirstArg((int) calculator.equals);
                    calculator.setIsOperatorSelected(false);
                }

            }
        });

//        findViewById(R.id.button_point).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "это действие недоступно", Toast.LENGTH_SHORT ).show();
//            }
//        });
    }

    ;

    public void init_view() {
        textViewEquals = findViewById(R.id.equalsText);
        text = findViewById(R.id.text);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator = (Calc) savedInstanceState.getSerializable(keyCalc);
        text.setText(calculator.getText());
        textViewEquals.setText(calculator.equals());
        Log.d(TAG, "onRestore");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "on Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "on Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "on Destroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putSerializable(keyCalc, calculator);
        super.onSaveInstanceState(saveInstanceState);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
