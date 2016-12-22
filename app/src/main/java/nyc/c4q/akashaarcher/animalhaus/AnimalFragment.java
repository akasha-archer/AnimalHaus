package nyc.c4q.akashaarcher.animalhaus;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.akashaarcher.animalhaus.backend.AnimalApi;
import nyc.c4q.akashaarcher.animalhaus.backend.AnimalResponse;
import nyc.c4q.akashaarcher.animalhaus.model.Animal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by akashaarcher on 12/21/16.
 */

public class AnimalFragment extends Fragment {

    private static final String TAG = "AnimalFragment";
    public static final String BASE_URL = "http://jsjrobotics.nyc/";


    private List<Animal> animalList;
    private AnimalAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isOnline()) {
            Toast.makeText(getActivity(), "You are connected to the internet", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "You are not connected to the internet", Toast.LENGTH_SHORT).show();
        }

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_animal, container, false);

        animalList = new ArrayList<>();

        adapter = new AnimalAdapter(getContext());
        RecyclerView postRecyclerView = (RecyclerView) view.findViewById(R.id.animal_rv);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        postRecyclerView.setAdapter(adapter);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimalApi api = retrofit.create(AnimalApi.class);

        Call<AnimalResponse> houseCall = api.listAnimals();
        houseCall.enqueue(new Callback<AnimalResponse>() {
            @Override
            public void onResponse(Call<AnimalResponse> call, Response<AnimalResponse> response) {
                AnimalResponse animalResp = response.body();
                animalList = animalResp.getAnimals();
                adapter.setPosts(animalList);
                Log.i("LIST:", animalList.size() + "");
                Log.d(TAG, "There was a success" + response);
            }

            @Override
            public void onFailure(Call<AnimalResponse> call, Throwable t) {
                Log.d(TAG, "There was a failure" + t);
            }
        });
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)
                getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }


}
