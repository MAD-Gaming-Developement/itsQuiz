package subject.trivia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SubjectApp extends AppCompatActivity implements View.OnClickListener {
    private BottomNavigationView bottomNavigationView;

    private static final int NAVIGATION_SUBJECT = R.id.navigation_Subject;
    private static final int NAVIGATION_HISTORY = R.id.navigation_History;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_app);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        Button worldCapitalsButton = findViewById(R.id.idWorldCapitals);
        Button famousInventorsButton = findViewById(R.id.idFamousInventors);
        Button movieQuotesButton = findViewById(R.id.idMovieQuotes);
        Button historicalEventsButton = findViewById(R.id.idHistoricalEvents);
        Button scienceAndNatureButton = findViewById(R.id.idScienceandNature);
        Button literatureAndBooksButton = findViewById(R.id.idLiteratureandBooks);
        Button musicGenresButton = findViewById(R.id.idMusicGenres);
        Button sportsTriviaButton = findViewById(R.id.idSportsTrivia);
        Button artAndArtistsButton = findViewById(R.id.idArtandArtists);
        Button geographyBeeButton = findViewById(R.id.idGeographyBee);

        // Set the OnClickListener for each button
        worldCapitalsButton.setOnClickListener(this);
        famousInventorsButton.setOnClickListener(this);
        movieQuotesButton.setOnClickListener(this);
        historicalEventsButton.setOnClickListener(this);
        scienceAndNatureButton.setOnClickListener(this);
        literatureAndBooksButton.setOnClickListener(this);
        musicGenresButton.setOnClickListener(this);
        sportsTriviaButton.setOnClickListener(this);
        artAndArtistsButton.setOnClickListener(this);
        geographyBeeButton.setOnClickListener(this);

        LottieAnimationView animationView = findViewById(R.id.lottieAnimation);
        animationView.setAnimation(R.raw.quiz);
        animationView.loop(false);
        animationView.playAnimation();
        getWindow().setFlags(1024, 1024);

        // Set the navigation item selected listener for bottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                 if (itemId == R.id.navigation_Subject) {
                    startActivity(new Intent(SubjectApp.this, SubjectApp.class));
                    return true;
                } else if (itemId == R.id.navigation_History) {
                    startActivity(new Intent(SubjectApp.this, PolicySetting.class));
                    return true;
                } else {
                    // Log or handle the unexpected value
                    return false;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        int clickedButtonId = v.getId();
        String category = getCategoryFromButtonId(clickedButtonId);

        // Start the QuestionAct activity with the selected category
        Intent intent = new Intent(this, TriviaQuestion.class);
        intent.putExtra("CATEGORY", category);
        startActivity(intent);
        finish();
    }

    // Helper method to map button IDs to category names
    private String getCategoryFromButtonId(int buttonId) {
        if (buttonId == R.id.idWorldCapitals) {
            return "WorldCapitals";
        } else if (buttonId == R.id.idFamousInventors) {
            return "FamousInventors";
        } else if (buttonId == R.id.idMovieQuotes) {
            return "MovieQuotes";
        } else if (buttonId == R.id.idHistoricalEvents) {
            return "HistoricalEvents";
        } else if (buttonId == R.id.idScienceandNature) {
            return "ScienceandNature";
        } else if (buttonId == R.id.idLiteratureandBooks) {
            return "LiteratureandBooks";
        } else if (buttonId == R.id.idMusicGenres) {
            return "MusicGenres";
        } else if (buttonId == R.id.idSportsTrivia) {
            return "SportsTrivia";
        } else if (buttonId == R.id.idArtandArtists) {
            return "ArtandArtists";
        } else if (buttonId == R.id.idGeographyBee) {
            return "GeographyBee";
        } else {
            return ""; // Handle the default case if needed
        }
    }
}
