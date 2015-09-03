package com.cadu.trabalhofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.CitationProvider;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CitationProvider citacoes = new CitationProvider();

    EditText getEdtAutor;
    EditText getEdtCitacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (BuildConfig.FLAVOR == "free") {
            AdView mAdView = (AdView) findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);

        }

        Log.d("flavor", BuildConfig.FLAVOR);





        Button getCitacao = (Button) findViewById(R.id.btnGetCitacao);
        Button InsertCitacao = (Button) findViewById(R.id.btnInsertCitacao);

        getEdtAutor = (EditText) findViewById(R.id.edtAutor);
        getEdtCitacao = (EditText) findViewById(R.id.edtCitacao);

        getCitacao.setOnClickListener(this);
        InsertCitacao.setOnClickListener(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGetCitacao:
                String testCitation = citacoes.GetCitation();
                Bundle dataBundle = new Bundle();
                dataBundle.putString("citation", testCitation);

                Intent intent = new Intent(getApplicationContext(),ShowCitationActivity.class);
                intent.putExtras(dataBundle);

                startActivity(intent);

                break;
            case R.id.btnInsertCitacao:
                if (getEdtAutor.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Autor deve ser Informado", Toast.LENGTH_SHORT).show();
                }   else {
                    if (getEdtCitacao.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Citacao deve ser Informada", Toast.LENGTH_SHORT).show();
                    } else {
                        citacoes.AddCitation((getEdtAutor.getText().toString()), (getEdtCitacao.getText().toString()));
                        Toast.makeText(getApplicationContext(), "Adicionado", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }


        }
    }
}
