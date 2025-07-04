package com.ragheb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "employee")
@NamedQuery(name = "query1", query = "From EmployeeEntity e where e.deptNo=?1")
@NamedQuery(name = "query2", query = "select e from EmployeeEntity e where e.salary> :sal")
public class EmployeeEntity {
    @Id
    @Column(name = "emp_no")
    private Integer empNumber;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "sal")
    private Double salary;

    @Column(name = "dept_no")
    private Integer deptNo;

    public Integer getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(Integer empNumber) {
        this.empNumber = empNumber;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "empNumber=" + empNumber +
                ", empName='" + empName + '\'' +
                ", salary=" + salary +
                ", deptNo=" + deptNo +
                '}';
    }
}
