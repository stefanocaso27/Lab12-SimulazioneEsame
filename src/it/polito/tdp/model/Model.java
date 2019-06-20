package it.polito.tdp.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;

import it.polito.tdp.db.EventsDao;

public class Model {
	
	private List<Integer> listAnni;
	private EventsDao dao;
	private SimpleWeightedGraph<Distretto, DefaultWeightedEdge> grafo;
	private List<Distretto> listDistretti;
	private List<Coppia> listCoppie;
	
	public Model() {
		this.listAnni = new LinkedList<>();
		this.dao = new EventsDao();
		this.listDistretti = new LinkedList<>();
		this.listCoppie = new LinkedList<>();
	}
	
	public List<Integer> getListaAnni() {
		this.listAnni = dao.getAnni();
		
		return listAnni;
	}
	
	public void creaGrafo(int anno) {
		this.listDistretti = dao.getDistretti(anno);
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(grafo, listDistretti);
		
		double dist = 0;
		
		for(Distretto d1 : grafo.vertexSet()) {
			for(Distretto d2 : grafo.vertexSet()) {
				if(!d1.equals(d2) && !grafo.containsEdge(d1, d2)) {
					grafo.addEdge(d1, d2);

				DefaultWeightedEdge e = grafo.getEdge(d1, d2);
				if(e != null) {
					dist = LatLngTool.distance(d1.getCoord(), d2.getCoord(), LengthUnit.KILOMETER);
					grafo.setEdgeWeight(e, dist);
					}
				}
			}
		
		}
		
		System.out.println("# vertici: " + grafo.vertexSet().size());
		System.out.println("# archi: " + grafo.edgeSet().size());
	}
	
	public String calcolaClassifica() {
		String s = "";
		double dist = 0;
		
		for(Distretto d1 : grafo.vertexSet()) {
			List<Distretto> lista = new LinkedList<>();
			lista = Graphs.neighborListOf(grafo, d1);
			
			List<Coppia> coppie = new LinkedList<Coppia>();
			
			for(Distretto d2 : lista) {
				DefaultWeightedEdge e = grafo.getEdge(d1, d2);
				if(e != null) {
					dist = LatLngTool.distance(d1.getCoord(), d2.getCoord(), LengthUnit.KILOMETER);
					
					Coppia c = new Coppia(d1, d2, dist);
					coppie.add(c);
					}
			}
			
			Collections.sort(coppie);
			this.listCoppie.addAll(coppie);
		}
		
		s = listCoppie.toString();
		return s;
	}
	
}
