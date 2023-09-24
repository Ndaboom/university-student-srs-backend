package com.cyberclick.universityStudentSrsBackend.service;

import com.cyberclick.universityStudentSrsBackend.entity.UserInfo;
import com.cyberclick.universityStudentSrsBackend.repository.UserInfoRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserInfo> userDetail = repository.findByName(username);

        // Converting userDetail to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }

    public List<String> addUser(UserInfo userInfo) {
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        repository.save(userInfo);

        List<String> userDetails = new ArrayList<>();
        userDetails.add(userInfo.getName());
        userDetails.add(userInfo.getEmail());
        userDetails.add(userInfo.getRoles());
        userDetails.add(userInfo.getId()+"");

        return userDetails;
    }
}
