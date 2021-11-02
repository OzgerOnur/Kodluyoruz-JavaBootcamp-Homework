package com.kodluyoruz.weekFourHomework.model.mapper;

import com.kodluyoruz.weekFourHomework.model.dto.UserDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.User;
import com.kodluyoruz.weekFourHomework.model.request.CreateUpdateUserRequest;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring") //uses = {BasketMapper.class}
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);


    @Mapping(target = "basketId",source = "basket",qualifiedByName = "basketTObasketId")
    UserDto toUserDto(User user);

    @Named("basketTObasketId")
    public static Integer basketTObasketId(Basket basket){
        return basket.getId();
    }


    User createUser(CreateUpdateUserRequest createUpdateUserRequest);

    List<UserDto> toUserDtoList(List<User> user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUser(@MappingTarget User user, CreateUpdateUserRequest request);





}
