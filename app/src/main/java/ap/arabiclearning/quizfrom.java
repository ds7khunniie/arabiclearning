package ap.arabiclearning;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class quizfrom extends Activity {
    Button Button1;
    Button Button2;
    private dbQuiz databaseFirst;
    private Cursor curNotes;
    private SQLiteDatabase readableDatabase;
    private String textParameter;
    private String text;
    private TextView textTitle;
    private TextView textDate;
    private TextView textQuestion;
    private int arr[] = {0,1,2,3,4,5,6,7,8,9};
    private int numQ = 1;
    RadioButton myOption1, myOption2, myOption3 , myOption4;
    private AlertDialog Dialog;
    private ProgressDialog alertDialog;
    private CustomClass object1 = new CustomClass();
    private ArrayList<CustomClass> myArrList = new ArrayList<>();
    private String trueAns;
    private String strQ = null;
    //String[][] mystring
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_from);
        Button1 = (Button) findViewById(R.id.home);
        Button2 = (Button) findViewById(R.id.next);
        myOption1 = (RadioButton)findViewById(R.id.radioButton1);
        myOption2 = (RadioButton)findViewById(R.id.radioButton2);
        myOption3 = (RadioButton)findViewById(R.id.radioButton3);
        myOption4 = (RadioButton)findViewById(R.id.radioButton4);

        Bundle bundle = getIntent().getExtras();
        textParameter = bundle.getString("page");
        if(textParameter != null){
            text = textParameter;
            Log.d(" Parameter", " id = "+text);
        }


        //Date & Time
        textDate = (TextView)findViewById(R.id.idDate);
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd : hh.mm.ss");
        String folderName = formatter.format(today);
        textDate.setText(folderName);// (4) this prints "Folder Name = 2009-09-06-08.23.23"

        //Title :: Listen
        textTitle = (TextView)findViewById(R.id.quiznumber);
        switch (text) {
            case "1":
                textTitle.setText("แบบทดสอบบทที่ 1 ชุดที่ 1 พยัญชนะ");
                break;
            case "2":
                textTitle.setText("แบบทดสอบบทที่ 1 ชุดที่ 2 การเขียนตัวพยัญชนะติดกัน");
                break;
            case "3":
                textTitle.setText("แบบทดสอบบทที่ 2 สระ");
                break;
            default:
                textTitle.setText("แบบทดสอบบทที่ 3  ตัวเลข");
                break;
        }

        numQ = 1;
        databaseFirst = new dbQuiz(this);
        try{
            //Cursor cursor = getAllNotes();
            //Connect Database >>>  myQuiz
            String countQuery = "SELECT  * FROM  myQuiz WHERE Col_SetQuiz = "+text;
            SQLiteDatabase db = databaseFirst.getReadableDatabase();
            Cursor cursor = db.rawQuery(countQuery, null);
            curNotes = cursor;

            //show Question
            //shuffer Question Show
            ShuffleArray(arr);
            showNotes(cursor);
        }finally {
            databaseFirst.close();
        }/**/

    }
    //Date
    private void showNotes(Cursor cursor) {
        //String myAnswer = new String();
        object1 = new CustomClass();
        myOption1.setChecked(false);
        myOption2.setChecked(false);
        myOption3.setChecked(false);
        myOption4.setChecked(false);


        String s = arr[0]+", "+arr[1]+", " +arr[2]+", " +arr[3]+", "+ arr[4]+", "+ arr[5]+", "+ arr[6]+", "+ arr[7]+", "+ arr[8]+", "+ arr[9];
        Log.d(" Database : ", "ShuffleArray:" + s);

        //Question

        String ans1;
        String ans2;
        String ans3;
        String ans4;
        String answerQ;
        int n = cursor.getColumnNames().length;
        Log.d(" Database: ", " getColumnNames >>>>> " + n + ", getColumnNames: " );
        int indexQ = arr[numQ - 1];
        cursor.moveToPosition(indexQ);
        String test = cursor.getString(0);
        String test2 = cursor.getString(2);
        Log.d(" Database: ", " id >>>>> " + indexQ);
        Log.d(" Database: ", " Listen >>>>> " + test2);
        strQ = cursor.getString(3);
        Log.d(" Database: ", " Question :" + strQ);
        ans1 = cursor.getString(4);
        ans2 = cursor.getString(5);
        ans3 = cursor.getString(6);
        ans4 = cursor.getString(7);
        answerQ = cursor.getString(8);
        trueAns = answerQ;

        Log.d(" Database: ", "-------------------------");
        String idChioce = Integer.toString(numQ);
        textQuestion = (TextView)findViewById(R.id.txtquestion);
        String sss =  idChioce+". "+strQ;
        textQuestion.setText(sss);

        textQuestion = (TextView)findViewById(R.id.radioButton1);
        String a1 = ans1;
        textQuestion.setText(a1);

        textQuestion = (TextView)findViewById(R.id.radioButton2);
        String a2 = ans2;
        textQuestion.setText(a2);

        textQuestion = (TextView)findViewById(R.id.radioButton3);
        String a3 = ans3;
        textQuestion.setText(a3);

        textQuestion = (TextView)findViewById(R.id.radioButton4);
        String a4 = ans4;
        textQuestion.setText(a4);


        numQ = numQ + 1;
        if(numQ > 10){
            cursor.close();
        }
        //cursor.close();
        //getDatabases(cursor , 0);
    }
    private void ShuffleArray(int[] array)
    {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        //return array;
    }
    /*private void getDatabases(Cursor cursor , int num) {
        for (int i = 0;i<cursor.getCount(); i++) {
            if( num == arr[i]){
                Log.d(" Database: ", " >>>>> " + cursor.getCount());
            }
            num = num + 1;
        }
    }*/
    public Cursor getAllNotes() {
        String countQuery = "SELECT  * FROM  myQuiz WHERE Col_SetQuiz = "+text;
        SQLiteDatabase db = databaseFirst.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor;
    }

    public SQLiteDatabase getReadableDatabase() {
        return readableDatabase;
    }
    //

    //
    public void clickhome (View view) {
        Intent aaa = new Intent(getApplicationContext(), ap.arabiclearning.MyActivity.class);
        startActivity(aaa);

    }

    public void clicknext (View view) {
        //Intent bbb = new Intent(getApplicationContext(), quizfrom.class);
        //startActivity(bbb);
        //Select Answer rigth
        if(myOption1.isChecked() || myOption2.isChecked() || myOption3.isChecked() || myOption4.isChecked()){
            //Keep myAnswer
            String selectMyAns;
            if(myOption1.isChecked()){
                selectMyAns = myOption1.getText().toString();
            }else if(myOption2.isChecked()){
                selectMyAns = myOption2.getText().toString();
            }else if(myOption3.isChecked()){
                selectMyAns = myOption3.getText().toString();
            }else{
                selectMyAns = myOption4.getText().toString();
            }
            Log.d(" Database: ", " selectMyAns >>>>> " + selectMyAns );


            String check;
            if(selectMyAns.equals(trueAns)){
                check = "true";
            }else{
                check = "false";
            }
            //int numIndex = numQ - 2;

            object1.id = Integer.toString(numQ - 1);
            object1.idParam = text;
            object1.strQuestion = strQ;
            object1.strMyAns = selectMyAns;
            object1.strAns = trueAns;
            object1.strCheck = check;

            myArrList.add(object1);
            /*myAnswer[numIndex][0] = varID;
            myAnswer[numIndex][1] = text;
            myAnswer[numIndex][2] = strQ;
            myAnswer[numIndex][3] = selectMyAns;
            myAnswer[numIndex][4] = trueAns;
            myAnswer[numIndex][5] = check;*/
            for(int index = 0; index < myArrList.size(); index++){
                Log.d(" check: ", " Round Score >>>>> " + myArrList.get(index).strQuestion );
                //Toast.makeText(getApplicationContext(), "Id is :" + Object.id, Toast.LENGTH_SHORT).show();
            }


            if(numQ > 10){
                //Nextpage. Show Score & send parameter myAnswer
                Intent intent;
                Bundle bundle = new Bundle();
                intent = new Intent(getApplicationContext(), pagemyscore.class);

                /**/
                Bundle d = new Bundle();
                d.putSerializable("myscore", myArrList);
                intent.putExtras(d);
                startActivity(intent);
            }else{
                //Next Question

                showNotes(curNotes);
            }
        }else{
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("กรุณาเลือกคำตอบ");
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
}
