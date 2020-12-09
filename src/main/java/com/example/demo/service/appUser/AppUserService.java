package com.example.demo.service.appUser;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService implements IAppUserService{

    @Autowired
    private AppUserRepository userRepository;
    @Override
    public AppUser getUserByName(String name) {
        return userRepository.findAppUserByName(name);
    }

    @Override
    public Iterable<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public AppUser save(AppUser appUser) {
        return userRepository.save(appUser);
    }
}
