package sg.edu.rp.c347.p10knowyourfacts;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = findViewById(R.id.viewpager1);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());
        al.add(new Frag3());

        adapter = new MyFragmentPagerAdapter(fm, al);

        vPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_next) {
            int max = vPager.getChildCount();
            if (vPager.getCurrentItem() < max-1){
                int nextpage = vPager.getCurrentItem() + 1;
                vPager.setCurrentItem(nextpage, true);
            }
            return true;
        }else if (id == R.id.action_previous){
            if (vPager.getCurrentItem() > 0){
                int previouspage = vPager.getCurrentItem() - 1;
                vPager.setCurrentItem(previouspage, true);
            }
            return true;
        }else if (id == R.id.action_random){
            // create random object
            setRandomPage();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setRandomPage(){
        Random randomno = new Random();
        int page = randomno.nextInt(3);
        if (page != vPager.getCurrentItem()){
            vPager.setCurrentItem(page, true);
        }else{
            setRandomPage();
        }
    }
}
