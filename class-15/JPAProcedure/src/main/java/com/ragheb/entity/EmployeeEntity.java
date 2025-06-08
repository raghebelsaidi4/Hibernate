package com.ragheb.entity;


import javax.persistence.*;

@Entity
@Table(name = "employee")
@NamedStoredProcedureQuery(
        name = "pro1",
        procedureName = "EMP_EXPERIENCE",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "ENO"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "NAME"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = Double.class, name = "EXPERIENCE")
        }
)
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
