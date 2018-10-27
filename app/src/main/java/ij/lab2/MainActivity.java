package ij.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    // another joke on click
    public void buttonClicked(View v) {
        Ion.with(this)
                .load("http://api.icndb.com/jokes/random")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        TextView txtJoke = findViewById(R.id.txtJoke);

                        String joke = result.get("value").getAsJsonObject().get("joke").getAsString();

                        txtJoke.setText(joke);


                    }
                });
    }
}
