package com.tencent.mm.plugin.s;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Message;
import android.util.Pair;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public abstract class h
{
  protected g nxT;
  protected ad nxU;
  private boolean nxV;
  public b nxW;
  protected long nxX;
  MediaFormat nxY;
  private String nxZ;
  long nya;
  int nyb;
  private MediaCodec.BufferInfo nyc;
  MediaExtractor nyd;
  private f nye;
  protected MediaCodec nyf;
  private int nyg;
  private ByteBuffer[] nyh;
  private int nyi;
  private ByteBuffer[] nyj;
  protected String path;
  protected int state;
  
  public h(g paramg, ad paramad)
  {
    GMTrace.i(12901142233088L, 96121);
    this.nxV = false;
    this.nxW = null;
    this.nxX = 0L;
    this.nyc = new MediaCodec.BufferInfo();
    this.nxT = paramg;
    this.nxU = paramad;
    this.state = 0;
    this.nyg = -1;
    this.nyi = -1;
    GMTrace.o(12901142233088L, 96121);
  }
  
  private void aKo()
  {
    GMTrace.i(12901410668544L, 96123);
    if (this.nxW != null) {
      this.nxX = (this.nxW.aKf() * 1000L);
    }
    GMTrace.o(12901410668544L, 96123);
  }
  
  protected void a(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    GMTrace.i(12902752845824L, 96133);
    v.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d]", new Object[] { aKl(), paramString, Integer.valueOf(paramInt) });
    this.nyb = paramInt;
    this.nxZ = paramString;
    this.nya = (paramMediaFormat.getLong("durationUs") / 1000L);
    this.nxY = paramMediaFormat;
    GMTrace.o(12902752845824L, 96133);
  }
  
  abstract boolean a(long paramLong1, long paramLong2, MediaCodec paramMediaCodec, ByteBuffer paramByteBuffer, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
  
  abstract boolean a(MediaCodec paramMediaCodec);
  
  abstract String aKe();
  
  public final String aKl()
  {
    GMTrace.i(12903826587648L, 96141);
    String str = aKe() + "_" + this.nxT.aKl();
    GMTrace.o(12903826587648L, 96141);
    return str;
  }
  
  public final void aKp()
  {
    GMTrace.i(12901544886272L, 96124);
    v.i("MicroMsg.TrackDataSource", "%s flush codec", new Object[] { aKl() });
    this.nyi = -1;
    this.nyg = -1;
    try
    {
      this.nyf.flush();
      GMTrace.o(12901544886272L, 96124);
      return;
    }
    catch (Exception localException)
    {
      GMTrace.o(12901544886272L, 96124);
    }
  }
  
  /* Error */
  protected final void aKq()
  {
    // Byte code:
    //   0: ldc2_w 167
    //   3: ldc -87
    //   5: invokestatic 50	com/tencent/gmtrace/GMTrace:i	(JI)V
    //   8: aload_0
    //   9: getfield 160	com/tencent/mm/plugin/s/h:nyf	Landroid/media/MediaCodec;
    //   12: ifnull +72 -> 84
    //   15: ldc 94
    //   17: ldc -85
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_0
    //   26: invokevirtual 100	com/tencent/mm/plugin/s/h:aKl	()Ljava/lang/String;
    //   29: aastore
    //   30: invokestatic 111	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_0
    //   34: invokevirtual 173	com/tencent/mm/plugin/s/h:aKp	()V
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 175	com/tencent/mm/plugin/s/h:nyj	[Ljava/nio/ByteBuffer;
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 177	com/tencent/mm/plugin/s/h:nyh	[Ljava/nio/ByteBuffer;
    //   47: aload_0
    //   48: getfield 160	com/tencent/mm/plugin/s/h:nyf	Landroid/media/MediaCodec;
    //   51: invokevirtual 180	android/media/MediaCodec:stop	()V
    //   54: aload_0
    //   55: getfield 160	com/tencent/mm/plugin/s/h:nyf	Landroid/media/MediaCodec;
    //   58: invokevirtual 183	android/media/MediaCodec:release	()V
    //   61: aload_0
    //   62: aconst_null
    //   63: putfield 160	com/tencent/mm/plugin/s/h:nyf	Landroid/media/MediaCodec;
    //   66: ldc 94
    //   68: ldc -71
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: invokevirtual 100	com/tencent/mm/plugin/s/h:aKl	()Ljava/lang/String;
    //   80: aastore
    //   81: invokestatic 111	com/tencent/mm/sdk/platformtools/v:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: ldc2_w 167
    //   87: ldc -87
    //   89: invokestatic 74	com/tencent/gmtrace/GMTrace:o	(JI)V
    //   92: return
    //   93: astore_1
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 160	com/tencent/mm/plugin/s/h:nyf	Landroid/media/MediaCodec;
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: aload_0
    //   103: getfield 160	com/tencent/mm/plugin/s/h:nyf	Landroid/media/MediaCodec;
    //   106: invokevirtual 183	android/media/MediaCodec:release	()V
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 160	com/tencent/mm/plugin/s/h:nyf	Landroid/media/MediaCodec;
    //   114: goto -48 -> 66
    //   117: astore_1
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 160	com/tencent/mm/plugin/s/h:nyf	Landroid/media/MediaCodec;
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: aload_0
    //   127: getfield 160	com/tencent/mm/plugin/s/h:nyf	Landroid/media/MediaCodec;
    //   130: invokevirtual 183	android/media/MediaCodec:release	()V
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield 160	com/tencent/mm/plugin/s/h:nyf	Landroid/media/MediaCodec;
    //   138: aload_1
    //   139: athrow
    //   140: astore_1
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 160	com/tencent/mm/plugin/s/h:nyf	Landroid/media/MediaCodec;
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	h
    //   93	7	1	localObject1	Object
    //   101	1	1	localException	Exception
    //   117	7	1	localObject2	Object
    //   125	14	1	localObject3	Object
    //   140	7	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   54	61	93	finally
    //   47	54	101	java/lang/Exception
    //   102	109	117	finally
    //   47	54	125	finally
    //   126	133	140	finally
  }
  
  protected final boolean aKr()
  {
    GMTrace.i(17459176275968L, 130081);
    try
    {
      v.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", new Object[] { aKl(), this.nxZ });
      this.nyf = MediaCodec.createDecoderByType(this.nxZ);
      a(this.nyf);
      this.nyf.start();
      this.nyh = this.nyf.getInputBuffers();
      this.nyj = this.nyf.getOutputBuffers();
      GMTrace.o(17459176275968L, 130081);
      return true;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.TrackDataSource", localException, "%s prepare decoder init decoder error ", new Object[] { aKl() });
      this.nxT.AJ(aKe());
      GMTrace.o(17459176275968L, 130081);
    }
    return false;
  }
  
  public final boolean aKs()
  {
    GMTrace.i(12902215974912L, 96129);
    v.i("MicroMsg.TrackDataSource", "%s start to prepare path %s", new Object[] { aKl(), this.path });
    try
    {
      v.i("MicroMsg.TrackDataSource", "%s start to init extractor", new Object[] { aKl() });
      this.nyd = new MediaExtractor();
      this.nyd.setDataSource(this.path);
      int j = this.nyd.getTrackCount();
      this.nyb = -1;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          MediaFormat localMediaFormat = this.nyd.getTrackFormat(i);
          String str = localMediaFormat.getString("mime");
          if ((str != null) && (str.contains(aKe()))) {
            a(localMediaFormat, str, i);
          }
        }
        else
        {
          if (this.nyb >= 0) {
            break;
          }
          v.w("MicroMsg.TrackDataSource", "%s prepare track but can not find track index.[%d, %d]", new Object[] { aKl(), Integer.valueOf(j), Integer.valueOf(this.nyb) });
          this.nxT.AI("can not find ");
          GMTrace.o(12902215974912L, 96129);
          return false;
        }
        i += 1;
      }
      this.nyd.selectTrack(this.nyb);
      this.nye = null;
      return false;
    }
    catch (Exception localException1)
    {
      try
      {
        v.i("MicroMsg.TrackDataSource", "%s start to init decoder mime[%s] state[%d]", new Object[] { aKl(), this.nxZ, Integer.valueOf(this.state) });
        if (!d.pl(this.state))
        {
          this.nyf = MediaCodec.createDecoderByType(this.nxZ);
          a(this.nyf);
          this.nyf.start();
          this.nyh = this.nyf.getInputBuffers();
          this.nyj = this.nyf.getOutputBuffers();
        }
        setState(1);
        v.i("MicroMsg.TrackDataSource", "%s finish to prepare", new Object[] { aKl() });
        GMTrace.o(12902215974912L, 96129);
        return true;
      }
      catch (Exception localException2)
      {
        v.e("MicroMsg.TrackDataSource", "%s prepare init decoder error %s", new Object[] { aKl(), localException2.toString() });
        this.nxT.AJ(aKe());
        GMTrace.o(12902215974912L, 96129);
      }
      localException1 = localException1;
      v.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "%s prepare init extractor error", new Object[] { aKl() });
      this.nxT.AI(localException1.toString());
      GMTrace.o(12902215974912L, 96129);
      return false;
    }
    catch (Throwable localThrowable)
    {
      v.e("MicroMsg.TrackDataSource", "%s prepare init extractor error %s", new Object[] { aKl(), localThrowable.toString() });
      this.nxT.AI(localThrowable.toString());
      GMTrace.o(12902215974912L, 96129);
      return false;
    }
  }
  
  protected void b(MediaCodec paramMediaCodec)
  {
    GMTrace.i(12903289716736L, 96137);
    GMTrace.o(12903289716736L, 96137);
  }
  
  protected final int l(long paramLong1, long paramLong2)
  {
    GMTrace.i(12902350192640L, 96130);
    v.d("MicroMsg.TrackDataSource", "%s start to do some work time[%d %d] state %d", new Object[] { aKl(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.state) });
    if (this.nyf != null) {}
    int i;
    for (;;)
    {
      try
      {
        v.d("MicroMsg.TrackDataSource", "%s drain output buffer time[%d %d] index %d", new Object[] { aKl(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.nyi) });
        if (this.nyi < 0)
        {
          this.nyi = this.nyf.dequeueOutputBuffer(this.nyc, 0L);
          if (this.nyi < 0) {
            continue;
          }
          if ((this.nyc.flags & 0x4) != 0)
          {
            v.i("MicroMsg.TrackDataSource", "%s process end of stream", new Object[] { aKl() });
            setState(9);
            this.nyi = -1;
            i = 0;
            if (i != 0) {
              continue;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        ByteBuffer localByteBuffer;
        v.e("MicroMsg.TrackDataSource", "%s do some work drain output buffer error %s", new Object[] { aKl(), localException1.toString() });
        aKp();
        g localg = this.nxT;
        str = aKe();
        if ((localg.nxQ) || (!localg.nxL)) {
          continue;
        }
        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 158L, 1L, false);
        com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(506), Long.valueOf(bf.Nz()), str });
        localg.nxQ = true;
        continue;
        i = 0;
        continue;
        if (this.nyg < 0)
        {
          this.nyg = this.nyf.dequeueInputBuffer(0L);
          if (this.nyg < 0)
          {
            v.d("MicroMsg.TrackDataSource", "%s can not dequeue effect input buffer", new Object[] { aKl() });
            continue;
          }
        }
      }
      try
      {
        v.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", new Object[] { aKl(), Integer.valueOf(this.nyg), Integer.valueOf(this.state), Boolean.valueOf(this.nxV) });
        if ((!d.pl(this.state)) && (!this.nxV)) {
          continue;
        }
        v.i("MicroMsg.TrackDataSource", "%s feed input buffer is end.", new Object[] { aKl() });
      }
      catch (Exception localException2)
      {
        v.e("MicroMsg.TrackDataSource", "%s do some work feed input buffer error %s", new Object[] { aKl(), localException2.toString() });
        aKp();
        Object localObject = this.nxT;
        str = aKe();
        if ((((g)localObject).nxP) || (!((g)localObject).nxL)) {
          continue;
        }
        com.tencent.mm.plugin.report.service.g.oSF.a(354L, 157L, 1L, false);
        com.tencent.mm.plugin.report.service.g.oSF.i(13836, new Object[] { Integer.valueOf(505), Long.valueOf(bf.Nz()), str });
        ((g)localObject).nxP = true;
        continue;
        localObject = this.nyh[this.nyg];
        if (this.nye == null) {
          break label1072;
        }
        i = this.nye.n((ByteBuffer)localObject);
        paramLong1 = this.nye.nxA.ilM;
        int j = this.nye.nxA.ilN;
        v.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[] { aKl(), Integer.valueOf(this.nyg), Integer.valueOf(i), Long.valueOf(paramLong1), Integer.valueOf(j) });
        if (i > 0) {
          break label973;
        }
        this.nyf.queueInputBuffer(this.nyg, 0, 0, 0L, 4);
        this.nxV = true;
        continue;
        this.nyf.queueInputBuffer(this.nyg, 0, i, paramLong1, 0);
        this.nyg = -1;
        localObject = this.nye;
        ((f)localObject).nxB += 1;
        if (((f)localObject).nxB >= ((f)localObject).nxC) {
          continue;
        }
        ((f)localObject).nxA = ((com.tencent.mm.plugin.a.g)((f)localObject).ilK.get(((f)localObject).nxB));
        v.d("MicroMsg.Mp4Extractor", "curr sample [%s]", new Object[] { ((f)localObject).nxA });
        continue;
        if (!this.nxT.nxO) {
          break label1120;
        }
        this.nyf.queueInputBuffer(this.nyg, 0, 0, this.nya * 1000L, 4);
        this.nxV = true;
        this.nxT.nxO = false;
        continue;
        i = this.nyd.readSampleData((ByteBuffer)localObject, 0);
        paramLong1 = this.nyd.getSampleTime();
        j = this.nyd.getSampleFlags();
        v.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[] { aKl(), Integer.valueOf(this.nyg), Integer.valueOf(i), Long.valueOf(paramLong1), Integer.valueOf(j) });
        y(j, paramLong1);
        if (i > 0) {
          break label1244;
        }
        this.nyf.queueInputBuffer(this.nyg, 0, 0, this.nya * 1000L, 4);
        this.nxV = true;
        continue;
        this.nyf.queueInputBuffer(this.nyg, 0, i, paramLong1, 0);
        this.nyg = -1;
        this.nyd.advance();
        paramLong2 = this.nyd.getSampleTime();
        if (this.nxT.nxN) {
          break label1450;
        }
      }
      v.d("MicroMsg.TrackDataSource", "%s finish to do some work. state %d", new Object[] { aKl(), Integer.valueOf(this.state) });
      i = this.state;
      GMTrace.o(12902350192640L, 96130);
      return i;
      localByteBuffer = this.nyj[this.nyi];
      if (localByteBuffer != null)
      {
        localByteBuffer.position(this.nyc.offset);
        localByteBuffer.limit(this.nyc.offset + this.nyc.size);
      }
      if (this.state != 1) {
        continue;
      }
      i = 1;
      if (i != 0) {
        setState(2);
      }
      v.d("MicroMsg.TrackDataSource", "%s process output buffer index %d ", new Object[] { aKl(), Integer.valueOf(this.nyi) });
      if (a(paramLong1, paramLong2, this.nyf, this.nyj[this.nyi], this.nyi, this.nyc))
      {
        this.nyi = -1;
        i = 1;
        continue;
        if (this.nyi == -2)
        {
          this.nxY = this.nyf.getOutputFormat();
          b(this.nyf);
          i = 1;
        }
        else if (this.nyi == -3)
        {
          this.nyj = this.nyf.getOutputBuffers();
          i = 1;
        }
        else
        {
          v.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d]", new Object[] { aKl(), Integer.valueOf(this.nyi) });
        }
      }
    }
    String str;
    label973:
    label1072:
    label1120:
    label1244:
    long l;
    if (m(paramLong1, paramLong2))
    {
      v.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", new Object[] { aKl(), Boolean.valueOf(this.nxT.nxN), Long.valueOf(paramLong2), Long.valueOf(this.nxX) });
      l = this.nyd.getSampleTime();
      if (Math.abs(l - paramLong1) >= 1000000L)
      {
        v.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { aKl(), Long.valueOf(l), Long.valueOf(paramLong1) });
        this.nxT.nxO = true;
      }
    }
    for (;;)
    {
      v.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", new Object[] { aKl(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      break;
      label1450:
      if (this.nxX == 0L)
      {
        if (m(paramLong1, paramLong2))
        {
          v.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { aKl(), Long.valueOf(paramLong2), Long.valueOf(this.nxX) });
          l = this.nyd.getSampleTime();
          if (Math.abs(l - paramLong1) >= 3000000L)
          {
            v.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[] { aKl(), Long.valueOf(l), Long.valueOf(paramLong1) });
            this.nxU.obtainMessage(5, -2, -2).sendToTarget();
          }
          aKo();
        }
      }
      else if ((paramLong2 < 0L) || (paramLong2 / 1000L + 1200L > this.nxX))
      {
        v.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[] { aKl(), Long.valueOf(paramLong2), Long.valueOf(this.nxX) });
        if (m(paramLong1, -1L)) {
          this.nxU.obtainMessage(5, -3, -3).sendToTarget();
        }
        aKo();
      }
    }
  }
  
  protected final boolean m(long paramLong1, long paramLong2)
  {
    GMTrace.i(12902484410368L, 96131);
    long l1 = bf.NB();
    try
    {
      if ((paramLong1 / 1000L + 1000L < this.nya) && (paramLong2 == -1L))
      {
        this.nxT.nxM = true;
        this.nxV = false;
        this.nyd.release();
        this.nyd = new MediaExtractor();
        this.nyd.setDataSource(this.path);
        this.nyd.selectTrack(this.nyb);
        this.nyd.seekTo(paramLong1, 2);
        long l2 = this.nyd.getSampleTime();
        v.w("MicroMsg.TrackDataSource", "%s it don't play end. currTime[%d] afterSeek[%d] nextSampleTime[%d] onlineCacheMs[%d] cost[%d]", new Object[] { aKl(), Long.valueOf(paramLong1), Long.valueOf(l2), Long.valueOf(paramLong2), Long.valueOf(this.nxX), Long.valueOf(bf.aB(l1)) });
        GMTrace.o(12902484410368L, 96131);
        return true;
      }
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.TrackDataSource", "%s reset extractor error %s", new Object[] { aKl(), localException.toString() });
      GMTrace.o(12902484410368L, 96131);
    }
    return false;
  }
  
  protected void onPause()
  {
    GMTrace.i(12903558152192L, 96139);
    GMTrace.o(12903558152192L, 96139);
  }
  
  protected void onStart()
  {
    GMTrace.i(12903423934464L, 96138);
    GMTrace.o(12903423934464L, 96138);
  }
  
  public final void pause()
  {
    GMTrace.i(12901947539456L, 96127);
    v.i("MicroMsg.TrackDataSource", "%s start to pause", new Object[] { aKl() });
    setState(4);
    onPause();
    GMTrace.o(12901947539456L, 96127);
  }
  
  public final long pp(int paramInt)
  {
    GMTrace.i(12902081757184L, 96128);
    v.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", new Object[] { aKl(), Integer.valueOf(paramInt), Boolean.valueOf(this.nxV) });
    aKp();
    this.nxV = false;
    long l;
    if (this.nye != null) {
      for (;;)
      {
        try
        {
          f localf = this.nye;
          l = paramInt * 1000;
          int i = 0;
          if (i < localf.ilL.size())
          {
            Pair localPair = (Pair)localf.ilL.get(i);
            if (l >= ((Long)localPair.second).longValue())
            {
              if (l == ((Long)localPair.second).longValue())
              {
                localf.nxB = ((Integer)localPair.first).intValue();
                localf.nxA = ((com.tencent.mm.plugin.a.g)localf.ilK.get(localf.nxB));
                if (this.nye.nxA.ilM < 0L) {
                  m(paramInt * 1000, -1L);
                }
                if (this.nye.nxA.ilM < 0L)
                {
                  m(0L, -1L);
                  this.nxT.aKm();
                }
                l = this.nye.nxA.ilM;
                v.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", new Object[] { aKl(), Long.valueOf(l) });
                l /= 1000L;
                GMTrace.o(12902081757184L, 96128);
                return l;
              }
              i += 1;
              continue;
            }
          }
          if ((i == 0) || (i == localf.ilL.size() - 1))
          {
            localf.nxB = ((Integer)((Pair)localf.ilL.get(i)).first).intValue();
            localf.nxA = ((com.tencent.mm.plugin.a.g)localf.ilK.get(localf.nxB));
            continue;
          }
          localException1.nxB = ((Integer)((Pair)localException1.ilL.get(i - 1)).first).intValue();
        }
        catch (Exception localException1)
        {
          v.printErrStackTrace("MicroMsg.TrackDataSource", localException1, "%s extractor seek exception %s", new Object[] { aKl(), localException1.toString() });
          GMTrace.o(12902081757184L, 96128);
          return 0L;
        }
        localException1.nxA = ((com.tencent.mm.plugin.a.g)localException1.ilK.get(localException1.nxB));
      }
    }
    try
    {
      this.nyd.seekTo(paramInt * 1000, 0);
      if (this.nyd.getSampleTime() < 0L) {
        m(paramInt * 1000, -1L);
      }
      if (this.nyd.getSampleTime() < 0L)
      {
        m(0L, -1L);
        this.nxT.aKm();
      }
      l = this.nyd.getSampleTime();
      v.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d]", new Object[] { aKl(), Long.valueOf(l), Long.valueOf(this.nyd.getCachedDuration()) });
      l /= 1000L;
      GMTrace.o(12902081757184L, 96128);
      return l;
    }
    catch (Exception localException2)
    {
      v.printErrStackTrace("MicroMsg.TrackDataSource", localException2, "%s extractor seek exception %s", new Object[] { aKl(), localException2.toString() });
      GMTrace.o(12902081757184L, 96128);
    }
    return 0L;
  }
  
  public void release()
  {
    GMTrace.i(12901679104000L, 96125);
    v.i("MicroMsg.TrackDataSource", "%s release", new Object[] { aKl() });
    if (this.nyd != null)
    {
      this.nyd.release();
      this.nyd = null;
    }
    if (this.nyf != null)
    {
      this.nyf.release();
      this.nyf = null;
    }
    f localf;
    if (this.nye != null)
    {
      localf = this.nye;
      if (localf.nxz == null) {}
    }
    try
    {
      localf.nxz.close();
      localf.ilK.clear();
      localf.ilK = null;
      localf.ilL.clear();
      localf.ilL = null;
      localf.nxA = null;
      v.i("MicroMsg.TrackDataSource", "%s finish release", new Object[] { aKl() });
      GMTrace.o(12901679104000L, 96125);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public final void setPath(String paramString)
  {
    GMTrace.i(12901276450816L, 96122);
    this.path = paramString;
    GMTrace.o(12901276450816L, 96122);
  }
  
  protected final void setState(int paramInt)
  {
    GMTrace.i(12903692369920L, 96140);
    v.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", new Object[] { aKl(), Integer.valueOf(this.state), Integer.valueOf(paramInt) });
    this.state = paramInt;
    GMTrace.o(12903692369920L, 96140);
  }
  
  public final void start()
  {
    GMTrace.i(12901813321728L, 96126);
    v.i("MicroMsg.TrackDataSource", "%s start to play", new Object[] { aKl() });
    setState(3);
    onStart();
    GMTrace.o(12901813321728L, 96126);
  }
  
  protected boolean y(int paramInt, long paramLong)
  {
    GMTrace.i(12902618628096L, 96132);
    GMTrace.o(12902618628096L, 96132);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/s/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */