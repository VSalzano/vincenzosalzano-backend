package com.gestioneincendi.models;

import java.util.Observable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@SuppressWarnings("deprecation")
public class Sonda extends Observable {
	
	private long id;
	private String latitudine;
	private String longitudine;
	private Integer intFumo;
	
	public void setIntFumo(Integer intFumo) {
		this.intFumo = intFumo;
		setChanged();
		notifyObservers(this);
		
	}
	

}
