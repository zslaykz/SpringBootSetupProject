package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.owu.entity.User;

public interface UserDao extends JpaRepository<User,Integer> {

    @Query("from u where u.username=:name")
    User findByUserName(@Param("name") String name);

}
