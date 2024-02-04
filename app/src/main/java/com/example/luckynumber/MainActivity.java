package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText editText;
TextView textView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn);
        editText=findViewById(R.id.edit_text);
        textView=findViewById(R.id.textView);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String name=editText.getText().toString();
        Intent intent=new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }
});
    }
}