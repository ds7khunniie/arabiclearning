package ap.arabiclearning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class quizlist extends BaseActivity {

    private ListView quizlist;

    //private String[]  Colums = {'_id' , 'Col_Listen' ,'Col_SetQuiz','Col_Questions' }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizlist);
        setDrawer(true);


        String[] str = { "แบบทดสอบบทที่ 1 ชุดที่ 1 พยัญชนะ", "แบบทดสอบบทที่ 1 ชุดที่ 2 การเขียนตัวพยัญชนะติดกัน", "แบบทดสอบบทที่ 2 สระ" ,"แบบทดสอบบทที่ 3  ตัวเลข"};

        ListView listView1 = (ListView)findViewById(R.id.quizlist);
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, str);
        listView1.setAdapter(itemsAdapter);
        //listView1.setAdapter(new ArrayAdapter (this, android.R.layout.simple_list_item_1,str) );
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0
                    , View arg1, int arg2, long arg3) {
                Intent intent;
                Bundle bundle = new Bundle();
                switch (arg2) {
                    case 0:
                        intent = new Intent(getApplicationContext()
                                , ap.arabiclearning.quizfrom.class);
                        Bundle a = new Bundle();
                        a.putString("page","1");
                        intent.putExtras(a);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getApplicationContext()
                                , quizfrom.class);
                        Bundle b = new Bundle();
                        b.putString("page","2");
                        intent.putExtras(b);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext()
                                , quizfrom.class);
                        Bundle c = new Bundle();
                        c.putString("page","3");
                        intent.putExtras(c);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext()
                                , quizfrom.class);

                        Bundle d = new Bundle();
                        d.putString("page","4");
                        intent.putExtras(d);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

}
