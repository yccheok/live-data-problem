package noteplus.yocto.com.myapplication.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "note")
public class Note {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "trashed")
    private boolean trashed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        return trashed == note.trashed;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (trashed ? 1 : 0);
        return result;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isTrashed() {
        return trashed;
    }

    public void setTrashed(boolean trashed) {
        this.trashed = trashed;
    }
}
