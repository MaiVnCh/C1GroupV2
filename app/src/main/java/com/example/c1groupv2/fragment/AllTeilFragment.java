package com.example.c1groupv2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.c1groupv2.Const;
import com.example.c1groupv2.R;
import com.example.c1groupv2.util.OnItemAllTeilClickListener;

public class AllTeilFragment extends Fragment implements View.OnClickListener {
    private int lessonId;
    TextView tvLessonHeading, tvSummaryA, tvSummaryB, tvSummaryC, tvSummaryD;
    String[] teilASummary = {Const.TEIL_A_LESSON1, Const.TEIL_A_LESSON2,Const.TEIL_A_LESSON3,
            Const.TEIL_A_LESSON4 ,Const.TEIL_A_LESSON5 ,Const.TEIL_A_LESSON6 ,Const.TEIL_A_LESSON7 ,Const.TEIL_A_LESSON8  };
    String[] teilBSummary = {Const.TEIL_B_LESSON1, Const.TEIL_B_LESSON2,Const.TEIL_B_LESSON3,
            Const.TEIL_B_LESSON4 ,Const.TEIL_B_LESSON5 ,Const.TEIL_B_LESSON6 ,Const.TEIL_B_LESSON7 ,Const.TEIL_B_LESSON8  };
    String[] teilCSummary = {Const.TEIL_C_LESSON1, Const.TEIL_C_LESSON2,Const.TEIL_C_LESSON3,
            Const.TEIL_C_LESSON4 ,Const.TEIL_C_LESSON5 ,Const.TEIL_C_LESSON6 ,Const.TEIL_C_LESSON7 ,Const.TEIL_C_LESSON8  };
    String[] teilDSummary = {Const.TEIL_D_LESSON1, Const.TEIL_D_LESSON2,Const.TEIL_D_LESSON3,
            Const.TEIL_D_LESSON4 ,Const.TEIL_D_LESSON5 ,Const.TEIL_D_LESSON6 ,Const.TEIL_D_LESSON7 ,Const.TEIL_D_LESSON8  };

    public AllTeilFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        lessonId = Integer.parseInt(bundle.getString("lessonId"));
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_teil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        view.findViewById(R.id.ll_click_teilA).setOnClickListener(this);
        view.findViewById(R.id.ll_click_teilB).setOnClickListener(this);
        view.findViewById(R.id.ll_click_teilC).setOnClickListener(this);
        view.findViewById(R.id.ll_click_teilD).setOnClickListener(this);
        tvLessonHeading = view.findViewById(R.id.tv_lesson_heading);
        tvSummaryA = view.findViewById(R.id.tv_summary_a);
        tvSummaryB = view.findViewById(R.id.tv_summary_b);
        tvSummaryC = view.findViewById(R.id.tv_summary_c);
        tvSummaryD = view.findViewById(R.id.tv_summary_d);

        if (lessonId == 1){
            tvLessonHeading.setText("Kapitel "+ lessonId+ ": Reden wir mal übers Wetter (Click for more details)");
            tvSummaryA.setText(teilASummary[0]);
            tvSummaryB.setText(teilBSummary[0]);
            tvSummaryC.setText(teilCSummary[0]);
            tvSummaryD.setText(teilDSummary[0]);

        } else if (lessonId == 2){
            tvLessonHeading.setText("Kapitel "+ lessonId+ ": Glück und andere Gefühle (Click for more details)");
            tvSummaryA.setText(teilASummary[1]);
            tvSummaryB.setText(teilBSummary[1]);
            tvSummaryC.setText(teilCSummary[1]);
            tvSummaryD.setText(teilDSummary[1]);
        }else if (lessonId == 3){
            tvLessonHeading.setText("Kapitel "+ lessonId+ ": Erfolge und Niederlagen (Click for more details)");
            tvSummaryA.setText(teilASummary[2]);
            tvSummaryB.setText(teilBSummary[2]);
            tvSummaryC.setText(teilCSummary[2]);
            tvSummaryD.setText(teilDSummary[2]);
        }else if (lessonId == 4){
            tvLessonHeading.setText("Kapitel "+ lessonId+ ": Fortschritt und Umwelt (Click for more details)");
            tvSummaryA.setText(teilASummary[3]);
            tvSummaryB.setText(teilBSummary[3]);
            tvSummaryC.setText(teilCSummary[3]);
            tvSummaryD.setText(teilDSummary[3]);
        }else if (lessonId == 5){
            tvLessonHeading.setText("Kapitel "+ lessonId+ ": Das Reich der Sinne (Click for more details)");
            tvSummaryA.setText(teilASummary[4]);
            tvSummaryB.setText(teilBSummary[4]);
            tvSummaryC.setText(teilCSummary[4]);
            tvSummaryD.setText(teilDSummary[4]);
        }else if (lessonId == 6){
            tvLessonHeading.setText("Kapitel "+ lessonId+ ": Geschichte und Politik (Click for more details)");
            tvSummaryA.setText(teilASummary[5]);
            tvSummaryB.setText(teilBSummary[5]);
            tvSummaryC.setText(teilCSummary[5]);
            tvSummaryD.setText(teilDSummary[5]);
        }else if (lessonId == 7){
            tvLessonHeading.setText("Kapitel "+ lessonId+ ": Ton, Bild und Wort (Click for more details)");
            tvSummaryA.setText(teilASummary[6]);
            tvSummaryB.setText(teilBSummary[6]);
            tvSummaryC.setText(teilCSummary[6]);
            tvSummaryD.setText(teilDSummary[6]);
        }else {
            tvLessonHeading.setText("Kapitel "+ lessonId+ ": Lebenswege (Click for more details)");
            tvSummaryA.setText(teilASummary[7]);
            tvSummaryB.setText(teilBSummary[7]);
            tvSummaryC.setText(teilCSummary[7]);
            tvSummaryD.setText(teilDSummary[7]);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_click_teilA:
                if (onItemAllTeilClickListener!= null){
                    onItemAllTeilClickListener.onClickItemAllTeil(v);
                }
                break;
            case R.id.ll_click_teilB:
                if (onItemAllTeilClickListener!= null){
                    onItemAllTeilClickListener.onClickItemAllTeil(v);
                }
                break;
            case R.id.ll_click_teilC:
                if (onItemAllTeilClickListener!= null){
                    onItemAllTeilClickListener.onClickItemAllTeil(v);
                }
                break;
            case R.id.ll_click_teilD:
                if (onItemAllTeilClickListener!= null){
                    onItemAllTeilClickListener.onClickItemAllTeil(v);
                }
                break;
        }

    }

    private OnItemAllTeilClickListener onItemAllTeilClickListener;

    public void setOnItemAllTeilClickListener(OnItemAllTeilClickListener onItemAllTeilClickListener) {
        this.onItemAllTeilClickListener = onItemAllTeilClickListener;
    }
}