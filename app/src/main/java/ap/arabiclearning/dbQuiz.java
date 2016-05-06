package ap.arabiclearning;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by Dowopen on 4/27/2016.
 */
public class dbQuiz extends SQLiteOpenHelper {
    private static final String DB_NAME = "QuizDatabase";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "myQuiz";
    /*private int Col_Listen;
    private int Col_SetQuiz;
    private String Col_Questions;
    private String Col_textChoice1;
    private String Col_textChoice2;
    private String Col_textChoice3;
    private String Col_textChoice4;
    private String Col_textAns;*/
    private String str = "(Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns )";
    public dbQuiz(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (_id INTEGER PRIMARY KEY AUTOINCREMENT, Col_Listen INTEGER,  Col_SetQuiz INTEGER, Col_Questions  TEXT,  Col_textChoice1  TEXT, Col_textChoice2  TEXT,  Col_textChoice3  TEXT,  Col_textChoice4  TEXT, Col_textAns TEXT );");
        //Listen1 set1
        Log.d("CREATE TABLE", "Create Table Successfully.");
        /**/
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 1, 'พยัญชนะภาษาอาหรับทั้งหมดมีกี่ตัว' , '24 ตัว','22 ตัว','28 ตัว','27 ตัว' , '28 ตัว');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 1, 'การอ่านและเขียนภาษาอาหรับ มีลักษณะการอ่านและเขียนอย่างไร', 'อ่านและขียนจากบนลงล่าง', 'อ่านและขียนจากขวาไปซ้าย' , 'อ่านและขียนจากซ้ายไปขวา' , 'อ่านและขียนจากล่างขึ้นบน' , 'อ่านและขียนจากขวาไปซ้าย');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 1, 'พยัญชนะตัวแรกในภาษาอาหรับคือพยัญชนะตัวอะไร', 'อลิฟ', 'ษา' , 'ตา' , 'นูน' , 'อลิฟ');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 1, 'พยัญชนะ ب เมื่อเทียบเสียงกับพยัญชนะไทยจะมีเสียงใกล้เคียงกับพยัญชนะใด', 'บ', 'น' , 'ย' , 'ต' ,'บ' );");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 1, 'พยัญชนะ ح เมื่อเทียบเสียงกับพยัญชนะไทยจะมีเสียงใกล้เคียงกับพยัญชนะใด', 'ห', 'ฟ' , 'อ' , 'ว' ,'ห');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 1, 'พยัญชนะ ن เมื่อเทียบเสียงกับพยัญชนะไทยจะมีเสียงใกล้เคียงกับพยัญชนะใด', 'น', 'ฟ' , 'อ' , 'ว' ,'น');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 1, 'พยัญชนะ م เมื่อเทียบเสียงกับพยัญชนะไทยจะมีเสียงใกล้เคียงกับพยัญชนะใด', 'ด', 'ร' , 'ม' , 'ฮ' ,'ม');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 1, 'พยัญชนะ ن อ่านออกเสียงอย่างไร', 'อลิฟ', 'นูน' , 'มีม' , 'วาว' ,'นูน');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 1, 'พยัญชนะ ا อ่านออกเสียงอย่างไร', 'อลิฟ', 'นูน' , 'มีม' , 'วาว' ,'อลิฟ');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 1, 'พยัญชนะ ف อ่านออกเสียงอย่างไร', 'ฟาอ์', 'กาฟ' , 'กอฟ' , 'ลาม' ,'ฟาอ์');");

        //Listen1 set2
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 2, 'พยัญชนะที่ไม่สามารถให้ตัวพยัญชนะอื่นมาต่อท้ายมันได้แต่มันสามารถต่อพยัญชนะอื่นได้ มีกี่ตัว' , '7','2','8','6' , '6');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 2, 'พยัญชนะเหล่านี้(ك+ر+ى+م) เมื่อเขียนติดกันจะได้รูปคำลักษณะใด' , 'بيت' , 'قريم' , 'بين' ,'كريم' ,'كريم');");

        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 2, 'พยัญชนะ ل (ลาม) เมื่ออยู่ท้ายคำจะมีรูปลักษณะคำแบบใด' , 'لينا' , 'فيل' , 'ملح' ,'ถูกทุกข้อ' ,'فيل');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 2, 'พยัญชนะ ن (นูน) เมื่ออยู่ต้นคำจะมีรูปลักษณะคำแบบใด' , 'لمن' , 'نون' , 'ينوب' ,'ข้อ 2 และ 3 ถูก' ,'نون');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 2, 'พยัญชนะ ح (หาอ์) เมื่ออยู่กลางคำจะมีรูปลักษณะคำแบบใด' , 'حل' , 'ملح' , 'بحر' ,'ข้อ 1 และ 2 ถูก' ,'ملح');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 2, 'พยัญชนะ س (สีน) เมื่ออยู่กลางคำจะมีรูปลักษณะคำแบบใด' , 'سم' , 'لص' , 'بسم' ,'طب' ,'بسم');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " (Col_Listen , Col_SetQuiz , Col_Questions , Col_textChoice1 , Col_textChoice2 , Col_textChoice3, Col_textChoice4,Col_textAns ) VALUES (1, 2, 'พยัญชนะเหล่านี้ (ل+ع+ب) เมื่อเขียนติดกันจะได้รูปคำลักษณะใด' , 'علج' , 'لغ' , 'لعب' ,'ไม่มีข้อถูก' ,'لعب');");
        db.execSQL("INSERT INTO " + TABLE_NAME + str +" VALUES (1, 2, 'พยัญชนะเหล่านี้ (ف+ي+ل) เมื่อเขียนติดกันจะได้รูปคำลักษณะใด' , 'فيل' , 'زهر' , 'عنب' ,'بيت' ,'فيل');");
        db.execSQL("INSERT INTO " + TABLE_NAME + str + " VALUES (1, 2, 'พยัญชนะเหล่านี้ (ل+ف+ظ) เมื่อเขียนติดกันจะได้รูปคำลักษณะใด' , 'ماء' , 'لفظ' , 'لبن' ,'بيت' ,'لفظ');");
        db.execSQL("INSERT INTO " + TABLE_NAME + str + " VALUES (1, 2, 'พยัญชนะเหล่านี้ (ت+ق+و+م) เมื่อเขียนติดกันจะได้รูปคำลักษณะใด' , 'تقوم' , 'انت' , 'من' ,'كم' ,'تقوم');");
        //Listen3
        db.execSQL("INSERT INTO " + TABLE_NAME + " " + str +" VALUES (2, 3, 'สระในภาษาอาหรับแบ่งออกเป็นกี่ประเภท' , '2','4','3','5' , '3');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " " + str +" VALUES (2, 3, 'สระธรรมดาหรือสระเดี่ยวแบ่งออกเป็นสระอะไรบ้าง', 'ฟัตหะฮ์/กัสเราะห์/ฎอมมะฮ์', 'ชัดดะฮ์/กัสเราะห์/ฎอมมะฮ์' , 'ฎอมมะฮ์/กัสเราะฮ์' , 'ไม่มีข้อถูก' , 'ฟัตหะฮ์/กัสเราะห์/ฎอมมะฮ์');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " " + str +" VALUES (2, 3, 'สระซ้อนแบ่งออกเป็นอะไรบ้าง', 'ฟัตหะฮ์/กัสเราะห์/ฎอมมะฮ์', 'จำไม่ได้' , 'ฎอมมะฮ์/กัสเราะฮ์' , 'ฟัตหะฮ์ตัยน์/กัสเราะห์ตัยน์/ฎอมมะฮ์ตัยน์' , 'ฟัตหะฮ์ตัยน์/กัสเราะห์ตัยน์/ฎอมมะฮ์ตัยน์');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " " + str +" VALUES (2, 3, 'สระฟัตหะฮ์ เรียกง่ายๆ ว่าอย่างไร', 'สระอี', 'สระอา' , 'สระอัน' , 'ถูกทุกข้อ' ,'สระอา' );");
        db.execSQL("INSERT INTO " + TABLE_NAME + " " + str +" VALUES (2, 3, 'สระกัสเราะห์เรียกง่ายๆ ว่าอย่างไร', 'สระอี', 'สระอา' , 'สระอัน' , 'ถูกทุกข้อ' ,'สระอี');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " " + str +" VALUES (2, 3, 'ฎอมมะห์ตัยน์ เรียกง่ายๆว่าอย่างไร', 'สระอี', 'สระอุน' , 'สระอัน' , 'ไมมีข้อไหนถูก' ,'สระอุน');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " " + str +" VALUES (2, 3, 'เมื่อ ب  มีสระกัสเราะห์ตัยน์อยู่ด้านล่างตัวมันจะอ่านว่าอย่างไร', 'บิน', 'บัน' , 'บุน' , 'บู' ,'บิน');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " " + str +" VALUES (2, 3, 'เมื่อ ت  มีสระฟัตหะฮ์อยู่ด้านบนตัวมันจะอ่านว่าอย่างไร', 'ติน', 'ตา' , 'ตุน' , 'ตี' ,'ตา');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " " + str +" VALUES (2, 3, 'เมื่อ ض  มีสระฎอมมะห์ตัยน์อยู่ด้านบนตัวมันจะอ่านว่าอย่างไร', 'ดุน', 'ดัน' , 'ตุน' , 'ตี' ,'ดัน');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " " + str +" VALUES (2, 3, 'เมื่อ ن  มีสระฎอมมะห์ตัยน์อยู่ด้านบนตัวมันจะอ่านว่าอย่างไร', 'นิน', 'นาน' , 'นัน' , 'นุน' ,'นัน');");


        //Listen4
        db.execSQL("INSERT INTO " + TABLE_NAME + " "+ str +" VALUES (3, 4, 'หมายเลข 7 ภาษาอาหรับมีรูปลักษณะแบบใด' , '٣','٧','٤','٨' , '٧');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " "+ str +" VALUES (3, 4, 'หมายเลข 4 ภาษาอาหรับมีรูปลักษณะแบบใด', '٤','٣','٨','٩' , '٤');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " "+ str +" VALUES (3, 4, 'หมายเลข 5 ภาษาอาหรับมีรูปลักษณะแบบใด', '٥','٨','٩','٤' , '٥');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " "+ str +" VALUES (3, 4, 'คำว่า ซิฟร์ หมายถึงหมายเลขตัวใด' , '٠','٤','٨','٥' , '٠');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " "+ str +" VALUES (3, 4, 'คำว่า อัรบะอะฮ์ หมายถึงหมายเลขตัวใด', '٣','٠','٨','٤' , '٠');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " "+ str +" VALUES (3, 4, 'คำว่า คอมซะฮ์ หมายถึงหมายเลขตัวใด', '٢','٣','٥','٨' , '٥');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " "+ str + " VALUES (3, 4, '١٠ อ่านว่าอะไรในภาษาอาหรับ', 'عشرة (อาซะรอ)' , 'خمسة (คอมซะฮ์)' , ' اثنان (อิสนาน)' , 'اربعة (อัรบะอะฮ์)'  , 'عشرة (อาซะรอ)' );");
        db.execSQL("INSERT INTO " + TABLE_NAME + " "+ str + " VALUES (3, 4, '٦  อ่านว่าอะไรในภาษาอาหรับ' , 'ثلاث (ซาลาซะฮ์)', 'خمسة (คอมซะฮ์)' , 'ستة (สิตตะอ์)' ,'اربعة (อัรบะอะฮ์)' , 'ستة (สิตตะอ์)');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " "+ str + " VALUES (3, 4, '203 เขียนอย่างไรในภาษาอาหรับ', '٦٠٣', '٤٠٥' , '٢٠٣' , '١٠٦' ,'٢٠٣');");
        db.execSQL("INSERT INTO " + TABLE_NAME + " "+ str + " VALUES (3, 4, '30 เขียนอย่างไรในภาษาอาหรับ', '٣٠', '٢٠' , '٤٠' , '١٠' ,'٣٠');");

        db.execSQL("CREATE TABLE myScores (_id INTEGER PRIMARY KEY AUTOINCREMENT,Col_Lis INTEGER, Col_Date TEXT,  Col_total_score TEXT, Col_true_score  TEXT,  Col_f_score  TEXT);");
        //Listen1 set1
        Log.d("CREATE TABLE > myScores", "Create Table Successfully.");

        String countQuery = "SELECT  * FROM  myQuiz";
        Cursor cursor = db.rawQuery(countQuery, null);
        Log.d("INSERT TABLE", "INSERT Table Successfully."+cursor.getCount());


    }
    public void InsertData(Integer strLis, String strDate , String strTotal_score, String strTrue_score, String strF_score) {
        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase();
            db.execSQL("INSERT INTO myScores (Col_Lis ,Col_Date , Col_total_score ,Col_true_score ,Col_f_score) VALUES ("+strLis+" , '"+strDate+"' , '"+strTotal_score+"','"+strTrue_score+"','"+strF_score +"');");

            String countQuery = "SELECT  * FROM  myScores";
            Cursor cursor = db.rawQuery(countQuery, null);
            Log.d("QUERY TABLE myScores", "myScores : "+cursor.getCount());
        }catch (Exception e) {
            Log.d("CAN't INSERT", "myScores : "+e);
        }
       }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

