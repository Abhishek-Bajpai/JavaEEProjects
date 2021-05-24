package module5.assignment.collections;

import java.util.Comparator;

public class Employee implements Comparable<Employee> , Comparator<Employee>{

	private int empNo;
	private String empNameString;
	private int empPhoneNo;
	private float empSalary;
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empNameString=" + empNameString + ", empPhoneNo=" + empPhoneNo
				+ ", empSalary=" + empSalary + "]";
	}
	public Employee(int empNo, String empNameString, int empPhoneNo, float empSalary) {
		super();
		this.empNo = empNo;
		this.empNameString = empNameString;
		this.empPhoneNo = empPhoneNo;
		this.empSalary = empSalary;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpNameString() {
		return empNameString;
	}
	public void setEmpNameString(String empNameString) {
		this.empNameString = empNameString;
	}
	public int getEmpPhoneNo() {
		return empPhoneNo;
	}
	public void setEmpPhoneNo(int empPhoneNo) {
		this.empPhoneNo = empPhoneNo;
	}
	public float getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empNameString == null) ? 0 : empNameString.hashCode());
		result = prime * result + empNo;
		result = prime * result + empPhoneNo;
		result = prime * result + Float.floatToIntBits(empSalary);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empNameString == null) {
			if (other.empNameString != null)
				return false;
		} else if (!empNameString.equals(other.empNameString))
			return false;
		if (empNo != other.empNo)
			return false;
		if (empPhoneNo != other.empPhoneNo)
			return false;
		if (Float.floatToIntBits(empSalary) != Float.floatToIntBits(other.empSalary))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Employee o) {
       return empNameString.compareTo(o.empNameString);
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.equals(o2)) {
			return 1;
		}
		return 0;
	}
	
	
	
}
