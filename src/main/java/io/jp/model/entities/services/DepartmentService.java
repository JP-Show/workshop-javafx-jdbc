package io.jp.model.entities.services;

import io.jp.model.dao.DaoFactory;
import io.jp.model.dao.DepartmentDao;
import io.jp.model.entities.Department;
import java.util.List;

public class DepartmentService {
    private DepartmentDao dao = DaoFactory.createDepartmentDao();

    public List<Department> findall() {
        return dao.findAll();
    }
}
