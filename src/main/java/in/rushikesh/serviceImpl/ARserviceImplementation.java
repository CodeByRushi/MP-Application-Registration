package in.rushikesh.serviceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.classic.pattern.Util;
import in.rushikesh.bindings.CitizenApplication;
import in.rushikesh.enitity.CitizenAppsEntity;
import in.rushikesh.repository.CitizenAppsRepo;
import in.rushikesh.service.ARservice;

@Service
public class ARserviceImplementation implements ARservice {

	@Autowired
	private CitizenAppsRepo citizenRepo;
	
	@Override
	public Integer createApplication(CitizenApplication app) {
		
		String url = "http://3.136.11.211:8080/ssn/{ssn}";
		Long ssn = app.getSsn();
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> response = rt.getForEntity(url, String.class, ssn);
		String stateName = response.getBody();
		
		if(stateName.equals("New Jersey")) {
			CitizenAppsEntity entity = new CitizenAppsEntity();
			BeanUtils.copyProperties(app, entity);
			entity.setState_name(stateName);
			CitizenAppsEntity appsEntity = citizenRepo.save(entity);
			return appsEntity.getApp_id();
		}else {
			
			return 0;
		}
		
	}

}
