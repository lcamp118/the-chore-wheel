package com.bonniewhy.thechorewheel.models.data;

import com.bonniewhy.thechorewheel.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<Users, Integer> {
}
