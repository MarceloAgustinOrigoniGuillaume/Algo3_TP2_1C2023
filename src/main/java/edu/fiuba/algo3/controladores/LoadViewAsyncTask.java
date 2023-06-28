package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Logger;
import edu.fiuba.algo3.Resources;

import javafx.concurrent.Task;
import javafx.scene.Parent;
import java.lang.Thread;
import javafx.scene.Scene;


public class LoadViewAsyncTask extends Task<Parent>{
	public interface ControladorFactory{
		Controlador instanciar() throws Exception;
	}

	private ControladorFactory instanciarControlador;
	private String vista;
	public LoadViewAsyncTask(String vista,ControladorFactory instanciador) {
		this.vista = vista;
		instanciarControlador = instanciador;
	}

	public Parent call() throws Exception{
		return Resources.getVista(vista, instanciarControlador.instanciar());
	}


	public void startLoading(){
		Thread viewLoader = new Thread(this);
		viewLoader.setDaemon(true);
		viewLoader.start();

	}

	public void loadOn(Scene scene){
		setOnSucceeded(e -> {
			scene.setRoot(getValue());
		});

		setOnFailed(e->{
			Logger.err("At load "+vista, getException());
			getException().printStackTrace();
		});

		startLoading();
	}
}
