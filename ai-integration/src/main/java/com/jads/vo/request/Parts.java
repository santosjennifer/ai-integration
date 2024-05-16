package com.jads.vo.request;

import java.util.ArrayList;
import java.util.List;

public class Parts {
	
	private List<Text> parts;
	
	public Parts() {}

	public Parts(String prompt) {
		this.parts = new ArrayList<>();
        this.parts.add(new Text(prompt));
	}

	public List<Text> getParts() {
		return parts;
	}

	public void setParts(List<Text> parts) {
		this.parts = parts;
	}

}
