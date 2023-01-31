package com.example.time_management;

import static android.text.format.DateUtils.formatElapsedTime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ServiceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    public Chronometer chrono;
    public Button start, lap, clearLap;
    public ListView lapList;
    public boolean running, tstart;
    public long pauseOffset;
    public int pause1;
    public NavigationView navBarView;

//    public void displayFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragView, fragment);
//        fragmentTransaction.commit();
//
//    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrono = findViewById(R.id.chrTimer);



        ArrayList<String> lapList = new ArrayList<>();
        ListView lapListView = findViewById(R.id.lapTime);
        ArrayAdapter<String> lapAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lapList);
        lapListView.setAdapter(lapAdapter);

        String startBtnText, stopBtnText, lapBtnText, resetBtnText;
        startBtnText = getString(R.string.start);
        stopBtnText = getString(R.string.stop);
        lapBtnText = getString(R.string.lap);
        resetBtnText = getString(R.string.reset);
        start = findViewById(R.id.startBtn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (start.getText() == startBtnText)
                {
                    start.setText(stopBtnText);
                    chrono.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    chrono.start();
                    running = true;
                    tstart = true;
                    lap.setText(lapBtnText);
                }
                else
                {
                    start.setText(startBtnText);
                    chrono.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - chrono.getBase();
                    running = false;
                    lap.setText(resetBtnText);
                }
            }
        });


        lap = findViewById(R.id.lapBtn);
        lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lap.getText() == lapBtnText)
                {
                    pause1 = (int) (SystemClock.elapsedRealtime() - chrono.getBase());
                    lapList.add("college time: " + String.valueOf(pause1));
//                    lapList.add("study");
                    lapAdapter.notifyDataSetChanged();
                }
                else
                {
                    chrono.setBase(SystemClock.elapsedRealtime());
                    pauseOffset = 0;
                    chrono.stop();
                }

            }
        });

        clearLap = findViewById(R.id.clearLap);
        clearLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lapAdapter.clear();
                lapAdapter.notifyDataSetChanged();
            }
        });
        final int[] a = new int[1];
        navBarView = findViewById(R.id.nav_view);
//        navBarView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                Intent i;
//                if (id == R.id.nav_home)
//                {
//                    Fragment fr = new nav_goals();
//                    displayFragment(fr);
//                }
//                else if (id == R.id.nav_gallery)
//                {
//                    Fragment fr = new nav_goals();
//                    displayFragment(fr);
//                }
//                else if (id == R.id.nav_slideshow)
//                {
//                    Fragment fr = new nav_goals();
//                    displayFragment(fr);
//                }
//                else if (id == R.id.nav_goals)
//                {
//                    Fragment fr = new nav_goals();
//                    displayFragment(fr);
//                }
////                    i = new Intent(getApplicationContext(), nav_goals.class);
//                else if (id == R.id.nav_reports)
//                {
//                    Fragment fr = new nav_goals();
//                    displayFragment(fr);
//                }
//                else if (id == R.id.nav_tasks)
//                {
//                    Fragment fr = new nav_goals();
//                    displayFragment(fr);
//                }
//                else if (id == R.id.nav_time_segments)
//                {
//                    Fragment fr = new nav_goals();
//                    displayFragment(fr);
//                }
//
//
//                return true;
//            }
//        });

    }
}
