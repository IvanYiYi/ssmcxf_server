package HSM;

public class SafeNet {
    public static final int DES_CBC = 1;
    public static final int DES_CBC_LP = 2;
    public static final int DES_CBC_P = 3;
    public static final int DES_ECB = 4;
    public static final int DES_ECB_LP = 5;
    public static final int DES_ECB_P = 6;
    public static final int RSA = 7;
    public static final int DES = 8;
    public static final int DES2 = 9;
    public static final int DES_MAC = 10;
    public static final int DES_MAC_EMV = 11;
    public static final int MD5 = 12;
    public static final int SHA1 = 13;
    public static final int RSA_EX = 14;
    public static final int AES_CBC = 15;
    public static final int AES_ECB = 16;

    static {
        System.loadLibrary("lib/HSM");
    }

    public native int Init(String Slot, String Pin);

    public native int Connect();

    public native void Disconnect();

    public native String GetErrMsg();

    public native Status Encrypt(String inbuf, int inlen, int mech,
                                 String keyprofile, String iv);

    public native Status Decrypt(String inbuf, int inlen, int mech,
                                 String keyprofile, String iv);

    public native Status GetRandom(int rdmLen);

    public native Status GetKey(String keyprofile);
}

