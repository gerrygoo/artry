package delag.ar;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Place[] places = {new Place(19.493815, -99.251522, "Casa"), new Place(19.494700, -99.250711, "Parque")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //start location service
        Intent intent = new Intent(MainActivity.this, LocationService.class);
        intent.putExtra("places", places);
        startService(intent);

//        startService(new Intent(this, LocationService.class));
        LinearLayout layout = (LinearLayout) findViewById(R.id.list_layout);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        for(int i=0; i<places.length; i++){
            final Place place = places[i];
            Button button = new Button(this);
            button.setLayoutParams(params);
            button.setText(place.getName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&destination="
                            +place.getLatitude()+","+place.getLongitude());
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    startActivity(mapIntent);
                }
            });
            layout.addView(button, i+1);
        }
    }
}
