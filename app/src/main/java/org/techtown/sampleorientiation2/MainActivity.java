package org.techtown.sampleorientiation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
    }

    public void onButton1Clicked(View v) {
        try {
            Toast toastView = Toast.makeText(this, "위치가 바뀐 토스트 메시지입니다.", Toast.LENGTH_LONG); //토스트 메세지 입력 try문인거 참고
            int xOffset = Integer.parseInt(editText.getText().toString()); //정수로 된 xOffset값을 문자로 가져오자
            int yOffset = Integer.parseInt(editText2.getText().toString()); //정수로 된 yOffset값을 문자로 가져오자.

            toastView.setGravity(Gravity.TOP | Gravity.LEFT , xOffset, yOffset);
            toastView.show();
        } catch (NumberFormatException e) { //예외에 대한 정보가 담겨있다.
            e.printStackTrace();
        }
    }
    //스낵바 만들기 (토스트 모양 바꾸기는 토스트가 잘 적용이 안되서 스킵함

    public void onButton3Clicked(View v) {
        Snackbar.make(v, "스낵바입니다", Snackbar.LENGTH_LONG).show();
    }
}
//이 과정들을 시도해보니 토스트의 위치가 변경되지 않는 듯하여 검색해보니, API가 R이상부터는 렌더링이 되지 않아
// 반환 값이 실제 값을 반영하지 않을 수도 있다고 한다. 그래서 이 "public int getGravity ()"메소드를 호출하지 말라고 한다.