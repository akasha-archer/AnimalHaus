package nyc.c4q.akashaarcher.animalhaus;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.akashaarcher.animalhaus.model.Animal;

/**
 * Created by akashaarcher on 12/21/16.
 */


public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private final View view;
    private TextView tvName;
    private Context context;


    public AnimalViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        view = itemView;
        tvName = (TextView) view.findViewById(R.id.tv_name);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.animal_item_layout, parent, false);
    }


    public void bind(final Animal animal) {
        tvName.setText(animal.getName());
        tvName.setTextColor(Color.parseColor(animal.getTextColor()));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               view.setBackgroundColor(Color.parseColor(animal.getBackground()));
            }
        });
    }


}
