package com.jads.vo.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(parts);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parts other = (Parts) obj;
		return Objects.equals(parts, other.parts);
	}

}
