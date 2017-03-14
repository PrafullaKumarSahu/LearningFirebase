package com.android.serverwarrior.learningfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView mTextFieldCondition;
    Button mSunnyButton;
    Button mFuggyButton;
    Firebase firebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        mTextFieldCondition = (TextView) findViewById(R.id.textViewCondition);
        mSunnyButton = (Button) findViewById(R.id.sunnyButton);
        mFuggyButton = (Button) findViewById(R.id.fuggyButton) ;
        firebaseRef = new Firebase("https://incandescent-inferno-7388.firebaseio.com/condition");

        firebaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mTextFieldCondition.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mSunnyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseRef.setValue("Sunny");
            }
        });

        mFuggyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                firebaseRef.setValue("Foggy");
            }
        });

  /*       firebaseRef.createUser("prafulla@indibits.com", "correcthorsebatterystaple", new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                System.out.println("Successfully created user account with uid: " + result.get("uid"));
            }
            @Override
            public void onError(FirebaseError firebaseError) {
                // there was an error
            }
        }); */
    }
}
