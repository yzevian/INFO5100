package registerDao;

public class newUser {
	private String number; // 
	private String userName; // 用户名
	private String fullName;
	private String password; // 密码
	private String age;
	private String sex;
	
	public newUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public newUser(String number,String userName,String fullName,String password,String age,String sex) {
		super();
		this.userName = userName;
		this.password = password;
		this.number = number; // 驾照
		this.fullName =fullName;
		this.age =age;
		this.sex =sex;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public  String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
