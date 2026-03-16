package com.part2.coursework.csc2063.mic3.lecturers;

import java.util.ArrayList;

public class Lecturer {

    private String id;
    private ArrayList<ModuleCode> moduleCodes = new ArrayList<>();

    public Lecturer() {}

    public Lecturer(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setModuleCodes(ArrayList<ModuleCode> moduleCodes) {
        this.moduleCodes = (moduleCodes == null) ? new ArrayList<>() : moduleCodes;
    }

    public ArrayList<ModuleCode> getModuleCodes() {
        return moduleCodes;
    }

    public void assignModuleCode(ModuleCode moduleCode) {
        if (moduleCode == null) return;
        if (!moduleCodes.contains(moduleCode)) {
            moduleCodes.add(moduleCode);
        }
    }

    public void removeModuleCode(ModuleCode moduleCode) {
        if (moduleCode == null) return;
        moduleCodes.remove(moduleCode);
    }
}
