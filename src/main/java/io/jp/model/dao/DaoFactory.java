package io.jp.model.dao;

import io.jp.db.DB;
import io.jp.model.dao.impl.DepartmentDaoJDBC;
import io.jp.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}

	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
