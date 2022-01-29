package com.jexample.pocketdecoder.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.jexample.pocketdecoder.R;
import com.jexample.pocketdecoder.activity.types.ChaldeanActivity;
import com.jexample.pocketdecoder.activity.types.EngExtActivity;
import com.jexample.pocketdecoder.activity.types.OrdinalActivity;
import com.jexample.pocketdecoder.activity.types.RevOrdinalActivity;
import com.jexample.pocketdecoder.activity.types.RevSumerianActivity;
import com.jexample.pocketdecoder.activity.types.SatanicActivity;
import com.jexample.pocketdecoder.activity.types.SumerianActivity;
import com.jexample.pocketdecoder.databinding.ActivityCipherBinding;
import com.jexample.pocketdecoder.utils.Constants;
import com.jexample.pocketdecoder.utils.tables.ChaldeanTable;
import com.jexample.pocketdecoder.utils.tables.EngExtTable;
import com.jexample.pocketdecoder.utils.tables.OrdinalTable;
import com.jexample.pocketdecoder.utils.tables.RevOrdinalTable;
import com.jexample.pocketdecoder.utils.tables.RevSumerianTable;
import com.jexample.pocketdecoder.utils.tables.SatanicTable;
import com.jexample.pocketdecoder.utils.tables.SumerianTable;

public class CipherActivity extends AppCompatActivity {

    private static final String TAG = "CipherActivity";
    private Activity activity = CipherActivity.this;
    private ActivityCipherBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cipher);


        binding.etWord.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    binding.tvSumerianResult.setText(
                            SumerianTable.getInstance().getSumerianResult(s.toString())
                    );
                    binding.tvRsSumerianResult.setText(
                            RevSumerianTable.getInstance().getRevSumerianResult(s.toString())
                    );
                    binding.tvOrdinalResult.setText(
                            OrdinalTable.getInstance().getOrdinalResult(s.toString())
                    );
                    binding.tvRsOrdinalResult.setText(
                            RevOrdinalTable.getInstance().getRevOrdinalResult(s.toString())
                    );
                    binding.tvEnglishExtResult.setText(
                            EngExtTable.getInstance().getEngExtResult(s.toString())
                    );
                    binding.tvSatanicResult.setText(
                            SatanicTable.getInstance().getEngExtResult(s.toString())
                    );
                    binding.tvChaldeanResult.setText(
                            ChaldeanTable.getInstance().getChaldeanResult(s.toString())
                    );
                    return;
                }
                binding.tvSumerianResult.setText("");
                binding.tvRsSumerianResult.setText("");
                binding.tvOrdinalResult.setText("");
                binding.tvRsOrdinalResult.setText("");
                binding.tvEnglishExtResult.setText("");
                binding.tvSatanicResult.setText("");
                binding.tvChaldeanResult.setText("");
            }
        });
        binding.llSumerian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(binding.etWord.getText().toString(),SumerianActivity.class);
            }
        });
        binding.llRevSumerian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(binding.etWord.getText().toString(), RevSumerianActivity.class);
            }
        });
        binding.llEngExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(binding.etWord.getText().toString(), EngExtActivity.class);
            }
        });
        binding.llOrdinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(binding.etWord.getText().toString(), OrdinalActivity.class);
            }
        });
        binding.llRevOrdinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(binding.etWord.getText().toString(), RevOrdinalActivity.class);
            }
        });
        binding.llChaldean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(binding.etWord.getText().toString(), ChaldeanActivity.class);
            }
        });
        binding.llSatanic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(binding.etWord.getText().toString(), SatanicActivity.class);
            }
        });
    }

    private void startActivity(String word, Class tClass) {
        Intent intent=new Intent(activity, tClass);
        intent.putExtra(Constants.KEY_WORD,word);
        startActivity(intent);
    }
}