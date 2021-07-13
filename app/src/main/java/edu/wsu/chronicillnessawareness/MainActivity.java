package edu.wsu.chronicillnessawareness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

    }

    public void openJoinGroup(){
        Intent intent = new Intent(this, JoinGroup.class);
        startActivity(intent);
    }

    public void openCreateGroup(){
        Intent intent = new Intent(this, CreateGroup.class);
        startActivity(intent);
    }

    public void openShareExperience(){
        Intent intent = new Intent(this, ShareExperience.class);
        startActivity(intent);
    }

    // creating navigation bar for home, notifications, and profile
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment fragment=null;
            switch(menuItem.getItemId())
            {
                case R.id.home:
                    fragment=new HomeFragment();
                    break;

                case R.id.notifications:
                    fragment=new NotificationFragment();
                    break;

                case R.id.profile:
                    fragment=new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
            return true;
        }
    };
}