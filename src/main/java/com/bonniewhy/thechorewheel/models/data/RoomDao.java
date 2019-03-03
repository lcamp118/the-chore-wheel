package com.bonniewhy.thechorewheel.models.data;

import com.bonniewhy.thechorewheel.models.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoomDao extends CrudRepository<Room, Integer> {
}
