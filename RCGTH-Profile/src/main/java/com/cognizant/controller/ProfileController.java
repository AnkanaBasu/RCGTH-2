package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Profile;
import com.cognizant.exception.ProfileAlreadyExistException;
import com.cognizant.exception.ProfileNotFoundException;
import com.cognizant.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService service;

	@GetMapping("/")
	public List<Profile> getAllProfiles() {
		return service.getAllProfiles();
	}
	
	@GetMapping("/{str}")
	public Profile getOneProfiles(@PathVariable String str) throws ProfileNotFoundException {
		return service.getOneProfiles(str);
	}

	@PostMapping("/")
	public Profile insertProfiles(@RequestBody Profile profile) throws ProfileAlreadyExistException {
		return service.insertProfiles(profile);
	}

	@PutMapping("/")
	public Profile updateProfiles(@RequestBody Profile profile) throws ProfileNotFoundException {
		return service.updateProfiles(profile);
	}

	@DeleteMapping("/{str}")
	public String deleteProfiles(@PathVariable String str) throws ProfileNotFoundException {
		return service.deleteProfiles(str);
	}

}
