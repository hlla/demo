package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.sc;
import com.tencent.mm.e.a.sc.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.m;
import java.util.Iterator;
import java.util.List;

public final class v
{
  private static int vyh;
  private static int vyi;
  private static int vyj;
  
  static
  {
    GMTrace.i(17906255527936L, 133412);
    vyh = 1;
    vyi = 2;
    vyj = 3;
    GMTrace.o(17906255527936L, 133412);
  }
  
  public static int a(f.a parama, boolean paramBoolean)
  {
    GMTrace.i(17905450221568L, 133406);
    a locala = e(parama);
    switch (parama.hiV)
    {
    }
    for (;;)
    {
      i = R.k.dva;
      GMTrace.o(17905450221568L, 133406);
      return i;
      if ((paramBoolean) || (locala.sZL == 1))
      {
        if ((locala.vyk <= 0) || (locala.vyl < 0) || (locala.vym < 0)) {}
      }
      else {
        switch (locala.vyk)
        {
        default: 
          break;
        case 1: 
        case 2: 
          i = R.k.dvc;
          GMTrace.o(17905450221568L, 133406);
          return i;
        case 3: 
          i = R.k.dva;
          GMTrace.o(17905450221568L, 133406);
          return i;
        case 4: 
          i = R.k.dvb;
          GMTrace.o(17905450221568L, 133406);
          return i;
          if (locala.sZL != 2) {
            break label269;
          }
          if ((locala.vyk > 0) && (locala.vyn >= 0L)) {
            switch (locala.vyk)
            {
            }
          }
          break;
        }
      }
    }
    int i = R.k.dvc;
    GMTrace.o(17905450221568L, 133406);
    return i;
    i = R.k.dva;
    GMTrace.o(17905450221568L, 133406);
    return i;
    i = R.k.dvb;
    GMTrace.o(17905450221568L, 133406);
    return i;
    label269:
    i = R.k.dva;
    GMTrace.o(17905450221568L, 133406);
    return i;
  }
  
  public static String a(int paramInt1, int paramInt2, boolean paramBoolean, f.a parama)
  {
    GMTrace.i(17905718657024L, 133408);
    Context localContext = aa.getContext();
    if (paramInt1 == 5)
    {
      parama = localContext.getString(R.l.exb);
      GMTrace.o(17905718657024L, 133408);
      return parama;
    }
    if (paramInt1 == 4)
    {
      parama = localContext.getString(R.l.exa);
      GMTrace.o(17905718657024L, 133408);
      return parama;
    }
    if (paramInt1 == 3)
    {
      if (paramInt2 == 2)
      {
        parama = localContext.getString(R.l.exc);
        GMTrace.o(17905718657024L, 133408);
        return parama;
      }
      if (paramBoolean)
      {
        parama = localContext.getString(R.l.exd);
        GMTrace.o(17905718657024L, 133408);
        return parama;
      }
      parama = parama.hiI;
      GMTrace.o(17905718657024L, 133408);
      return parama;
    }
    if (paramBoolean)
    {
      parama = parama.hiH;
      GMTrace.o(17905718657024L, 133408);
      return parama;
    }
    parama = parama.hiI;
    GMTrace.o(17905718657024L, 133408);
    return parama;
  }
  
