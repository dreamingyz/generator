package com.baomidou.mybatisplus.generator.samples;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author zhujunming@yunquna.com
 * @since 2022/3/23 15:26
 */
public class YqnGeneratorTest {

    public static void main(String[] args) {
        FastAutoGenerator.create(new DataSourceConfig.Builder("jdbc:mysql://mysql-common.qax-pub.yqn.corp:3306/yqn_composer_v2", "root", "sr@12345"))
            .globalConfig(builder -> builder.author("zhujunming@yunquna.com")
                .enableSwagger()
                .outputDir("E://code")
                .dateType(DateType.ONLY_DATE))
            .packageConfig(builder -> builder.parent("com.yqn.framework.composer.console")
                .entity("dao.domain")
                .mapper("dao.mapper")
                .pathInfo(Collections.singletonMap(OutputFile.xml, "E://code/mapper")))
            //表名
            .strategyConfig(builder -> builder.addInclude("composer_commit_log")
                .entityBuilder()
                .enableLombok()
                .mapperBuilder()
                //控制生成resultMap
                .enableBaseResultMap()
                .enableBaseColumnList())
            .templateEngine(new FreemarkerTemplateEngine())
            .execute();
    }
}
