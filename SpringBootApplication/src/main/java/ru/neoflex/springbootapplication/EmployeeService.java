package ru.neoflex.springbootapplication;

import ru.neoflex.springbootapplication.Employee;
import ru.neoflex.springbootapplication.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getById(Long id){
       return employeeRepository.findById(id);
   }
}
