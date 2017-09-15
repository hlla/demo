package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class al
{
  public String aeskey;
  public String fFN;
  public String fFR;
  public String fJC;
  public String fJP;
  public long fTG;
  public int gxu;
  public String gxv;
  public int hJz;
  public String hZN;
  public long hZS;
  public int height;
  public String id;
  public String mKn;
  public String thumbUrl;
  public int uHH;
  public int uHI;
  public int uHJ;
  public int uHK;
  public String uHL;
  public String uHM;
  public boolean uHN;
  public String uHO;
  public int width;
  
  public al()
  {
    GMTrace.i(1532498018304L, 11418);
    this.uHL = "";
    this.gxv = "";
    this.uHN = true;
    GMTrace.o(1532498018304L, 11418);
  }
  
  public static al a(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(1532632236032L, 11419);
    if (paramMap == null)
    {
      GMTrace.o(1532632236032L, 11419);
      return null;
    }
    al localal = new al();
    localal.uHL = paramString2;
    localal.fJC = paramString1;
    localal.id = ((String)paramMap.get(".msg.emoji.$idbuffer"));
    localal.hZN = ((String)paramMap.get(".msg.emoji.$fromusername"));
    paramString1 = (String)paramMap.get(".msg.emoji.$androidmd5");
    localal.fFN = paramString1;
    if (paramString1 == null) {
      localal.fFN = ((String)paramMap.get(".msg.emoji.$md5"));
    }
    if (!bf.mA(localal.fFN)) {
      localal.fFN = localal.fFN.toLowerCase();
    }
    try
    {
      localal.uHH = Integer.valueOf((String)paramMap.get(".msg.emoji.$type")).intValue();
      if (paramMap.get(".msg.emoji.$androidlen") != null) {
        localal.uHI = Integer.valueOf((String)paramMap.get(".msg.emoji.$androidlen")).intValue();
      }
      for (;;)
      {
        if (paramMap.get(".msg.gameext.$type") != null) {
          localal.uHJ = Integer.valueOf((String)paramMap.get(".msg.gameext.$type")).intValue();
        }
        if (paramMap.get(".msg.gameext.$content") != null) {
          localal.uHK = Integer.valueOf((String)paramMap.get(".msg.gameext.$content")).intValue();
        }
        if (paramMap.get(".msg.emoji.$productid") != null) {
          localal.fFR = ((String)paramMap.get(".msg.emoji.$productid"));
        }
        if (paramMap.get(".msg.emoji.$cdnurl") != null) {
          localal.mKn = ((String)paramMap.get(".msg.emoji.$cdnurl"));
        }
        if (paramMap.get(".msg.emoji.$designerid") != null) {
          localal.uHM = ((String)paramMap.get(".msg.emoji.$designerid"));
        }
        if (paramMap.get(".msg.emoji.$thumburl") != null) {
          localal.thumbUrl = ((String)paramMap.get(".msg.emoji.$thumburl"));
        }
        if (paramMap.get(".msg.emoji.$encrypturl") != null) {
          localal.fJP = ((String)paramMap.get(".msg.emoji.$encrypturl"));
        }
        if (paramMap.get(".msg.emoji.$aeskey") != null) {
          localal.aeskey = ((String)paramMap.get(".msg.emoji.$aeskey"));
        }
        if (paramMap.get(".msg.emoji.$width") != null) {
          localal.width = Integer.valueOf((String)paramMap.get(".msg.emoji.$width")).intValue();
        }
        if (paramMap.get(".msg.emoji.$height") != null) {
          localal.height = Integer.valueOf((String)paramMap.get(".msg.emoji.$height")).intValue();
        }
        if (paramMap.get(".msg.emoji.$activityid") != null) {
          localal.uHO = ((String)paramMap.get(".msg.emoji.$activityid"));
        }
        if (!bf.mA(paramString3)) {
          localal.gxv = paramString3;
        }
        v.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml id:%s  md5:%s  type:%d  len:%d  gameType:%d  gameContent:%d  productId:%s  cdnUrl:%s designerid:%s thumburl:%s encryptrul:%s width:%d height:%d activityID:%s", new Object[] { localal.id, localal.fFN, Integer.valueOf(localal.uHH), Integer.valueOf(localal.uHI), Integer.valueOf(localal.uHJ), Integer.valueOf(localal.uHK), localal.fFR, localal.mKn, localal.uHM, localal.thumbUrl, localal.fJP, Integer.valueOf(localal.width), Integer.valueOf(localal.height), localal.uHO });
        GMTrace.o(1532632236032L, 11419);
        return localal;
        if (paramMap.get(".msg.emoji.$len") != null) {
          localal.uHI = Integer.valueOf((String)paramMap.get(".msg.emoji.$len")).intValue();
        }
      }
      return null;
    }
    catch (Exception paramMap)
    {
      v.e("MicroMsg.emoji.EmojiMsgInfo", "exception:%s", new Object[] { bf.g(paramMap) });
      GMTrace.o(1532632236032L, 11419);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */