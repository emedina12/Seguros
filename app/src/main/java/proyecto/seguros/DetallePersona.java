package proyecto.seguros;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import proyecto.seguros.Class.Persona;
import proyecto.seguros.R;

public class DetallePersona extends AppCompatActivity {
    private TextView txtCedulaDetalle;
    private TextView txtNombresDetalle;
    private TextView txtApellidosDetalle;
    private TextView txtDireccionDetalle;
    private TextView txtTelefonoDetalle;
    private TextView txtEmailDetalle;
    private TextView txtSexoDetalle;
    private String[] sex;
    private ImageView fot;
    private String id,cedula,nombres,apellidos,direccion,telefono,email;
    private int foto,sexo;
    private Intent i;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);
        txtCedulaDetalle = findViewById(R.id.txtCedulaDetalle);
        txtNombresDetalle = findViewById(R.id.txtNombresDetalle);
        txtApellidosDetalle = findViewById(R.id.txtApellidosDetalle);
        txtDireccionDetalle = findViewById(R.id.txtDireccionDetalle);
        txtTelefonoDetalle = findViewById(R.id.txtTelefonoDetalle);
        txtEmailDetalle = findViewById(R.id.txtEmailDetalle);
        txtSexoDetalle = findViewById(R.id.txtSexoDetalle);
        fot = findViewById(R.id.foto);
        sex = getResources().getStringArray(R.array.opciones_sexo);

        i = getIntent();

        bundle = i.getBundleExtra("datos");
        cedula = bundle.getString("cedula");
        nombres = bundle.getString("nombres");
        apellidos = bundle.getString("apellidos");
        direccion = bundle.getString("direccion");
        telefono = bundle.getString("telefono");
        email = bundle.getString("email");
        sexo = bundle.getInt("sexo");
        foto = bundle.getInt("foto");
        id = bundle.getString("id");

        txtCedulaDetalle.setText(cedula);
        txtNombresDetalle.setText(nombres);
        txtApellidosDetalle.setText(apellidos);
        txtDireccionDetalle.setText(direccion);
        txtTelefonoDetalle.setText(telefono);
        txtEmailDetalle.setText(email);
        txtSexoDetalle.setText(sex[sexo]);
        fot.setImageResource(foto);
    }

    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.pregunta_eliminacion));
        positivo = getResources().getString(R.string.positivo);
        negativo = getResources().getString(R.string.negativo);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Persona p = new Persona(id);
                p.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }


    public void onBackPressed() {
        finish();
        Intent i = new Intent(DetallePersona.this,PrincipalPersona.class);
        startActivity(i);
    }

}
