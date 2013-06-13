/**
 * Graphic base class extending from GameElement and is derived by Backdrop and Prop
 */
package gamePlayEngine.model.gameElement.graphic;

import gamePlayEngine.model.gameElement.GameElement;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@XmlSeeAlso({ Backdrop.class, Prop.class })
@XmlTransient
public class Graphic extends GameElement {
	
}
