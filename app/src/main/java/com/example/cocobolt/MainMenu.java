package com.example.cocobolt;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public class Producto {
        private String nombre;
        private int precio;

        public Producto(String nombre, int precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        // getters y setters
    }
    private List<Producto> carrito = new ArrayList<>();
    private Button agregarcarro1;
    private Button agregarcarro2;
    private Button agregarcarro3;
    private Button agregarcarro4;
    private Button agregarcarro5;
    private Button agregarcarro6;
    private Button agregarcarro7;
    private Button agregarcarro8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_menu);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button vercarrito = findViewById(R.id.BTcarrito);
        vercarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, MainCarrito.class);
                startActivity(intent);
            }
        });



        //AGREGAR AL CARRO TODAS LAS OPCIOENS
        agregarcarro1 = findViewById(R.id.agregarcarro1);
        agregarcarro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto nachibowl = new Producto("NachiBowl", 4500);
                carrito.add(nachibowl);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro2 = findViewById(R.id.agregarcarro2);
        agregarcarro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto cocobowl = new Producto("Cocobowl", 5500);
                carrito.add(cocobowl);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro3 = findViewById(R.id.agregarcarro3);
        agregarcarro3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto panchobowl = new Producto("PanchoBowl", 4000);
                carrito.add(panchobowl);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro4 = findViewById(R.id.agregarcarro4);
        agregarcarro4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto fabibowl = new Producto("FabiBowl", 3500);
                carrito.add(fabibowl);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro5 = findViewById(R.id.agregarcarro5);
        agregarcarro5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto vegan = new Producto("Vegan Bowl", 2500);
                carrito.add(vegan);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro6 = findViewById(R.id.agregarcarro6);
        agregarcarro6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto fajita_vegan = new Producto("Fajita Vegan", 3500);
                carrito.add(fajita_vegan);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro7 = findViewById(R.id.agregarcarro7);
        agregarcarro7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto fajita_especial = new Producto("Fajita Especial", 2500);
                carrito.add(fajita_especial);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
        agregarcarro8 = findViewById(R.id.agregarcarro8);
        agregarcarro8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Producto Fajita_normal = new Producto("Fajita Normal", 2500);
                carrito.add(Fajita_normal);
                Toast.makeText(MainMenu.this, "Se ha agregado el producto al carrito", Toast.LENGTH_SHORT).show();
            }
        });
    }
}