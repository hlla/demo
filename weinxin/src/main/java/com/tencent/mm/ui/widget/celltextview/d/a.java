package com.tencent.mm.ui.widget.celltextview.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.View.MeasureSpec;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.celltextview.b.a.b;
import com.tencent.mm.ui.widget.celltextview.c.c;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements com.tencent.mm.ui.widget.celltextview.b.a.a
{
  private int PN;
  private int el;
  private int em;
  private int iO;
  private TextPaint jsW;
  private Context mContext;
  private float mFg;
  private int vnI;
  private String wvV;
  private int wvW;
  private int wvX;
  private ArrayList<d> wvY;
  private LinkedList<com.tencent.mm.ui.widget.celltextview.c.b> wvZ;
  private int wwA;
  private int wwB;
  private int wwC;
  private float wwD;
  private boolean wwE;
  private CharSequence wwF;
  private int wwG;
  private int wwH;
  private int wwI;
  private int wwJ;
  private int wwK;
  private boolean wwL;
  private Drawable wwM;
  private int wwN;
  private LinkedList<a> wwO;
  private LinkedList<a> wwP;
  private com.tencent.mm.ui.widget.celltextview.c.b wwQ;
  private int wwR;
  private ArrayList<c> wwe;
  private float wwf;
  private a.b wwy;
  private com.tencent.mm.ui.widget.celltextview.f.a wwz;
  private int xT;
  
  public a(Context paramContext, TextPaint paramTextPaint)
  {
    GMTrace.i(18745250545664L, 139663);
    this.xT = -16777216;
    this.wwA = Integer.MAX_VALUE;
    this.wwE = true;
    this.wwK = -16776961;
    this.wwL = true;
    this.mContext = paramContext;
    this.wwe = new ArrayList();
    this.wwz = new com.tencent.mm.ui.widget.celltextview.f.b();
    this.mFg = com.tencent.mm.ui.widget.celltextview.g.b.f(paramContext, 14.0F);
    this.wwJ = ((int)com.tencent.mm.ui.widget.celltextview.g.b.f(paramContext, 6.0F));
    this.jsW = paramTextPaint;
    this.jsW.setColor(this.xT);
    this.jsW.setTextSize(this.mFg);
    GMTrace.o(18745250545664L, 139663);
  }
  
  private void Cw(int paramInt)
  {
    GMTrace.i(18749142859776L, 139692);
    if ((this.wvY == null) || (this.wvY.size() == 0))
    {
      GMTrace.o(18749142859776L, 139692);
      return;
    }
    this.wwe.clear();
    c localc = caS();
    int i = 0;
    d locald;
    Object localObject2;
    if (i < this.wvY.size())
    {
      locald = (d)this.wvY.get(i);
      locald.caQ();
      localObject2 = locald;
      label85:
      if ((localObject2 != null) && (!TextUtils.isEmpty(((d)localObject2).getText()))) {
        if ((this.wwA <= 0) || (this.wwA >= this.wwe.size())) {}
      }
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        Cx(paramInt);
      }
      GMTrace.o(18749142859776L, 139692);
      return;
      int j = paramInt - this.wwR;
      Object localObject1 = this.wwz;
      TextPaint localTextPaint = this.jsW;
      boolean bool;
      label181:
      float f1;
      int k;
      float f2;
      if (i < this.wvY.size() - 1)
      {
        bool = true;
        localObject1 = ((com.tencent.mm.ui.widget.celltextview.f.a)localObject1).a((d)localObject2, localTextPaint, j, paramInt, bool);
        f1 = this.wwz.b(this.jsW);
        k = ((com.tencent.mm.ui.widget.celltextview.c.a)localObject1).wwk;
        f2 = ((com.tencent.mm.ui.widget.celltextview.c.a)localObject1).width;
        localObject1 = localObject2;
        if (k > 0)
        {
          if ((((d)localObject2).caN()) || (f2 <= j) || (f2 - j <= f1)) {
            break label312;
          }
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        if ((localObject1 != null) || (cZ(locald.getText(), locald.getText().length() - 1) != '\n')) {
          break label459;
        }
        localc = caS();
        localObject2 = localObject1;
        break;
        bool = false;
        break label181;
        label312:
        localObject1 = ((d)localObject2).caP();
        ((d)localObject1).v(0, k, null);
        f1 = 0.0F;
        j = 0;
        while (j < this.wwe.size() - 1)
        {
          f1 += ((c)this.wwe.get(j)).wwq;
          j += 1;
        }
        localc.a((d)localObject1, new RectF(this.wwR, f1, this.wwR + f2, ((d)localObject1).Cv(this.wwJ) + f1));
        this.wwR = ((int)(this.wwR + f2));
        if (k >= ((d)localObject2).getLength())
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = ((d)localObject2).caP();
          ((d)localObject1).v(k, -1, null);
        }
      }
      label459:
      localObject2 = localObject1;
      if (localObject1 == null) {
        break label85;
      }
      localc = caS();
      localObject2 = localObject1;
      break label85;
      i += 1;
      break;
      caT();
    }
  }
  
  private void Cx(int paramInt)
  {
    GMTrace.i(18749411295232L, 139694);
    if (this.wwe.size() < 2) {
      caS();
    }
    c localc = (c)this.wwe.get(this.wwe.size() - 2);
    float f1 = this.jsW.measureText("...", 0, 3);
    this.wwR = 0;
    int k = localc.getSize();
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (i < k)
    {
      localObject1 = localc.Ct(i);
      int m = (int)(paramInt - f1 - this.wwR);
      if (m <= 0)
      {
        GMTrace.o(18749411295232L, 139694);
        return;
      }
      localObject2 = this.wwz;
      TextPaint localTextPaint = this.jsW;
      if (i < k - 1) {}
      int j;
      for (boolean bool = true;; bool = false)
      {
        localObject2 = ((com.tencent.mm.ui.widget.celltextview.f.a)localObject2).a((d)localObject1, localTextPaint, m, paramInt, bool);
        j = ((com.tencent.mm.ui.widget.celltextview.c.a)localObject2).wwk;
        float f2 = localc.Cu(i).width();
        if (f2 > m) {
          break label210;
        }
        this.wwR = ((int)(this.wwR + f2));
        i += 1;
        break;
      }
      label210:
      if (((d)localObject1).caN())
      {
        paramInt = j;
        if (cZ(((d)localObject1).getText(), j - 1) == '\n') {
          paramInt = j - 1;
        }
        ((d)localObject1).v(0, paramInt, "...");
        localc.Ej(i + 1);
        this.wwR = ((int)(this.wwR + ((com.tencent.mm.ui.widget.celltextview.c.a)localObject2).width));
        paramInt = 1;
      }
    }
    for (;;)
    {
      this.wwR += (int)f1;
      i = paramInt;
      if (this.wwe.size() == 2)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          i = paramInt;
          if (((c)this.wwe.get(1)).Ct(0) == null)
          {
            localObject1 = localc.Ct(localc.getSize() - 1);
            i = paramInt;
            if (localObject1 != null)
            {
              i = paramInt;
              if (((d)localObject1).caN())
              {
                ((d)localObject1).v(0, -1, "...");
                i = 1;
              }
            }
          }
        }
      }
      if (this.wwR > this.wwf) {}
      for (f1 = this.wwR;; f1 = this.wwf)
      {
        this.wwf = f1;
        if (i == 0) {
          break label435;
        }
        GMTrace.o(18749411295232L, 139694);
        return;
        localc.Ej(i);
        paramInt = 0;
        break;
      }
      label435:
      localObject1 = new RectF(localc.Cu(localc.getSize() - 1));
      localObject2 = localc.Ct(localc.getSize() - 1);
      if ((((d)localObject2).caN()) && (((d)localObject2).getText().endsWith("\n"))) {
        ((d)localObject2).v(0, ((d)localObject2).getText().length() - 1, null);
      }
      ((RectF)localObject1).left = ((RectF)localObject1).right;
      ((RectF)localObject1).right = this.wwR;
      localc.a(new d(this.jsW, 0, "...", this.mFg), (RectF)localObject1);
      GMTrace.o(18749411295232L, 139694);
      return;
      paramInt = 0;
    }
  }
  
  private int aB(LinkedList<a> paramLinkedList)
  {
    GMTrace.i(18749948166144L, 139698);
    if ((paramLinkedList == null) || (paramLinkedList.isEmpty()))
    {
      GMTrace.o(18749948166144L, 139698);
      return 0;
    }
    paramLinkedList = paramLinkedList.iterator();
    for (int i = 0; paramLinkedList.hasNext(); i = ((a)paramLinkedList.next()).wwT.width() + this.vnI + i) {}
    GMTrace.o(18749948166144L, 139698);
    return i;
  }
  
  private static char cZ(String paramString, int paramInt)
  {
    GMTrace.i(18749813948416L, 139697);
    if ((paramInt >= 0) && (paramString != null) && (paramInt < paramString.length()))
    {
      char c = paramString.charAt(paramInt);
      GMTrace.o(18749813948416L, 139697);
      return c;
    }
    GMTrace.o(18749813948416L, 139697);
    return '\000';
  }
  
  private int caR()
  {
    GMTrace.i(18749277077504L, 139693);
    Iterator localIterator = this.wwe.iterator();
    c localc;
    float f;
    for (int i = 0; localIterator.hasNext(); i = (int)(localc.wwq + f))
    {
      localc = (c)localIterator.next();
      f = i;
    }
    GMTrace.o(18749277077504L, 139693);
    return i;
  }
  
  private c caS()
  {
    GMTrace.i(18749545512960L, 139695);
    caT();
    this.wwR = 0;
    c localc = new c();
    localc.wwq = 0.0F;
    this.wwe.add(localc);
    GMTrace.o(18749545512960L, 139695);
    return localc;
  }
  
  private void caT()
  {
    GMTrace.i(18749679730688L, 139696);
    int k = this.wwe.size() - 1;
    if (k < 0)
    {
      GMTrace.o(18749679730688L, 139696);
      return;
    }
    c localc = (c)this.wwe.get(k);
    int j = 0;
    int i = 0;
    while (j < localc.getSize())
    {
      i += localc.Ct(j).getLength();
      j += 1;
    }
    if (k == 0)
    {
      localc.et(0, i);
      GMTrace.o(18749679730688L, 139696);
      return;
    }
    j = ((c)this.wwe.get(k - 1)).wws;
    localc.et(j, j + i);
    GMTrace.o(18749679730688L, 139696);
  }
  
  public final void Co(int paramInt)
  {
    GMTrace.i(18745921634304L, 139668);
    this.wwA = paramInt;
    GMTrace.o(18745921634304L, 139668);
  }
  
  public final void Cp(int paramInt)
  {
    GMTrace.i(18745384763392L, 139664);
    int m = View.MeasureSpec.getMode(paramInt);
    int i = View.MeasureSpec.getSize(paramInt);
    paramInt = i;
    Object localObject1;
    if (i <= 0)
    {
      localObject1 = this.mContext;
      if (localObject1 == null) {
        paramInt = 0;
      }
    }
    else
    {
      i = paramInt;
      if (this.iO > 0)
      {
        i = paramInt;
        if (this.iO < paramInt) {
          i = this.iO;
        }
      }
      if ((this.PN == 0) || (this.PN <= i)) {
        break label1635;
      }
      i = this.PN;
    }
    label438:
    label627:
    label674:
    label685:
    label1021:
    label1261:
    label1478:
    label1480:
    label1623:
    label1629:
    label1635:
    for (;;)
    {
      if (!this.wwE)
      {
        v.w("CellLayout", "[measureImpl] content is not change!");
        GMTrace.o(18745384763392L, 139664);
        return;
        paramInt = ((Context)localObject1).getResources().getDisplayMetrics().widthPixels;
        break;
      }
      this.wwE = false;
      int n = aB(this.wwO) + aB(this.wwP);
      int j = i - n - this.wwG - this.wwH;
      Object localObject2;
      Object localObject3;
      float f1;
      float f2;
      int i1;
      if (this.wwL)
      {
        localObject2 = com.tencent.mm.ui.widget.celltextview.a.b.caK();
        localObject3 = this.wvY;
        localObject1 = this.wwF;
        f1 = this.mFg;
        f2 = j;
        if (localObject1 == null) {}
        for (localObject1 = "";; localObject1 = ((CharSequence)localObject1).toString())
        {
          localObject1 = new com.tencent.mm.ui.widget.celltextview.a.a((String)localObject1, f1, f2);
          ((com.tencent.mm.ui.widget.celltextview.a.a)localObject1).al((ArrayList)localObject3);
          localObject1 = (com.tencent.mm.ui.widget.celltextview.a.a)((com.tencent.mm.ui.widget.celltextview.a.b)localObject2).wwi.get(localObject1);
          if (localObject1 == null) {
            break;
          }
          localObject2 = this.wvZ;
          if ((((com.tencent.mm.ui.widget.celltextview.a.a)localObject1).wvZ != null) && (localObject2 != null))
          {
            ((LinkedList)localObject2).clear();
            ((LinkedList)localObject2).addAll(((com.tencent.mm.ui.widget.celltextview.a.a)localObject1).wvZ);
          }
          localObject2 = this.wvY;
          if ((((com.tencent.mm.ui.widget.celltextview.a.a)localObject1).wvY != null) && (localObject2 != null))
          {
            ((ArrayList)localObject2).clear();
            ((ArrayList)localObject2).addAll(((com.tencent.mm.ui.widget.celltextview.a.a)localObject1).wvY);
          }
          localObject2 = this.wwe;
          if ((((com.tencent.mm.ui.widget.celltextview.a.a)localObject1).wwe != null) && (localObject2 != null))
          {
            ((ArrayList)localObject2).clear();
            ((ArrayList)localObject2).addAll(((com.tencent.mm.ui.widget.celltextview.a.a)localObject1).wwe);
          }
          paramInt = 1;
          v.i("CellLayout", "[measureImpl] target at Cache!!!");
          this.wwC = this.wwe.size();
          i1 = caR();
          localObject1 = this.wwe.iterator();
          for (f1 = 0.0F; ((Iterator)localObject1).hasNext(); f1 = ((c)localObject2).wwp)
          {
            localObject2 = (c)((Iterator)localObject1).next();
            if (((c)localObject2).wwp <= f1) {
              break label1629;
            }
          }
        }
        v.i("CellLayout", "[measureImpl] don't target at Cache!!!");
      }
      for (;;)
      {
        paramInt = 0;
        Cw(j);
        com.tencent.mm.ui.widget.celltextview.a.b.caK().a(this.wwF, this.mFg, j, this.wvZ, this.wwe, this.wvY);
        break;
        this.wwf = Math.min(j, f1);
        float f3;
        float f4;
        if (paramInt == 0)
        {
          f3 = this.wwf;
          f4 = this.wwz.b(this.jsW);
          localObject1 = this.wwe.iterator();
          paramInt = -1;
        }
        for (;;)
        {
          int i2;
          int k;
          Object localObject4;
          Object localObject5;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (c)((Iterator)localObject1).next();
            j = paramInt + 1;
            i2 = ((c)localObject2).getSize();
            localObject3 = ((c)localObject2).Cu(i2 - 1);
            if (localObject3 == null)
            {
              f1 = 0.0F;
              f1 = f3 - f1;
              if ((f1 == 0.0F) || (Math.abs(f1) > f4)) {
                break label1623;
              }
              paramInt = -1;
              k = 0;
              if (k >= i2) {
                break label685;
              }
              localObject4 = ((c)localObject2).Ct(k);
              if (((d)localObject4).getType() != 2) {
                break label674;
              }
              paramInt += 1;
            }
            for (;;)
            {
              k += 1;
              break label627;
              f1 = ((RectF)localObject3).right;
              break;
              paramInt += ((d)localObject4).getLength();
            }
            if (paramInt == 0) {}
            for (f1 = 0.0F;; f1 /= paramInt)
            {
              f2 = 0.0F;
              paramInt = 0;
              while (paramInt < i2)
              {
                localObject4 = ((c)localObject2).Cu(paramInt);
                localObject5 = ((c)localObject2).Ct(paramInt);
                k = ((d)localObject5).getLength();
                if (((d)localObject5).getType() == 2) {
                  k = 1;
                }
                float f5 = ((RectF)localObject4).width();
                ((RectF)localObject4).left = f2;
                ((RectF)localObject4).right = (k * f1 + (f5 + f2));
                f2 += ((RectF)localObject4).width();
                paramInt += 1;
              }
            }
            ((c)localObject2).wwp = f2;
            ((c)localObject2).wwt = f1;
            if (localObject3 == null) {}
            for (f2 = 0.0F;; f2 = ((RectF)localObject3).right)
            {
              v.i("CellLayout", "[adaptLetterSpacing] line:%s size:%s letterSpacing:%s textSize:%s lineRight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i2), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
              paramInt = j;
              break;
            }
          }
          else
          {
            if (this.wvZ != null)
            {
              localObject1 = this.wvZ.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (com.tencent.mm.ui.widget.celltextview.c.b)((Iterator)localObject1).next();
                k = ((com.tencent.mm.ui.widget.celltextview.c.b)localObject2).abH;
                i2 = ((com.tencent.mm.ui.widget.celltextview.c.b)localObject2).wd;
                localObject4 = new LinkedList();
                localObject3 = new LinkedList();
                localObject5 = this.wwe.iterator();
                c localc;
                if (((Iterator)localObject5).hasNext())
                {
                  localc = (c)((Iterator)localObject5).next();
                  if ((localc.wwr > k) || (k > localc.wws)) {
                    break label1261;
                  }
                  if ((localc.wwr <= i2) && (i2 <= localc.wws)) {
                    ((LinkedList)localObject4).add(localc);
                  }
                }
                else
                {
                  localObject4 = ((LinkedList)localObject4).iterator();
                }
                for (;;)
                {
                  if (!((Iterator)localObject4).hasNext()) {
                    break label1480;
                  }
                  localObject5 = (c)((Iterator)localObject4).next();
                  v.i("CellLayout", "[getLineIndex] line:[%s:%s]", new Object[] { Integer.valueOf(((c)localObject5).wwr), Integer.valueOf(((c)localObject5).wws) });
                  j = ((c)localObject5).wwr;
                  f2 = -1.0F;
                  f1 = -1.0F;
                  paramInt = 0;
                  for (;;)
                  {
                    if (paramInt < ((c)localObject5).getSize())
                    {
                      int i3 = ((c)localObject5).Ct(paramInt).getLength();
                      f3 = f2;
                      if (j <= k)
                      {
                        f3 = f2;
                        if (k <= j + i3) {
                          f3 = (int)(((c)localObject5).Cu(paramInt).left + ((c)localObject5).Ct(paramInt).m(k - j, ((c)localObject5).wwt));
                        }
                      }
                      f2 = f1;
                      if (j <= i2)
                      {
                        f2 = f1;
                        if (i2 < j + i3) {
                          f2 = (int)(((c)localObject5).Cu(paramInt).left + ((c)localObject5).Ct(paramInt).m(i2 - j, ((c)localObject5).wwt));
                        }
                      }
                      j += i3;
                      paramInt += 1;
                      f1 = f2;
                      f2 = f3;
                      continue;
                      ((LinkedList)localObject4).add(localc);
                      break;
                      if ((localc.wwr <= i2) && (i2 <= localc.wws))
                      {
                        ((LinkedList)localObject4).add(localc);
                        break label1021;
                      }
                      if (((LinkedList)localObject4).size() <= 0) {
                        break;
                      }
                      ((LinkedList)localObject4).add(localc);
                      break;
                    }
                  }
                  if ((f2 >= 0.0F) && (f1 < 0.0F))
                  {
                    f3 = ((c)localObject5).wwp;
                    f4 = f2;
                  }
                  for (;;)
                  {
                    if ((f4 < 0.0F) || (f3 < 0.0F) || (f4 >= f3)) {
                      break label1478;
                    }
                    v.i("CellLayout", "[getLineIndex] rect:[%s:%s]", new Object[] { Float.valueOf(f4), Float.valueOf(f3) });
                    ((LinkedList)localObject3).add(new RectF(f4, ((c)localObject5).Cu(0).top, f3, ((c)localObject5).Cu(0).bottom));
                    break;
                    if ((f2 < 0.0F) && (f1 >= 0.0F))
                    {
                      f4 = 0.0F;
                      f3 = f1;
                    }
                    else
                    {
                      f3 = f1;
                      f4 = f2;
                      if (f2 < 0.0F)
                      {
                        f3 = f1;
                        f4 = f2;
                        if (f1 < 0.0F)
                        {
                          f4 = 0.0F;
                          f3 = ((c)localObject5).wwp;
                        }
                      }
                    }
                  }
                }
                ((com.tencent.mm.ui.widget.celltextview.c.b)localObject2).wwm = ((LinkedList)localObject3);
              }
            }
            this.wwD = (this.el + this.em + i1);
            if (this.wwB > this.wwD) {
              this.wwD = this.wwB;
            }
            if ((m == 1073741824) || ((m == 0) && (i > 0))) {}
            for (this.wwf = i;; this.wwf = (this.wwf + this.wwG + this.wwH + n))
            {
              this.wwf = Math.max(this.wwf, this.PN);
              this.wwD = Math.max(this.wwD, this.wwN);
              GMTrace.o(18745384763392L, 139664);
              return;
            }
          }
          paramInt = j;
        }
        break label438;
      }
    }
  }
  
  public final void Cq(int paramInt)
  {
    GMTrace.i(18747263811584L, 139678);
    this.wwI = paramInt;
    GMTrace.o(18747263811584L, 139678);
  }
  
  public final void Cr(int paramInt)
  {
    GMTrace.i(18747398029312L, 139679);
    this.wwJ = paramInt;
    GMTrace.o(18747398029312L, 139679);
  }
  
  public final void Cs(int paramInt)
  {
    GMTrace.i(18747666464768L, 139681);
    this.wwK = paramInt;
    GMTrace.o(18747666464768L, 139681);
  }
  
  public final void U(String paramString, int paramInt1, int paramInt2)
  {
    GMTrace.i(18746995376128L, 139676);
    this.wvV = paramString;
    this.wvW = paramInt1;
    this.wvX = paramInt2;
    GMTrace.o(18746995376128L, 139676);
  }
  
  public final void a(com.tencent.mm.ui.widget.celltextview.c.b paramb)
  {
    GMTrace.i(18746726940672L, 139674);
    this.wwQ = paramb;
    GMTrace.o(18746726940672L, 139674);
  }
  
  public final void a(ArrayList<d> paramArrayList, CharSequence paramCharSequence)
  {
    GMTrace.i(18746458505216L, 139672);
    this.wvY = paramArrayList;
    this.wwF = paramCharSequence;
    GMTrace.o(18746458505216L, 139672);
  }
  
  public final void aC(LinkedList<com.tencent.mm.ui.widget.celltextview.c.b> paramLinkedList)
  {
    GMTrace.i(19011001647104L, 141643);
    this.wvZ = paramLinkedList;
    GMTrace.o(19011001647104L, 141643);
  }
  
  public final List<com.tencent.mm.ui.widget.celltextview.c.b> caL()
  {
    GMTrace.i(18746861158400L, 139675);
    LinkedList localLinkedList = this.wvZ;
    GMTrace.o(18746861158400L, 139675);
    return localLinkedList;
  }
  
  public final String caM()
  {
    GMTrace.i(18917049237504L, 140943);
    if (this.wvY == null)
    {
      GMTrace.o(18917049237504L, 140943);
      return "";
    }
    Object localObject = new StringBuilder();
    Iterator localIterator = this.wvY.iterator();
    while (localIterator.hasNext())
    {
      String str = ((d)localIterator.next()).getText();
      if (str != null) {
        ((StringBuilder)localObject).append(str);
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    GMTrace.o(18917049237504L, 140943);
    return (String)localObject;
  }
  
  public final int getMaxLines()
  {
    GMTrace.i(18748069117952L, 139684);
    int i = this.wwA;
    GMTrace.o(18748069117952L, 139684);
    return i;
  }
  
  public final int getMeasuredHeight()
  {
    GMTrace.i(18748471771136L, 139687);
    int i = (int)this.wwD;
    GMTrace.o(18748471771136L, 139687);
    return i;
  }
  
  public final int getMeasuredWidth()
  {
    GMTrace.i(18748337553408L, 139686);
    int i = (int)this.wwf;
    GMTrace.o(18748337553408L, 139686);
    return i;
  }
  
  public final int getPaddingBottom()
  {
    GMTrace.i(18749008642048L, 139691);
    int i = this.em;
    GMTrace.o(18749008642048L, 139691);
    return i;
  }
  
  public final int getPaddingLeft()
  {
    GMTrace.i(18748605988864L, 139688);
    int i = this.wwG;
    GMTrace.o(18748605988864L, 139688);
    return i;
  }
  
  public final int getPaddingRight()
  {
    GMTrace.i(18748740206592L, 139689);
    int i = this.wwH;
    GMTrace.o(18748740206592L, 139689);
    return i;
  }
  
  public final int getPaddingTop()
  {
    GMTrace.i(18748874424320L, 139690);
    int i = this.el;
    GMTrace.o(18748874424320L, 139690);
    return i;
  }
  
  public final String getText()
  {
    GMTrace.i(18747934900224L, 139683);
    if (this.wwF == null)
    {
      GMTrace.o(18747934900224L, 139683);
      return "";
    }
    String str = this.wwF.toString();
    GMTrace.o(18747934900224L, 139683);
    return str;
  }
  
  public final float getTextSize()
  {
    GMTrace.i(18748203335680L, 139685);
    float f = this.mFg;
    GMTrace.o(18748203335680L, 139685);
    return f;
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(18745518981120L, 139665);
    paramCanvas.save();
    float f = caR();
    if (this.wwI == 80) {
      paramCanvas.translate(aB(this.wwO), this.wwD - f);
    }
    Object localObject;
    while (this.wwQ != null)
    {
      localObject = this.wwQ;
      Iterator localIterator = ((com.tencent.mm.ui.widget.celltextview.c.b)localObject).wwm.iterator();
      while (localIterator.hasNext())
      {
        RectF localRectF = (RectF)localIterator.next();
        paramCanvas.save();
        paramCanvas.clipRect(localRectF);
        paramCanvas.drawColor(((com.tencent.mm.ui.widget.celltextview.c.b)localObject).jjm);
        paramCanvas.restore();
      }
      if (this.wwI == 3) {
        paramCanvas.translate(this.wwG + aB(this.wwO), (this.wwD - f) / 2.0F);
      } else if (this.wwI == 16) {
        paramCanvas.translate(this.wwG + aB(this.wwO), (this.wwD - f) / 2.0F);
      }
    }
    int k = this.wwe.size();
    int i = 0;
    while (i < k)
    {
      localObject = (c)this.wwe.get(i);
      int m = ((c)localObject).getSize();
      paramCanvas.save();
      if ((this.wwI == 1) || (this.wwI == 17))
      {
        f = ((c)localObject).wwp;
        f = (this.wwf - f) / 2.0F;
        ((c)localObject).wwu = f;
        paramCanvas.translate(f, 0.0F);
      }
      int j = 0;
      while (j < m)
      {
        ((c)localObject).Ct(j).a(paramCanvas, ((c)localObject).Cu(j), ((c)localObject).wwt, this.wwz.b(this.jsW));
        j += 1;
      }
      paramCanvas.restore();
      i += 1;
    }
    paramCanvas.restore();
    GMTrace.o(18745518981120L, 139665);
  }
  
  public final void requestLayout()
  {
    GMTrace.i(18745653198848L, 139666);
    this.wwE = true;
    GMTrace.o(18745653198848L, 139666);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    GMTrace.i(18747800682496L, 139682);
    this.wwM = paramDrawable;
    GMTrace.o(18747800682496L, 139682);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    GMTrace.i(18746190069760L, 139670);
    this.iO = paramInt;
    GMTrace.o(18746190069760L, 139670);
  }
  
  public final void setMinHeight(int paramInt)
  {
    GMTrace.i(18747532247040L, 139680);
    this.wwB = paramInt;
    GMTrace.o(18747532247040L, 139680);
  }
  
  public final void setMinWidth(int paramInt)
  {
    GMTrace.i(18746324287488L, 139671);
    this.PN = paramInt;
    GMTrace.o(18746324287488L, 139671);
  }
  
  public final void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(18747129593856L, 139677);
    this.wwG = paramInt1;
    this.el = paramInt2;
    this.em = paramInt4;
    this.wwH = paramInt3;
    if (this.wwM != null)
    {
      Rect localRect = new Rect();
      this.wwM.getPadding(localRect);
      v.i("CellLayout", "[measureImpl] drawableRect:%s", new Object[] { localRect });
      this.wwG = localRect.left;
      this.wwH = localRect.right;
      this.el = localRect.top;
      this.em = localRect.bottom;
      this.PN = this.wwM.getMinimumWidth();
      this.wwB = this.wwM.getMinimumHeight();
    }
    GMTrace.o(18747129593856L, 139677);
  }
  
  public final void setTextColor(int paramInt)
  {
    GMTrace.i(18745787416576L, 139667);
    this.xT = paramInt;
    this.jsW.setColor(paramInt);
    GMTrace.o(18745787416576L, 139667);
  }
  
  public final void setTextSize(float paramFloat)
  {
    GMTrace.i(18746055852032L, 139669);
    this.mFg = paramFloat;
    this.jsW.setTextSize(paramFloat);
    GMTrace.o(18746055852032L, 139669);
  }
  
  private final class a
  {
    int wwS;
    Rect wwT;
    
    public final boolean equals(Object paramObject)
    {
      GMTrace.i(18745116327936L, 139662);
      if (this == paramObject)
      {
        GMTrace.o(18745116327936L, 139662);
        return true;
      }
      if ((paramObject == null) || (!(paramObject instanceof a)))
      {
        GMTrace.o(18745116327936L, 139662);
        return false;
      }
      if (this.wwS == ((a)paramObject).wwS)
      {
        GMTrace.o(18745116327936L, 139662);
        return true;
      }
      GMTrace.o(18745116327936L, 139662);
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */