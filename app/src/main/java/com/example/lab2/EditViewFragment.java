package com.example.lab2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EditViewFragment extends Fragment {

    private EditText editText;
    private OnTextEnteredListener textEnteredListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editview, container, false);
        editText = view.findViewById(R.id.editText);

        Button btnEditText = view.findViewById(R.id.editTextButton);
        btnEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = editText.getText().toString();
                if (textEnteredListener != null) {
                    textEnteredListener.onTextEntered(enteredText);
                }
                editText.setText("");
            }
        });
        return view;
    }

    public void setOnTextEnteredListener(OnTextEnteredListener listener) {
        textEnteredListener = listener;
    }
}