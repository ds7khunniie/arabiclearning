package ap.arabiclearning;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;

public class ShowActivity extends BaseActivity {
//Check again
    //Change Task to Note
    private Note     note = null;
    private TextView Note_title;
    private TextView Note_content;
    private TextView Date;
    private static final int MenuItem_EditID = 1;
    private static final int MenuItem_DeleteID = 2;
    private static final int EDIT_NOTE = 10;
    //EDIT_TASK
//Check again
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        setDrawer(true);
        setTitle(R.string.note);

        Note_title = (TextView) findViewById(R.id.Note_title);
        Note_content = (TextView) findViewById(R.id.Note_content);
        Date = (TextView) findViewById(R.id.Date);
        long id = getIntent().getLongExtra("id", 0);
        setView(id);
    }
//edit table name
    //Change Task to Note
    private void setView(long id) {
        if (id > 0)
            note = Note.load(Note.class, id);
        if (note != null) {
            Note_title.setText(note.note_title);
            Note_content.setText(note.note_content);
            Date.setText(note.date);
        } else {
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        addMenuItem(menu, MenuItem_EditID, R.string.edit, buildDrawable(MaterialDesignIconic.Icon.gmi_edit));
        addMenuItem(menu, MenuItem_DeleteID, R.string.delete, buildDrawable(MaterialDesignIconic.Icon.gmi_delete));
        return true;
    }
//edit task to note
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MenuItem_EditID:
                Intent intent = new Intent(this, FormActivity.class);
                intent.putExtra("id", note.getId());
                startActivityForResult(intent, EDIT_NOTE);
                break;
            case MenuItem_DeleteID:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle(android.R.string.dialog_alert_title);
                alert.setMessage(R.string.are_you_sure);
                alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        note.delete();
                        setResult(Activity.RESULT_OK, new Intent().putExtra("refreshNeeded", true));
                        finish();
                    }
                });
                alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                alert.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            switch (requestCode) {
                case EDIT_NOTE:
                    if (extras != null && extras.getLong("id", 0) > 0) {
                        setView(note.getId());
                        setResult(Activity.RESULT_OK, new Intent().putExtra("refreshNeeded", true));
                    }
                    break;
            }
        }
    }
}
