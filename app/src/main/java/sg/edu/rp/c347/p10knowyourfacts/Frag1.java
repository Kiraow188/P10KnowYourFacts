package sg.edu.rp.c347.p10knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    Button btn;

    public Frag1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        btn = view.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getBackground().equals(Color.BLUE)) {
                    view.setBackgroundColor(Color.YELLOW);
                }else{
                    view.setBackgroundColor(Color.BLUE);
                }
            }
        });
        return view;
    }

}
