package ee.eovchar.simplepaint;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Draw2D extends View
{

    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mBitmap;

    public Draw2D(Context context)
    {
        super(context);

        // Выводим значок из ресурсов
        Resources res = this.getResources();
        mBitmap = BitmapFactory.decodeResource(res, R.drawable.cat_bottom);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        // стиль Заливка
        mPaint.setStyle(Paint.Style.FILL);

        // закрашиваем холст белым цветом
        mPaint.setColor(Color.WHITE);
        canvas.drawPaint(mPaint);

        // Рисуем желтый круг
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.YELLOW);
        canvas.drawCircle(950, 30, 25, mPaint);

        // Рисуем зеленый прямоугольник
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(20, 650, 150, 680, mPaint);

        //Rusuem RED KRUG

        mPaint.setColor(Color.RED);
        canvas.drawCircle(50,50,50,mPaint);

        //BLUE KVADRAT

        mPaint.setColor(Color.BLUE);
       // left top right bottom
       // left <= right and top <= bottom
        canvas.drawRect(100,200,150,250,mPaint);

        // Рисуем текст
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(32);
        canvas.drawText("Лужайка только для котов", 30, 648, mPaint);

        // Текст под углом
        int x = 810;
        int y = 190;

        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(27);
        String str2rotate = "Лучик солнца!";

        // Создаем ограничивающий прямоугольник для наклонного текста
        // поворачиваем холст по центру текста
        canvas.rotate(-45, x + mRect.exactCenterX(), y + mRect.exactCenterY());

        // Рисуем текст
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2rotate, x, y, mPaint);

        // восстанавливаем холст
        canvas.restore();

        // Выводим изображение
        canvas.drawBitmap(mBitmap, 150, 150, mPaint);
    }
}