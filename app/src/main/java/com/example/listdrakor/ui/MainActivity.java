package com.example.listdrakor.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.listdrakor.fragment.SettingsFragment;
import com.example.listdrakor.models.Drama;
import com.example.listdrakor.adapter.DramaAdapter;
import com.example.listdrakor.adapter.DramaItemClickListener;
import com.example.listdrakor.R;
import com.example.listdrakor.models.Slide;
import com.example.listdrakor.adapter.SliderPagerAdapter;
import com.example.listdrakor.utils.AppSettings;
import com.example.listdrakor.utils.DataSource;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements DramaItemClickListener {



    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView DramaRV, DramaRVRomance, DramaRVDramaFantasi;
    AppSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        settings = new AppSettings(this);
        applyTheme(settings.getTheme());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniViews();

        iniSlider();

        iniAction();

        iniRomance();

        iniFantasi();
    }

    private void applyTheme(int theme) {
        switch (theme){
            case  AppSettings.THEME_LIGHT: setTheme(R.style.AppTheme);
                break;
            case  AppSettings.THEME_DARK: setTheme(R.style.DarkTheme);
                break;
            case  AppSettings.THEME_DARK_AMOLED: setTheme(R.style.DarkTheme);
                break;
            default:
                setTheme(R.style.AppTheme);
        }
    }

    private void iniFantasi() {
        DramaAdapter fantasiDramaAdapter = new DramaAdapter(this, DataSource.getFantasiDrama(), this);
        DramaRVDramaFantasi.setAdapter(fantasiDramaAdapter);
        DramaRVDramaFantasi.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }


    private void iniRomance() {
        DramaAdapter romanceDramaAdapter = new DramaAdapter(this, DataSource.getRomanceDrama(), this);
        DramaRVRomance.setAdapter(romanceDramaAdapter);
        DramaRVRomance.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }

    private void iniAction() {


        DramaAdapter dramaAdapter = new DramaAdapter(this, DataSource.getActionDrama(), this);
        DramaRV.setAdapter(dramaAdapter);
        DramaRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private void iniSlider() {
        lstSlides = new ArrayList<>() ;
        lstSlides.add(new Slide(R.drawable.slide1,"Start Up"));
        lstSlides.add(new Slide(R.drawable.slide2,"18 Again"));
        lstSlides.add(new Slide(R.drawable.slide3,"Search"));
        lstSlides.add(new Slide(R.drawable.slide4,"Tale of the Nine Tiled"));
        lstSlides.add(new Slide(R.drawable.slide5,"Private Lives"));
        lstSlides.add(new Slide(R.drawable.slide6,"Vagabond"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);
        sliderpager.setAdapter(adapter);

        indicator.setupWithViewPager(sliderpager,true);

        //setup timer
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 3000);
    }

    private void iniViews() {
        sliderpager = findViewById(R.id.slider_pager) ;
        indicator= findViewById(R.id.indicator);
        DramaRV = findViewById(R.id.rv_drama);
        DramaRVRomance = findViewById(R.id.rv_drama_romance);
        DramaRVDramaFantasi = findViewById(R.id.rv_drama_fantasi);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDramaClick(Drama drama, ImageView dramaImageView) {

        //mengirim informasi drama ke detail activity
        Intent intent = new Intent(this,DramaDetailActivity.class);
        intent.putExtra("title", drama.getTitle());
        intent.putExtra("imgURL", drama.getThumbnail());
        intent.putExtra("imgCover", drama.getCoverPhoto());
        startActivity(intent);

        //membuat animasi
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                                                    dramaImageView,"sharedName");
        startActivity(intent, options.toBundle());

        //membuat tulisan kita mengklik apa
        //Toast.makeText(this,"Membuka : " + drama.getTitle(), Toast.LENGTH_LONG).show();

    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1){
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new SettingsFragment())
                        .addToBackStack(null)
                        .commit();
                return true;
            default:
                return true;
        }
    }



}