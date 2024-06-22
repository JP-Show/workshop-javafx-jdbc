package io.jp.model.entities.services;

import io.jp.model.entities.Department;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    public List<Department> findall() {
        List<Department> list = new ArrayList<>();
        list.add(new Department(1, "Books"));
        list.add(new Department(2, "Compuuters"));
        list.add(new Department(3, "Electronics"));
        return list;
    }
}
