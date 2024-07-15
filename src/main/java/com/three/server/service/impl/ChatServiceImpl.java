package com.three.server.service.impl;

import com.baidubce.qianfan.Qianfan;
import com.baidubce.qianfan.core.auth.Auth;
import com.baidubce.qianfan.model.chat.ChatResponse;
import com.three.server.service.ChatService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {
    private Qianfan qianfan =
            new Qianfan(Auth.TYPE_OAUTH, "", "");
    @Override
    public String chatWithWholeResponse(String message) {
        try {
            // 调用自定义的QianfanClient类中的方法来执行对话
            // 这里假设chatCompletion方法返回一个包含对话结果的ChatResponse对象
            ChatResponse response = qianfan.chatCompletion()
                    .model("ERNIE-Bot-4") // 指定模型
                    .addMessage("user", message) // 添加用户消息
                    .temperature(0.7) // 设置温度参数
                    .execute(); // 执行请求

            // 返回对话结果
            if (response != null && response.getResult() != null) {
                return response.getResult();
            } else {
                // 如果没有返回结果或结果为空，则返回错误信息
                return null;
            }
        } catch (Exception e) {
            // 捕获并处理可能发生的异常
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseBodyEmitter streamChat(String message) {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter(60000L);  // 设置超时时间为60秒

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                qianfan.chatCompletion()
//                        .model("ERNIE-Bot-4")//付费
//                        .model("ERNIE-4.0-8K")//付费
                        .model("ERNIE-Speed-128K")
                        .addMessage("user", message)
                        .executeStream()
                        .forEachRemaining(chunk -> {
                            try {
                                emitter.send(chunk.getResult(), MediaType.TEXT_PLAIN);
                            } catch (IOException e) {
                                emitter.completeWithError(e);
                            }
                        });
                emitter.complete();
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        });

        return emitter;
    }
}
