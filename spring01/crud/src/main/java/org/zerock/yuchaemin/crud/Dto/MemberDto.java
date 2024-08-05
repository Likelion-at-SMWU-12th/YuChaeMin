package org.zerock.yuchaemin.crud.Dto;

public class MemberDto {
    private String name;
    private String email;
    private String organizaiton;

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getOrganizaiton() {
        return organizaiton;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setOrganizaiton(String organizaiton){
        this.organizaiton = organizaiton;
    }
    @Override
    public String toString() {
        return "MemberDto{" +
                "name=" + name + "\n" +
                ", email=" + email + "\n" +
                ", organization=" + organizaiton + "\n" +
                "}";
    }
}
