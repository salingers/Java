package frank.java.chapter07.inner.statics;

// import frank.java.chapter06.inner.statics.Outer.Inner;

public class Test {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.outerMethodOne();
		outer.outerMethodTwo();

		Outer.Inner inner = new Outer.Inner();
		// Inner inner = new Inner();
		inner.innerMethodOne();
		inner.innerMethodTwo();
	}

}
