package com.jmvv.testing.Services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jmvv.testing.Exceptions.BadRequestException;
import com.jmvv.testing.Models.Genere;
import com.jmvv.testing.Models.Person;
import com.jmvv.testing.Repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository repositoryTest;

    private PersonService serviceTest;

    private final Person sample = new Person(
        null,
        "Lucy", 
        24, 
        Genere.Female, 
        LocalDate.parse("2000-02-01"), 
        1);
// when
    
    @BeforeEach
    void setUp(){
        serviceTest=new PersonService(repositoryTest);
    }


    @Test
    void canGetAllPerson() {
        // when
        serviceTest.getAllPerson();
        // then
        verify(repositoryTest).findAll();
    }

    @Test
    @Disabled
    void testGetPerson() {

    }

    @Test
    void testSavePerson() {
        // given sample person
     
        serviceTest.savePerson(sample);
        // then
        ArgumentCaptor<Person> personArgumentCaptor = ArgumentCaptor.forClass(Person.class);
        verify(repositoryTest).save(personArgumentCaptor.capture());
        Person personSaved = personArgumentCaptor.getValue();
        assertThat(sample).isEqualTo(personSaved);
    }

    @Test
    void whenNumberIdExist(){
        // given sample person and mock number id exist
        when(repositoryTest.numberIdIsUses(sample.getNumberId())).thenReturn(true);
        assertThatThrownBy(()->serviceTest.savePerson(sample))
                        .isInstanceOf(BadRequestException.class)
                        .hasMessageContaining("Number Id: "+sample.getNumberId()+" is ready used");
        verify(repositoryTest,never()).save(any());
    }
}
