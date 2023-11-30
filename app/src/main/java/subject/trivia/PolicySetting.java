package subject.trivia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PolicySetting extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TextView textPrivacyPolicy;
    private TextView textIntroduction;
    private TextView textInformationCollection;
    private TextView textCookies;
    private TextView textSecurity;
    private TextView textLinks;
    private TextView textChangesPrivacy;
    private TextView textTerms;
    private TextView changeterms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_setting);

        bottomNavigationView = findViewById(R.id.nav_view1);
        textPrivacyPolicy = findViewById(R.id.textPrivacyPolicy);
        textIntroduction = findViewById(R.id.textIntroduction);
        textInformationCollection = findViewById(R.id.textInformationCollection);
        textCookies = findViewById(R.id.textCookies);
        textSecurity = findViewById(R.id.textSecurity);
        textLinks = findViewById(R.id.textLinks);
        textChangesPrivacy = findViewById(R.id.textChangesPrivacy);
        textTerms = findViewById(R.id.textTerms);
        changeterms = findViewById(R.id.Changesterms);


        // Set the text for each TextView
        textPrivacyPolicy.setText("Privacy Policy");
        textIntroduction.setText("\n\nIntroduction\n\nWelcome to our app! This app is offered for free, and your use of it is subject to the terms outlined in this Privacy Policy. By using the app, you agree to the collection and use of your information as described here.\n\n");

        textInformationCollection.setText("Information Collection and Use\n\nTo enhance your experience, we may request certain personally identifiable information. However, rest assured that this information is retained on your device and not collected by us. Some features of the app may rely on third-party services, and we recommend reviewing the privacy policies of these services.\n\n");

        textCookies.setText("Cookies\n\nThis app does not explicitly use cookies. Nevertheless, third-party code and libraries integrated into the app might use cookies to enhance their services. You can choose to accept or decline cookies, but declining may limit certain functionalities.\n\n");

        textSecurity.setText("Security\n\nWe value your trust and employ commercially acceptable means to protect your Personal Information. While we strive for security, remember that no method of transmission over the internet is 100% secure.\n\n");

        textLinks.setText("Links to Other Sites\n\nThe app may contain links to external sites. We have no control over the content, privacy policies, or practices of these third-party sites and cannot assume responsibility for them.\n\n");

        textChangesPrivacy.setText("Changes to This Privacy Policy\n\nWe may update our Privacy Policy periodically. Check this page for any changes, and we'll notify you by posting the revised Privacy Policy here.\n\n");

        textTerms.setText("Terms and Conditions\n\nBy using the app, you agree to these terms. You're not allowed to copy, modify, or attempt to extract the source code. We reserve the right to make changes or charge for services. Personal data is stored and processed to provide the service.\n\n");

        changeterms.setText("Changes to Terms and Conditions\n\nWe may update our Terms and Conditions. Check this page periodically, and we'll notify you of changes by posting the updated Terms and Conditions.\n\n");
        changeterms.setText("\n\n\n");

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.navigation_Subject) {
                    startActivity(new Intent(PolicySetting.this, SubjectApp.class));
                    return true;
                } else if (itemId == R.id.navigation_History) {
                    // startActivity(new Intent(PolicySetting.this, PolicySetting.class));
                    return true;
                } else {
                    // Log or handle the unexpected value
                    return false;
                }
            }
        });
    }
}
