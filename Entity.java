package guessMaster;

public class Entity {
	private String name;
	private Date born;
	//constructor for Entity
	public Entity(String inName,Date inBorn) {
		this.setName(inName);
		this.setBorn(inBorn);
	}
	//setter and getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBorn() {
		return born;
	}
	public void setBorn(Date born) {
		this.born = born;
	}

	//converting entity to string
	public String toString() {
		return name + ", born on" + born ;
	}
	

	// checking if 2 entities are equal
	public boolean equals(Entity entity) {
		if(this==entity ) return true;
		else return false;
	}
	
}
