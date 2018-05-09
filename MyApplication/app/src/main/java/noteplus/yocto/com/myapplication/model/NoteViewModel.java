package noteplus.yocto.com.myapplication.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

public class NoteViewModel extends ViewModel {
    private final LiveData<List<Note>> notesLiveData;
    private final LiveData<List<Note>> trashedNotesLiveData;

    public LiveData<List<Note>> getNotesLiveData() {
        return notesLiveData;
    }

    public LiveData<List<Note>> getTrashedNotesLiveData() {
        return trashedNotesLiveData;
    }

    public NoteViewModel() {
        notesLiveData = NoteplusRoomDatabase.instance().noteDao().getNotes();
        trashedNotesLiveData = NoteplusRoomDatabase.instance().noteDao().getTrashedNotes();
    }
}
