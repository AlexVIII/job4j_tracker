package ru.job4j.pattern.singleton;

public class ProgramRunner {
    public static void main(String[] args) {
        ProgramLogger.getProgramLogger().addLogInfo("1111");
        ProgramLogger.getProgramLogger().addLogInfo("2222");

        ProgramLogger.getProgramLogger().showLogFile();
    }
}
