package com.ecommerce.bicicle.service.impl;

import com.ecommerce.bicicle.dto.ItemSavedDto;
import com.ecommerce.bicicle.dto.UserDto;
import com.ecommerce.bicicle.entity.ItemEntity;
import com.ecommerce.bicicle.entity.UserEntity;
import com.ecommerce.bicicle.mapper.ItemSaveFloatingCharsMapper;
import com.ecommerce.bicicle.mapper.UserMapper;
import com.ecommerce.bicicle.repository.ItemEntityRepository;
import com.ecommerce.bicicle.repository.UserRepository;
import com.ecommerce.bicicle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemEntityRepository itemEntityRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ItemSaveFloatingCharsMapper floatingCharsMapper;

    @Override
    public UserDto authenticate(UserDto userDto) {

        return null;
    }

    @Override
    public List<UserDto> get() {

        Iterable<UserEntity> userEntities = userRepository.findAll();

        List<UserEntity> userEntitiesList = userMapper.toUserDtoList(userEntities);

        return userMapper.toUserDtoList(userEntitiesList);
    }

    @Override
    public List<UserDto> getUserAdmins() {

        List<UserEntity> userEntities = userRepository.getByContent("BAAW_PARTNER");

        List<UserDto> userEntitiesList = userMapper.toUserDtoList(userEntities);

        return userEntitiesList;
    }

    @Override
    public UserDto get(Integer userId) {
        Optional<UserEntity> userEntities = userRepository.findById(userId);

        UserDto userDto = userMapper.toUserDto(userEntities);

        return userDto;
    }

    @Override
    public UserDto getByUsername(String userName) {
        Optional<UserEntity> userEntities = userRepository.getByUserName(userName);

        UserDto userDto = userMapper.toUserDto(userEntities);

        return userDto;
    }

    @Override
    public List<ItemSavedDto> getFavouriteItems(String userName) {

        Optional<UserEntity> userEntities = userRepository.getByUserName(userName);
        UserDto userDto = userMapper.toUserDto(userEntities);

        List<ItemSavedDto> itemSavedDtos = new ArrayList<>();

        if(userDto.getFavorites() != null) {
            if( !userDto.getFavorites().equalsIgnoreCase("") ) {
                String[] favs = userDto.getFavorites().trim().split(",");
                List<Integer> favList = Arrays.stream(favs).map(s -> Integer.parseInt(s.replace(" ", ""))).collect(Collectors.toList());

                Iterable<ItemEntity> itemIterable = this.itemEntityRepository.findAllById(favList);
                List<ItemEntity> itemEntities  = floatingCharsMapper.toItemSaveDtoList(itemIterable);
                itemSavedDtos = floatingCharsMapper.toItemSaveDtoList(itemEntities);
            }
        }

        return itemSavedDtos;
    }

    @Override
    public List<ItemSavedDto> addFavouriteItems(String userName, Integer itemId) {

        Optional<UserEntity> userEntities = userRepository.getByUserName(userName);
        UserDto userDto = userMapper.toUserDto(userEntities);

        List<ItemSavedDto> itemSavedDtos = new ArrayList<>();

        if(userDto.getFavorites() != null) {
            if( !userDto.getFavorites().equalsIgnoreCase("") ) {
                String[] favs = userDto.getFavorites().split(",");
                Set<Integer> favList = Arrays.stream(favs).map(s -> Integer.parseInt(s.replace(" ", ""))).collect(Collectors.toSet());
                favList.add(itemId);

                //edit user
                String favString = favList.toString().replace("[", "").replace("]", "");
                userDto.setFavorites(favString);

                this.userRepository.save(userMapper.toUserEntity(userDto));

                Iterable<ItemEntity> itemIterable = this.itemEntityRepository.findAllById(favList);
                List<ItemEntity> itemEntities  = floatingCharsMapper.toItemSaveDtoList(itemIterable);
                itemSavedDtos = floatingCharsMapper.toItemSaveDtoList(itemEntities);

                return itemSavedDtos;
            }
        }

        String favString = itemId + "";
        userDto.setFavorites(favString);

        this.userRepository.save(userMapper.toUserEntity(userDto));

        List<Integer> favList = new ArrayList<>();
        favList.add(itemId);

        Iterable<ItemEntity> itemIterable = this.itemEntityRepository.findAllById(favList);
        List<ItemEntity> itemEntities  = floatingCharsMapper.toItemSaveDtoList(itemIterable);
        itemSavedDtos = floatingCharsMapper.toItemSaveDtoList(itemEntities);

        return itemSavedDtos;
    }

    @Override
    public List<ItemSavedDto> removeFavouriteItems(String userName, Integer itemId) {

        Optional<UserEntity> userEntities = userRepository.getByUserName(userName);
        UserDto userDto = userMapper.toUserDto(userEntities);

        List<ItemSavedDto> itemSavedDtos = new ArrayList<>();

        if(userDto.getFavorites() != null) {
            if( !userDto.getFavorites().equalsIgnoreCase("") ) {
                String[] favs = userDto.getFavorites().split(",");
                Set<Integer> favList = Arrays.stream(favs).map(s -> Integer.parseInt(s.replace(" ", ""))).collect(Collectors.toSet());
                favList.remove(itemId);

                //edit user
                String favString = favList.toString().replace("[", "").replace("]", "");
                userDto.setFavorites(favString);

                this.userRepository.save(userMapper.toUserEntity(userDto));

                Iterable<ItemEntity> itemIterable = this.itemEntityRepository.findAllById(favList);
                List<ItemEntity> itemEntities  = floatingCharsMapper.toItemSaveDtoList(itemIterable);
                itemSavedDtos = floatingCharsMapper.toItemSaveDtoList(itemEntities);
            }
        }

        return itemSavedDtos;
    }


    @Override
    public UserDto getByUsernameAndPassword(String userName, String password) {
        Optional<UserEntity> userEntities = userRepository.getByUserNameAndPassword(userName, password);
        UserDto userDto = userMapper.toUserDto(userEntities);
        return userDto;
    }

    @Override
    public UserDto getByUsernameAndPassword(String userName, String password, Boolean userVerified) {
        Optional<UserEntity> userEntities = userRepository.getByUserNameAndPasswordAndUserVerified(userName, password, userVerified);
        UserDto userDto = userMapper.toUserDto(userEntities);
        return userDto;
    }

    @Override
    public UserDto getByUsernameAndPasswordCrossPlatform(String userName, String uid) {
        Optional<UserEntity> userEntities = userRepository.getByUserNameAndUid(userName, uid);

        UserDto userDto = userMapper.toUserDto(userEntities);
        return userDto;
    }

    @Override
    public UserDto enableUser(UserDto user) {
        Optional<UserEntity> findUser = userRepository.findById(user.getId());
        if(!findUser.isPresent()) {
            return new UserDto();
        }

        UserEntity userEntity = findUser.get();
        userEntity.setUserVerified(true);
        userEntity = userRepository.save(userEntity);

        UserDto userDto = userMapper.toUserDto(userEntity);
        return userDto;
    }

    @Override
    public UserDto save(UserDto user) {
        // 1. get User
        Optional<UserEntity> findUser = userRepository.findById(user.getId());
        if(!findUser.isPresent()) {
            return new UserDto();
        }

        // 2. set params
        try {
            UserEntity userEntity = userMapper.toUserEntity(findUser);
            userEntity.setUserName(user.getUserName());
            userEntity.setEmail(user.getEmail());
            userEntity.setLastname(user.getLastname());
            userEntity.setName(user.getName());

            userEntity = userRepository.save(userEntity);

            return userMapper.toUserDto(userEntity);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    @Override
    public UserDto registerUser(UserDto user) {

        user.setUserVerified(false);
        UserEntity userEntity = userMapper.toUserEntity(user);

        userEntity = userRepository.save(userEntity);

        return userMapper.toUserDto(userEntity);
    }

    @Override
    public UserDto savePassword(UserDto user) {
        // 1. get User
        Optional<UserEntity> findUser = userRepository.findById(user.getId());
        if(!findUser.isPresent()) {
            return new UserDto();
        }

        // 2. set params
        try {
            UserEntity userEntity = userMapper.toUserEntity(findUser);
            userEntity.setPassword(user.getPassword());

            userEntity = userRepository.save(userEntity);

            return userMapper.toUserDto(userEntity);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto saveCrossPlatform(UserDto user) {

        // 1. set params
        try {
            UserEntity userEntity = userMapper.toUserEntity(user);
            userEntity.setUserVerified(true);

            Optional<UserEntity> findUser = userRepository.getByUserName(user.getUserName());
            if(findUser.isPresent()) {
                // Modify uid only
                userEntity = findUser.get();
                userEntity.setUid(user.getUid());
            }

            userEntity = userRepository.save(userEntity);

            return userMapper.toUserDto(userEntity);
        } catch (NullPointerException e) {
            e.getMessage();
            throw new NullPointerException();
        }
    }

    String[] removeDuplicates(String[] input) {

        //String[] input = new int[]{1, 1, 3, 7, 7, 8, 9, 9, 9, 10};
        String current = input[0];
        boolean found = false;

        for (int i = 0; i < input.length; i++) {
            if (current == input[i] && !found) {
                found = true;
            } else if (current != input[i]) {
                System.out.print(" " + current);
                current = input[i];
                found = false;
            }
        }
        System.out.print("Remove Duplicates " + current);

        return input;
    }
}
