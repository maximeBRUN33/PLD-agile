package application;

import java.util.HashMap;
import java.util.List;

import Modele.Intersection;
import Modele.Segment;
import Modele.Warehouse;

public class map {
	private Warehouse warehouse;
	private HashMap<String, Intersection> intersections;
	private List<Segment> segments;

	public map() {
	}

	public map(Warehouse warehouse, HashMap<String, Intersection> intersections, List<Segment> segments) {
		super();
		this.warehouse = warehouse;
		this.intersections = intersections;
		this.segments = segments;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public HashMap<String, Intersection> getIntersections() {
		return intersections;
	}

	public void setIntersections(HashMap<String, Intersection> intersections) {
		this.intersections = intersections;
	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	@Override
	public String toString() {
		return "map [warehouse=" + warehouse + ", intersections=" + intersections + ", segments=" + segments + "]";
	}
}
