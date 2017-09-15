package com.tencent.qqpinyin.voicerecoapi;

public final class c
{
  private int iZS;
  private int icD;
  private TRVADNative wNA = new TRVADNative();
  
  public c()
  {
    this.icD = 500000;
    this.iZS = 10000000;
  }
  
  public c(int paramInt)
  {
    this.icD = paramInt;
    this.iZS = 5000000;
  }
  
  public final void a(short[] paramArrayOfShort, int paramInt, a parama)
  {
    double d1 = 26.0D;
    int i = 0;
    if (paramInt <= 0) {
      return;
    }
    for (;;)
    {
      label59:
      label60:
      try
      {
        switch (this.wNA.mfeSendData(paramArrayOfShort, paramInt))
        {
        case 1: 
          parama.wNB = 0;
        }
      }
      finally {}
      parama.wNF = ((int)d1);
      new StringBuilder("volumn��").append(parama.wNF);
      break;
      parama.wNB = 1;
      break label187;
      parama.wNB = 2;
      break label187;
      parama.wNB = 3;
      int j;
      label187:
      do
      {
        double d2 = j;
        double d3 = Math.sqrt(paramArrayOfShort[i] * paramArrayOfShort[i]);
        j = (int)(d2 + d3 / paramInt);
        i += 1;
        continue;
        if (j > 16383) {
          break label60;
        }
        d1 = 26.0D * ((j - 100.0D) / 32667.0D);
        break label60;
        break;
        j = 0;
      } while (i < paramInt);
      if (j >= 100) {
        break label59;
      }
      d1 = 0.0D;
    }
  }
  
  public final int start()
  {
    int j = this.wNA.mfeInit(this.icD, this.iZS);
    int i = j;
    if (j == 0)
    {
      j = this.wNA.mfeOpen();
      i = j;
      if (j == 0)
      {
        j = this.wNA.mfeEnableNoiseDetection(true);
        i = j;
        if (j == 0) {
          i = this.wNA.mfeStart();
        }
      }
    }
    if (i == 0) {
      return 0;
    }
    return -1;
  }
  
  public final int stop()
  {
    int j = this.wNA.mfeStop();
    int i = j;
    if (j == 0)
    {
      j = this.wNA.mfeClose();
      i = j;
      if (j == 0) {
        i = this.wNA.mfeExit();
      }
    }
    if (i == 0) {
      return 0;
    }
    return -1;
  }
  
  public static final class a
  {
    public int wNB = 0;
    public int wNC = 256;
    public int wND = 512;
    private int wNE = 0;
    public int wNF = 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/qqpinyin/voicerecoapi/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */