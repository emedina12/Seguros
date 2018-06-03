package proyecto.seguros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class CrearPersona extends AppCompatActivity {
    private EditText txtRam;
    private Spinner SpinnerMarca;
    private Spinner SpinnerColor;
    private Spinner SpinnerTipo;
    private Spinner SpinnerSistemaOperativo;
    private String[] opcionmarca, opcioncolor, opciontipo, opcionsistemaoperativo;
    private ArrayAdapter<String> AdapterMarca, AdapterColor, AdapterTipo, AdapterSistemaOperativo;
    private ArrayList<Integer> fotos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_persona);
    }
}