  public static String b(f.a parama, boolean paramBoolean)
  {
    GMTrace.i(17905584439296L, 133407);
    for (;;)
    {
      int i1;
      long l;
      int i3;
      int i2;
      int n;
      int m;
      int k;
      int j;
      int i;
      try
      {
        str1 = m.xL();
        if (parama.hiV <= 0)
        {
          if (paramBoolean)
          {
            str1 = parama.hiH;
            GMTrace.o(17905584439296L, 133407);
            return str1;
          }
          str1 = parama.hiI;
          GMTrace.o(17905584439296L, 133407);
          return str1;
        }
        i1 = 0;
        int i7 = 0;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        l = -1L;
        Object localObject = parama.hiU;
        sc localsc = new sc();
        localsc.fZq.fZs = ((String)localObject);
        a.uql.m(localsc);
        if (parama.hiV != 2)
        {
          i3 = i6;
          i2 = i5;
          n = i4;
          if (parama.hiV != 3) {
            break label936;
          }
        }
        m = i6;
        k = i5;
        j = i4;
        i = i7;
        if (!bf.bV(parama.hiZ))
        {
          localObject = parama.hiZ.iterator();
          m = i6;
          k = i5;
          j = i4;
          i = i7;
          if (((Iterator)localObject).hasNext())
          {
            arrayOfString = ((String)((Iterator)localObject).next()).split(",");
            if ((arrayOfString.length != 4) || (!arrayOfString[0].equals(str1))) {
              continue;
            }
            j = bf.getInt(arrayOfString[1], -1);
            k = bf.getInt(arrayOfString[2], -1);
            m = bf.getInt(arrayOfString[3], -1);
            i = 1;
          }
        }
        i3 = m;
        i2 = k;
        n = j;
        i1 = i;
        if (bf.bV(parama.hjb)) {
          break label936;
        }
        localObject = parama.hjb.iterator();
        i3 = m;
        i2 = k;
        n = j;
        i1 = i;
        if (!((Iterator)localObject).hasNext()) {
          break label936;
        }
        String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",");
        if ((arrayOfString.length != 3) || (!arrayOfString[0].equals(str1))) {
          continue;
        }
        l = bf.getLong(arrayOfString[1], -1L);
        i2 = bf.getInt(arrayOfString[2], -1);
        i3 = 1;
        i1 = i;
        n = j;
        j = i3;
        i = i2;
        if (localsc.fZr.status == vyj)
        {
          str1 = aa.getContext().getString(R.l.dBg);
          GMTrace.o(17905584439296L, 133407);
          return str1;
        }
        if (localsc.fZr.status == vyi)
        {
          str1 = aa.getContext().getString(R.l.dAZ);
          GMTrace.o(17905584439296L, 133407);
          return str1;
        }
        i2 = parama.hiV;
        switch (i2)
        {
        }
      }
      catch (Exception localException)
      {
        String str1;
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.C2CAppMsgUtil", "getC2CDescFromAppMsgContent, error: %s", new Object[] { localException.getMessage() });
        continue;
        str2 = parama.hiI;
        GMTrace.o(17905584439296L, 133407);
        return str2;
      }
      if (paramBoolean)
      {
        parama = parama.hiH;
        GMTrace.o(17905584439296L, 133407);
        return parama;
        if (paramBoolean)
        {
          str1 = parama.hiH;
          GMTrace.o(17905584439296L, 133407);
          return str1;
        }
        String str2;
        if ((!str2.equals(parama.hje)) && (!paramBoolean)) {
          if (i1 != 0)
          {
            break label951;
            str2 = aa.getContext().getString(R.l.dBh);
            GMTrace.o(17905584439296L, 133407);
            return str2;
            str2 = aa.getContext().getString(R.l.dBf, new Object[] { Integer.valueOf(k - m) });
            GMTrace.o(17905584439296L, 133407);
            return str2;
            str2 = aa.getContext().getString(R.l.dBe);
            GMTrace.o(17905584439296L, 133407);
            return str2;
            str2 = aa.getContext().getString(R.l.dBg);
            GMTrace.o(17905584439296L, 133407);
            return str2;
          }
          else
          {
            if (j != 0)
            {
              if ((i <= 0) || (l < 0L)) {
                continue;
              }
              switch (i)
              {
              default: 
                break;
              case 1: 
                str2 = aa.getContext().getString(R.l.dBb, new Object[] { Float.valueOf((float)l / 100.0F) });
                GMTrace.o(17905584439296L, 133407);
                return str2;
              case 2: 
                str2 = aa.getContext().getString(R.l.dBa, new Object[] { Float.valueOf((float)l / 100.0F) });
                GMTrace.o(17905584439296L, 133407);
                return str2;
              case 3: 
                str2 = aa.getContext().getString(R.l.dBd, new Object[] { Float.valueOf((float)l / 100.0F) });
                GMTrace.o(17905584439296L, 133407);
                return str2;
              case 4: 
                str2 = aa.getContext().getString(R.l.dBc);
                GMTrace.o(17905584439296L, 133407);
                return str2;
              }
            }
            str2 = aa.getContext().getString(R.l.dBc);
            GMTrace.o(17905584439296L, 133407);
            return str2;
          }
        }
      }
      else
      {
        parama = parama.hiI;
        GMTrace.o(17905584439296L, 133407);
        return parama;
        label936:
        i = -1;
        j = 0;
        m = i3;
        k = i2;
        continue;
      }
      label951:
      if ((n > 0) && (k >= 0) && (m >= 0)) {
        switch (n)
        {
        }
      }
    }
  }
  
  public static int c(f.a parama, boolean paramBoolean)
  {
    GMTrace.i(17906121310208L, 133411);
    if (parama == null)
    {
      if (paramBoolean)
      {
        i = R.g.bby;
        GMTrace.o(17906121310208L, 133411);
        return i;
      }
      i = R.g.bbw;
      GMTrace.o(17906121310208L, 133411);
      return i;
    }
    Object localObject = parama.hiU;
    sc localsc = new sc();
    localsc.fZq.fZs = ((String)localObject);
    a.uql.m(localsc);
    if ((localsc.fZr.status == vyj) || (localsc.fZr.status == vyi))
    {
      if (paramBoolean)
      {
        i = R.g.bbz;
        GMTrace.o(17906121310208L, 133411);
        return i;
      }
      i = R.g.bbx;
      GMTrace.o(17906121310208L, 133411);
      return i;
    }
    localObject = e(parama);
    switch (parama.hiV)
    {
    }
    while (paramBoolean)
    {
      i = R.g.bby;
      GMTrace.o(17906121310208L, 133411);
      return i;
      if ((paramBoolean) || (((a)localObject).sZL == 1)) {
        if ((((a)localObject).vyk <= 0) || (((a)localObject).vyl < 0) || (((a)localObject).vym < 0)) {
          break;
        }
      } else {
        switch (((a)localObject).vyk)
        {
        default: 
          break;
        case 1: 
        case 2: 
          if (paramBoolean)
          {
            i = R.g.bby;
            GMTrace.o(17906121310208L, 133411);
            return i;
          }
          i = R.g.bbw;
          GMTrace.o(17906121310208L, 133411);
          return i;
        case 3: 
        case 4: 
          if (paramBoolean)
          {
            i = R.g.bbz;
            GMTrace.o(17906121310208L, 133411);
            return i;
          }
          i = R.g.bbx;
          GMTrace.o(17906121310208L, 133411);
          return i;
          if (((a)localObject).sZL == 2)
          {
            if ((((a)localObject).vyk > 0) && (((a)localObject).vyn >= 0L)) {
              switch (((a)localObject).vyk)
              {
              default: 
                break;
              case 1: 
                if (paramBoolean)
                {
                  i = R.g.bby;
                  GMTrace.o(17906121310208L, 133411);
                  return i;
                }
                i = R.g.bbw;
                GMTrace.o(17906121310208L, 133411);
                return i;
              case 2: 
              case 3: 
              case 4: 
                if (paramBoolean)
                {
                  i = R.g.bbz;
                  GMTrace.o(17906121310208L, 133411);
                  return i;
                }
                i = R.g.bbx;
                GMTrace.o(17906121310208L, 133411);
                return i;
              }
            }
          }
          else
          {
            if (paramBoolean)
            {
              i = R.g.bby;
              GMTrace.o(17906121310208L, 133411);
              return i;
            }
            i = R.g.bbw;
            GMTrace.o(17906121310208L, 133411);
            return i;
          }
          break;
        }
      }
    }
    int i = R.g.bbw;
    GMTrace.o(17906121310208L, 133411);
    return i;
  }
  
  public static a e(f.a parama)
  {
    GMTrace.i(17905316003840L, 133405);
    String str = m.xL();
    if ((parama.hiV == 2) || (parama.hiV == 3))
    {
      Object localObject;
      if (!bf.bV(parama.hiZ))
      {
        localObject = parama.hiZ.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String[] arrayOfString = ((String)((Iterator)localObject).next()).split(",");
          if ((arrayOfString.length == 4) && (arrayOfString[0].equals(str)))
          {
            parama = new a(bf.getInt(arrayOfString[1], -1), bf.getInt(arrayOfString[2], -1), bf.getInt(arrayOfString[3], -1));
            GMTrace.o(17905316003840L, 133405);
            return parama;
          }
        }
      }
      if (!bf.bV(parama.hjb))
      {
        parama = parama.hjb.iterator();
        while (parama.hasNext())
        {
          localObject = ((String)parama.next()).split(",");
          if ((localObject.length == 3) && (localObject[0].equals(str)))
          {
            long l = bf.getLong(localObject[1], -1L);
            parama = new a(bf.getInt(localObject[2], -1), l);
            GMTrace.o(17905316003840L, 133405);
            return parama;
          }
        }
      }
    }
    parama = new a();
    GMTrace.o(17905316003840L, 133405);
    return parama;
  }
  
  public static int s(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(17905852874752L, 133409);
    if (paramInt1 == 5)
    {
      if (paramBoolean)
      {
        paramInt1 = R.g.bdi;
        GMTrace.o(17905852874752L, 133409);
        return paramInt1;
      }
      paramInt1 = R.g.bdg;
      GMTrace.o(17905852874752L, 133409);
      return paramInt1;
    }
    if (paramInt1 == 4)
    {
      if (paramBoolean)
      {
        paramInt1 = R.g.bdi;
        GMTrace.o(17905852874752L, 133409);
        return paramInt1;
      }
      paramInt1 = R.g.bdg;
      GMTrace.o(17905852874752L, 133409);
      return paramInt1;
    }
    if (paramInt1 == 3)
    {
      if (paramInt2 == 2)
      {
        if (paramBoolean)
        {
          paramInt1 = R.g.bdi;
          GMTrace.o(17905852874752L, 133409);
          return paramInt1;
        }
        paramInt1 = R.g.bdg;
        GMTrace.o(17905852874752L, 133409);
        return paramInt1;
      }
      if (paramBoolean)
      {
        paramInt1 = R.g.bdi;
        GMTrace.o(17905852874752L, 133409);
        return paramInt1;
      }
      paramInt1 = R.g.bdf;
      GMTrace.o(17905852874752L, 133409);
      return paramInt1;
    }
    if (paramBoolean)
    {
      paramInt1 = R.g.bdh;
      GMTrace.o(17905852874752L, 133409);
      return paramInt1;
    }
    paramInt1 = R.g.bdf;
    GMTrace.o(17905852874752L, 133409);
    return paramInt1;
  }
  
  public static int t(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    GMTrace.i(17905987092480L, 133410);
    if (paramInt1 == 5)
    {
      paramInt1 = R.g.bgM;
      GMTrace.o(17905987092480L, 133410);
      return paramInt1;
    }
    if (paramInt1 == 4)
    {
      paramInt1 = R.g.bgM;
      GMTrace.o(17905987092480L, 133410);
      return paramInt1;
    }
    if (paramInt1 == 3)
    {
      if (paramInt2 == 2)
      {
        paramInt1 = R.g.bgM;
        GMTrace.o(17905987092480L, 133410);
        return paramInt1;
      }
      if (paramBoolean)
      {
        paramInt1 = R.g.bgM;
        GMTrace.o(17905987092480L, 133410);
        return paramInt1;
      }
      GMTrace.o(17905987092480L, 133410);
      return -1;
    }
    GMTrace.o(17905987092480L, 133410);
    return -1;
  }
  
  public static final class a
  {
    public int sZL;
    public int vyk;
    public int vyl;
    public int vym;
    public long vyn;
    
    public a()
    {
      GMTrace.i(17917932470272L, 133499);
      this.vyl = -1;
      this.vym = -1;
      this.vyn = -1L;
      this.sZL = 3;
      GMTrace.o(17917932470272L, 133499);
    }
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      GMTrace.i(17917664034816L, 133497);
      this.vyl = -1;
      this.vym = -1;
      this.vyn = -1L;
      this.sZL = 1;
      this.vyk = paramInt1;
      this.vyl = paramInt2;
      this.vym = paramInt3;
      GMTrace.o(17917664034816L, 133497);
    }
    
    public a(int paramInt, long paramLong)
    {
      GMTrace.i(17917798252544L, 133498);
      this.vyl = -1;
      this.vym = -1;
      this.vyn = -1L;
      this.sZL = 2;
      this.vyk = paramInt;
      this.vyn = paramLong;
      GMTrace.o(17917798252544L, 133498);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */