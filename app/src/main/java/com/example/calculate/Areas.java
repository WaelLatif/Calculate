package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Areas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);


        Spinner sp_shapes = findViewById(R.id.areas_sp_shapes);
        EditText et_rectangle_width = findViewById(R.id.areas_et_rectangle_width);
        EditText et_rectangle_height = findViewById(R.id.areas_et_rectangle_height);
        EditText et_circle_radius = findViewById(R.id.areas_et_circle_radius);
        EditText et_triangle_base = findViewById(R.id.areas_et_triangle_base);
        EditText et_triangle_height = findViewById(R.id.areas_et_triangle_height);
        TextView tv_result = findViewById(R.id.areas_tv_result);
        Button btn_calculate = findViewById(R.id.areas_btn_calculate);

        //Circle -> pi * r * r
        //Rectangle -> w * h
        //triangle -> 0.5 * base * h

        sp_shapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;
                    case 1:
                        et_rectangle_height.setVisibility(View.VISIBLE);
                        et_rectangle_width.setVisibility(View.VISIBLE);
                        et_circle_radius.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;

                    case 2:
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.VISIBLE);
                        et_triangle_base.setVisibility(View.GONE);
                        et_triangle_height.setVisibility(View.GONE);
                        break;

                    case 3:
                        et_rectangle_height.setVisibility(View.GONE);
                        et_rectangle_width.setVisibility(View.GONE);
                        et_circle_radius.setVisibility(View.GONE);
                        et_triangle_base.setVisibility(View.VISIBLE);
                        et_triangle_height.setVisibility(View.VISIBLE);
                        break;
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = sp_shapes.getSelectedItemPosition();
                double area = 0;
                switch (index) {
                    case 1:
                        double rect_width = Double.parseDouble(et_rectangle_width.getText().toString());
                        double rect_height = Double.parseDouble(et_rectangle_height.getText().toString());
                        area = rect_height * rect_width;
                        break;
                    case 2:
                        double cir_radius = Double.parseDouble(et_circle_radius.getText().toString());

                        area = Math.PI * Math.pow(cir_radius, 2);
                        break;

                    case 3:
                        double tri_base= Double.parseDouble(et_triangle_base.getText().toString());
                        double tri_height = Double.parseDouble(et_triangle_height.getText().toString());
                        area = 0.5 * tri_base * tri_height;
                        break;
                }
                tv_result.setText(area+"");
            }
        });

    }
}