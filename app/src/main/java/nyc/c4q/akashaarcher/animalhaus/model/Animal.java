package nyc.c4q.akashaarcher.animalhaus.model;

/**
 * Created by akashaarcher on 12/21/16.
 */

public class Animal {

    private String name;
    private String textColor;
    private String background;


    public Animal(String name, String textColor, String background) {
        this.name = name;
        this.textColor = textColor;
        this.background = background;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
