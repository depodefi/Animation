package animation.l.test.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<ImageView> images = new ArrayList<ImageView>();
    private Button buyButton = null;
    private Button cancelButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        images.add((ImageView)findViewById(R.id.square1));
        images.add((ImageView)findViewById(R.id.square2));
        images.add((ImageView)findViewById(R.id.square3));
        images.add((ImageView)findViewById(R.id.square4));
        images.add((ImageView)findViewById(R.id.square5));
        images.add((ImageView)findViewById(R.id.square6));
        buyButton = (Button)findViewById(R.id.buy);
        cancelButton = (Button)findViewById(R.id.cancel);

        OnClickListener buyCancelListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(buyButton.getVisibility() == View.VISIBLE) {
                    cancelButton.setVisibility(View.VISIBLE);
                    buyButton.setVisibility(View.GONE);
                } else {
                    buyButton.setVisibility(View.VISIBLE);
                    cancelButton.setVisibility(View.GONE);
                }
            }
        };

        buyButton.setOnClickListener(buyCancelListener);
        cancelButton.setOnClickListener(buyCancelListener);

        final AlphaAnimation mAlphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        images.get(0).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(mAlphaAnimation);
            }
        });

    }
}
