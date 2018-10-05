package hr.fer.dino.bozic.opjj1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Activity which composes an email based on the provided data.
 */
public class ComposeMailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_mail);

        Button send_mail = findViewById(R.id.send_mail);
        send_mail.setOnClickListener(view -> {
            EditText receiver = findViewById(R.id.receiver);
            EditText subject = findViewById(R.id.subject);
            EditText body = findViewById(R.id.body);

            if(body.getText().toString().isEmpty() || subject.getText().toString().isEmpty() || receiver.getText().toString().isEmpty()){
                Toast.makeText(this, R.string.missing, Toast.LENGTH_LONG).show();
                return;
            }

            if(!Character.isUpperCase(subject.getText().toString().charAt(0))){
                Toast.makeText(this, R.string.uppercase, Toast.LENGTH_LONG).show();
                return;
            }

            String mailData =
                    "mailto:" + Uri.encode(receiver.getText().toString()) +
                    "?cc=marcupic@gmail.com, ana@baotic.org" +
                    "&subject=" + Uri.encode(subject.getText().toString()) +
                    "&body=" + Uri.encode(body.getText().toString());

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse(mailData));

            try{
                startActivity(emailIntent);
                this.finish();
            } catch(ActivityNotFoundException e){

            }
        });
    }
}
