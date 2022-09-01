package com.taskplanner.users.controller;

import com.taskplanner.users.dto.UserDto;
import com.taskplanner.users.entities.User;
import com.taskplanner.users.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Laura Garcia
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private ModelMapper modelMapper = new ModelMapper();

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        List<User> users = userService.getAll();
        List<UserDto> usersDto = new ArrayList<>();
        for(User user : users){
            UserDto userDto = modelMapper.map(user, UserDto.class);
            usersDto.add(userDto);
        }
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<UserDto> findById( @PathVariable String id ) {
        try{
            User user = userService.findById(id);
//            System.out.println(user.getId());
            UserDto userDto = modelMapper.map(user, UserDto.class);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserDto> create( @RequestBody UserDto userDto ) {
        User user = modelMapper.map(userDto, User.class);
        System.out.println(user.getId());
        userService.create(user);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<UserDto> update( @RequestBody UserDto user, @PathVariable String id ) {
        try{
            User userMp = modelMapper.map(user, User.class);
            UserDto userDto =  modelMapper.map(userService.update(userMp, id), UserDto.class);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        try{
            userService.deleteById(id);
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }
    }
}