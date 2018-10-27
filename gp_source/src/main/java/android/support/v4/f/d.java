package android.support.v4.f;

import android.os.Build.VERSION;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;

public final class d
{
  public int a;
  public int b;
  public final TextPaint c;
  public TextDirectionHeuristic d;
  
  public d(TextPaint paramTextPaint)
  {
    this.c = paramTextPaint;
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.a = 1;
      this.b = 1;
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        this.d = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        return;
      }
      this.d = null;
      return;
      this.b = 0;
      this.a = 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */