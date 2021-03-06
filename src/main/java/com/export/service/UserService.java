package com.export.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.export.Utils;
import com.export.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Philip Kwadwo Appiah
 */

@Service
public class UserService {

    final String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final String candidateNum = "0123456789";


    @Autowired
    Utils appUtil;
    public List<User> findAllUsers(){


        List<User> users = IntStream.rangeClosed(1,20)
                .mapToObj( i -> new User(appUtil.generateRandomChars(candidateChars,10),
                		                 appUtil.generateRandomChars(candidateChars, 10),
                		                 appUtil.generateRandonInteger(i),
                                         appUtil.generateRandomChars(candidateChars,15),
                                         appUtil.generateRandomChars(candidateChars,15),
                                         appUtil.generateRandomChars(candidateChars,20),
                                         appUtil.generateRandomChars(candidateChars,10),
                                         appUtil.generateRandomChars(candidateChars,10),
                                         appUtil.generateRandomChars(candidateNum,10)))
                .collect(Collectors.toList());

        return users;

    }
}
