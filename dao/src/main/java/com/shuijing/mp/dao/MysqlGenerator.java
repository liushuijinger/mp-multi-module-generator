package com.shuijing.mp.dao;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * mysql 代码生成器
 * </p>
 *
 * @author liushuijing
 * @since 2019-11-04
 */
public class MysqlGenerator {

    // 代码生成模板
    public static final String TEMPLATES_MAPPER_XML_PATH = "/templates/mapper.xml.ftl";
    public static final String TEMPLATES_MAPPER_JAVA_PATH = "/templates/mapper.java.ftl";
    public static final String TEMPLATES_ENTITY_PATH = "/templates/entity.java.ftl";
    public static final String TEMPLATES_SERVICE_PATH = "/templates/service.java.ftl";
    public static final String TEMPLATES_SERVICE_IMPL_PATH = "/templates/serviceImpl.java.ftl";
    public static final String TEMPLATES_CONTROLLER_PATH = "/templates/controller.java.ftl";


    // 包名以及类名
    public static final String PARENT_PACKAGE = "com.shuijing.mp";
    public static final String MAPPER_PACKAGE = "dao.mapper";
    public static final String ENTITY_PACKAGE = "dao.entity";
    public static final String CONTROLLER_PACKAGE = "web.controller";
    public static final String CONTROLLER_POSTFIX = "Controller";
    public static final String SERVICE_IMPL_POSTFIX = "ServiceImpl";
    public static final String SERVICE_POSTFIX = "Service";
    public static final String MAPPER_POSTFIX = "Mapper";
    public static final String XML_POSTFIX = "Mapper";


    // 自定义模块路径，src 前面为模块名，java/resources 后面为包路径
    public static final String CONTROLLER_PATH = "/web/src/main/java/com/shuijing/mp/web/controller/";
    public static final String SERVICE_IMPL_PATH = "/service/src/main/java/com/shuijing/mp/service/impl/";
    public static final String SERVICE_PATH = "/service/src/main/java/com/shuijing/mp/service/";
    public static final String ENTITY_PATH = "/dao/src/main/java/com/shuijing/mp/dao/entity/";
    public static final String MAPPER_PATH = "/dao/src/main/java/com/shuijing/mp/dao/mapper/";
    public static final String XML_PATH = "/dao/src/main/resources/mapper/";

    // 文件输出路径，指定了各模块输出路径后，还会将所有生成的文件输出到这里，无法关闭
    public static final String OUT_PUT_DIR = "/Users/liushuijing/tmp";


    // 数据源配置
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mp?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8";
    public static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "123456";

    // 要生成代码的表名
    public static final String[] TABLE_NAMES = new String[] { "user" };


    // 开发者信息
    public static final String AUTHOR = "liushuijing";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        gc.setServiceName("%sService");
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);
        gc.setActiveRecord(true);
        gc.setBaseColumnList(true);
        gc.setOutputDir(OUT_PUT_DIR);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(DATABASE_URL);
        dsc.setDriverName(DATABASE_DRIVER);
        dsc.setUsername(DATABASE_USERNAME);
        dsc.setPassword(DATABASE_PASSWORD);
        mpg.setDataSource(dsc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();

        // 生成 dao
        fileOutConfigList.add(new FileOutConfig(TEMPLATES_MAPPER_XML_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + XML_PATH + tableInfo.getEntityName() + XML_POSTFIX + StringPool.DOT_XML;
            }
        });

        fileOutConfigList.add(new FileOutConfig(TEMPLATES_MAPPER_JAVA_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + MAPPER_PATH + tableInfo.getEntityName() + MAPPER_POSTFIX
                                + StringPool.DOT_JAVA;
            }
        });

        fileOutConfigList.add(new FileOutConfig(TEMPLATES_ENTITY_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + ENTITY_PATH + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });

        // 生成 service
        fileOutConfigList.add(new FileOutConfig(TEMPLATES_SERVICE_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + SERVICE_PATH + tableInfo.getEntityName() + SERVICE_POSTFIX
                                + StringPool.DOT_JAVA;
            }
        });

        fileOutConfigList.add(new FileOutConfig(TEMPLATES_SERVICE_IMPL_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + SERVICE_IMPL_PATH + tableInfo.getEntityName() + SERVICE_IMPL_POSTFIX
                                + StringPool.DOT_JAVA;
            }
        });

        // 生成 Controller
        fileOutConfigList.add(new FileOutConfig(TEMPLATES_CONTROLLER_PATH) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + CONTROLLER_PATH + tableInfo.getEntityName() + CONTROLLER_POSTFIX
                                + StringPool.DOT_JAVA;
            }
        });

        cfg.setFileOutConfigList(fileOutConfigList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null).setEntity(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(TABLE_NAMES);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy)
        .setPackageInfo(new PackageConfig().setParent(PARENT_PACKAGE).setMapper(MAPPER_PACKAGE).setEntity(
                        ENTITY_PACKAGE).setController(CONTROLLER_PACKAGE));

        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
