package test.model.mapper.impl;

import org.springframework.stereotype.Component;
import test.model.User;
import test.model.dto.request.UserRequestDto;
import test.model.dto.response.UserResponseDto;
import test.model.mapper.ModelMapper;

@Component
public class UserMapperImpl implements ModelMapper<User, UserRequestDto, UserResponseDto> {

    @Override
    public User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());
        return user;
    }

    @Override
    public UserResponseDto toDto(User entity) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setLogin(entity.getLogin());
        userResponseDto.setPassword(entity.getPassword());
        userResponseDto.setId(entity.getId());
        return userResponseDto;
    }
}
