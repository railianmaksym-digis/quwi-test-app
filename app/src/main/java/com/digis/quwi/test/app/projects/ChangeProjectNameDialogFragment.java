package com.digis.quwi.test.app.projects;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.digis.quwi.test.R;

import org.jetbrains.annotations.NotNull;

public class ChangeProjectNameDialogFragment extends DialogFragment {
    static final String OLD_NAME_ARG_KEY = "OLD_NAME_ARG";

    private ChangeProjectNameDialogFragment() {
    }

    private ProjectNameListener projectNameListener;

    public static ChangeProjectNameDialogFragment create(String oldName, ProjectNameListener projectNameListener) {
        Bundle arguments = new Bundle();
        arguments.putString(OLD_NAME_ARG_KEY, oldName);
        ChangeProjectNameDialogFragment dialogFragment = new ChangeProjectNameDialogFragment();
        dialogFragment.setProjectNameListener(projectNameListener);
        dialogFragment.setArguments(arguments);
        return dialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, R.style.DialogStyle);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_change_project_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String oldName = getArguments().getString(OLD_NAME_ARG_KEY);
        view.findViewById(R.id.tvBtnCancel).setOnClickListener(v -> dismiss());

        EditText etProjectName = view.findViewById(R.id.etProjectName);
        etProjectName.setText(oldName);
        etProjectName.requestFocus();
        showKeyboard();
        view.findViewById(R.id.tvBtnSave).setOnClickListener(v -> {
            projectNameListener.onNewProjectNameSubmitted(etProjectName.getText().toString());
            dismiss();
        });
    }

    @Override
    public void onDismiss(@NonNull @NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        closeKeyboard();
    }

    public void setProjectNameListener(ProjectNameListener projectNameListener) {
        this.projectNameListener = projectNameListener;
    }

    public interface ProjectNameListener {
        void onNewProjectNameSubmitted(String newName);
    }

    private void showKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    private void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

}