package it.polito.tdp.model;

import com.javadocmd.simplelatlng.LatLng;

public class Distretto {
	
	private Integer id;
	private LatLng coord;
	
	public Distretto(Integer id, double lat, double lon) {
		super();
		this.id = id;
		this.coord = new LatLng(lat, lon);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LatLng getCoord() {
		return coord;
	}
	public void setCoord(LatLng coord) {
		this.coord = coord;
	}

	@Override
	public String toString() {
		return String.format("Distretto [id=%s, coord=%s]", id, coord);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distretto other = (Distretto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
