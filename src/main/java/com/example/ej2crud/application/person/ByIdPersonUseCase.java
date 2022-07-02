package com.example.ej2crud.application.person;

import com.example.ej2crud.application.exceptions.NotFoundException;
import com.example.ej2crud.domain.Person;
import com.example.ej2crud.infraestructure.dto.output.OutputPersonDto;
import com.example.ej2crud.infraestructure.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ByIdPersonUseCase extends PersonUseCase {

    ByIdPersonUseCase(PersonRepository personRepository) {
        super(personRepository);
    }
    public OutputPersonDto getById(int id) {
        List<Person> personList = this.personRepository.findById(id);
        if (personList == null) {
            throw new NotFoundException("El id no existe");
        }
        Person person = personList.get(0);
        return this.serialize(person);
    }
}
