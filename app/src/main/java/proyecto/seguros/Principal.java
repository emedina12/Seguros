package proyecto.seguros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import proyecto.seguros.Class.Persona;
import proyecto.seguros.Class.Poliza;

public class Principal extends AppCompatActivity {
    private ListView Listview_Principal;
    private String[] opciones_Principal;
    private Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Listview_Principal = findViewById(R.id.ListViewPrincipal);
        opciones_Principal =getResources().getStringArray(R.array.opciones_Principal);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opciones_Principal);

        Listview_Principal.setAdapter(adapter);
        Listview_Principal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                switch (i){
                    case 0:
                        in = new Intent(Principal.this,PrincipalPersona.class);
                        startActivity(in);
                        break;

                    case 1:
                        in = new Intent(Principal.this,PrincipalPoliza.class);
                        startActivity(in);
                        break;

                    case 2:
                        in = new Intent(Principal.this,Reportes.class);
                        startActivity(in);
                        break;
                }
            }
        });

    }
    }

