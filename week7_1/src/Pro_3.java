class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "이름: " + name + ", 월급: " +  salary;
    }
}

class Staff extends Employee {
    private String department;
    private int peerEvaluation;

    public Staff(String name) {
        super(name, 4500);
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void evaluatePeers(Staff[] peers) {
        for (Staff peer : peers) {
            if(false == peer.equals(this)) {
                int evaluation = (int)(Math.random() * 11);
                peer.evaluate(evaluation);
            }
        }
    }

    public void evaluate(int value) {
        peerEvaluation += value;
    }

    public int getPeerEvaluation() {
        return peerEvaluation;
    }

    @Override
    public String toString() {
        return super.toString() + ", 부서: " + department + ", 동료 평가점수: " + peerEvaluation;
    }
}

class Manager extends Employee {
    private String department;
    Staff[] staffList;
    private final int BONUS_RATE = 50;
    private final int BASE_UP = 500;

    public Manager(String name, int salary, String department, Staff[] staffList) {
        super(name, salary);
        this.department = department;
        this.staffList = staffList;

        for(Staff staff : this.staffList) {
            staff.setDepartment(department);
        }
    }

    public void evaluatePerformance() {
        for(Staff staff : this.staffList) {
            staff.evaluatePeers(this.staffList);
        }

        for(Staff staff : this.staffList) {
            int performanceRating = staff.getPeerEvaluation();
            int bonus = performanceRating * BONUS_RATE;
            int newSalary = staff.getSalary() + BASE_UP + bonus;
            staff.setSalary(newSalary);
        }
    }

    public Staff[] getStaffList() {
        return staffList;
    }

    @Override
    public String toString() {
        return super.toString() + "부서: " + department;
    }
}

public class Pro_3 {
    public static void main(String[] args) {
        Staff[] stafflist = new Staff[3];
        stafflist[0] = new Staff("김인하");
        stafflist[1] = new Staff("이인하");
        stafflist[2] = new Staff("강인하");
        Manager manager = new Manager("최인하", 50000, "SW개발팀", stafflist);

        System.out.println("Staff Information:");
        for(Staff staff : manager.getStaffList()) {
            System.out.println(staff);
        }
        System.out.println();

        manager.evaluatePerformance();

        System.out.println("After Performance Evaluation:");
        for (Staff staff : manager.getStaffList()) {
            System.out.println(staff);
        }
    }
}