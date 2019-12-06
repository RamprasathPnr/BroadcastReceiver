package in.mobile.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    private BootCompletedReceiver bootCompletedReceiver;
    private AirplanceModeReceiver aiplAirplanceModeReceiver;
    private DateChangedReceiver dateChangedReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IntentFilter filterDateChanged = new IntentFilter("android.intent.action.DATE_CHANGED");

        dateChangedReceiver = new DateChangedReceiver();
        registerReceiver(dateChangedReceiver, filterDateChanged);


        IntentFilter filterBootCompleted = new IntentFilter("android.intent.action.BOOT_COMPLETED");

        bootCompletedReceiver = new BootCompletedReceiver();
        registerReceiver(bootCompletedReceiver, filterBootCompleted);

        IntentFilter filterAirplaneChanged = new IntentFilter("android.intent.action.AIRPLANE_MODE");

        aiplAirplanceModeReceiver = new AirplanceModeReceiver();
        registerReceiver(aiplAirplanceModeReceiver, filterAirplaneChanged);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(aiplAirplanceModeReceiver);
        unregisterReceiver(bootCompletedReceiver);
        unregisterReceiver(dateChangedReceiver);
    }
}
