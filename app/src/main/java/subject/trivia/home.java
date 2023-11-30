package subject.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //getSupportActionBar().hide();
        LottieAnimationView animationView = findViewById(R.id.lottieAnimation);
        animationView.setAnimation(R.raw.quiz);
        animationView.loop(true);
        animationView.playAnimation();
        getWindow().setFlags(1024, 1024);

        // Delayed transition to TriviaQuestion.java after 3 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(home.this, SubjectApp.class);
                startActivity(intent);


                finish();
            }
        }, 1200);
    }
}
