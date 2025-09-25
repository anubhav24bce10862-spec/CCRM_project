package edu.ccrm.domain;

public final class Course {
    private final String code;
    private final String title;
    private final int credits;
    private String instructor;
    private Semester semester;
    private String department;

    private Course(Builder b){
        this.code = b.code;
        this.title = b.title;
        this.credits = b.credits;
        this.instructor = b.instructor;
        this.semester = b.semester;
        this.department = b.department;
    }

    public static class Builder {
        private final String code;
        private final String title;
        private int credits;
        private String instructor;
        private Semester semester;
        private String department;

        public Builder(String code, String title){
            this.code = code; this.title = title;
        }
        public Builder credits(int c){ this.credits = c; return this; }
        public Builder instructor(String i){ this.instructor = i; return this; }
        public Builder semester(Semester s){ this.semester = s; return this; }
        public Builder department(String d){ this.department = d; return this; }
        public Course build(){ return new Course(this); }
    }

    @Override
    public String toString(){
        return code + " - " + title + " (" + credits + "cr) - " + instructor;
    }
}
