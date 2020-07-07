package com.garehn.lyceesgt.assets;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.garehn.lyceesgt.R;
import com.garehn.lyceesgt.lycees.Lycee;

public class ResultDialog {

    protected TextView textTitle;
    protected TextView text1;
    protected TextView text2;
    protected TextView test3;

    public void showDialog(Activity activity, Lycee lycee){
        Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.result_dialog);
        dialog.show();
    }
}