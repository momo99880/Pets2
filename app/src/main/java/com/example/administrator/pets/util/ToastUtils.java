package com.example.administrator.pets.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by BELIEVE on 2017/10/13.
 */

public class ToastUtils {
    public static void ToastText(Context context,String str){
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
    }
}
