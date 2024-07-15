package com.three.server.controller;

import com.baidubce.qianfan.Qianfan;
import com.three.server.common.responseBodyCustom.ApiResponse;
import com.three.server.service.impl.ChatServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatServiceImpl chatService;

    // 一次返回完整答复
    @GetMapping("/getWholeRes/{mes}")
    public ApiResponse<String> getWholeRes(@PathVariable String mes) {
        System.out.println(mes);
        if (chatService.chatWithWholeResponse(mes) == null)
        {
            return ApiResponse.fail(500,"智能客服无法回复您的问题，请稍后再试");
        }
        return ApiResponse.success(chatService.chatWithWholeResponse(mes));
    }

    // 流式返回答复
    @GetMapping("/chatStream")
    public ResponseBodyEmitter streamChat(@RequestParam("message") String message) {
        System.out.println(message);
        return chatService.streamChat(message);
    }
}
