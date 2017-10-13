package com.example.administrator.pets.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.administrator.pets.globle.Globle;
import com.example.administrator.pets.pojo.User;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyUserService extends IntentService {

    private OkHttpClient client = new OkHttpClient();
    public MyUserService() {
        super("MyUserService");
    }



    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getStringExtra("action");
            Log.e("beli","action="+action);
            String username = intent.getStringExtra("username");
            String userpwd = intent.getStringExtra("userpwd");
            if (action.equals("0")){
//                注册
                Log.e("beli","注册");
                String url = "http://"+ Globle.IP+":8080/GraduationProject/pages/UserRegisterActionByJson";

                Register(username,userpwd,url);
            }else if (action.equals("1")){
                String url = "http://"+ Globle.IP+":8080/GraduationProject/pages/UserLoginActionByJson";
                Login(username,userpwd,url);
            }
        }

    }
    public void Register(String username, String pwd, String url) {
        Log.e("beli",username+","+pwd+",url="+url);
        FormBody body = new FormBody.Builder()
                .add("name",username)
                .add("pwd",pwd)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("beli",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                Log.e("beli",res);
                if (!res.equals("")){
                    try {
                        JSONObject object = new JSONObject(res);
                        String code_error = object.getString("code_error");
                        Intent intent = new Intent("com.action.res");
                        intent.putExtra("code_error",code_error);
                        sendBroadcast(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void Login(String username, String pwd, String url) {
        Log.e("beli",username+","+pwd+",url="+url);
        FormBody body = new FormBody.Builder()
                .add("name",username)
                .add("pwd",pwd)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("beli",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
//                Log.e("beli",res);

                    try {
                        JSONObject object = new JSONObject(res);
                        String code_error = object.getString("code_error");
                        Gson gson = new Gson();
                        Intent intent = new Intent("com.action.login");
                        intent.putExtra("code_error",code_error);

                        if (code_error.equals("0")){
                            String str = object.getString("user");
                            User user = gson.fromJson(str,User.class);
                            Log.e("beli",user.toString());
                            intent.putExtra("user",user);
                        }

                        sendBroadcast(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

            }
        });
    }
}
