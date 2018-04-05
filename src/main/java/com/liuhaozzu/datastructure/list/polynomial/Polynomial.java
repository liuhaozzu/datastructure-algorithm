package com.liuhaozzu.datastructure.list.polynomial;

public class Polynomial {

	private static final double PRECISION = 0.000001;
	private Term head = new Term(0, 0);
	private int length = 0;

	public Polynomial(Term head) {
		this.head = head;
	}

	public Polynomial(float coef, int expn) {
		if (head.getNext() == null) {
			head.setNext(new Term(coef, expn));
		}
		length++;
	}

	public Polynomial addTerm(Term newTerm) {
		Term term = locateElem(newTerm);
		if(term.isSimilarTerms(newTerm)) {
			float sum = term.getCoef()+ newTerm.getCoef();
			if(sum <-PRECISION || sum <PRECISION) {
				Term next = term.getNext();
				if(next!=null) {
					term.setNext(next.getNext());
				}
			}else {
				term.setCoef(sum);
			}
		}else {
			newTerm.setNext(term.getNext());
			term.setNext(newTerm);
		}
		return this;
	}

	/**
	 * 
	 * @param term
	 * @return if there is an element in the Polynomial satisfied the condition that
	 *         <code>compare() == 0</code>,<br/>
	 *         return the first position of the satisfied element; or return the
	 *         previous element of the first <code>compare()>0</code>
	 */
	public int locateElemPosition(Term term) {
		Term current = head.getNext();
		int position = 0;
		while (current != null) {

			int comp = current.compareTo(term);
			if (comp == 0) {
				return ++position;
			} else if (comp < 0) {
				current = current.getNext();
			}
			if (comp > 0) {
				return position;
			}
		}
		return position;
	}

	/**
	 * 
	 * @param term
	 * @return if there is an element in the Polynomial satisfied the condition that
	 *         <code>compare() == 0</code>,<br/>
	 *         return the first position of the satisfied element; or return the
	 *         previous element of the first <code>compare()>0</code>
	 */
	public Term locateElem(Term term) {
		Term current = head.getNext();
		Term previous = head;
		while (current != null) {
			int comp = current.compareTo(term);
			if (comp == 0) {
				return current;
			} else if (comp < 0) {
				previous = current;
				current = current.getNext();
			}
			if (comp > 0) {
				return previous;
			}
		}
		return previous;
	}

	public void printPolyn() {
		StringBuilder builder = new StringBuilder();
		Term current = head.getNext();
		while (current != null) {
			builder.append(current.toString() + " + ");
			current=current.getNext();
		}
		String result = builder.substring(0, builder.length() - 3);
		System.out.println(result);
	}

	public int length() {
		return length;
	}

	public Polynomial addPolyn(Polynomial another) {
		if (this.head.getNext() == null) {
			return another;
		}
		if (another == null || another.head.getNext() == null) {
			return this;
		}
		Term pointer1 = this.head.getNext();
		Term pointer2 = another.head.getNext();
		Term tempHead = new Term(0f, 0);
		Term tempCurrent = tempHead;
		while (pointer1.getNext() != null && pointer2.getNext() != null) {
			int comp = pointer1.compareTo(pointer2);
			if (comp == 0) {
				float sum = pointer1.getCoef() + pointer2.getCoef();
				if (sum != 0) {
					pointer1.setCoef(sum);
					tempCurrent.setNext(pointer1);
					tempCurrent = pointer1;
				} else {
					pointer1.setNext(pointer1.getNext().getNext());
					pointer2.setNext(pointer2.getNext().getNext());
					// release node
					pointer1.getNext().setNext(null);
					pointer2.getNext().setNext(null);
					// point to next element
					pointer1 = pointer1.getNext();
					pointer2 = pointer2.getNext();
				}
			} else if (comp < 0) {
				tempCurrent.setNext(pointer1);
				tempCurrent = pointer1;
				pointer1 = pointer1.getNext();
			} else if (comp > 0) {
				tempCurrent.setNext(pointer2);
				tempCurrent = pointer2;
				pointer2 = pointer2.getNext();
			}
		}
		return new Polynomial(tempHead);
	}

	public Polynomial substractPolyn(Polynomial another) {
		return another;

	}

	public Polynomial multiplyPolyn(Polynomial another) {
		// TODO:
		throw new UnsupportedOperationException(
				"still not supported, if you are interested please help to implement it");
	}
}
