package ap.arabiclearning;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class history extends BaseActivity {
    private dbQuiz databaseFirst;
    private TextView textDate;
    private TextView textTop;
    private TextView textScores;
    private TextView textT;
    private TextView textF;
    private Button Button1;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        Button1 = (Button) findViewById(R.id.btnOk);
        textDate = (TextView)findViewById(R.id.textView3);
        textTop = (TextView)findViewById(R.id.textView6);
        textScores = (TextView)findViewById(R.id.textScore);
        textT = (TextView)findViewById(R.id.textView8);
        textF = (TextView)findViewById(R.id.textView9);
        String str = "";
        databaseFirst = new dbQuiz(this);
        SQLiteDatabase db = databaseFirst.getReadableDatabase();
        String countQuery = "SELECT  * FROM  myScores ";
        Cursor cursor = db.rawQuery(countQuery, null);


        if (cursor != null) {
            String[] st = { "แบบทดสอบบทที่ 1 ชุดที่ 1 พยัญชนะ", "แบบทดสอบบทที่ 1 ชุดที่ 2 การเขียนตัวพยัญชนะติดกัน", "แบบทดสอบบทที่ 2 สระ" ,"แบบทดสอบบทที่ 3  ตัวเลข"};
            int n = cursor.getCount();
            Log.d("VIEW", "SELECT Table Successfully."+n);
            if(n == 0){
                str = "ไม่พบประวัติข้อมูลการทดสอบ";
            }else{
                cursor.moveToFirst();
                for(int i = 0; i < cursor.getCount(); i++){
                    String s0 = cursor.getString(0);
                    String s1 = cursor.getString(1);
                    String s2 = cursor.getString(2);
                    String s3 = cursor.getString(3);
                    String s4 = cursor.getString(4);
                    String s5 = cursor.getString(5);
                    int nn = Integer.parseInt(s1);
                    //nn = nn - 1;
                    //str = str + "" + s0 + System.getProperty ("line.separator");
                    str = str +  st[nn] + System.getProperty ("line.separator");
                    str = str + "วันเวลาที่เล่น: " + s2 + System.getProperty ("line.separator");
                    str = str + "คะแนนที่ได้ " + s3 +" คะแนน" + System.getProperty ("line.separator");
                    str = str + "ตอบถูก "+s4 +" ข้อ" + System.getProperty ("line.separator");
                    str = str + "ตอบผิด "+ s5 +" ข้อ" + System.getProperty ("line.separator");
                    str = str + "_____________________________" + System.getProperty ("line.separator");
                    //str = str + cursor.getString(0)+". "+classObject.get(index).strQuestion+ System.getProperty ("line.separator");
                    cursor.moveToNext();
                }
            }
        }else{
            str = "ไม่พบประวัติข้อมูลการทดสอบ";
        }
        if (cursor != null) {
            cursor.close();
        }


        textDate.setText(str);
        textTop.setText("");
        textScores.setText("");
        textT.setText("");
        textF.setText("");
    }
    public void clickgo (View view) {
        Intent aaa = new Intent(getApplicationContext(), ap.arabiclearning.menuquiz.class);//ap.arabiclearning.quizfrom.class
        startActivity(aaa);
    }
}