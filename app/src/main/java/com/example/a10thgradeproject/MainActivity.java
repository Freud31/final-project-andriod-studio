package com.example.a10thgradeproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView appTitle;
    private EditText userInput;
    private Button submitButton;
    private ImageView image1;
    private TextView uniqAboutMe;
    private ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.userInput);
        submitButton = findViewById(R.id.submitButton);
        //image1 = findViewById(R.id.imageView);
        uniqAboutMe = findViewById(R.id.uniqAboutMe);
        imageButton = findViewById(R.id.imageButton);

        boolean[] isFirstImage = {true};

        //image1.setVisibility(View.GONE);
        uniqAboutMe.setVisibility(View.GONE);
        imageButton.setVisibility(View.GONE);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = userInput.getText().toString();
                Toast.makeText(MainActivity.this, "Hello "+input, Toast.LENGTH_SHORT).show();

                userInput.setVisibility(View.GONE);
                submitButton.setVisibility(View.GONE);
                uniqAboutMe.setVisibility(View.VISIBLE);
                imageButton.setVisibility(View.VISIBLE);

            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFirstImage[0]) {
                    imageButton.setImageResource(R.drawable.volleyball2);
                } else {
                    imageButton.setImageResource(R.drawable.volleyball);
                }
                isFirstImage[0] = !isFirstImage[0];
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}