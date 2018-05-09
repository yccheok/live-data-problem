package noteplus.yocto.com.myapplication.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import java.util.List;

@Dao
public abstract class NoteDao {
    @Transaction
    @Query("SELECT * FROM note where trashed = 0")
    public abstract LiveData<List<Note>> getNotes();

    @Transaction
    @Query("SELECT * FROM note where trashed = 1")
    public abstract LiveData<List<Note>> getTrashedNotes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insert(Note note);
}