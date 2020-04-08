package com.example.a17it078_wcmc.Fragment.p10;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.a17it078_wcmc.Core.Feature;
import com.example.a17it078_wcmc.R;

public class p10 extends Fragment {

    DatabaseHelper mydb;
    EditText name,surname,marks,id;
    Button addData,viewData,update,delete;
    boolean isInserted,isUpdate;
    Integer deletedRows;

    public p10() {
        // Required empty public constructor
    }

    public static p10 newInstance(String param1, String param2) {
        p10 fragment = new p10();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View header =  inflater.inflate(R.layout.fragment_p10, container, false);

        mydb = new DatabaseHelper(getContext());

        name = header.findViewById(R.id.p10_name);
        surname = header.findViewById(R.id.p10_surname);
        marks = header.findViewById(R.id.p10_marks);
        id = header.findViewById(R.id.p10_id);
        addData = header.findViewById(R.id.p10_add_data);
        viewData = header.findViewById(R.id.p10_view_data);
        update = header.findViewById(R.id.p10_update);
        delete = header.findViewById(R.id.p10_delete);

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isInserted = mydb.insertData(name.getText().toString(),surname.getText().toString(),marks.getText().toString());
                if (isInserted == true){
                    Feature.Toast(getContext(),"Data Inserted");
                }else {
                    Feature.Toast(getContext(),"Data not Inserted");
                }
            }
        });

        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = mydb.getAllData();
                if (res.getCount() == 0){
                    showMessage("Error","Nothing Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("ID :"+res.getString(0)+"\n");
                    buffer.append("NAME :"+res.getString(1)+"\n");
                    buffer.append("SURNAME :"+res.getString(2)+"\n");
                    buffer.append("MARKS :"+res.getString(3)+"\n\n");
                }
                showMessage("Data",buffer.toString());
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isUpdate = mydb.updateData(id.getText().toString(),name.getText().toString(),surname.getText().toString(),marks.getText().toString());

                if (isUpdate == true){
                    Feature.Toast(getContext(),"Data Updated");
                }else {
                    Feature.Toast(getContext(),"Data not Updated");
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletedRows = mydb.deleteData(id.getText().toString());
                if (deletedRows > 0){
                    Feature.Toast(getContext(),"Data Deleted");
                }else {
                    Feature.Toast(getContext(), "Data not Deleted");
                }
            }
        });

        return header;
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
