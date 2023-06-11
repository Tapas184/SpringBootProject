 package com.nt.contoller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.entity.Tourist;

@Controller
public class RequestController {

	
	@Autowired
	private RestTemplate temp;
	
	@Autowired
	private ObjectMapper mapper;
	
	@GetMapping("/")
	public String showHomePage() {
		//return logical View name to DS
		return "home";
	}
	@GetMapping("/alltouristlist")
	public String findAllTourist(Map<String, Object> map) throws Exception {
		/*we need to send request to producer app and get the data and then format the data
		 * url=http://localhost:5050/SpringRest-Proj-04-ProducerApp/findAlltourist
		 * method= GET
		 * response containtent type = application/json(default)
		 * no path/no query string to pass
		 */
		String producerUrl = "http://localhost:5050/SpringRest-Proj-04-ProducerApp/findAlltourist";//also called endpoint
		ResponseEntity<String> resp = temp.exchange(producerUrl, HttpMethod.GET, null, String.class);
		//get the JSON response body from Producer App
		String jsonresponseBody = resp.getBody();
		//create mapper object
		
		//convert JSON body to Object
		List<Tourist> touristList=mapper.readValue(jsonresponseBody, new TypeReference<List<Tourist>>() {});
		//keep the object in Map
		map.put("touristList", touristList);
		//return logical view name
		return "allTourist";
	}
	
	@GetMapping("/addtourist")
	public String addTouristForm(@ModelAttribute("tst") Tourist tourist) {
		//Return logical View name to DS
		return "TouristAdd";
	}//tourist registration form
	
	@PostMapping("/addtourist")
	public String addTourist(@ModelAttribute("tst") Tourist tourist,
			                 RedirectAttributes attrs
			                 ) throws Exception{
		/*Now nee need to convert Object Data to Json data(Serialization) so we can integration with Producer App
		 * url=http://localhost:5050/SpringRest-Proj-04-ProducerApp/register;
		 * 
		 */
	String jsonstring=mapper.writeValueAsString(tourist); //tO CONVERT JAVA BEAN OBJ TO JSON 
	//invok spring rest service
	String url="http://localhost:5050/SpringRest-Proj-04-ProducerApp/register";
	//prepare HttpHeader class
	HttpHeaders header = new HttpHeaders();
	header.setContentType(MediaType.APPLICATION_JSON);//Optional By Default Application_JSON
	//Prepare http Entity
	HttpEntity<String> entity = new HttpEntity<>(jsonstring, header);
	ResponseEntity<String> resp = temp.exchange(url, HttpMethod.POST, entity, String.class);
	String result= resp.getBody();
	//put the message  into RedirectAttributes
	attrs.addFlashAttribute("msg", result);
		return "redirect:alltouristlist";
	}
	@GetMapping("/edit")
	public String editTourist(@RequestParam("id") Integer tid,
			                  @ModelAttribute("tst") Tourist tourist
			                  ) throws Exception{
		/*
		 * Producer App url= "http://localhost:5050/SpringRest-Proj-04-ProducerApp/findtourist/{id}";
		 */
		//invoke rest service
		//prepare String
		String url = "http://localhost:5050/SpringRest-Proj-04-ProducerApp/findtourist/"+tid;
		ResponseEntity<String> resp = temp.exchange(url, HttpMethod.GET, null,String.class);
		//get json body from response object
		String jsonBody=resp.getBody();
		//convert Json Body to tourist object
	Tourist tourist1=mapper.readValue(jsonBody, Tourist.class);
		//copy one bean object to another bean class object
	BeanUtils.copyProperties(tourist1, tourist);
		return "editTourist";
	}
	
	@PostMapping("/edit")
	public String editTourist(@ModelAttribute("tst") Tourist tourist,
			                  RedirectAttributes ra) {
		//Object to Json Body
		/*
		 * Url = "http://localhost:5050/SpringRest-Proj-04-ProducerApp/updatetourist";
		 */
		String jsonstring=null;
		try {
		jsonstring=mapper.writeValueAsString(tourist);
		}catch(Exception e){
			e.printStackTrace();
		}
		//invok spring rest service
		String url="http://localhost:5050/SpringRest-Proj-04-ProducerApp/updatetourist";
		//prepare HttpHeader class
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		//Prepare http Entity
		HttpEntity<String> entity = new HttpEntity<>(jsonstring, header);
		ResponseEntity<String> resp = temp.exchange(url, HttpMethod.PUT, entity, String.class);
		//get the out put as string
		String result= resp.getBody();
		//add the string in redirect attributes
		ra.addFlashAttribute("msg", result);
		return "redirect:alltouristlist";
	}//method editTourist
	
	@GetMapping("/delete")
	public String deleteTouristList(@RequestParam("id") Integer id,
			                        RedirectAttributes ra,
			                        @ModelAttribute("tst") Tourist tourist) {
		/*Get the Id details from delete 
		 * prepare url for poducer app
		 * url="http://localhost:5050/SpringRest-Proj-04-ProducerApp/deletelist/"+id;
		 * 
		 */
		String delete$url = "http://localhost:5050/SpringRest-Proj-04-ProducerApp/deletelist/"+id; 
		ResponseEntity<String> resp = temp.exchange(delete$url, HttpMethod.DELETE, null, String.class); //get the response entity
		String body = resp.getBody(); //get the response body
		//put the body into flash Attributes
		ra.addFlashAttribute("msg", body);
		return "redirect:alltouristlist";
	}
	
}//request Handler Class
