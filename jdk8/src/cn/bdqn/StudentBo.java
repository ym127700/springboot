package cn.bdqn;


public class StudentBo extends Student{

    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "StudentBo{" +
                "school='" + school + '\'' +
                "} " + super.toString();
    }
}
