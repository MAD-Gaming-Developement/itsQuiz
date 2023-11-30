package subject.trivia;

public class UserActivity {
    private String subject;
    private int score;
    private long timestamp;

    // Default constructor (required for Firebase)
    public UserActivity() {
        // Default constructor required for calls to DataSnapshot.getValue(UserActivity.class)
    }

    // Parameterized constructor
    public UserActivity(String subject, int score, long timestamp) {
        this.subject = subject;
        this.score = score;
        this.timestamp = timestamp;
    }

    // Getter methods
    public String getSubject() {
        return subject;
    }

    public int getScore() {
        return score;
    }

    public long getTimestamp() {
        return timestamp;
    }

    // Setter methods (optional, depending on your needs)
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
