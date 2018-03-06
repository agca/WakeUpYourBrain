package cz.ales.training;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    private Button btnEasy;
    private Button btnHard;
    private Button btnCust;
    private Animation anim_bounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        btnEasy = findViewById(R.id.button_easy);
        btnHard = findViewById(R.id.button_hard);
        btnCust = findViewById(R.id.button_custom);
        TextView title = findViewById(R.id.tvTitle);

        Animation anim_easy = AnimationUtils.loadAnimation(this, R.anim.anim_easy);
        Animation anim_hard = AnimationUtils.loadAnimation(this, R.anim.anim_hard);
        Animation anim_cust = AnimationUtils.loadAnimation(this, R.anim.anim_cust);
        Animation anim_fab = AnimationUtils.loadAnimation(this, R.anim.anim_fab);
        Animation anim_title = AnimationUtils.loadAnimation(this, R.anim.anim_title);
        anim_bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);


        btnEasy.startAnimation(anim_easy);
        btnHard.startAnimation(anim_hard);
        btnCust.startAnimation(anim_cust);
//        fab.startAnimation(anim_fab);
        title.startAnimation(anim_title);

        Equation equation = new Equation(true, false, false, false, 10, 20);
//
        Toast.makeText(this, equation.getEquationString() + equation.getCorrectResultString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goEasy(View view) {
        btnEasy.startAnimation(anim_bounce);
        Equation equation = new Equation(false, true, false, true, 10, 20);
        Toast.makeText(this, equation.getEquationString() + equation.getCorrectResultString(), Toast.LENGTH_SHORT).show();
    }

    public void goHard(View view) {
        btnHard.startAnimation(anim_bounce);
    }

    public void goCustom(View view) {
        btnCust.startAnimation(anim_bounce);
    }
}
