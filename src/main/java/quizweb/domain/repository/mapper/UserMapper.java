package quizweb.domain.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import quizweb.domain.repository.entity.User;

@Mapper
public interface UserMapper {

    public List<User> findAll();

    public User find(long id);

    public void insert(User user);

}
