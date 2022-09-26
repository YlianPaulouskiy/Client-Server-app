package com.exercise.demo.data.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class PersonDialogWindow extends DialogFragment {

    private final String name;
    private final String realName;
    private final String team;
    private final String firstAppearance;

    public PersonDialogWindow(String name, String realName, String team, String firstAppearance) {
        this.name = name;
        this.realName = realName;
        this.team = team;
        this.firstAppearance = firstAppearance;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder window = new AlertDialog.Builder(getActivity());
        window.setTitle("About " + name);
        window.setMessage("Real name: " + realName);
        window.setMessage("Team: " + team);
        window.setMessage("First appearance: " + firstAppearance);
        return window.create();
    }
}
