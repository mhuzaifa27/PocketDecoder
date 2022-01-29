package com.jexample.pocketdecoder.activity.types;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;

import com.jexample.pocketdecoder.R;
import com.jexample.pocketdecoder.databinding.ActivityChaldeanBinding;
import com.jexample.pocketdecoder.databinding.ActivitySumerianBinding;
import com.jexample.pocketdecoder.utils.Constants;
import com.jexample.pocketdecoder.utils.tables.ChaldeanTable;
import com.jexample.pocketdecoder.utils.tables.SumerianTable;

public class ChaldeanActivity extends AppCompatActivity {

    private static final String TAG = "ChaldeanActivity";
    private Activity activity = ChaldeanActivity.this;
    private ActivityChaldeanBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chaldean);
        setData();
    }

    private void setData() {
        if (getIntent() != null) {
            if (getIntent().hasExtra(Constants.KEY_WORD)) {
                String word = getIntent().getStringExtra(Constants.KEY_WORD);
                binding.tvWord.setText(word);
                binding.tvEquation.setText(
                        ChaldeanTable.getInstance().getChaldeanEquation(word)
                );
            }
        }
    }
}