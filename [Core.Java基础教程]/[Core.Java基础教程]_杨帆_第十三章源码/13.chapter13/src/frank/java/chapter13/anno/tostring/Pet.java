package frank.java.chapter13.anno.tostring;

@ClassName("宠物")
public class Pet {
	@FieldName("物种")
	public String type;
	@FieldName("昵称")
	public String name;
	@FieldName("公母")
	public boolean sex;
	@FieldName("年轮")
	public int age;
	
	@Override
	public String toString() {
		try {
			return ToStringUtils.AnnotationToString(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
