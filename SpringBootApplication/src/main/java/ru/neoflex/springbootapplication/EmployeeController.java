package ru.neoflex.springbootapplication;

import ru.neoflex.springbootapplication.Employee;
import ru.neoflex.springbootapplication.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/{id}")
    public Optional<EmployeeDto> findById(@PathVariable Long id) {
        return Optional.of(new EmployeeDto(employeeService.getById(id)));
    }
}
