package com.example.lenovo.bmob_login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

   private EditText et_name;
   private EditText et_password;
   private Button btn_login;
    private Button btn_registered;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //获取界面中的两个编辑框
        et_name=(EditText)findViewById(R.id.et_name);
        et_password=(EditText)findViewById(R.id.et_password);
        //获取界面中的两个按钮
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_registered=(Button)findViewById(R.id.btn_registered);

        //为btn_login绑定事件监听
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //执行输入校验
                if(validate()) {
                    //登录成功
                    //启动myActivity
                    Intent intent = new Intent(MainActivity.this, pictureActivity.class);
                    startActivity(intent);
                    //结束
                    finish();
                }
                 else
                        {
                            DialogUtil.showDialog(MainActivity.this,"用户名或密码错误，请重新输入!",false);
                        }
                    }

        });
        //为btn_registered绑定监听事件
        btn_registered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,registeredActivity.class);
                startActivity(intent);

            }
        });

    }


    //对用户名、密码进行校验
    private  boolean validate()
    {
        String username=et_name.getText().toString().trim();
        if(username.equals(""))
        {
            DialogUtil.showDialog(this,"用户名是必修填的!",false);
            return false;

        }
        String userpassword=et_password.getText().toString().trim();
        if (userpassword.equals(""))
        {
            DialogUtil.showDialog(this,"用户密码必修填",false);
            return false;
        }
        return true;

    }


}
