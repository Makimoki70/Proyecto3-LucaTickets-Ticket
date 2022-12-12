package com.proyecto.spring.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.proyecto.spring.ticket.model.response.Event;

@FeignClient(name = "event", url= "http://localhost:7777")
public interface EventFeignClient {
	@GetMapping("/event/{id}")
    public Event getEventById(@PathVariable long id);
}