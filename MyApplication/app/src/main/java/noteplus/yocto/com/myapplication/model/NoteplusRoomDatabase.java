package noteplus.yocto.com.myapplication.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import noteplus.yocto.com.myapplication.NoteplusApplication;

@Database(
        entities = {Note.class},
        version = 1
)
public abstract class NoteplusRoomDatabase extends RoomDatabase {
    private volatile static NoteplusRoomDatabase INSTANCE;

    private static final String NAME = "noteplus";

    public abstract NoteDao noteDao();

    public static NoteplusRoomDatabase instance() {
        if (INSTANCE == null) {
            synchronized (NoteplusRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            NoteplusApplication.instance(),
                            NoteplusRoomDatabase.class,
                            NAME
                    ).build();
                }
            }
        }

        return INSTANCE;
    }
}
