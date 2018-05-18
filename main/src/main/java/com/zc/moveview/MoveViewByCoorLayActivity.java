package com.zc.moveview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zc.mydemoin58.R;
import com.zc.util.ToastUtills;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MoveViewByCoorLayActivity extends AppCompatActivity {

    private Button addBtn;
    private Button saveBtn;
    private ImageView saveImg;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_view_by_coor_lay);
        addBtn = (Button) findViewById(R.id.move_btn);
        saveBtn = (Button) findViewById(R.id.move_save_btn);
        saveImg = (ImageView) findViewById(R.id.move_save_img);
        relativeLayout = (RelativeLayout) findViewById(R.id.move_relalay);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.addView(new MoveLayout(MoveViewByCoorLayActivity.this));
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = createViewBitmap(relativeLayout);
                saveBitmap(bitmap);
            }
        });
    }

    public Bitmap createViewBitmap(View v) {
        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        v.draw(canvas);
        return bitmap;
    }

    public void saveBitmap(Bitmap bm) {
        File f = new File("/sdcard/", "zc.png");
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
            ToastUtills.showToast("保存至本地成功");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
