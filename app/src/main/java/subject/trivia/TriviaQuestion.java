package subject.trivia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class TriviaQuestion extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    private static final int NAVIGATION_SUBJECT = R.id.navigation_Subject;
    private static final int NAVIGATION_HISTORY = R.id.navigation_History;

    private RadioButton AnswerStringA;
    private RadioButton AnswerStringB;
    private RadioButton AnswerStringC;
    private RadioButton AnswerStringD;
    private Button confirmed;
    private TextView AnswerStringText;
    private String rightAnswer;
    private String answer;
    private List<AnswerString> AnswerStrings;
    private int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia_question);

        String questionText = getIntent().getStringExtra("questionText");
        confirmed = findViewById(R.id.confirm);


        bottomNavigationView = findViewById(R.id.nav_view);
        AnswerStringA = findViewById(R.id.questA);
        AnswerStringB = findViewById(R.id.questB);
        AnswerStringC = findViewById(R.id.questC);
        AnswerStringD = findViewById(R.id.questD);
        AnswerStringText = findViewById(R.id.txtvaskQuestion);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

        setRadioListeners();

        score = 0;
        AnswerStrings = new ArrayList<>();
        LottieAnimationView animationView = findViewById(R.id.lottieAnimation);
        animationView.setAnimation(R.raw.quiz);
        animationView.loop(true);
        animationView.playAnimation();
        getWindow().setFlags(1024, 1024);

        // Retrieve the selected category from the intent
        Intent intent = getIntent();
        String selectedCategory = intent.getStringExtra("CATEGORY");

        // Load AnswerStrings based on the selected category
        loadAnswerStrings(selectedCategory);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_Subject) {
                    startActivity(new Intent(TriviaQuestion.this, SubjectApp.class));
                    return true;
                } else if (itemId == R.id.navigation_History) {
                    startActivity(new Intent(TriviaQuestion.this, PolicySetting.class));
                    return true;
                } else {
                    // Log or handle the unexpected value
                    return false;
                }
            }
        });
    }


    private void loadAnswerStrings(String category) {
        // Clear previous AnswerStrings
        AnswerStrings.clear();

        // Load AnswerStrings based on the selected category
        switch (category) {
            case "WorldCapitals":
                AnswerStrings.add(new AnswerString("What is the capital city of Japan?", "A", "Tokyo", "Osaka", "Kyoto", "Seoul"));
                AnswerStrings.add(new AnswerString("Which city serves as the capital of Australia?", "C", "Sydney", "Melbourne", "Canberra", "Brisbane"));
                AnswerStrings.add(new AnswerString("The capital city of Brazil is:", "A", "Brasília", " Rio de Janeiro", "São Paulo", "Buenos Aires"));
                AnswerStrings.add(new AnswerString("What is the capital of South Africa?", "A", "Pretoria", "Cape Town", "Johannesburg", "Nairobi"));
                AnswerStrings.add(new AnswerString("Which city is the capital of Canada?", "B", "Montreal", "Ottawa", "Toronto", "Vancouver"));
                AnswerStrings.add(new AnswerString("The capital of Egypt is:", "A", "Cairo", "Alexandria", "Luxor", "Giza"));
                AnswerStrings.add(new AnswerString("What is the capital city of Argentina?", "C", "Santiago", "Bogotá", "Buenos Aires", "Lima"));
                AnswerStrings.add(new AnswerString("The capital of Russia is:", "A", "Moscow", "Saint Petersburg", "Kiev", "Warsaw"));
                AnswerStrings.add(new AnswerString("What is the capital city of Mexico?", "A", "Mexico City", "Guadalajara", "Cancún", "Monterrey"));
                AnswerStrings.add(new AnswerString("Which city serves as the capital of India?", "C", "Mumbai", "Kolkata", "Delhi", "Bangalore"));
                AnswerStrings.add(new AnswerString("What is the capital city of France?", "C", "Madrid", "Berlin", "Paris", "Rome"));
                AnswerStrings.add(new AnswerString("What is the capital city of Germany?", "C", "Munich", "Frankfurt", "Berlin", "Hamburg"));
                AnswerStrings.add(new AnswerString("The capital of Italy is:", "B", "Madrid", "Rome", "Milan", "Florence"));
                AnswerStrings.add(new AnswerString("Which city serves as the capital of South Korea?", "A", "Seoul", "Busan", "Incheon", "Daegu"));
                AnswerStrings.add(new AnswerString("The capital of Spain is:", "B", "Barcelona", "Madrid", "Valencia", "Seville"));
                AnswerStrings.add(new AnswerString("The capital of China is:", "A", "Beijing", "Shanghai", "Hong Kong", "Guangzhou"));
                AnswerStrings.add(new AnswerString("What is the capital city of Turkey?", "B", "Istanbul", "Ankara", "Izmir", "Antalya"));
                AnswerStrings.add(new AnswerString("Which city serves as the capital of Saudi Arabia?", "A", "Riyadh", "Jeddah", "Mecca", "Medina"));
                AnswerStrings.add(new AnswerString("What is the capital city of Nigeria?", "B", "Lagos", "Abuja", "Kano", "Ibadan"));
                AnswerStrings.add(new AnswerString("The capital of Indonesia is:", "A", "Jakarta", "Bali", "Surabaya", "Medan"));
                AnswerStrings.add(new AnswerString("The capital of Thailand is:", "A", "Bangkok", "Phuket", "Chiang Mai", "Pattaya"));
                AnswerStrings.add(new AnswerString("The capital of Kenya is:", "A", "Nairobi", "Mombasa", "Kisumu", "Nakuru"));
                AnswerStrings.add(new AnswerString("What is the capital city of Peru?", "A", "Lima", "Cusco", "Arequipa", "Trujillo"));
                AnswerStrings.add(new AnswerString("The capital of Sweden is:", "A", "Stockholm", "Gothenburg", "Malmo", "Uppsala"));
                AnswerStrings.add(new AnswerString("Which city serves as the capital of Nigeria?", "B", "Lagos", "Abuja", "Kano", "Ibadan"));
                AnswerStrings.add(new AnswerString("What is the capital city of Iran?", "A", "Tehran", "Isfahan", "Shiraz", "Tabriz"));
                AnswerStrings.add(new AnswerString("Which city serves as the capital of Switzerland?", "C", "Zurich", "Geneva", "Bern", "Basel"));
                AnswerStrings.add(new AnswerString("The capital of Malaysia is:", "A", "Kuala Lumpur", "Penang", "Johor Bahru", "Kuching"));
                AnswerStrings.add(new AnswerString("What is the capital city of Pakistan?", "C", "Karachi", "Lahore", "Islamabad", "Rawalpindi"));
                AnswerStrings.add(new AnswerString("The capital of the Philippines", "C", "Cebu", "Mindanao", "Manila", "Quezon City"));



                // Add more AnswerStrings for World Capitals...
                break;
            case "FamousInventors":
                AnswerStrings.add(new AnswerString("Who is credited with inventing the telephone?", "B", "Thomas Edison", "Alexander Graham Bell", "Nikola Tesla", "Benjamin Franklin"));
                AnswerStrings.add(new AnswerString("Which inventor is known for developing the first practical electric light bulb?", "A", "Thomas Edison", "Michael Faraday", "James Clerk Maxwell", "George Westinghouse"));
                AnswerStrings.add(new AnswerString("Who is the inventor of the modern computer?", "A", "Charles Babbage", "Alan Turing", "John von Neumann", "Ada Lovelace"));
                AnswerStrings.add(new AnswerString("Which inventor is associated with the development of the World Wide Web?", "A", "Tim Berners-Lee", "Bill Gates", "Steve Jobs", "Mark Zuckerberg"));
                AnswerStrings.add(new AnswerString("Who is the inventor of the first practical telephone exchange?", "A", "Alexander Graham Bell", "Thomas Edison", "Nikola Tesla", "Samuel Morse"));
                AnswerStrings.add(new AnswerString("Which inventor is known for the invention of the printing press?", "A", "Johannes Gutenberg", "Leonardo da Vinci", "Galileo Galilei", "Isaac Newton"));
                AnswerStrings.add(new AnswerString("Who is credited with the invention of the steam engine?", "A", "James Watt", "Thomas Edison", "Nikola Tesla", "George Stephenson"));
                AnswerStrings.add(new AnswerString("Which inventor is famous for the discovery of penicillin?", "B", "Louis Pasteur", "Alexander Fleming", "Marie Curie", "Joseph Lister"));
                AnswerStrings.add(new AnswerString("Who is the inventor of the first practical sewing machine?", "A", "Elias Howe", "Isaac Singer", "Thomas Edison", "Karl Benz"));
                AnswerStrings.add(new AnswerString("Which inventor is associated with the development of the alternating current (AC) electrical system?", "B", "Thomas Edison", "Nikola Tesla", "Michael Faraday", "George Westinghouse"));
                AnswerStrings.add(new AnswerString("Who is credited with the invention of the periodic table of elements?", "B", "Marie Curie", "Dmitri Mendeleev", "Antoine Lavoisier", "Niels Bohr"));
                AnswerStrings.add(new AnswerString("Which inventor is known for the development of the assembly line in manufacturing?", "A", "Henry Ford", "Eli Whitney", "Alfred Nobel", "Orville Wright"));
                AnswerStrings.add(new AnswerString("Who is the inventor of the first practical photographic process?", "C", "Ansel Adams", "George Eastman", "Louis Daguerre", "Thomas Edison"));
                AnswerStrings.add(new AnswerString("Which inventor is associated with the discovery of radioactivity?", "A", "Marie Curie", "Albert Einstein", "Ernest Rutherford", "Wilhelm Roentgen"));
                AnswerStrings.add(new AnswerString("Who is credited with the invention of the first practical video game?", "C", "Steve Jobs", "Bill Gates", "Nolan Bushnell", "Shigeru Miyamoto"));
                AnswerStrings.add(new AnswerString("Which inventor is known for the creation of the pacemaker?", "A", "Willem Einthoven", "Alexander Fleming", "Karl Landsteiner", "ohn Hopps"));
                AnswerStrings.add(new AnswerString("Who is the inventor of the first practical electric motor?", "A", " Michael Faraday", "Thomas Edison", "Nikola Tesla", "James Clerk Maxwell"));
                AnswerStrings.add(new AnswerString("Which inventor is associated with the development of the transistor?", "B", "Thomas Edison", "John Bardeen", "Nikola Tesla", "Samuel Morse"));
                AnswerStrings.add(new AnswerString("Who is credited with the invention of the first practical refrigerator?", "D", "Benjamin Franklin", "Nikola Tesla", "Albert Einstein", "Oliver Evans"));
                AnswerStrings.add(new AnswerString("Which inventor is known for the development of the first practical jet engine?", "A", "Frank Whittle", "Orville Wright", "Igor Sikorsky", "Charles Lindbergh"));
                AnswerStrings.add(new AnswerString("Who is the inventor of the first practical telephone?", "B", "Thomas Edison", "Alexander Graham Bell", "Nikola Tesla", "Samuel Morse"));
                AnswerStrings.add(new AnswerString("Which inventor is known for the invention of the light-emitting diode (LED)?", "B", "Thomas Edison", "Nick Holonyak Jr.", "Nikola Tesla", "George Westinghouse"));
                AnswerStrings.add(new AnswerString("Who is credited with the development of the first practical television?", "C", "Thomas Edison", "Alexander Graham Bell", "Philo Farnsworth", "Guglielmo Marconi"));
                AnswerStrings.add(new AnswerString("Which inventor is associated with the creation of the World Wide Web?", "A", "Tim Berners-Lee", "Bill Gates", "Steve Jobs", "Mark Zuckerberg"));
                AnswerStrings.add(new AnswerString("Who is the inventor of the first practical computer mouse?", "A", "Douglas Engelbart", "Alan Turing", "Steve Jobs", "Bill Gates"));
                AnswerStrings.add(new AnswerString("Which inventor is known for the development of the first practical electric car?", "C", "Nikola Tesla", "Thomas Edison", "Elon Musk", "Henry Ford"));
                AnswerStrings.add(new AnswerString("Who is credited with the invention of the first practical photographic film?", "B", "Ansel Adams", "George Eastman", "Louis Daguerre", "Thomas Edison"));
                AnswerStrings.add(new AnswerString("Which inventor is associated with the creation of the first practical computer programming language?", "D", "Bill Gates", "Ada Lovelace", "Alan Turing", "Grace Hopper"));
                AnswerStrings.add(new AnswerString("Who is the inventor of the first practical sewing machine?", "A", "Elias Howe", "Isaac Singer", "Thomas Edison", "Karl Benz"));
                AnswerStrings.add(new AnswerString("Which inventor is known for the development of the first practical digital camera?", "D", "Steve Jobs", "Bill Gates", "George Eastman", "Steven Sasson"));
                break;
            case "MovieQuotes":
                AnswerStrings.add(new AnswerString("Which movie features the famous line: Here's looking at you, kid?", "A", "Casablanca", "Gone with the Wind", "The Godfather", "Citizen Kane"));
                AnswerStrings.add(new AnswerString("In: The Shawshank Redemption : what is Andy Dufresne's famous line to Red about hope?", "A", "Get busy living, or get busy dying.", "Hope is a dangerous thing.", "Freedom is a state of mind.", "I find hope in the darkest of days."));
                AnswerStrings.add(new AnswerString("Which film includes the quote: May the Force be with you?", "A", "Star Wars", "Jurassic Park", "The Matrix", "E.T. the Extra-Terrestrial"));
                AnswerStrings.add(new AnswerString("In the Filipino film \"One More Chance,\" what is Popoy's memorable line during his confrontation with Basha?", "B", " \"She loved me at my worst, you had me at my best.\"", "\"Basha, sobrang sakit!\"", "\"Wala na tayong space.\"", " \"You had me at my best, but you chose to break me.\""));
                AnswerStrings.add(new AnswerString("\"Here's Johnny!\" is a famous line from which horror film?\n", "A", "The Shining", "Psycho", "Halloween", "A Nightmare on Elm Street"));
                AnswerStrings.add(new AnswerString("In \"Forrest Gump,\" what does Forrest say life is like?", "A", "\"A box of chocolates.\"", "\"A rollercoaster ride.\"", "\"A journey with no end.\"", "\"A puzzle to solve.\""));
                AnswerStrings.add(new AnswerString("Which movie features the line: \"You can't handle the truth!\"?", "A", "A Few Good Men", "The Departed", "Scent of a Woman", "Rain Man"));
                AnswerStrings.add(new AnswerString("In \"The Dark Knight,\" what is the Joker's famous line about chaos?", "D", " \"Why so serious?\"", " \"Let's put a smile on that face.\"", "\"This town deserves a better class of criminal.\"", "\"Some men just want to watch the world burn.\""));
                AnswerStrings.add(new AnswerString("\"I feel the need—the need for speed\" is a quote from which movie?", "A", "Top Gun", "Fast and Furious", "Days of Thunder", "Mission: Impossible"));
                AnswerStrings.add(new AnswerString("Which film includes the line: \"There's no place like home\"?", "A", "The Wizard of Oz", "E.T. the Extra-Terrestrial", "The Goonies", "Back to the Future"));
                AnswerStrings.add(new AnswerString("In \"Titanic,\" what is Jack's famous line to Rose on the ship's bow?", "A", "\"I'm the king of the world!\"", "\"You jump, I jump, right?\"", "\"Draw me like one of your French girls.\"", "\"I'll never let go, Jack.\""));
                AnswerStrings.add(new AnswerString("Which Filipino movie features the line: \"Walang himala! Ang himala ay nasa puso ng tao, nasa puso nating lahat!\" (There are no miracles! The miracle is in the heart of the people, in all our hearts!)", "A", "Himala", "Magnifico", "Dekada '70", "Jose Rizal"));
                AnswerStrings.add(new AnswerString("In the movie \"One More Try,\" who said the line: \"I can't be a father to a child whose mother is a liar.\"?", "A", "Edward", "Tristan", "Anthony", "Grace"));
                AnswerStrings.add(new AnswerString("\"You can't change the past, but you can learn from it\" is a quote from which movie?", "A", "The Butterfly Effect", "Groundhog Day", "Back to the Future", "The Time Traveler's Wife"));
                AnswerStrings.add(new AnswerString("Which film includes the line: \"To infinity and beyond\"?", "A", "Toy Story", "Finding Nemo", "The Lion King", "Shrek"));
                AnswerStrings.add(new AnswerString("In \"The Silence of the Lambs,\" what is Hannibal Lecter's famous line to Clarice?\n", "A", "\"I ate his liver with some fava beans and a nice Chianti.\"", "\"It puts the lotion on its skin or else it gets the hose again.\"", "\"Hello, Clarice.\"", "\"A census taker once tried to test me. I ate his liver with some fava beans and a nice Chianti.\""));
                AnswerStrings.add(new AnswerString("Which Filipino movie features the iconic line: \"You had me at my best, but you chose to break me\"?", "A", "One More Chance", "Starting Over Again", "That Thing Called Tadhana", "My Amnesia Girl"));
                AnswerStrings.add(new AnswerString("In the movie \"Four Sisters and a Wedding,\" which sister said the line: \"You can't choose the family you're born into, but you can choose the one you'll love.\"?", "B", "Bobbie", "Alex", "Gabbie", "CJ"));
                AnswerStrings.add(new AnswerString("In the movie \"Baler,\" what is the famous line of Feliza, played by Anne Curtis, to Daniel, played by Jericho Rosales?", "D", "\"Huwag mong gawing biro ang pag-ibig.\" (Don't make a joke out of love.)", "\"Walang hanggan ang pag-ibig ko sa'yo.\" (My love for you is endless.)", "\"Kahit anong mangyari, hindi kita iiwan.\" (No matter what happens, I won't leave you.)", "\"Iniwan mo ako, Feliza.\" (You left me, Feliza.)"));
                AnswerStrings.add(new AnswerString("In the film \"Starting Over Again,\" what is Marco's famous line to Ginny during their confrontation?\n", "D", "\"You never gave us a chance.\"", "\"Sana hindi na lang kita minahal.\"", "\"We could have been happy.\"", "\"Ginny, ikaw pa rin.\" (Ginny, it's still you.)"));
                AnswerStrings.add(new AnswerString("In \"Jerry Maguire,\" what is Jerry's famous line to Dorothy?", "C","\"Show me the money!\"", "\"You complete me.\"", "\"You had me at hello.\"", "\"Help me, help you.\""));
                AnswerStrings.add(new AnswerString("Which movie features the quote: \"Keep your friends close, but your enemies closer\"?\n", "A", "The Godfather Part II", "Scarface", "Goodfellas", "The Sopranos"));
                AnswerStrings.add(new AnswerString("In \"The Matrix,\" what does Morpheus offer Neo to choose between?", "A", "Red pill or blue pill", "Love or hate", "Fight or surrender", "Truth or illusion"));
                AnswerStrings.add(new AnswerString("Which Filipino romantic comedy features the line: \"Kelan mo pa naging matapang?\" (When did you become brave?)", "B", " My Amnesia Girl", "My Ex and Whys", "My Perfect You", "My Big Love"));
                AnswerStrings.add(new AnswerString("Which film features the line: \"There's no crying in baseball\"?", "A", "A League of Their Own", "Field of Dreams", "Moneyball", "Bull Durham"));
                AnswerStrings.add(new AnswerString("In \"The Princess Bride,\" what is Inigo Montoya's famous line?", "C", "\"As you wish.\"", "\"Inconceivable!\"", "\"Hello. My name is Inigo Montoya. You killed my father. Prepare to die.\"", "\"I am not a witch; I'm your wife.\""));
                AnswerStrings.add(new AnswerString("\"Totoo ba ang sinasabi ng mga manghuhula?\" (Are fortune tellers telling the truth?) is a famous line from which Filipino horror film?", "A", "Feng Shui", "Shake, Rattle & Roll", "Ouija", "Sukob"));
                AnswerStrings.add(new AnswerString("Which movie features the line: \"I'm king of the world!\"?", "A", "Titanic", "Gladiator", "Braveheart", "300"));
                AnswerStrings.add(new AnswerString("In the movie \"Heneral Luna,\" what is Heneral Luna's famous line during the Battle of Kakarong de Sili?", "D", " \"Bayan o Sarili?\"", "\"Tara, kain tayo!\"", " \"Ang taong hindi marunong lumingon sa pinanggalingan ay hindi makararating sa paroroonan.\"", "\"Buwisit na buwisit na buwisit!\""));
                AnswerStrings.add(new AnswerString("Which Filipino film features the line: \"Sa ilalim ng Unang Unang Tulay, doon kita hinihintay.\" (Under the First Bridge, that's where I'll be waiting for you)", "D", "My Ex and Whys", "The Hows of Us", "Starting Over Again", "That Thing Called Tadhana"));

                break;
            case "HistoricalEvents":
                AnswerStrings.add(new AnswerString("The Great Wall of China was primarily built to protect against invasions from which nomadic group?\n","B", "Huns", "Mongols", "Visigoths", "Vandals "));
                AnswerStrings.add(new AnswerString("The Allied invasion of Normandy on June 6, 1944, is commonly known by which code name?\n","B", "Operation Barbarossa", "Operation Overlord", "Operation Market Garden", "Operation Torch"));
                AnswerStrings.add(new AnswerString("The \"Shot Heard 'Round the World\" refers to the first shot fired in which revolutionary war?\n","A", "American Revolution", "French Revolution", "Russian Revolution", "Chinese Revolution"));
                AnswerStrings.add(new AnswerString("Who was the first President of the United States?","B", "Thomas Jefferson", "George Washington", "John Adams", "Benjamin Franklin"));
                AnswerStrings.add(new AnswerString("The signing of the Magna Carta in 1215 is associated with the limitation of the power of which monarch?","C", "King Louis XIV of France", "King Henry VIII of England", "King John of England", "Queen Elizabeth I of England"));
                AnswerStrings.add(new AnswerString("In which year did Christopher Columbus first reach the Americas?","Answer A","1492","1521","1607","1776"));
                AnswerStrings.add(new AnswerString("The Battle of Gettysburg was a significant conflict during which war?","B", "World War I", "American Civil War", "Napoleonic Wars", "War of 1812"));
                AnswerStrings.add(new AnswerString("Who was the Egyptian queen known for her relationship with Roman leaders Julius Caesar and Mark Antony?","C", "Nefertiti", "Hatshepsut", " Cleopatra", "Isis"));
                AnswerStrings.add(new AnswerString("The Berlin Wall, a symbol of the Cold War, fell in which year?","A", "1989", "1971", "1963", "1995"));
                AnswerStrings.add(new AnswerString("The Emancipation Proclamation, issued by President Abraham Lincoln, aimed to free slaves during which conflict?","B", "American Revolution", "American Civil War", "Spanish-American War", "World War II"));

                AnswerStrings.add(new AnswerString("What event is often considered the start of World War I?","A", "Assassination of Archduke Franz Ferdinand", "Bombing of Pearl Harbor", "Battle of Stalingrad", "Signing of the Treaty of Versailles"));
                AnswerStrings.add(new AnswerString("The Renaissance, a period of cultural and intellectual growth, originated in which European city?","c", "London", "Florence", "Rome", "Paris"));
                AnswerStrings.add(new AnswerString("The Industrial Revolution began in which country?","D", "France", "Germany", "United States", "United Kingdom"));
                AnswerStrings.add(new AnswerString("Who is known for his theory of general relativity and the equation E=mc^2?","B", "Isaac Newton", "Albert Einstein", "Galileo Galilei", "Nikola Tesla"));
                AnswerStrings.add(new AnswerString("The Boston Tea Party was a protest against which policy of the British government?","B", "Stamp Act", "Tea Act", "Intolerable Acts", "Townshend Acts"));
                AnswerStrings.add(new AnswerString("The Battle of Waterloo, where Napoleon Bonaparte was defeated, took place in which year?","B", "1798", "1815", "1848", "1863"));
                AnswerStrings.add(new AnswerString("Who was the leader of the Soviet Union during the Cuban Missile Crisis?","C", "Vladimir Putin", "Joseph Stalin", "Nikita Khrushchev", "Mikhail Gorbachev"));
                AnswerStrings.add(new AnswerString("The 1917 Bolshevik Revolution led to the establishment of which government in Russia?","C", "Constitutional Monarchy", "Fascist Regime", "Communist Soviet Union", "Parliamentary Republic"));
                AnswerStrings.add(new AnswerString("The Renaissance, a period of cultural and intellectual growth, originated in which European ","C", "Paris", "Rome", "Florence", "London"));
                AnswerStrings.add(new AnswerString("The Treaty of Versailles was signed to officially end which major conflict?","A", "World War I", "World War II", "Korean War", "Vietnam War"));

                AnswerStrings.add(new AnswerString("The \"Trail of Tears\" refers to the forced relocation of which Native American tribes?","B", "Apache", "Cherokee", "Sioux", "Navajo"));
                AnswerStrings.add(new AnswerString("The space race between the United States and the Soviet Union reached a milestone with the landing of the first human on the moon. Who was this astronaut?","B", "Neil Armstrong", "Buzz Aldrin", "John Glenn"));
                AnswerStrings.add(new AnswerString("The Opium Wars were fought between China and which other country?","B", "Japan","United Kingdom","France","Russia"));
                AnswerStrings.add(new AnswerString("The Battle of Saratoga is considered a turning point in which conflict?","A", "American Revolution", "American Civil War", "War of 1812", "Spanish-American War"));
                AnswerStrings.add(new AnswerString("The construction of the Panama Canal was completed in which year?","B", "1901", "1914", "1923", "1938"));
                AnswerStrings.add(new AnswerString("The Marshall Plan, a U.S. initiative, aimed to provide economic aid to which region after World War II?","C", "Asia", "Africa", "Europe", "South America"));
                AnswerStrings.add(new AnswerString("The Battle of Midway, a decisive naval battle in World War II, took place between the United States and which other country?","B", "Germany", "Japan", "Italy", "Soviet Union"));
                AnswerStrings.add(new AnswerString("The Renaissance, a period of cultural and intellectual growth, originated in which European city?","C", "Paris", "Rome", "Florence", "London"));
                AnswerStrings.add(new AnswerString("The Louisiana Purchase, a significant territorial acquisition by the United States, was made from which country?","A", "France", "Spain", "Mexico", "Britain"));
                AnswerStrings.add(new AnswerString("The fall of the Berlin Wall symbolized the end of the Cold War. In which year did the Berlin Wall fall?","A", "1989", "1975", "1991", "2001"));
                break;
            case "ScienceandNature":
                AnswerStrings.add(new AnswerString(
                        "What is the chemical symbol for gold?", "A",
                        "Au",
                        "Ag",
                        "Fe",
                        "Cu"));

                AnswerStrings.add(new AnswerString(
                        "Which planet is known as the Red Planet?", "B",
                        "Venus",
                        "Mars",
                        "Jupiter",
                        "Saturn"));

                AnswerStrings.add(new AnswerString(
                        "What is the powerhouse of the cell?", "B",
                        "Nucleus",
                        "Mitochondria",
                        "Ribosome",
                        "Endoplasmic reticulum"));

                AnswerStrings.add(new AnswerString(
                        "Which gas do plants absorb during photosynthesis?", "B",
                        "Oxygen",
                        "Carbon dioxide",
                        "Nitrogen",
                        "Hydrogen"));

                AnswerStrings.add(new AnswerString(
                        "What is the largest mammal in the world?", "B",
                        "Elephant",
                        "Blue whale",
                        "Giraffe",
                        "Gorilla"));

                AnswerStrings.add(new AnswerString(
                        "What is the chemical symbol for water?", "B",
                        "W",
                        "H2O",
                        "O2",
                        "CO2"));

                AnswerStrings.add(new AnswerString(
                        "Which gas makes up the majority of the Earth's atmosphere?", "B",
                        "Oxygen",
                        "Nitrogen",
                        "Carbon dioxide",
                        "Hydrogen"));

                AnswerStrings.add(new AnswerString(
                        "What is the smallest prime number?", "C",
                        "0",
                        "1",
                        "2",
                        "3"));

                AnswerStrings.add(new AnswerString(
                        "Which planet is known as the 'Morning Star' or 'Evening Star'?", "B",
                        "Mercury",
                        "Venus",
                        "Mars",
                        "Jupiter"));

                AnswerStrings.add(new AnswerString(
                        "What is the powerhouse of the cell?", "B",
                        "Nucleus",
                        "Mitochondria",
                        "Ribosome",
                        "Endoplasmic reticulum"));

                AnswerStrings.add(new AnswerString(
                        "How many bones are there in the adult human body?", "A",
                        "206",
                        "214",
                        "220",
                        "230"));

                AnswerStrings.add(new AnswerString(
                        "Which gas do humans exhale when they breathe?", "B",
                        "Oxygen",
                        "Carbon dioxide",
                        "Nitrogen",
                        "Hydrogen"));

                AnswerStrings.add(new AnswerString(
                        "What is the chemical symbol for table salt?", "A",
                        "NaCl",
                        "HCl",
                        "CO2",
                        "O2"));

                AnswerStrings.add(new AnswerString(
                        "Which planet is known as the 'Red Planet'?", "B",
                        "Venus",
                        "Mars",
                        "Jupiter",
                        "Saturn"));

                AnswerStrings.add(new AnswerString(
                        "What is the main component of the Earth's core?", "A",
                        "Iron",
                        "Nickel",
                        "Copper",
                        "Aluminum"));

                AnswerStrings.add(new AnswerString(
                        "What is the largest organ in the human body?", "C",
                        "Liver",
                        "Heart",
                        "Skin",
                        "Lungs"));

                AnswerStrings.add(new AnswerString(
                        "Which gas is responsible for the greenhouse effect on Earth?", "C",
                        "Oxygen",
                        "Nitrogen",
                        "Carbon dioxide",
                        "Hydrogen"));

                AnswerStrings.add(new AnswerString(
                        "What is the chemical symbol for gold?", "A",
                        "Au",
                        "Ag",
                        "Fe",
                        "Cu"));

                AnswerStrings.add(new AnswerString(
                        "Which gas is commonly known as laughing gas?", "B",
                        "Oxygen",
                        "Nitrous oxide",
                        "Hydrogen",
                        "Carbon dioxide"));

                AnswerStrings.add(new AnswerString(
                        "What is the largest planet in our solar system?", "C",
                        "Mercury",
                        "Venus",
                        "Jupiter",
                        "Saturn"));

                AnswerStrings.add(new AnswerString(
                        "Which vitamin is synthesized by the human body when exposed to sunlight?", "D",
                        "Vitamin A",
                        "Vitamin B",
                        "Vitamin C",
                        "Vitamin D"));

                AnswerStrings.add(new AnswerString(
                        "What is the smallest planet in our solar system?", "A",
                        "Mercury",
                        "Venus",
                        "Mars",
                        "Earth"));

                AnswerStrings.add(new AnswerString(
                        "Which element has the chemical symbol 'O'?", "D",
                        "Oxygen",
                        "Osmium",
                        "Odium",
                        "None of the above"));

                AnswerStrings.add(new AnswerString(
                        "What is the chemical formula for the gas commonly known as laughing gas?", "B",
                        "CO2",
                        "N2O",
                        "CH4",
                        "H2O"));

                AnswerStrings.add(new AnswerString(
                        "Which famous scientist developed the theory of general relativity?", "C",
                        "Isaac Newton",
                        "Galileo Galilei",
                        "Albert Einstein",
                        "Nikola Tesla"));

                AnswerStrings.add(new AnswerString(
                        "What is the powerhouse of a plant cell?", "A",
                        "Chloroplast",
                        "Nucleus",
                        "Mitochondria",
                        "Endoplasmic reticulum"));

                AnswerStrings.add(new AnswerString(
                        "Which gas is responsible for the color of the Earth's sky?", "C",
                        "Oxygen",
                        "Nitrogen",
                        "Rayleigh scattering",
                        "Carbon dioxide"));

                AnswerStrings.add(new AnswerString(
                        "What is the chemical symbol for the element with atomic number 79?", "A",
                        "Au",
                        "Ag",
                        "Fe",
                        "Cu"));

                AnswerStrings.add(new AnswerString(
                        "In the context of ecology, what does 'biome' refer to?", "D",
                        "A type of rock formation",
                        "A unit of geological time",
                        "A type of weather pattern",
                        "A large geographical biotic unit"));

                AnswerStrings.add(new AnswerString(
                        "Which gas is produced by plants during photosynthesis?", "A",
                        "Oxygen",
                        "Carbon dioxide",
                        "Nitrogen",
                        "Hydrogen"));

                AnswerStrings.add(new AnswerString(
                        "What is the process by which plants make their own food using sunlight?", "B",
                        "Respiration",
                        "Photosynthesis",
                        "Transpiration",
                        "Germination"));

                break;
            case "LiteratureandBooks":
                AnswerStrings.add(new AnswerString(
                        "Who wrote the play 'Romeo and Juliet'?", "A",
                        "William Shakespeare",
                        "Jane Austen",
                        "Charles Dickens",
                        "F. Scott Fitzgerald"));

                AnswerStrings.add(new AnswerString(
                        "In '1984' by George Orwell, what is the name of the oppressive regime in power?", "C",
                        "The Federation",
                        "The Republic",
                        "The Party",
                        "The Empire"));

                AnswerStrings.add(new AnswerString(
                        "Who wrote the novel 'To Kill a Mockingbird'?", "B",
                        "F. Scott Fitzgerald",
                        "Harper Lee",
                        "J.K. Rowling",
                        "Mark Twain"));

                AnswerStrings.add(new AnswerString(
                        "In the Harry Potter series, what is the name of Harry's owl?", "D",
                        "Scabbers",
                        "Hedwig",
                        "Crookshanks",
                        "Nagini"));

                AnswerStrings.add(new AnswerString(
                        "What is the title of the first book in J.K. Rowling's 'Harry Potter' series?", "C",
                        "The Half-Blood Prince",
                        "The Goblet of Fire",
                        "The Philosopher's Stone",
                        "The Chamber of Secrets"));

                AnswerStrings.add(new AnswerString(
                        "Who wrote the epic poem 'The Iliad'?", "A",
                        "Homer",
                        "Virgil",
                        "Sophocles",
                        "Ovid"));

                AnswerStrings.add(new AnswerString(
                        "What is the main setting of 'Pride and Prejudice' by Jane Austen?", "B",
                        "Paris",
                        "England",
                        "Italy",
                        "America"));

                AnswerStrings.add(new AnswerString(
                        "Who wrote 'The Great Gatsby'?", "D",
                        "Jane Austen",
                        "F. Scott Fitzgerald",
                        "Ernest Hemingway",
                        "J. Salinger"));

                AnswerStrings.add(new AnswerString(
                        "What is the genre of Mary Shelley's 'Frankenstein'?", "A",
                        "Gothic fiction",
                        "Science fiction",
                        "Mystery",
                        "Romance"));

                AnswerStrings.add(new AnswerString(
                        "Who wrote 'The Catcher in the Rye'?", "B",
                        "J.K. Rowling",
                        "J. Salinger",
                        "Ernest Hemingway",
                        "F. Scott Fitzgerald"));

                AnswerStrings.add(new AnswerString(
                        "In 'The Lord of the Rings' series, who is the author of the fictional work 'The Hobbit'?", "C",
                        "J.K. Rowling",
                        "George R.R. Martin",
                        "J.R.R. Tolkien",
                        "S. Lewis"));

                AnswerStrings.add(new AnswerString(
                        "What is the opening line of Charles Dickens' 'A Tale of Two Cities'?", "D",
                        "It was a bright cold day in April, and the clocks were striking thirteen.",
                        "Call me Ishmael.",
                        "In the beginning, God created the heavens and the earth.",
                        "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness..."));

                AnswerStrings.add(new AnswerString(
                        "Who wrote 'The Odyssey'?", "A",
                        "Homer",
                        "Virgil",
                        "Sophocles",
                        "Ovid"));

                AnswerStrings.add(new AnswerString(
                        "What is the central theme of George Orwell's 'Animal Farm'?", "B",
                        "Love conquers all",
                        "Corruption of power",
                        "Exploration of the cosmos",
                        "Triumph of good over evil"));

                AnswerStrings.add(new AnswerString(
                        "Who wrote 'Wuthering Heights'?", "C",
                        "Charlotte Brontë",
                        "Jane Austen",
                        "Emily Brontë",
                        "Thomas Hardy"));

                AnswerStrings.add(new AnswerString(
                        "In the play 'Macbeth' by William Shakespeare, what prophecies are given by the three witches?", "C",
                        "Macbeth will become the King of England",
                        "Macbeth will be defeated by Macduff",
                        "Macbeth will become king but will be eventually overthrown",
                        "Macbeth will rule Scotland forever"));

                AnswerStrings.add(new AnswerString(
                        "Who wrote 'The Scarlet Letter'?", "A",
                        "Nathaniel Hawthorne",
                        "Herman Melville",
                        "Louisa May Alcott",
                        "Mark Twain"));

                AnswerStrings.add(new AnswerString(
                        "In 'The Count of Monte Cristo' by Alexandre Dumas, what is the name of the central character seeking revenge?", "B",
                        "Jean Valjean",
                        "Edmond Dantès",
                        "Heathcliff",
                        "Sherlock Holmes"));

                AnswerStrings.add(new AnswerString(
                        "Which Shakespearean play features the characters Rosencrantz and Guildenstern?", "C",
                        "Macbeth",
                        "Hamlet",
                        "Rosencrantz and Guildenstern Are Dead",
                        "Othello"));

                AnswerStrings.add(new AnswerString(
                        "Who is the author of 'One Hundred Years of Solitude'?", "A",
                        "Gabriel García Márquez",
                        "Isabel Allende",
                        "Julio Cortázar",
                        "Mario Vargas Llosa"));

                AnswerStrings.add(new AnswerString(
                        "Which novel features the character Holden Caulfield?", "B",
                        "To Kill a Mockingbird",
                        "The Catcher in the Rye",
                        "1984",
                        "Lord of the Flies"));

                AnswerStrings.add(new AnswerString(
                        "Who wrote the science fiction novel 'Dune'?", "C",
                        "Arthur  Clarke",
                        "Isaac Asimov",
                        "Frank Herbert",
                        "Philip K. Dick"));

                AnswerStrings.add(new AnswerString(
                        "What is the name of the fictional African country in the Marvel Comics universe, home to Black Panther?", "B",
                        "Latveria",
                        "Wakanda",
                        "Genovia",
                        "Elbonia"));

                AnswerStrings.add(new AnswerString(
                        "Who wrote the epic poem 'Paradise Lost'?", "A",
                        "John Milton",
                        "Dante Alighieri",
                        "Geoffrey Chaucer",
                        "William Wordsworth"));

                AnswerStrings.add(new AnswerString(
                        "In 'The Hitchhiker's Guide to the Galaxy', what is the answer to the ultimate AnswerString of life, the universe, and everything?", "C",
                        "24",
                        "42",
                        "137",
                        "99"));

                AnswerStrings.add(new AnswerString(
                        "What is the title of Jules Verne's novel about a journey to the center of the Earth?", "A",
                        "Journey to the Center of the Earth",
                        "Around the World in Eighty Days",
                        "20,000 Leagues Under the Sea",
                        "The Mysterious Island"));

                AnswerStrings.add(new AnswerString(
                        "Who wrote 'The Picture of Dorian Gray'?", "C",
                        "Charles Dickens",
                        "Leo Tolstoy",
                        "Oscar Wilde",
                        "Virginia Woolf"));

                AnswerStrings.add(new AnswerString(
                        "In 'Alice's Adventures in Wonderland', who is the cat that can appear and disappear at will?", "B",
                        "The Cheshire Cat",
                        "The Mad Hatter",
                        "The White Rabbit",
                        "The Queen of Hearts"));

                AnswerStrings.add(new AnswerString(
                        "What is the setting of the novel 'Brave New World' by Aldous Huxley?", "A",
                        "A dystopian future society",
                        "Victorian-era England",
                        "Ancient Greece",
                        "Post-apocalyptic Earth"));

                AnswerStrings.add(new AnswerString(
                        "Who wrote 'The Shining'?", "A",
                        "Stephen King",
                        "H.P. Lovecraft",
                        "Edgar Allan Poe",
                        "Bram Stoker"));

                AnswerStrings.add(new AnswerString(
                        "What is the title of the first book in S. Lewis's 'The Chronicles of Narnia' series?", "C",
                        "The Silver Chair",
                        "The Horse and His Boy",
                        "The Lion, the Witch and the Wardrobe",
                        "Prince Caspian"));

                AnswerStrings.add(new AnswerString(
                        "In 'The Diary of Anne Frank', in which city did Anne and her family go into hiding?", "B",
                        "Paris",
                        "Amsterdam",
                        "Berlin",
                        "Warsaw"));

                AnswerStrings.add(new AnswerString(
                        "What is the pen name of the author Samuel Clemens?", "D",
                        "George Eliot",
                        "Mark Twain",
                        "Lewis Carroll",
                        "Edgar Allan Poe"));

                break;
            case "MusicGenres":
                AnswerStrings.add(new AnswerString(
                        "Which music genre originated in Jamaica in the late 1960s and features a strong offbeat rhythm?","C",
                        "Blues",
                        "Jazz",
                        "Reggae",
                        "Country"));

                AnswerStrings.add(new AnswerString(
                        "In which genre is the artist Michael Jackson often referred to as the 'King of Pop'?","B",
                        "Rock",
                        "Pop",
                        "Hip-Hop",
                        "Jazz"));

                AnswerStrings.add(new AnswerString(
                        "What music genre is characterized by a fast tempo, syncopated rhythm, and brass instruments?","A",
                        "Jazz",
                        "Classical",
                        "Country",
                        "Electronic"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre is often associated with electric guitars, bass, and drums and is known for its loud and energetic sound?","D",
                        "Blues",
                        "Jazz",
                        "Reggae",
                        "Rock"));

                AnswerStrings.add(new AnswerString(
                        "In which genre does the artist Beyoncé primarily work?","C",
                        "Hip-Hop",
                        "Country",
                        "R&B (Rhythm and Blues)",
                        "Electronic"));

                AnswerStrings.add(new AnswerString(
                        "What music genre is characterized by a fusion of hip-hop and electronic dance music (EDM)?","D",
                        "Rock",
                        "Pop",
                        "Jazz",
                        "Trap"));

                AnswerStrings.add(new AnswerString(
                        "In which genre is the artist Johnny Cash known as the 'Man in Black'?","A",
                        "Country",
                        "Blues",
                        "Rock",
                        "Folk"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre originated in New Orleans and is known for its brass bands, piano, and syncopated rhythms?","B",
                        "Salsa",
                        "Jazz",
                        "Reggae",
                        "Classical"));

                AnswerStrings.add(new AnswerString(
                        "In which genre do artists like Bob Marley and Peter Tosh make significant contributions?","C",
                        "Jazz",
                        "Rock",
                        "Reggae",
                        "Hip-Hop"));

                AnswerStrings.add(new AnswerString(
                        "What music genre is characterized by its use of synthesizers, drum machines, and computer-generated sounds?","D",
                        "Classical",
                        "Jazz",
                        "Blues",
                        "Electronic"));

                AnswerStrings.add(new AnswerString(
                        "In which genre is the artist Eminem known for his contributions?","B",
                        "Pop",
                        "Hip-Hop",
                        "Country",
                        "Rock"));

                AnswerStrings.add(new AnswerString(
                        "What music genre originated in African American communities in the Southern United States and is characterized by its soulful vocals and steady beat?","A",
                        "Blues",
                        "Classical",
                        "Reggae",
                        "Folk"));

                AnswerStrings.add(new AnswerString(
                        "In which genre is the artist Taylor Swift known for her work?","C",
                        "Jazz",
                        "Rock",
                        "Country",
                        "Hip-Hop"));

                AnswerStrings.add(new AnswerString(
                        "What music genre is characterized by its emphasis on lyrics, storytelling, and the use of acoustic instruments?","D",
                        "Hip-Hop",
                        "Electronic",
                        "Jazz",
                        "Folk"));

                AnswerStrings.add(new AnswerString(
                        "In which genre is the artist Elvis Presley often referred to as the 'King of Rock and Roll'?","C",
                        "Pop",
                        "Country",
                        "Rock",
                        "Blues"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre emerged in the late 1970s and features fast tempos, short song durations, and often politically charged lyrics?","A",
                        "Punk",
                        "Reggae",
                        "Jazz",
                        "Hip-Hop"));

                AnswerStrings.add(new AnswerString(
                        "In which genre does the artist Lady Gaga primarily work?","B",
                        "Rock",
                        "Pop",
                        "Country",
                        "R&B (Rhythm and Blues)"));

                AnswerStrings.add(new AnswerString(
                        "What music genre originated in the African American communities of New Orleans and is characterized by its brass instruments and lively, upbeat rhythms?","B",
                        "Salsa",
                        "Jazz",
                        "Reggae",
                        "Classical"));

                AnswerStrings.add(new AnswerString(
                        "In which genre does the artist Bob Dylan make significant contributions?","D",
                        "Pop",
                        "Country",
                        "Rock",
                        "Folk"));

                AnswerStrings.add(new AnswerString(
                        "What music genre emerged in the late 1980s and is characterized by its use of sampling, scratching, and rapping?","B",
                        "Rock",
                        "Hip-Hop",
                        "Jazz",
                        "Reggae"));

                AnswerStrings.add(new AnswerString(
                        "In which genre is the artist Adele known for her contributions?","C",
                        "Pop",
                        "Electronic",
                        "R&B (Rhythm and Blues)",
                        "Country"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre originated in the Southern United States and is characterized by its three-chord structure and simple melodies?","A",
                        "Country",
                        "Blues",
                        "Rock",
                        "Jazz"));

                AnswerStrings.add(new AnswerString(
                        "In which genre does the artist Jay-Z make significant contributions?","B",
                        "Classical",
                        "Hip-Hop",
                        "Electronic",
                        "Pop"));

                AnswerStrings.add(new AnswerString(
                        "What music genre originated in the African American communities of New Orleans and is characterized by its improvisation and swing rhythms?","B",
                        "Salsa",
                        "Jazz",
                        "Reggae",
                        "Rock"));

                AnswerStrings.add(new AnswerString(
                        "In which genre does the artist Shakira primarily work?","A",
                        "Pop",
                        "Rock",
                        "Reggae",
                        "Country"));

                AnswerStrings.add(new AnswerString(
                        "What music genre originated in the United Kingdom in the late 1970s and is characterized by its rebellious attitude and DIY ethos?","A",
                        "Punk",
                        "Hip-Hop",
                        "Classical",
                        "Country"));

                AnswerStrings.add(new AnswerString(
                        "In which genre is the artist Bruno Mars known for his contributions?","B",
                        "Pop",
                        "R&B (Rhythm and Blues)",
                        "Rock",
                        "Electronic"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre originated in the African American communities of the Southern United States and is characterized by its call-and-response style and improvisation?","A",
                        "Blues",
                        "Electronic",
                        "Jazz",
                        "Country"));

                AnswerStrings.add(new AnswerString(
                        "In which genre is the artist Katy Perry known for her work?","B",
                        "Pop",
                        "Pop",
                        "Country",
                        "Rock"));

                AnswerStrings.add(new AnswerString(
                        "What music genre is characterized by its use of turntables, drum machines, and spoken word lyrics?","B",
                        "Jazz",
                        "Hip-Hop",
                        "Rock",
                        "Classical"));

                AnswerStrings.add(new AnswerString(
                        "In which genre does the artist Rihanna primarily work?","C",
                        "Pop",
                        "R&B (Rhythm and Blues)",
                        "Pop",
                        "Electronic"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre is characterized by its use of synthesizers, drum machines, and a futuristic sound?","D",
                        "Jazz",
                        "Hip-Hop",
                        "Reggae",
                        "Electronic"));

                break;
            case "SportsTrivia":
                AnswerStrings.add(new AnswerString(
                        "Which sport is known as the 'king of sports' and is played with a small, hard ball and a mallet?", "C",
                        "Soccer",
                        "Tennis",
                        "Polo",
                        "Golf"));

                AnswerStrings.add(new AnswerString(
                        "In which sport is the term 'slam dunk' commonly used?", "B",
                        "Soccer",
                        "Basketball",
                        "Baseball",
                        "Volleyball"));

                AnswerStrings.add(new AnswerString(
                        "Which athlete is often referred to as 'The Greatest' and 'The People's Champion'?", "D",
                        "Michael Phelps",
                        "Lionel Messi",
                        "Serena Williams",
                        "Muhammad Ali"));

                AnswerStrings.add(new AnswerString(
                        "In golf, what is the term for completing a hole in one stroke under par?", "A",
                        "Birdie",
                        "Eagle",
                        "Bogey",
                        "Par"));

                AnswerStrings.add(new AnswerString(
                        "Which country hosted the 2016 Summer Olympics?", "B",
                        "United States",
                        "Brazil",
                        "China",
                        "Russia"));

                AnswerStrings.add(new AnswerString(
                        "What is the highest score a gymnast can achieve in a perfect routine?", "B",
                        "8.5",
                        "10",
                        "12",
                        "15"));

                AnswerStrings.add(new AnswerString(
                        "Which team won the first FIFA World Cup in 1930?", "A",
                        "Uruguay",
                        "Brazil",
                        "Germany",
                        "Italy"));

                AnswerStrings.add(new AnswerString(
                        "In American football, how many points is a touchdown worth?", "C",
                        "3",
                        "5",
                        "6",
                        "7"));

                AnswerStrings.add(new AnswerString(
                        "Which city hosted the 2016 Summer Olympics?", "B",
                        "Tokyo",
                        "Rio de Janeiro",
                        "London",
                        "Beijing"));

                AnswerStrings.add(new AnswerString(
                        "What is the term for a perfect score of 300 in a game of bowling?", "D",
                        "Eagle",
                        "Strike",
                        "Spare",
                        "Perfect Game"));

                AnswerStrings.add(new AnswerString(
                        "In tennis, what is the term for a zero score?", "C",
                        "Love",
                        "Fault",
                        "Zero",
                        "Nil"));

                AnswerStrings.add(new AnswerString(
                        "Who is the all-time leading scorer in NBA history?", "A",
                        "Kareem Abdul-Jabbar",
                        "LeBron James",
                        "Michael Jordan",
                        "Kobe Bryant"));

                AnswerStrings.add(new AnswerString(
                        "Which country won the most gold medals in the 2012 Summer Olympics?", "C",
                        "United States",
                        "China",
                        "Great Britain",
                        "Russia"));

                AnswerStrings.add(new AnswerString(
                        "What is the term for a three-strike sequence in bowling?", "B",
                        "Spare",
                        "Turkey",
                        "Strikeout",
                        "Hat Trick"));

                AnswerStrings.add(new AnswerString(
                        "Which sport is played on a diamond-shaped field and features bases that players must run to?", "A",
                        "Baseball",
                        "Soccer",
                        "Hockey",
                        "Cricket"));

                AnswerStrings.add(new AnswerString(
                        "Who won the gold medal in the men's 100 meters at the 2016 Summer Olympics?", "B",
                        "Usain Bolt",
                        "Justin Gatlin",
                        "Andre De Grasse",
                        "Yohan Blake"));

                AnswerStrings.add(new AnswerString(
                        "In soccer, what is the term for a situation where a player scores three goals in a single game?", "C",
                        "Hat Trick",
                        "Grand Slam",
                        "Golden Boot",
                        "Triple Play"));

                AnswerStrings.add(new AnswerString(
                        "Which boxer was known as 'The Greatest' and 'The People's Champion'?", "D",
                        "Mike Tyson",
                        "Sugar Ray Leonard",
                        "Floyd Mayweather",
                        "Muhammad Ali"));

                AnswerStrings.add(new AnswerString(
                        "In golf, what is the term for completing a hole in two strokes under par?", "A",
                        "Eagle",
                        "Birdie",
                        "Albatross",
                        "Bogey"));

                AnswerStrings.add(new AnswerString(
                        "Which team won the FIFA Women's World Cup in 2019?", "A",
                        "United States",
                        "Netherlands",
                        "Sweden",
                        "Germany"));

                AnswerStrings.add(new AnswerString(
                        "What is the term for a perfect score of 180 in a game of darts?", "C",
                        "Bullseye",
                        "Triple Crown",
                        "Nine-Dart Finish",
                        "Double Trouble"));

                AnswerStrings.add(new AnswerString(
                        "Which country hosted the 2018 Winter Olympics?", "D",
                        "Canada",
                        "Russia",
                        "Germany",
                        "South Korea"));

                AnswerStrings.add(new AnswerString(
                        "What is the term for a situation in baseball where a pitcher throws three strikes to a batter?", "A",
                        "Strikeout",
                        "Home Run",
                        "Foul Ball",
                        "Walk"));

                AnswerStrings.add(new AnswerString(
                        "Who won the gold medal in the women's all-around gymnastics at the 2016 Summer Olympics?", "A",
                        "Simone Biles",
                        "Aly Raisman",
                        "Gabby Douglas",
                        "Laurie Hernandez"));

                AnswerStrings.add(new AnswerString(
                        "Which country has won the most FIFA World Cup titles?", "C",
                        "Brazil",
                        "Germany",
                        "Italy",
                        "Argentina"));

                AnswerStrings.add(new AnswerString(
                        "In baseball, how many strikes are required to make an 'out'?", "B",
                        "1",
                        "3",
                        "4",
                        "2"));

                AnswerStrings.add(new AnswerString(
                        "Who holds the record for the most Grand Slam singles titles in tennis?", "C",
                        "Rafael Nadal",
                        "Roger Federer",
                        "Serena Williams",
                        "Novak Djokovic"));

                AnswerStrings.add(new AnswerString(
                        "What is the term for a perfect score of 300 in a game of bowling?", "D",
                        "Turkey",
                        "Strike",
                        "Spare",
                        "Perfect Game"));

                AnswerStrings.add(new AnswerString(
                        "In basketball, how many players are on the court for each team at the start of a game?", "B",
                        "5",
                        "5",
                        "6",
                        "7"));

                AnswerStrings.add(new AnswerString(
                        "Which country hosted the 2014 Winter Olympics?", "A",
                        "Russia",
                        "Canada",
                        "Norway",
                        "United States"));

                break;
            case "ArtandArtists":
                AnswerStrings.add(new AnswerString(
                        "Which artist is known for painting the Mona Lisa?", "C",
                        "Pablo Picasso",
                        "Vincent van Gogh",
                        "Leonardo da Vinci",
                        "Claude Monet"));

                AnswerStrings.add(new AnswerString(
                        "Who sculpted the statue of David?", "B",
                        "Auguste Rodin",
                        "Michelangelo",
                        "Donatello",
                        "Leonardo da Vinci"));

                AnswerStrings.add(new AnswerString(
                        "Which art movement included artists such as Salvador Dalí and René Magritte?", "A",
                        "Surrealism",
                        "Cubism",
                        "Impressionism",
                        "Abstract Expressionism"));

                AnswerStrings.add(new AnswerString(
                        "Who painted 'Starry Night'?", "B",
                        "Claude Monet",
                        "Vincent van Gogh",
                        "Pablo Picasso",
                        "Georgia O'Keeffe"));

                AnswerStrings.add(new AnswerString(
                        "The painting 'The Persistence of Memory' features melting clocks and was created by which artist?", "A",
                        "Salvador Dalí",
                        "Pablo Picasso",
                        "Frida Kahlo",
                        "Jackson Pollock"));

                AnswerStrings.add(new AnswerString(
                        "Which artist is known for his 'Campbell's Soup Cans' artwork?", "C",
                        "Pablo Picasso",
                        "Vincent van Gogh",
                        "Andy Warhol",
                        "Jackson Pollock"));

                AnswerStrings.add(new AnswerString(
                        "Who painted 'The Birth of Venus'?", "D",
                        "Michelangelo",
                        "Leonardo da Vinci",
                        "Raphael",
                        "Sandro Botticelli"));

                AnswerStrings.add(new AnswerString(
                        "Which art movement was characterized by geometric shapes and primary colors?", "B",
                        "Surrealism",
                        "Cubism",
                        "Impressionism",
                        "Abstract Expressionism"));

                AnswerStrings.add(new AnswerString(
                        "Who is known for his sculptures 'The Thinker' and 'The Kiss'?", "A",
                        "Auguste Rodin",
                        "Michelangelo",
                        "Donatello",
                        "Leonardo da Vinci"));

                AnswerStrings.add(new AnswerString(
                        "The painting 'Guernica,' depicting the horrors of war, was created by which artist?", "C",
                        "Salvador Dalí",
                        "Pablo Picasso",
                        "Pablo Picasso",
                        "Jackson Pollock"));

                AnswerStrings.add(new AnswerString(
                        "Who is known for his colorful depictions of water lilies in his paintings?", "A",
                        "Claude Monet",
                        "Vincent van Gogh",
                        "Georgia O'Keeffe",
                        "Wassily Kandinsky"));

                AnswerStrings.add(new AnswerString(
                        "Which artist is associated with the painting 'The Girl with a Pearl Earring'?", "D",
                        "Claude Monet",
                        "Vincent van Gogh",
                        "Pablo Picasso",
                        "Johannes Vermeer"));

                AnswerStrings.add(new AnswerString(
                        "Who is known for his kinetic sculptures and mobiles?", "B",
                        "Auguste Rodin",
                        "Alexander Calder",
                        "Donatello",
                        "Leonardo da Vinci"));

                AnswerStrings.add(new AnswerString(
                        "Which art movement emerged in the 1950s and emphasized spontaneous, expressive brushwork?", "D",
                        "Surrealism",
                        "Cubism",
                        "Impressionism",
                        "Abstract Expressionism"));

                AnswerStrings.add(new AnswerString(
                        "Who is considered the founder of the Renaissance?", "C",
                        "Leonardo da Vinci",
                        "Michelangelo",
                        "Giotto",
                        "Raphael"));

                AnswerStrings.add(new AnswerString(
                        "The painting 'American Gothic,' featuring a farmer and his daughter, was created by which artist?", "A",
                        "Grant Wood",
                        "Edward Hopper",
                        "Georgia O'Keeffe",
                        "Jackson Pollock"));

                AnswerStrings.add(new AnswerString(
                        "Who is known for his use of dots to create images, a technique called pointillism?", "B",
                        "Claude Monet",
                        "Georges Seurat",
                        "Wassily Kandinsky",
                        "Piet Mondrian"));

                AnswerStrings.add(new AnswerString(
                        "Which artist is known for his large, colorful sculptures of balloon animals?", "C",
                        "Jeff Koons",
                        "Damien Hirst",
                        "Jeff Koons",
                        "Banksy"));

                AnswerStrings.add(new AnswerString(
                        "Who painted 'The Scream'?", "A",
                        "Edvard Munch",
                        "Vincent van Gogh",
                        "Salvador Dalí",
                        "Leonardo da Vinci"));

                AnswerStrings.add(new AnswerString(
                        "The art movement known for its focus on everyday objects and scenes is called:", "B",
                        "Cubism",
                        "Realism",
                        "Abstract Expressionism",
                        "Surrealism"));

                AnswerStrings.add(new AnswerString(
                        "Who is known for his colorful, abstract paintings and his cut-out collages?", "C",
                        "Pablo Picasso",
                        "Wassily Kandinsky",
                        "Henri Matisse",
                        "Jackson Pollock"));

                AnswerStrings.add(new AnswerString(
                        "Which artist is associated with the 'drip painting' technique?", "D",
                        "Salvador Dalí",
                        "Pablo Picasso",
                        "Wassily Kandinsky",
                        "Jackson Pollock"));

                AnswerStrings.add(new AnswerString(
                        "Who painted 'The Last Supper'?", "B",
                        "Leonardo da Vinci",
                        "Leonardo da Vinci",
                        "Raphael",
                        "Michelangelo"));

                AnswerStrings.add(new AnswerString(
                        "The art movement characterized by distorted and exaggerated depictions of the human figure is called:", "A",
                        "Expressionism",
                        "Cubism",
                        "Realism",
                        "Impressionism"));

                AnswerStrings.add(new AnswerString(
                        "Who is known for his abstract, colorful compositions and co-founding the De Stijl movement?", "D",
                        "Pablo Picasso",
                        "Wassily Kandinsky",
                        "Henri Matisse",
                        "Piet Mondrian"));

                AnswerStrings.add(new AnswerString(
                        "The famous painting 'The Night Watch' was created by:", "C",
                        "Rembrandt",
                        "Johannes Vermeer",
                        "Rembrandt",
                        "Hieronymus Bosch"));

                AnswerStrings.add(new AnswerString(
                        "Which artist is known for his use of light and shadows in paintings such as 'The Calling of Saint Matthew'?", "A",
                        "Caravaggio",
                        "Leonardo da Vinci",
                        "Raphael",
                        "Michelangelo"));

                AnswerStrings.add(new AnswerString(
                        "Who is known for his abstract, geometric paintings and his role in the Bauhaus movement?", "B",
                        "Pablo Picasso",
                        "Wassily Kandinsky",
                        "Henri Matisse",
                        "Jackson Pollock"));

                AnswerStrings.add(new AnswerString(
                        "In basketball, how many players are on the court for each team at the start of a game?", "B",
                        "5",
                        "5",
                        "6",
                        "7"));

                AnswerStrings.add(new AnswerString(
                        "Which country hosted the 2014 Winter Olympics?", "A",
                        "Russia",
                        "Canada",
                        "Norway",
                        "United States"));


                break;
            case "GeographyBee":
                AnswerStrings.add(new AnswerString(
                        "Which music genre originated in Jamaica and features a prominent offbeat rhythm?", "C",
                        "Jazz",
                        "Rock",
                        "Reggae",
                        "Country"));

                AnswerStrings.add(new AnswerString(
                        "The genre of flamenco music has its roots in which country?", "A",
                        "Spain",
                        "Brazil",
                        "India",
                        "Mexico"));

                AnswerStrings.add(new AnswerString(
                        "What music genre is often associated with New Orleans and features brass band instrumentation?", "D",
                        "Hip Hop",
                        "Salsa",
                        "Blues",
                        "Dixieland Jazz"));

                AnswerStrings.add(new AnswerString(
                        "Which genre of music is characterized by its use of turntables, samples, and rap vocals?", "B",
                        "Rock",
                        "Hip Hop",
                        "Country",
                        "Classical"));

                AnswerStrings.add(new AnswerString(
                        "Fado, a music genre known for its melancholic and expressive themes, is associated with which country?", "C",
                        "Argentina",
                        "France",
                        "Portugal",
                        "Greece"));

                AnswerStrings.add(new AnswerString(
                        "The didgeridoo, an indigenous Australian instrument, is often featured in music of which genre?", "A",
                        "Aboriginal",
                        "Celtic",
                        "Polka",
                        "Flamenco"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre originated in the Appalachian region of the United States and often features banjos and fiddles?", "D",
                        "Ska",
                        "Tango",
                        "Bossa Nova",
                        "Bluegrass"));

                AnswerStrings.add(new AnswerString(
                        "Bollywood music, known for its vibrant and eclectic compositions, comes from which country's film industry?", "B",
                        "Japan",
                        "India",
                        "South Korea",
                        "Nigeria"));

                AnswerStrings.add(new AnswerString(
                        "Which genre of music has its roots in African American communities in the southern United States and often expresses sorrow or hardship?", "C",
                        "Gospel",
                        "Punk",
                        "Blues",
                        "Reggaeton"));

                AnswerStrings.add(new AnswerString(
                        "Tango music originated in the working-class neighborhoods of which South American city?", "A",
                        "Buenos Aires",
                        "Rio de Janeiro",
                        "Santiago",
                        "Lima"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre is closely associated with the Caribbean and features a steel drum instrument?", "C",
                        "Flamenco",
                        "Polka",
                        "Calypso",
                        "Mariachi"));

                AnswerStrings.add(new AnswerString(
                        "K-Pop, a genre that originated in South Korea, gained international popularity. What does 'K' stand for in K-Pop?", "B",
                        "Korean",
                        "Korean",
                        "Kite",
                        "Kingdom"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre is characterized by its use of electronic instruments, synthesizers, and a repetitive beat?", "A",
                        "Electronic Dance Music (EDM)",
                        "Folk",
                        "Jazz",
                        "R&B"));

                AnswerStrings.add(new AnswerString(
                        "The music of mariachi, featuring trumpets and violins, has its origins in which country?", "D",
                        "Brazil",
                        "Spain",
                        "Mexico",
                        "Poland"));

                AnswerStrings.add(new AnswerString(
                        "Samba, a lively and rhythmical music genre, is associated with the Carnival celebrations in which country?", "C",
                        "Italy",
                        "Argentina",
                        "Brazil",
                        "Spain"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre emerged in Jamaica in the late 1950s and is known for its upbeat tempo and offbeat rhythm?", "B",
                        "Blues",
                        "Ska",
                        "Country",
                        "Hip Hop"));

                AnswerStrings.add(new AnswerString(
                        "What music genre is characterized by its use of bagpipes and often associated with Scottish and Irish culture?", "C",
                        "Flamenco",
                        "Bluegrass",
                        "Celtic",
                        "Reggae"));

                AnswerStrings.add(new AnswerString(
                        "The accordion is a prominent instrument in which European music genre known for its polkas and waltzes?", "D",
                        "Flamenco",
                        "Tango",
                        "Samba",
                        "Polka"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre, known for its use of the banjo and storytelling lyrics, has roots in the American South?", "A",
                        "Folk",
                        "Reggae",
                        "Heavy Metal",
                        "Jazz"));

                AnswerStrings.add(new AnswerString(
                        "Gamelan music, featuring traditional Indonesian instruments, is associated with the culture of which country?", "C",
                        "Vietnam",
                        "Thailand",
                        "Indonesia",
                        "Malaysia"));

                AnswerStrings.add(new AnswerString(
                        "What genre of music originated in the Mississippi Delta and often features slide guitar and harmonica?", "C",
                        "Hip Hop",
                        "Blues",
                        "Delta Blues",
                        "Bluegrass"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre, originating in the Brazilian favelas, is known for its rapid beats and social commentary?", "D",
                        "Tango",
                        "Samba",
                        "Bossa Nova",
                        "Funk Carioca"));

                AnswerStrings.add(new AnswerString(
                        "In which country did the accordion-driven music genre known as Zydeco originate?", "A",
                        "United States",
                        "France",
                        "Mexico",
                        "Italy"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre, popularized in the 1970s, features elaborate stage shows, face paint, and flamboyant costumes?", "D",
                        "Disco",
                        "Punk",
                        "Grunge",
                        "Glam Rock"));

                AnswerStrings.add(new AnswerString(
                        "The instrument known as the bouzouki is commonly associated with the music of which country?", "B",
                        "Turkey",
                        "Greece",
                        "Egypt",
                        "Iran"));

                AnswerStrings.add(new AnswerString(
                        "Which music genre, originating in the Mississippi Delta and often features slide guitar and harmonica?", "C",
                        "Hip Hop",
                        "Blues",
                        "Delta Blues",
                        "Bluegrass"));

                AnswerStrings.add(new AnswerString(
                        "What music genre is characterized by its use of turntables, samples, and rap vocals?", "B",
                        "Rock",
                        "Hip Hop",
                        "Country",
                        "Classical"));

                AnswerStrings.add (new AnswerString("Which music genre originated in the United States and often features spoken-word lyrics over a strong rhythmic backing?", "B",
                        "Jazz",
                        "Rap",
                        "Blues",
                        "Rock"));



                // Add more AnswerStrings for Famous Inventors...
                break;
            // Add cases for other categories...
            default:
                break;
        }

        // Load the first AnswerString
        loadAnswerString();
    }

    private void loadAnswerString() {
        if (!AnswerStrings.isEmpty()) {
            AnswerString q = AnswerStrings.remove(0);
            AnswerStringText.setText(q.getAnswerString());
            AnswerStringA.setText(q.getOptionA());
            AnswerStringB.setText(q.getOptionB());
            AnswerStringC.setText(q.getOptionC());
            AnswerStringD.setText(q.getOptionD());
            rightAnswer = q.getRightAnswer();
        } else {
            showScore();
        }
    }

    private Intent isRightOrWrong(String answer) {
        Intent screen;
        if (answer.equals(rightAnswer)) {
            score += 1;
            screen = new Intent(this, CorrectAnswer.class);
        } else {
            screen = new Intent(this, WrongAnswer.class);
        }
        return screen;
    }
    private void setRadioListeners() {
        confirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AnswerStringA.isChecked()) {
                    answer = "A";
                } else if (AnswerStringB.isChecked()) {
                    answer = "B";
                } else if (AnswerStringC.isChecked()) {
                    answer = "C";
                } else if (AnswerStringD.isChecked()) {
                    answer = "D";
                }

                if (answer != null) {
                    startActivity(isRightOrWrong(answer));
                    loadAnswerString();
                }
            }
        });
    }


    private void showScore() {
        Intent intent = new Intent(this, ShowScore.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

}
