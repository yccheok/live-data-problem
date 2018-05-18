package noteplus.yocto.com.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NotificationsListAdapter extends ArrayAdapter<Notification> {

    public NotificationsListAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.element_notification_list_item, parent, false);
        }

        TextView txtId = convertView.findViewById(R.id.txt_notification_id);
        txtId.setText(String.valueOf(position + 1));

        TextView txtCount = convertView.findViewById(R.id.txt_count);
        txtCount.setText(String.valueOf(getItem(position).getSize()));

        return convertView;
    }
}
