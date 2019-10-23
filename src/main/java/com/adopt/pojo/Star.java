package com.adopt.pojo;

public class Star {
    private Integer id;

    private String photo;

    private String name;

    private Integer age;

    private Integer sex;

    private String address;

    private String phone;

    private Integer type;

    private String breed;

    private Integer adopted;

    private Integer momid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed == null ? null : breed.trim();
    }

    public Integer getAdopted() {
        return adopted;
    }

    public void setAdopted(Integer adopted) {
        this.adopted = adopted;
    }

    public Integer getMomid() {
        return momid;
    }

    public void setMomid(Integer momid) {
        this.momid = momid;
    }

	@Override
	public String toString() {
		return "Star [id=" + id + ", photo=" + photo + ", name=" + name + ", age=" + age + ", sex=" + sex + ", address="
				+ address + ", phone=" + phone + ", type=" + type + ", breed=" + breed + ", adopted=" + adopted
				+ ", momid=" + momid + "]";
	}
    
}