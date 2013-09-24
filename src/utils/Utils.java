package utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static List<Double> arrayToList(double[] a) {
		List<Double> l = new ArrayList<Double>(a.length);

		for (double e : a)
			l.add(e);

		return l;
	}
}
