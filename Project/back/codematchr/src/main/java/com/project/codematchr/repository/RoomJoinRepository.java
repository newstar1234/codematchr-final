package com.project.codematchr.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.codematchr.entity.RoomJoinEntity;
import com.project.codematchr.entity.pk.RoomJoinPk;

@Repository
public interface RoomJoinRepository extends JpaRepository<RoomJoinEntity, RoomJoinPk> {

    RoomJoinEntity findByUserEmail(String userEmail);

    List<RoomJoinEntity> findByRoomNumber(Integer roomNumber);

    RoomJoinEntity findByRoomNumberAndUserEmail(Integer roomNumber, String userEmail);
    
}
