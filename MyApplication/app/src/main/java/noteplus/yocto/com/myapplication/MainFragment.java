package noteplus.yocto.com.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import noteplus.yocto.com.myapplication.model.Note;
import noteplus.yocto.com.myapplication.model.NoteViewModel;
import noteplus.yocto.com.myapplication.model.NoteplusRoomDatabase;

public class MainFragment extends Fragment {

    private static final boolean REPRODUCE_BUG = true;

    private NoteViewModel noteViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noteViewModel = ViewModelProviders.of(getActivity()).get(NoteViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        final TextView textView = view.findViewById(R.id.text_view);
        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Note note = new Note();
                        note.setTrashed(true);
                        NoteplusRoomDatabase.instance().noteDao().insert(note);
                    }
                }).start();
            }
        });

        if (REPRODUCE_BUG) {
            textView.setText("REPRODUCE_BUG: on");
        } else {
            textView.setText("REPRODUCE_BUG: off");

            // existence of this subscription changes the behavior in TrashFragment
            noteViewModel.getTrashedNotesLiveData().observe(this, new Observer<List<Note>>() {
                @Override
                public void onChanged(@Nullable List<Note> notes) {
                }
            });
        }

        return view;
    }
}
