package com.lwz.ctb.creativedesignvalley.Module.MyCenter.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.lwz.ctb.creativedesignvalley.R;

//学生认证界面
public class SettledActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_email; //用户“邮箱”
    private ImageView iv_student_card;  //“学生证”
    private EditText et_pay_number; //“支付宝账号”
    private EditText et_photo_number;   //"电话号码"
    private EditText et_Verification_Code;  //  “验证码”
    private Button btn_next_one;    //“下一步”
    private Button btn_cancel;  //“取消”
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settled);

        init();
        setLintener();
    }



    private void init() {
        et_email=findViewById(R.id.et_user_email);
        iv_student_card=findViewById(R.id.iv_student_card);
        et_pay_number=findViewById(R.id.et_pay_number);
        et_photo_number=findViewById(R.id.et_pay_number);
        et_Verification_Code=findViewById(R.id.et_Verification_Code);
        btn_next_one=findViewById(R.id.btn_next_one);
        btn_cancel=findViewById(R.id.btn_cancel);
    }

    private void setLintener() {
        btn_next_one.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next_one:     //点击下一步
                //跳转到“店铺设置”
                Intent intent=new Intent(this,SetShopActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_cancel:   //点击“取消”
                finish();
                break;

                default:
                    break;
        }
    }
}
