package com.tencent.qqpinyin.voicerecoapi;

public final class b
  extends Exception
{
  private String iMn = "";
  private int jTc;
  
  public b(int paramInt)
  {
    this.jTc = paramInt;
    String str;
    switch (paramInt)
    {
    default: 
      str = "unknown error";
    }
    for (;;)
    {
      this.iMn = str;
      new StringBuilder("errorCode: ").append(this.jTc).append("\t msg: ").append(this.iMn);
      return;
      str = "speex engine error";
      continue;
      str = "out of memory";
      continue;
      str = "should init at first";
      continue;
      str = "already init";
      continue;
      str = "null param or 0 length";
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/qqpinyin/voicerecoapi/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */