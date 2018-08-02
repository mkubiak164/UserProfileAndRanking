package com.capgemini.user.profile.and.ranking.profile;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("profile")
public class ProfileController {
	
	@Autowired 
	ProfileService profileService;
	
	Map<Long, ProfileDTO> profileData = new HashMap<Long, ProfileDTO>();

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody 
	public ProfileDTO getProfile(@RequestParam long id) {
		return  profileService.showProfile(id);
	}
		
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody 
	public void pushProfile(@RequestParam ProfileDTO profileDTO) {
		profileService.addProfile(profileDTO);
	}
	

	@RequestMapping(value = "search/email/name")
	public ProfileDTO search(@RequestParam("email") String email, @RequestParam("name") String name) {
		return profileService.searchByEmailName(email, name);
	}
	

}


