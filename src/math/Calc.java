package math;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calc {

	public static double stderr(double[] f, double mean) {
		double tmp = 0, m = mean;

		for (int i = 0; i < f.length; i++) {
			tmp += (f[i] - m) * (f[i] - m);
		}
		tmp = Math.sqrt(tmp * (1 / (f.length - 1)));
		return tmp;
	}

	public static double mean(List<Float> f) {
		double m = 0;

		for (int i = 0; i < f.size(); i++) {
			m += f.get(i);
		}
		m /= f.size();

		return m;
	}

	public static double variance(List<Float> f) {
		double res = 0, mean = mean(f);
		for (double i : f) {
			res += Math.pow(i - mean, 2);
		}
		return res /= (mean - 1);
	}

	public static List<Float> ccr(List<Float> a, List<Float> b) {
		if(a.size() != b.size())
			throw new InvalidParameterException("both lists must have same length!");
		
		ArrayList<Float> c = new ArrayList<Float>();

		for (int i = -b.size() + 1; i < (int) b.size(); i++) {
			c.add(dot(a, shift(b, i)));
		}
		return c;
	}

	public static List<Float> shift(List<Float> a, int s) {

		ArrayList<Float> c = new ArrayList<Float>(Collections.nCopies(a.size(), 0f));

		for (int i = 0; i < c.size(); i++) {
			if ((s + i >= 0) && (s + i < a.size()))
				c.set(i, a.get(s + i));
		}

		return c;
	}

	public static float dot(List<Float> a, List<Float> b) {
		if(a.size() != b.size())
			throw new InvalidParameterException("both lists must have same length!");

		float sum = 0;

		for (int i = 0; i < a.size(); i++) {
			sum += a.get(i) * b.get(i);
		}

		return sum;

	}

}
