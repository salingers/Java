package frank.java.chapter07.inf;

public interface Flyer {
	void fly();
}

class Vehicle {	
}

class Airplane extends Vehicle implements Flyer {
	@Override
	public void fly() {
		System.out.println("飞机在天上飞！");
	}
}

class Creature {
	public void eat() {
		System.out.println("是生物都要吃东西！");
	}
}

class Bird extends Creature implements Flyer {
	@Override
	public void fly() {
		System.out.println("小鸟在天上飞！");
	}
	
	public void buildNest() {
		System.out.println("小鸟在筑巢！");
	}
	
	public void layEggs() {
		System.out.println("小鸟在生蛋！");
	}
}

class ET extends Creature {
}

class Superman extends ET implements Flyer {
	@Override
	public void fly() {
		System.out.println("超人在天上飞！");
	}
	
	public void laserShot() {
		System.out.println("超人可以发射激光，好厉害的哦！");
	}
}