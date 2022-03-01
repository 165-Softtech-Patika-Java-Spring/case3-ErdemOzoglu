package com.example.user.controller;

import com.example.user.dto.UserDeleteRequestDto;
import com.example.user.dto.UserDeleteResponseDto;
import com.example.user.dto.UserDto;
import com.example.user.dto.UserUpdateDto;
import com.example.user.entity.UserEntity;
import com.example.user.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    public final UserEntityService userEntityService;

    @PostMapping("/saveUser")
    public ResponseEntity saveUser(@RequestBody UserDto userDto) {

        UserDto userDto1 = userEntityService.save(userDto);

        return ResponseEntity.ok(userDto1);
    }

    @GetMapping("/findAllUser")
    public ResponseEntity findAllUser() {

        List<UserEntity> UserEntityList = userEntityService.findAll();

        return ResponseEntity.ok(UserEntityList);
    }

    @GetMapping("/findById/{Id}")
    public ResponseEntity findById(@PathVariable Long Id) {

        UserDto userDto = userEntityService.findById(Id);

        return ResponseEntity.ok(userDto);
    }

   @GetMapping("/findByUserName")
    public ResponseEntity findByUserName(@RequestParam String UserName) {

        UserDto userDto = userEntityService.findByUserName(UserName);

        return ResponseEntity.ok(userDto);
    }

    @PatchMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody UserUpdateDto userUpdateDto) {

        UserDto userDto1 = userEntityService.updateUser(userUpdateDto);

        return ResponseEntity.ok(userDto1);
    }
    @DeleteMapping("/deleteByUserNameAndPhoneNo")
    public ResponseEntity deleteByUserNameAndPhoneNo(@RequestBody UserDeleteRequestDto userDeleteDto){

       UserDeleteResponseDto userDeleteResponseDto = userEntityService.deleteByPhoneNoAndName(userDeleteDto);

        return ResponseEntity.ok(userDeleteResponseDto);
    }

}
