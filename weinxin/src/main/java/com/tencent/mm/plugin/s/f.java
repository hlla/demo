package com.tencent.mm.plugin.s;

import android.util.Pair;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.a.g;
import com.tencent.mm.sdk.platformtools.v;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public final class f
{
  List<g> ilK;
  List<Pair> ilL;
  g nxA;
  int nxB;
  int nxC;
  RandomAccessFile nxz;
  
  public final int n(ByteBuffer paramByteBuffer)
  {
    GMTrace.i(17459847364608L, 130086);
    if (this.nxB >= this.nxC)
    {
      GMTrace.o(17459847364608L, 130086);
      return -1;
    }
    for (;;)
    {
      byte[] arrayOfByte;
      int i;
      int j;
      try
      {
        this.nxz.seek(this.nxA.start);
        arrayOfByte = new byte[this.nxA.size];
        i = this.nxz.read(arrayOfByte);
      }
      catch (Exception paramByteBuffer)
      {
        i = -1;
      }
      try
      {
        j = this.nxA.size;
        if (i < j)
        {
          GMTrace.o(17459847364608L, 130086);
          return -1;
        }
        arrayOfByte[0] = 0;
        arrayOfByte[1] = 0;
        arrayOfByte[2] = 0;
        arrayOfByte[3] = 1;
        j = 0;
      }
      catch (Exception paramByteBuffer)
      {
        for (;;) {}
      }
      paramByteBuffer.clear();
      paramByteBuffer.put(arrayOfByte, 0, i).flip();
      GMTrace.o(17459847364608L, 130086);
      return i;
      v.printErrStackTrace("MicroMsg.Mp4Extractor", paramByteBuffer, "read sample data error", new Object[0]);
      continue;
      while (j < i)
      {
        if ((arrayOfByte[j] == Byte.MIN_VALUE) && (j + 4 < i) && (arrayOfByte[(j + 1)] == 0) && (arrayOfByte[(j + 2)] == 0))
        {
          arrayOfByte[(j + 3)] = 0;
          arrayOfByte[(j + 4)] = 1;
        }
        j += 1;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/s/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */