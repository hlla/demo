package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class bc
{
  private static final RectF i = new RectF();
  private static ConcurrentHashMap l = new ConcurrentHashMap();
  public float a = -1.0F;
  public float b = -1.0F;
  public float c = -1.0F;
  public int[] d = new int[0];
  public int e = 0;
  public final Context f;
  public boolean g = false;
  public boolean h = false;
  private TextPaint j;
  private final TextView k;
  
  bc(TextView paramTextView)
  {
    this.k = paramTextView;
    this.f = this.k.getContext();
  }
  
  private static Object a(Object paramObject1, String paramString, Object paramObject2)
  {
    try
    {
      paramObject1 = a(paramString).invoke(paramObject1, new Object[0]);
      if (paramObject1 != null) {}
      return paramObject1;
    }
    catch (Exception paramObject1)
    {
      paramObject1 = paramObject1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to invoke TextView#");
      localStringBuilder.append(paramString);
      localStringBuilder.append("() method");
      Log.w("ACTVAutoSizeHelper", localStringBuilder.toString(), (Throwable)paramObject1);
      return paramObject2;
    }
    finally {}
  }
  
  private static Method a(String paramString)
  {
    try
    {
      localObject2 = (Method)l.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          ((Method)localObject2).setAccessible(true);
          l.put(paramString, localObject2);
          localObject1 = localObject2;
        }
      }
      return (Method)localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Failed to retrieve TextView#");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("() method");
      Log.w("ACTVAutoSizeHelper", ((StringBuilder)localObject2).toString(), localException);
    }
    return null;
  }
  
  static int[] a(int[] paramArrayOfInt)
  {
    int n = paramArrayOfInt.length;
    Object localObject = paramArrayOfInt;
    if (n != 0)
    {
      Arrays.sort(paramArrayOfInt);
      ArrayList localArrayList = new ArrayList();
      int m = 0;
      if (m < n)
      {
        int i1 = paramArrayOfInt[m];
        if (i1 > 0)
        {
          localObject = Integer.valueOf(i1);
          if (Collections.binarySearch(localArrayList, localObject) < 0) {
            break label61;
          }
        }
        for (;;)
        {
          m += 1;
          break;
          label61:
          localArrayList.add(localObject);
        }
      }
      localObject = paramArrayOfInt;
      if (n != localArrayList.size())
      {
        n = localArrayList.size();
        paramArrayOfInt = new int[n];
        m = 0;
        for (;;)
        {
          localObject = paramArrayOfInt;
          if (m >= n) {
            break;
          }
          paramArrayOfInt[m] = ((Integer)localArrayList.get(m)).intValue();
          m += 1;
        }
      }
    }
    return (int[])localObject;
  }
  
  final void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    StringBuilder localStringBuilder;
    if (paramFloat1 <= 0.0F)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Minimum auto-size text size (");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append("px) is less or equal to (0px)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    if (paramFloat2 <= paramFloat1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Maximum auto-size text size (");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("px) is less or equal to minimum auto-size ");
      localStringBuilder.append("text size (");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append("px)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    if (paramFloat3 <= 0.0F)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("The auto-size step granularity (");
      localStringBuilder.append(paramFloat3);
      localStringBuilder.append("px) is less or equal to (0px)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.e = 1;
    this.b = paramFloat1;
    this.a = paramFloat2;
    this.c = paramFloat3;
    this.g = false;
  }
  
  final void a(int paramInt, float paramFloat)
  {
    Object localObject = this.f;
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
      if (paramFloat != this.k.getPaint().getTextSize())
      {
        this.k.getPaint().setTextSize(paramFloat);
        if (Build.VERSION.SDK_INT < 18) {
          break label139;
        }
      }
      label139:
      for (boolean bool = this.k.isInLayout();; bool = false)
      {
        if (this.k.getLayout() != null) {
          this.h = false;
        }
        try
        {
          localObject = a("nullLayouts");
          if (localObject != null) {
            ((Method)localObject).invoke(this.k, new Object[0]);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", localException);
          }
        }
        if (bool) {
          this.k.forceLayout();
        }
        for (;;)
        {
          this.k.invalidate();
          return;
          this.k.requestLayout();
        }
      }
    }
  }
  
  final boolean a()
  {
    int[] arrayOfInt = this.d;
    int m = arrayOfInt.length;
    if (m > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.g = bool;
      bool = this.g;
      if (bool)
      {
        this.e = 1;
        this.b = arrayOfInt[0];
        this.a = arrayOfInt[(m - 1)];
        this.c = -1.0F;
      }
      return bool;
    }
  }
  
  final boolean b()
  {
    if ((e()) && (this.e == 1)) {
      if ((!this.g) || (this.d.length == 0))
      {
        float f1 = Math.round(this.b);
        int m = 1;
        while (Math.round(this.c + f1) <= Math.round(this.a))
        {
          m += 1;
          f1 += this.c;
        }
        int[] arrayOfInt = new int[m];
        f1 = this.b;
        int n = 0;
        while (n < m)
        {
          arrayOfInt[n] = Math.round(f1);
          f1 += this.c;
          n += 1;
        }
        this.d = a(arrayOfInt);
      }
    }
    for (this.h = true;; this.h = false) {
      return this.h;
    }
  }
  
  final void c()
  {
    if (d()) {
      if (this.h)
      {
        if ((this.k.getMeasuredHeight() <= 0) || (this.k.getMeasuredWidth() <= 0)) {
          break label625;
        }
        if (((Boolean)a(this.k, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue()) {
          break label681;
        }
      }
    }
    label596:
    label625:
    label635:
    label646:
    label655:
    label668:
    label675:
    label678:
    label681:
    for (int m = this.k.getMeasuredWidth() - this.k.getTotalPaddingLeft() - this.k.getTotalPaddingRight();; m = 1048576)
    {
      int n = this.k.getHeight() - this.k.getCompoundPaddingBottom() - this.k.getCompoundPaddingTop();
      if ((m > 0) && (n > 0)) {}
      for (;;)
      {
        int i1;
        int i3;
        Object localObject3;
        int i2;
        synchronized (i)
        {
          i.setEmpty();
          i.right = m;
          i.bottom = n;
          RectF localRectF2 = i;
          m = this.d.length;
          if (m == 0) {
            break label635;
          }
          i1 = m - 1;
          n = 0;
          m = 1;
          if (m > i1) {
            break label596;
          }
          i3 = (m + i1) / 2;
          n = this.d[i3];
          Object localObject1 = this.k.getText();
          localObject3 = this.k.getTransformationMethod();
          if (localObject3 == null) {
            break label678;
          }
          localObject3 = ((TransformationMethod)localObject3).getTransformation((CharSequence)localObject1, this.k);
          if (localObject3 == null) {
            break label675;
          }
          localObject1 = localObject3;
          i2 = this.k.getMaxLines();
          localObject3 = this.j;
          if (localObject3 == null)
          {
            this.j = new TextPaint();
            this.j.set(this.k.getPaint());
            this.j.setTextSize(n);
            Object localObject4 = (Layout.Alignment)a(this.k, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
            if (Build.VERSION.SDK_INT >= 23)
            {
              n = Math.round(localRectF2.right);
              localObject3 = (TextDirectionHeuristic)a(this.k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
              localObject4 = StaticLayout.Builder.obtain((CharSequence)localObject1, 0, ((CharSequence)localObject1).length(), this.j, n).setAlignment((Layout.Alignment)localObject4).setLineSpacing(this.k.getLineSpacingExtra(), this.k.getLineSpacingMultiplier()).setIncludePad(this.k.getIncludeFontPadding()).setBreakStrategy(this.k.getBreakStrategy()).setHyphenationFrequency(this.k.getHyphenationFrequency());
              if (i2 != -1) {
                break label668;
              }
              n = Integer.MAX_VALUE;
              localObject3 = ((StaticLayout.Builder)localObject4).setMaxLines(n).setTextDirection((TextDirectionHeuristic)localObject3).build();
              break label646;
              if (((StaticLayout)localObject3).getHeight() > localRectF2.bottom) {
                break label655;
              }
              i2 = i3 + 1;
              n = m;
              m = i2;
              continue;
              if ((((StaticLayout)localObject3).getLineCount() > i2) || (((StaticLayout)localObject3).getLineEnd(((StaticLayout)localObject3).getLineCount() - 1) != ((CharSequence)localObject1).length())) {
                break label655;
              }
              continue;
            }
            else
            {
              n = Math.round(localRectF2.right);
              f1 = this.k.getLineSpacingMultiplier();
              float f2 = this.k.getLineSpacingExtra();
              boolean bool = this.k.getIncludeFontPadding();
              localObject3 = new StaticLayout((CharSequence)localObject1, this.j, n, (Layout.Alignment)localObject4, f1, f2, bool);
            }
          }
        }
        ((TextPaint)localObject3).reset();
        continue;
        float f1 = this.d[n];
        if (f1 == this.k.getTextSize()) {}
        for (;;)
        {
          this.h = true;
          return;
          a(0, f1);
        }
        throw new IllegalStateException("No available text sizes to choose from.");
        if (i2 == -1)
        {
          continue;
          n = i3 - 1;
          i1 = n;
          continue;
          n = i2;
          continue;
        }
      }
    }
  }
  
  final boolean d()
  {
    return (e()) && (this.e != 0);
  }
  
  final boolean e()
  {
    return this.k instanceof AppCompatEditText ^ true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */