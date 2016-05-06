package ap.arabiclearning;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by Dowopen on 8/1/2559.
 */
public class SplashScreen extends ap.arabiclearning.MyActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(SplashScreen.this, ap.arabiclearning.MyActivity.class);
                SplashScreen.this.startActivity(splashIntent);
                SplashScreen.this.finish();
            }

        }, SPLASH_TIME_OUT);
    }
}