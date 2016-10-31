package frank.java.chapter07.inf;

public interface Flyer {
	void fly();
}

class Vehicle {
}

class Airplane extends Vehicle implements Flyer {
	@Override
	public void fly() {
		System.out.println("憌�憭拐����");
	}
}

class Creature {
	public void eat() {
		System.out.println("����閬��正嚗�");
	}
}

class Bird extends Creature implements Flyer {
	@Override
	public void fly() {
		System.out.println("撠�憭拐����");
	}

	public void buildNest() {
		System.out.println("撠�蝑楷嚗�");
	}

	public void layEggs() {
		System.out.println("撠������");
	}
}

class ET extends Creature {
}

class Superman extends ET implements Flyer {
	@Override
	public void fly() {
		System.out.println("頞犖�憭拐����");
	}

	public void laserShot() {
		System.out.println("頞犖�隞亙������末��拿��嚗�");
	}
}