package bd.com.greenit.sabbirdev.mynotes;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by SabbirDEV on 8/5/2015.
 */
public class NotesCursorAdapter extends CursorAdapter{
    public NotesCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String noteText = cursor.getString(cursor.getColumnIndex(DBOpenHelper.TEXT));
        int position = noteText.indexOf(10);
        if (position != -1){
            noteText = noteText.substring(0, position) + "...";
        }
        TextView textView = (TextView) view.findViewById(R.id.textViewNote);
        textView.setText(noteText);
    }
}
