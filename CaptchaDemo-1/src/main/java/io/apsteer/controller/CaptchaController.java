package io.apsteer.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import io.apsteer.model.RecaptchaResponse;
import io.apsteer.model.UserAccount;
import io.apsteer.service.CaptchaService;

@Controller
public class CaptchaController {

	@Autowired
	private CaptchaService service;

	@PostMapping("/login")
	public ResponseEntity<Object> chekCaptcha(@ModelAttribute("acc") UserAccount acc, BindingResult result,HttpServletRequest req) {
		
		int failure=4;
		boolean check = false;
		if (check) {
			if (!result.hasErrors()) {
				try {
					String response = service.captchaValidation(acc.getAttemptCount(), acc);
					return ResponseEntity.ok(response);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					return new ResponseEntity<>(303, HttpStatus.NOT_FOUND);
				}
			}//if
			
		} else {
			if (failure > 3) {
				/*RedirectView redirectViw = new RedirectView();
				redirectViw.setUrl("/showCaptcha");
				URI location = URI.create(redirectViw.getUrl());
				return ResponseEntity.status(302).location(location).build();*/
				RestTemplate restTemplate = new RestTemplate();
				String captchaResponse =req.getParameter("g-recaptcha-response");
				String secretKey = "6LdjbzsnAAAAAJpmTFyLZOS8CvgrcXTiep1TtdK-";
				//String secretKey = "6LdjbzsnAAAAAJpmTFyLZOS8CvgrcXTiep1Ttd";
				String url = "https://www.google.com/recaptcha/api/siteverify?secret=" + secretKey +"&response=" + captchaResponse;
				RecaptchaResponse response = restTemplate.postForObject(url, null, RecaptchaResponse.class);

				if (response != null && response.isSuccess()) {
					// CAPTCHA verification successful, proceed with the action
					return ResponseEntity.ok("Sucessfully Validate");
				} else {
					// CAPTCHA verification failed, display an error message
					return ResponseEntity.badRequest().body("Captcha validation Failed");
				} // else
			} // if
		} // else
		return null;
	}//method

	@GetMapping("/showCaptcha")
	public String showCaptcha() {
		return "reCaptcha";
	}
	
	public ResponseEntity<String> getValidateUpdate(@RequestParam("g-recaptcha-response") String captchaResponse ){
		
		RestTemplate restTemplate = new RestTemplate();
		String secretKey = "6Lc44jYnAAAAAAkJ2li-1lcHZyO-LcUtW7eRKRf0";
		String url = "https://www.google.com/recaptcha/api/siteverify";
		Map<String, String> body= new HashMap<>();
		body.put("secret", secretKey);
		body.put("response",captchaResponse);
		RecaptchaResponse response = restTemplate.postForObject(url, null, RecaptchaResponse.class);

		if (response != null && response.isSuccess()) {
			// CAPTCHA verification successful, proceed with the action
			return ResponseEntity.ok("Sucessfully Validate");
		} else {
			// CAPTCHA verification failed, display an error message
			return ResponseEntity.badRequest().body("Captcha validation Failed");
		} // else
	}

	@GetMapping("/home")
	public String showHome(@ModelAttribute("acc") UserAccount acc ) {
		return "Home";
	}
}
