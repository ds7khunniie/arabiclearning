package ap.arabiclearning;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dowopen on 5/4/2016.
 */
public class pagemyscore extends Activity  {
    private TextView textDis;
    private TextView textTop;
    private TextView textMyscore;
    private Button Button1;
    private String textParameter;
    private String text;
    private CustomClass Object;
    private ArrayList<CustomClass> classObject;
    String str = "";
    private Integer numP = 0;
    private Integer scoresTrues = 0;
    private Integer scoresFalses = 0;
    private dbQuiz databaseFirst;
    private String txtDates;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagemyscore);
        textDis = (TextView)findViewById(R.id.mytextscore);
        textTop = (TextView)findViewById(R.id.textTopic);
        textMyscore = (TextView)findViewById(R.id.txtS);

       try{
            // Get the Bundle Object
            Bundle bundleObject = getIntent().getExtras();
            // Get ArrayList Bundle
           classObject = (ArrayList<CustomClass>) bundleObject.getSerializable("myscore");
            //Retrieve Objects from Bundle
            for(int index = 0; index < classObject.size(); index++){
                String words = "";
                str = str + classObject.get(index).id+". "+classObject.get(index).strQuestion+ System.getProperty ("line.separator");

                if(classObject.get(index).strCheck.equals("true")){
                    words = "(ถูก)";
                    scoresTrues = scoresTrues + 1;
                }else{
                    words = "(ผิด)";
                }
                String tempString = "ตอบ";
                SpannableString spanString = new SpannableString(tempString);
                spanString.setSpan(new UnderlineSpan(), 0, spanString.length(), 0);
                str = str +tempString+" "+ classObject.get(index).strMyAns+". "+words+ System.getProperty ("line.separator");

                Object = classObject.get(index);
                //Toast.makeText(getApplicationContext(), "Id is :" + Object.id, Toast.LENGTH_SHORT).show();

            }
        } catch(Exception e){
            e.printStackTrace();
        }

        scoresFalses = 10 - scoresTrues;
        String sScore = "คุณได้คะแนน " + Integer.toString(scoresTrues);

        String[] st = { "แบบทดสอบบทที่ 1 ชุดที่ 1 พยัญชนะ", "แบบทดสอบบทที่ 1 ชุดที่ 2 การเขียนตัวพยัญชนะติดกัน", "แบบทดสอบบทที่ 2 สระ" ,"แบบทดสอบบทที่ 3  ตัวเลข"};
        int num = Integer.parseInt(classObject.get(0).idParam.toString());
        textMyscore.setText(sScore);
        num = num - 1;
        textTop.setText(st[num]);
        textDis.setText(str); /**/
        numP = num;
        //set variable

        Button1 = (Button) findViewById(R.id.btnsave);
    }
    public void clickSave (View view) {
        //Save history
        databaseFirst = new dbQuiz(this);
        //SQLiteDatabase db = databaseFirst.getWritableDatabase();

        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd : hh.mm.ss");
        String sID = Integer.toString(numP);
        String sDate = formatter.format(today);
        String sScore = Integer.toString(scoresTrues);
        String sTrue = Integer.toString(scoresTrues);
        String sFalse = Integer.toString(scoresFalses);

        databaseFirst.InsertData(numP, sDate,sScore,sTrue,sFalse);

        Log.d(" Database: ", " Save >>>>> ");
        Intent aaa = new Intent(getApplicationContext(), ap.arabiclearning.menuquiz.class);
        startActivity(aaa);
    }
}
