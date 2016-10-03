package id.sch.smktelkom_mlg.tugas01.xiirpl4009.formbeasiswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNS, etOS;
    TextView HasilNS, HasilJ, HasilPO, HasilGP;
    CheckBox cbTKJ, cbRPL, cbMULTIMEDIA;
    RadioGroup rgPO;
    RadioButton rg1, rg2, rg3;
    Spinner spPKO;
    Button buttonOK;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNS = (EditText) findViewById(R.id.editTextNS);

        cbTKJ = (CheckBox) findViewById(R.id.checkBoxTKJ);
        cbRPL = (CheckBox) findViewById(R.id.checkBoxRPL);
        cbMULTIMEDIA = (CheckBox) findViewById(R.id.checkBoxMULTIMEDIA);

        rgPO = (RadioGroup) findViewById(R.id.radioGroupPO);

        rg1 = (RadioButton) findViewById(R.id.radioButton1);
        rg2 = (RadioButton) findViewById(R.id.radioButton2);
        rg3 = (RadioButton) findViewById(R.id.radioButton3);

        spPKO = (Spinner) findViewById(R.id.spinner1);

        buttonOK = (Button) findViewById(R.id.buttonOK);

        HasilNS = (TextView) findViewById(R.id.hasil1);
        HasilJ = (TextView) findViewById(R.id.hasil3);
        HasilPO = (TextView) findViewById(R.id.hasil4);
        HasilGP = (TextView) findViewById(R.id.hasil5);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
                doClick();
            }
        });

    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNS.getText().toString();
            HasilNS.setText("Nama Siswa :" + nama);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNS.getText().toString();

        if (nama.isEmpty()) {
            etNS.setError("Nama Anda Belum Diisi");
            valid = false;
        } else {
            etNS.setError(null);
        }

        return valid;
    }

    private void doClick() {
        String Jumhasil = null;

        if (rg1.isChecked()) {
            Jumhasil = rg1.getText().toString();
        } else if (rg2.isChecked()) {
            Jumhasil = rg2.getText().toString();
        } else if (rg3.isChecked()) {
            Jumhasil = rg3.getText().toString();
        }

        if (Jumhasil == null) {
            HasilGP.setText("Belum Memilih Penghasilan Orangtua");
        } else {
            HasilGP.setText("Penghasilan Orangtua :" + Jumhasil);
        }

        String hasilMod = "Jurusan Yang dipilih :";
        int startlen = hasilMod.length();
        if (cbRPL.isChecked()) hasilMod += cbRPL.getText();
        if (cbTKJ.isChecked()) hasilMod += cbTKJ.getText();
        if (cbMULTIMEDIA.isChecked()) hasilMod += cbMULTIMEDIA.getText();

        if (hasilMod.length() == startlen) hasilMod += "Belum Memilih Jurusan";
        HasilJ.setText(hasilMod);

        HasilPO.setText("Pekerjaan Orang Tua:" + spPKO.getSelectedItem());
    }
}
