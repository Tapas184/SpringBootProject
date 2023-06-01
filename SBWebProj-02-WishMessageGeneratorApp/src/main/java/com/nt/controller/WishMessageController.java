package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMsgService;

@Controller
public class WishMessageController {
	@Autowired
	private IWishMsgService service;
	
	@GetMapping(value="/")
	public  String welcomeMessageHandler() {
		return "home";
	}
	/*	@RequestMapping("/wish")
		public ModelAndView getWishMessage() {
			//user service class
		String result=	service.getWishMessage();
		//return ModelAndView
		//return new ModelAndView("display","wmg",result);//here we can add only only modelandview attributes
		ModelAndView mav = new ModelAndView();//in this approach we can add no.of attributes
		mav.addObject("wmg", result);
		mav.setViewName("display");
		return mav;
		}*/
	/*	@RequestMapping("/wish")
		public String getWishMessage(BindingAwareModelMap map) {
			String result = service.getWishMessage();
			map.addAttribute("wmg", result);
			return "display";
		}*/
	/*	@RequestMapping("/wish")
		public String getWishMessage(HashMap<String,Object> map) {
			//user service  to get result 
			String result = service.getWishMessage();
			map.put("wmg", result);
			//return LVN to dispatcherServlet
			return "display";
		}*/
	/*	@RequestMapping("/wish")
		public String getWishMessage(Map<String,Object> map) {
			String result = service.getWishMessage();
			map.put("wmg", result);
			return "display";
		}*/
	@RequestMapping("/wish") //it directly search wish.jsp if return type is void
	public void getWishMessage(Model model) {
		String result = service.getWishMessage();
		model.addAttribute("wmg", result);
	}
}//class
