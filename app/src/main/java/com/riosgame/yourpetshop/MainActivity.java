package com.riosgame.yourpetshop;

import android.app.Fragment;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView ListaAnimales;
    FragmentPagerAdapter adapterViewPager;
    ImageView imagen2;
    int clicks;
    ImageView imagen3;
    TextView tv_cantidad;
    private TabLayout tabLayout;
    private ViewPager viewpager1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen2 = (ImageView) findViewById(R.id.imagen2);
        imagen3 = (ImageView) findViewById(R.id.imagen3);
        tv_cantidad = (TextView) findViewById(R.id.tv_cantidad);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewpager1 = (ViewPager) findViewById(R.id.viewpager1);

        Toolbar mytulbar = (Toolbar) findViewById(R.id.myactionbar);
        setSupportActionBar(mytulbar);
        ImageView estrella = (ImageView) findViewById(R.id.estrella);



        PageAdapter myPagerAdapter = new PageAdapter(getSupportFragmentManager());
        viewpager1 = (ViewPager) findViewById(R.id.viewpager1);
        viewpager1.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewpager1);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);

       // ListaAnimales = (RecyclerView) findViewById(R.id.rvanimales);
       // LinearLayoutManager llm = new LinearLayoutManager(this);
       // llm.setOrientation(LinearLayoutManager.VERTICAL);
     //  GridLayoutManager glm = new GridLayoutManager(this, 2);
      //  ListaAnimales.setLayoutManager(glm);
       // InicializarListaAnimales();
       // InicializarAdapter();
       // setUpViewPager();
       /* if(mytulbar != null){
            setSupportActionBar(mytulbar);

        }*/

        getSupportActionBar().setTitle(null);

        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adelante = new Intent(MainActivity.this, ListadoMascotas.class);
                startActivity(adelante);

            }
        });
    }
  /*  public void menupopup(View v) {
        //ImageView  imagen3 = (ImageView) findViewById(R.id.imagen3);
        PopupMenu popup = new PopupMenu(this, imagen3);
        popup.getMenuInflater().inflate(R.menu.menupoupup, popup.getMenu());
        popup.show();
       // Toast .makeText(activity,"has hecho clicks", Toast.LENGTH_LONG).show();

    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.contacto:

                ActivityContacto();
                break;
            case R.id.acercade:

                AcercaDe();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void ActivityContacto() {
        Intent intent = new Intent(this,Formulario.class);
        startActivity(intent);
        Toast.makeText(this, "El mundo esta loco", Toast.LENGTH_SHORT).show();
    }
    private void AcercaDe() {
        Intent intent2 = new Intent(this,DeveloperBio.class);
        startActivity(intent2);
        Toast.makeText(this, "El mundo es mio", Toast.LENGTH_SHORT).show();
    }
}

/*miBoton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {//con esto paso datos de una acividad a otra
				Intent i = new Intent (PrimerActivity.this, SegundoActivity.class);
				i.putExtra("nombre", campoNombre.getText()+"");
				i.putExtra("apellido", campoApellidos.getText()+"");
				startActivity(i);
			}
		});

		String nombre = getIntent().getStringExtra("nombre");//con esto recivo los dato enviados desde otra actividad
		String apellidos = getIntent().getStringExtra("apellido");*/
