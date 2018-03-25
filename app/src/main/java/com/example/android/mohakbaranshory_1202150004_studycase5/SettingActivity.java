package com.example.android.mohakbaranshory_1202150004_studycase5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingActivity extends AppCompatActivity {
    ListView listView;
    CardView cardView;
    String valcolor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        listView = findViewById(R.id.listView);

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.saved_high_score), "sa");
        editor.commit();

                cardView = (CardView) findViewById(R.id.card_view);
        valcolor = "Red";
        String[] strings = {"Shape Color\n"+valcolor};
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, strings));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, int i, long l) {
                final AlertDialog.Builder dialog = new AlertDialog.Builder(SettingActivity.this);
                dialog.setTitle("Shape Color"); //Mengatur Judul
                //Mengubah Layout XML menjadi Kodingan
                final View dialogView = getLayoutInflater().inflate(R.layout.radiobutton_color,null);
                //Mengambil RadioGroup dari Layout XML
                final RadioGroup rg =(RadioGroup)dialogView.findViewById(R.id.rgShapeColor);
                //Melakukan Check Default
                //Inflat R.layout.fragment_shapecolor
                dialog.setView(dialogView);

                dialog.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Mengambil nilai yang di cek/pilih

                        TodoList todoList = new TodoList(1);
                        switch(rg.getCheckedRadioButtonId()){
                            //Melakuakan Pengambilan nilai
                            // optionShapeColor untuk ID RadioButton
                            // shapeColor untuk Kode Warna
                            case R.id.rShapeColorRed: todoList.color = Color.RED; valcolor = "Red"; break;
                            case R.id.rShapeColorBlue: todoList.color = Color.BLUE; valcolor = "Blue"; break;
                            case R.id.rShapeColorGreen: todoList.color = Color.GREEN; valcolor = "Green"; break;
                        }
                        listView.invalidateViews();
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                dialog.show();


            }
        });
        /*switch (valColor){
            case "Red":
                cardView.setCardBackgroundColor(Color.RED);
                break;
            case "Blue":
                cardView.setCardBackgroundColor(Color.BLUE);
                break;
            case "Green":
                cardView.setCardBackgroundColor(Color.GREEN);
                break;
        }
        */

    }
}
