package nyc.c4q.akashaarcher.animalhaus;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            AnimalFragment homeFragment = new AnimalFragment();
            FragmentTransaction mainFragTransaction = getSupportFragmentManager().beginTransaction();
            mainFragTransaction.add(R.id.main_container, homeFragment);
            mainFragTransaction.commit();



        }
   }
}
