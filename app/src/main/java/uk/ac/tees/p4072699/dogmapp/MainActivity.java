package uk.ac.tees.p4072699.dogmapp;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
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
    Toast t;
    ImageButton p1;
    ImageButton p2;
    ImageButton p3;
    ImageButton p4;
    ImageButton p5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context con = this;
        final Button save = (Button) findViewById(R.id.button_save);
        final EditText com = (EditText) findViewById(R.id.editText);

        p1 = (ImageButton) findViewById(R.id.paw_1);
        p2 = (ImageButton) findViewById(R.id.paw_2);
        p3 = (ImageButton) findViewById(R.id.paw_3);
        p4 = (ImageButton) findViewById(R.id.paw_4);
        p5 = (ImageButton) findViewById(R.id.paw_5);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comments = com.getText().toString();
                dh.add(new Walk("TEST", "2KM", paws));
                Intent intent = new Intent(con, HomeActivity.class);
                startActivity(intent);
            }
        });

        p1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                paws = 1;
                //t = Toast.makeText(getApplicationContext(), "You have selected 1 paws", Toast.LENGTH_SHORT);
                //t.show();
                p1.setImageResource(R.drawable.selected);
                p2.setImageResource(R.drawable.paw);
                p3.setImageResource(R.drawable.paw);
                p4.setImageResource(R.drawable.paw);
                p5.setImageResource(R.drawable.paw);
            }
        });


        p2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                paws = 2;
                //t = Toast.makeText(getApplicationContext(), "You have selected 2 paws", Toast.LENGTH_SHORT);
                //t.show();
                p2.setImageResource(R.drawable.selected);
                p1.setImageResource(R.drawable.selected);
                p3.setImageResource(R.drawable.paw);
                p4.setImageResource(R.drawable.paw);
                p5.setImageResource(R.drawable.paw);
            }
        });

        p3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                paws = 3;
                //t = Toast.makeText(getApplicationContext(), "You have selected 3 paws", Toast.LENGTH_SHORT);
                //t.show();
                p3.setImageResource(R.drawable.selected);
                p2.setImageResource(R.drawable.selected);
                p1.setImageResource(R.drawable.selected);
                p4.setImageResource(R.drawable.paw);
                p5.setImageResource(R.drawable.paw);

            }
        });

        p4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                paws = 4;
                //t = Toast.makeText(getApplicationContext(), "You have selected 4 paws", Toast.LENGTH_SHORT);
                //t.show();
                p4.setImageResource(R.drawable.selected);
                p2.setImageResource(R.drawable.selected);
                p3.setImageResource(R.drawable.selected);
                p1.setImageResource(R.drawable.selected);
                p5.setImageResource(R.drawable.paw);
            }
        });

        p5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                paws = 5;
                //t = Toast.makeText(getApplicationContext(), "You have selected 5 paws", Toast.LENGTH_SHORT);
                //t.show();
                p5.setImageResource(R.drawable.selected);
                p2.setImageResource(R.drawable.selected);
                p3.setImageResource(R.drawable.selected);
                p4.setImageResource(R.drawable.selected);
                p1.setImageResource(R.drawable.selected);
            }
        });
    }


}



