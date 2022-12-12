package com.proyecto.spring.feigns;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.proyecto.spring.ticket.model.response.User;

@FeignClient(name = "user", url= "http://localhost:8888")
public interface UserFeignClient {
	@GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id);
}
