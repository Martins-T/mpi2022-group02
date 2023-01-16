package lv.kp.praktiskais2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class second_page extends AppCompatActivity {
    Button back_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        back_button = (Button) findViewById(R.id.back);
        back_button.setOnClickListener(view -> goBack());
    }

    public void goBack() {
        this.finish();
    }


}