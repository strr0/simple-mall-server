package com.strr.mall.generator.util;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 模板工具
 */
public class VelocityUtil {
    private static VelocityEngine engine;
    static {
        engine = new VelocityEngine();
        engine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, "src/main/resources/vm");
        engine.setProperty(VelocityEngine.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
        engine.init();
    }

    /**
     * 生成模板
     * @param context
     * @param templateName
     * @param filePath
     */
    public static void merge(VelocityContext context, String templateName, String filePath) {
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Template template = engine.getTemplate(templateName, "UTF-8");
        try (FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw)) {
            template.merge(context, bw);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(templateName + " is finished...");
    }
}
