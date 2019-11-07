package com.lwz.ctb.creativedesignvalley.Module.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.lwz.ctb.creativedesignvalley.MainActivity;
import com.lwz.ctb.creativedesignvalley.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 林伟洲-软件工程 on 2019/11/5.
 */

public class RegistActivity extends AppCompatActivity {
    private EditText et_user_name;
    private EditText et_psw;
    private EditText et_psw_again;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init(){
        et_user_name = findViewById(R.id.et_user_name);
        et_psw = findViewById(R.id.et_psw);
        et_psw_again = findViewById(R.id.et_psw_again);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取输入在相应控件中的字符串
                String userName = et_user_name.getText().toString().trim();
                String psw = et_psw.getText().toString().trim();
                String pswAgain = et_psw_again.getText().toString().trim();
                //判断输入框内容
                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(RegistActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(psw)){
                    Toast.makeText(RegistActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(pswAgain)){
                    Toast.makeText(RegistActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!psw.equals(pswAgain)){
                    Toast.makeText(RegistActivity.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    registRequest(userName, psw);
                }
            }
        });
    }

    public void registRequest(final String accountNumber, final String password) {
        //请求地址
        String url = "http://106.52.80.20:8080/MyWebTest/RegisterServlet";
        String tag = "Register";

        //取得请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

        //防止重复请求，所以先取消tag标识的请求队列
        requestQueue.cancelAll(tag);

        final StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = (JSONObject) new JSONObject(response).get("params");
                            String result = jsonObject.getString("Result");
                            if (result.equals("success")) {
                                Log.i("RegistActivity","regist success");
                                Toast.makeText(RegistActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                // 跳转到登录页
                                Intent data = new Intent();
                                data.putExtra("userName", accountNumber);
                                setResult(RESULT_OK, data);
                                RegistActivity.this.finish();
                            } else if (result.equals("failed")){
                                Log.i("RegistActivity","login fail");
                                Toast.makeText(RegistActivity.this,"用户名已存在",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            Log.e("RegistActivity", e.getMessage(), e);
                            Toast.makeText(RegistActivity.this,"无网络连接",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("RegistActivity", error.getMessage(), error);
                Toast.makeText(RegistActivity.this,"请检查网络，或者稍后重试",Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("AccountNumber", accountNumber);
                params.put("Password", password);
                return params;
            }
        };
        request.setTag(tag);
        //将请求添加到队列中
        requestQueue.add(request);
    }

}