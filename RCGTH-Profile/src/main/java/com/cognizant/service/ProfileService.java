package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entity.Profile;
import com.cognizant.exception.ProfileAlreadyExistException;
import com.cognizant.exception.ProfileNotFoundException;
import com.cognizant.repo.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository repo;

	public List<Profile> getAllProfiles() {
		return repo.findAll();
	}

	public Profile getOneProfiles(String str) throws ProfileNotFoundException {
		if (repo.findById(str).isPresent()) {
			return repo.findById(str).get();
		} else {
			throw new ProfileNotFoundException(str + " Profile Not Found!");
		}
	}

	public Profile insertProfiles(Profile profile) throws ProfileAlreadyExistException {
		return repo.save(profile);
	}

	public Profile updateProfiles(Profile profile) throws ProfileNotFoundException {
		if (repo.findById(profile.getProfiletype()).isPresent()) {
			return repo.save(profile);
		} else {
			throw new ProfileNotFoundException(profile.getProfiletype() + " Profile Not Found!");
		}
	}

	public String deleteProfiles(String type) throws ProfileNotFoundException {
		if (repo.findById(type).isPresent()) {
			repo.deleteById(type);
			String msg = type + " Profile Deleted";
			return msg;
		} else {
			throw new ProfileNotFoundException(type + " Profile Not Found!");
		}
	}

}
