

class student {
	private String id;
	private String name;
	private String className;

	student(String id, String name,String className) {
		setId(id);
		setName(name);
		setClassName(className);
	}

	public String getId() {
		return id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name +", classname="+className+  "]";
	}

}
