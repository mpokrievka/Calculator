package at.sw2017.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Calculator extends Activity implements View.OnClickListener {
   // private Button buttonZero, buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix,
   //         buttonSeven, buttonEight, buttonNine;
    private Button buttonAdd, buttonSubstract, buttonMultiply, buttonDivide, buttonEqual;
    private Button buttonC;
    private TextView numberView;
    private ArrayList<Button> numberButtons = new ArrayList<Button>();
    private int firstNumber = 0;

    private enum State{
        ADD, SUB, MUL, DIV, INIT
    }
    State state = State.INIT;

    public void setUpNumberButtonListener(){
        for(int i = 0; i<=9; i++){
            String buttonName = "button" + i;

            int id = getResources().getIdentifier(buttonName, "id", R.class.getPackage().getName());

            Button button = (Button) findViewById(id);
            button.setOnClickListener(this);

            numberButtons.add(button);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSubstract = (Button) findViewById(R.id.buttonSubstract);
        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonC = (Button) findViewById(R.id.buttonC);

        buttonAdd.setOnClickListener(this);
        buttonSubstract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonC.setOnClickListener(this);

        setUpNumberButtonListener();

        numberView = (TextView) findViewById(R.id.textView);
    }

    private void clearTextView(){
        numberView.setText("0");
        firstNumber = 0;
        state = State.INIT;
    }

    private void clearNumberView(){
        String tempString = numberView.getText().toString();
        if(!tempString.equals("")){
            firstNumber = Integer.valueOf(tempString);
        }
        numberView.setText("");
    }

    private void calculateResult(){
        int secondNumber = 0;
        String tempString = numberView.getText().toString();
        if(!tempString.equals("")){
            secondNumber = Integer.valueOf(tempString);
        }

        int result;
        switch(state){
            case ADD:
                result = Calculations.doAddition(firstNumber, secondNumber);
                break;
            case SUB:
                result = Calculations.doSubtraction(firstNumber, secondNumber);
                break;
            case MUL:
                result = Calculations.doMultiplication(firstNumber, secondNumber);
                break;
            case DIV:
                result = Calculations.doDivision(firstNumber, secondNumber);
                break;
            default:
                result = secondNumber;
        }
        numberView.setText(Integer.toString(result));
    }

    @Override
    public void onClick(View v) {
      Button clickedButton = (Button) v;
      switch(clickedButton.getId()){
          case R.id.buttonAdd:
              clearNumberView();
              state = State.ADD;
              break;
          case R.id.buttonSubstract:
              clearNumberView();
              state = State.SUB;
              break;
          case R.id.buttonMultiply:
              clearNumberView();
              state = State.MUL;
              break;
          case R.id.buttonDivide:
              clearNumberView();
              state = State.DIV;
              break;
          case R.id.buttonEqual:
              calculateResult();
              state = State.INIT;
              break;
          case R.id.buttonC:
              clearTextView();
              break;
          default:
              String recentNumber = numberView.getText().toString();

              if(recentNumber.equals("0")){
                  recentNumber = "";
              }
              recentNumber += clickedButton.getText().toString();
              numberView.setText(recentNumber);
      }

    }
}
