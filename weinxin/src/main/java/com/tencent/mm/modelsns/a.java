package com.tencent.mm.modelsns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Bundle;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.ox;
import com.tencent.mm.e.a.ox.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.Set;

public final class a
{
  public static Set<String> hSK;
  
  public static Intent a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2)
  {
    GMTrace.i(14691204071424L, 109458);
    v.d("MicroMsg.ShareSnsImpl", "appmsg.description " + paramWXMediaMessage.description);
    v.d("MicroMsg.ShareSnsImpl", "appmsg.title " + paramWXMediaMessage.title);
    Object localObject1 = paramWXMediaMessage.mediaObject;
    int i;
    switch (((WXMediaMessage.IMediaObject)localObject1).type())
    {
    default: 
      i = -1;
    }
    Intent localIntent;
    for (;;)
    {
      localIntent = new Intent();
      localIntent.putExtra("KThrid_app", true);
      v.d("MicroMsg.ShareSnsImpl", "TimeLineType " + i + " " + ((WXMediaMessage.IMediaObject)localObject1).type());
      localIntent.putExtra("Ksnsupload_appid", paramString1);
      localIntent.putExtra("Ksnsupload_appname", paramString2);
      localIntent.putExtra("KSnsAction", true);
      localIntent.putExtra("need_result", true);
      paramString1 = new Bundle();
      paramString2 = new SendMessageToWX.Req();
      paramString2.message = paramWXMediaMessage;
      paramString2.toBundle(paramString1);
      localIntent.putExtra("Ksnsupload_timeline", paramString1);
      if (i != -1) {
        break;
      }
      v.d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
      GMTrace.o(14691204071424L, 109458);
      return null;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 5;
      continue;
      i = 3;
      continue;
      i = 15;
    }
    label525:
    label610:
    label618:
    label1055:
    String str1;
    String str2;
    switch (((WXMediaMessage.IMediaObject)localObject1).type())
    {
    default: 
      v.e("MicroMsg.ShareSnsImpl", "none type not support!");
      GMTrace.o(14691204071424L, 109458);
      return null;
    case 1: 
      localIntent.putExtra("Kdescription", ((WXTextObject)localObject1).text);
      localIntent.putExtra("Ksnsupload_type", 8);
      GMTrace.o(14691204071424L, 109458);
      return localIntent;
    case 3: 
      paramString1 = (WXMusicObject)localObject1;
      if (!bf.mA(paramString1.musicUrl))
      {
        paramWXMediaMessage = paramString1.musicUrl;
        paramString2 = bf.ap(paramWXMediaMessage, "");
        if (bf.mA(paramString1.musicDataUrl)) {
          break label610;
        }
        paramWXMediaMessage = paramString1.musicDataUrl;
        bf.ap(paramWXMediaMessage, "");
        if (bf.mA(paramString1.musicLowBandDataUrl)) {
          break label618;
        }
      }
      for (paramWXMediaMessage = paramString1.musicLowBandDataUrl;; paramWXMediaMessage = paramString1.musicLowBandUrl)
      {
        bf.ap(paramWXMediaMessage, "");
        localIntent.putExtra("Ksnsupload_link", paramString2);
        localIntent.putExtra("Ksnsupload_title", "");
        localIntent.putExtra("Ksnsupload_type", 2);
        localIntent.putExtra("ksnsis_music", true);
        GMTrace.o(14691204071424L, 109458);
        return localIntent;
        paramWXMediaMessage = paramString1.musicLowBandUrl;
        break;
        paramWXMediaMessage = paramString1.musicUrl;
        break label525;
      }
    case 2: 
      paramWXMediaMessage = (WXImageObject)localObject1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 0);
      localIntent.putExtra("sns_kemdia_path", paramWXMediaMessage.imagePath);
      GMTrace.o(14691204071424L, 109458);
      return localIntent;
    case 5: 
      localIntent.putExtra("Ksnsupload_link", ((WXWebpageObject)localObject1).webpageUrl);
      localIntent.putExtra("Ksnsupload_title", bf.ap(paramWXMediaMessage.title, ""));
      localIntent.putExtra("Ksnsupload_imgbuf", paramWXMediaMessage.thumbData);
      localIntent.putExtra("Ksnsupload_type", 1);
      GMTrace.o(14691204071424L, 109458);
      return localIntent;
    case 6: 
      v.e("MicroMsg.ShareSnsImpl", "file is not support!");
      GMTrace.o(14691204071424L, 109458);
      return null;
    case 4: 
      paramWXMediaMessage = (WXVideoObject)localObject1;
      if (!bf.mA(paramWXMediaMessage.videoUrl)) {}
      for (paramWXMediaMessage = paramWXMediaMessage.videoUrl;; paramWXMediaMessage = paramWXMediaMessage.videoLowBandUrl)
      {
        localIntent.putExtra("Ksnsupload_link", bf.ap(paramWXMediaMessage, ""));
        localIntent.putExtra("Ksnsupload_title", "");
        localIntent.putExtra("Ksnsupload_type", 1);
        localIntent.putExtra("ksnsis_video", true);
        GMTrace.o(14691204071424L, 109458);
        return localIntent;
      }
    case 38: 
      paramWXMediaMessage = (WXVideoFileObject)localObject1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 14);
      paramString1 = paramWXMediaMessage.filePath;
      paramWXMediaMessage = "";
      paramString2 = g.aV(paramString1);
      if ((bf.mA("")) || (!FileOp.aO("")))
      {
        paramWXMediaMessage = new StringBuilder();
        ap.yY();
        paramWXMediaMessage = c.getAccSnsTmpPath() + paramString2;
      }
      try
      {
        localObject1 = kF(paramString1);
        if (localObject1 == null) {
          break label1055;
        }
        v.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        d.a((Bitmap)localObject1, 80, Bitmap.CompressFormat.JPEG, paramWXMediaMessage, true);
        localObject1 = d.Pd(paramWXMediaMessage);
        v.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight) });
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          v.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[] { localException1.getMessage() });
        }
      }
      localIntent.putExtra("KSightPath", paramString1);
      localIntent.putExtra("KSightThumbPath", paramWXMediaMessage);
      localIntent.putExtra("sight_md5", paramString2);
      GMTrace.o(14691204071424L, 109458);
      return localIntent;
      v.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[] { paramString1 });
      GMTrace.o(14691204071424L, 109458);
      return null;
    case 39: 
      paramWXMediaMessage = (WXGameVideoFileObject)localException1;
      localIntent.putExtra("KBlockAdd", true);
      localIntent.putExtra("Ksnsupload_type", 14);
      paramString1 = paramWXMediaMessage.filePath;
      paramString2 = paramWXMediaMessage.videoUrl;
      str1 = paramWXMediaMessage.thumbUrl;
      v.i("MicroMsg.ShareSnsImpl", "videoPath %s,thumbPath %s,cdnUrl %s,cdnThumbUrl %s", new Object[] { paramString1, "", paramString2, str1 });
      str2 = g.aV(paramString1);
      if ((bf.mA("")) || (!FileOp.aO("")))
      {
        paramWXMediaMessage = new StringBuilder();
        ap.yY();
      }
      break;
    }
    for (paramWXMediaMessage = c.getAccSnsTmpPath() + str2;; paramWXMediaMessage = "")
    {
      try
      {
        Object localObject2 = kF(paramString1);
        if (localObject2 == null) {
          break label1386;
        }
        v.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
        d.a((Bitmap)localObject2, 80, Bitmap.CompressFormat.JPEG, paramWXMediaMessage, true);
        localObject2 = d.Pd(paramWXMediaMessage);
        v.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject2).outHeight) });
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          label1386:
          v.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[] { localException2.getMessage() });
        }
      }
      localIntent.putExtra("KSightPath", paramString1);
      localIntent.putExtra("KSightThumbPath", paramWXMediaMessage);
      localIntent.putExtra("sight_md5", str2);
      localIntent.putExtra("KSightCdnUrl", paramString2);
      localIntent.putExtra("KSightCdnThumbUrl", str1);
      GMTrace.o(14691204071424L, 109458);
      return localIntent;
      v.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[] { paramString1 });
      GMTrace.o(14691204071424L, 109458);
      return null;
      GMTrace.o(14691204071424L, 109458);
      return null;
    }
  }
  
  private static Bitmap kF(String paramString)
  {
    GMTrace.i(16268933464064L, 121213);
    ox localox = new ox();
    localox.fVH.fVJ = paramString;
    com.tencent.mm.sdk.b.a.uql.m(localox);
    paramString = (Bitmap)localox.fVI.result;
    GMTrace.o(16268933464064L, 121213);
    return paramString;
  }
  
  public static final class a
  {
    public String hSL;
    public String hSM;
    public String hSN;
    public int hSO;
    public int hSP;
    public int hSQ;
    public int hSR;
    public int videoBitRate;
    public int videoFrameRate;
    
    public a()
    {
      GMTrace.i(15961977520128L, 118926);
      this.hSO = -1;
      this.hSP = -1;
      this.hSQ = -1;
      this.videoBitRate = -1;
      this.hSR = -1;
      this.videoFrameRate = -1;
      GMTrace.o(15961977520128L, 118926);
    }
    
    public static a kG(String paramString)
    {
      GMTrace.i(15962111737856L, 118927);
      MediaExtractor localMediaExtractor = new MediaExtractor();
      a locala = new a();
      locala.hSL = paramString;
      for (;;)
      {
        Object localObject2;
        int i;
        Object localObject5;
        Object localObject6;
        try
        {
          localMediaExtractor.setDataSource(paramString);
          int j = localMediaExtractor.getTrackCount();
          localObject2 = null;
          str1 = null;
          i = 0;
          localObject3 = localObject2;
          localObject4 = str1;
          if (i < j)
          {
            localMediaFormat = localMediaExtractor.getTrackFormat(i);
            if (!localMediaFormat.containsKey("mime"))
            {
              v.i("MicroMsg.ShareSnsImpl", "find video mime : not found.");
              localObject5 = localObject2;
              localObject6 = str1;
              break label510;
            }
            str2 = localMediaFormat.getString("mime");
            v.i("MicroMsg.ShareSnsImpl", "find video mime : %s", new Object[] { str2 });
            localObject5 = localObject2;
            localObject6 = str1;
            if (str2 == null) {
              break label510;
            }
            if (!str2.startsWith("video/")) {
              continue;
            }
            localObject3 = localObject2;
            localObject4 = str1;
            if (str1 != null) {
              break label524;
            }
            localObject4 = localMediaFormat;
            localObject3 = localObject2;
            break label524;
          }
          if (localObject4 != null)
          {
            if (((MediaFormat)localObject4).containsKey("durationUs")) {
              continue;
            }
            i = 0;
            locala.hSO = i;
            if (((MediaFormat)localObject4).containsKey("height")) {
              continue;
            }
            i = 0;
            locala.hSP = i;
            if (((MediaFormat)localObject4).containsKey("width")) {
              continue;
            }
            i = 0;
            locala.hSQ = i;
            if (((MediaFormat)localObject4).containsKey("mime")) {
              continue;
            }
            str1 = "";
            locala.hSM = str1;
            if (((MediaFormat)localObject4).containsKey("bitrate")) {
              continue;
            }
            i = 0;
            locala.videoBitRate = i;
            if (((MediaFormat)localObject4).containsKey("i-frame-interval")) {
              continue;
            }
            i = 0;
            locala.hSR = i;
            if (((MediaFormat)localObject4).containsKey("frame-rate")) {
              continue;
            }
            i = 0;
            locala.videoFrameRate = i;
          }
          if (localObject3 != null)
          {
            if (((MediaFormat)localObject3).containsKey("mime")) {
              continue;
            }
            str1 = "";
            locala.hSN = str1;
          }
        }
        catch (Exception localException)
        {
          String str1;
          MediaFormat localMediaFormat;
          String str2;
          v.i("MicroMsg.ShareSnsImpl", "Video extractor init failed. video path = [%s] e = [%s]", new Object[] { paramString, localException.getMessage() });
          localMediaExtractor.release();
          continue;
        }
        finally
        {
          localMediaExtractor.release();
        }
        GMTrace.o(15962111737856L, 118927);
        return locala;
        Object localObject3 = localObject2;
        Object localObject4 = str1;
        if (str2.startsWith("audio/"))
        {
          localObject3 = localObject2;
          localObject4 = str1;
          if (localObject2 == null)
          {
            localObject3 = localMediaFormat;
            localObject4 = str1;
            break label524;
            i = (int)(((MediaFormat)localObject4).getLong("durationUs") / 1000L);
            continue;
            i = ((MediaFormat)localObject4).getInteger("height");
            continue;
            i = ((MediaFormat)localObject4).getInteger("width");
            continue;
            str1 = ((MediaFormat)localObject4).getString("mime");
            continue;
            i = ((MediaFormat)localObject4).getInteger("bitrate");
            continue;
            i = ((MediaFormat)localObject4).getInteger("i-frame-interval");
            continue;
            i = ((MediaFormat)localObject4).getInteger("frame-rate");
            continue;
            str1 = ((MediaFormat)localObject3).getString("mime");
            continue;
          }
        }
        label510:
        label524:
        do
        {
          do
          {
            i += 1;
            localObject2 = localObject5;
            Object localObject1 = localObject6;
            break;
            localObject5 = localObject3;
            localObject6 = localObject4;
          } while (localObject3 == null);
          localObject5 = localObject3;
          localObject6 = localObject4;
        } while (localObject4 == null);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsns/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */