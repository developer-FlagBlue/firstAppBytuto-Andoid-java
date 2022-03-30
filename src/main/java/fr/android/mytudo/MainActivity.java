package fr.android.mytudo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//EditText donne
        EditText editText = findViewById(R.id.editeTextAmout);
//Button donne
        Button button1 = findViewById(R.id.bntCompute);
//TextView donne
        TextView textView2 = findViewById(R.id.textView2);
//ListView donne
        ListView listView = findViewById(R.id.listViewResult);
//List<String> data
        List<String> data = new ArrayList<>();
// ArrayAdapter
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, data);
//setAdapter
        listView.setAdapter(stringArrayAdapter);



//utilisation action **** click
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//instruction à execute déclonchement
                double amount = Double.parseDouble(editText.getText().toString());
                double result = amount * 5;
//afficher result --> textView2
                textView2.setText(String.valueOf(result));
//changement de data adapter
                data.add(amount + "=>" + result);
                stringArrayAdapter.notifyDataSetChanged();
                editText.setText("");


            }
        });
    }
}