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

public class MainActivity extends AppCompatActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;

    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;

    private String url = "https://rms.test.zbjdev.com/resource/redirect?key=mobile/newwap/88%E5%93%81%E7%89%8C%E8%90%A5%E9%94%80%E4%B8%93%E5%9C%BAbanner.png/origine/8f0e9d3b-70cc-4111-81fd-3ccb42b01ab5";
    private String url1 = "https://omleweu0n.qnssl.com/mobile%2Fnewwap%2F88%E5%93%81%E7%89%8C%E8%90%A5%E9%94%80%E4%B8%93%E5%9C%BAbanner.png%2Forigine%2F8f0e9d3b-70cc-4111-81fd-3ccb42b01ab5";
    String urlImg1 = "https://bgl.zbjimg.com/bgl%2Fbjclound%2Fpic-%E5%A4%A9%E5%A4%A9%E7%89%B9%E6%83%A0.png%2Forigine%2F4bb25bf9-bc9c-4f31-b53f-5c0ee4ef0756?imageMogr2/auto-orient/strip/quality/90";
    String urlImg2 = "https://bgl.zbjimg.com/bgl%2Fbjclound%2Fpic-%E7%83%AD%E5%8D%96%E6%A6%9C%E5%8D%95.png%2Forigine%2Ff88f0e15-bff1-4fd1-a1ed-adb4b78cbc7d?imageMogr2/auto-orient/strip/quality/90";
    String urlImg3 = "https://bgl.zbjimg.com/bgl%2Fbjclound%2Fpic-%E9%A1%BE%E9%97%AE%E5%92%A8%E8%AF%A2.png%2Forigine%2Fd3864440-e0b3-4ae2-8b8b-f4af217c072f?imageMogr2/auto-orient/strip/quality/90";
    String urlImg4 = "https://bgl.zbjimg.com/bgl%2Fbjclound%2Fpic-%E9%99%84%E8%BF%91%E4%BA%BA%E6%89%8D.png%2Forigine%2Fa780f0a2-7ffe-415f-b49c-b0d70e0d9091?imageMogr2/auto-orient/strip/quality/90";


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

//        ZbjImageCache.getInstance().downloadImage(imageView, url, -1);
//        Glide.with(this).load(url).into(new SimpleTarget<Drawable>() {
//            @Override
//            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
//                imageView1.setImageBitmap(toRoundCorner(((BitmapDrawable) drawable).getBitmap(), 40, new int[]{1, 0, 0, 0}));
//                imageView2.setImageBitmap(toRoundCorner(((BitmapDrawable) drawable).getBitmap(), 40, new int[]{0, 1, 0, 0}));
//            }
//        });
//
//        Glide.with(this).load(url1).into(new SimpleTarget<Drawable>() {
//            @Override
//            public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
//                imageView3.setImageBitmap(toRoundCorner(((BitmapDrawable) drawable).getBitmap(), 40, new int[]{0, 0, 1, 0}));
//                imageView4.setImageBitmap(toRoundCorner(((BitmapDrawable) drawable).getBitmap(), 40, new int[]{0, 0, 0, 1}));
//            }
//        });

        Glide.with(this).load(url).into(imageView1);
        Glide.with(this).load(url).into(imageView2);
        Glide.with(this).load(url1).into(imageView3);
        Glide.with(this).load(url1).into(imageView4);

        Glide.with(this).load(urlImg1).into(imageView5);
        Glide.with(this).load(urlImg2).into(imageView6);
        Glide.with(this).load(urlImg3).into(imageView7);
        Glide.with(this).load(urlImg4).into(imageView8);
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
