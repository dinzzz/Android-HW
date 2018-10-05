package hr.fer.dino.bozic.opjj1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

/**
 * Show activity.
 */
public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        String reza = getIntent().getExtras().getString("reza");

        Toast.makeText(this, reza, Toast.LENGTH_LONG).show();

        EditText input = findViewById(R.id.input_text);
        Button btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(view -> {

        });


    }
}
