package in.rushikesh.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rushikesh.bindings.CitizenApplication;
import in.rushikesh.service.ARservice;

@RestController
public class ARrestController {
	
	@Autowired
	private ARservice service;
	
	@PostMapping("/create")
	public ResponseEntity<String> createApplication(@RequestBody CitizenApplication app) {
		Integer appId = service.createApplication(app);
		if(appId > 0) {
			return new ResponseEntity<>("Application saved successfully.", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Invalid SSN.", HttpStatus.BAD_REQUEST);
		}
	}

}
