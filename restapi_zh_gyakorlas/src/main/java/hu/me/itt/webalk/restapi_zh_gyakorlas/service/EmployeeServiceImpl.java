package hu.me.itt.webalk.restapi_zh_gyakorlas.service;

import hu.me.itt.webalk.restapi_zh_gyakorlas.controller.EmployeeCreateDto;
import hu.me.itt.webalk.restapi_zh_gyakorlas.repository.EmployeeModel;
import hu.me.itt.webalk.restapi_zh_gyakorlas.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<EmployeeModel> optionalEmployeeModel = employeeRepository.findById(id);
        if(optionalEmployeeModel.isEmpty())
            throw new NoSuchEntityException(id);
        return new Employee(optionalEmployeeModel.get());
    }

    @Override
    public Employee save(Employee employee) {
        return new Employee(employeeRepository.save(employee.toModel()));
    }
}
