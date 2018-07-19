package com.winnie.widget.httpsimageload;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;

    private String url = "https://travel.12306.cn/imgs/resources/uploadfiles/images/a9b9c76d-36ba-4e4a-8e02-9e6a1a991da0_news_W540_H300.jpg";

    @TargetApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.image_view1);
        imageView2 = findViewById(R.id.image_view2);
        imageView3 = findViewById(R.id.image_view3);
        imageView4 = findViewById(R.id.image_view4);

        imageView5 = findViewById(R.id.area_1);
        imageView6 = findViewById(R.id.area_2);
        imageView7 = findViewById(R.id.area_3);
        imageView8 = findViewById(R.id.area_4);

//        v4.7.1使用
        Glide.with(this).load(url).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                imageView1.setImageBitmap(toRoundCorner(((BitmapDrawable) drawable).getBitmap(), 40, new int[]{1, 0, 0, 0}));
                imageView2.setImageBitmap(toRoundCorner(((BitmapDrawable) drawable).getBitmap(), 40, new int[]{0, 1, 0, 0}));
                imageView3.setImageBitmap(toRoundCorner(((BitmapDrawable) drawable).getBitmap(), 40, new int[]{0, 0, 1, 0}));
                imageView4.setImageBitmap(toRoundCorner(((BitmapDrawable) drawable).getBitmap(), 40, new int[]{0, 0, 0, 1}));
            }
        });


//        v3.7.0使用
//        Glide.with(this).load(url).into(imageView1);
//        Glide.with(this).load(url).into(imageView2);
//        Glide.with(this).load(url).into(imageView3);
//        Glide.with(this).load(url).into(imageView4);

        Glide.with(this).load(url).into(imageView5);
        Glide.with(this).load(url).into(imageView6);
        Glide.with(this).load(url).into(imageView7);
        Glide.with(this).load(url).into(imageView8);
    }

    /**
     * 把图片变成圆角
     *
     * @param drawable 需要修改的图片
     * @param pixels   圆角的弧度
     * @return 圆角图片
     */
    public static Bitmap toRoundCorner(Drawable drawable, int pixels) {

        Bitmap output = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, drawable.getIntrinsicHeight(), drawable.getIntrinsicHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(((BitmapDrawable) drawable).getBitmap(), rect, rect, paint);

        return output;
    }

    /**
     * 把图片变成圆角
     *
     * @param bitmap 需要修改的图片
     * @param pixels 圆角的弧度
     * @return 圆角图片
     */
    public static Bitmap toRoundCorner(Bitmap bitmap, int pixels, int[] corners) {

        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);

        //先画一个圆角矩形将图片显示为圆角
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        //哪个角不是圆角我再把你用矩形画出来
        if (corners.length > 0) {
            if (corners[0] == 0) {
                canvas.drawRect(0, 0, roundPx, roundPx, paint);
            }
        }
        if (corners.length > 1) {
            if (corners[1] == 0) {
                canvas.drawRect(rectF.right - roundPx, 0, rectF.right, roundPx, paint);
            }
        }

        if (corners.length > 2) {
            if (corners[2] == 0) {
                canvas.drawRect(0, rectF.bottom - roundPx, roundPx, rectF.bottom, paint);
            }
        }

        if (corners.length > 3) {
            if (corners[3] == 0) {
                canvas.drawRect(rectF.right - roundPx, rectF.bottom - roundPx, rectF.right, rectF.bottom, paint);
            }
        }


        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }
}
