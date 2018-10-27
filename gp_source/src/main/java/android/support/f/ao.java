package android.support.f;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

final class ao
{
  private static final boolean a;
  private static final boolean b;
  private static final boolean c;
  
  static
  {
    boolean bool2 = true;
    if (Build.VERSION.SDK_INT >= 19) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a = bool1;
      if (Build.VERSION.SDK_INT >= 18) {}
      for (bool1 = true;; bool1 = false)
      {
        b = bool1;
        if (Build.VERSION.SDK_INT >= 28) {}
        for (bool1 = bool2;; bool1 = false)
        {
          c = bool1;
          return;
        }
      }
    }
  }
  
  static View a(ViewGroup paramViewGroup, View paramView1, View paramView2)
  {
    Object localObject = new Matrix();
    ((Matrix)localObject).setTranslate(-paramView2.getScrollX(), -paramView2.getScrollY());
    ba.a.a(paramView1, (Matrix)localObject);
    ba.a.b(paramViewGroup, (Matrix)localObject);
    paramView2 = new RectF(0.0F, 0.0F, paramView1.getWidth(), paramView1.getHeight());
    ((Matrix)localObject).mapRect(paramView2);
    int k = Math.round(paramView2.left);
    int m = Math.round(paramView2.top);
    int n = Math.round(paramView2.right);
    int i1 = Math.round(paramView2.bottom);
    ImageView localImageView = new ImageView(paramView1.getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    boolean bool2;
    boolean bool1;
    if (a)
    {
      bool2 = paramView1.isAttachedToWindow();
      if (paramViewGroup != null) {
        bool1 = paramViewGroup.isAttachedToWindow();
      }
    }
    for (int j = bool2 ^ true;; j = 0)
    {
      ViewGroup localViewGroup;
      int i;
      int i3;
      int i2;
      if (!b)
      {
        localViewGroup = null;
        i = 0;
        i3 = Math.round(paramView2.width());
        i2 = Math.round(paramView2.height());
        if (i3 <= 0)
        {
          paramView2 = null;
          label193:
          if (!b) {
            localObject = paramView2;
          }
        }
      }
      for (;;)
      {
        if (localObject != null) {
          localImageView.setImageBitmap((Bitmap)localObject);
        }
        localImageView.measure(View.MeasureSpec.makeMeasureSpec(n - k, 1073741824), View.MeasureSpec.makeMeasureSpec(i1 - m, 1073741824));
        localImageView.layout(k, m, n, i1);
        return localImageView;
        localObject = paramView2;
        if (j != 0)
        {
          paramViewGroup.getOverlay().remove(paramView1);
          localViewGroup.addView(paramView1, i);
          localObject = paramView2;
          continue;
          if (i2 > 0)
          {
            float f = Math.min(1.0F, 1048576.0F / (i3 * i2));
            i3 = Math.round(i3 * f);
            i2 = Math.round(i2 * f);
            ((Matrix)localObject).postTranslate(-paramView2.left, -paramView2.top);
            ((Matrix)localObject).postScale(f, f);
            if (c)
            {
              paramView2 = new Picture();
              localCanvas = paramView2.beginRecording(i3, i2);
              localCanvas.concat((Matrix)localObject);
              paramView1.draw(localCanvas);
              paramView2.endRecording();
              paramView2 = Bitmap.createBitmap(paramView2);
              break label193;
            }
            paramView2 = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
            Canvas localCanvas = new Canvas(paramView2);
            localCanvas.concat((Matrix)localObject);
            paramView1.draw(localCanvas);
            break label193;
          }
          paramView2 = null;
          break label193;
          if (j == 0)
          {
            localViewGroup = null;
            i = 0;
            break;
          }
          if (bool1)
          {
            localViewGroup = (ViewGroup)paramView1.getParent();
            i = localViewGroup.indexOfChild(paramView1);
            paramViewGroup.getOverlay().add(paramView1);
            break;
          }
          localObject = null;
        }
      }
      bool1 = false;
      break;
      bool1 = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */