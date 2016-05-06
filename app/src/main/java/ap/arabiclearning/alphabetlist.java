package ap.arabiclearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * Created by Dowopen on 8/2/2559.
 */
public class alphabetlist extends BaseActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alphabetlist);
        setDrawer(true);
        setTitle(R.string.note);
        String[] str = { "Introduction", "Consonant 1", "Consonant 2" };

        ListView listView1 = (ListView)findViewById(R.id.lista);
        listView1.setAdapter(new ArrayAdapter(this
                , android.R.layout.simple_list_item_1, str));
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0
                    , View arg1, int arg2, long arg3) {
                Intent intent;
                switch(arg2) {
                    case 0 :
                        intent = new Intent(getApplicationContext()
                                , alphabetvdo1.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getApplicationContext()
                                , alphabetvdo2.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(getApplicationContext()
                                , alphabetvdo3.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}