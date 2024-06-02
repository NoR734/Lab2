package com.example.lab2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnTextEnteredListener {
    private EditViewFragment editViewFragment;
    private TextViewFragment textViewFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editViewFragment = new EditViewFragment();
        textViewFragment = new TextViewFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView2, editViewFragment)
                .replace(R.id.fragmentContainerView, textViewFragment)
                .commit();

        editViewFragment.setOnTextEnteredListener(this);
    }

    @Override
    public void onTextEntered(String text) {
        textViewFragment.displayText(text);
    }
}