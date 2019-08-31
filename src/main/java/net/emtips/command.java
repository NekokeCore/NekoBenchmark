package net.emtips;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import static net.emtips.api.getCPU.*;


public class command implements CommandExecutor {
    private final bencgmark plugin;
    public static BigDecimal quartermpi = new BigDecimal("0");
    public static BigDecimal general = new BigDecimal("0");
    public static BigDecimal mone = new BigDecimal("-1");
    public static BigDecimal one = new BigDecimal("1");
    public static BigDecimal two = new BigDecimal("2");
    public command(bencgmark plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if (cmd.getName().equalsIgnoreCase("benchmark")) {
            if (!(sender instanceof Player)) {
            if(args.length == 0){
                sender.sendMessage("§c[Benchmark]跑分插件！作者: NekokeCores. 需要帮助吗？请输入benchmark help !");
                return true;
            }
            if(args[0].equalsIgnoreCase("help")){
                sender.sendMessage("§c----------------------[Benchmark]----------------------");
                sender.sendMessage("§c获取主机信息：请输入 benchmark info");
                sender.sendMessage("§cCPU跑分：请输入 benchmark cpu");
                sender.sendMessage("§cRAM跑分：请输入 benchmark ram");
                sender.sendMessage("§c网速跑分：请输入 benchmark net");
                sender.sendMessage("§c综合跑分：请输入 benchmark zh   *实验性功能");
                sender.sendMessage("§c----------------------[Benchmark]----------------------");
            }
            if(args[0].equalsIgnoreCase("cpu")){
                sender.sendMessage("§c[Benchmark]开始cpu计算跑分，祝你好运！");
                long startTime = System.nanoTime();
                for (int i = 0; i <=20; i++) {
                    general = mone.pow(i % 2).divide(two.multiply(BigDecimal.valueOf(i)).add(one), 2000000, BigDecimal.ROUND_UP);
                    quartermpi = quartermpi.add(general);
                    //sender.sendMessage("§c[Benchmark]当前次数：" + i);
                }
                long endTime = System.nanoTime();
                sender.sendMessage("§c[Benchmark]程序结束！用时：" + (endTime-startTime)+"ns(纳秒)，得分(分值越低越好!)："+((endTime-startTime)*0.0000001));
            }
                if(args[0].equalsIgnoreCase("info")){
                    sender.sendMessage("§c----------------------[Benchmark]----------------------");
                    Runtime r = Runtime.getRuntime();
                    Properties props = System.getProperties();
                    Map<String, String> map = System.getenv();
                    String userName = map.get("USERNAME");
                    String computerName = map.get("COMPUTERNAME");
                    String userDomain = map.get("USERDOMAIN");
                    InetAddress addr;
                    sender.sendMessage("§c-----------------------[网络信息]-----------------------");
                    try {
                        addr = InetAddress.getLocalHost();
                        String ip = addr.getHostAddress();
                        sender.sendMessage("§c本地IP:" + ip);
                        sender.sendMessage("§c本地主机名:" + addr.getHostName());
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    sender.sendMessage("§c-----------------------[系统信息]-----------------------");
                    sender.sendMessage("§c操作系统的名称:" + props.getProperty("os.name"));
                    sender.sendMessage("§c操作系统的构架:" + props.getProperty("os.arch"));
                    sender.sendMessage("§c操作系统的版本:" + props.getProperty("os.version"));
                    sender.sendMessage("§c用户名:" + userName);
                    sender.sendMessage("§c计算机名:" + computerName);
                    sender.sendMessage("§c计算机域名:" + userDomain);
                    sender.sendMessage("§c用户的主目录:" + props.getProperty("user.home"));
                    sender.sendMessage("§c用户的当前工作目录:" + props.getProperty("user.dir"));
                    sender.sendMessage("§c-----------------------[硬件信息]-----------------------");
                    sender.sendMessage("§cCPU:"+ getCpu());
                    sender.sendMessage("§c内存:"+ getmem());
                    sender.sendMessage("§c主板:"+ getbasebord());
                    sender.sendMessage("§c网卡:"+ getnet());
                    sender.sendMessage("§c-----------------------[Java信息]-----------------------");
                    sender.sendMessage("§cJVM可以使用的总内存:" + r.totalMemory());
                    sender.sendMessage("§cJVM可以使用的剩余内存:" + r.freeMemory());
                    sender.sendMessage("§cJVM可以使用的处理器个数:" + r.availableProcessors());
                    sender.sendMessage("§cJava的运行环境版本:" + props.getProperty("java.version"));
                    sender.sendMessage("§cJava的运行环境供应商:" + props.getProperty("java.vendor"));
                    sender.sendMessage("§cJava供应商的URL:"  + props.getProperty("java.vendor.url"));
                    sender.sendMessage("§cJava的安装路径:" + props.getProperty("java.home"));
                    sender.sendMessage("§cJava的虚拟机规范版本:" + props.getProperty("java.vm.specification.version"));
                    sender.sendMessage("§cJava的虚拟机规范供应商:" + props.getProperty("java.vm.specification.vendor"));
                    sender.sendMessage("§cJava的虚拟机规范名称:" + props.getProperty("java.vm.specification.name"));
                    sender.sendMessage("§cJava的虚拟机实现版本:" + props.getProperty("java.vm.version"));
                    sender.sendMessage("§cJava的虚拟机实现供应商:" + props.getProperty("java.vm.vendor"));
                    sender.sendMessage("§cJava的虚拟机实现名称:" + props.getProperty("java.vm.name"));
                    sender.sendMessage("§cJava运行时环境规范版本" + props.getProperty("java.specification.version"));
                    sender.sendMessage("§cJava运行时环境规范供应商:" + props.getProperty("java.specification.vender"));
                    sender.sendMessage("§cJava运行时环境规范名称:" + props.getProperty("java.specification.name"));
                    sender.sendMessage("§cJava的类格式版本号:" + props.getProperty("java.class.version") );
                    sender.sendMessage("§cJava的类路径:" + props.getProperty("java.class.path"));
                    sender.sendMessage("§c加载库时搜索的路径列表" + props.getProperty("java.library.path"));
                    sender.sendMessage("§c默认的临时文件路径:" + props.getProperty("java.io.tmpdir"));
                    sender.sendMessage("§c一个或多个扩展目录的路径:" + props.getProperty("java.ext.dirs"));
                    sender.sendMessage("§c----------------------[Benchmark]----------------------");
                }
                if(args[0].equalsIgnoreCase("ram")){
                    sender.sendMessage("§c[Benchmark]开始内存测试！祝你好运！");
                    long startTime = System.nanoTime();
                    int[] ary = new int[10000000];
                    for (int i = 0; i < 10000000; i++) {
                        ary[i] = (int)(Math.random()*1000000000);
                    }
                    Arrays.sort(ary);
                    long endTime = System.nanoTime();
                    sender.sendMessage("§c[Benchmark]程序结束！用时：" + (endTime-startTime)+"ns(纳秒),得分(分值越低越好!)："+((endTime-startTime)*0.0000001));

                }
                if(args[0].equalsIgnoreCase("net")){

                }
                if(args[0].equalsIgnoreCase("zh")){
                    sender.sendMessage("§c[Benchmark]暂未开放！");
                }
            } else {
                sender.sendMessage("§c[Benchmark]必须控制台输入命令");
                return true;
            }
        }
        return true;
    }
}
