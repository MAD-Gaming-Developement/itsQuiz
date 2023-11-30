package subject.trivia;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

public class CorrectAnswer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct_answer);

        LottieAnimationView animationView = findViewById(R.id.lottieAnimationRight);
        animationView.setAnimation(R.raw.check);
        animationView.loop(true);
        animationView.playAnimation();
        getWindow().setFlags(1024, 1024);

        // Play correct answer sound
        final MediaPlayer audio = MediaPlayer.create(this, R.raw.highscore);
        if (audio != null) {
            audio.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    audio.start();
                }
            });
            audio.prepareAsync();
            audio.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    // Handle errors here
                    return false;
                }
            });
        } else {
            // Log an error or take appropriate action
        }

        // Finish the activity after 2000 milliseconds (2 seconds)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 2000);
    }
}
