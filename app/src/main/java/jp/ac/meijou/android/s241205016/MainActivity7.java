package jp.ac.meijou.android.s241205016;

import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.stream.Collectors;

import jp.ac.meijou.android.s241205016.databinding.ActivityMain6Binding;
import jp.ac.meijou.android.s241205016.databinding.ActivityMain7Binding;
import okhttp3.OkHttpClient;

public class MainActivity7 extends AppCompatActivity {
    private final OkHttpClient okHttpClient = new OkHttpClient();
    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<Gist> gistJsonAdapter = moshi.adapter(Gist.class);
    private ActivityMain7Binding binding;
    private ConnectivityManager connectivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMain7Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        connectivityManager = getSystemService(ConnectivityManager.class);

        var currentNetwork = connectivityManager.getActiveNetwork();

        sarchNetwork(currentNetwork);

        binding.button10.setOnClickListener(view -> {
            var network = connectivityManager.getActiveNetwork();
            sarchNetwork(network);
        });
    }

    private void updateTransport(Network network) {
        var caps = connectivityManager.getNetworkCapabilities(network);

        if (caps != null) {
            String transport;
            if (caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                transport = "Mobile Communication";
            } else if (caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                transport = "WiFi";
            } else {
                transport = "Other";
            }

            binding.textview7.setText(transport);
        }
    }

    private void updateIpAddress(Network network) {
        var linkProperties = connectivityManager.getLinkProperties(network);

        if (linkProperties != null) {
            var addresses = linkProperties.getLinkAddresses().stream()
                    .map(LinkAddress::toString)
                    .collect(Collectors.joining("\n"));

            binding.textview9.setText(addresses);
        }
    }

    private void sarchNetwork(Network network) {
        updateTransport(network);
        updateIpAddress(network);
    }
}