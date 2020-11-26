package com.tbc.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
public interface SessionRepository extends JpaRepository<Session,String> {

@Modifying
    @Query( "SELECT  p from Session p where status=?1")
    List<Session> getStatus(String status );

@Modifying
    @Query(value = "UPDATE session_data SET status=?1 where user_id=?2 and password=?3",nativeQuery = true)
  @Transactional
    int getSession(String status,String user_id,String password);
}
