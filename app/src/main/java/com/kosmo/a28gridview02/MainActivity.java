package com.kosmo.a28gridview02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    //이미지 리소스 아이디 배열
    int[] resIds = {
            R.drawable.movie01, R.drawable.movie02, R.drawable.movie03,
            R.drawable.movie04, R.drawable.movie05, R.drawable.movie06,
            R.drawable.movie07, R.drawable.movie08, R.drawable.movie09,
    };

    //영화제목
    String[] movies = {
            "리턴", "마파도","말아톤",
            "명량","변호인","설국열차",
            "스물","신세계","해적"
    };

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //어댑터 객체 생성 후 그리드 뷰에 연결함
        CustomAdapter adapter = new CustomAdapter(this, movies, resIds);
        gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(adapter);

        //그리드뷰에 리스너 부착
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //커스텀 대화상자를 띄우기 위해 XML파일을 전개한다.
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View dialogLayout = inflater.inflate(R.layout.dialog_layout, null);

                //영화포스터 이미지 삽임
                ImageView image = (ImageView)dialogLayout.findViewById(R.id.moviedialog);
                image.setImageResource(resIds[i]);

                //커스텀 대화상자 출력
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(movies[i])
                        .setIcon(android.R.drawable.ic_dialog_email)
                        .setView(dialogLayout)
                        .setPositiveButton("확인", null)
                        .show();
            }
        });

    }
}