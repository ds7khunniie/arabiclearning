package ap.arabiclearning;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

;

public class MyActivity extends Activity {
    ImageButton imageButton1;
    ImageButton imageButton2;
    ImageButton imageButton3;
    ImageButton imageButton4;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        imageButton1 = (ImageButton) findViewById(R.id.button1);
        imageButton2 = (ImageButton) findViewById(R.id.button2);
        imageButton3 = (ImageButton) findViewById(R.id.button3);
        imageButton4 = (ImageButton) findViewById(R.id.button4);
    }
//ปุม1
    public void clickImageButton1(View view) {
        Intent a = new Intent(getApplicationContext(), ap.arabiclearning.lessons_category.class);
        startActivity(a);

    }

    public void clickImageButton2(View view) {
        Intent b = new Intent(getApplicationContext(), ap.arabiclearning.ListActivity.class);
        startActivity(b);
    }

    public void clickImageButton3(View view) {
        Intent c = new Intent(getApplicationContext(), ap.arabiclearning.menuquiz.class);
        startActivity(c);
    }


    public void clickImageButton4(View view) {
        finish();
        System.exit(0);
}
}