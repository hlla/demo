package com.tencent.mm.plugin.s;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Message;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;

public final class k
  extends h
{
  private int hSP;
  private int hSQ;
  public Surface nyF;
  boolean nyG;
  private boolean nyH;
  public boolean nyI;
  long nyJ;
  
  public k(g paramg, ad paramad)
  {
    super(paramg, paramad);
    GMTrace.i(12904766111744L, 96148);
    this.nyG = false;
    this.nyH = false;
    this.nyI = false;
    this.nyJ = -1L;
    GMTrace.o(12904766111744L, 96148);
  }
  
  private boolean AK(String paramString)
  {
    GMTrace.i(18682168213504L, 139193);
    try
    {
      boolean bool = "video/hevc".equalsIgnoreCase(paramString);
      if (!bool) {
        break label85;
      }
      i = 1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.VideoTrackDataSource", localThrowable, "check is h265 video", new Object[0]);
        int i = 0;
      }
      GMTrace.o(18682168213504L, 139193);
    }
    if ("video/hevc".equalsIgnoreCase(paramString)) {
      i = 1;
    }
    if ((i != 0) && (g.aKn()))
    {
      v.i("MicroMsg.VideoTrackDataSource", "%s it is h265 video and black device", new Object[] { aKl() });
      GMTrace.o(18682168213504L, 139193);
      return true;
    }
    label85:
    return false;
  }
  
  protected final void a(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    GMTrace.i(12905437200384L, 96153);
    super.a(paramMediaFormat, paramString, paramInt);
    this.hSP = paramMediaFormat.getInteger("height");
    this.hSQ = paramMediaFormat.getInteger("width");
    if (paramMediaFormat.containsKey("rotation-degrees")) {
      paramInt = paramMediaFormat.getInteger("rotation-degrees");
    }
    for (int i = 1;; i = 0)
    {
      if ((Math.abs(paramInt) == 90) || (Math.abs(paramInt) == 270))
      {
        j = this.hSQ;
        this.hSQ = this.hSP;
        this.hSP = j;
      }
      int j = paramInt;
      if (i != 0)
      {
        j = paramInt;
        if (!AK(paramString)) {
          j = 0;
        }
      }
      this.nxU.obtainMessage(4, this.hSQ, this.hSP, Integer.valueOf(j)).sendToTarget();
      v.i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", new Object[] { aKl(), Integer.valueOf(this.hSQ), Integer.valueOf(this.hSP), Integer.valueOf(j) });
      GMTrace.o(12905437200384L, 96153);
      return;
      paramInt = SightVideoJNI.getMp4Rotate(this.path);
      v.w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", new Object[] { aKl(), Integer.valueOf(paramInt) });
    }
  }
  
  final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    GMTrace.i(12904900329472L, 96149);
    v.d("MicroMsg.VideoTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[] { aKl(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    if (d.pn(this.state))
    {
      v.i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", new Object[] { aKl() });
      paramMediaCodec.releaseOutputBuffer(paramInt, true);
      setState(4);
      GMTrace.o(12904900329472L, 96149);
      return true;
    }
    if (d.pm(this.state))
    {
      paramLong2 = paramBufferInfo.presentationTimeUs / 1000L;
      l1 = paramLong1 - paramLong2;
      v.d("MicroMsg.VideoTrackDataSource", "%s start to handle precision seek[%d, %d] diff[%d]", new Object[] { aKl(), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(l1) });
      int i;
      if (l1 <= 30L)
      {
        i = 1;
        if (i == 0) {
          break label256;
        }
        v.i("MicroMsg.VideoTrackDataSource", "%s precision seek done to surface", new Object[] { aKl() });
        paramMediaCodec.releaseOutputBuffer(paramInt, true);
        if (this.nyH)
        {
          setState(7);
          this.nyH = false;
        }
        this.nyH = true;
      }
      for (;;)
      {
        GMTrace.o(12904900329472L, 96149);
        return true;
        i = 0;
        break;
        label256:
        paramMediaCodec.releaseOutputBuffer(paramInt, false);
      }
    }
    if (!d.po(this.state))
    {
      v.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[] { aKl(), Integer.valueOf(this.state) });
      GMTrace.o(12904900329472L, 96149);
      return false;
    }
    long l1 = paramBufferInfo.presentationTimeUs / 1000L;
    long l2 = SystemClock.elapsedRealtime();
    long l3 = l2 - paramLong2;
    long l4 = l1 - paramLong1 - l3;
    v.d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", new Object[] { aKl(), Long.valueOf(l4), Long.valueOf(l3), Long.valueOf(l2), Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(l1) });
    if (l4 < -30L)
    {
      v.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", new Object[] { aKl() });
      paramMediaCodec.releaseOutputBuffer(paramInt, false);
      this.nxT.nxK = 0L;
      GMTrace.o(12904900329472L, 96149);
      return true;
    }
    if (l4 < 30L)
    {
      this.nxT.nxH = paramBufferInfo.presentationTimeUs;
      if (l4 <= 11L) {}
    }
    try
    {
      Thread.sleep(l4 - 10L);
      v.i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", new Object[] { aKl(), Integer.valueOf(paramInt), Long.valueOf(l1) });
      paramMediaCodec.releaseOutputBuffer(paramInt, true);
      GMTrace.o(12904900329472L, 96149);
      return true;
      v.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too early now do nothing.", new Object[] { aKl() });
      GMTrace.o(12904900329472L, 96149);
      return false;
    }
    catch (Exception paramByteBuffer)
    {
      for (;;) {}
    }
  }
  
  final boolean a(MediaCodec paramMediaCodec)
  {
    GMTrace.i(12905168764928L, 96151);
    if (paramMediaCodec == null)
    {
      GMTrace.o(12905168764928L, 96151);
      return false;
    }
    if (this.nyF == null)
    {
      v.w("MicroMsg.VideoTrackDataSource", "%s decoder configure surface but surface is null.", new Object[] { aKl() });
      this.nyG = false;
      v.i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", new Object[] { aKl() });
      if (this.nyd != null) {
        break label113;
      }
    }
    label113:
    for (MediaFormat localMediaFormat = this.nxY;; localMediaFormat = this.nyd.getTrackFormat(this.nyb))
    {
      paramMediaCodec.configure(localMediaFormat, this.nyF, null, 0);
      GMTrace.o(12905168764928L, 96151);
      return false;
      this.nyG = true;
      break;
    }
  }
  
  final String aKe()
  {
    GMTrace.i(12905034547200L, 96150);
    GMTrace.o(12905034547200L, 96150);
    return "video";
  }
  
  @TargetApi(23)
  public final void aKx()
  {
    GMTrace.i(17459310493696L, 130082);
    if (this.nyf != null) {
      this.nyf.setOutputSurface(this.nyF);
    }
    GMTrace.o(17459310493696L, 130082);
  }
  
  public final void aKy()
  {
    GMTrace.i(17459444711424L, 130083);
    v.i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", new Object[] { aKl() });
    if (this.nyf != null)
    {
      aKq();
      m(this.nxT.nxH, -1L);
      aKr();
    }
    GMTrace.o(17459444711424L, 130083);
  }
  
  protected final void b(MediaCodec paramMediaCodec)
  {
    GMTrace.i(12905302982656L, 96152);
    v.i("MicroMsg.VideoTrackDataSource", "%s output format changed", new Object[] { aKl() });
    paramMediaCodec.setVideoScalingMode(1);
    GMTrace.o(12905302982656L, 96152);
  }
  
  protected final boolean y(int paramInt, long paramLong)
  {
    GMTrace.i(12905571418112L, 96154);
    v.d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", new Object[] { aKl(), Integer.valueOf(paramInt), Boolean.valueOf(this.nxT.nxM) });
    if ((this.nxT.nxM) && (paramInt == 1) && (this.nyJ != paramLong))
    {
      boolean bool = m(paramLong, -1L);
      this.nyJ = paramLong;
      GMTrace.o(12905571418112L, 96154);
      return bool;
    }
    GMTrace.o(12905571418112L, 96154);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/s/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */