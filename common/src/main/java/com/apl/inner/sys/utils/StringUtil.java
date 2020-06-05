//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.apl.inner.sys.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public StringUtil() {
    }

    public static Object getObjectFromBytes(byte[] objBytes) throws Exception {
        if (objBytes != null && objBytes.length != 0) {
            ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
            ObjectInputStream oi = new ObjectInputStream(bi);
            return oi.readObject();
        } else {
            return null;
        }
    }

    public static String generateUuid() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        return uuid;
    }

    public static List<Long> stringToLongList(String longList) {
        List<Long> list = new ArrayList();
        String[] longs = longList.split(",");
        String[] var3 = longs;
        int var4 = longs.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String aLong = var3[var5];

            list.add(Long.parseLong(aLong));
        }

        return list;
    }

    public static String checkIds(String ids) {
        if (ids != null && ids.length() != 0) {
            StringBuilder sb = new StringBuilder();
            String[] arr = ids.split(",");
            String[] var4 = arr;
            int var5 = arr.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String aLong = var4[var6];

                Long n = Long.parseLong(aLong);
                if (sb.length() > 0) {
                    sb.append(",");
                }

                sb.append(n.toString());
            }

            return sb.toString();
        } else {
            return null;
        }
    }

    public static String getIdsForList(List<Long> list) {
        StringBuilder sb = new StringBuilder();
        boolean isNotFirst = false;

        Long aLong;
        for(Iterator var3 = list.iterator(); var3.hasNext(); sb.append(aLong.toString())) {
            aLong = (Long)var3.next();
            if (isNotFirst) {
                sb.append(",");
            }
        }

        return sb.toString();
    }

    public static String getValueWithoutNull(String str) {
        return str == null ? "" : str;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().equals("");
    }

    public static boolean notEmpty(String str) {
        if (null == str) {
            return false;
        } else if ("".equals(str.trim())) {
            return false;
        } else if (" ".equals(str.trim())) {
            return false;
        } else {
            return !"null".equals(str.trim());
        }
    }

    public static boolean isPhoneNO(String phone) {
        if (isEmpty(phone)) {
            return false;
        } else {
            Pattern p = Pattern.compile("^1[3|4|5|7|8|9][0-9]{9}$");
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }

    public static boolean checkYZBM(String post) {
        return post.matches("[1-9]\\d{5}(?!\\d)");
    }

    public static boolean isIdCard(String idCard) {
        if (isEmpty(idCard)) {
            return false;
        } else {
            Pattern p = Pattern.compile("^((\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z]))$");
            Matcher m = p.matcher(idCard);
            return m.matches();
        }
    }

    public static boolean isEmail(String email) {
        if (isEmpty(email)) {
            return false;
        } else {
            Pattern p = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
            Matcher m = p.matcher(email);
            return m.matches();
        }
    }

    public static boolean isQQ(String qq) {
        if (isEmpty(qq)) {
            return false;
        } else {
            Pattern p = Pattern.compile("^[1-9][0-9]{4,}$");
            Matcher m = p.matcher(qq);
            return m.matches();
        }
    }

    public static boolean isDecimalNum(String decimalNum) {
        if (null == decimalNum) {
            return false;
        } else if (decimalNum.startsWith("-")) {
            return false;
        } else if (decimalNum.length() - decimalNum.lastIndexOf(".") > 3) {
            return false;
        } else {
            try {
                Double.parseDouble(decimalNum);
                return true;
            } catch (NumberFormatException var2) {
                return false;
            }
        }
    }

    public static boolean isNum(String str) {
        if (null != str && str.length() != 0) {
            try {
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException var2) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isTimeStr(String timeStr) {
        return null == timeStr ? false : timeStr.matches("[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$");
    }

    public static boolean isClockStr(String clockStr) {
        return null == clockStr ? false : clockStr.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}$");
    }

    public static boolean isDayStr(String dayStr) {
        return null == dayStr ? false : dayStr.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}$");
    }

    public static String readFile2Text(String filePath, String encoding) {
        if (filePath == null) {
            return null;
        } else {
            StringBuffer result = new StringBuffer();

            try {
                File file = new File(filePath);
                if (file.isFile() && file.exists()) {
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String text = null;

                    while((text = bufferedReader.readLine()) != null) {
                        result.append(text);
                        result.append("\r\n");
                    }

                    read.close();
                }
            } catch (Exception var7) {
                var7.printStackTrace();
            }

            return result.toString();
        }
    }

    public static boolean hasEmpty(String... strs) {
        if (strs != null && strs.length != 0) {
            boolean result = false;
            String[] var2 = strs;
            int var3 = strs.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String str = var2[var4];
                if (str == null || str.trim().equals("")) {
                    result = true;
                    break;
                }
            }

            return result;
        } else {
            return true;
        }
    }

    public static String getFileSuffix(String fileName) {
        return isEmpty(fileName) ? "" : fileName.substring(fileName.indexOf("."));
    }

    public static List<String> toList(String str) {
        List<String> list = new ArrayList();
        if (isEmpty(str)) {
            return list;
        } else {
            str = str.substring(1, str.length() - 1);
            String[] subStr = str.split(",");

            for(int i = 0; i < subStr.length; ++i) {
                list.add(subStr[i]);
            }

            System.out.println(list);
            System.out.println(list.size());
            return list;
        }
    }

    public static List<String> toStringList(String str) {
        List<String> list = new ArrayList();
        String[] subStr = str.split("\\]");

        for(int i = 0; i < subStr.length; ++i) {
            list.add(subStr[i] + "]");
        }

        return list;
    }

    public static String genRandomSix() {
        int result = (int)(Math.random() * 899999.0D + 100000.0D);
        return String.valueOf(result);
    }

    public static String genRandomFour() {
        int result = (int)(Math.random() * 8999.0D + 1000.0D);
        return String.valueOf(result);
    }
}
