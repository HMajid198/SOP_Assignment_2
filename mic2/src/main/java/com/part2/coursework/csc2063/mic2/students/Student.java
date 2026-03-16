package com.part2.coursework.csc2063.mic2.students;

import java.util.HashMap;

public class Student {

    private String id;

    /**
     * Convention:
     * - Enrolled but no grade yet => -1
     */
    private HashMap<ModuleCode, Integer> modules = new HashMap<>();

    public Student() {}

    public Student(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setModules(HashMap<ModuleCode, Integer> modules) {
        this.modules = (modules == null) ? new HashMap<>() : modules;
    }

    public HashMap<ModuleCode, Integer> getModules() {
        return modules;
    }

    public void enrolModuleCode(ModuleCode moduleCode) {
        if (moduleCode == null) return;
        modules.putIfAbsent(moduleCode, -1);
    }

    public void unenrolModuleCode(ModuleCode moduleCode) {
        if (moduleCode == null) return;
        modules.remove(moduleCode);
    }

    public void registerGrade(ModuleCode moduleCode, int grade) {
        if (moduleCode == null) return;

        // Only allow grade registration if enrolled
        if (modules.containsKey(moduleCode)) {
            modules.put(moduleCode, grade);
        }
    }

    public void unregisterGrade(ModuleCode moduleCode) {
        if (moduleCode == null) return;

        // If enrolled, reset to "no grade yet"
        if (modules.containsKey(moduleCode)) {
            modules.put(moduleCode, -1);
        }
    }
}
