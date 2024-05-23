package com.example.cocobolt;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity implements Serializable {

    public class Producto implements Serializable{
        private String nombre;
        private int precio;

        public Producto (String nombre, int precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
        public String getNombre() {
            return nombre;
        }

        public int getPrecio() {
            return precio;
        }
        // getters y setters
    }
    private List<Integer> cantidad = new ArrayList<>();
    private List<Producto> carrito = new ArrayList<>();
    private Button agregarcarro1;
    private Button agregarcarro2;
    private Button agregarcarro3;
    private Button agregarcarro4;
    private Button agregarcarro5;
    private Button agregarcarro6;
    private Button agregarcarro7;
    private Button agregarcarro8;
    private Button vercarrito;
    private DatabaseReference databaseReference;
    private DatabaseReference mDatabase;
    private int total = 0;
    public static int boleta = 0;
    private int ptotal = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);
        //iniciar conexion  //CONECTAR DB
        FirebaseApp.initializeApp(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //INICIALIZAR CONTADOR CANTIDAD X PRODUCTO
        for (int i = 0; i < 8; i++) {
            cantidad.add(0);
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView valortotal = findViewById(R.id.valortotal);
        valortotal.setText("$"+total);
        //INICIALIZAMOS NOMBRES
        TextView nombre1 = findViewById(R.id.nombre1);
        TextView nombre2 = findViewById(R.id.nombre2);
        TextView nombre3 = findViewById(R.id.nombre3);
        TextView nombre4 = findViewById(R.id.nombre4);
        TextView nombre5 = findViewById(R.id.nombre5);
        TextView nombre6 = findViewById(R.id.nombre6);
        TextView nombre7 = findViewById(R.id.nombre7);
        TextView nombre8 = findViewById(R.id.nombre8);


        //VER CARRITO
        vercarrito = findViewById(R.id.BTcarrito);
        vercarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(carrito);
                mDatabase.push().setValue(carrito);
                boleta = total;
                Intent intent1 = new Intent(MainMenu.this, MainActivity2.class);
                cantidad.clear();
                carrito.clear();
                total = 0;
                Toast.makeText(MainMenu.this, "Pedido pagado correctamente", Toast.LENGTH_SHORT).show();
                startActivity(intent1);

            }
        });

        //AGREGAR AL CARRO TODAS LAS OPCIOENS
        agregarcarro1 = findViewById(R.id.agregarcarro1);
        agregarcarro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto nachibowl = new Producto("NachiBowl", 4500);
                carrito.add(nachibowl);
                cantidad.set(0,cantidad.get(0)+1);
                nombre1.setText("NachiBowl | Cantidad: "+cantidad.get(0));
                total = total + 4500;
                valortotal.setText("$"+total);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro2 = findViewById(R.id.agregarcarro2);
        agregarcarro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto cocobowl = new Producto("Cocobowl", 5500);
                carrito.add(cocobowl);
                cantidad.set(1,cantidad.get(1)+1);
                nombre2.setText("CocoBowl | Cantidad: "+cantidad.get(1));
                total = total + 5500;
                valortotal.setText("$"+total);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro3 = findViewById(R.id.agregarcarro3);
        agregarcarro3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto panchobowl = new Producto("PanchoBowl", 4000);
                carrito.add(panchobowl);
                cantidad.set(2,cantidad.get(2)+1);
                nombre3.setText("PanchoBowl | Cantidad: "+cantidad.get(2));
                total = total + 4000;
                valortotal.setText("$"+total);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro4 = findViewById(R.id.agregarcarro4);
        agregarcarro4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto fabibowl = new Producto("FabiBowl", 3500);
                carrito.add(fabibowl);
                cantidad.set(3,cantidad.get(3)+1);
                nombre4.setText("FabiBowl | Cantidad: "+cantidad.get(3));
                total = total + 3500;
                valortotal.setText("$"+total);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro5 = findViewById(R.id.agregarcarro5);
        agregarcarro5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto vegan = new Producto("Vegan Bowl", 2500);
                carrito.add(vegan);
                cantidad.set(4,cantidad.get(4)+1);
                nombre5.setText("Vegan | Cantidad: "+cantidad.get(4));
                total = total + 2500;
                valortotal.setText("$"+total);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro6 = findViewById(R.id.agregarcarro6);
        agregarcarro6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto fajita_vegan = new Producto("Fajita Vegan", 3500);
                carrito.add(fajita_vegan);
                cantidad.set(5,cantidad.get(5)+1);
                nombre6.setText("Fajita Vegan | Cantidad: "+cantidad.get(5));
                total = total + 3500;
                valortotal.setText("$"+total);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro7 = findViewById(R.id.agregarcarro7);
        agregarcarro7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto fajita_especial = new Producto("Fajita Especial", 2500);
                carrito.add(fajita_especial);
                cantidad.set(6,cantidad.get(6)+1);
                nombre7.setText("Fajita Especial | Cantidad: "+cantidad.get(6));
                total = total + 2500;
                valortotal.setText("$"+total);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro8 = findViewById(R.id.agregarcarro8);
        agregarcarro8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto Fajita_normal = new Producto("Fajita Normal", 2500);
                carrito.add(Fajita_normal);
                cantidad.set(7,cantidad.get(7)+1);
                nombre8.setText("Fajita Normal | Cantidad: "+cantidad.get(7));
                total = total + 2500;
                valortotal.setText("$"+total);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
    }
}