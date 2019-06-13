package main;

public class ComparableClassResult extends ClassResult implements Comparable<ComparableClassResult> {

	public ComparableClassResult(String classId) {
		super(classId);
	}
	
	@Override
	public int compareTo(ComparableClassResult o) {
		return  KoansOrder.compare(className, o.className);
	}
	

}
