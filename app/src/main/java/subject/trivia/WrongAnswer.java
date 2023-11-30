package subject.trivia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class WrongAnswer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_answer);

        LottieAnimationView animationView = findViewById(R.id.lottieAnimationWrong);
        animationView.setAnimation(R.raw.wrong);
        animationView.loop(true);
        animationView.playAnimation();
        getWindow().setFlags(1024, 1024);

        // Play wrong answer sound
        final MediaPlayer audio = MediaPlayer.create(this, R.raw.wronganswer);
        if (audio != null) {
            try {
                // Check if the audio is not playing
                if (!audio.isPlaying()) {
                    audio.prepare();  // Use prepare() instead of start()
                    audio.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Release the MediaPlayer when the sound is finished playing
            audio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }

        // Finish the activity after 1000 milliseconds (1 second)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 1000);
    }
}
