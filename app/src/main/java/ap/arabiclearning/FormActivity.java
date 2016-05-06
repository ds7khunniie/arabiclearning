package ap.arabiclearning;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormActivity extends BaseActivity {

    private static final int MenuItem_SaveID = 1;
//edit task to note
    private Note note = null;
    private EditText titleEdit;
    private EditText contentEdit;
    private TextView textView_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        setDrawer(true);



        titleEdit = (EditText) findViewById(R.id.titleEdit);
        contentEdit = (EditText) findViewById(R.id.contentEdit);
        textView_date = (TextView)findViewById(R.id.textView_date);

        long id = getIntent().getLongExtra("id", 0);
        if (id == 0) {
            Date today = Calendar.getInstance().getTime();
            // (2) create a date "formatter" (the date format we want)
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd : hh.mm.ss");
            // (3) create a new String using the date format we want
            String folderName = formatter.format(today);
            // (4) this prints "Folder Name = 2009-09-06-08.23.23"
                /*System.out.println("Folder Name = " + folderName);*/
            textView_date.setText(folderName);

            System.out.println(" ===== test Dowopen::folderName ===== " + folderName);
            setTitle("Back");
        } else {
            setTitle("My Note");

//edit task to note
            note = Note.load(Note.class, id);
            if (note != null) {
                titleEdit.setText(note.note_title);
                contentEdit.setText(note.note_content);
                textView_date.setText(note.date);
                System.out.println(" ===== test Dowopen::note.date ===== "+note.date);

            } else {
                Date today = Calendar.getInstance().getTime();
                // (2) create a date "formatter" (the date format we want)
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd : hh.mm.ss");
                // (3) create a new String using the date format we want
                String folderName = formatter.format(today);
                // (4) this prints "Folder Name = 2009-09-06-08.23.23"
                /*System.out.println("Folder Name = " + folderName);*/
                textView_date.setText(folderName);
                System.out.println(" ===== test Dowopen::note == null ===== " + folderName);

                finish();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        addMenuItem(menu, MenuItem_SaveID, R.string.save, buildDrawable(MaterialDesignIconic.Icon.gmi_save));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (isEdited()) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(this);
                    alert.setTitle(android.R.string.dialog_alert_title);
                    alert.setMessage(R.string.unsaved_exit_alert);
                    alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            onBackPressed();
                        }
                    });
                    alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    alert.show();
                    return true;
                }
                break;
            case MenuItem_SaveID:
                save();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isEdited() {
        if (note == null)
            return titleEdit.getText().length() > 0 || contentEdit.getText().length() > 0;
        else
            return !note.note_title.equals(titleEdit.getText().toString()) || !note.note_content.equals(contentEdit.getText().toString());
    }
    /*save note*/
    private void save() {
        if (titleEdit.getText().length() > 0) {
            if (note == null)
                note = new Note();
            note.note_title = titleEdit.getText().toString();
            note.note_content = contentEdit.getText().toString();
            note.date = textView_date.getText().toString();
            System.out.println(" ===== test Dowopen ===== ");
            note.saveWithTimestamp();
            setResult(Activity.RESULT_OK, new Intent().putExtra("id", note.getId()));
            this.finish();
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle(android.R.string.dialog_alert_title);
            alert.setMessage("Please input text");
            alert.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alert.show();
        }
    }
}
