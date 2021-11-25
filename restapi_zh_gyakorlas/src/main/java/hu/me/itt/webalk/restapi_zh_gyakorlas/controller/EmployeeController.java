package hu.me.itt.webalk.restapi_zh_gyakorlas.controller;

import hu.me.itt.webalk.restapi_zh_gyakorlas.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id){
        return new EmployeeDto(employeeService.getEmployeeById(id));
    }

    @PostMapping(consumes = "application/json")
    public EmployeeDto save(@RequestBody @Valid EmployeeCreateDto employeeCreateDto){
        return new EmployeeDto(employeeService.save(employeeCreateDto.toEmployee()));
    }
}
