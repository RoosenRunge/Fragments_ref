package com.example.fragments_ref;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link Fragmento3#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Fragmento3 extends Fragment {

    //1--cria a variável "text" relativa ao caixa de texto no arquivo XML
    private TextView text;
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    public Fragmento3() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment Fragmento3.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static Fragmento3 newInstance(String param1, String param2) {
//        Fragmento3 fragment = new Fragmento3();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_fragmento3, container, false);
        // Inflate the layout for this fragment
        //2--Criação de uma variável view para poder manipular o TextView no fragment_frame3
        View view = inflater.inflate(R.layout.fragment_fragmento3, container, false);

        //3--Faz o link entre a view XML e a variávle "text"
        text = (TextView) view.findViewById(R.id.textoFrag3);

        //4-- Recebimento e passagem de valor para a TexView
        //verifica se há conteúdo a ser lido
        if(getArguments() !=null){

            //extrai o conteúdo e guarda na variável "conteudo"
            String conteudo = getArguments().getString("myTag");

            //insere o conteudo na caixa de texto
            text.setText(conteudo);
        }
        return view ;
    }
}