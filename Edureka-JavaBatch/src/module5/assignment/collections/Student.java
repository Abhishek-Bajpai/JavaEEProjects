package module5.assignment.collections;

public class Student {

	private int rollNo;
	private String studentNameString;
	private float totalMarks;  
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudentNameString() {
		return studentNameString;
	}
	public void setStudentNameString(String studentNameString) {
		this.studentNameString = studentNameString;
	}
	public float getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(float totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rollNo;
		result = prime * result + ((studentNameString == null) ? 0 : studentNameString.hashCode());
		result = prime * result + Float.floatToIntBits(totalMarks);
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
		Student other = (Student) obj;
		if (rollNo != other.rollNo)
			return false;
		if (studentNameString == null) {
			if (other.studentNameString != null)
				return false;
		} else if (!studentNameString.equals(other.studentNameString))
			return false;
		if (Float.floatToIntBits(totalMarks) != Float.floatToIntBits(other.totalMarks))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", studentNameString=" + studentNameString + ", totalMarks=" + totalMarks
				+ "]";
	}
	public Student(int rollNo, String studentNameString, float totalMarks) {
		super();
		this.rollNo = rollNo;
		this.studentNameString = studentNameString;
		this.totalMarks = totalMarks;
	}
	
	
}
