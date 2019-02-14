package com.wxm.controller.health;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.wxm.log.CommonLogger;

@Controller
public class HealthController {

	@GetMapping("/health")
	public void health(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(HttpStatus.OK.value());
		try {
			response.getWriter().write("");
		} catch (IOException e) {
			CommonLogger.error("health error", e);
		}
	}
}
