package com.example.c1groupv2.util;

public interface OnClickAddWritingTipDialogListener {
    void onCancelButtonClick();
    void onOKButtonClick(String newTipNumber, String newTipTheme, String newTipIntroduction, String newTipContent, String newTipConclusion);
}
