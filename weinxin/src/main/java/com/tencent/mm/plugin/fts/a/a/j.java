package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class j
  extends i
{
  public j()
  {
    GMTrace.i(18635997315072L, 138849);
    GMTrace.o(18635997315072L, 138849);
  }
  
  private void a(Pattern paramPattern)
  {
    int i = 0;
    GMTrace.i(18636265750528L, 138851);
    this.lYD = paramPattern.split(this.content);
    this.lYE = new int[this.lYD.length];
    int j = 0;
    while (i < this.lYE.length)
    {
      this.lYE[i] = j;
      j += this.lYD[i].length() + 1;
      i += 1;
    }
    GMTrace.o(18636265750528L, 138851);
  }
  
  private void axE()
  {
    GMTrace.i(18636534185984L, 138853);
    switch (this.hOZ)
    {
    default: 
      GMTrace.o(18636534185984L, 138853);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    a(c.a.lXM);
    String[] arrayOfString1 = c.a.lXL.split(this.lYA);
    byte[] arrayOfByte = this.content.getBytes();
    int i = 0;
    label80:
    int n;
    int k;
    int j;
    String str;
    String[] arrayOfString2;
    if (i < arrayOfString1.length)
    {
      n = Integer.valueOf(arrayOfString1[i]).intValue();
      int m = new String(arrayOfByte, 0, Integer.valueOf(arrayOfString1[(i + 1)]).intValue()).length();
      k = Arrays.binarySearch(this.lYE, m);
      j = k;
      if (k < 0) {
        j = -k - 2;
      }
      str = this.lYD[j];
      arrayOfString2 = c.a.lXN.split(str);
      m -= this.lYE[j];
      k = 0;
      label178:
      if (k >= arrayOfString2.length) {
        break label272;
      }
      m = m - arrayOfString2[k].length() - 1;
      if (m < 0)
      {
        str = arrayOfString2[k];
        k = com.tencent.mm.plugin.fts.a.c.lXE[k];
      }
    }
    for (;;)
    {
      if (k > 0) {
        localArrayList.add(new d(j, n, k, str, arrayOfString2[(arrayOfString2.length - 1)]));
      }
      i += 2;
      break label80;
      k += 1;
      break label178;
      this.lYF = localArrayList;
      break;
      label272:
      k = -1;
      str = null;
    }
  }
  
  public final void axD()
  {
    GMTrace.i(18636399968256L, 138852);
    if (bf.mA(this.lYA))
    {
      GMTrace.o(18636399968256L, 138852);
      return;
    }
    switch (this.type)
    {
    }
    for (;;)
    {
      GMTrace.o(18636399968256L, 138852);
      return;
      switch (this.hOZ)
      {
      case 4: 
      case 5: 
      case 8: 
      case 9: 
      case 10: 
      default: 
      case 11: 
        for (;;)
        {
          try
          {
            i = Integer.valueOf(c.a.lXL.split(this.lYA)[1]).intValue();
            this.lYB = new String(this.content.getBytes(), 0, i).length();
            this.lYC = this.content;
            GMTrace.o(18636399968256L, 138852);
            return;
          }
          catch (Exception localException3)
          {
            int i;
            String[] arrayOfString1;
            int k;
            int j;
            String[] arrayOfString2;
            this.lYB = Integer.MAX_VALUE;
            this.lYC = "";
            GMTrace.o(18636399968256L, 138852);
            return;
          }
          try
          {
            arrayOfString1 = c.a.lXL.split(this.lYA);
            a(c.a.lXM);
            i = Integer.valueOf(arrayOfString1[1]).intValue();
            k = new String(this.content.getBytes(), 0, i).length();
            j = Arrays.binarySearch(this.lYE, k);
            i = j;
            if (j < 0) {
              i = -j - 2;
            }
            this.lYB = (k - this.lYE[i]);
            this.lYC = this.lYD[i];
            GMTrace.o(18636399968256L, 138852);
            return;
          }
          catch (Exception localException1)
          {
            this.lYB = Integer.MAX_VALUE;
            this.lYC = "";
            GMTrace.o(18636399968256L, 138852);
            return;
          }
        }
      }
      try
      {
        arrayOfString2 = c.a.lXL.split(this.lYA);
        a(c.a.lXP);
        i = Integer.valueOf(arrayOfString2[1]).intValue();
        i = new String(this.content.getBytes(), 0, i).length();
        this.lYB = Arrays.binarySearch(this.lYE, i);
        if (this.lYB < 0) {
          this.lYB = (-this.lYB - 2);
        }
        this.lYC = this.lYD[this.lYB];
        GMTrace.o(18636399968256L, 138852);
        return;
      }
      catch (Exception localException2)
      {
        this.lYB = Integer.MAX_VALUE;
        this.lYC = "";
        GMTrace.o(18636399968256L, 138852);
        return;
      }
      axE();
    }
  }
  
  public final void d(String[] paramArrayOfString, String paramString)
  {
    GMTrace.i(18636668403712L, 138854);
    if (paramArrayOfString.length > 1) {
      this.lYH = 1;
    }
    while (this.type == 131075)
    {
      if (System.currentTimeMillis() - this.timestamp >= 1209600000L) {
        break label375;
      }
      this.lYg += 50;
      String str = m.xL();
      if (this.hOZ == 38)
      {
        HashSet localHashSet = new HashSet();
        if (this.lYF != null)
        {
          Iterator localIterator = this.lYF.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              d locald = (d)localIterator.next();
              if (!str.equals(locald.gtH))
              {
                localHashSet.add(Integer.valueOf(locald.lYc));
                continue;
                this.lYH = 0;
                break;
              }
            }
          }
        }
        if (localHashSet.size() >= this.lYy - 1L)
        {
          this.lYg += 20;
          this.lYI = true;
        }
        if ((paramArrayOfString.length > 1) && (this.content.contains(paramString)))
        {
          this.lYH = 2;
          this.lYg += 5;
        }
        if (this.lYy <= 15L) {
          this.lYK = 1;
        }
      }
      if (((this.hOZ == 5) || (this.hOZ == 1)) && (this.content.contains(paramString)))
      {
        if (paramArrayOfString.length > 1) {
          this.lYH = 2;
        }
        this.lYg += 10;
      }
      GMTrace.o(18636668403712L, 138854);
      return;
    }
    if (this.type == 131072)
    {
      if (System.currentTimeMillis() - this.timestamp < 1105032704L) {
        this.lYg += 50;
      }
      if (((this.hOZ == 5) || (this.hOZ == 1)) && (this.content.contains(paramString)))
      {
        if (paramArrayOfString.length > 1) {
          this.lYH = 2;
        }
        this.lYg += 10;
      }
    }
    label375:
    GMTrace.o(18636668403712L, 138854);
  }
  
  public final j e(Cursor paramCursor)
  {
    GMTrace.i(18636131532800L, 138850);
    this.lYw = paramCursor.getLong(0);
    this.type = paramCursor.getInt(1);
    this.hOZ = paramCursor.getInt(2);
    this.lYy = paramCursor.getLong(3);
    this.lYb = paramCursor.getString(4);
    this.timestamp = paramCursor.getLong(5);
    if (paramCursor.getColumnCount() >= 7) {
      this.content = paramCursor.getString(6);
    }
    if (paramCursor.getColumnCount() >= 8) {
      this.lYA = paramCursor.getString(7);
    }
    GMTrace.o(18636131532800L, 138850);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */