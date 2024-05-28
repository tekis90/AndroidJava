package com.game.kenneygame;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.game.kenneygame.databinding.FragmentGirisBinding;


public class GirisFragment extends Fragment {


    private FragmentGirisBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding=FragmentGirisBinding.inflate(inflater,container,false);

       binding.btBubu.setOnClickListener(v->{

           Log.e("Button","BUBU Selected");

           Intent intent = new Intent(requireActivity(), GameMainActivity.class);
           intent.putExtra("character","BUBU");

           Log.e("character","BUBU ");
           startActivity(intent);
           Log.e("Button","Go to Game Page ");

        });

       binding.btDudu.setOnClickListener(v->{

           Log.e("Button","DUDU Selected");

           Intent intent = new Intent(requireActivity(), GameMainActivity.class);
           intent.putExtra("character","DUDU");
           Log.e("character","DUDU ");

           startActivity(intent);
           Log.e("Button","Go to Game Page ");



       });





        return binding.getRoot();
    }
}