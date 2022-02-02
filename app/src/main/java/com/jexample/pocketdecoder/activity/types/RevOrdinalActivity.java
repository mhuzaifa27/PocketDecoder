package com.jexample.pocketdecoder.activity.types;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jexample.pocketdecoder.R;
import com.jexample.pocketdecoder.databinding.ActivityRevOrdinalBinding;
import com.jexample.pocketdecoder.databinding.ActivitySumerianBinding;
import com.jexample.pocketdecoder.utils.Constants;
import com.jexample.pocketdecoder.utils.tables.RevOrdinalTable;
import com.jexample.pocketdecoder.utils.tables.SumerianTable;

public class RevOrdinalActivity extends AppCompatActivity {

    private static final String TAG = "RevOrdinalActivity";
    private Activity activity = RevOrdinalActivity.this;
    private ActivityRevOrdinalBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rev_ordinal);
        setData();
    }

    private void setData() {
        if (getIntent() != null) {
            if (getIntent().hasExtra(Constants.KEY_WORD)) {
                String word = getIntent().getStringExtra(Constants.KEY_WORD);
                binding.tvWord.setText(word);
                binding.tvEquation.setText(
                        RevOrdinalTable.getInstance().getRevOrdinalEquation(word)
                );
                binding.tvResult.setText(
                        RevOrdinalTable.getInstance().getRevOrdinalResult(word)
                );
            }
        }
    }
}