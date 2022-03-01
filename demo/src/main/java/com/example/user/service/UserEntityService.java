package com.example.user.service;

import com.example.user.converter.UserConverter;
import com.example.user.dao.UserDao;
import com.example.user.dto.UserDeleteRequestDto;
import com.example.user.dto.UserDeleteResponseDto;
import com.example.user.dto.UserDto;
import com.example.user.dto.UserUpdateDto;
import com.example.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserEntityService {
    private final UserDao userDao;

    public UserDto save(UserDto userDto) {
        UserEntity userEntity = UserConverter.INSTANCE.convertToUserEntity(userDto);
        userEntity = userDao.save(userEntity);
        userDto = UserConverter.INSTANCE.convertToUserDto(userEntity);
        return userDto;
    }

    public List<UserEntity> findAll() {

        List<UserEntity> userEntityList = userDao.findAll();

        return userEntityList;
    }

    public UserDto findById(Long Id) {

        Optional<UserEntity> optionalUserEntity = userDao.findById(Id);

        UserEntity userEntity;
        if (optionalUserEntity.isPresent()) {
            userEntity = optionalUserEntity.get();
        } else {
            throw new NotFoundException("Item not found!");
        }

        UserDto userDto = UserConverter.INSTANCE.convertToUserDto(userEntity);

        return userDto;
    }

   public UserDto findByUserName(String UserName) {

        UserEntity userEntity = userDao.findByUsername(UserName);
        UserDto userDto = UserConverter.INSTANCE.convertToUserDto(userEntity);

        return userDto;
    }

    public UserDto updateUser(UserUpdateDto userUpdateDto) {

        UserEntity userEntity = UserConverter.INSTANCE.convertToUserEntityUpdateDto(userUpdateDto);

        userEntity = userDao.save(userEntity);

        UserDto userDto = UserConverter.INSTANCE.convertToUserDto(userEntity);

        return userDto;

    }

    public UserDeleteResponseDto deleteByPhoneNoAndName(UserDeleteRequestDto userDeleteDto){
        UserDeleteResponseDto userDeleteResponseDto = new UserDeleteResponseDto();
        UserEntity userEntity = userDao.findByUsernameAndPhoneNo(userDeleteDto.getUsername(),userDeleteDto.getPhoneNo());
        if(userEntity == null){
            userDeleteResponseDto.setErrorMessage(userDeleteDto.getUsername()+" kullanıcı adı ile "+userDeleteDto.getPhoneNo() + " telefonu bilgileri uyuşmamaktadır.");
        }else{
            userDao.delete(userEntity);
            userDeleteResponseDto.setPhoneNo(userEntity.getPhoneNo());
            userDeleteResponseDto.setUsername(userEntity.getUsername());
        }

        return userDeleteResponseDto;
    }
}
