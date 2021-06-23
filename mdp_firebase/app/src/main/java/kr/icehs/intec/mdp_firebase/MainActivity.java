package kr.icehs.intec.mdp_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    ScrollView scroll2;
    HorizontalScrollView scroll1;
    LinearLayout linear1, linear2;
    TextView tv1;
    ImageButton home_btn, category_btn2, user_btn;
    int a=0, b=0, c=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        SpannableStringBuilder builder = new SpannableStringBuilder("SORDER");
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#4285F4")), 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#EA4335")), 1, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#FBBC05")), 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#4285F4")), 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#34A853")), 4, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(new ForegroundColorSpan(Color.parseColor("#EA4335")), 5, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv1.append(builder);

        scroll1 = findViewById(R.id.scroll1);
        scroll2 = findViewById(R.id.scroll2);
        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scroll1.setVisibility(View.VISIBLE);
                scroll2.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.INVISIBLE);
                linear2.setVisibility(View.INVISIBLE);
                home_btn.setBackgroundResource(R.drawable.home_blue);
                category_btn2.setBackgroundResource(R.drawable.category);
                user_btn.setBackgroundResource(R.drawable.user);
            }
        });
        category_btn2 = findViewById(R.id.category_btn2);
        category_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scroll1.setVisibility(View.INVISIBLE);
                scroll2.setVisibility(View.INVISIBLE);
                linear1.setVisibility(View.VISIBLE);
                linear2.setVisibility(View.INVISIBLE);
                home_btn.setBackgroundResource(R.drawable.home);
                category_btn2.setBackgroundResource(R.drawable.category_blue);
                user_btn.setBackgroundResource(R.drawable.user);

            }
        });
        user_btn = findViewById(R.id.user_btn);
        user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scroll1.setVisibility(View.INVISIBLE);
                scroll2.setVisibility(View.INVISIBLE);
                linear1.setVisibility(View.INVISIBLE);
                linear2.setVisibility(View.VISIBLE);
                home_btn.setBackgroundResource(R.drawable.home);
                category_btn2.setBackgroundResource(R.drawable.category);
                user_btn.setBackgroundResource(R.drawable.user_blue);

            }
        });


    }

}