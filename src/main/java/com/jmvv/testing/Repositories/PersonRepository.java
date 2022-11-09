package com.jmvv.testing.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jmvv.testing.Models.Person;

@Repository
public interface PersonRepository extends JpaRepository <Person,Integer>{
    Optional<Person> findByNumberId(int number_id);
    @Query(""+
            "SELECT CASE WHEN COUNT (p) > 0 THEN "+
            "TRUE ELSE FALSE END "+
            "FROM Person p "+
            "WHERE p.numberId = ?1 "
    )
    Boolean numberIdIsUses(Integer numberId);
}
