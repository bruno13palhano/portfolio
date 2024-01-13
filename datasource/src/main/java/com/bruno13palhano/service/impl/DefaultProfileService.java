package com.bruno13palhano.service.impl;

import com.bruno13palhano.Profile;
import com.bruno13palhano.repository.ProfileRepository;
import com.bruno13palhano.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProfileService implements ProfileService {
    private final ProfileRepository profileRepository;

    public DefaultProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public void insert(Profile model) {
        profileRepository.insert(model);
    }

    @Override
    public void deleteById(Integer id) {
        profileRepository.deleteById(id);
    }

    @Override
    public void update(Profile model) {
        profileRepository.update(model);
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.getAll();
    }

    @Override
    public Profile getById(Integer id) {
        return profileRepository.getById(id);
    }
}
