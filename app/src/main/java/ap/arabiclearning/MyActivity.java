package ap.arabiclearning;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
public class MyActivity extends Activity {
    ImageButton imageButton1;
    ImageButton imageButton2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        imageButton1 = (ImageButton) findViewById(R.id.button1);
        imageButton2 = (ImageButton) findViewById(R.id.button2);
    }

    public void clickImageButton1(View view) {
        Intent a = new Intent(getApplicationContext(), lessons_category.class);
        startActivity(a);

    }

    public void clickImageButton2(View view) {
        Intent b = new Intent(getApplicationContext(), myquote.class);
        startActivity(b);
    }
}