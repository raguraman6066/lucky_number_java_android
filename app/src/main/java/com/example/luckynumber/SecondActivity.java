package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
TextView welcomeText,luckynumberText;
Button share_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        welcomeText=findViewById(R.id.tv1);
        luckynumberText=findViewById(R.id.tv2);
        share_btn=findViewById(R.id.share_btn);
//get data
        Intent intent=getIntent();
        String userName=intent.getStringExtra("name");
        //number
     int random_num=generateRandomNumber();
     luckynumberText.setText(""+random_num);
     share_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        shareData(userName,random_num);
    }
});


    }

    public void shareData(String userName,int randomNumber){
        Intent i=new Intent(Intent.ACTION_SEND);//share content to other apps
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,userName+" got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is: "+randomNumber);
        startActivity(Intent.createChooser(i,"Choose a platform"));
    }


    public int generateRandomNumber(){
        Random random=new Random();
        int upper_limit=1000;
        int randomNumberGenerated=random.nextInt(upper_limit);
        return randomNumberGenerated;

    }
}