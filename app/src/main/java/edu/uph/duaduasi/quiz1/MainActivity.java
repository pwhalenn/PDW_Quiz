package edu.uph.duaduasi.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout profilBox, todoBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profilBox = (LinearLayout) findViewById(R.id.profilBox);
        profilBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IdentityActivity.class);
                startActivity(intent);
            }
        });

        todoBox = (LinearLayout) findViewById(R.id.todoBox);
        todoBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);
            }
        });
    }
}