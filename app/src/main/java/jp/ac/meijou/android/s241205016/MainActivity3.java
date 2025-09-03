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
    private int cal_ans = 0;
    private int cal_o = 0;

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
            binding.textViewCalo.setText("+");
        });
        binding.buttonCalm.setOnClickListener(view -> {
            cal_o = 2;
            binding.textViewCalo.setText("-");
        });
        binding.buttonCalx.setOnClickListener(view -> {
            cal_o = 3;
            binding.textViewCalo.setText("×");
        });
        binding.buttonCald.setOnClickListener(view -> {
            cal_o = 4;
            binding.textViewCalo.setText("÷");
        });

        //AC
        binding.buttonCalAC.setOnClickListener(view -> {
            cal_o = 0;
            cal_ans = 0;
            binding.textViewCalo.setText("");
            binding.textViewCal.setText("0");
        });

        //数字(未実装)
    }
}