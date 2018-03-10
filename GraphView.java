package cz.ales.training;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ales on 6.3.18.
 */

public class GraphView extends View {


    public GraphView(Context context) {
        super(context);
    }

    public GraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GraphView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();

        float graphSizeX = getWidth();
        float graphSizeY = getHeight();
        float borderX = 50;
        float borderY = 50;

        drawBackground(paint, canvas);
        drawAxes(paint, canvas, graphSizeX, graphSizeY, borderX, borderY);
    }



    private void drawBackground(Paint paint, Canvas canvas) {
        paint.setColor(Color.LTGRAY); //bílé pozadí
        canvas.drawPaint(paint);
    }

    private void drawAxes(Paint paint, Canvas canvas, float sizeX, float sizeY, float borderX, float borderY) {
        float overlapX = 150;
        float overlapY = 100;
        paint.setColor(Color.DKGRAY);
        paint.setStrokeWidth(10);
        paint.setStrokeCap(Paint.Cap.ROUND);

        //y axis
        canvas.drawLine(borderX+overlapX, sizeY-borderY, borderX+overlapX, borderY, paint);

        //x
        canvas.drawLine(borderX, sizeY-borderY-overlapY, sizeX-borderX, sizeY-borderY-overlapY, paint);
    }
}
