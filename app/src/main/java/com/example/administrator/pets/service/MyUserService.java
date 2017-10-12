package com.example.administrator.pets.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.example.administrator.pets.globle.Globle;

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
            if (action.equals("0")){
//                注册
                Log.e("beli","注册");
                String url = "http://"+ Globle.IP+":8080/GraduationProject/pages/UserRegisterActionByJson";
                String username = intent.getStringExtra("username");
                String userpwd = intent.getStringExtra("userpwd");
                loginAndRegister(username,userpwd,url,action);
            }
        }

    }
    private void loginAndRegister(String username, String userpwd, String url, final String action) {
        FormBody body = new FormBody.Builder()
                .add("name",username)
                .add("pwd",userpwd)
                .build();
        Request.Builder builder = new Request.Builder();
        final Request request = builder
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                Log.e("beli",res);
            }
        });
    }


}
