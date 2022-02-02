package com.jexample.pocketdecoder.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.jexample.pocketdecoder.R;
import com.jexample.pocketdecoder.databinding.ActivityGeneratorBinding;
import com.jexample.pocketdecoder.utils.RandomString;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratorActivity extends AppCompatActivity {

    private static final String TAG = "GeneratorActivity";
    private Activity activity = GeneratorActivity.this;
    private ActivityGeneratorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_generator);

        binding.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tvGeneratedString.setText(
                        new RandomString(8, ThreadLocalRandom.current()).nextString()
                );
            }
        });
    }
}