package kr.icehs.intec.mdp_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BasketActivity extends AppCompatActivity {

    String str1="0", str2="0", str3="0", str4="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        TextView tv1 = findViewById(R.id.textView);
        TextView tv2 = findViewById(R.id.textView2);
        TextView tv3 = findViewById(R.id.textView3);
        TextView tv4 = findViewById(R.id.textView4);

        Intent intent = getIntent();
        if(intent.getStringExtra("a") != null) str1 = intent.getStringExtra("a");
        if(intent.getStringExtra("b") != null) str2 = intent.getStringExtra("b");
        if(intent.getStringExtra("c") != null) str3 = intent.getStringExtra("c");
        if(intent.getStringExtra("d") != null) str4 = intent.getStringExtra("d");

        tv1.setText("치킨" + str1 + "개\n");
        tv2.setText("피자" + str2 + "개\n");
        tv3.setText("보쌈" + str3 + "개\n");
        tv4.setText("족발" + str4 + "개\n");

    }
}