package com.cpad.assignment.service.impl;

import com.cpad.assignment.dto.request.CredentialsDTO;
import com.cpad.assignment.dto.response.UserInfoDTO;
import com.cpad.assignment.model.User;
import com.cpad.assignment.repository.UserRepository;
import com.cpad.assignment.service.UserService;
import com.cpad.assignment.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserInfoDTO login(CredentialsDTO credentials) throws Exception {
        try{
            Optional<User> user = userRepository.findByUsernameAndPassword(
                    credentials.getUsername(), credentials.getPassword());
            if(user.isPresent()){
                return modelMapper.convert(user.get());
            }
            throw new Exception();
        }catch (Exception e){
            return new UserInfoDTO();
        }
    }

}
