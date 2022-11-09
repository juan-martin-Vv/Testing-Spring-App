package com.jmvv.testing.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jmvv.testing.Exceptions.BadRequestException;
import com.jmvv.testing.Models.Person;
import com.jmvv.testing.Repositories.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository p_repo;

    public Person getPerson(int number_id){
        if(p_repo.findByNumberId(number_id).isPresent())
        return p_repo.findByNumberId(number_id).get();
        return null;
    }
    public Person savePerson(Person person) {
        if (p_repo.numberIdIsUses(person.getNumberId())) {
            throw new BadRequestException(
                "Number Id: "+person.getNumberId()+" is ready used"
            );
        }
        return p_repo.save(person);
    }
    public List<Person> getAllPerson(){
        return p_repo.findAll();
    }
}
