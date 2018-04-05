package com.liuhaozzu.datastructure.list.polynomial;

public class Term implements Comparable<Term> {
	private static final double PRECISION = 0.000001;
	// coefficient
	private float coef;
	// exponent
	private int expn;
	private Term next;

	public Term(float coef, int expn) {
		super();
		this.coef = coef;
		this.expn = expn;
	}

	public float getCoef() {
		return coef;
	}

	public void setCoef(float coef) {
		this.coef = coef;
	}

	public int getExpn() {
		return expn;
	}

	public void setExpn(int expn) {
		this.expn = expn;
	}

	public Term getNext() {
		return next;
	}

	public void setNext(Term next) {
		this.next = next;
	}

	@Override
	public int compareTo(Term o) {
		if (null == o) {
			throw new NullPointerException();
		}
		return this.getExpn() - o.getExpn();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(coef);
		result = prime * result + expn;
		return result;
	}

	public boolean isSimilarTerms(Term another) {
		if(another==null) {
			return false;
		}else {
			return expn==another.getExpn();
		}	
	}

	@Override
	public String toString() {
		return coef + "*x^" + expn;
	}
}
