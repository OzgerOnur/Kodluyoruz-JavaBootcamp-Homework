package com.kodluyoruz.weekFourHomework.service;

import com.kodluyoruz.weekFourHomework.exceptions.errors.NotFoundException;
import com.kodluyoruz.weekFourHomework.model.dto.UserDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.User;
import com.kodluyoruz.weekFourHomework.model.mapper.UserMapper;
import com.kodluyoruz.weekFourHomework.model.request.CreateUpdateUserRequest;
import com.kodluyoruz.weekFourHomework.repository.BasketRepository;
import com.kodluyoruz.weekFourHomework.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.weekFourHomework.model.mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BasketService basketService;

    public UserDto createUser(CreateUpdateUserRequest request) {
        User user = USER_MAPPER.createUser(request);
        User createdUser = userRepository.save(user);
        Basket basket = basketService.createBasket(createdUser.getId());
        createdUser.setBasket(basket);
        return USER_MAPPER.toUserDto(createdUser);
    }

    protected User getUserEntity(int id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));

    }


    public UserDto getUser(int id) {
        User user = getUserEntity(id);
        return USER_MAPPER.toUserDto(user);
    }

    public UserDto updateUser(int id, CreateUpdateUserRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException());
        USER_MAPPER.updateUser(user,request);
        User createdUser = userRepository.save(user);
        return USER_MAPPER.toUserDto(createdUser);
    }

    public List<UserDto> getUsers(String name) {
        List<User> users = userRepository.findAll();
        return USER_MAPPER.toUserDtoList(users);
    }

    public void deleteUser(int id) {
        User user = userRepository.getById(id);
        user.setDeleted(true);
        userRepository.save(user);
    }

}
