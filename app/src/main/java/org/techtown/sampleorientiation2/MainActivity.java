package org.techtown.sampleorientiation2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView; //전역변수 : 어디서든 호출하면 사용가능하다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button); //지역변수 button 이 메소드 안에서만 사용이 가능하다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //화면에서 실행
                showMessage();
            }
        });
    }

    private void showMessage() { //대화상자 만들기
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("안내");
        builder.setMessage("종료하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("예", new DialogInterface.OnClickListener() { //예 버튼 추가
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String message = "예 버튼이 눌렸습니다.";
                textView.setText(message);
            }
        });

        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() { //취소 버튼 추가
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String message = "취소버튼이 눌렸습니다";
                textView.setText(message);

            }
        });

        builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() { //아니오 버튼 추가
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String message = "아니오 버튼이 눌렸습니다";
                textView.setText(message);
            }
        });

        AlertDialog dialog = builder.create(); //builder 변수에 create라는 메소드를 주고, 이것을 dialog 변수에 넣고,
        dialog.show(); //show 메소드를 주어 실행한다.
    }
}