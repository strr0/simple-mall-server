package com.strr.mall.generator;

import com.strr.mall.generator.util.ColumnUtil;
import com.strr.mall.generator.util.VelocityUtil;
import org.apache.velocity.VelocityContext;

/**
 * 代码生成
 * @author strr
 */
public class CodeGenerator {
    public static void main(String[] args) {
        String schema = "simple_mall";
        String table = "sys_test";
        String comment = "测试";
        String author = "strr";

        String packageName = "com.strr.mall.test";
        String entityName = "TestInfo";

        String outputPath = "src/main/java/" + packageName.replace(".", "/");
        VelocityContext context = new VelocityContext();
        context.put("packageName", packageName);
        context.put("tableName", table);
        context.put("entityName", entityName);
        context.put("columnInfoList", ColumnUtil.getColumnInfoList(schema, table));
        context.put("tableComment", comment);
        context.put("author", author);

        VelocityUtil.merge(context, "entity.vm", outputPath + "/entity/" + entityName + ".java");
        VelocityUtil.merge(context, "repository.vm", outputPath + "/repository/" + entityName + "Repository.java");
        VelocityUtil.merge(context, "service.vm", outputPath + "/service/" + entityName + "Service.java");
        VelocityUtil.merge(context, "serviceimpl.vm", outputPath + "/service/impl/" + entityName + "ServiceImpl.java");
        VelocityUtil.merge(context, "controller.vm", outputPath + "/controller/" + entityName + "Controller.java");
        VelocityUtil.merge(context, "dao.vm", outputPath + "/dao/" + entityName + "Dao.java");
        VelocityUtil.merge(context, "daoimpl.vm", outputPath + "/dao/impl/" + entityName + "DaoImpl.java");
        VelocityUtil.merge(context, "vue.vm", "src/main/resources/templates/" + entityName + ".vue");
    }
}
