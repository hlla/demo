package com.tencent.mm.ui.widget.celltextview.c;

import android.graphics.RectF;
import com.tencent.gmtrace.GMTrace;
import java.util.ArrayList;
import java.util.Iterator;

public final class c
{
  private ArrayList<d> wwn;
  private ArrayList<RectF> wwo;
  public float wwp;
  public float wwq;
  public int wwr;
  public int wws;
  public float wwt;
  public float wwu;
  
  public c()
  {
    GMTrace.i(18753437827072L, 139724);
    GMTrace.o(18753437827072L, 139724);
  }
  
  public final d Ct(int paramInt)
  {
    GMTrace.i(18753840480256L, 139727);
    if (paramInt < 0)
    {
      GMTrace.o(18753840480256L, 139727);
      return null;
    }
    if (this.wwn != null)
    {
      d locald = (d)this.wwn.get(paramInt);
      GMTrace.o(18753840480256L, 139727);
      return locald;
    }
    GMTrace.o(18753840480256L, 139727);
    return null;
  }
  
  public final RectF Cu(int paramInt)
  {
    GMTrace.i(18753974697984L, 139728);
    if (paramInt < 0)
    {
      GMTrace.o(18753974697984L, 139728);
      return null;
    }
    if (this.wwo != null)
    {
      RectF localRectF = (RectF)this.wwo.get(paramInt);
      GMTrace.o(18753974697984L, 139728);
      return localRectF;
    }
    GMTrace.o(18753974697984L, 139728);
    return null;
  }
  
  public final void Ej(int paramInt)
  {
    GMTrace.i(19011941171200L, 141650);
    if (this.wwn == null)
    {
      GMTrace.o(19011941171200L, 141650);
      return;
    }
    int k = this.wwn.size();
    if (paramInt >= k)
    {
      GMTrace.o(19011941171200L, 141650);
      return;
    }
    int i = 0;
    while (i < k - paramInt)
    {
      this.wwn.remove(k - i - 1);
      Object localObject = (RectF)this.wwo.remove(k - i - 1);
      if (localObject != null)
      {
        this.wwp -= ((RectF)localObject).width();
        if (this.wwq >= ((RectF)localObject).height())
        {
          this.wwq = 0.0F;
          localObject = this.wwn.iterator();
          int j = 0;
          if (((Iterator)localObject).hasNext())
          {
            d locald = (d)((Iterator)localObject).next();
            RectF localRectF = (RectF)this.wwo.get(j);
            if (locald.getType() == 0) {}
            for (this.wwq = ((int)localRectF.height());; this.wwq = ((int)localRectF.height())) {
              do
              {
                j += 1;
                break;
              } while ((locald.getType() != 2) || (this.wwq != 0.0F));
            }
          }
        }
      }
      i += 1;
    }
    GMTrace.o(19011941171200L, 141650);
  }
  
  public final void a(d paramd, RectF paramRectF)
  {
    GMTrace.i(18753572044800L, 139725);
    if (this.wwn == null) {
      this.wwn = new ArrayList(1);
    }
    if (this.wwo == null) {
      this.wwo = new ArrayList(1);
    }
    this.wwn.add(paramd);
    this.wwo.add(paramRectF);
    float f2 = this.wwp;
    if (paramRectF.width() < 0.0F) {}
    for (float f1 = 0.0F;; f1 = paramRectF.width())
    {
      this.wwp = (f1 + f2);
      if (paramd.getType() != 0) {
        break;
      }
      this.wwq = ((int)paramRectF.height());
      GMTrace.o(18753572044800L, 139725);
      return;
    }
    if ((paramd.getType() == 2) && (this.wwq == 0.0F)) {
      this.wwq = ((int)paramRectF.height());
    }
    GMTrace.o(18753572044800L, 139725);
  }
  
  public final void et(int paramInt1, int paramInt2)
  {
    GMTrace.i(18753706262528L, 139726);
    this.wwr = paramInt1;
    this.wws = paramInt2;
    GMTrace.o(18753706262528L, 139726);
  }
  
  public final int getSize()
  {
    GMTrace.i(18754243133440L, 139730);
    if ((this.wwn == null) || (this.wwo == null))
    {
      GMTrace.o(18754243133440L, 139730);
      return 0;
    }
    int i = this.wwn.size();
    int j = this.wwo.size();
    if (i < j)
    {
      GMTrace.o(18754243133440L, 139730);
      return i;
    }
    GMTrace.o(18754243133440L, 139730);
    return j;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */