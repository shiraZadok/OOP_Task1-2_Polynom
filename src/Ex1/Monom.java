package Ex1;

import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 */
public class Monom implements function {
	public static final Monom ZERO = new Monom(0, 0);
	public static final Monom MINUS1 = new Monom(-1, 0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();


	/**
	 * this method returns the comparator of this Monom.
	 *
	 * @return
	 */
	public static Comparator<Monom> getComp() {
		return _Comp;
	}

	/**
	 * the constructor of Monom.
	 *
	 * @param a: is a double that represent the coefficient of this Monom
	 * @param b: is a int that represent the power of this Monom
	 */
	public Monom(double a, int b) {
		this.set_coefficient(a);
		this.set_power(b);
	}

	/**
	 * constructor of Monom
	 *
	 * @param ot: is a Monom represent the Monom that we want to point at him.
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	public double get_coefficient() {
		return this._coefficient;
	}

	public int get_power() {
		return this._power;
	}

	/**
	 * this method returns the derivative monom of this.
	 *
	 * @return
	 */
	public Monom derivative() {
		if (this.get_power() == 0) {
			return getNewZeroMonom();
		}
		return new Monom(this.get_coefficient() * this.get_power(), this.get_power() - 1);
	}

	/**
	 * this method calculator the value of the Monom in x value.
	 *
	 * @param x: is a double that represent the value of the x that we calculator.
	 * @return: the value of the calculator.
	 */
	public double f(double x) {
		double ans = 0;
		double p = this.get_power();
		ans = this.get_coefficient() * Math.pow(x, p);
		return ans;
	}

	/**
	 * @return
	 */
	public boolean isZero() {
		return this.get_coefficient() == 0;
	}

	// ***************** add your code below **********************

	/**
	 * constructor of Monom.
	 * get- String of Monom.
	 *
	 * @param s: is a String represent the Monom that we build.
	 */
	public Monom(String s) {
		try {
			s = s.toLowerCase();
			double a = 0.0;

			int b = 0;
			for (int i = 0; i < s.length(); i++) {
				if (i == 0 && s.charAt(i) == 'x') {
					a = 1;
					if (i == s.length() - 1)
						b = 1;
					else
						b = Integer.parseInt(s.substring(i + 2, s.length()));
					break;
				} else if (s.charAt(i) == 'x') {
					if (s.charAt(i - 1) == '-') {
						if (i == s.length() - 1)
							b = 1;
						else
							b = Integer.parseInt(s.substring(i + 2, s.length()));
						a = -1;
					} else if (i == s.length() - 1) {
						b = 1;
						a = Double.parseDouble(s.substring(0, i));
					} else {
						b = Integer.parseInt(s.substring(i + 2, s.length()));
						a = Double.parseDouble(s.substring(0, i));
					}
					break;
				} else if (i == s.length() - 1) {
					a = Double.parseDouble(s);
					b = 0;
					break;
				}
			}
			this.set_coefficient(a);
			this.set_power(b);
		} catch (Exception e) {
			System.err.println("ERR: the monom is not correct");
		}
	}

	/**
	 * this method add between two Monoms.
	 * the add succeed just if the power of the Monoms equals.
	 *
	 * @param m: is a Monom represent the Monom that we add to this.Monom.
	 */
	public void add(Monom m) {
		if (this._power != m._power) {
			System.err.println("ERR: The add it unable because the powers it different");
			return;
		} else {
			if (m._coefficient + this._coefficient == 0) this._power = 0;
			this._coefficient = this.get_coefficient() + m._coefficient;
		}
	}

	/**
	 * this method multipy between two Monoms.
	 *
	 * @param d: is a Monom. represent the Monom that we multipy to this.Monom.
	 */
	public void multipy(Monom d) {
		if (this.isZero() || d.isZero()) {
			this._coefficient = 0;
			this._power = 0;
		} else {
			this.set_coefficient(this.get_coefficient() * d.get_coefficient());
			this.set_power(this.get_power() + d.get_power());
		}
	}

	/**
	 * this method return String that represent this Monom.
	 *
	 * @return
	 */
	public String toString() {
		String a = "" + this._coefficient;
		String b = "" + this._power;
		if (this._power == 0)
			return a;
		else if (this._power == 1) {
			if (this._coefficient == 1)
				return "x";
			else if (this._coefficient == -1)
				return "-x";
			else
				return a + "x";
		} else if (this._coefficient == 1)
			return "x^" + b;
		else if (this._coefficient == -1)
			return "-x^" + b;
		return a + "x^" + b;

	}

	@Override
	public function initFromString(String s) {
		return null;
	}

	@Override
	public function copy() {
		return null;
	}


	// you may (always) add other methods.

	//****************** Private Methods and Data *****************

	public void setBcoefficient(double e) {
		set_coefficient(e);
	}

	public void setBpower(int e) {
		set_power(e);
	}

	private void set_coefficient(double a) {
		this._coefficient = a;
	}

	private void set_power(int p) {
		if (p < 0) {
			System.err.println("ERR: the power of Monom should not be negative, got: " + p);
		}
		this._power = p;
	}

	private static Monom getNewZeroMonom() {
		return new Monom(ZERO);
	}

	public boolean equals(Monom m) {
		return this._power == m._power && Math.abs(this._coefficient - m._coefficient) <= EPSILON;

	}

	private double _coefficient;
	private int _power;


}



