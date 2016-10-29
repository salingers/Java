package frank.java.chapter13.proxy.concept;

/**
 * @uml.dependency   supplier="frank.java.chapter13.proxy.concept.Subject"
 */
public class Client {

	/**
	 * @uml.property  name="subject"
	 * @uml.associationEnd  aggregation="shared" inverse="client:frank.java.chapter13.proxy.concept.Subject"
	 */
	private Subject subject;

	/**
	 * Getter of the property <tt>subject</tt>
	 * @return  Returns the subject.
	 * @uml.property  name="subject"
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * Setter of the property <tt>subject</tt>
	 * @param subject  The subject to set.
	 * @uml.property  name="subject"
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
