package com.eng2tech.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPK {
	
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game idGame;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria idCategoria;	
	
	public BelongingPK() {
	}
	
	public BelongingPK(Game idGame, Categoria idCategoria) {
		this.idGame = idGame;
		this.idCategoria = idCategoria;
	}
	
	public Game getIdGame() {
		return idGame;
	}
	public void setIdGame(Game idGame) {
		this.idGame = idGame;
	}
	public Categoria getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategoria, idGame);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(idCategoria, other.idCategoria) && Objects.equals(idGame, other.idGame);
	}
}