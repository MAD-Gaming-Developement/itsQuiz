package subject.trivia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ShowScore extends AppCompatActivity {
    TextView TxtScore;
    TextView TxtStatus;
    MediaPlayer audio;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        bottomNavigationView = findViewById(R.id.nav_view4);
        TxtScore = findViewById(R.id.txtscore);
        TxtStatus = findViewById(R.id.txtStatus);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        TxtScore.setText(String.valueOf(score));
        TxtStatus.setText(setStatus(score));
        playAudio(setStatus(score));

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return handleNavigation(item.getItemId());
            }
        });
    }

    private boolean handleNavigation(int itemId) {
        Log.d("Navigation", "Selected Item ID: " + itemId);
 if (itemId == R.id.navigation_Subject) {
            // Handle navigation to SubjectApp
            startActivity(new Intent(ShowScore.this, SubjectApp.class));
            finish(); // Close the current activity
            return true;
        } else if (itemId == R.id.navigation_History) {
            // Handle navigation to PolicySetting
            startActivity(new Intent(ShowScore.this, PolicySetting.class));
            finish(); // Close the current activity
            return true;
        } else {
            Log.e("Navigation", "Unexpected Item ID: " + itemId);
            return false;
        }
    }


    private String setStatus(int score) {
        if (score >= 25) {
            return "You are very smart!";
        } else if (score >= 18) {
            return "Congratulations!";
        } else {
            return "You need to study more...";
        }
    }

    private void playAudio(String status) {
        if (audio != null) {
            audio.release();  // Release any existing MediaPlayer instance
        }

        if (status.equals("You are very smart!")) {
            audio = MediaPlayer.create(this, R.raw.highscore);
        } else {
            audio = MediaPlayer.create(this, R.raw.mediumscore);
        }

        if (audio != null) {
            audio.start();

            // Set an OnCompletionListener to release the MediaPlayer when the sound is finished playing
            audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }
}
