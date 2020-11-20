package com.example.listdrakor.utils;

import com.example.listdrakor.R;
import com.example.listdrakor.models.Drama;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Drama> getActionDrama(){

        List<Drama> lstDrama = new ArrayList<>();
        lstDrama.add(new Drama("Healer",R.drawable.healer, R.drawable.healer));
        lstDrama.add(new Drama("Search",R.drawable.search, R.drawable.search));
        lstDrama.add(new Drama("Kingdom",R.drawable.kingdom, R.drawable.kingdom));
        lstDrama.add(new Drama("Vagabond",R.drawable.vagabond, R.drawable.vgbnd));
        lstDrama.add(new Drama("Private Lives",R.drawable.private_lives, R.drawable.private_lives));
        lstDrama.add(new Drama("Arthdal Chornicles",R.drawable.arthdal_chronicles, R.drawable.arthdal_chronicles));
        lstDrama.add(new Drama("Tale of The Nine Tiled",R.drawable.tale_of_the_nine_tailed, R.drawable.tale_of_the_nine_tailed));
        return lstDrama;
    }

    public static List<Drama> getRomanceDrama(){
        List<Drama> lstDrama = new ArrayList<>();
        lstDrama.add(new Drama("Crash Landing on You",R.drawable.cloy, R.drawable.cloy));
        lstDrama.add(new Drama("Start Up",R.drawable.start_up, R.drawable.startup));
        lstDrama.add(new Drama("It's Okay to not be Okay",R.drawable.iotnbo, R.drawable.iotnbo));
        lstDrama.add(new Drama("Descendant of the Sun",R.drawable.dots, R.drawable.dots));
        lstDrama.add(new Drama("18 Again", R.drawable.eighteen_again, R.drawable.ea));
        lstDrama.add(new Drama("More Than Friend",R.drawable.more_than_friend, R.drawable.more_than_friend));
        lstDrama.add(new Drama("Itaewon Class",R.drawable.icjpg, R.drawable.icjpg));
        return lstDrama;
    }

    public static List<Drama> getFantasiDrama(){
        List<Drama> lstDrama = new ArrayList<>();
        lstDrama.add(new Drama("Search",R.drawable.search, R.drawable.search));
        lstDrama.add(new Drama("Kingdom",R.drawable.kingdom, R.drawable.kingdom));
        lstDrama.add(new Drama("18 Again", R.drawable.eighteen_again, R.drawable.ea));
        lstDrama.add(new Drama("Arthdal Chornicles",R.drawable.arthdal_chronicles, R.drawable.arthdal_chronicles));
        lstDrama.add(new Drama("Tale of The Nine Tiled",R.drawable.tale_of_the_nine_tailed, R.drawable.tale_of_the_nine_tailed));

        return lstDrama;
    }
}
