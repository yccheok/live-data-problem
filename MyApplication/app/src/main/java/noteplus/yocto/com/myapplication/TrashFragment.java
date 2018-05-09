package noteplus.yocto.com.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import noteplus.yocto.com.myapplication.model.Note;
import noteplus.yocto.com.myapplication.model.NoteViewModel;

public class TrashFragment extends Fragment {
    private NoteViewModel noteViewModel;
    private int count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noteViewModel = ViewModelProviders.of(getActivity()).get(NoteViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.trash_fragment, container, false);
        final TextView textView = view.findViewById(R.id.text_view);

        noteViewModel.getTrashedNotesLiveData().removeObservers(this);
        noteViewModel.getTrashedNotesLiveData().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                count++;
                textView.setText("TrashFragment onChanged called " + count + " times with list size " + notes.size());
            }
        });

        return view;
    }
}

