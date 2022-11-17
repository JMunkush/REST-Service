package io.munkush.com.dao;

import io.munkush.com.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class EmployeeDAOImpl implements EmployeeDAO {


    private final SessionFactory sessionFactory;

    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();

        Query<Employee> query = session.createQuery("from Employee", Employee.class);


        return query.getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);

        query.executeUpdate();
    }

    @Override
    public void update(Employee employee, int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Employee set name=:n, surname=:sn, department=:d where id=:id");
        query.setParameter("n", employee.getName());
        query.setParameter("sn", employee.getSurname());
        query.setParameter("d", employee.getDepartment());
        query.setParameter("id", id);

        query.executeUpdate();
    }
}
