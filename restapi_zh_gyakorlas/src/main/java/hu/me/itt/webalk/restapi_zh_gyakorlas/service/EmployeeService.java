package hu.me.itt.webalk.restapi_zh_gyakorlas.service;

import hu.me.itt.webalk.restapi_zh_gyakorlas.controller.EmployeeCreateDto;

public interface EmployeeService {
    Employee getEmployeeById(Long id);
    Employee save(Employee employee);
}
