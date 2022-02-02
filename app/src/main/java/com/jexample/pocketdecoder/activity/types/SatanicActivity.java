package com.jexample.pocketdecoder.activity.types;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jexample.pocketdecoder.R;
import com.jexample.pocketdecoder.databinding.ActivitySatanicBinding;
import com.jexample.pocketdecoder.databinding.ActivitySumerianBinding;
import com.jexample.pocketdecoder.utils.Constants;
import com.jexample.pocketdecoder.utils.tables.SatanicTable;
import com.jexample.pocketdecoder.utils.tables.SumerianTable;

public class SatanicActivity extends AppCompatActivity {
    private static final String TAG = "SatanicActivity";
    private Activity activity = SatanicActivity.this;
    private ActivitySatanicBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_satanic);
        setData();
    }

    private void setData() {
        if (getIntent() != null) {
            if (getIntent().hasExtra(Constants.KEY_WORD)) {
                String word = getIntent().getStringExtra(Constants.KEY_WORD);
                binding.tvWord.setText(word);
                binding.tvEquation.setText(
                        SatanicTable.getInstance().getSatanicEquation(word)
                );
                binding.tvResult.setText(
                        SatanicTable.getInstance().getEngExtResult(word)
                );
            }
        }
    }
}