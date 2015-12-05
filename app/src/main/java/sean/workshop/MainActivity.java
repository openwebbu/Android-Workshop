package sean.workshop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int counter = 0;
    private static String[] quotes = {"Life is a crazy, mystical thing. And sometimes, you just go out like a buster."
            , "Mistakes are always forgivable, if one has the courage to admit them.", "We all make choices in life, but in the end our choices make us.", "I'm selfish, impatient and a little insecure. I make mistakes, I am out of control and at times hard to handle. But if you can't handle me at my worst, then you sure as hell don't deserve me at my best.", "I've learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel.", "Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that."};
    private static String[] authorArray = {"C9 Mango", "Bruce Lee", "Andrew Ryan", "Marilyn Monroe", "Maya Angelou", "Martin Luther King Jr."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Quotes");
        setSupportActionBar(toolbar);

        final TextView quoteText = (TextView) findViewById(R.id.quoteText);
        final TextView quoteNumber = (TextView) findViewById(R.id.quoteNum);
        final TextView authors = (TextView) findViewById(R.id.author);

        final Button nextButton = (Button) findViewById(R.id.buttonNext);
        final Button prevButton = (Button) findViewById(R.id.buttonPrev);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter < 5) {
                    counter++;
                    quoteText.setText(quotes[counter]);
                    quoteNumber.setText(counter+1 + "/6");
                    authors.setText(authorArray[counter]);
                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(counter > 0) {
                    counter--;
                    quoteText.setText(quotes[counter]);
                    quoteNumber.setText(counter+1 + "/6");
                    authors.setText(authorArray[counter]);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
