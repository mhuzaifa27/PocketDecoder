package com.jexample.pocketdecoder.activity.types;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jexample.pocketdecoder.R;
import com.jexample.pocketdecoder.databinding.ActivityRevSumerianBinding;
import com.jexample.pocketdecoder.databinding.ActivitySumerianBinding;
import com.jexample.pocketdecoder.utils.Constants;
import com.jexample.pocketdecoder.utils.tables.RevSumerianTable;
import com.jexample.pocketdecoder.utils.tables.SumerianTable;

public class RevSumerianActivity extends AppCompatActivity {
    private static final String TAG = "RevSumerianActivity";
    private Activity activity = RevSumerianActivity.this;
    private ActivityRevSumerianBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rev_sumerian);
        setData();
    }

    private void setData() {
        if (getIntent() != null) {
            if (getIntent().hasExtra(Constants.KEY_WORD)) {
                String word = getIntent().getStringExtra(Constants.KEY_WORD);
                binding.tvWord.setText(word);
                binding.tvEquation.setText(
                        RevSumerianTable.getInstance().getRevSumerianEquation(word)
                );
                binding.tvResult.setText(
                        RevSumerianTable.getInstance().getRevSumerianResult(word)
                );
            }
        }
    }
}