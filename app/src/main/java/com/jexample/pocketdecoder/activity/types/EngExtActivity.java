package com.jexample.pocketdecoder.activity.types;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jexample.pocketdecoder.R;
import com.jexample.pocketdecoder.databinding.ActivityEngExtBinding;
import com.jexample.pocketdecoder.databinding.ActivitySumerianBinding;
import com.jexample.pocketdecoder.utils.Constants;
import com.jexample.pocketdecoder.utils.tables.EngExtTable;
import com.jexample.pocketdecoder.utils.tables.SumerianTable;

public class EngExtActivity extends AppCompatActivity {

    private static final String TAG = "EngExtActivity";
    private Activity activity = EngExtActivity.this;
    private ActivityEngExtBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_eng_ext);
        setData();
    }

    private void setData() {
        if (getIntent() != null) {
            if (getIntent().hasExtra(Constants.KEY_WORD)) {
                String word = getIntent().getStringExtra(Constants.KEY_WORD);
                binding.tvWord.setText(word);
                binding.tvEquation.setText(
                        EngExtTable.getInstance().getEngExtEquation(word)
                );
                binding.tvResult.setText(
                        EngExtTable.getInstance().getEngExtResult(word)
                );
            }
        }
    }
}