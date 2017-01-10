package org.hello.boot.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hello.boot.entity.Department;
import org.hello.boot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Employee> findAll(){
		return jdbcTemplate.query("SELECT * FROM emp", new EmployeeRowMapper());
	}
	
	@Transactional(readOnly=true)
	public Employee findEmployeeById(int empno) {
		return jdbcTemplate.queryForObject("SELECT * from emp where empno=?", new Object[]{empno}, new EmployeeRowMapper());
	}
	
	class EmployeeRowMapper implements RowMapper<Employee> {
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			Employee mgr = new Employee();
			Department dept = new Department();
			employee.setEmpNo(rs.getInt("empno"));
			employee.seteName(rs.getString("ename"));
			employee.setJob(rs.getString("job"));
			mgr.setEmpNo(rs.getInt("mgr")); employee.setMgr(mgr);
			employee.setHireDate(rs.getDate("hiredate"));
			employee.setSal(rs.getDouble("sal"));
			employee.setComm(rs.getDouble("comm"));
			dept.setDeptNo(rs.getInt("deptno")); employee.setDept(dept);
			return employee;
		}
	}
	
	
}
