package com.jexample.pocketdecoder.activity.types;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.jexample.pocketdecoder.R;
import com.jexample.pocketdecoder.databinding.ActivityOrdinalBinding;
import com.jexample.pocketdecoder.databinding.ActivitySumerianBinding;
import com.jexample.pocketdecoder.utils.Constants;
import com.jexample.pocketdecoder.utils.tables.EngExtTable;
import com.jexample.pocketdecoder.utils.tables.OrdinalTable;
import com.jexample.pocketdecoder.utils.tables.SumerianTable;

public class OrdinalActivity extends AppCompatActivity {
    private static final String TAG = "OrdinalActivity";
    private Activity activity = OrdinalActivity.this;
    private ActivityOrdinalBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_ordinal);
        setData();
    }

    private void setData() {
        if (getIntent() != null) {
            if (getIntent().hasExtra(Constants.KEY_WORD)) {
                String word = getIntent().getStringExtra(Constants.KEY_WORD);
                binding.tvWord.setText(word);
                binding.tvEquation.setText(
                        OrdinalTable.getInstance().getOrdinalEquation(word)
                );
                binding.tvResult.setText(
                        OrdinalTable.getInstance().getOrdinalResult(word)
                );
            }
        }
    }
}