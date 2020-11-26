package com.tbc.things;

import com.tbc.things.Things;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public interface ThingsRepository extends JpaRepository<Things,String> {
@Modifying
    @Query(value = "SELECT p from Things p WHERE user_id=?1 AND password=?2")
@Transactional
List<Things>getLogin(String user_id,String password);


}
