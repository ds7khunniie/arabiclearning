package ap.arabiclearning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dowopen on 9/1/2559.
 */
public class lessons_category extends Activity{
    Button ba1;
    Button ba2;
    Button ba3;
    Button ba4;
    @Override
    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons_category);

            ba1 = (Button) findViewById(R.id.a1);
           ba2  = (Button) findViewById(R.id.a2);
            ba3 = (Button) findViewById(R.id.a3);
            ba4 = (Button) findViewById(R.id.a4);
        }

    public void clicka1(View view) {
        Intent d = new Intent(getApplicationContext(), alphabet.class);
        startActivity(d);

    }

    public void clicka2(View view) {
        Intent e = new Intent(getApplicationContext(), writing.class);
        startActivity(e);
    }

    public void clicka3(View view) {
        Intent d = new Intent(getApplicationContext(), vowel.class);
        startActivity(d);
    }

    public void clicka4(View view) {
        Intent f = new Intent(getApplicationContext(), number.class);
        startActivity(f);
    }
}
