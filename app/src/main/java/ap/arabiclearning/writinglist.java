package ap.arabiclearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Dowopen on 8/3/2559.
 */
public class writinglist extends BaseActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writinglist);
        setDrawer(true);
        setTitle(R.string.note);

        String[] str = { "How to writing", "Basic writing 1", "Basic writing 2", "Basic writing 3", "Basic writing 4" };

        ListView listView1 = (ListView)findViewById(R.id.listw);
        listView1.setAdapter(new ArrayAdapter(this
                , android.R.layout.simple_list_item_1, str));
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0
                    , View arg1, int arg2, long arg3) {
                Intent intent;
                switch(arg2) {
                    case 0 :
                        intent = new Intent(getApplicationContext()
                                , writingvdo1.class);
                        startActivity(intent);
                        break;
                    case 1 :
                        intent = new Intent(getApplicationContext()
                                , writingvdo2.class);
                        startActivity(intent);
                        break;
                    case 2 :
                        intent = new Intent(getApplicationContext()
                                , writingvdo3.class);
                        startActivity(intent);
                        break;
                    case 3 :
                        intent = new Intent(getApplicationContext()
                                , writingvdo4.class);
                        startActivity(intent);
                        break;
                    case 4 :
                        intent = new Intent(getApplicationContext()
                                , writingvdo5.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
