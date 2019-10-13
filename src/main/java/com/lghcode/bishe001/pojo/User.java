package com.lghcode.bishe001.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class User {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 0--系统管理员,1--员工
     */
    @Column(name = "user_type")
    private Integer userType;

    /**
     * 员工编号或者管理员用户名
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 身份证号码
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 学历
     */
    private String education;

    /**
     * 住址
     */
    private String adress;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 部门名称
     */
    private String department;

    /**
     * 职位
     */
    private String position;

    /**
     * 加入日期
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 1-可以，0-不允许
     */
    @Column(name = "is_login")
    private Integer isLogin;

    /**
     * 用户头像
     */
    @Column(name = "head_img")
    private String headImg;
    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取0--系统管理员,1--员工
     *
     * @return user_type - 0--系统管理员,1--员工
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置0--系统管理员,1--员工
     *
     * @param userType 0--系统管理员,1--员工
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 获取员工编号或者管理员用户名
     *
     * @return user_no - 员工编号或者管理员用户名
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置员工编号或者管理员用户名
     *
     * @param userNo 员工编号或者管理员用户名
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取身份证号码
     *
     * @return id_card - 身份证号码
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号码
     *
     * @param idCard 身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取出生日期
     *
     * @return birthday - 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取学历
     *
     * @return education - 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取住址
     *
     * @return adress - 住址
     */
    public String getAdress() {
        return adress;
    }

    /**
     * 设置住址
     *
     * @param adress 住址
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * 获取联系电话
     *
     * @return phone - 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话
     *
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取部门名称
     *
     * @return department - 部门名称
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置部门名称
     *
     * @param department 部门名称
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取职位
     *
     * @return position - 职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位
     *
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取加入日期
     *
     * @return create_time - 加入日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置加入日期
     *
     * @param createTime 加入日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取1-可以，0-不允许
     *
     * @return is_login - 1-可以，0-不允许
     */
    public Integer getIsLogin() {
        return isLogin;
    }

    /**
     * 设置1-可以，0-不允许
     *
     * @param isLogin 1-可以，0-不允许
     */
    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}