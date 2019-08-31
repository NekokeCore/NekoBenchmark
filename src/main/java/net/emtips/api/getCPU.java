package net.emtips.api;


import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.Scanner;

public class getCPU {
    private static String getCpuWindows() {
        try {
            Process process = Runtime.getRuntime().exec("wmic cpu get name");
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String key = sc.next();
            String cpuName = "";
            while (sc.hasNext()) {
                cpuName += sc.next() + " ";
            }
            return StringUtils.isEmpty(cpuName) ? null : cpuName.substring(0, cpuName.length() - 1);
        } catch (IOException ex) {

        }
        return null;
    }
    private static String getbasebordWindows() {
        try {
            Process process = Runtime.getRuntime().exec("wmic BASEBOARD get Product");
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String key = sc.next();
            String basebordName = "";
            while (sc.hasNext()) {
                basebordName += sc.next() + " ";
            }
            return StringUtils.isEmpty(basebordName) ? null : basebordName.substring(0, basebordName.length() - 1);
        } catch (IOException ex) {

        }
        return null;
    }
    private static String getnetcardWindows() {
        try {
            Process process = Runtime.getRuntime().exec("wmic NICCONFIG where " + "index='1'" + " get description");
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String key = sc.next();
            String netcardName = "";
            while (sc.hasNext()) {
                netcardName += sc.next() + " ";
            }
            return StringUtils.isEmpty(netcardName) ? null : netcardName.substring(0, netcardName.length() - 1);
        } catch (IOException ex) {

        }
        return null;
    }
    private static String getmemWindows() {
        try {
            Process process = Runtime.getRuntime().exec("wmic memorychip get  PartNumber");
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String key = sc.next();
            String memName = "";
            while (sc.hasNext()) {
                memName += sc.next() + " ";
            }
            return StringUtils.isEmpty(memName) ? null : memName.substring(0, memName.length() - 1);
        } catch (IOException ex) {

        }
        return null;
    }
    public static String getCpu() {
        return  getCpuWindows();
    }
    public static String getbasebord() {
        return  getbasebordWindows();
    }
    public static String getnet() {
        return  getnetcardWindows();
    }
    public static String getmem() {
        return  getmemWindows();
    }
}
