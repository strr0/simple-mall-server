package com.strr.mall.generator.service.impl;

import com.strr.mall.common.Constant;
import com.strr.mall.generator.dao.ColumnInfoDao;
import com.strr.mall.generator.entity.ColumnInfo;
import com.strr.mall.generator.entity.GeneratorInfo;
import com.strr.mall.generator.service.GeneratorInfoService;
import com.strr.mall.generator.util.VelocityUtil;
import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneratorInfoServiceImpl implements GeneratorInfoService {
    @Autowired
    private ColumnInfoDao columnInfoDao;

    /**
     * 生成代码
     * @param info
     */
    @Override
    public void generatorCode(GeneratorInfo info) {
        List<ColumnInfo> columnInfoList = columnInfoDao.getColumnInfoList(info.getSchema(), info.getTable());
        VelocityContext context = new VelocityContext();
        context.put("packageName", info.getPackageName());
        context.put("tableName", info.getTable());
        context.put("entityName", info.getEntityName());
        context.put("columnInfoList", columnInfoList);
        context.put("tableComment", info.getComment());
        context.put("author", info.getAuthor());
        String outputPath = null;
        switch (info.getOutputType()) {
            case Constant.JAVA_CODE:
                outputPath = Constant.JAVA_CODE_PATH + info.getOutputPath();
                VelocityUtil.merge(context, "entity.vm", outputPath + "/entity/" + info.getEntityName() + ".java");
                VelocityUtil.merge(context, "repository.vm", outputPath + "/repository/" + info.getEntityName() + "Repository.java");
                VelocityUtil.merge(context, "service.vm", outputPath + "/service/" + info.getEntityName() + "Service.java");
                VelocityUtil.merge(context, "serviceimpl.vm", outputPath + "/service/impl/" + info.getEntityName() + "ServiceImpl.java");
                VelocityUtil.merge(context, "controller.vm", outputPath + "/controller/" + info.getEntityName() + "Controller.java");
                //VelocityUtil.merge(context, "dao.vm", outputPath + "/dao/" + info.getEntityName() + "Dao.java");
                //VelocityUtil.merge(context, "daoimpl.vm", outputPath + "/dao/impl/" + info.getEntityName() + "DaoImpl.java");
                break;
            case Constant.VUE_CODE:
                outputPath = Constant.VUE_CODE_PATH + info.getOutputPath();
                VelocityUtil.merge(context, "vue.vm", outputPath + "/" + info.getEntityName() + ".vue");
                break;
            default:
                break;
        }
    }

}
