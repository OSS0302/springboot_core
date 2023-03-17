package oss.core.member;

public enum Grade {
    ; //
    //BASIC,VIP
    private Long id;    // 회원 아이디
    private String name;// 회원 이름
    private Grade grade;// 회원 등급

    Grade(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
    //  데이터를 가지고오고 뽑아내는 getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
