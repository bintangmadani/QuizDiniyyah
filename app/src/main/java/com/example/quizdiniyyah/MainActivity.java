package com.example.quizdiniyyah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView pertanyaan;
    RadioGroup rg;
    RadioButton PilihanA, PilihanB, PilihanC, PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

    //pertanyaan kuis
    String[] pertanyaan_kuis = new String[]{
            "1. Siapa nama Guru Aqidah Kelas 10? ",
            "2. Siapa nama Guru Bhs.Arab Kelas 10?",
            "3. Siapa nama Guru Matan Kelas 10?",
            "4. Siapa nama Guru Adab Kelas 10?",
            "5. Siapa nama Guru Fikih kelas 10?",

    };
    //pilihan jawaban a, b, c, d;
    String[] pilihan_jawaban = new String[] {
            "Ust.Gaos","Ust.Mansur","Ust.Senno","Ust.Zebuah",
            "Ust.Harun","Ust.Zebuah","Ust.Husein","Ust.Gaos",
            "Ust.Senno","Ust.Gaos","Ust.Husein","Ust.Harun",
            "Ust.Senno","Ust.Zebuah","Ust.Sopp","Ust.Yusril",
            "Ust.Yusril","Ust.Mansur","Ust.Gaos","Ust.Senno",
    };

    //jawaban yang benar
    String [] jawaban_benar = new String[]{
            "Ust.Mansur",
            "Ust.Harun",
            "Ust.Husein",
            "Ust.Zebuah",
            "Ust.Gaos",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pertanyaan = (TextView)findViewById(R.id.pertanyaan);
        rg = (RadioGroup)findViewById(R.id.radio_group);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_kuis[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);

        rg.check(0);
        benar = 0;
        salah = 0;



    }
    public void next(View view){
        if (PilihanA.isChecked()||PilihanB.isChecked()||PilihanC.isChecked()||PilihanD.isChecked()){
            RadioButton jawaban_user = (RadioButton)findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            rg.check(0);
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor]))benar++;
            else salah++;
            nomor++;
            if (nomor<pertanyaan_kuis.length){
                pertanyaan.setText(pertanyaan_kuis[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor*4)+0]);
                PilihanB.setText(pilihan_jawaban[(nomor*4)+1]);
                PilihanC.setText(pilihan_jawaban[(nomor*4)+2]);
                PilihanD.setText(pilihan_jawaban[(nomor*4)+3]);

            }
            else {
                hasil=benar * 20;
                Intent selesai = new Intent(getApplicationContext(),HasilQuiz.class);
                startActivity(selesai);
            }
        }
        else {
            Toast.makeText(this, "Pilih Jawaban dulu", Toast.LENGTH_SHORT).show();
        }
    }
}

