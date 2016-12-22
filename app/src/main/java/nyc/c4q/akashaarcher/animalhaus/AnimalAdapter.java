package nyc.c4q.akashaarcher.animalhaus;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.akashaarcher.animalhaus.model.Animal;

/**
 * Created by akashaarcher on 12/21/16.
 */

public class AnimalAdapter extends RecyclerView.Adapter {


    Context context;
    private List<Animal> animals;

    public AnimalAdapter(Context context) {
        this.context = context;
        this.animals = new ArrayList<>();
    }


    public void setPosts(List<Animal> animals) {
        this.animals = animals;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnimalViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AnimalViewHolder postViewHolder = (AnimalViewHolder) holder;
        Animal animalList = animals.get(position);
        postViewHolder.bind(animalList);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }
}
