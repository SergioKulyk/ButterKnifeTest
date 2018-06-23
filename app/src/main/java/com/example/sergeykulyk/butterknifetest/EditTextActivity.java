package com.example.sergeykulyk.butterknifetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class EditTextActivity extends AppCompatActivity {

    private static final String TAG = EditTextActivity.class.getSimpleName();

    @BindView(R.id.textView2)
    TextView textView2;

    @OnTextChanged(value = R.id.editText, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Log.v(TAG, "before: " + s + " " + start + " " + count + " " + after);
    }

    @OnTextChanged(value = R.id.editText, callback = OnTextChanged.Callback.TEXT_CHANGED)
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.v(TAG, "on: " + s + " " + start + " " + before + " " + count);

    }

    @OnTextChanged(value = R.id.editText, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    public void afterTextChanged(Editable s) {
        Log.v(TAG, "after: " + s.toString());
    }

    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.editText3)
    EditText editText3;
    @BindView(R.id.editText4)
    EditText editText4;
    @BindView(R.id.editText5)
    EditText editText5;
    @BindView(R.id.editText6)
    EditText editText6;
    @BindView(R.id.autoCompleteTextView)
    AutoCompleteTextView autoCompleteTextView;

    @BindViews({R.id.editText, R.id.editText2, R.id.editText3, R.id.editText4})
    List<EditText> editTextList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        ButterKnife.bind(this);

        final StringBuilder builder;
        builder = new StringBuilder();

        ButterKnife.Action<EditText> getText = (view, index) -> builder.append(index).append(". ").append(view.getText().toString());

        ButterKnife.apply(editTextList, getText);

        ButterKnife.Setter<TextView, String> setText = (view, value, index) -> view.setText(value);

        ButterKnife.apply(textView2, setText, builder.toString());
    }
}
