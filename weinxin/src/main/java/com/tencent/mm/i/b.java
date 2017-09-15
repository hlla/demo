package com.tencent.mm.i;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class b
{
  public static int sA()
  {
    GMTrace.i(4101425332224L, 30558);
    int i = bf.getInt(g.sV().getValue("InputLimitSendEmotionBufSize"), 1048576);
    GMTrace.o(4101425332224L, 30558);
    return i;
  }
  
  public static int sB()
  {
    GMTrace.i(4101559549952L, 30559);
    try
    {
      int i = bf.getInt(g.sV().getValue("InputLimitSendEmotionWidth"), 1024);
      GMTrace.o(4101559549952L, 30559);
      return i;
    }
    catch (Exception localException)
    {
      v.h("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", new Object[] { localException });
      GMTrace.o(4101559549952L, 30559);
    }
    return 1024;
  }
  
  public static int sC()
  {
    GMTrace.i(4101693767680L, 30560);
    try
    {
      int i = bf.getInt(g.sV().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
      GMTrace.o(4101693767680L, 30560);
      return i;
    }
    catch (Exception localException)
    {
      v.h("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", new Object[] { localException });
      GMTrace.o(4101693767680L, 30560);
    }
    return 5242880;
  }
  
  public static int sD()
  {
    GMTrace.i(4101827985408L, 30561);
    int i = bf.getInt(g.sV().getValue("InputLimitFavImageSize"), 26214400);
    GMTrace.o(4101827985408L, 30561);
    return i;
  }
  
  public static String sE()
  {
    GMTrace.i(4101962203136L, 30562);
    String str = g.sV().getValue("InputLimitForbiddenChar");
    GMTrace.o(4101962203136L, 30562);
    return str;
  }
  
  public static int sw()
  {
    GMTrace.i(4100888461312L, 30554);
    int i = bf.getInt(g.sV().getValue("InputLimitSessionTextMsg"), 8192);
    GMTrace.o(4100888461312L, 30554);
    return i * 2;
  }
  
  public static int sx()
  {
    GMTrace.i(4101022679040L, 30555);
    int i = bf.getInt(g.sV().getValue("InputLimitSNSObjectText"), 2000);
    GMTrace.o(4101022679040L, 30555);
    return i * 2;
  }
  
  public static int sy()
  {
    GMTrace.i(4101156896768L, 30556);
    int i = bf.getInt(g.sV().getValue("SnsCommentMaxSize"), 1000);
    GMTrace.o(4101156896768L, 30556);
    return i * 2;
  }
  
  public static int sz()
  {
    GMTrace.i(4101291114496L, 30557);
    int i = bf.getInt(g.sV().getValue("InputLimitFavText"), 100000);
    GMTrace.o(4101291114496L, 30557);
    return i * 2;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */