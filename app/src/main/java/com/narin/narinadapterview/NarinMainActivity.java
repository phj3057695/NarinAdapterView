package com.narin.narinadapterview;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NarinMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narin_main);
        final GridView gv = (GridView) findViewById(R.id.gridView1);
        NarinGridAdapter gAdapter = new NarinGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
    public class NarinGridAdapter extends BaseAdapter{
        Context context;
        public NarinGridAdapter(Context c){
            context =c;
        }
        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
        Integer[] posterID={R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,R.drawable.mov09,R.drawable.mov10};
        String[] movieTitle={"위선자들","내부자들","검은 사제들","크림슨 피크", "스파이 브릿지", "맥베스", "어떤이의 꿈", "몬스터 헌트", "마션", "스타워즈 : 깨어난 포스"};
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView=getLayoutInflater().inflate(R.layout.narindialog,null);
            }
            ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);
            final TextView mTitle = (TextView) convertView.findViewById(R.id.txtName);
            ivPoster.setLayoutParams(new LinearLayout.LayoutParams(350,400));
            ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ivPoster.setPadding(5,5,5,5);
            ivPoster.setImageResource(posterID[position]);
            mTitle.setPadding(0,0,0,45);
            mTitle.setText(movieTitle[position]);
            final int pos = position;
            ivPoster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(NarinMainActivity.this, R.layout.narindialog, null);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    //TextView mTitle = (TextView) dialogView.findViewById(R.id.txtName);
                    AlertDialog.Builder narin_dlg = new AlertDialog.Builder(NarinMainActivity.this);
                    ivPoster.setImageResource(posterID[pos]);
                    narin_dlg.setTitle(movieTitle[pos]);
                    narin_dlg.setView(dialogView);
                    narin_dlg.setNegativeButton("닫기", null);
                    narin_dlg.show();
                }
            });
            return convertView;

        }
    }
}
