package kr.icehs.intec.mdp_firebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    LinearLayout home_layout, category_layout, user_layout, wait_layout, pringles_layout, kancho_layout, choco_layout, milk_layout, basket_layout, all_layout;
    ConstraintLayout snack_layout, beverage_layout;
    DrawerLayout drawerLayout;
    View drawerView;
    TextView tv1, mount1_tv, mount2_tv, mount3_tv, mount4_tv, price1_tv, price2_tv;
    ImageButton home_btn, category_btn1, category_btn2, user_btn, basket_btn, back_btn;
    Button clothes_btn, snack_btn, beverage_btn, food_btn, goods_btn, plus1_btn, minus1_btn,plus2_btn, minus2_btn, plus3_btn, minus3_btn, plus4_btn, minus4_btn, save_btn, order_btn, save_btn2, order_btn2, save_btn3, order_btn3, save_btn4, order_btn4, order2_btn;
    ImageView pringles, kancho, choco, milk;
    ViewFlipper v_flipper;
    ListView listView;
    ListViewAdapter adapter;
    int a=0, b=0, c=0, d=0, total=0, total_1=0, total_2=0;
    String total_3;

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

        drawerView = findViewById(R.id.drawerView);
        category_btn1 = findViewById(R.id.category_btn1);
        category_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerView);
            }
        });     // ???????????? ??????1

        int images[] = {
            R.drawable.ad1,
            R.drawable.sale
        };

        v_flipper = findViewById(R.id.image_slide);
        for(int image : images){
            fllipperImages(image);
        }

        price1_tv = findViewById(R.id.price1_tv);
        price2_tv = findViewById(R.id.price2_tv);
        order2_btn = findViewById(R.id.order2_btn);

        basket_layout = findViewById(R.id.basket_layout);
        all_layout = findViewById(R.id.all_layout);
        drawerLayout = findViewById(R.id.drawerLayout);
        pringles_layout = findViewById(R.id.pringles_layout);
        kancho_layout = findViewById(R.id.kancho_layout);
        choco_layout = findViewById(R.id.choco_layout);
        milk_layout = findViewById(R.id.milk_layout);
        beverage_layout = findViewById(R.id.beverage_layout);
        wait_layout = findViewById(R.id.wait_layout);
        snack_layout = findViewById(R.id.snack_layout);
        home_layout = findViewById(R.id.home_layout);
        category_layout = findViewById(R.id.category_layout);
        user_layout = findViewById(R.id.user_layout);

        home_btn = findViewById(R.id.home_btn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_layout.setVisibility(View.VISIBLE);
                category_layout.setVisibility(View.INVISIBLE);
                user_layout.setVisibility(View.INVISIBLE);
                home_btn.setBackgroundResource(R.drawable.home_blue);
                category_btn2.setBackgroundResource(R.drawable.category);
                user_btn.setBackgroundResource(R.drawable.user);
                wait_layout.setVisibility(View.INVISIBLE);
                snack_layout.setVisibility(View.INVISIBLE);
                beverage_layout.setVisibility(View.INVISIBLE);
                pringles_layout.setVisibility(View.INVISIBLE);
                kancho_layout.setVisibility(View.INVISIBLE);
                choco_layout.setVisibility(View.INVISIBLE);
                milk_layout.setVisibility(View.INVISIBLE);
                mount1_tv.setText("0");
                mount2_tv.setText("0");
                mount3_tv.setText("0");
                mount4_tv.setText("0");
            }
        });     // ????????? ??????

        category_btn2 = findViewById(R.id.category_btn2);
        category_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_layout.setVisibility(View.INVISIBLE);
                category_layout.setVisibility(View.VISIBLE);
                user_layout.setVisibility(View.INVISIBLE);
                home_btn.setBackgroundResource(R.drawable.home);
                category_btn2.setBackgroundResource(R.drawable.category_blue);
                user_btn.setBackgroundResource(R.drawable.user);
                wait_layout.setVisibility(View.INVISIBLE);
                snack_layout.setVisibility(View.INVISIBLE);
                beverage_layout.setVisibility(View.INVISIBLE);
                pringles_layout.setVisibility(View.INVISIBLE);
                kancho_layout.setVisibility(View.INVISIBLE);
                choco_layout.setVisibility(View.INVISIBLE);
                milk_layout.setVisibility(View.INVISIBLE);
                basket_layout.setVisibility(View.INVISIBLE);
                all_layout.setVisibility(View.VISIBLE);
                a=0;
                b=0;
                c=0;
                d=0;
                mount1_tv.setText("0");
                mount2_tv.setText("0");
                mount3_tv.setText("0");
                mount4_tv.setText("0");
            }
        });     //  ???????????? ??????2

        user_btn = findViewById(R.id.user_btn);
        user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_layout.setVisibility(View.INVISIBLE);
                category_layout.setVisibility(View.INVISIBLE);
                user_layout.setVisibility(View.VISIBLE);
                home_btn.setBackgroundResource(R.drawable.home);
                category_btn2.setBackgroundResource(R.drawable.category);
                user_btn.setBackgroundResource(R.drawable.user_blue);
                wait_layout.setVisibility(View.INVISIBLE);
                snack_layout.setVisibility(View.INVISIBLE);
            }
        });     // ??????????????? ??????

        clothes_btn = findViewById(R.id.clothes);
        clothes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wait_layout.setVisibility(View.VISIBLE);
                snack_layout.setVisibility(View.INVISIBLE);
                category_layout.setVisibility(View.INVISIBLE);
            }
        });     // ???????????? ??????

        snack_btn = findViewById(R.id.snacks);
        snack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wait_layout.setVisibility(View.INVISIBLE);
                snack_layout.setVisibility(View.VISIBLE);
                category_layout.setVisibility(View.INVISIBLE);
            }
        });     // ???????????? ??????

        beverage_btn = findViewById(R.id.beverage);
        beverage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beverage_layout.setVisibility(View.VISIBLE);
                category_layout.setVisibility(View.INVISIBLE);
            }
        });     // ???????????? ??????

        food_btn = findViewById(R.id.food);
        food_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wait_layout.setVisibility(View.VISIBLE);
                snack_layout.setVisibility(View.INVISIBLE);
                category_layout.setVisibility(View.INVISIBLE);
            }
        });     // ???????????? ????????????

        goods_btn = findViewById(R.id.goods);
        goods_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wait_layout.setVisibility(View.VISIBLE);
                snack_layout.setVisibility(View.INVISIBLE);
                category_layout.setVisibility(View.INVISIBLE);
            }
        });     // ???????????? ????????????

        pringles = findViewById(R.id.pringles);
        pringles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pringles_layout.setVisibility(View.VISIBLE);
                snack_layout.setVisibility(View.INVISIBLE);
            }
        });     // ???????????? ?????? ??????

        kancho = findViewById(R.id.kancho);
        kancho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kancho_layout.setVisibility(View.VISIBLE);
                snack_layout.setVisibility(View.INVISIBLE);
            }
        });     // ?????? ?????? ??????

        choco = findViewById(R.id.choco);
        choco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choco_layout.setVisibility(View.VISIBLE);
                snack_layout.setVisibility(View.INVISIBLE);
            }
        });    // ???????????? ?????? ??????

        milk = findViewById(R.id.milk);
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milk_layout.setVisibility(View.VISIBLE);
                beverage_layout.setVisibility(View.INVISIBLE);
            }
        });     // ?????? ?????? ??????

        mount1_tv = findViewById(R.id.mount1_tv);
        plus1_btn = findViewById(R.id.plus1_btn);
        plus1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                if(a>=4) {
                    Snackbar.make(v, "?????? ????????? ??????????????????.", Snackbar.LENGTH_SHORT).show();
                    a=3;
                }
                if(a<4) mount1_tv.setText(a+"");
            }
        });     // ???????????? ?????? ??????

        minus1_btn = findViewById(R.id.minus1_btn);
        minus1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a--;
                if(a<0) {
                    mount1_tv.setText("0");
                    a=0;
                }
                if(a>=0) mount1_tv.setText(a+"");
            }
        });    // ???????????? ?????? ??????

        mount2_tv = findViewById(R.id.mount2_tv);
        plus2_btn = findViewById(R.id.plus2_btn);
        plus2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b++;
                if(b>=4) {
                    Snackbar.make(v, "?????? ????????? ??????????????????.", Snackbar.LENGTH_SHORT).show();
                    b=3;
                }
                if(b<4) mount2_tv.setText(b+"");
            }
        });     // ?????? ?????? ??????

        minus2_btn = findViewById(R.id.minus2_btn);
        minus2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b--;
                if(b<0) {
                    mount2_tv.setText("0");
                    b=0;
                }
                if(b>=0) mount2_tv.setText(b+"");
            }
        });    // ?????? ?????? ??????

        mount3_tv = findViewById(R.id.mount3_tv);
        plus3_btn = findViewById(R.id.plus3_btn);
        plus3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c++;
                if(c>=4) {
                    Snackbar.make(v, "?????? ????????? ??????????????????.", Snackbar.LENGTH_SHORT).show();
                    c=3;
                }
                if(c<4) mount3_tv.setText(c+"");
            }
        });     // ???????????? ?????? ??????

        minus3_btn = findViewById(R.id.minus3_btn);
        minus3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c--;
                if(c<0) {
                    mount3_tv.setText("0");
                    c=0;
                }
                if(c>=0) mount3_tv.setText(c+"");
            }
        });    // ???????????? ?????? ??????

        mount4_tv = findViewById(R.id.mount4_tv);
        plus4_btn = findViewById(R.id.plus4_btn);
        plus4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d++;
                if(d>=4) {
                    Snackbar.make(v, "?????? ????????? ??????????????????.", Snackbar.LENGTH_SHORT).show();
                    d=3;
                }
                if(d<4) mount4_tv.setText(d+"");
            }
        });     // ?????? ?????? ??????

        minus4_btn = findViewById(R.id.minus4_btn);
        minus4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d--;
                if(d<0) {
                    mount4_tv.setText("0");
                    d = 0;
                }
                if(d>=0) mount4_tv.setText(d+"");
            }
        });    // ?????? ?????? ??????

        // adapter ??????
        adapter = new ListViewAdapter();

        // ???????????? ?????? ??? Adapter ??????
        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        save_btn = findViewById(R.id.save_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a != 0) {
                    // ???????????? ?????? ??? Adapter ??????
                    listView = findViewById(R.id.listview);
                    listView.setAdapter(adapter);
                    adapter.addItem("????????????(????????????)53g", R.drawable.pringles, a * 1 + "," + a * 200 + "???", a + "???");
                    total += a*1200;
                    total_1 = total/1000;
                    total_2 = total%1000;
                    price1_tv.setText(total_1 + "," + total_2 + "???");
                    price2_tv.setText(total_1 + "," + total_2 + "???");
                    order2_btn.setText("??? " + total_1 + "," + total_2 + "??? ????????????");
                    Snackbar.make(v, "???????????????!", Snackbar.LENGTH_SHORT).show();
                }
                else Snackbar.make(v, "????????? ??????????????????!", Snackbar.LENGTH_SHORT).show();
            }
        });      // ???????????? ?????? ??????

        order_btn = findViewById(R.id.order_btn);
        order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a != 0) {
                    // ???????????? ?????? ??? Adapter ??????
                    listView = findViewById(R.id.listview);
                    listView.setAdapter(adapter);
                    adapter.addItem("????????????(????????????)53g", R.drawable.pringles, a * 1 + "," + a * 200 + "???", a + "???");
                    total += a*1200;
                    total_1 = total/1000;
                    total_2 = total%1000;
                    price1_tv.setText(total_1 + "," + total_2 + "???");
                    price2_tv.setText(total_1 + "," + total_2 + "???");
                    order2_btn.setText("??? " + total_1 + "," + total_2 + "??? ????????????");
                    basket_layout.setVisibility(View.VISIBLE);
                    all_layout.setVisibility(View.INVISIBLE);
                }
                else Snackbar.make(v, "????????? ??????????????????!", Snackbar.LENGTH_SHORT).show();
            }
        });     // ???????????? ?????? ??????

        save_btn2 = findViewById(R.id.save_btn2);
        save_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b != 0) {
                    // ???????????? ?????? ??? Adapter ??????
                    listView = findViewById(R.id.listview);
                    listView.setAdapter(adapter);
                    adapter.addItem("[????????????] ?????? 47g", R.drawable.kancho, b * 1 + ",000???", b + "???");
                    total += b*1000;
                    setPrice(true);
                    Snackbar.make(v, "???????????????!", Snackbar.LENGTH_SHORT).show();
                }
                else Snackbar.make(v, "????????? ??????????????????!", Snackbar.LENGTH_SHORT).show();
            }
        });     // ?????? ?????? ??????

        order_btn2 = findViewById(R.id.order_btn2);
        order_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(b != 0) {
                    // ???????????? ?????? ??? Adapter ??????
                    listView = findViewById(R.id.listview);
                    listView.setAdapter(adapter);
                    adapter.addItem("[????????????] ?????? 47g", R.drawable.kancho, b * 1 + ",000???", b + "???");
                    total += b*1000;
                    setPrice(true);
                    basket_layout.setVisibility(View.VISIBLE);
                    all_layout.setVisibility(View.INVISIBLE);
                }
                else Snackbar.make(v, "????????? ??????????????????!", Snackbar.LENGTH_SHORT).show();
            }
        });    // ?????? ?????? ??????

        save_btn3 = findViewById(R.id.save_btn3);
        save_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c != 0) {
                    // ???????????? ?????? ??? Adapter ??????
                    listView = findViewById(R.id.listview);
                    listView.setAdapter(adapter);
                    adapter.addItem("[?????????] ???????????? 50g", R.drawable.choco, c * 1 + ",000???", c + "???");
                    total += c*1000;
                    setPrice(true);
                    Snackbar.make(v, "???????????????!", Snackbar.LENGTH_SHORT).show();
                }
                else Snackbar.make(v, "????????? ??????????????????!", Snackbar.LENGTH_SHORT).show();
            }
        });     // ???????????? ?????? ??????

        order_btn3 = findViewById(R.id.order_btn3);
        order_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(c != 0) {
                    // ???????????? ?????? ??? Adapter ??????
                    listView = findViewById(R.id.listview);
                    listView.setAdapter(adapter);
                    adapter.addItem("[?????????] ???????????? 50g", R.drawable.choco, c * 1 + ",000???", c + "???");
                    total += c*1000;
                    setPrice(true);
                    basket_layout.setVisibility(View.VISIBLE);
                    all_layout.setVisibility(View.INVISIBLE);
                }
                else Snackbar.make(v, "????????? ??????????????????!", Snackbar.LENGTH_SHORT).show();
            }
        });    // ???????????? ?????? ??????

        save_btn4 = findViewById(R.id.save_btn4);
        save_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d != 0) {
                    // ???????????? ?????? ??? Adapter ??????
                    listView = findViewById(R.id.listview);
                    listView.setAdapter(adapter);
                    adapter.addItem("[??????] ?????? 200ML", R.drawable.milk, d * 1 + ",000???", d + "???");
                    total += d*1000;
                    setPrice(true);
                    Snackbar.make(v, "???????????????!", Snackbar.LENGTH_SHORT).show();
                }
                else Snackbar.make(v, "????????? ??????????????????!", Snackbar.LENGTH_SHORT).show();
            }
        });     // ?????? ?????? ??????

        order_btn4 = findViewById(R.id.order_btn4);
        order_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d != 0) {
                    // ???????????? ?????? ??? Adapter ??????
                    listView = findViewById(R.id.listview);
                    listView.setAdapter(adapter);
                    adapter.addItem("[??????] ?????? 200ML", R.drawable.milk, d * 1 + ",000???", d + "???");
                    total += d*1000;
                    setPrice(true);
                    basket_layout.setVisibility(View.VISIBLE);
                    all_layout.setVisibility(View.INVISIBLE);
                }
                else Snackbar.make(v, "????????? ??????????????????!", Snackbar.LENGTH_SHORT).show();
            }
        });    // ?????? ?????? ??????

        basket_btn = findViewById(R.id.basket_btn);
        basket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all_layout.setVisibility(View.INVISIBLE);
                basket_layout.setVisibility(View.VISIBLE);
            }
        });

        adapter.notifyDataSetChanged(); // ???????????? ????????? ??????

        back_btn = findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basket_layout.setVisibility(View.INVISIBLE);
                all_layout.setVisibility(View.VISIBLE);
            }
        });

    }

    // ????????? ???????????? ?????? ?????????
    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);          // ????????? ??????
        v_flipper.setFlipInterval(5000);       // ?????? ????????? ???????????? ???????????????(1000 ??? 1???)
        v_flipper.setAutoStart(true);          // ?????? ?????? ?????? ??????

        // animation
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

    // 1,000??? ?????? ?????? ?????? ?????? ?????????
    public void setPrice(boolean bool) {
        total_1 = total/1000;
        total_2 = total%1000;
        if(total_2 == 0) {
            total_3 = Integer.toString(total_2) + "00";
            price1_tv.setText(total_1 + "," + total_3 + "???");
            price2_tv.setText(total_1 + "," + total_3 + "???");
            order2_btn.setText("??? " + total_1 + "," + total_3 + "??? ????????????");
        }
        if(total_2 != 0) {
            price1_tv.setText(total_1 + "," + total_2 + "???");
            price2_tv.setText(total_1 + "," + total_2 + "???");
            order2_btn.setText("??? " + total_1 + "," + total_2 + "??? ????????????");
        }
    }
}