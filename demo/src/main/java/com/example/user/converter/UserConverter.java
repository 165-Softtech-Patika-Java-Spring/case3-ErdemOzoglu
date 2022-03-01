package com.example.user.converter;

import com.example.user.dto.UserDeleteRequestDto;
import com.example.user.dto.UserDto;
import com.example.user.dto.UserUpdateDto;
import com.example.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserEntity convertToUserEntity(UserDto userDto);

    UserEntity convertToUserEntityUpdateDto(UserUpdateDto userUpdateDto);

    UserDto convertToUserDto(UserEntity userEntity);

    UserDeleteRequestDto convertToUserDeleteDto(UserEntity userEntity);



}
