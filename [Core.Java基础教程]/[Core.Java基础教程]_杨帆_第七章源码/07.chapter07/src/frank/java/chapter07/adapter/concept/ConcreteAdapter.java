package frank.java.chapter07.adapter.concept;


public class ConcreteAdapter implements Adapter {
	

	@Override
	public void operation() {
		adaptee.adaptedOperation();
	}

	/**
	 * @uml.property   name="adaptee"
	 * @uml.associationEnd   inverse="concreteAdapter:frank.java.chapter07.adapter.concept.Adaptee"
	 */
	private Adaptee adaptee;

	/** 
	 * Getter of the property <tt>adaptee</tt>
	 * @return  Returns the adaptee.
	 * @uml.property  name="adaptee"
	 */
	public Adaptee getAdaptee() {
		return adaptee;
	}

	/** 
	 * Setter of the property <tt>adaptee</tt>
	 * @param adaptee  The adaptee to set.
	 * @uml.property  name="adaptee"
	 */
	public void setAdaptee(Adaptee adaptee) {
		this.adaptee = adaptee;
	}


}
