package com.jexample.pocketdecoder.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.jexample.pocketdecoder.R;
import com.jexample.pocketdecoder.databinding.ActivityAnagramBinding;
import com.jexample.pocketdecoder.utils.Anagram;

import java.util.List;

public class AnagramActivity extends AppCompatActivity {

    private static final String TAG = "AnagramActivity";
    private Activity activity = AnagramActivity.this;
    private ActivityAnagramBinding binding;
    private Dialog waitDialog;
    private Anagram anagram=new Anagram();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_anagram);
        // we disable validate button because words are not loaded from assets
        binding.validate.setEnabled(anagram.isLoaded());
        // we need to load words from assets
        loadWords();

        binding.validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.etInput.getText().toString();

                if (text != null) {
                    final String text2 = text.trim();

                    if (!"".equals(text2)) {
                        showWaitDialog(); // wait dialog for user

                        new Thread(() -> {
                            final List<String> words = anagram.listWords(text); // we search anagrams for entered letters in separate thread
                            if(words.contains(text))
                                words.remove(text);
                            runOnUiThread(() -> {
                                hideWaitDialog();
                                // we display results
                                displayResult(words);
                            });
                        }).start();

                    }
                }

            }
        });
    }

    private void showWaitDialog() {
        waitDialog = new AlertDialog.Builder(this).setMessage("Wait").create();
    }

    private void hideWaitDialog() {
        waitDialog.dismiss();
    }

    private void displayResult(List<String> words) {
        if (words.isEmpty()) {
            binding.result.setText("No result found!");
        } else {
            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                sb.append(word).append("\n");
            }
            binding.result.setText(sb);
        }
    }

    private void loadWords() {
        showWaitDialog();
        new Thread(() -> {
            anagram.loadWords(activity);

            runOnUiThread(() -> {
                hideWaitDialog();
                binding.validate.setEnabled(anagram.isLoaded());
            });
        }).start();
    }
}