package com.diazt.projectlima;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView operasi = findViewById(R.id.operasi);
        TextView hasil = findViewById(R.id.hasil);

        int angka1 = getIntent().getIntExtra("angka1", 0);
        int angka2 = getIntent().getIntExtra("angka2", 0);
        String angka_operasi = getIntent().getStringExtra("operasi");
        int hasil_operasi = getIntent().getIntExtra("hasil", 0);

        String kalimat = angka1 + " " + angka_operasi + " " + angka2;
        operasi.setText(kalimat);
        hasil.setText(String.valueOf(hasil_operasi));
    }
}
