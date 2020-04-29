package com.hsbg.test;

public class SomethingDoer {
	//my team doesn't own this. We need to mock it.
	private ForeignClass foreign;
	
	public SomethingDoer(ForeignClass foreign) {
		super();
		this.foreign = foreign;
	}

	public String print(String str) {
		System.out.println(str);
		return str + foreign.getId();
	}
	
	public int add(int i, int j) {
		System.out.println(i+j);
		return i+j;
	}
}
