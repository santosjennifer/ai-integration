package com.jads.vo.request;

import java.util.ArrayList;
import java.util.List;

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

}
