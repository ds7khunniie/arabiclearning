package ap.arabiclearning;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

public class ArabicLearningApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
