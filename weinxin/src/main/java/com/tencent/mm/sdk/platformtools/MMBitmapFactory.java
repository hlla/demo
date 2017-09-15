package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager.AssetInputStream;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.NinePatch;
import android.graphics.Rect;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.modelsfs.FileOp;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class MMBitmapFactory
{
  public static final int DECODER_ID_MMJPEG_DECODER = 2;
  public static final int DECODER_ID_MMPNG_DECODER = 0;
  public static final int DECODER_ID_MMVCODEC_DECODER = 1;
  private static final Bitmap.Config DEFAULT_BITMAP_CONFIG;
  private static final int DEFAULT_CHECK_STORAGE_SIZE = 8192;
  private static final int DEFAULT_DECODE_MARK_SIZE = 8388608;
  private static final int DEFAULT_DECODE_STORAGE_SIZE = 8192;
  public static final int DEFAULT_DECODE_STRATEGY = 1;
  public static final int ERROR_ALLOCATE_STRUCT_FAILED = 1001;
  public static final int ERROR_BEGIN_SAMPLE_FAILED = 1004;
  public static final int ERROR_GET_PIXEL_FORMAT_FAILED = 1003;
  public static final int ERROR_ILLEGAL_IDATA_CHUNK = 2003;
  public static final int ERROR_ILLEGAL_IMAGE_SIZE = 1008;
  public static final int ERROR_ILLEGAL_NPTC_CHUNK = 2002;
  public static final int ERROR_IMAGE_SIZE_IS_TOO_LARGE = 1007;
  public static final int ERROR_IMG_BUG_DETECTED_BEGIN = 2000;
  public static final int ERROR_IO_FAILED = 1005;
  public static final int ERROR_LOCK_BITMAP_FAILED = 1002;
  public static final int ERROR_PNG_BUG_DETECTED_BEGIN = 2001;
  public static final int ERROR_SUCCESS = 0;
  public static final int ERROR_UNSUPPORT_IMAGE_FORMAT = 1006;
  private static final int ERROR_USER_DEFINED_BEGIN = 3000;
  public static final int STRATEGY_AUTO_DETECT = 0;
  public static final int STRATEGY_FORCE_SYSTEM_DECODER = 1;
  private static final String TAG = "MicroMsg.MMBitmapFactory";
  private static boolean mIsInit;
  static Method mMthGetDefaultDensity;
  
  static
  {
    GMTrace.i(13767651885056L, 102577);
    mIsInit = false;
    DEFAULT_BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    mMthGetDefaultDensity = null;
    GMTrace.o(13767651885056L, 102577);
  }
  
  public MMBitmapFactory()
  {
    GMTrace.i(13759867256832L, 102519);
    GMTrace.o(13759867256832L, 102519);
  }
  
  private static boolean checkIfHaveToUseMMDecoder(BitmapFactory.Options paramOptions)
  {
    GMTrace.i(13766309707776L, 102567);
    if (paramOptions != null) {}
    for (String str = paramOptions.outMimeType;; str = "")
    {
      v.d("MicroMsg.MMBitmapFactory", "mimetype: %s", new Object[] { str });
      if ((paramOptions == null) || (paramOptions.outMimeType == null) || ((!paramOptions.outMimeType.toLowerCase().endsWith("png")) && (!paramOptions.outMimeType.toLowerCase().endsWith("vcodec")))) {
        break;
      }
      GMTrace.o(13766309707776L, 102567);
      return true;
    }
    GMTrace.o(13766309707776L, 102567);
    return false;
  }
  
  public static boolean checkIsImageLegal(InputStream paramInputStream)
  {
    GMTrace.i(13760806780928L, 102526);
    boolean bool = checkIsImageLegal(paramInputStream, null);
    GMTrace.o(13760806780928L, 102526);
    return bool;
  }
  
  public static boolean checkIsImageLegal(InputStream paramInputStream, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13761209434112L, 102529);
    boolean bool = checkIsImageLegalInternal(paramInputStream, paramDecodeResultLogger);
    GMTrace.o(13761209434112L, 102529);
    return bool;
  }
  
  public static boolean checkIsImageLegal(String paramString)
  {
    GMTrace.i(13760538345472L, 102524);
    boolean bool = checkIsImageLegal(paramString, null);
    GMTrace.o(13760538345472L, 102524);
    return bool;
  }
  
  public static boolean checkIsImageLegal(String paramString, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13760940998656L, 102527);
    if (paramString == null)
    {
      v.e("MicroMsg.MMBitmapFactory", "filePath is null.");
      if (paramDecodeResultLogger != null) {
        paramDecodeResultLogger.mDecodeResultCode = 1005;
      }
      GMTrace.o(13760940998656L, 102527);
      return false;
    }
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      long l = System.currentTimeMillis();
      boolean bool = checkIsImageLegalInternal(localFileInputStream, paramDecodeResultLogger);
      v.d("MicroMsg.MMBitmapFactory", "check [%s] res:%b, cost:%d ms", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
      GMTrace.o(13760940998656L, 102527);
      return bool;
    }
    catch (FileNotFoundException paramString)
    {
      v.printErrStackTrace("MicroMsg.MMBitmapFactory", paramString, "An exception was thrown.", new Object[0]);
      if (paramDecodeResultLogger != null) {
        paramDecodeResultLogger.mDecodeResultCode = 1005;
      }
      GMTrace.o(13760940998656L, 102527);
    }
    return false;
  }
  
  public static boolean checkIsImageLegal(byte[] paramArrayOfByte)
  {
    GMTrace.i(13760672563200L, 102525);
    boolean bool = checkIsImageLegal(paramArrayOfByte, null);
    GMTrace.o(13760672563200L, 102525);
    return bool;
  }
  
  public static boolean checkIsImageLegal(byte[] paramArrayOfByte, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13761075216384L, 102528);
    if (paramArrayOfByte == null)
    {
      v.e("MicroMsg.MMBitmapFactory", "buf is null.");
      if (paramDecodeResultLogger != null) {
        paramDecodeResultLogger.mDecodeResultCode = 1005;
      }
      GMTrace.o(13761075216384L, 102528);
      return false;
    }
    boolean bool = checkIsImageLegalInternal(new ByteArrayInputStream(paramArrayOfByte), paramDecodeResultLogger);
    GMTrace.o(13761075216384L, 102528);
    return bool;
  }
  
  private static boolean checkIsImageLegalInternal(InputStream paramInputStream, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13761343651840L, 102530);
    if (paramInputStream == null)
    {
      v.e("MicroMsg.MMBitmapFactory", "InputStream is null.");
      if (paramDecodeResultLogger != null) {
        paramDecodeResultLogger.mDecodeResultCode = 1005;
      }
      GMTrace.o(13761343651840L, 102530);
      return false;
    }
    if (!DynamicConfigStorage.getValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false))
    {
      GMTrace.o(13761343651840L, 102530);
      return true;
    }
    int i = nativeCheckIsImageLegal(paramInputStream, new byte[' '], paramDecodeResultLogger);
    if ((i == 0) || (i == 1006))
    {
      GMTrace.o(13761343651840L, 102530);
      return true;
    }
    GMTrace.o(13761343651840L, 102530);
    return false;
  }
  
  private static void checkIsInit()
  {
    GMTrace.i(13760001474560L, 102520);
    if (!mIsInit) {
      v.w("MicroMsg.MMBitmapFactory", "MMBitmapFactory is not initialized.");
    }
    GMTrace.o(13760001474560L, 102520);
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    GMTrace.i(13761477869568L, 102531);
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, null, null, 1, new int[0]);
    GMTrace.o(13761477869568L, 102531);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(13761612087296L, 102532);
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, null, null, paramInt3, new int[0]);
    GMTrace.o(13761612087296L, 102532);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    GMTrace.i(13761746305024L, 102533);
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, null, 1, new int[0]);
    GMTrace.o(13761746305024L, 102533);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3)
  {
    GMTrace.i(13761880522752L, 102534);
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, null, paramInt3, new int[0]);
    GMTrace.o(13761880522752L, 102534);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13762283175936L, 102537);
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger, 1, new int[0]);
    GMTrace.o(13762283175936L, 102537);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int paramInt3, int... paramVarArgs)
  {
    GMTrace.i(13762417393664L, 102538);
    long l = System.currentTimeMillis();
    paramArrayOfByte = decodeByteArrayInternal(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger, paramInt3, paramVarArgs);
    v.i("MicroMsg.MMBitmapFactory", "decode done, size:%d, cost:%d ms", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis() - l) });
    GMTrace.o(13762417393664L, 102538);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13762014740480L, 102535);
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, null, paramDecodeResultLogger, 1, new int[0]);
    GMTrace.o(13762014740480L, 102535);
    return paramArrayOfByte;
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, DecodeResultLogger paramDecodeResultLogger, int paramInt3, int... paramVarArgs)
  {
    GMTrace.i(13762148958208L, 102536);
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, null, paramDecodeResultLogger, paramInt3, paramVarArgs);
    GMTrace.o(13762148958208L, 102536);
    return paramArrayOfByte;
  }
  
  private static Bitmap decodeByteArrayInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int paramInt3, int... paramVarArgs)
  {
    GMTrace.i(13762551611392L, 102539);
    checkIsInit();
    boolean bool = DynamicConfigStorage.getValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false);
    if (bool) {
      switch (paramInt3)
      {
      default: 
        v.i("MicroMsg.MMBitmapFactory", "Decoded by system BitmapFactory directly, isEnabled:%b", new Object[] { Boolean.valueOf(bool) });
        paramArrayOfByte = decodeByteArrayWithSystemDecoder(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger);
      }
    }
    for (;;)
    {
      GMTrace.o(13762551611392L, 102539);
      return paramArrayOfByte;
      paramArrayOfByte = decodeByteArrayWithMMDecoderIfPossible(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger, paramVarArgs);
      continue;
      v.i("MicroMsg.MMBitmapFactory", "Decoded by system BitmapFactory directly since strategy, isEnabled:%b", new Object[] { Boolean.valueOf(bool) });
      paramArrayOfByte = decodeByteArrayWithSystemDecoder(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger);
    }
  }
  
  private static Bitmap decodeByteArrayWithMMDecoderIfPossible(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int... paramVarArgs)
  {
    GMTrace.i(13762685829120L, 102540);
    if (paramDecodeResultLogger == null) {}
    for (;;)
    {
      try
      {
        localObject = new DecodeResultLogger();
        paramDecodeResultLogger = (DecodeResultLogger)localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject;
        paramVarArgs = null;
        continue;
      }
      try
      {
        localObject = nativeDecodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger, paramVarArgs);
        paramVarArgs = (int[])localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        paramVarArgs = null;
        continue;
      }
      try
      {
        if (paramDecodeResultLogger.mDecodeResultCode == 0) {
          continue;
        }
        paramVarArgs = (int[])localObject;
        if (paramDecodeResultLogger.mDecodeResultCode >= 2000) {
          continue;
        }
        paramVarArgs = (int[])localObject;
        v.i("MicroMsg.MMBitmapFactory", "mmimgdec decoder decodes failed, try system BitmapFactory.");
        paramVarArgs = (int[])localObject;
        paramDecodeResultLogger.mIsDecodeByMMDecoder = false;
        paramVarArgs = (int[])localObject;
        localObject = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
        if (localObject == null)
        {
          if (paramOptions == null) {
            continue;
          }
          paramVarArgs = (int[])localObject;
          if (!paramOptions.inJustDecodeBounds) {
            continue;
          }
          paramVarArgs = (int[])localObject;
          if (paramOptions.outWidth < 0) {
            continue;
          }
          paramVarArgs = (int[])localObject;
          if (paramOptions.outHeight < 0) {
            continue;
          }
        }
        paramVarArgs = (int[])localObject;
        v.i("MicroMsg.MMBitmapFactory", "System decoder decodes success.");
        paramVarArgs = (int[])localObject;
        paramDecodeResultLogger.mDecodeResultCode = 0;
        paramArrayOfByte = paramDecodeResultLogger;
        paramVarArgs = (int[])localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        v.printErrStackTrace("MicroMsg.MMBitmapFactory", paramArrayOfByte, "An exception was thrown when decode image.", new Object[0]);
        paramDecodeResultLogger.mDecodeResultCode = 1005;
        paramArrayOfByte = paramDecodeResultLogger;
        continue;
        paramVarArgs = (int[])localObject;
        v.i("MicroMsg.MMBitmapFactory", "decoder [%s] decodes done, ret:%d.", new Object[] { paramDecodeResultLogger.mDecoderTag, Integer.valueOf(paramDecodeResultLogger.mDecodeResultCode) });
        paramVarArgs = (int[])localObject;
        paramArrayOfByte = paramDecodeResultLogger;
        if (localObject == null) {
          continue;
        }
        paramArrayOfByte = (byte[])localObject;
        if (paramOptions == null) {
          continue;
        }
        paramVarArgs = (int[])localObject;
        paramArrayOfByte = (byte[])localObject;
        if (!paramOptions.inScaled) {
          continue;
        }
        paramVarArgs = (int[])localObject;
        paramArrayOfByte = (byte[])localObject;
        if (paramOptions.inJustDecodeBounds) {
          continue;
        }
        paramVarArgs = (int[])localObject;
        paramArrayOfByte = getScaledBitmap((Bitmap)localObject, paramOptions);
        paramVarArgs = paramArrayOfByte;
        setDensityFromOptions(paramArrayOfByte, paramOptions);
        paramVarArgs = paramArrayOfByte;
        paramArrayOfByte = paramDecodeResultLogger;
        continue;
      }
      v.i("MicroMsg.MMBitmapFactory", paramArrayOfByte.toLogString());
      GMTrace.o(13762685829120L, 102540);
      return paramVarArgs;
      paramVarArgs = (int[])localObject;
      v.w("MicroMsg.MMBitmapFactory", "System decoder decodes failed.");
      paramVarArgs = (int[])localObject;
      paramDecodeResultLogger.mDecodeResultCode = 1006;
      paramVarArgs = (int[])localObject;
      paramArrayOfByte = paramDecodeResultLogger;
    }
  }
  
  private static Bitmap decodeByteArrayWithSystemDecoder(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13762820046848L, 102541);
    paramOptions = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
    if (paramDecodeResultLogger != null)
    {
      paramDecodeResultLogger.clear();
      if (paramOptions != null)
      {
        paramInt1 = 0;
        paramDecodeResultLogger.mDecodeResultCode = paramInt1;
        paramDecodeResultLogger.mIsDecodeByMMDecoder = false;
      }
    }
    else
    {
      if (paramOptions == null) {
        break label88;
      }
    }
    label88:
    for (paramArrayOfByte = paramOptions.toString();; paramArrayOfByte = "null")
    {
      v.i("MicroMsg.MMBitmapFactory", "decode bytearray by system decoder done, res: %s", new Object[] { paramArrayOfByte });
      GMTrace.o(13762820046848L, 102541);
      return paramOptions;
      paramInt1 = 1006;
      break;
    }
  }
  
  public static Bitmap decodeFile(String paramString)
  {
    GMTrace.i(13762954264576L, 102542);
    paramString = decodeFile(paramString, null, null, 1, new int[0]);
    GMTrace.o(13762954264576L, 102542);
    return paramString;
  }
  
  public static Bitmap decodeFile(String paramString, int paramInt)
  {
    GMTrace.i(13763088482304L, 102543);
    paramString = decodeFile(paramString, null, null, paramInt, new int[0]);
    GMTrace.o(13763088482304L, 102543);
    return paramString;
  }
  
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    GMTrace.i(13763222700032L, 102544);
    paramString = decodeFile(paramString, paramOptions, null, 1, new int[0]);
    GMTrace.o(13763222700032L, 102544);
    return paramString;
  }
  
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions, int paramInt)
  {
    GMTrace.i(13763356917760L, 102545);
    paramString = decodeFile(paramString, paramOptions, null, paramInt, new int[0]);
    GMTrace.o(13763356917760L, 102545);
    return paramString;
  }
  
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int paramInt, int... paramVarArgs)
  {
    GMTrace.i(13763759570944L, 102548);
    try
    {
      paramString = decodeStream(FileOp.openRead(paramString), null, paramOptions, paramDecodeResultLogger, paramInt, paramVarArgs);
      GMTrace.o(13763759570944L, 102548);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      GMTrace.o(13763759570944L, 102548);
    }
    return null;
  }
  
  public static Bitmap decodeFile(String paramString, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13763491135488L, 102546);
    paramString = decodeFile(paramString, null, paramDecodeResultLogger, 1, new int[0]);
    GMTrace.o(13763491135488L, 102546);
    return paramString;
  }
  
  public static Bitmap decodeFile(String paramString, DecodeResultLogger paramDecodeResultLogger, int paramInt)
  {
    GMTrace.i(13763625353216L, 102547);
    paramString = decodeFile(paramString, null, paramDecodeResultLogger, paramInt, new int[0]);
    GMTrace.o(13763625353216L, 102547);
    return paramString;
  }
  
  public static Bitmap decodeFileDescriptor(FileDescriptor paramFileDescriptor, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13766175490048L, 102566);
    if (!checkIfHaveToUseMMDecoder(paramOptions)) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, paramOptions);
        if (localBitmap == null) {
          break label78;
        }
        paramFileDescriptor = localBitmap;
        if (paramDecodeResultLogger != null)
        {
          paramDecodeResultLogger.clear();
          paramDecodeResultLogger.mDecodeResultCode = 0;
          paramDecodeResultLogger.mIsDecodeByMMDecoder = false;
          paramFileDescriptor = localBitmap;
        }
        GMTrace.o(13766175490048L, 102566);
        return paramFileDescriptor;
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.MMBitmapFactory", localException, "", new Object[0]);
      }
      Object localObject = null;
      continue;
      label78:
      v.d("MicroMsg.MMBitmapFactory", "decodeFileDescriptor, fallback");
      paramFileDescriptor = decodeStream(new FileInputStream(paramFileDescriptor), null, paramOptions, paramDecodeResultLogger, 0, new int[0]);
    }
  }
  
  public static Bitmap decodeRegion(FileDescriptor paramFileDescriptor, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13765638619136L, 102562);
    if (!checkIfHaveToUseMMDecoder(paramOptions)) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap = BitmapRegionDecoder.newInstance(paramFileDescriptor, true).decodeRegion(paramRect, paramOptions);
        if (localBitmap == null) {
          break label89;
        }
        paramFileDescriptor = localBitmap;
        if (paramDecodeResultLogger != null)
        {
          paramDecodeResultLogger.clear();
          paramDecodeResultLogger.mDecodeResultCode = 0;
          paramDecodeResultLogger.mIsDecodeByMMDecoder = false;
          paramFileDescriptor = localBitmap;
        }
        GMTrace.o(13765638619136L, 102562);
        return paramFileDescriptor;
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.MMBitmapFactory", localException, "", new Object[0]);
      }
      Object localObject = null;
      continue;
      label89:
      v.d("MicroMsg.MMBitmapFactory", "decodeRegion with FileDescriptor, fallback");
      paramFileDescriptor = decodeRegionFallback(new FileInputStream(paramFileDescriptor), paramRect, paramOptions, paramDecodeResultLogger);
    }
  }
  
  public static Bitmap decodeRegion(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13765504401408L, 102561);
    if (!checkIfHaveToUseMMDecoder(paramOptions)) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap = BitmapRegionDecoder.newInstance(paramInputStream, true).decodeRegion(paramRect, paramOptions);
        if (localBitmap == null) {
          break label89;
        }
        paramInputStream = localBitmap;
        if (paramDecodeResultLogger != null)
        {
          paramDecodeResultLogger.clear();
          paramDecodeResultLogger.mDecodeResultCode = 0;
          paramDecodeResultLogger.mIsDecodeByMMDecoder = false;
          paramInputStream = localBitmap;
        }
        GMTrace.o(13765504401408L, 102561);
        return paramInputStream;
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.MMBitmapFactory", localException, "", new Object[0]);
      }
      Object localObject = null;
      continue;
      label89:
      v.d("MicroMsg.MMBitmapFactory", "decodeRegion with inputStream, fallback");
      paramInputStream = decodeRegionFallback(paramInputStream, paramRect, paramOptions, paramDecodeResultLogger);
    }
  }
  
  public static Bitmap decodeRegion(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13765772836864L, 102563);
    if (!checkIfHaveToUseMMDecoder(paramOptions)) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap = BitmapRegionDecoder.newInstance(paramArrayOfByte, paramInt1, paramInt2, true).decodeRegion(paramRect, paramOptions);
        if (localBitmap == null) {
          break label97;
        }
        paramArrayOfByte = localBitmap;
        if (paramDecodeResultLogger != null)
        {
          paramDecodeResultLogger.clear();
          paramDecodeResultLogger.mDecodeResultCode = 0;
          paramDecodeResultLogger.mIsDecodeByMMDecoder = false;
          paramArrayOfByte = localBitmap;
        }
        GMTrace.o(13765772836864L, 102563);
        return paramArrayOfByte;
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.MMBitmapFactory", localException, "", new Object[0]);
      }
      Object localObject = null;
      continue;
      label97:
      v.d("MicroMsg.MMBitmapFactory", "decodeRegion with bytes, fallback");
      paramArrayOfByte = decodeRegionFallback(paramArrayOfByte, paramInt1, paramInt2, paramRect, paramOptions, paramDecodeResultLogger);
    }
  }
  
  private static Bitmap decodeRegionFallback(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13765907054592L, 102564);
    paramInputStream = decodeStream(paramInputStream, null, paramOptions, paramDecodeResultLogger, 0, new int[0]);
    if (paramInputStream != null)
    {
      paramInputStream = Bitmap.createBitmap(paramInputStream, paramRect.left, paramRect.top, paramRect.right - paramRect.left, paramRect.bottom - paramRect.top);
      GMTrace.o(13765907054592L, 102564);
      return paramInputStream;
    }
    GMTrace.o(13765907054592L, 102564);
    return null;
  }
  
  private static Bitmap decodeRegionFallback(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13766041272320L, 102565);
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger, 0, new int[0]);
    if (paramArrayOfByte != null)
    {
      paramArrayOfByte = Bitmap.createBitmap(paramArrayOfByte, paramRect.left, paramRect.top, paramRect.right - paramRect.left, paramRect.bottom - paramRect.top);
      GMTrace.o(13766041272320L, 102565);
      return paramArrayOfByte;
    }
    GMTrace.o(13766041272320L, 102565);
    return null;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream)
  {
    GMTrace.i(13763893788672L, 102549);
    paramInputStream = decodeStream(paramInputStream, null, null, null, 1, new int[0]);
    GMTrace.o(13763893788672L, 102549);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, int paramInt)
  {
    GMTrace.i(13764028006400L, 102550);
    paramInputStream = decodeStream(paramInputStream, null, null, null, paramInt, new int[0]);
    GMTrace.o(13764028006400L, 102550);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    GMTrace.i(13764162224128L, 102551);
    paramInputStream = decodeStream(paramInputStream, paramRect, paramOptions, null, 1, new int[0]);
    GMTrace.o(13764162224128L, 102551);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, int paramInt)
  {
    GMTrace.i(13764296441856L, 102552);
    paramInputStream = decodeStream(paramInputStream, paramRect, paramOptions, null, paramInt, new int[0]);
    GMTrace.o(13764296441856L, 102552);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int paramInt, int... paramVarArgs)
  {
    GMTrace.i(13764699095040L, 102555);
    long l2 = System.currentTimeMillis();
    try
    {
      int i = paramInputStream.available();
      l1 = i;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        long l1 = -1L;
      }
    }
    paramInputStream = decodeStreamInternal(paramInputStream, paramRect, paramOptions, paramDecodeResultLogger, paramInt, paramVarArgs);
    v.i("MicroMsg.MMBitmapFactory", "decode done, size:%d, cost:%d ms", new Object[] { Long.valueOf(l1), Long.valueOf(System.currentTimeMillis() - l2) });
    GMTrace.o(13764699095040L, 102555);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13764430659584L, 102553);
    paramInputStream = decodeStream(paramInputStream, null, null, paramDecodeResultLogger, 1, new int[0]);
    GMTrace.o(13764430659584L, 102553);
    return paramInputStream;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, DecodeResultLogger paramDecodeResultLogger, int paramInt, int... paramVarArgs)
  {
    GMTrace.i(13764564877312L, 102554);
    paramInputStream = decodeStream(paramInputStream, null, null, paramDecodeResultLogger, paramInt, paramVarArgs);
    GMTrace.o(13764564877312L, 102554);
    return paramInputStream;
  }
  
  private static Bitmap decodeStreamInternal(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int paramInt, int... paramVarArgs)
  {
    GMTrace.i(13764833312768L, 102556);
    checkIsInit();
    boolean bool = DynamicConfigStorage.getValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false);
    if ((bool) && (!(paramInputStream instanceof AssetManager.AssetInputStream))) {
      switch (paramInt)
      {
      default: 
        v.i("MicroMsg.MMBitmapFactory", "Decoded by system BitmapFactory directly, isEnabled:%b", new Object[] { Boolean.valueOf(bool) });
        paramInputStream = decodeStreamWithSystemDecoder(paramInputStream, paramRect, paramOptions, paramDecodeResultLogger);
      }
    }
    for (;;)
    {
      GMTrace.o(13764833312768L, 102556);
      return paramInputStream;
      paramInputStream = decodeStreamWithMMDecoderIfPossible(paramInputStream, paramRect, paramOptions, paramDecodeResultLogger, paramVarArgs);
      continue;
      v.i("MicroMsg.MMBitmapFactory", "Decoded by system BitmapFactory directly, isEnabled:%b", new Object[] { Boolean.valueOf(bool) });
      paramInputStream = decodeStreamWithSystemDecoder(paramInputStream, paramRect, paramOptions, paramDecodeResultLogger);
    }
  }
  
  private static Bitmap decodeStreamWithMMDecoderIfPossible(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int... paramVarArgs)
  {
    GMTrace.i(13764967530496L, 102557);
    Object localObject1 = null;
    if (paramOptions != null) {
      localObject1 = paramOptions.inTempStorage;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new byte[' '];
    }
    if (!paramInputStream.markSupported()) {
      if ((paramInputStream instanceof FileInputStream)) {
        localObject1 = new i((FileInputStream)paramInputStream);
      }
    }
    for (;;)
    {
      try
      {
        ((InputStream)localObject1).mark(8388608);
        if (paramDecodeResultLogger != null) {
          continue;
        }
        paramInputStream = new DecodeResultLogger();
        paramDecodeResultLogger = paramInputStream;
      }
      catch (IOException paramRect)
      {
        paramInputStream = null;
        continue;
        continue;
      }
      try
      {
        paramVarArgs = nativeDecodeStream((InputStream)localObject1, (byte[])localObject2, paramRect, paramOptions, paramDecodeResultLogger, paramVarArgs);
        paramInputStream = paramVarArgs;
      }
      catch (IOException paramRect)
      {
        paramInputStream = null;
        continue;
      }
      try
      {
        if (paramDecodeResultLogger.mDecodeResultCode == 0) {
          continue;
        }
        paramInputStream = paramVarArgs;
        if (paramDecodeResultLogger.mDecodeResultCode >= 2000) {
          continue;
        }
        paramInputStream = paramVarArgs;
        v.i("MicroMsg.MMBitmapFactory", "mmimgdec decoder decodes failed, try system BitmapFactory.");
        paramInputStream = paramVarArgs;
        paramDecodeResultLogger.mIsDecodeByMMDecoder = false;
        paramInputStream = paramVarArgs;
        ((InputStream)localObject1).reset();
        paramInputStream = paramVarArgs;
        ((InputStream)localObject1).mark(8388608);
        paramInputStream = paramVarArgs;
        paramRect = BitmapFactory.decodeStream((InputStream)localObject1, paramRect, paramOptions);
        if (paramRect == null)
        {
          if (paramOptions == null) {
            continue;
          }
          paramInputStream = paramRect;
          if (!paramOptions.inJustDecodeBounds) {
            continue;
          }
          paramInputStream = paramRect;
          if (paramOptions.outWidth < 0) {
            continue;
          }
          paramInputStream = paramRect;
          if (paramOptions.outHeight < 0) {
            continue;
          }
        }
        paramInputStream = paramRect;
        v.i("MicroMsg.MMBitmapFactory", "System decoder decodes success.");
        paramInputStream = paramRect;
        paramDecodeResultLogger.mDecodeResultCode = 0;
      }
      catch (IOException paramRect)
      {
        v.printErrStackTrace("MicroMsg.MMBitmapFactory", paramRect, "An exception was thrown when decode image.", new Object[0]);
        paramDecodeResultLogger.mDecodeResultCode = 1005;
        continue;
        paramInputStream = paramVarArgs;
        v.i("MicroMsg.MMBitmapFactory", "decoder [%s] decodes done, ret:%d.", new Object[] { paramDecodeResultLogger.mDecoderTag, Integer.valueOf(paramDecodeResultLogger.mDecodeResultCode) });
        paramRect = paramVarArgs;
        if (paramVarArgs == null) {
          continue;
        }
        paramRect = paramVarArgs;
        if (paramOptions == null) {
          continue;
        }
        paramInputStream = paramVarArgs;
        paramRect = paramVarArgs;
        if (!paramOptions.inScaled) {
          continue;
        }
        paramInputStream = paramVarArgs;
        paramRect = paramVarArgs;
        if (paramOptions.inJustDecodeBounds) {
          continue;
        }
        paramInputStream = paramVarArgs;
        paramRect = getScaledBitmap(paramVarArgs, paramOptions);
        paramInputStream = paramRect;
        setDensityFromOptions(paramRect, paramOptions);
        continue;
      }
      paramInputStream = paramRect;
      ((InputStream)localObject1).reset();
      paramInputStream = paramRect;
      ((InputStream)localObject1).mark(8388608);
      paramInputStream = paramRect;
      v.i("MicroMsg.MMBitmapFactory", paramDecodeResultLogger.toLogString());
      GMTrace.o(13764967530496L, 102557);
      return paramInputStream;
      localObject1 = new BufferedInputStream(paramInputStream);
      continue;
      paramInputStream = paramRect;
      v.w("MicroMsg.MMBitmapFactory", "System decoder decodes failed.");
      paramInputStream = paramRect;
      paramDecodeResultLogger.mDecodeResultCode = 1006;
      continue;
      localObject1 = paramInputStream;
    }
  }
  
  private static Bitmap decodeStreamWithSystemDecoder(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    GMTrace.i(13765101748224L, 102558);
    paramRect = BitmapFactory.decodeStream(paramInputStream, paramRect, paramOptions);
    int i;
    if (paramDecodeResultLogger != null)
    {
      paramDecodeResultLogger.clear();
      if (paramRect != null)
      {
        i = 0;
        paramDecodeResultLogger.mDecodeResultCode = i;
        paramDecodeResultLogger.mIsDecodeByMMDecoder = false;
      }
    }
    else
    {
      if (paramRect == null) {
        break label86;
      }
    }
    label86:
    for (paramInputStream = paramRect.toString();; paramInputStream = "null")
    {
      v.i("MicroMsg.MMBitmapFactory", "decode stream by system decoder done, res: %s", new Object[] { paramInputStream });
      GMTrace.o(13765101748224L, 102558);
      return paramRect;
      i = 1006;
      break;
    }
  }
  
  private static Bitmap getScaledBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    GMTrace.i(13765235965952L, 102559);
    int i = paramOptions.inDensity;
    int j = paramOptions.inTargetDensity;
    int k = paramOptions.inScreenDensity;
    if ((i != 0) && (j != 0) && (i != k)) {}
    for (float f = j / i;; f = 1.0F)
    {
      if (f != 1.0F) {}
      for (i = 1;; i = 0)
      {
        paramOptions = paramBitmap;
        if (i != 0) {
          paramOptions = Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * f + 0.5F), (int)(f * paramBitmap.getHeight() + 0.5F), true);
        }
        GMTrace.o(13765235965952L, 102559);
        return paramOptions;
      }
    }
  }
  
  public static boolean init()
  {
    GMTrace.i(13760135692288L, 102521);
    if (m.rs()) {
      d.u(aa.getContext(), "libvoipCodec_v7a.so");
    }
    boolean bool = nativeInit(new String[] { new File(aa.getContext().getDir("lib", 0), "libvoipCodec_v7a.so").getAbsolutePath() });
    mIsInit = bool;
    if (!bool)
    {
      DynamicConfigStorage.setValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false);
      v.w("MicroMsg.MMBitmapFactory", "MMBitmapFactory initialize failed, force use system BitmapFactory instead.");
    }
    bool = mIsInit;
    GMTrace.o(13760135692288L, 102521);
    return bool;
  }
  
  private static native int nativeCheckIsImageLegal(InputStream paramInputStream, byte[] paramArrayOfByte, DecodeResultLogger paramDecodeResultLogger);
  
  private static native Bitmap nativeDecodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int... paramVarArgs);
  
  private static native Bitmap nativeDecodeStream(InputStream paramInputStream, byte[] paramArrayOfByte, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int... paramVarArgs);
  
  private static native boolean nativeInit(String... paramVarArgs);
  
  private static native int nativePinBitmap(Bitmap paramBitmap);
  
  private static native boolean nativeSwitchDecoder(int paramInt, boolean paramBoolean);
  
  private static native int nativeUnPinBitmap(Bitmap paramBitmap);
  
  public static Bitmap pinBitmap(Bitmap paramBitmap)
  {
    GMTrace.i(13766443925504L, 102568);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (nativePinBitmap(paramBitmap) < 0)) {
      v.e("MicroMsg.MMBitmapFactory", "pinBitmap failed");
    }
    GMTrace.o(13766443925504L, 102568);
    return paramBitmap;
  }
  
  private static void setDensityFromOptions(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int i = 1;
    GMTrace.i(13765370183680L, 102560);
    if ((paramBitmap == null) || (paramOptions == null))
    {
      GMTrace.o(13765370183680L, 102560);
      return;
    }
    int k = paramOptions.inDensity;
    if (k != 0)
    {
      paramBitmap.setDensity(k);
      int j = paramOptions.inTargetDensity;
      if ((j == 0) || (k == j) || (k == paramOptions.inScreenDensity))
      {
        GMTrace.o(13765370183680L, 102560);
        return;
      }
      byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
      if ((arrayOfByte != null) && (NinePatch.isNinePatchChunk(arrayOfByte))) {}
      for (;;)
      {
        if ((paramOptions.inScaled) || (i != 0)) {
          paramBitmap.setDensity(j);
        }
        GMTrace.o(13765370183680L, 102560);
        return;
        i = 0;
      }
    }
    if (paramOptions.inBitmap != null) {
      try
      {
        if (mMthGetDefaultDensity == null)
        {
          paramOptions = Bitmap.class.getDeclaredMethod("getDefaultDensity", null);
          mMthGetDefaultDensity = paramOptions;
          paramOptions.setAccessible(true);
        }
        paramBitmap.setDensity(((Integer)mMthGetDefaultDensity.invoke(null, new Object[0])).intValue());
        GMTrace.o(13765370183680L, 102560);
        return;
      }
      catch (Exception paramOptions)
      {
        paramBitmap.setDensity(160);
      }
    }
    GMTrace.o(13765370183680L, 102560);
  }
  
  public static void setUseMMBitmapFactory(boolean paramBoolean)
  {
    GMTrace.i(13760269910016L, 102522);
    if (mIsInit)
    {
      DynamicConfigStorage.setValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, paramBoolean);
      if (!paramBoolean) {
        v.i("MicroMsg.MMBitmapFactory", "MMBitmapFactory is switched off, use system BitmapFactory directly.");
      }
    }
    GMTrace.o(13760269910016L, 102522);
  }
  
  public static boolean switchDecoder(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(13760404127744L, 102523);
    paramBoolean = nativeSwitchDecoder(paramInt, paramBoolean);
    GMTrace.o(13760404127744L, 102523);
    return paramBoolean;
  }
  
  public static Bitmap unPinBitmap(Bitmap paramBitmap)
  {
    GMTrace.i(13766578143232L, 102569);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (nativeUnPinBitmap(paramBitmap) < 0)) {
      v.e("MicroMsg.MMBitmapFactory", "unpinBitmap failed");
    }
    GMTrace.o(13766578143232L, 102569);
    return paramBitmap;
  }
  
  public static class DecodeResultLogger
  {
    public int mDecodeResultCode;
    public String mDecoderTag;
    public boolean mIsDecodeByMMDecoder;
    
    public DecodeResultLogger()
    {
      GMTrace.i(13748056096768L, 102431);
      this.mDecoderTag = null;
      clear();
      GMTrace.o(13748056096768L, 102431);
    }
    
    private void fillerForNative(int paramInt, boolean paramBoolean, String paramString)
    {
      GMTrace.i(13748190314496L, 102432);
      this.mDecodeResultCode = paramInt;
      this.mIsDecodeByMMDecoder = paramBoolean;
      String str;
      if (paramString != null)
      {
        str = paramString;
        if (paramString.length() != 0) {}
      }
      else
      {
        str = "System";
      }
      this.mDecoderTag = str;
      GMTrace.o(13748190314496L, 102432);
    }
    
    public void clear()
    {
      GMTrace.i(13748861403136L, 102437);
      this.mDecodeResultCode = 0;
      this.mIsDecodeByMMDecoder = false;
      this.mDecoderTag = "System";
      GMTrace.o(13748861403136L, 102437);
    }
    
    public int getDecodeResult()
    {
      GMTrace.i(13748324532224L, 102433);
      int i = this.mDecodeResultCode;
      GMTrace.o(13748324532224L, 102433);
      return i;
    }
    
    public String getDecoderTag()
    {
      GMTrace.i(13748727185408L, 102436);
      String str = this.mDecoderTag;
      GMTrace.o(13748727185408L, 102436);
      return str;
    }
    
    public boolean isDecodeByMMDecoder()
    {
      GMTrace.i(13748592967680L, 102435);
      boolean bool = this.mIsDecodeByMMDecoder;
      GMTrace.o(13748592967680L, 102435);
      return bool;
    }
    
    public void setDecodeResult(int paramInt)
    {
      GMTrace.i(13748458749952L, 102434);
      this.mDecodeResultCode = paramInt;
      GMTrace.o(13748458749952L, 102434);
    }
    
    public String toLogString()
    {
      GMTrace.i(13748995620864L, 102438);
      String str = String.format("%d,%b,%s,%s", new Object[] { Integer.valueOf(this.mDecodeResultCode), Boolean.valueOf(this.mIsDecodeByMMDecoder), this.mDecoderTag, "-" });
      GMTrace.o(13748995620864L, 102438);
      return str;
    }
    
    public String toString()
    {
      GMTrace.i(13749129838592L, 102439);
      String str = String.format("{%d,%b,%s}", new Object[] { Integer.valueOf(this.mDecodeResultCode), Boolean.valueOf(this.mIsDecodeByMMDecoder), this.mDecoderTag });
      GMTrace.o(13749129838592L, 102439);
      return str;
    }
  }
  
  private static class DynamicConfigStorage
  {
    public static String PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY;
    private static final String PREF_NAME = "pref_MMBitmapFactory_dyncfg";
    private static SharedPreferences mPref;
    
    static
    {
      GMTrace.i(13744566435840L, 102405);
      mPref = ak.aZ(aa.getContext(), "pref_MMBitmapFactory_dyncfg");
      PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY = "pref_key_is_enable_MMBitmapFactory";
      GMTrace.o(13744566435840L, 102405);
    }
    
    private DynamicConfigStorage()
    {
      GMTrace.i(13744029564928L, 102401);
      GMTrace.o(13744029564928L, 102401);
    }
    
    public static boolean getValue(String paramString, boolean paramBoolean)
    {
      GMTrace.i(13744298000384L, 102403);
      reload();
      if (mPref == null)
      {
        v.w("MicroMsg.MMBitmapFactory", "SharedPreferences in DynamicConfigStorage initialize failed.");
        GMTrace.o(13744298000384L, 102403);
        return paramBoolean;
      }
      paramBoolean = mPref.getBoolean(paramString, paramBoolean);
      v.d("MicroMsg.MMBitmapFactory", "DynamicConfigStorage, getValue:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      GMTrace.o(13744298000384L, 102403);
      return paramBoolean;
    }
    
    private static void reload()
    {
      GMTrace.i(13744163782656L, 102402);
      mPref = ak.aZ(aa.getContext(), "pref_MMBitmapFactory_dyncfg");
      GMTrace.o(13744163782656L, 102402);
    }
    
    public static void setValue(String paramString, boolean paramBoolean)
    {
      GMTrace.i(13744432218112L, 102404);
      if (mPref == null)
      {
        v.w("MicroMsg.MMBitmapFactory", "SharedPreferences in DynamicConfigStorage initialize failed.");
        GMTrace.o(13744432218112L, 102404);
        return;
      }
      SharedPreferences.Editor localEditor = mPref.edit();
      localEditor.putBoolean(paramString, paramBoolean);
      localEditor.commit();
      GMTrace.o(13744432218112L, 102404);
    }
  }
  
  public static class HEVCKVStatHelper
  {
    private static final String KVSTAT_STRING_SEPERATOR = ",";
    public static final int SCENE_SNS = 0;
    private static final long STAT_INTERVAL = 60000L;
    private static long mLastStatTick;
    
    static
    {
      GMTrace.i(13773557465088L, 102621);
      mLastStatTick = 0L;
      GMTrace.o(13773557465088L, 102621);
    }
    
    public HEVCKVStatHelper()
    {
      GMTrace.i(13773154811904L, 102618);
      GMTrace.o(13773154811904L, 102618);
    }
    
    public static String getKVStatString(Object paramObject, int paramInt, long paramLong, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
    {
      GMTrace.i(13773423247360L, 102620);
      StringBuilder localStringBuilder = new StringBuilder(128);
      long l2 = -1L;
      long l1;
      if ((paramObject instanceof File))
      {
        paramObject = (File)paramObject;
        l1 = l2;
        if (((File)paramObject).exists())
        {
          l1 = l2;
          if (((File)paramObject).isFile()) {
            l1 = ((File)paramObject).length();
          }
        }
      }
      for (;;)
      {
        localStringBuilder.append(paramInt).append(",").append(paramDecodeResultLogger.mDecodeResultCode).append(",").append(l1).append(",").append(paramLong).append(",").append(bf.mz(paramOptions.outMimeType));
        paramObject = localStringBuilder.toString();
        GMTrace.o(13773423247360L, 102620);
        return (String)paramObject;
        if ((paramObject instanceof String))
        {
          paramObject = (String)paramObject;
          l1 = l2;
          if (FileOp.aO((String)paramObject)) {
            l1 = FileOp.kj((String)paramObject);
          }
        }
        else
        {
          l1 = l2;
          if ((paramObject instanceof byte[])) {
            l1 = ((byte[])paramObject).length;
          }
        }
      }
    }
    
    public static boolean isTimeToStat()
    {
      GMTrace.i(13773289029632L, 102619);
      long l = bf.NB();
      if (l - mLastStatTick > 60000L)
      {
        mLastStatTick = l;
        GMTrace.o(13773289029632L, 102619);
        return true;
      }
      GMTrace.o(13773289029632L, 102619);
      return false;
    }
  }
  
  public static class KVStatHelper
  {
    private static final String KVSTAT_STRING_SEPERATOR = ",";
    public static final int MMBMPFACTORY_SCENE_ADDTOFAV = 5;
    public static final int MMBMPFACTORY_SCENE_APPMSG_DECODE = 9;
    public static final int MMBMPFACTORY_SCENE_APPMSG_TRANS = 6;
    public static final int MMBMPFACTORY_SCENE_GALLERY_BROWSE = 1;
    public static final int MMBMPFACTORY_SCENE_GET_MSGIMG = 2;
    public static final int MMBMPFACTORY_SCENE_IMGMSG_TRANS = 7;
    public static final int MMBMPFACTORY_SCENE_NONE = 0;
    public static final int MMBMPFACTORY_SCENE_OTHERS = 8;
    public static final int MMBMPFACTORY_SCENE_SHAREIMG = 3;
    public static final int MMBMPFACTORY_SCENE_SHARE_TO_TIMELINE = 4;
    public static final int MMBMPFACTORY_SCENE_SNS_IMGRECV = 10;
    
    public KVStatHelper()
    {
      GMTrace.i(13742955823104L, 102393);
      GMTrace.o(13742955823104L, 102393);
    }
    
    public static String getKVStatString(Object paramObject, int paramInt, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
    {
      GMTrace.i(13743090040832L, 102394);
      StringBuilder localStringBuilder = new StringBuilder(128);
      Object localObject2 = "";
      long l2 = -1L;
      Object localObject1;
      if ((paramObject instanceof File))
      {
        localObject1 = (File)paramObject;
        if ((!((File)localObject1).exists()) || (!((File)localObject1).isFile())) {
          break label332;
        }
        paramObject = bf.mz(g.f((File)localObject1));
      }
      for (long l1 = ((File)localObject1).length();; l1 = -1L)
      {
        localObject1 = paramObject;
        for (;;)
        {
          localStringBuilder.append(paramInt).append(",").append(paramDecodeResultLogger.mDecodeResultCode).append(",").append(l1).append(",").append((String)localObject1);
          paramObject = localStringBuilder.toString();
          GMTrace.o(13743090040832L, 102394);
          return (String)paramObject;
          if ((paramObject instanceof String))
          {
            String str2 = (String)paramObject;
            localObject1 = localObject2;
            l1 = l2;
            if (FileOp.aO(str2))
            {
              localObject1 = null;
              try
              {
                paramObject = FileOp.openRead((String)paramObject);
                localObject1 = paramObject;
              }
              catch (FileNotFoundException paramObject)
              {
                String str1;
                paramObject = paramObject;
                paramObject = null;
                localObject1 = localObject2;
                l1 = l2;
                if (paramObject == null) {
                  continue;
                }
                try
                {
                  ((InputStream)paramObject).close();
                  localObject1 = localObject2;
                  l1 = l2;
                }
                catch (Exception paramObject)
                {
                  localObject1 = localObject2;
                  l1 = l2;
                }
                continue;
              }
              finally
              {
                if (localObject1 == null) {}
              }
            }
          }
          else
          {
            try
            {
              ((InputStream)localObject1).close();
              throw ((Throwable)paramObject);
              localObject1 = localObject2;
              l1 = l2;
              if ((paramObject instanceof byte[]))
              {
                paramObject = (byte[])paramObject;
                localObject1 = g.n((byte[])paramObject);
                l1 = paramObject.length;
              }
            }
            catch (Exception paramDecodeResultLogger)
            {
              for (;;) {}
            }
          }
        }
        label332:
        paramObject = "";
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/MMBitmapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */