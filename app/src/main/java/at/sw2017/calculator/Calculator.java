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

    @Override
    public void onClick(View v) {
      Button clickedButton = (Button) v;
      switch(clickedButton.getId()){
          case R.id.buttonAdd:
              break;
          case R.id.buttonSubstract:
              break;
          case R.id.buttonMultiply:
              break;
          case R.id.buttonDivide:
              break;
          case R.id.buttonEqual:
              break;
          case R.id.buttonC:
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
