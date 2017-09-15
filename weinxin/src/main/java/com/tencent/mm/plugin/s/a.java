package com.tencent.mm.plugin.s;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;

public final class a
  extends h
{
  private int channels;
  private AudioTrack ibt;
  private boolean kkZ;
  private int sampleRate;
  
  public a(g paramg, ad paramad)
  {
    super(paramg, paramad);
    GMTrace.i(12899800055808L, 96111);
    this.kkZ = false;
    GMTrace.o(12899800055808L, 96111);
  }
  
  private int getSampleRate()
  {
    GMTrace.i(12900739579904L, 96118);
    if (this.sampleRate == 0) {
      this.sampleRate = this.nxY.getInteger("sample-rate");
    }
    int i = this.sampleRate;
    GMTrace.o(12900739579904L, 96118);
    return i;
  }
  
  final boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    GMTrace.i(12899934273536L, 96112);
    v.d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[] { aKl(), Integer.valueOf(this.state), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
    if (!d.po(this.state))
    {
      v.i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", new Object[] { aKl(), Integer.valueOf(this.state) });
      GMTrace.o(12899934273536L, 96112);
      return false;
    }
    if (this.ibt == null)
    {
      v.i("MicroMsg.AudioTrackDataSource", "%s init audio track", new Object[] { aKl() });
      if (this.channels == 0) {
        this.channels = this.nxY.getInteger("channel-count");
      }
      if (this.channels == 1)
      {
        i = 4;
        int j = AudioTrack.getMinBufferSize(getSampleRate(), i, 2);
        this.ibt = new c(3, getSampleRate(), i, 2, j);
        if ((this.ibt == null) || (this.ibt.getState() == 1)) {
          break label281;
        }
        v.w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", new Object[] { aKl(), Integer.valueOf(this.ibt.getState()) });
        this.ibt.release();
        this.ibt = null;
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label295;
        }
        GMTrace.o(12899934273536L, 96112);
        return false;
        i = 12;
        break;
        label281:
        bQ(this.kkZ);
      }
    }
    label295:
    if ((d.pj(this.state)) && ((this.ibt.getPlayState() == 2) || (this.ibt.getPlayState() == 1))) {
      onStart();
    }
    if (this.state == 4) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (this.ibt.getPlayState() == 3)) {
        onPause();
      }
      try
      {
        this.nxT.nxI = paramBufferInfo.presentationTimeUs;
        paramBufferInfo = new byte[paramBufferInfo.size];
        paramByteBuffer.get(paramBufferInfo);
        paramByteBuffer.clear();
        if (paramBufferInfo.length > 0) {
          this.ibt.write(paramBufferInfo, 0, paramBufferInfo.length);
        }
        v.d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track", new Object[] { aKl(), Integer.valueOf(paramInt), Long.valueOf(this.nxT.nxI) });
        paramMediaCodec.releaseOutputBuffer(paramInt, false);
      }
      catch (Exception paramMediaCodec)
      {
        for (;;)
        {
          v.e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", new Object[] { aKl(), paramMediaCodec.toString() });
        }
      }
      GMTrace.o(12899934273536L, 96112);
      return true;
    }
  }
  
  final boolean a(MediaCodec paramMediaCodec)
  {
    GMTrace.i(12900605362176L, 96117);
    v.i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", new Object[] { aKl() });
    paramMediaCodec.configure(this.nxY, null, null, 0);
    GMTrace.o(12900605362176L, 96117);
    return false;
  }
  
  final String aKe()
  {
    GMTrace.i(12901008015360L, 96120);
    GMTrace.o(12901008015360L, 96120);
    return "audio";
  }
  
  protected final void b(MediaCodec paramMediaCodec)
  {
    GMTrace.i(12900873797632L, 96119);
    v.i("MicroMsg.AudioTrackDataSource", "%s on output format changed", new Object[] { aKl() });
    this.sampleRate = 0;
    this.channels = 0;
    this.ibt = null;
    GMTrace.o(12900873797632L, 96119);
  }
  
  public final void bQ(boolean paramBoolean)
  {
    GMTrace.i(12900471144448L, 96116);
    if (this.ibt == null)
    {
      v.w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", new Object[] { aKl(), Boolean.valueOf(paramBoolean) });
      this.kkZ = paramBoolean;
      GMTrace.o(12900471144448L, 96116);
      return;
    }
    if (com.tencent.mm.compatible.util.d.ep(21))
    {
      v.d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", new Object[] { aKl(), Boolean.valueOf(paramBoolean) });
      if (paramBoolean)
      {
        this.ibt.setStereoVolume(0.0F, 0.0F);
        GMTrace.o(12900471144448L, 96116);
        return;
      }
      this.ibt.setStereoVolume(1.0F, 1.0F);
      GMTrace.o(12900471144448L, 96116);
      return;
    }
    v.d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", new Object[] { aKl(), Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.ibt.setVolume(0.0F);
      GMTrace.o(12900471144448L, 96116);
      return;
    }
    this.ibt.setVolume(1.0F);
    GMTrace.o(12900471144448L, 96116);
  }
  
  protected final void onPause()
  {
    GMTrace.i(12900202708992L, 96114);
    v.i("MicroMsg.AudioTrackDataSource", "%s on pause", new Object[] { aKl() });
    if ((this.ibt != null) && (this.ibt.getState() == 1)) {
      this.ibt.pause();
    }
    GMTrace.o(12900202708992L, 96114);
  }
  
  protected final void onStart()
  {
    GMTrace.i(12900068491264L, 96113);
    v.i("MicroMsg.AudioTrackDataSource", "%s on start", new Object[] { aKl() });
    if ((this.ibt != null) && (this.ibt.getState() == 1)) {
      this.ibt.play();
    }
    GMTrace.o(12900068491264L, 96113);
  }
  
  public final void release()
  {
    GMTrace.i(12900336926720L, 96115);
    try
    {
      this.ibt.flush();
      this.ibt.release();
      super.release();
      GMTrace.o(12900336926720L, 96115);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/s/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */