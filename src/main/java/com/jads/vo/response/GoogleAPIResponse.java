package com.jads.vo.response;

import java.util.List;

public class GoogleAPIResponse {
	
	private List<Candidate> candidates;

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

}
