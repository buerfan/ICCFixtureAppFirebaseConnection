package com.example.jakirapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference myRef;

    EditText ID,countryName,numberOfMatch,numberOfWin,numberOfLoss,NRR,Pts;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
        myRef= FirebaseDatabase.getInstance().getReference("standings");

        btnSubmit=findViewById(R.id.btnSubmit);

        ID=findViewById(R.id.edtID);
        countryName=findViewById(R.id.edtCountryName);
        numberOfMatch=findViewById(R.id.edtMatch);
        numberOfWin=findViewById(R.id.edtWin);
        numberOfLoss=findViewById(R.id.edtLoss);
        NRR=findViewById(R.id.edtNRR);
        Pts=findViewById(R.id.edtPts);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Toast toast=Toast.makeText(getApplicationContext(),"This is",Toast.LENGTH_LONG);
                //toast.show();



                addData();
            }
        });

    }

    private void addData() {

        String strID,strcountryName,strnumberOfMatch,strnumberOfWin,strnumberOfLoss,strNRR,strPts;
        strID=ID.getText().toString().trim();
        strcountryName=countryName.getText().toString().trim();
        strnumberOfMatch=numberOfMatch.getText().toString().trim();
        strnumberOfWin=numberOfWin.getText().toString().trim();
        strnumberOfLoss=numberOfLoss.getText().toString().trim();
        strNRR=NRR.getText().toString().trim();
        strPts=Pts.getText().toString().trim();


        if(!TextUtils.isEmpty(strcountryName))
        {

            DataObject dataObject=new DataObject(strID,strcountryName,strnumberOfMatch,strnumberOfWin,strnumberOfLoss,strNRR,strPts);

            myRef.child(strcountryName).setValue(dataObject);
            Toast.makeText(this,"Data added Successfully...",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast toast=Toast.makeText(getApplicationContext(),"Country Name Empty...",Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
