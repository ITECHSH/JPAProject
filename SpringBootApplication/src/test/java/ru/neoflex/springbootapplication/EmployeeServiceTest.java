package ru.neoflex.springbootapplication;

import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
   @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void shouldFindObjectById(){
        Employee employee = setEmployee();
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Optional<Employee> result = employeeService.getById(1L);
        Assertions.assertTrue(result.isPresent());
        Employee emp = result.get();
        Assertions.assertEquals(1L, emp.getId());
        Assertions.assertEquals("Alex", emp.getName());
        Assertions.assertEquals("Ivanov", emp.getSurname());
    }
    @Test
    public void shouldNotFindObjectById(){
        Employee employee = setEmployee();
        Mockito.when(employeeRepository.findById(33L)).thenReturn(Optional.empty());
        Optional<Employee> result = employeeService.getById(33L);
        Assertions.assertFalse(result.isPresent());
    }

    private Employee setEmployee(){
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Alex");
        employee.setSurname("Ivanov");
        employee.setPost("manager");
        employee.setSeniority(15);
        employee.setAge(40);
        return employee;
    }
}
