package kr.icehs.intec.mdp_firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements Runnable, View.OnClickListener {

    Button m1_btn, m2_btn, m3_btn, m4_btn; // 메뉴 담기 버튼
    Button basket_btn;                     // 장바구니 버튼
    Thread t;
    DataInputStream din;
    DataOutputStream dout;
    Socket sock;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m1_btn = (Button)findViewById(R.id.m1_btn);
        m2_btn = (Button)findViewById(R.id.m2_btn);
        m3_btn = (Button)findViewById(R.id.m3_btn);
        m4_btn = (Button)findViewById(R.id.m4_btn);

        str = new String();

        m1_btn.setOnClickListener(this);
        m2_btn.setOnClickListener(this);
        m3_btn.setOnClickListener(this);
        m4_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        t = new Thread(this);
        t.start();
        switch(v.getId()) {
            case R.id.m1_btn:
                sendMsg("1");
                break;
            case R.id.m2_btn:
                sendMsg("2");
                break;
            case R.id.m3_btn:
                sendMsg("3");
                break;
            case R.id.m4_btn:
                sendMsg("4");
                break;
            default:
                break;
        }
    }

    public void sendMsg(String msg) {
        //str = msg;
        try {
            dout.writeUTF(msg);
            dout.flush();
        } catch(IOException ex) {
            Log.e(ex.toString(), "12");
        } catch (NullPointerException ex) {
            Log.e(ex.toString(), "13");
        }
    }

    @Override
    public void run() {
        try{
            sock = new Socket("192.168.0.38", 7777);
            din = new DataInputStream(sock.getInputStream());
            dout = new DataOutputStream(sock.getOutputStream());
            while(true){
                str = din.readUTF();
                if(str != null){
                    break;
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}