package lv.kp.praktiskais2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button, button2;
    private static final String TAG = "Logging";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button_next_page);
        button.setOnClickListener(view -> openSecondPage());

        button2 = (Button) findViewById(R.id.button_open_dialog);
        button2.setOnClickListener(view -> openDialog());

    }
    public void openSecondPage() {
        Intent intent = new Intent(this,second_page.class);
        startActivity(intent);
    }
    public void openDialog() {
        Log.e(TAG, " openDialog ");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Studenti");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(),"You clicked OK", Toast.LENGTH_LONG).show();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(),"You closed dialog", Toast.LENGTH_LONG).show();
            }
        }).setItems(R.array.members_array, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String student_name = getResources().getStringArray(R.array.members_array)[which];
                Toast.makeText(getApplicationContext(),"Students :" + student_name, Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}