package test;

import com.arief.hibernate.model.dao.DepartmentDAO;
import com.arief.hibernate.model.dao.EmployeeDAO;
import com.arief.hibernate.model.dao.impl.DepartmentDAOImpl;
import com.arief.hibernate.model.dao.impl.EmployeeDAOImpl;
import com.arief.hibernate.model.entity.Department;
import com.arief.hibernate.model.entity.Employee;
import com.arief.hibernate.setup.HibernateSetup;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HibernateTestApp {



//    @Test
    public void findEmployeesThatDontHaveProject(){
        SessionFactory sessionFactory  = HibernateSetup.sessionFactoryInstance();
        EmployeeDAO dao = new EmployeeDAOImpl(sessionFactory);

//        List<Employee> list = dao.findEmployeesThatDoesntHaveProject();
//
//        for(Employee e : list){
//            System.out.println(e.getEmployeeId());
//            System.out.println(e.getEmployeeName());
//        }
    }


//    @Test
    public void insertDepartment(){
        Department department = new Department();

        department.setDepartmentId("D001");
        department.setDepartmentName("Department A");
        department.setDepartmentLocation("Jakarta");
        department.setEmployeeList(new ArrayList<Employee>());

        SessionFactory sessionFactory = HibernateSetup.sessionFactoryInstance();
        DepartmentDAO dao = new DepartmentDAOImpl(sessionFactory);


        dao.save(department);



    }


//    @Test
    public void testDepartmentDAO(){
        SessionFactory sessionFactory = HibernateSetup.sessionFactoryInstance();

        DepartmentDAO departmentDAO = new DepartmentDAOImpl(sessionFactory);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl(sessionFactory);


//        Department departmentA = departmentDAO.findOne("D001");


        departmentDAO.removeEmployee(3,"D001");

    }
}
