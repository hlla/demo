package com.tencent.mm.ui.widget.celltextview.f;

import android.graphics.Paint;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.Stack;

public final class b
  implements a
{
  private static float[] wwY;
  private Paint fu;
  private float wwZ;
  
  static
  {
    GMTrace.i(18761893543936L, 139787);
    wwY = new float[26];
    GMTrace.o(18761893543936L, 139787);
  }
  
  public b()
  {
    GMTrace.i(18761356673024L, 139783);
    GMTrace.o(18761356673024L, 139783);
  }
  
  private static int da(String paramString, int paramInt)
  {
    GMTrace.i(18761759326208L, 139786);
    int i = paramInt - 1;
    char[] arrayOfChar = com.tencent.mm.ui.widget.celltextview.g.a.V(paramString, i, i + 1 + 1);
    if ((com.tencent.mm.ui.widget.celltextview.g.a.l(arrayOfChar[0])) && (com.tencent.mm.ui.widget.celltextview.g.a.l(arrayOfChar[1])))
    {
      paramInt = com.tencent.mm.ui.widget.celltextview.g.a.db(paramString, i);
      GMTrace.o(18761759326208L, 139786);
      return paramInt;
    }
    GMTrace.o(18761759326208L, 139786);
    return paramInt;
  }
  
  public final com.tencent.mm.ui.widget.celltextview.c.a a(d paramd, Paint paramPaint, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(18761490890752L, 139784);
    if (!paramd.caN())
    {
      paramd = new com.tencent.mm.ui.widget.celltextview.c.a(paramd.getLength(), paramd.getWidth());
      GMTrace.o(18761490890752L, 139784);
      return paramd;
    }
    this.fu = paramPaint;
    int n = paramd.getText().indexOf('\n');
    int j;
    String str;
    label76:
    int k;
    int i;
    label91:
    int i1;
    float f1;
    Stack localStack;
    label142:
    float f2;
    char c;
    label208:
    int m;
    if (n >= 0)
    {
      j = 1;
      if (j != 0) {
        break label601;
      }
      str = paramd.getText();
      k = str.length();
      if (j == 0) {
        break label618;
      }
      i = 1;
      i1 = k - i;
      f1 = -2.14748365E9F;
      localStack = new Stack();
      k = 0;
      if (k >= i1) {
        break label918;
      }
      i = 25;
      if (k + 25 < i1) {
        break label624;
      }
      i = i1 - k;
      int i2 = paramd.a(k, i, wwY);
      f2 = f1;
      if (f1 == -2.14748365E9F)
      {
        if (!com.tencent.mm.ui.widget.celltextview.g.a.n(str.charAt(0))) {
          break label649;
        }
        c = str.charAt(0);
        b(this.fu);
        f2 = -com.tencent.mm.ui.widget.celltextview.g.a.b(c, this.fu);
      }
      m = 0;
      f1 = f2;
      label215:
      if (m >= i2) {
        break label908;
      }
      f1 = wwY[m] + f1;
      localStack.push(Float.valueOf(f1));
      f2 = f1 - paramInt1;
      if (f2 <= 0.0F) {
        break label899;
      }
      i = m + k;
      c = com.tencent.mm.ui.widget.celltextview.g.a.cZ(str, i);
      if (!com.tencent.mm.ui.widget.celltextview.g.a.m(c)) {
        break label655;
      }
      b(this.fu);
      f2 -= com.tencent.mm.ui.widget.celltextview.g.a.a(c, this.fu);
      label305:
      if (localStack.size() > 0) {
        localStack.pop();
      }
      if ((f2 <= b(paramPaint)) || (!com.tencent.mm.ui.widget.celltextview.g.a.m(com.tencent.mm.ui.widget.celltextview.g.a.cZ(str, i - 1)))) {
        break label658;
      }
      f2 = ((Float)localStack.pop()).floatValue();
      c = com.tencent.mm.ui.widget.celltextview.g.a.cZ(str, i - 1);
      b(this.fu);
      localStack.push(Float.valueOf(f2 - com.tencent.mm.ui.widget.celltextview.g.a.a(c, this.fu)));
      paramInt1 = i;
    }
    for (;;)
    {
      label402:
      f2 = paramInt2;
      i = paramInt1 - 1;
      paramd = com.tencent.mm.ui.widget.celltextview.g.a.V(str, i + 1, i + 2 + 1);
      paramBoolean = com.tencent.mm.ui.widget.celltextview.g.a.o(paramd[1]);
      boolean bool = com.tencent.mm.ui.widget.celltextview.g.a.o(paramd[0]);
      v.i("MicroMsg.NewBreakText", "[isBreakPunc] [%s:%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
      if ((bool) && (!paramBoolean))
      {
        paramInt2 = com.tencent.mm.ui.widget.celltextview.g.a.dc(str, i);
        if (paramInt2 > 1) {
          paramInt2 = da(str, paramInt2 - 1);
        }
      }
      for (;;)
      {
        i = da(str, paramInt2);
        paramInt2 = paramInt1 - i;
        if (paramInt2 >= 0) {
          break label1048;
        }
        localStack.push(Float.valueOf(f1));
        label538:
        f1 = 0.0F;
        if (localStack.size() > 0) {
          f1 = ((Float)localStack.peek()).floatValue();
        }
        if (n != i) {
          break label894;
        }
        paramInt1 = 1;
        label571:
        paramd = new com.tencent.mm.ui.widget.celltextview.c.a(paramInt1 + i, f1);
        GMTrace.o(18761490890752L, 139784);
        return paramd;
        j = 0;
        break;
        label601:
        str = paramd.getText().substring(0, n + 1);
        break label76;
        label618:
        i = 0;
        break label91;
        label624:
        if (!Character.isHighSurrogate(str.charAt(k + 25 - 1))) {
          break label142;
        }
        i = 26;
        break label142;
        label649:
        f2 = 0.0F;
        break label208;
        label655:
        break label305;
        label658:
        if (f2 > b(paramPaint)) {
          break label1051;
        }
        i += 1;
        f1 = f2 + paramInt1;
        localStack.push(Float.valueOf(f1));
        paramInt1 = i;
        break label402;
        paramInt2 = paramInt1;
        continue;
        if ((bool) && (paramBoolean))
        {
          paramInt2 = com.tencent.mm.ui.widget.celltextview.g.a.dc(str, i);
          if (paramInt2 > 0)
          {
            i = com.tencent.mm.ui.widget.celltextview.g.a.dd(str, i + 2);
            paramd = str.substring(da(str, paramInt2 - 1), i + 1);
            if (this.fu.measureText(paramd) <= f2) {
              paramInt2 -= 1;
            }
          }
          else
          {
            paramInt2 = paramInt1;
            continue;
          }
        }
        paramInt2 = paramInt1;
      }
      label894:
      label899:
      label908:
      label918:
      label1048:
      for (;;)
      {
        if ((localStack.size() > 0) && (paramInt2 > 0))
        {
          localStack.pop();
          paramInt2 -= 1;
        }
        else
        {
          c = com.tencent.mm.ui.widget.celltextview.g.a.cZ(str, i - 1);
          if ((paramInt1 - i <= 0) || (!com.tencent.mm.ui.widget.celltextview.g.a.m(c))) {
            break label538;
          }
          f1 = ((Float)localStack.pop()).floatValue();
          b(this.fu);
          localStack.push(Float.valueOf(f1 - com.tencent.mm.ui.widget.celltextview.g.a.a(c, this.fu)));
          break label538;
          paramInt1 = 0;
          break label571;
          m += 1;
          break label215;
          k = i + k;
          break;
          if ((!paramBoolean) && (com.tencent.mm.ui.widget.celltextview.g.a.m(com.tencent.mm.ui.widget.celltextview.g.a.cZ(str, i1 - 1))))
          {
            c = com.tencent.mm.ui.widget.celltextview.g.a.cZ(str, i1 - 1);
            b(this.fu);
            f1 -= com.tencent.mm.ui.widget.celltextview.g.a.a(c, this.fu);
          }
          for (;;)
          {
            if (j != 0) {}
            for (paramInt2 = 1;; paramInt2 = 0)
            {
              i = paramInt2 + i1;
              paramInt2 = i;
              if (i == 0)
              {
                paramInt2 = 0;
                f1 = paramInt1;
              }
              f2 = f1;
              if (f1 < 0.0F) {
                f2 = 0.0F;
              }
              paramd = new com.tencent.mm.ui.widget.celltextview.c.a(paramInt2, f2);
              GMTrace.o(18761490890752L, 139784);
              return paramd;
            }
          }
        }
      }
      label1051:
      paramInt1 = i;
    }
  }
  
  public final float b(Paint paramPaint)
  {
    GMTrace.i(18761625108480L, 139785);
    if (0.0F == this.wwZ) {
      this.wwZ = paramPaint.measureText("A");
    }
    float f = this.wwZ;
    GMTrace.o(18761625108480L, 139785);
    return f;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */