package com.google.android.gms.c;

public final class bh
{
  public static final int[] aCL = new int[0];
  public static final long[] aCM = new long[0];
  public static final float[] aCN = new float[0];
  public static final double[] aCO = new double[0];
  public static final boolean[] aCP = new boolean[0];
  public static final String[] aCQ = new String[0];
  public static final byte[][] aCR = new byte[0][];
  public static final byte[] aCS = new byte[0];
  
  static int an(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static final int b(aw paramaw, int paramInt)
  {
    int i = 1;
    int j = paramaw.getPosition();
    paramaw.cf(paramInt);
    while (paramaw.ll() == paramInt)
    {
      paramaw.cf(paramInt);
      i += 1;
    }
    paramaw.ci(j);
    return i;
  }
  
  static int ct(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int cu(int paramInt)
  {
    return paramInt >>> 3;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */