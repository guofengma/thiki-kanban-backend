package org.thiki.kanban.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersPersistence {
    User findById(@Param("id") String id);

    Integer deleteById(@Param("id") String id);

    User findByName(String userName);

    User findByIdentity(@Param("identity") String identity);

    User findByCredential(@Param("identity") String identity, @Param("password") String password);

    boolean isNameExist(String userName);

    boolean isEmailExist(String email);

    Profile findProfile(String userName);

    Integer initProfile(Profile profile);

    Integer updateAvatar(@Param("userName") String userName, @Param("avatarName") String avatarName);

    Integer updateProfile(@Param("userName") String userName, @Param("profile") Profile profile);
}
