package com.garehn.lyceesgt.assets;

import android.content.Context;
import android.widget.Switch;

public class CustomSwitch extends Switch {
    public CustomSwitch(Context context) {
        super(context);
    }

    public int booleanToInt(boolean b){
        int result = 0;
        if (b){
            result = 1;
        }
        else{
            result =0;
        }
        return result;
    }

    public int isCheckedInt(){
        int result=0;
        boolean b = this.isChecked();
        result = booleanToInt(b);
        return result;
    }

}
