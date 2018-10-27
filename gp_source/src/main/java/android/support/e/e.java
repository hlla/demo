package android.support.e;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class e
{
  static long a(File paramFile)
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    try
    {
      l2 = paramFile.length() - 22L;
      if (l2 < 0L) {
        break label276;
      }
      long l3 = -65536L + l2;
      l1 = l3;
      if (l3 < 0L) {
        l1 = 0L;
      }
      i = Integer.reverseBytes(101010256);
      do
      {
        paramFile.seek(l2);
        if (paramFile.readInt() == i) {
          break;
        }
        l3 = l2 - 1L;
        l2 = l3;
      } while (l3 >= l1);
      throw new ZipException("End Of Central Directory signature not found");
    }
    finally
    {
      paramFile.close();
    }
    paramFile.skipBytes(2);
    paramFile.skipBytes(2);
    paramFile.skipBytes(2);
    paramFile.skipBytes(2);
    Object localObject3 = new f();
    ((f)localObject3).b = (Integer.reverseBytes(paramFile.readInt()) & 0xFFFFFFFF);
    ((f)localObject3).a = (Integer.reverseBytes(paramFile.readInt()) & 0xFFFFFFFF);
    Object localObject2 = new CRC32();
    long l1 = ((f)localObject3).b;
    paramFile.seek(((f)localObject3).a);
    long l2 = Math.min(16384L, l1);
    localObject3 = new byte['䀀'];
    int i = paramFile.read((byte[])localObject3, 0, (int)l2);
    for (;;)
    {
      l1 = ((CRC32)localObject2).getValue();
      paramFile.close();
      return l1;
      label276:
      do
      {
        ((CRC32)localObject2).update((byte[])localObject3, 0, i);
        l1 -= i;
        if (l1 == 0L) {
          break;
        }
        i = paramFile.read((byte[])localObject3, 0, (int)Math.min(16384L, l1));
        continue;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("File too short to be a zip file: ");
        ((StringBuilder)localObject2).append(paramFile.length());
        throw new ZipException(((StringBuilder)localObject2).toString());
      } while (i != -1);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */