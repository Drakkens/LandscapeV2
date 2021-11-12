package com.drakkens.landscape.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.drakkens.landscape.R;

public class MainMenu extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.menu_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
    }
}

