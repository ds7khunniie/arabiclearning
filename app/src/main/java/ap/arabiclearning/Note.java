package ap.arabiclearning;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.Date;
import java.util.List;
//edit table Tasks to note
@Table(name = "Note")
public class Note extends Model {

    @Column(name = "note_title")
    public String note_title;

    @Column(name = "note_content")
    public String note_content;

    @Column(name = "date")
    public String date;

    @Column(name = "dueAt", index = true)
    public Date dueAt = null;

    @Column(name = "createdAt", index = true)
    public Date createdAt = null;

    @Column(name = "updatedAt", index = true)
    public Date updatedAt = null;



    public static List<Note> getAll() {
        return new Select().from(Note.class).orderBy("updatedAt DESC").execute();
    }

    public void saveWithTimestamp() {
        //don't use this function
        Date now = new Date();
        updatedAt = now;
        if (createdAt == null)
            createdAt = now;
        save();
    }
}
