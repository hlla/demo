package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ShareElfFile
  implements Closeable
{
  private final FileInputStream jFT;
  private final Map<String, SectionHeader> xfE = new HashMap();
  public ElfHeader xfF = null;
  public ProgramHeader[] xfG = null;
  public SectionHeader[] xfH = null;
  
  public ShareElfFile(File paramFile)
  {
    this.jFT = new FileInputStream(paramFile);
    Object localObject = this.jFT.getChannel();
    this.xfF = new ElfHeader((FileChannel)localObject);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(128);
    localByteBuffer.limit(this.xfF.xfR);
    if (this.xfF.xfI[5] == 1) {}
    for (paramFile = ByteOrder.LITTLE_ENDIAN;; paramFile = ByteOrder.BIG_ENDIAN)
    {
      localByteBuffer.order(paramFile);
      ((FileChannel)localObject).position(this.xfF.xfN);
      this.xfG = new ProgramHeader[this.xfF.xfS];
      i = 0;
      while (i < this.xfG.length)
      {
        a((FileChannel)localObject, localByteBuffer, "failed to read phdr.");
        this.xfG[i] = new ProgramHeader(localByteBuffer, this.xfF.xfI[4]);
        i += 1;
      }
    }
    ((FileChannel)localObject).position(this.xfF.xfO);
    localByteBuffer.limit(this.xfF.xfT);
    this.xfH = new SectionHeader[this.xfF.xfU];
    int i = 0;
    while (i < this.xfH.length)
    {
      a((FileChannel)localObject, localByteBuffer, "failed to read shdr.");
      this.xfH[i] = new SectionHeader(localByteBuffer, this.xfF.xfI[4]);
      i += 1;
    }
    if (this.xfF.xfV > 0)
    {
      localObject = this.xfH[this.xfF.xfV];
      paramFile = ByteBuffer.allocate((int)((SectionHeader)localObject).xgj);
      this.jFT.getChannel().position(((SectionHeader)localObject).xgi);
      a(this.jFT.getChannel(), paramFile, "failed to read section: " + ((SectionHeader)localObject).xgo);
      localObject = this.xfH;
      int k = localObject.length;
      i = j;
      while (i < k)
      {
        localByteBuffer = localObject[i];
        paramFile.position(localByteBuffer.xge);
        localByteBuffer.xgo = o(paramFile);
        this.xfE.put(localByteBuffer.xgo, localByteBuffer);
        i += 1;
      }
    }
  }
  
  /* Error */
  public static int S(File paramFile)
  {
    // Byte code:
    //   0: iconst_4
    //   1: newarray <illegal type>
    //   3: astore_3
    //   4: new 46	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_3
    //   15: invokevirtual 176	java/io/InputStream:read	([B)I
    //   18: pop
    //   19: aload_3
    //   20: iconst_0
    //   21: baload
    //   22: bipush 100
    //   24: if_icmpne +35 -> 59
    //   27: aload_3
    //   28: iconst_1
    //   29: baload
    //   30: bipush 101
    //   32: if_icmpne +27 -> 59
    //   35: aload_3
    //   36: iconst_2
    //   37: baload
    //   38: bipush 121
    //   40: if_icmpne +19 -> 59
    //   43: aload_3
    //   44: iconst_3
    //   45: baload
    //   46: istore_1
    //   47: iload_1
    //   48: bipush 10
    //   50: if_icmpne +9 -> 59
    //   53: aload_2
    //   54: invokevirtual 179	java/io/InputStream:close	()V
    //   57: iconst_0
    //   58: ireturn
    //   59: aload_3
    //   60: iconst_0
    //   61: baload
    //   62: bipush 127
    //   64: if_icmpne +33 -> 97
    //   67: aload_3
    //   68: iconst_1
    //   69: baload
    //   70: bipush 69
    //   72: if_icmpne +25 -> 97
    //   75: aload_3
    //   76: iconst_2
    //   77: baload
    //   78: bipush 76
    //   80: if_icmpne +17 -> 97
    //   83: aload_3
    //   84: iconst_3
    //   85: baload
    //   86: bipush 70
    //   88: if_icmpne +9 -> 97
    //   91: aload_2
    //   92: invokevirtual 179	java/io/InputStream:close	()V
    //   95: iconst_1
    //   96: ireturn
    //   97: aload_2
    //   98: invokevirtual 179	java/io/InputStream:close	()V
    //   101: iconst_m1
    //   102: ireturn
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 179	java/io/InputStream:close	()V
    //   114: aload_0
    //   115: athrow
    //   116: astore_0
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_0
    //   120: goto -25 -> 95
    //   123: astore_0
    //   124: goto -23 -> 101
    //   127: astore_2
    //   128: goto -14 -> 114
    //   131: astore_0
    //   132: goto -26 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramFile	File
    //   46	5	1	i	int
    //   12	99	2	localFileInputStream	FileInputStream
    //   127	1	2	localThrowable	Throwable
    //   3	81	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	13	103	finally
    //   53	57	116	java/lang/Throwable
    //   91	95	119	java/lang/Throwable
    //   97	101	123	java/lang/Throwable
    //   110	114	127	java/lang/Throwable
    //   13	19	131	finally
  }
  
  public static void a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, String paramString)
  {
    paramByteBuffer.rewind();
    int i = paramFileChannel.read(paramByteBuffer);
    if (i != paramByteBuffer.limit()) {
      throw new IOException(paramString + " Rest bytes insufficient, expect to read " + paramByteBuffer.limit() + " bytes but only " + i + " bytes were read.");
    }
    paramByteBuffer.flip();
  }
  
  private static String o(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    int i = paramByteBuffer.position();
    while ((paramByteBuffer.hasRemaining()) && (arrayOfByte[paramByteBuffer.position()] != 0)) {
      paramByteBuffer.position(paramByteBuffer.position() + 1);
    }
    paramByteBuffer.position(paramByteBuffer.position() + 1);
    return new String(arrayOfByte, i, paramByteBuffer.position() - i - 1, Charset.forName("ASCII"));
  }
  
  public static void x(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 <= 0) || (paramInt1 > paramInt2)) {
      throw new IOException(paramString);
    }
  }
  
  public void close()
  {
    this.jFT.close();
    this.xfE.clear();
    this.xfG = null;
    this.xfH = null;
  }
  
  public static class ElfHeader
  {
    public final byte[] xfI = new byte[16];
    public final short xfJ;
    public final short xfK;
    public final int xfL;
    public final long xfM;
    public final long xfN;
    public final long xfO;
    public final int xfP;
    public final short xfQ;
    public final short xfR;
    public final short xfS;
    public final short xfT;
    public final short xfU;
    public final short xfV;
    
    public ElfHeader(FileChannel paramFileChannel)
    {
      paramFileChannel.position(0L);
      paramFileChannel.read(ByteBuffer.wrap(this.xfI));
      if ((this.xfI[0] != Byte.MAX_VALUE) || (this.xfI[1] != 69) || (this.xfI[2] != 76) || (this.xfI[3] != 70)) {
        throw new IOException(String.format("bad elf magic: %x %x %x %x.", new Object[] { Byte.valueOf(this.xfI[0]), Byte.valueOf(this.xfI[1]), Byte.valueOf(this.xfI[2]), Byte.valueOf(this.xfI[3]) }));
      }
      ShareElfFile.x(this.xfI[4], 2, "bad elf class: " + this.xfI[4]);
      ShareElfFile.x(this.xfI[5], 2, "bad elf data encoding: " + this.xfI[5]);
      int i;
      label214:
      ByteBuffer localByteBuffer;
      if (this.xfI[4] == 1)
      {
        i = 36;
        localByteBuffer = ByteBuffer.allocate(i);
        if (this.xfI[5] != 1) {
          break label367;
        }
      }
      label367:
      for (ByteOrder localByteOrder = ByteOrder.LITTLE_ENDIAN;; localByteOrder = ByteOrder.BIG_ENDIAN)
      {
        localByteBuffer.order(localByteOrder);
        ShareElfFile.a(paramFileChannel, localByteBuffer, "failed to read rest part of ehdr.");
        this.xfJ = localByteBuffer.getShort();
        this.xfK = localByteBuffer.getShort();
        this.xfL = localByteBuffer.getInt();
        ShareElfFile.x(this.xfL, 1, "bad elf version: " + this.xfL);
        switch (this.xfI[4])
        {
        default: 
          throw new IOException("Unexpected elf class: " + this.xfI[4]);
          i = 48;
          break label214;
        }
      }
      this.xfM = localByteBuffer.getInt();
      this.xfN = localByteBuffer.getInt();
      for (this.xfO = localByteBuffer.getInt();; this.xfO = localByteBuffer.getLong())
      {
        this.xfP = localByteBuffer.getInt();
        this.xfQ = localByteBuffer.getShort();
        this.xfR = localByteBuffer.getShort();
        this.xfS = localByteBuffer.getShort();
        this.xfT = localByteBuffer.getShort();
        this.xfU = localByteBuffer.getShort();
        this.xfV = localByteBuffer.getShort();
        return;
        this.xfM = localByteBuffer.getLong();
        this.xfN = localByteBuffer.getLong();
      }
    }
  }
  
  public static class ProgramHeader
  {
    public final int xfW;
    public final int xfX;
    public final long xfY;
    public final long xfZ;
    public final long xga;
    public final long xgb;
    public final long xgc;
    public final long xgd;
    
    public ProgramHeader(ByteBuffer paramByteBuffer, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IOException("Unexpected elf class: " + paramInt);
      case 1: 
        this.xfW = paramByteBuffer.getInt();
        this.xfY = paramByteBuffer.getInt();
        this.xfZ = paramByteBuffer.getInt();
        this.xga = paramByteBuffer.getInt();
        this.xgb = paramByteBuffer.getInt();
        this.xgc = paramByteBuffer.getInt();
        this.xfX = paramByteBuffer.getInt();
        this.xgd = paramByteBuffer.getInt();
        return;
      }
      this.xfW = paramByteBuffer.getInt();
      this.xfX = paramByteBuffer.getInt();
      this.xfY = paramByteBuffer.getLong();
      this.xfZ = paramByteBuffer.getLong();
      this.xga = paramByteBuffer.getLong();
      this.xgb = paramByteBuffer.getLong();
      this.xgc = paramByteBuffer.getLong();
      this.xgd = paramByteBuffer.getLong();
    }
  }
  
  public static class SectionHeader
  {
    public final int xge;
    public final int xgf;
    public final long xgg;
    public final long xgh;
    public final long xgi;
    public final long xgj;
    public final int xgk;
    public final int xgl;
    public final long xgm;
    public final long xgn;
    public String xgo;
    
    public SectionHeader(ByteBuffer paramByteBuffer, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IOException("Unexpected elf class: " + paramInt);
      case 1: 
        this.xge = paramByteBuffer.getInt();
        this.xgf = paramByteBuffer.getInt();
        this.xgg = paramByteBuffer.getInt();
        this.xgh = paramByteBuffer.getInt();
        this.xgi = paramByteBuffer.getInt();
        this.xgj = paramByteBuffer.getInt();
        this.xgk = paramByteBuffer.getInt();
        this.xgl = paramByteBuffer.getInt();
        this.xgm = paramByteBuffer.getInt();
      }
      for (this.xgn = paramByteBuffer.getInt();; this.xgn = paramByteBuffer.getLong())
      {
        this.xgo = null;
        return;
        this.xge = paramByteBuffer.getInt();
        this.xgf = paramByteBuffer.getInt();
        this.xgg = paramByteBuffer.getLong();
        this.xgh = paramByteBuffer.getLong();
        this.xgi = paramByteBuffer.getLong();
        this.xgj = paramByteBuffer.getLong();
        this.xgk = paramByteBuffer.getInt();
        this.xgl = paramByteBuffer.getInt();
        this.xgm = paramByteBuffer.getLong();
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/tinker/loader/shareutil/ShareElfFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */