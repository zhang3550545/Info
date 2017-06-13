package com.yundoku.info.utils;

import android.os.Environment;
import com.google.gson.Gson;
import com.yundoku.info.bean.AppInfo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class ToolUtil {

    public static void toFile(String json) {
        File directory = Environment.getExternalStorageDirectory();
        File file = new File(directory, "infos.json");
        FileOutputStream write = null;
        try {
            write = new FileOutputStream(file);
            byte[] bytes = json.getBytes();
            write.write(bytes);
            write.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (write != null) {
                    write.close();
                }
            } catch (Exception e) {
            }
        }
    }

    public static <E> String listToJson(List<E> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    public static void toFile(List<AppInfo> infoList) {
        toFile(listToJson(infoList));
    }

}
