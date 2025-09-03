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
    private int cal_eq = 1;

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
            cal_ans = Cal(cal_ans, cal_in, cal_o);
            cal_o = 1;
            cal_j = 1;
            cal_in = 0;
            binding.textViewCalo.setText("+");
            binding.textViewCalin.setText("");
        });
        binding.buttonCalm.setOnClickListener(view -> {
            cal_ans = Cal(cal_ans, cal_in, cal_o);
            cal_o = 2;
            cal_j = 1;
            cal_in = 0;
            binding.textViewCalo.setText("-");
            binding.textViewCalin.setText("");
        });
        binding.buttonCalx.setOnClickListener(view -> {
            cal_ans = Cal(cal_ans, cal_in, cal_o);
            cal_o = 3;
            cal_j = 1;
            cal_in = 0;
            binding.textViewCalo.setText("×");
            binding.textViewCalin.setText("");
        });
        binding.buttonCald.setOnClickListener(view -> {
            cal_ans = Cal(cal_ans, cal_in, cal_o);
            cal_o = 4;
            cal_j = 1;
            cal_in = 0;
            binding.textViewCalo.setText("÷");
            binding.textViewCalin.setText("");
        });
        binding.buttonCale.setOnClickListener(view -> {
            cal_ans = Cal(cal_ans, cal_in, cal_o);
            cal_in = 0;
            cal_o = 0;
            cal_j = 0;
            cal_in = 0;
            cal_eq = 0;
            binding.textViewCalo.setText("");
            binding.textViewCalin.setText("");
        });

        //AC
        binding.buttonCalAC.setOnClickListener(view -> {
            cal_o = 0;
            cal_ans = 0;
            cal_in = 0;
            cal_j = 0;
            binding.textViewCalo.setText("");
            binding.textViewCal.setText("0");
            binding.textViewCalin.setText("");
        });

        //数字
        binding.buttonCal0.setOnClickListener(view -> {
            if (cal_j == 0) {
                cal_ans = cal_ans * 10 * cal_eq;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                if (cal_eq == 0) {
                    cal_eq = 1;
                }
            } else {
                cal_in = cal_in * 10;
                binding.textViewCalin.setText(String.valueOf(cal_in));
            }
        });
        binding.buttonCal1.setOnClickListener(view -> {
            if (cal_j == 0) {
                cal_ans = cal_ans * 10 * cal_eq + 1;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                if (cal_eq == 0) {
                    cal_eq = 1;
                }
            } else {
                cal_in = cal_in * 10 + 1;
                binding.textViewCalin.setText(String.valueOf(cal_in));
            }
        });
        binding.buttonCal2.setOnClickListener(view -> {
            if (cal_j == 0) {
                cal_ans = cal_ans * 10 * cal_eq + 2;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                if (cal_eq == 0) {
                    cal_eq = 1;
                }
            } else {
                cal_in = cal_in * 10 + 2;
                binding.textViewCalin.setText(String.valueOf(cal_in));
            }
        });
        binding.buttonCal3.setOnClickListener(view -> {
            if (cal_j == 0) {
                cal_ans = cal_ans * 10 * cal_eq + 3;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                if (cal_eq == 0) {
                    cal_eq = 1;
                }
            } else {
                cal_in = cal_in * 10 + 3;
                binding.textViewCalin.setText(String.valueOf(cal_in));
            }
        });
        binding.buttonCal4.setOnClickListener(view -> {
            if (cal_j == 0) {
                cal_ans = cal_ans * 10 * cal_eq + 4;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                if (cal_eq == 0) {
                    cal_eq = 1;
                }
            } else {
                cal_in = cal_in * 10 + 4;
                binding.textViewCalin.setText(String.valueOf(cal_in));
            }
        });
        binding.buttonCal5.setOnClickListener(view -> {
            if (cal_j == 0) {
                cal_ans = cal_ans * 10 * cal_eq + 5;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                if (cal_eq == 0) {
                    cal_eq = 1;
                }
            } else {
                cal_in = cal_in * 10 + 5;
                binding.textViewCalin.setText(String.valueOf(cal_in));
            }
        });
        binding.buttonCal6.setOnClickListener(view -> {
            if (cal_j == 0) {
                cal_ans = cal_ans * 10 * cal_eq + 6;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                if (cal_eq == 0) {
                    cal_eq = 1;
                }
            } else {
                cal_in = cal_in * 10 + 6;
                binding.textViewCalin.setText(String.valueOf(cal_in));
            }
        });
        binding.buttonCal7.setOnClickListener(view -> {
            if (cal_j == 0) {
                cal_ans = cal_ans * 10 * cal_eq + 7;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                if (cal_eq == 0) {
                    cal_eq = 1;
                }
            } else {
                cal_in = cal_in * 10 + 7;
                binding.textViewCalin.setText(String.valueOf(cal_in));
            }
        });
        binding.buttonCal8.setOnClickListener(view -> {
            if (cal_j == 0) {
                cal_ans = cal_ans * 10 * cal_eq + 8;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                if (cal_eq == 0) {
                    cal_eq = 1;
                }
            } else {
                cal_in = cal_in * 10 + 8;
                binding.textViewCalin.setText(String.valueOf(cal_in));
            }
        });
        binding.buttonCal9.setOnClickListener(view -> {
            if (cal_j == 0) {
                cal_ans = cal_ans * 10 * cal_eq + 9;
                binding.textViewCal.setText(String.valueOf(cal_ans));
                if (cal_eq == 0) {
                    cal_eq = 1;
                }
            } else {
                cal_in = cal_in * 10 + 9;
                binding.textViewCalin.setText(String.valueOf(cal_in));
            }
        });
    }

    protected double Cal(double cal_ans, double cal_in, int cal_o){
        if (cal_o == 1) {
            cal_ans = cal_ans + cal_in;
            binding.textViewCal.setText(String.valueOf(cal_ans));
        } else if (cal_o == 2) {
            cal_ans = cal_ans - cal_in;
            binding.textViewCal.setText(String.valueOf(cal_ans));
        } else if (cal_o == 3) {
            cal_ans = cal_ans * cal_in;
            binding.textViewCal.setText(String.valueOf(cal_ans));
        } else if (cal_o == 4) {
            if (cal_in == 0) {
                binding.textViewCal.setText("ERROR");
                cal_ans = 0;
            } else {
                cal_ans = cal_ans / cal_in;
                binding.textViewCal.setText(String.valueOf(cal_ans));
            }
        }
        return cal_ans;
    }
}