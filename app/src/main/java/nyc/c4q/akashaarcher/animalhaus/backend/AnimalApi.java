package nyc.c4q.akashaarcher.animalhaus.backend;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by akashaarcher on 12/21/16.
 */

public interface AnimalApi {

    @GET("cgi-bin/12_21_2016_exam.pl")
    Call<AnimalResponse> listAnimals();
}
