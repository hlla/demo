package com.google.android.finsky.bv;

import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.bu;
import java.util.List;

public final class i
{
  public static final int[] a = { 4, 0 };
  
  public static bu a(Document paramDocument)
  {
    int[] arrayOfInt = a;
    int j = arrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      List localList = paramDocument.c(arrayOfInt[i]);
      if (localList == null) {}
      while (localList.isEmpty())
      {
        i += 1;
        break;
      }
      return (bu)localList.get(0);
    }
    return null;
  }
  
  public static bu a(Document paramDocument, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    if (i < j)
    {
      List localList = paramDocument.c(paramArrayOfInt[i]);
      if (localList == null) {}
      while (localList.isEmpty())
      {
        i += 1;
        break;
      }
      return (bu)localList.get(0);
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bv/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */