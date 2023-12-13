package com.kpzip.circuitsapi.circuitsim;

import java.util.Objects;

public class NodePair {

	public final Circuit.Node first;
	public final Circuit.Node second;
	
	public NodePair(Circuit.Node first, Circuit.Node second) {
		if (first.compareTo(second) > 0) {
			this.first = first;
			this.second = second;
		}
		else {
			this.first = second;
			this.second = first;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodePair other = (NodePair) obj;
		return Objects.equals(first, other.first) && Objects.equals(second, other.second);
	}
	
	

}
