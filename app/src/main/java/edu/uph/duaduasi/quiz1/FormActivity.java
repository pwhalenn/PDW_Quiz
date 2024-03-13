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

public class FormActivity extends AppCompatActivity {

    private EditText namaKegiatan;
    private RadioGroup tempatKegiatan;
    private CheckBox cbOlahraga, cbJalan, cbMakan, cbBelajar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        namaKegiatan = findViewById(R.id.namaKegiatan);
        tempatKegiatan = findViewById(R.id.tempatKegiatan);
        cbOlahraga = findViewById(R.id.cbOlahraga);
        cbJalan = findViewById(R.id.cbJalan);
        cbMakan = findViewById(R.id.cbMakan);
        cbBelajar = findViewById(R.id.cbBelajar);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast();
            }
        });
    }
    private void showToast() {
        String kegiatan = namaKegiatan.getText().toString();
        String tempat = getSelectedRadioButtonText();
        String jenis = getSelectedCheckBoxesText();

        // Create message for Toast
        String message = "Nama: " + kegiatan + " | Tempat Kegiatan: " + tempat + " | Jenis Kegiatan: " + jenis;

        // Show the horizontal Toast
        Toast toast = Toast.makeText(FormActivity.this, message, Toast.LENGTH_LONG);
        View toastView = toast.getView();
        // Set layout direction to right-to-left
        toastView.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        toast.show();
    }
    private String getSelectedRadioButtonText() {
        int selectedId = tempatKegiatan.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);
        return selectedRadioButton != null ? selectedRadioButton.getText().toString() : "";
    }
    private String getSelectedCheckBoxesText() {
        StringBuilder selectedHobi = new StringBuilder();

        if (cbOlahraga.isChecked()) {
            selectedHobi.append("Olahraga, ");
        }
        if (cbJalan.isChecked()) {
            selectedHobi.append("Jalan-jalan, ");
        }
        if (cbMakan.isChecked()) {
            selectedHobi.append("Makan, ");
        }
        if (cbBelajar.isChecked()) {
            selectedHobi.append("Belajar");
        }
        return selectedHobi.toString();
    }
}