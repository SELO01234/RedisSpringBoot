package com.example.SpringBootRedis_demo.repository;

import com.example.SpringBootRedis_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @Autowired
    private RedisTemplate redisTemplate;
    private static final String KEY = "USER";

    @Override
    public boolean saveUser(User user) {
        try{
            redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> users = redisTemplate.opsForHash().values(KEY);
        return users;
    }

    @Override
    public User getUser(Long id) {
        User user = (User) redisTemplate.opsForHash().get(KEY, id.toString());
        return user;
    }

    @Override
    public boolean deleteUserById(Long id) {
        try{
            redisTemplate.opsForHash().delete(KEY, id.toString());
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(Long id, User user) {
        try{
            redisTemplate.opsForHash().put(KEY, id.toString(), user);
            return true;
        }
        catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }
}
