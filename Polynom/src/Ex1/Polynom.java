package Ex1;

import java.util.Iterator;
import java.util.LinkedList;



/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 *
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
	public LinkedList<Monom> P = new LinkedList<>();
	/**
	 * Zero (empty polynom)
	 */
	public Polynom()
	{
		this.P = new LinkedList<Monom>() ;
	}
	/**
	 * init a Polynom from a String such as:
	 *  {"x", "3+1.4X^3-34x", "(2x^2-4)*(-1.2x-7.1)", "(3-3.4x+1)*((3.1x-1.2)-(3X^2-3.1))"};
	 * @param s: is a string represents a Polynom
	 */
	public Polynom(String s) {
		s=s.replace(" ","");
		if(s.charAt(0)== '+') s=s.substring(1);
		int i = 0;
		while (i<s.length()){
			if(s.charAt(i)=='+'){
				String t = s.substring(0,i);
				Monom m = new Monom(t);
				this.P.add(m);
				s=s.substring(i+1);
				i=0;
			}
			else if(s.charAt(i)=='-' && i!=0){
				String t = s.substring(0,i);
				Monom m = new Monom(t);
				this.P.add(m);
				s=s.substring(i);
				i=0;
			}
			else if(i==s.length()-1){

				Monom m = new Monom(s);
				this.P.add(m);
				return;
			}
			else i++;
		}
	}

	/**
	 * this method calculator the value of the function in x value.
	 * @param x: is a double that represent the value of the x that we calculator.
	 * @return
	 */
	public double f(double x) {
		Iterator<Monom> i = this.iteretor();
		double sum = 0;
		while (i.hasNext()) {
			Monom t = i.next();
			sum = sum + t.f(x);
		}
		return sum;
	}

	/**
	 * this method add between two Polynoms.
	 * @param p1: is a Polynom_able that we add.
	 */
	@Override
	public void add(Polynom_able p1) {
		boolean flag = true;
		Iterator<Monom> i = p1.iteretor();
		while (i.hasNext()){
			Monom temp = i.next();
			flag=check(temp);
			if(!flag){
				this.P.add(new Monom(temp));
			}
		}
		this.Organarrangement();

	}

	/**
	 * this method check if exist in this polynom an organ with a same power to s.
	 * @param s: is a Monom that we check.
	 * @return
	 */
	private boolean check(Monom s){
		boolean flag = false;
		Iterator<Monom> runner = this.iteretor();
		while(runner.hasNext()){
			Monom temp = runner.next();
			if(temp.get_power()==s.get_power()){
				temp.add(s);
				if(temp.get_coefficient()==0)
					this.P.remove(temp);
				return true;
			}
		}
		return flag;
	}

	/**
	 * this method add between polynom to Monom.
	 * @param m1:is a Monom tha we add
	 */
	@Override
	public void add(Monom m1) {
		Iterator<Monom> i = this.P.iterator();
		while (i.hasNext()) {
			Monom t = i.next();
			if (m1.get_power() == t.get_power()) {
				t.add(m1);
				return;
			}
		}
		this.P.add(m1);
		Organarrangement();
	}

	/**
	 * this method substract between two polynom.
	 * @param p1: is a polynom_able that we substract.
	 */
	@Override
	public void substract(Polynom_able p1) {
		Polynom_able temp = p1.copy();
		temp.multiply(Monom.MINUS1);
		this.add(temp);
		if (this.P.size()==0)
			this.P.add(Monom.ZERO);
		this.Organarrangement();
	}

	/**
	 * this method multiply between two polynom.
	 * @param p1: is a polynom_able that we multiply.
	 */
	@Override
	public void multiply(Polynom_able p1) {
		Iterator<Monom> i = p1.iteretor();
		Polynom temp = new  Polynom();
		while (i.hasNext()){
			Monom t = i.next();
			Polynom c = (Polynom) this.copy();
			c.multiply(t);
			temp.add(c);
		}
		temp.Organarrangement();
		this.P = temp.P;
	}

	/**
	 * this method compares between two polynom.
	 * @param p1: is a polynom_able that we compares.
	 * @return: if equals return true else false.
	 */
	@Override
	public boolean equals(Object p1) {
		if (p1 instanceof ComplexFunction) {
			ComplexFunction cf = (ComplexFunction) p1;
			return cf.equals(this);
		}
		else if (p1 instanceof Monom) {
			Monom m = (Monom) p1;
			if(this.P.size()>1) return false;
			return this.P.get(0).equals(m);
		}
		else if (p1 instanceof Polynom) {
			this.Organarrangement();
			((Polynom) p1).Organarrangement();
			Iterator<Monom> t = this.iteretor();
			Iterator<Monom> pi = ((Polynom) p1).iteretor();
			if (this.P.size() != ((Polynom) p1).P.size())
				return false;
			else {
				while (t.hasNext() && pi.hasNext()) {
					Monom t1 = t.next();
					Monom pi1 = pi.next();
					boolean ans = t1.equals(pi1);
					if (ans == false)
						return false;
				}
				return true;
			}
		}
		else{
			return false;
		}
	}

	/**
	 * this method check if this polynom is  a Zero.
	 * @return: true if correct else false.
	 */
	@Override
	public boolean isZero() {
		boolean b = this.P.getFirst().isZero();
		return b;
	}

	/**
	 * this method check and calculator if there is a point with X-axis on this Polynom.
	 * @param x0 starting point
	 * @param x1 end point
	 * @param eps>0 (positive) representing the epsilon range the solution should be within.
	 * @return the value of the point.
	 */
	@Override
	public double root(double x0, double x1, double eps) {
		if (this.P.getFirst().equals(Monom.ZERO)){ //check if the Polynom equals to Zero
			System.err.println("ERR: there is no point with the x-axis");
			return -1;
		}
		double y0 = this.f(x0);
		double y1 = this.f(x1);
		if (y0 * y1 > 0 || x0 > x1){
			System.err.println("ERR: the point is not exist");
			return -1;
		}
		double mid = 0;
		while (x1 - x0 > eps) {
			mid = (x0 + x1) / 2;
			double Ymid = this.f(mid);
			if (Ymid == 0)
				return mid;
			else if (Ymid * y0 > 0) {
				x0 = mid;
				y0 = Ymid;
			} else {
				x1 = mid;
				y1 = Ymid;
			}
		}
		return mid;

	}

	/**
	 * copy constructor of this Polynom
	 * @return: a vote to new Polynom.
	 */
	@Override
	public Polynom_able copy() {
		Polynom_able n = new Polynom();
		Iterator<Monom> i = this.iteretor();
		while (i.hasNext()) {
			Monom t = i.next();
			Monom m = new Monom(t);
			n.add(m);
		}
		return n;
	}

	/**
	 * this method returns the derivative of this Polynom.
	 * @return
	 */
	@Override
	public Polynom_able derivative() {
		Iterator<Monom> i = this.iteretor();
		Polynom ans = new Polynom();
		while (i.hasNext()){
			Monom m = i.next();
			Monom temp = m.derivative();
			if(temp.get_coefficient()!=0)
				ans.add(temp);
		}
		return  ans;
	}

	/**
	 * this method calculator the area between the function(Polynom) to the X-axis.
	 * @param x0 starting pooint
	 * @param x1 end point
	 * @param eps positive step value
	 * @return
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		double ans=0;
		for (double x=x0+eps; x <x1; x+=eps) {
			if(this.f(x)>=0) {
				double y = this.f(x);
				double Srectangle = eps * y;
				ans += Srectangle;
			}
		}
		return ans;
	}

	/**
	 * this method return the Iterator of this Polynom.
	 * @return
	 */
	@Override
	public Iterator<Monom> iteretor() {
		return P.iterator();
	}

	/**
	 * this method multiply between this Polynom to Monom.
	 * @param m1: is a Monom that we multi.
	 */
	@Override
	public void multiply(Monom m1) {
		int index = 0;
		while (index < this.P.size()) {
			this.P.get(index).multipy(m1);
			index++;
		}
	}


	/**
	 * this function will Organ  arrangement of the polynon and sort them in the end
	 */
	public void Organarrangement (){
		Monom_Comperator mc= new Monom_Comperator();
		this.P.sort(mc);
		int index = 0;
		while (index < this.P.size()-1){
			if (this.P.get(index).equals(Monom.ZERO)&& this.P.size()>1) P.remove(index);
			else if (this.P.get(index).get_power()==this.P.get(index+1).get_power()) {
				this.P.get(index).add(this.P.get(index + 1));
				P.remove(index+1);
			}
			else
				index++;
		}

	}

	/**
	 * this method return String that represent the Polynom.
	 * @return
	 */
	public String toString () {
		if(this.P.size()==0) return "0.0";
		int i = 0;
		String ans = "";
		while (i <=this.P.size()-1) {
			if (i!=0 && this.P.get(i).get_coefficient()>0)
				ans+="+";
			ans +=this.P.get(i).toString();
			i++;
		}
		return ans;
	}

	@Override
	public function initFromString(String s) {
		function ans = new Polynom(s);
		return ans;
	}
}



