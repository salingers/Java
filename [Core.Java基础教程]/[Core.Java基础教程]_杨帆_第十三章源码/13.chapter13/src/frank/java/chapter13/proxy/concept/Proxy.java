package frank.java.chapter13.proxy.concept;

/**
 * @uml.dependency   supplier="frank.java.chapter13.proxy.concept.RealSubject"
 */
public class Proxy implements Subject {

	@Override
	public void request() {
	}

	/**
	 * @uml.property   name="subject"
	 * @uml.associationEnd   aggregation="composite" inverse="proxy:frank.java.chapter13.proxy.concept.RealSubject"
	 */
	private RealSubject subject;

	/**
	 * Getter of the property <tt>subject</tt>
	 * 
	 * @return Returns the subject.
	 * @uml.property name="subject"
	 */
	public RealSubject getSubject() {
		return subject;
	}

	/**
	 * Setter of the property <tt>subject</tt>
	 * 
	 * @param subject
	 *            The subject to set.
	 * @uml.property name="subject"
	 */
	public void setSubject(RealSubject subject) {
		this.subject = subject;
	}

}
