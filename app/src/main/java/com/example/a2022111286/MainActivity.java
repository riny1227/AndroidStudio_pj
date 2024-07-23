package com.example.a2022111286;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDetail, tvMoney;
    ImageButton btn_draw;
    EditText dlgEdtDetail, dlgEdtMoney;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("가계부 내역 작성");

        tvDetail = (TextView) findViewById(R.id.tvDetail);
        tvMoney = (TextView) findViewById(R.id.tvMoney);
        btn_draw = (ImageButton) findViewById(R.id.btn_draw);

        btn_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // layout > dialog1.xml 파일을 인플레이트하여 dialogView에 대입
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);

                // AlertDialog.Builder 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("가계부 내역 작성");  // 제목
                dlg.setIcon(R.drawable.ic_draw); // 아이콘
                dlg.setView(dialogView);    // 인플레이트한 dialogView을 대화상자로 사용

                //setPositiveButton(문자열, 리스너) 메서드 만들기
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 사용자 이름(dlgEdit1), 이메일(dlgEdit2) 위젯을 변수에 대입
                        dlgEdtDetail = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                        dlgEdtMoney = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                        // 사용자 이름(dlgEdit1), 이메일(dlgEdit2) 가져와 설정(tvName, tvEmail)하기
                        tvDetail.setText(dlgEdtDetail.getText().toString());
                        tvMoney.setText(dlgEdtMoney.getText().toString());
                    }
                });
                dlg.show();
            }
        });
    }
}