package com.exercise.demo.data.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class CarDialogWindow extends DialogFragment {

    private final Long id;
    private final String mark;
    private final int doorCount;
    private final Boolean accounting;

    public CarDialogWindow(Long id, String mark, int doorCount, Boolean accounting) {
        this.id = id;
        this.mark = mark;
        this.doorCount = doorCount;
        this.accounting = accounting;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder window = new AlertDialog.Builder(getActivity());
        window.setTitle("About car #" + id);
        window.setMessage("Mark: " + mark +
                "\nDoor count:  " + doorCount +
                "\nAccounting: " + accounting);
        return window.create();
    }
}
