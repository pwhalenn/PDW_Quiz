package edu.uph.duaduasi.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FormIdentityActivity extends AppCompatActivity {

    private EditText editTextNamaKegiatan;
    private RadioGroup radioGroupTempatKegiatan;
    private CheckBox cbOlahraga, cbJalan, cbMakan, cbBelajar;
    private Button buttonSimpan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_identity);

        editTextNamaKegiatan = findViewById(R.id.editTextText);
        radioGroupTempatKegiatan = findViewById(R.id.radioGroupTempatKegiatan);
        cbOlahraga = findViewById(R.id.cbOlahraga);
        cbJalan = findViewById(R.id.cbJalan);
        cbMakan = findViewById(R.id.cbMakan);
        cbBelajar = findViewById(R.id.cbBelajar);
        buttonSimpan = findViewById(R.id.button);

        buttonSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the selected values
                String namaKegiatan = editTextNamaKegiatan.getText().toString();
                String tempatKegiatan = getSelectedTempatKegiatan();
                String jenisKegiatan = getSelectedJenisKegiatan();

                // Display the Toast message
                String toastMessage = "Berhasil Disimpan\n" +
                        "Nama Kegiatan: " + namaKegiatan + "\n" +
                        "Tempat Kegiatan: " + tempatKegiatan + "\n" +
                        "Jenis Kegiatan:\n" + jenisKegiatan;

                Toast.makeText(FormIdentityActivity.this, toastMessage, Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getSelectedTempatKegiatan() {
        int selectedRadioButtonId = radioGroupTempatKegiatan.getCheckedRadioButtonId();

        if (selectedRadioButtonId == R.id.radio_luar) {
            return "Luar Ruangan";
        } else if (selectedRadioButtonId == R.id.radio_dalam) {
            return "Dalam Ruangan";
        } else {
            return "";
        }
    }

    private String getSelectedJenisKegiatan() {
        StringBuilder jenisKegiatan = new StringBuilder();

        if (cbOlahraga.isChecked()) {
            jenisKegiatan.append("- OlahRaga\n");
        }
        if (cbJalan.isChecked()) {
            jenisKegiatan.append("- Jalan-jalan\n");
        }
        if (cbMakan.isChecked()) {
            jenisKegiatan.append("- Makan\n");
        }
        if (cbBelajar.isChecked()) {
            jenisKegiatan.append("- Belajar\n");
        }

        return jenisKegiatan.toString();
    }
}