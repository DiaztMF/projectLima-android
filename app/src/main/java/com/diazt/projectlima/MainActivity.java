package com.diazt.projectlima;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText bilangan1;
    private EditText bilangan2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bilangan1 = findViewById(R.id.bilangan1);
        bilangan2 = findViewById(R.id.bilangan2);

        findViewById(R.id.tambah).setOnClickListener(v -> kirimData("+"));
        findViewById(R.id.kurang).setOnClickListener(v -> kirimData("-"));
        findViewById(R.id.kali).setOnClickListener(v -> kirimData("*"));
        findViewById(R.id.bagi).setOnClickListener(v -> kirimData("/"));
    }

    private void kirimData(String operasi) {
        String input1 = bilangan1.getText().toString();
        String input2 = bilangan2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Harap isi kedua bilangan", Toast.LENGTH_SHORT).show();
            return;
        }

        int angka1 = Integer.parseInt(input1);
        int angka2 = Integer.parseInt(input2);
        int hasil = 0;

        switch (operasi) {
            case "+":
                hasil = angka1 + angka2;
                break;
            case "-":
                hasil = angka1 - angka2;
                break;
            case "*":
                hasil = angka1 * angka2;
                break;
            case "/":
                hasil = angka1 / angka2;
                break;
        }

        Intent intent = new Intent(MainActivity.this, Page2.class);
        intent.putExtra("angka1", angka1);
        intent.putExtra("angka2", angka2);
        intent.putExtra("operasi", operasi);
        intent.putExtra("hasil", hasil);
        startActivity(intent);
    }
}
