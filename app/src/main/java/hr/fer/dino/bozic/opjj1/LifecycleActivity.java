package hr.fer.dino.bozic.opjj1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activity which represents a home screen of the application.
 */
public class LifecycleActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        Log.d("Lifecycle",  " onCreate.");
        result = findViewById(R.id.label_result);

        Button btnCalculate = findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(view -> {
            EditText inputFirst = findViewById(R.id.input_first);
            EditText inputSecond = findViewById(R.id.input_second);


            String first = inputFirst.getText().toString();
            String second = inputSecond.getText().toString();
            int firstNum = 0;
            int secondNum = 0;

            try {
                firstNum = Integer.parseInt(first);
            } catch(NumberFormatException ignored){
            }

            try {
                secondNum = Integer.parseInt(second);
            } catch(NumberFormatException ignored){
            }

            if(secondNum != 0) {
                result.setText(String.valueOf(firstNum / secondNum));
            }
            else{
                result.setText(R.string.zbzb);
            }


        });

        Button btnSend = findViewById(R.id.btn_send);
        btnSend.setOnClickListener(view ->{
            Intent intent = new Intent(LifecycleActivity.this, ShowActivity.class);


            Bundle data = new Bundle();
            data.putString("reza", result.getText().toString());
            intent.putExtras(data);
            startActivity(intent);
        });

        Button btnMail = findViewById(R.id.btn_mail);
        btnMail.setOnClickListener(view ->{
            Intent intent = new Intent(LifecycleActivity.this, ComposeMailActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(  "Lifecycle",  "OnPause");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(  "Lifecycle",  "OnResume");
    }
}
