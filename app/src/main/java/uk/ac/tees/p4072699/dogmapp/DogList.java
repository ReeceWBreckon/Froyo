package uk.ac.tees.p4072699.dogmapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.Arrays;
import java.util.List;

public class DogList extends AppCompatActivity {
    DatabaseHandler dh = new DatabaseHandler(this);
    int selected;
    String[] dogs = {};
    Integer[] dogsId = {};
    Owner owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_list);

        final Context con = this;
        final Button home = (Button) findViewById(R.id.button_home);
        final Button add = (Button) findViewById(R.id.button_add);
        final Button rem = (Button) findViewById(R.id.button_remove);

        owner = (Owner)getIntent().getSerializableExtra("owner");

        List<Dog> list = dh.getAllDogs(owner.getId());


        for (Dog dg : list) {
            dogs = Arrays.copyOf(dogs, dogs.length + 1);

            Cursor cID = dh.getReadableDatabase().rawQuery("SELECT * FROM " + dh.getOwnerLogintable()
                    + " WHERE " + dh.getColId() + "=?",new String[]{Integer.toString(dg.getOwnerID())});

            dogs[dogs.length - 1] = "Name: " + dg.getName() +"\nOwner: " + dh.getOneOwner(cID).getName();
            dogsId = Arrays.copyOf(dogsId, dogsId.length + 1);
            dogsId[dogsId.length - 1] = dg.getId();
    }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dogs);

        final ListView listView = (ListView) findViewById(R.id.lv_dgs);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected = dogsId[position];
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(con, Home.class);
                intent.putExtra("owner",owner);
                startActivity(intent);
            }
        });

        rem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dh.removeDog(selected);
                Intent intent = new Intent(con, DogList.class);
                intent.putExtra("owner",owner);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(con, AddDogActivity.class);
                intent.putExtra("owner",owner);
                startActivity(intent);
            }
        });
    }
}