package com.example.c1groupv2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.c1groupv2.fragment.AddWordFragment;
import com.example.c1groupv2.fragment.ExercisesFragment;
import com.example.c1groupv2.fragment.NewWordListFragment;
import com.example.c1groupv2.fragment.QAFragment;
import com.example.c1groupv2.fragment.BrowseFragment;

public class NaviAdapter extends FragmentPagerAdapter {
    private BrowseFragment browseFragment;
    private AddWordFragment addWordFragment;
    private NewWordListFragment newWordListFragment;
    private ExercisesFragment exercisesFragment;
    private QAFragment qaFragment;

    private  Fragment [] arrFragment;

    public NaviAdapter(@NonNull FragmentManager fm) {
        super(fm);
        browseFragment = new BrowseFragment();
        addWordFragment = new AddWordFragment();
        newWordListFragment = new NewWordListFragment();
        exercisesFragment = new ExercisesFragment();
        qaFragment = new QAFragment();
        arrFragment = new Fragment[] { browseFragment,addWordFragment,  newWordListFragment, exercisesFragment, qaFragment};
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrFragment[position];
    }

    @Override
    public int getCount() {
        return arrFragment.length;
    }
}
