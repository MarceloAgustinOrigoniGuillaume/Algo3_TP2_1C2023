package edu.fiuba.algo3.vistas.celda;


import javafx.scene.image.ImageView;
import edu.fiuba.algo3.Resources;
import edu.fiuba.algo3.Logger;

public class DefensaCeldaView extends ImageView{

	public DefensaCeldaView(){
		super();
		setVisible(false);
	}

	public void updateDefensa(String url_imagen, int width, int height){
		if(url_imagen == ""){
			setVisible(false);
			return;
		}
		//Logger.info("UPDATING IMG _________"+url_imagen);
		setVisible(true);
		setImage(Resources.getImg(url_imagen, width, height));
	}
}