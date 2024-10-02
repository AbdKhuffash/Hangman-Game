package com.example.a1200970_abd_khuffash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText fName=findViewById(R.id.fName);
        EditText lName=findViewById(R.id.lName);
        EditText Id=findViewById(R.id.Id);
        TextView Alert=findViewById(R.id.AlertTextView);

        Button Start=findViewById(R.id.startGame);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User newUser=new User();
                boolean flag=true;

                if(fName.getText().toString().isEmpty()) {
                    Alert.setText("Please Fill All Fields");
                    flag=false;
                }
                else
                    newUser.setfName(fName.getText().toString());

                if(lName.getText().toString().isEmpty()) {
                    Alert.setText("Please Fill All Fields");
                    flag=false;
                }
                else
                    newUser.setlName(lName.getText().toString());

                if(Id.getText().toString().isEmpty()) {
                    Alert.setText("Please Fill All Fields");
                    flag=false;
                }
                else
                    newUser.setId(Integer.parseInt(Id.getText().toString()));

                if(flag){
                    Intent intent=new Intent(MainActivity.this,HungmanActivity.class);
                    intent.putExtra("user", newUser);
                    MainActivity.this.startActivity(intent);
                    finish();
                }
            }
        });

    }
}