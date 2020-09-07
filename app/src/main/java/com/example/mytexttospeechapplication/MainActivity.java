package com.example.mytexttospeechapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText textSpeech;
    Button btn_speechText;
    TextToSpeech toSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSpeech=(EditText) findViewById(R.id.TextForSpeech);
        btn_speechText=(Button) findViewById(R.id.btn_speech);

        toSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    toSpeech.setLanguage(Locale.UK);
                }
            }
        });

        btn_speechText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toSpeech.speak(textSpeech.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }

        });
    }
}