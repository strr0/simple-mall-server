package com.strr.mall.generator;

import com.strr.mall.generator.entity.TableInfo;
import com.strr.mall.generator.util.TableUtil;
import com.strr.mall.generator.util.VelocityUtil;
import org.apache.velocity.VelocityContext;

import java.util.List;

/**
 * 代码生成
 * @author strr
 */
public class CodeGenerator {
    public static void main(String[] args) {
        String schema = "simple_mall";
        String table = "sys_user";
        String comment = "用户";
        String author = "strr";

        String packageName = "com.strr.mall.system";
        String entityName = "User";

        String outputPath = "src/main/java/" + packageName.replace(".", "/");
        VelocityContext context = new VelocityContext();
        context.put("packageName", packageName);
        context.put("tableName", table);
        context.put("entityName", entityName);
        context.put("tableInfoList", TableUtil.getTableInfoList(schema, table));
        context.put("tableComment", comment);
        context.put("author", author);

        VelocityUtil.merge(context, "entity.vm", outputPath + "/entity/" + entityName + ".java");
        VelocityUtil.merge(context, "repository.vm", outputPath + "/repository/" + entityName + "Repository.java");
        VelocityUtil.merge(context, "service.vm", outputPath + "/service/" + entityName + "Service.java");
        VelocityUtil.merge(context, "serviceimpl.vm", outputPath + "/service/impl/" + entityName + "ServiceImpl.java");
        VelocityUtil.merge(context, "controller.vm", outputPath + "/controller/" + entityName + "Controller.java");
        //VelocityUtil.merge(context, "dao.vm", outputPath + "/dao/" + entityName + "Dao.java");
        //VelocityUtil.merge(context, "daoimpl.vm", outputPath + "/dao/impl/" + entityName + "DaoImpl.java");
    }
}
