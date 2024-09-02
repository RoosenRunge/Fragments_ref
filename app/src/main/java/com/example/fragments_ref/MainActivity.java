package com.example.fragments_ref;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fragments_ref.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

// --1   private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    //--2 criando um gerenciador de fragments
    private FragmentManager fm = getSupportFragmentManager();
    //--3 criando instâncias do Fragmento2 e do Fragmento2
    private Fragmento2 f2 = new Fragmento2();
    private Fragmento3 f3 = new Fragmento3();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAnchorView(R.id.fab)
//                        .setAction("Action", null).show();
//            }
//        });
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
        //---4 codigo para adição dinâmica do Fragmento2
        if (id == R.id.action_Add_frag2) {
            FragmentTransaction t = fm.beginTransaction(); //abrindo a transação
            t.add(R.id.layoutFrag, f2, "Frag2");      //evocando o Fragmento2 e associando ao layoutFrag associando a Tag "Frag2"
            t.addToBackStack(null);                       //adicionando à pilha
            t.commit();                                   //fazendo commit (enviando a operação p/execução)
        }


        //---5 codigo para remoção dinâmica do Fragmento2
        else if (id == R.id.action_Remove_frag2) {
            FragmentTransaction t = fm.beginTransaction(); //abrindo a transação
            t.remove(f2);                                  //remove Frag2
            t.addToBackStack(null);                        //adicionando à pilha
            t.commit();                                    //fazendo commit (enviando a operação p/execução)
        }

        //6-- codigo para captura da instância do Frag2 pela tag.
        else if (id == R.id.action_Find_frag2_by_tag) {
            Fragmento2 tag = (Fragmento2) fm.findFragmentByTag("Frag2"); //buscando Fra2 pela Tag e associando a variável tag
            if (tag != null)                     //se tag !=null chama método helloFrag2() no Fragmento2
                tag.helloFrag2();

        }
        //-7 -- código para trocar dinâmicamente o Frag2 pelo Frag3 com passagem de argumentos
        else if (id == R.id.action_Replace_Frag3_Args){
            FragmentTransaction t = fm.beginTransaction();  //abrindo a transação
            Bundle args = new Bundle();                     //criando variável Bundle para guardar "chave","valor"
            args.putString("myTag","android Telecom");      //passando a chave e o valor
            f3.setArguments(args);                          //inserindo no Fragmento3
            t.replace(R.id.layoutFrag,f3);                  //Colocando Fragmento3 no LayoutFrag
            t.addToBackStack(null);                         //adicionando à pilha
            t.commit();                                     //fazendo commit (enviando a operação p/execução)
        }


        return super.onOptionsItemSelected(item);
    }


    //8----criação do método Hello na activity que será evocado pelo Fragmento1 atravvés do botão btHello
    public void hello() {
        Toast.makeText(this, "método hello da Activity", Toast.LENGTH_LONG).show();
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }


}