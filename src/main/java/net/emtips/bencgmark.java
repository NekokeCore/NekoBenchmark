package net.emtips;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.*;

public class bencgmark extends JavaPlugin {
    static Connection sql;
    static PreparedStatement stat;
    static Statement stat1;
    @Override
    public void onEnable() {
        //生成SQlite
        getLogger().info("正在检查插件是否释放配置文件夹！");
        if(getDataFolder().exists()) {
            getLogger().info("检查成功，插件将会继续运行");
        }else{
            getLogger().info("检查失败，插件将会自动创建文件夹！");
            getDataFolder().mkdir();
        }
        //与SQlite尝试连
        getLogger().info("下面尝试与SQLite进行连接！");
        File dataFolder = new File(getDataFolder(), "benchmarkdata.db");
        try {
            Class.forName("org.sqlite.JDBC");
            sql = DriverManager.getConnection("jdbc:sqlite:"+ dataFolder);
            stat = sql.prepareStatement("CREATE TABLE if not exists mark(benchmark int);");
            stat.executeUpdate();
            stat = sql.prepareStatement("insert into mark(benchmark) values(0);");
            stat.executeUpdate();
            stat.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        getLogger().info("SQLite连接成功！");
        //注册指令监听器
        this.getCommand("benchmark").setExecutor(new command(this));
        //返回成功信息
        getLogger().info("插件已启动！");
    }
    @Override
    public void onDisable(){
        getLogger().info("插件已关闭！");
    }
}
