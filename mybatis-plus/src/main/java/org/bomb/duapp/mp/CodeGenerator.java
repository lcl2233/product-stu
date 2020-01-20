package org.bomb.duapp.mp;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {

    private static String projectPath ;

    private static String author ;

    private static String jdbcUrl ;

    private static String jdbcDriver ;

    private static String userName ;

    private static String password ;

    private static String packagePath ;

    static {
        projectPath = System.getProperty("user.dir") + "/commodity-infrastructure/";
        author = "bomb";

        jdbcUrl = "jdbc:mysql://rm-uf62vvbo25h3377m7.mysql.rds.aliyuncs.com:3306/du_product?useUnicode=true&useSSL=false&characterEncoding=utf8";
        jdbcDriver = "com.mysql.jdbc.Driver";
        userName = "du_java";
        password = "W0gefGMnHK2OOiYq";

        packagePath = "com.shizhuang.duapp.commodity.infrastructure.integration.db";
    }

    public static void main(String[]args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "src/main/java/");
        gc.setAuthor(author);
        gc.setFileOverride(true); //覆盖原有文件
        gc.setOpen(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setEntityName("%sPO");
        gc.setServiceName("%sDao");
        gc.setServiceImplName("%sDaoImpl");
        gc.setMapperName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(jdbcUrl);
        dsc.setDriverName(jdbcDriver);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setEntity("model");
        pc.setMapper("mapper");
        pc.setService("dao");
        pc.setServiceImpl("dao.impl");
        pc.setParent(packagePath);
        mpg.setPackageInfo(pc);

        //策略
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setEntityBuilderModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setLogicDeleteFieldName("is_del");
//        strategy.setInclude("commodity_size_template_detail"); 表名
        mpg.setStrategy(strategy);

        mpg.execute();
    }
}
