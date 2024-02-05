package edu.uph.duaduasi.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_layout);

        LinearLayout linearLayout = findViewById(R.id.yourLinearLayout);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event
                // Start a new activity when the LinearLayout is clicked
                Intent intent = new Intent(YourActivity.this, FormIdentityActivity.class);
                startActivity(intent);
            }
        });
    }
}