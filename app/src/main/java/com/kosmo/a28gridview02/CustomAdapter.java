package com.kosmo.a28gridview02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    //메인액티비티에서 어댑터 생성 시 매개변수로 전달되는 값 사용
    private Context context; //메인액티비티를 가리킨다.
    private String[] movies; //영화제목을 저장한 배열
    private int[] resIds; //영화 이미지의 아이디값을 저장한 배열

    //인자생성자
    public CustomAdapter(Context context, String[] movies, int[] resIds) {
        this.context = context;
        this.movies = movies;
        this.resIds = resIds;
    }

    //아이템 총 갯수 반환
    @Override
    public int getCount() {
        return movies.length;
    }

    //position 에 해당하는 아이템
    @Override
    public Object getItem(int position) {
        return movies[position];
    }

    //position 에 해당하는 아이템의 아이디값
    @Override
    public long getItemId(int position) {
        return position;
    }

    //아이템용 뷰 반환
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //생성된 아이템 레이아웃이 없으 ㄹ경우 xml레이아웃 파일을 통해 인플레이트(전개) 처리함.
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.movie_item, null);
        }

        //위젯 얻고 position 인덱스에 해당하는 각 위젯의 데이터 설정
        ImageView movieImage = (ImageView)convertView.findViewById(R.id.movieImg);
        //영화 포스터 이미지를 커스텀뷰에 설정함
        movieImage.setImageResource(resIds[position]);
        //영화제목을 커스텀뷰에 설정함
        final TextView movieTitle = (TextView)convertView.findViewById(R.id.movieTitle);
        movieTitle.setText(movies[position]);

        return convertView;
    }
}