package com.example.quiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.quiz.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    TextView textView, textView2, textView3;
    Button yes, no;
    Integer index, score;
    ImageView imageView;

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        String [] question = {"1) Ronaldo was Born in 1985","2) Ronaldo have 4 ballon d'or","3) Ronaldo is 37 Years old","4) Ronaldo first played for Real Madrid","5) Ronaldo plays for Argentina","6) Ronaldo is having 4 kids","7) Only Ronaldo crossed 800 goals","8) Ronaldo is GOAT"};
        boolean [] answer = {true,false,true,false,false,true,true,true};
        String url = "https://en.wikipedia.org/wiki/Cristiano_Ronaldo";
        textView = view.findViewById(R.id.textView);
        textView2 = view.findViewById(R.id.textView5);
        textView3 = view.findViewById(R.id.textView4);
        imageView = view.findViewById(R.id.imageView4);
        yes = view.findViewById(R.id.button);
        no = view.findViewById(R.id.button2);
        index=0;
        score=0;
        textView2.setText("");
        textView3.setText("");
        textView.setText(question[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer[index]){
                    score++;
                }
                index++;
                if(index==question.length) {
                    if (score==question.length) {
                        yes.setEnabled(false);
                        no.setEnabled(false);
                        textView.setText("You Won (*^▽^*) ");
                        textView2.setText("Your score is: " + score);
                        textView3.setText("If you want to start again press Restart");
                    }
                    else {
                        yes.setEnabled(false);
                        no.setEnabled(false);
                        textView.setText("You Lost (✖╭╮✖)");
                        textView2.setText("Your score is: " + score);
                        textView3.setText("If you want to start again press Restart");
                    }
                }
                else if(!(index ==question.length)) {
                    textView.setText(question[index]);
                }
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!answer[index]) {
                    score++;
                }
                index++;
                if (index == question.length) {
                    if (score==question.length){
                        yes.setEnabled(false);
                        no.setEnabled(false);
                        textView.setText("You Won (*^▽^*) ");
                        textView2.setText("Your score is: " + score);
                        textView3.setText("If you want to start again press Restart");
                    }
                    else {
                        yes.setEnabled(false);
                        no.setEnabled(false);
                        textView.setText("You Lost (✖╭╮✖)");
                        textView2.setText("Your score is: " + score);
                        textView3.setText("If you want to start again press Restart");
                    }
                }
                else if(!(index ==question.length)) {
                    textView.setText(question[index]);
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}