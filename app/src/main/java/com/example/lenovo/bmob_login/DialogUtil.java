package com.example.lenovo.bmob_login;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

/**
 * Created by lenovo on 2016/6/4.
 */
public class DialogUtil {
    //定义一个显示消息的对话框
    public  static void showDialog(final Context ctx,String msg,boolean goHome)
    {
        //创建一个AlertDialoog.Builder对象
        AlertDialog.Builder builder=new AlertDialog.Builder(ctx).setMessage(msg).setCancelable(false);
        if(goHome)
        {
           builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int which) {
                   Intent i =new Intent(ctx,pictureActivity.class);
                   i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   ctx.startActivity(i);

               }

        });
        }
        else
        {
            builder.setPositiveButton("确定",null);
        }
        builder.create().show();
    }
    //定义一个显示指定组件的对话框
    public static void showDialog(Context ctx,View view)
    {
        new AlertDialog.Builder(ctx).setView(view).setCancelable(false).setPositiveButton("确定",null).create().show();

    }
}
