package com.meng.demo1.classloader;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class OkHttpDemo {

    public static void main(String[] args) {
        // 创建client 对象
        OkHttpClient client = new OkHttpClient();
        // 构建请求参数
        Request request = new Request.Builder()
                .get()
                .url("http://127.0.0.1:8802")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String res = response.body().string();
                System.out.println(res);
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println(e);
            }
        });
    }
}
