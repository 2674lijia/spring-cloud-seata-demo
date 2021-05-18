package com.example.provide.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang.StringUtils;

import java.util.Scanner;

/**
 * @Author: lijia
 * @Description:
 * @CreateDate: 2021/5/14 11:05
 */
public class CodeGenerator {


    //项目的真实路径
    private static final String PROJECT_RELATIVE_PATH = "F:\\work\\Project_ing\\demo\\provide";

    // 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
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

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // 全局配置

        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(PROJECT_RELATIVE_PATH + "/src/main/java");    //生成文件的输出目录
        gc.setAuthor("lijia");                    //作者
        gc.setFileOverride(true);                //是否覆蓋已有文件 默认值：false
        gc.setOpen(false);                        //是否打开输出目录 默认值:true
        //gc.setSwagger2(true);                    //开启 swagger2 模式 默认false
        gc.setBaseColumnList(true);                //开启 baseColumnList 默认false
        gc.setBaseResultMap(true);                //开启 BaseResultMap 默认false
        gc.setEntityName("%s");            //实体命名方式  默认值：null 例如：%sEntity 生成 UserEntity
        gc.setMapperName("%sMapper");            //mapper 命名方式 默认值：null 例如：%sDao 生成 UserDao
        gc.setXmlName("%sMapper");                //Mapper xml 命名方式   默认值：null 例如：%sDao 生成 UserDao.xml
        gc.setServiceName("%sService");            //service 命名方式   默认值：null 例如：%sBusiness 生成 UserBusiness
        gc.setServiceImplName("%sServiceImpl");    //service impl 命名方式  默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
        gc.setControllerName("%sController");    //controller 命名方式    默认值：null 例如：%sAction 生成 UserAction
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);        //数据库类型	该类内置了常用的数据库类型【必须】
        //mysql 8.0.3以上 加上serverTimezone=UTC
        dsc.setUrl("jdbc:mysql://192.168.0.21:3306/seata?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        //设置各个包路径
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent("com.example.provide"); //设置父包
        //pc.setEntity() //如果不给各个模块设置具体的包路径，则默认是
        //pc.setXml("resources.mapper");//不设置的话 默认是和java类在一起
        mpg.setPackageInfo(pc);

        // 自定义配置
/*	        InjectionConfig cfg = new InjectionConfig() {
	            @Override
	            public void initMap() {		//注入自定义 Map 对象
	                // to do nothing
	            }
	        };
	        List<FileOutConfig> focList = new ArrayList<>();
	        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
	            @Override
	            public String outputFile(TableInfo tableInfo) {
	                // 自定义输入文件名称
	                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
	                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
	            }
	        });
	        cfg.setFileOutConfigList(focList);
	        mpg.setCfg(cfg);
	        mpg.setTemplate(new TemplateConfig().setXml(null));*/

        // 策略配置	数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);    //表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略, 未指定按照 naming 执行


/*        strategy.setCapitalMode(true);            // 全局大写命名 ORACLE 注意
        strategy.setTablePrefix("prefix");        //表前缀
        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");    //自定义继承的Entity类全称，带包名
        strategy.setSuperEntityColumns(new String[]{"test_id", "age"});    //自定义实体，公共字段
        strategy.setEntityLombokModel(true);    //【实体】是否为lombok模型（默认 false
        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");    //自定义继承的Controller类全称，带包名*/


        //如果不设置  默认是 包含全部表
        //strategy.setInclude(scanner("表名"));		//需要包含的表名，允许正则表达式（与exclude二选一配置）
        strategy.setInclude(new String[] { "product" }); // 需要生成的表可以多张表
        //strategy.setExclude(new String[]{"test"}); // 排除生成的表

        strategy.setRestControllerStyle(true); //controller 层使用Restful风格
        strategy.setControllerMappingHyphenStyle(true);    //驼峰转连字符
//        strategy.setTablePrefix("tb_");    //去掉前缀
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
