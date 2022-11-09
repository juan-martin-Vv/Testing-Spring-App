package com.jmvv.testing.Repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.jmvv.testing.Models.Genere;
import com.jmvv.testing.Models.Person;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository underTestRepo;

    private Person sample = new Person(
                                null,
                                "Lucy", 
                                24, 
                                Genere.Female, 
                                LocalDate.parse("2000-02-01"), 
                                1);

    @Test
    void insertPerson() {
        Person personTest = sample;
        assertTrue(underTestRepo.saveAndFlush(personTest).getName().equals(sample.getName()));
    }

    @Test
    void testFindByNumberId() {
        insertPerson();
        assertTrue(underTestRepo.findByNumberId(1).get().getName().equals(sample.getName()));
    }

    @Test
    void testNumberIdIsUses() {
        insertPerson();
        Boolean isLoaded = underTestRepo.numberIdIsUses(sample.getNumberId());
        assertTrue(isLoaded.equals(true));
    }
}
