package jp.ac.meijou.android.s241205016;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s241205016.databinding.ActivityMain3Binding;
import jp.ac.meijou.android.s241205016.databinding.ActivityMainBinding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;
    private double cal_ans = 0;
    private double cal_in = 0;
    private int cal_o = 0;
    private int cal_j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //演算子
        binding.buttonCalp.setOnClickListener(view -> {
            cal_o = 1;
            cal_j = 1;
            binding.textViewCalo.setText("+");
        });
        binding.buttonCalm.setOnClickListener(view -> {
            cal_o = 2;
            cal_j = 1;
            binding.textViewCalo.setText("-");
        });
        binding.buttonCalx.setOnClickListener(view -> {
            cal_o = 3;
            cal_j = 1;
            binding.textViewCalo.setText("×");
        });
        binding.buttonCald.setOnClickListener(view -> {
            cal_o = 4;
            cal_j = 1;
            binding.textViewCalo.setText("÷");
        });
        binding.buttonCale.setOnClickListener(view -> {
            if (cal_o == 1) {
                cal_ans = cal_ans + cal_in;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                cal_in = 0;
                cal_o = 0;
                cal_j = 0;
            } else if (cal_o == 2) {
                cal_ans = cal_ans - cal_in;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                cal_in = 0;
                cal_o = 0;
                cal_j = 0;
            } else if (cal_o == 3) {
                cal_ans = cal_ans * cal_in;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                cal_in = 0;
                cal_o = 0;
                cal_j = 0;
            } else if (cal_o == 4) {
                if (cal_in == 0) {
                    binding.textViewCal.setText("ERROR");
                } else {
                    cal_ans = cal_ans / cal_in;
                    binding.textViewCal.setText(String.valueOf(cal_ans));
                }
                cal_in = 0;
                cal_o = 0;
                cal_j = 0;
            }
        });

        //AC
        binding.buttonCalAC.setOnClickListener(view -> {
            cal_o = 0;
            cal_ans = 0;
            cal_in = 0;
            cal_j = 0;
            binding.textViewCalo.setText("");
            binding.textViewCal.setText("0");
            binding.textViewCalin.setText("0");
        });

        //数字
        binding.buttonCal0.setOnClickListener(view -> {

        });
    }
}