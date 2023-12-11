package com.kpzip.circuitsapi.circuitsim;

import java.util.Objects;

import com.kpzip.circuitsapi.circuitsim.Circuit.Node;

public class NodePair {

	public Node first;
	public Node second;
	
	public NodePair(Node first, Node second) {
		this.first = first;
		this.second = second;
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
