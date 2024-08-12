package com.thisdarkcrow.sudo;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.thisdarkcrow.sudo.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private TextView[][] sudoku;
    private Button[] numPad;
    int targetX;
    int targetY;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        targetX=-1;
        targetY=-1;
        sudoku=new TextView[9][9];

        sudoku[0][0]=binding.textView00;
        sudoku[0][1]=binding.textView01;
        sudoku[0][2]=binding.textView02;
        sudoku[0][3]=binding.textView03;
        sudoku[0][4]=binding.textView04;
        sudoku[0][5]=binding.textView05;
        sudoku[0][6]=binding.textView06;
        sudoku[0][7]=binding.textView07;
        sudoku[0][8]=binding.textView08;

        sudoku[1][0]=binding.textView10;
        sudoku[1][1]=binding.textView11;
        sudoku[1][2]=binding.textView12;
        sudoku[1][3]=binding.textView13;
        sudoku[1][4]=binding.textView14;
        sudoku[1][5]=binding.textView15;
        sudoku[1][6]=binding.textView16;
        sudoku[1][7]=binding.textView17;
        sudoku[1][8]=binding.textView18;

        sudoku[2][0]=binding.textView20;
        sudoku[2][1]=binding.textView21;
        sudoku[2][2]=binding.textView22;
        sudoku[2][3]=binding.textView23;
        sudoku[2][4]=binding.textView24;
        sudoku[2][5]=binding.textView25;
        sudoku[2][6]=binding.textView26;
        sudoku[2][7]=binding.textView27;
        sudoku[2][8]=binding.textView28;

        sudoku[3][0]=binding.textView30;
        sudoku[3][1]=binding.textView31;
        sudoku[3][2]=binding.textView32;
        sudoku[3][3]=binding.textView33;
        sudoku[3][4]=binding.textView34;
        sudoku[3][5]=binding.textView35;
        sudoku[3][6]=binding.textView36;
        sudoku[3][7]=binding.textView37;
        sudoku[3][8]=binding.textView38;

        sudoku[4][0]=binding.textView40;
        sudoku[4][1]=binding.textView41;
        sudoku[4][2]=binding.textView42;
        sudoku[4][3]=binding.textView43;
        sudoku[4][4]=binding.textView44;
        sudoku[4][5]=binding.textView45;
        sudoku[4][6]=binding.textView46;
        sudoku[4][7]=binding.textView47;
        sudoku[4][8]=binding.textView48;

        sudoku[5][0]=binding.textView50;
        sudoku[5][1]=binding.textView51;
        sudoku[5][2]=binding.textView52;
        sudoku[5][3]=binding.textView53;
        sudoku[5][4]=binding.textView54;
        sudoku[5][5]=binding.textView55;
        sudoku[5][6]=binding.textView56;
        sudoku[5][7]=binding.textView57;
        sudoku[5][8]=binding.textView58;

        sudoku[6][0]=binding.textView60;
        sudoku[6][1]=binding.textView61;
        sudoku[6][2]=binding.textView62;
        sudoku[6][3]=binding.textView63;
        sudoku[6][4]=binding.textView64;
        sudoku[6][5]=binding.textView65;
        sudoku[6][6]=binding.textView66;
        sudoku[6][7]=binding.textView67;
        sudoku[6][8]=binding.textView68;

        sudoku[7][0]=binding.textView70;
        sudoku[7][1]=binding.textView71;
        sudoku[7][2]=binding.textView72;
        sudoku[7][3]=binding.textView73;
        sudoku[7][4]=binding.textView74;
        sudoku[7][5]=binding.textView75;
        sudoku[7][6]=binding.textView76;
        sudoku[7][7]=binding.textView77;
        sudoku[7][8]=binding.textView78;

        sudoku[8][0]=binding.textView80;
        sudoku[8][1]=binding.textView81;
        sudoku[8][2]=binding.textView82;
        sudoku[8][3]=binding.textView83;
        sudoku[8][4]=binding.textView84;
        sudoku[8][5]=binding.textView85;
        sudoku[8][6]=binding.textView86;
        sudoku[8][7]=binding.textView87;
        sudoku[8][8]=binding.textView88;

        numPad=new Button[9];

        numPad[0]=binding.button1;
        numPad[1]=binding.button2;
        numPad[2]=binding.button3;
        numPad[3]=binding.button4;
        numPad[4]=binding.button5;
        numPad[5]=binding.button6;
        numPad[6]=binding.button7;
        numPad[7]=binding.button8;
        numPad[8]=binding.button9;

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );*/

        //Numeric screen button array listeners
        for(int i=0;i<numPad.length;++i){
            int finali=i;
            numPad[i].setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                sudoku[targetX][targetY].setText(""+(finali+1));
                            }catch (NullPointerException | ArrayIndexOutOfBoundsException e){}

                        }
                    }
            );
        }

        //Cell selected array screen listeners
        for(int i=0;i<sudoku.length;++i){
            int finali=i;
            for(int j=0;j<sudoku.length;++j){
                int finalj = j;
                sudoku[i][j].setOnClickListener(
                        new View.OnClickListener(){
                            @Override
                            public void onClick(View view) {
                                try{
                                    sudoku[targetX][targetY].setBackgroundResource(R.drawable.marco_black_foreground);
                                } catch (ArrayIndexOutOfBoundsException e){}

                                targetX=finali;
                                targetY= finalj;

                                sudoku[finali][finalj].setBackgroundResource(R.drawable.marco_red_foreground);
                            }
                        }
                );
            }
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}