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
        projectPath = System.getProperty("user.dir") + "/mybatis-plus/";
        author = "bomb";

        jdbcUrl = "jdbc:mysql://127.0.0.1:3306/db0?useUnicode=true&useSSL=false&characterEncoding=utf8";
        jdbcDriver = "com.mysql.jdbc.Driver";
        userName = "root";
        password = "123456";

        packagePath = "org.bomb.duapp.mp";
    }

    public static void main(String[]args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "src/main/java/");
        gc.setAuthor(author);
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setDateType(DateType.ONLY_DATE);
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
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setParent(packagePath);
        mpg.setPackageInfo(pc);

        //策略
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setInclude("opus_out_amount");
        mpg.setStrategy(strategy);

        mpg.execute();
    }
}
