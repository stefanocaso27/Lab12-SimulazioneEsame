package it.polito.tdp.model;

public class Coppia implements Comparable <Coppia> {
	
	private Distretto d1;
	private Distretto d2;
	private double distanza;
	
	public Coppia(Distretto d1, Distretto d2, double distanza) {
		super();
		this.d1 = d1;
		this.d2 = d2;
		this.distanza = distanza;
	}
	
	public Distretto getD1() {
		return d1;
	}
	public void setD1(Distretto d1) {
		this.d1 = d1;
	}
	public Distretto getD2() {
		return d2;
	}
	public void setD2(Distretto d2) {
		this.d2 = d2;
	}
	public double getDistanza() {
		return distanza;
	}
	public void setDistanza(double distanza) {
		this.distanza = distanza;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d1 == null) ? 0 : d1.hashCode());
		result = prime * result + ((d2 == null) ? 0 : d2.hashCode());
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
		Coppia other = (Coppia) obj;
		if (d1 == null) {
			if (other.d1 != null)
				return false;
		} else if (!d1.equals(other.d1))
			return false;
		if (d2 == null) {
			if (other.d2 != null)
				return false;
		} else if (!d2.equals(other.d2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Coppia [d1=%s, d2=%s, distanza=%s]\n", d1.getId(), d2.getId(), distanza);
	}

	@Override
	public int compareTo(Coppia c) {
		if(this.distanza > c.getDistanza())
			return 1;
		else
			return -1;
	}
	

}
