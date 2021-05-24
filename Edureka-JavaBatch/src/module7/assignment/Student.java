/**
 * 
 */
package module7.assignment;

/**
 * @author Abhishek Bajpai
 * May 15 2021
 *
 */
public class Student {

	private int id;
	private String name;
	private String classStr;
	private float marks;
	
	public Student(int id, String name, String classStr, float marks) {
		super();
		this.id = id;
		this.name = name;
		this.classStr = classStr;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassStr() {
		return classStr;
	}

	public void setClassStr(String classStr) {
		this.classStr = classStr;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((classStr == null) ? 0 : classStr.hashCode());
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(marks);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (classStr == null) {
			if (other.classStr != null)
				return false;
		} else if (!classStr.equals(other.classStr))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(marks) != Float.floatToIntBits(other.marks))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", classStr=" + classStr + ", marks=" + marks + "]";
	}
	
	
	
	
	
}
