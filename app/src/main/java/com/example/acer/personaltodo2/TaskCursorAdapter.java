package com.example.acer.personaltodo2;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.acer.personaltodo2.data.TaskContract;

import static com.example.acer.personaltodo2.data.TaskContract.*;

/**
 * Created by Acer on 11/2/2017.
 */

public class TaskCursorAdapter extends CursorAdapter {

    public TaskCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
// Find fields to populate in inflated template
        TextView tvName = view.findViewById(R.id.task);
        TextView tvPriority = view.findViewById(R.id.priority_level);
        TextView tvDueDate = view.findViewById(R.id.due_date);
        TextView tvStatus = view.findViewById(R.id.status);

        // Extract properties from cursor
        String name = cursor.getString(cursor.getColumnIndexOrThrow(TaskEntry.COLUMN_TASK_NAME));
        int priority = cursor.getInt(cursor.getColumnIndexOrThrow(TaskEntry.COLUMN_TASK_PRIORITY));
        String dueDate = cursor.getString(cursor.getColumnIndexOrThrow(TaskEntry.COLUMN_TASK_DUE_DATE));
        int status = cursor.getInt(cursor.getColumnIndexOrThrow(TaskEntry.COLUMN_TASK_STATUS));

        //Get string values of priority and status
        switch (priority) {
            case TaskEntry.PRIORITY_MEDIUM:
                tvPriority.setText(R.string.priority_medium);
                break;
            case TaskEntry.PRIORITY_HIGH:
                tvPriority.setText(R.string.priority_high);
                break;
            case TaskEntry.PRIORITY_CRITICAL:
                tvPriority.setText(R.string.priority_critical);
                break;
            default:
                tvPriority.setText(R.string.priority_low);
                break;

        }

        switch (status) {
            case TaskEntry.STATUS_COMPLETE:
                tvStatus.setText(R.string.button_completed);
                break;
            default:
                tvStatus.setText(R.string.button_in_progress);
                break;

        }

        // Populate fields with extracted properties
        tvName.setText(name);
        tvDueDate.setText(dueDate);



}}
