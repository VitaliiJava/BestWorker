package com.lviv.bestworker;


public class Worker implements Runnable {

    private String fname;
    private String lname;
    private int age;

    @Override
    public void run() {

    }

    public Worker(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;

        Worker worker = (Worker) o;

        if (getAge() != worker.getAge()) return false;
        if (getFname() != null ? !getFname().equals(worker.getFname()) : worker.getFname() != null) return false;
        return getLname() != null ? getLname().equals(worker.getLname()) : worker.getLname() == null;

    }

    @Override
    public int hashCode() {
        int result = getFname() != null ? getFname().hashCode() : 0;
        result = 31 * result + (getLname() != null ? getLname().hashCode() : 0);
        result = 31 * result + getAge();
        return result;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "First name = '" + fname + '\'' +
                ", Last name='" + lname + '\'' +
                ", Age=" + age +
                "}\n";
    }
}
