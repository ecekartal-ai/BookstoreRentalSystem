import java.util.Comparator;

public class LengthComparator implements Comparator<Content>{

	@Override
	public int compare(Content o1, Content o2) {
		return o2.length - o1.length;
	}
}
