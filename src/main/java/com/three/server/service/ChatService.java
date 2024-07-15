package com.three.server.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

public interface ChatService {
    //一次返回完整的AI回答
    String chatWithWholeResponse(String mes);
    ResponseBodyEmitter streamChat(String mes);
}
