/**
 * Created by kkhrebtov on 2/20/14.
 */
public class Employee {
    private String employee_first_name, employee_login, manager_id, manager_team_name_1, manager_team_name_2, site_name, employee_doh, lob_name, employee_email;
    private int enk_employee_id, employee_id;


    public Employee(int enk_employee_id, int employee_id, String employee_first_name, String employee_login, String manager_id, String manager_team_name_1, String manager_team_name_2, String site_name, String employee_doh, String lob_name, String employee_email) {
        this.employee_first_name = employee_first_name;
        this.employee_login = employee_login;
        this.manager_id = manager_id;
        this.manager_team_name_1 = manager_team_name_1;
        this.manager_team_name_2 = manager_team_name_2;
        this.site_name = site_name;
        this.employee_doh = employee_doh;
        this.lob_name = lob_name;
        this.employee_email = employee_email;
        this.enk_employee_id = enk_employee_id;
        this.employee_id = employee_id;
    }

    public void setEmployeeFirstName(String employee_first_name) {
        this.employee_first_name = employee_first_name;
    }

    public void setEmployeeLogin(String employee_login) {
        this.employee_login = employee_login;
    }

    public void setManagerId(String manager_id) {
        this.manager_id = manager_id;
    }

    public void setManagerTeamName1(String manager_team_name_1) {
        this.manager_team_name_1 = manager_team_name_1;
    }

    public void setManagerTeamName2(String manager_team_name_2) {
        this.manager_team_name_2 = manager_team_name_2;
    }

    public void setSiteName(String site_name) {
        this.site_name = site_name;
    }

    public void setEmployeeDoh(String employee_doh) {
        this.employee_doh = employee_doh;
    }

    public void setLobName(String lob_name) {
        this.lob_name = lob_name;
    }

    public void setEmployeeEmail(String employee_email) {
        this.employee_email = employee_email;
    }

    public void setEnkEmployeeId(int enk_employee_id) {
        this.enk_employee_id = enk_employee_id;
    }

    public void setEmployeeId(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployeeFirstName() {

        return employee_first_name;
    }

    public String getEmployeeLogin() {
        return employee_login;
    }

    public String getManagerId() {
        return manager_id;
    }

    public String getManagerTeamName1() {
        return manager_team_name_1;
    }

    public String getManagerTeamName2() {
        return manager_team_name_2;
    }

    public String getSiteName() {
        return site_name;
    }

    public String getEmployeeDoh() {
        return employee_doh;
    }

    public String getLobName() {
        return lob_name;
    }

    public String getEmployeeEmail() {
        return employee_email;
    }

    public int getEnkEmployeeId() {
        return enk_employee_id;
    }

    public int getEmployeeId() {
        return employee_id;
    }
}
