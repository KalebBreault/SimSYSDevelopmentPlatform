/**
 * Specialized class from Graphic presenting a Prop Model
 */
package gamePlayEngine.model.gameElement.graphic;

//@XmlSeeAlso({Button.class, Label.class})
public class Prop<T> extends Graphic {
	private Location location;
	private Color color;
	private String text;
	private String behavior;
	private String typeName;
	
	/* Templated type on unmarshalling from XML is lost. Once this issue is fixed following can be used */
	//private T type;

	public String getBehavior() {
		return behavior;
	}

	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}	

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
