package com.jads.vo.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GoogleAPIRequest {

	private List<Parts> contents;

	public GoogleAPIRequest() {}

	public GoogleAPIRequest(String prompt) {
		this.contents = new ArrayList<>();
		this.contents.add(new Parts(prompt));
	}

	public List<Parts> getContents() {
		return contents;
	}

	public void setContents(List<Parts> contents) {
		this.contents = contents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contents);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GoogleAPIRequest other = (GoogleAPIRequest) obj;
		return Objects.equals(contents, other.contents);
	}

}
