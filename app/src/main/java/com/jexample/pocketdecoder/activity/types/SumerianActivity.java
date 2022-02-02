package com.jexample.pocketdecoder.activity.types;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;

import com.jexample.pocketdecoder.R;
import com.jexample.pocketdecoder.databinding.ActivitySumerianBinding;
import com.jexample.pocketdecoder.utils.Constants;
import com.jexample.pocketdecoder.utils.tables.SumerianTable;

public class SumerianActivity extends AppCompatActivity {
    private static final String TAG = "SumerianActivity";
    private Activity activity = SumerianActivity.this;
    private ActivitySumerianBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sumerian);
        setData();
    }

    private void setData() {
        if (getIntent() != null) {
            if (getIntent().hasExtra(Constants.KEY_WORD)) {
                String word = getIntent().getStringExtra(Constants.KEY_WORD);
                binding.tvWord.setText(word);
                binding.tvEquation.setText(
                        SumerianTable.getInstance().getSumerianEquation(word)
                );
                binding.tvResult.setText(
                        SumerianTable.getInstance().getSumerianResult(word)
                );
            }
        }
    }
}