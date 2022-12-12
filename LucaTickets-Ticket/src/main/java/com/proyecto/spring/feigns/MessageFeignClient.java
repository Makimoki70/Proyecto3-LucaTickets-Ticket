package com.proyecto.spring.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.spring.ticket.model.response.Message;

@FeignClient(name = "message", url= "http://localhost:4444")
public interface MessageFeignClient {
	@GetMapping("/message")
    public Message getMessage();
}
