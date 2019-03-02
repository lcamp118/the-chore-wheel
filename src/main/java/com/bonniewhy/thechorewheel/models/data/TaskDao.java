package com.bonniewhy.thechorewheel.models.data;

import com.bonniewhy.thechorewheel.models.Tasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TaskDao extends CrudRepository<Tasks, Integer> {
}
