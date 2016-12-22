package nyc.c4q.akashaarcher.animalhaus.backend;

import java.util.List;

import nyc.c4q.akashaarcher.animalhaus.model.Animal;

/**
 * Created by akashaarcher on 12/21/16.
 */

public class AnimalResponse {

    private boolean success;
    List<Animal> animals;


    public List<Animal> getAnimals(){
        return animals;
    }

}
