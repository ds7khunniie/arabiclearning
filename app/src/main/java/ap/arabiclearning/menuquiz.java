package ap.arabiclearning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class menuquiz extends Activity{
    ImageButton imageButton1;
    ImageButton imageButton2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuquiz);
        imageButton1 = (ImageButton) findViewById(R.id.buttonquiz);
        imageButton2 = (ImageButton) findViewById(R.id.buttonhistory);

    }

    public void clickbuttonquiz(View view) {
        Intent aa = new Intent(getApplicationContext(), ap.arabiclearning.quizlist.class);
        startActivity(aa);

    }

    public void clickbuttonhistory(View view) {
        Intent bb = new Intent(getApplicationContext(), ap.arabiclearning.history.class);
        startActivity(bb);
    }
}
