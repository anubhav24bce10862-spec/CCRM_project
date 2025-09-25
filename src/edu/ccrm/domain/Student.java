package edu.ccrm.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Student extends Person {
    private String regNo;
    private Status status;
    private final List<String> enrolledCourseCodes = new ArrayList<>();
    private final LocalDateTime createdAt;

    private Student(Builder b){
        super(b.id, b.fullName, b.email);
        this.regNo = b.regNo;
        this.status = b.status;
        this.createdAt = b.createdAt != null ? b.createdAt : LocalDateTime.now();
    }

    public static class Builder {
        private final String id;
        private final String fullName;
        private String email;
        private String regNo;
        private Status status = Status.ACTIVE;
        private java.time.LocalDateTime createdAt;

        public Builder(String id, String fullName){
            this.id = id; this.fullName = fullName;
        }
        public Builder email(String e){ this.email = e; return this; }
        public Builder regNo(String r){ this.regNo = r; return this; }
        public Student build(){ return new Student(this); }
    }

    @Override
    public String profile(){
        return String.format("Student[%s,%s,%s]", id, regNo, fullName);
    }

    public enum Status { ACTIVE, INACTIVE }
}
