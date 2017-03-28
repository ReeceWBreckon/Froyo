package uk.ac.tees.p4072699.dogmapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler dh = new DatabaseHandler(this);
    int paws;
    String comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context con = this;
        final Button save = (Button) findViewById(R.id.button_save);
        final EditText com = (EditText) findViewById(R.id.editText);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comments = com.getText().toString();
                dh.add(new Walk("TEST","2KM", paws));
                Intent intent = new Intent(con, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void paw1(View view) {
        paws = 1;
    }

    public void paw2(View view) {
        paws = 2;
    }

    public void paw3(View view) {
        paws = 3;
    }

    public void paw4(View view) {
        paws = 4;
    }

    public void paw5(View view) {
        paws = 5;
    }
}