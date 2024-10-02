package com.example.a1200970_abd_khuffash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HungmanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hungman);

        TextView UserData=findViewById(R.id.UserData);

        User user = (User) getIntent().getSerializableExtra("user");

        UserData.setText(user.toString());


        String Word="birzeit";
        final StringBuilder currentProgress = new StringBuilder("-------");

        TextView FeedBack= findViewById(R.id.FeedBack);
        TextView Hungman=findViewById(R.id.Hungman);
        TextView Progress=findViewById(R.id.progress);
        Progress.setText(currentProgress.toString());

        Hungman.setText("");
        Hungman.setVisibility(View.VISIBLE);

        EditText Letter1=findViewById(R.id.Letter1);
        EditText Letter2= findViewById(R.id.Letter2);
        EditText Letter3= findViewById(R.id.Letter3);
        EditText Letter4= findViewById(R.id.Letter4);
        EditText Letter5= findViewById(R.id.Letter5);
        EditText Letter6= findViewById(R.id.Letter6);
        EditText Letter7= findViewById(R.id.Letter7);

        Button Submit =findViewById(R.id.Submit);
        Button Restart=findViewById(R.id.Restart);

        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hungman.setText("");
                Letter1.setText("");
                Letter2.setText("");
                Letter3.setText("");
                Letter4.setText("");
                Letter5.setText("");
                Letter6.setText("");
                Letter7.setText("");
                FeedBack.setText("");
                Progress.setText("-------");
                currentProgress.setLength(0);
                currentProgress.append("-------");
                user.setTries(6);
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String letter1 = Letter1.getText().toString().isEmpty() ? "-" : Letter1.getText().toString();
                String letter2 = Letter2.getText().toString().isEmpty() ? "-" : Letter2.getText().toString();
                String letter3 = Letter3.getText().toString().isEmpty() ? "-" : Letter3.getText().toString();
                String letter4 = Letter4.getText().toString().isEmpty() ? "-" : Letter4.getText().toString();
                String letter5 = Letter5.getText().toString().isEmpty() ? "-" : Letter5.getText().toString();
                String letter6 = Letter6.getText().toString().isEmpty() ? "-" : Letter6.getText().toString();
                String letter7 = Letter7.getText().toString().isEmpty() ? "-" : Letter7.getText().toString();

                String guessedWord = letter1 + letter2 + letter3 + letter4 + letter5 + letter6 + letter7;


                if(guessedWord.replace("-","").isEmpty())
                    FeedBack.setText("Please Enter A word :|");
                else{
                    if (guessedWord.equalsIgnoreCase(Word)) {
                        FeedBack.setText("Congratulations,"+user.getfName()+" "+user.getlName()+"! You guessed the word.");
                        Hungman.setText("");
                        Progress.setText(Word);
                        user.setTries(6);
                        //finish();

                    } else
                    {
                        user.setTries(user.getTries()-1);

                        switch(user.getTries())
                        {
                            case 5:
                                Hungman.setText("O");
                                FeedBack.setText("Sorry,"+user.getfName()+" "+user.getlName()+". You Lost your Head.");
                                break;
                            case 4:
                                Hungman.setText("O\n|");
                                FeedBack.setText("Sorry,"+user.getfName()+" "+user.getlName()+". You Lost your body.");
                                break;
                            case 3:
                                Hungman.setText("O\n|\\");
                                FeedBack.setText("Sorry,"+user.getfName()+" "+user.getlName()+". You Lost your right arm.");
                                break;
                            case 2:
                                Hungman.setText("O\n/|\\");
                                FeedBack.setText("Sorry,"+user.getfName()+" "+user.getlName()+". You Lost your left arm.");
                                break;
                            case 1:
                                Hungman.setText("O\n/|\\\n \\");
                                FeedBack.setText("Sorry,"+user.getfName()+" "+user.getlName()+". You Lost your right leg.");

                                break;
                            case 0:
                                Hungman.setText("O\n/|\\\n/ \\");
                                FeedBack.setText("Sorry,"+user.getfName()+" "+user.getlName()+". You Lost your left leg and lost the Game.");

                                break;

                        }

                        for (int i = 0; i < Word.length(); i++) {
                            if (Character.toLowerCase(guessedWord.charAt(i)) == Character.toLowerCase(Word.charAt(i))) {
                                currentProgress.setCharAt(i, Word.charAt(i));
                            }
                        }
                        Progress.setText(currentProgress.toString());
                        //finish();
                    }
                }




            }
        });




    }
}