package App.branch.pages;

import Utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.*;
import java.util.stream.Stream;

public class TeamPage extends HomePage  {
    private WebElement listHeader,teamContainer,teamEmpContainer;
    private List<WebElement> empListElement;
    private ArrayList<Integer> totalCountOfTeams;
    private String[] teams = {"All", "Data", "Engineering","Marketing","Operations","Partner Growth","Product","Recruiting"};
    private List<Employee> employees;
    private String[] teamsExceptAll;
    private int sum = 0;
    private HashMap<String, List<Employee>> empArrayList,employeeMap;

    public TeamPage(){
            pageBody = driver.findElement(By.className("team-outside-container"));
            teamContainer = pageBody.findElement(By.cssSelector("div.container-fluid.teams-container"));
            teamEmpContainer = teamContainer.findElement(By.cssSelector("div.row.row-centered"));
            listHeader = teamContainer.findElement(By.tagName("ul"));
            totalCountOfTeams = new ArrayList<>();
            empArrayList=new HashMap<String, List<Employee>>();
            employeeMap = new HashMap<String, List<Employee>>();
            teamsExceptAll = Arrays.copyOfRange(teams, 1, 8);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("window.scrollBy(0, 250)", "");
            empArrayList = readFromAllTeams();
    }

    public List<WebElement> clickOnTeam(String teamName){
        WebElement ele = listHeader.findElement(By.xpath(".//a[contains(text(),'"+teamName+"')]"));
        ele.click();
        return empListElement = teamContainer.findElements(By.xpath("//div[@class='wrap']/parent::div[@style='display: inline-block;']"));
    }

    public HashMap<String, List<Employee>> readFromAllTeams() {
        for(String team : teams){
            List<Employee> listOfEmployees = new ArrayList<>();
        empListElement = clickOnTeam(team);
        for (WebElement employee : empListElement) {
            String[] empInfo = employee.findElement(By.xpath(".//div[@class='info-block'][1]")).getText().split("\\r?\\n");
            Employee emp = new Employee();
            emp.setName(empInfo[0]);
            emp.setDept(empInfo[1]);
            listOfEmployees.add(emp);
        }
            employeeMap.put(team, listOfEmployees);
    }
        return employeeMap;
    }

    public HashMap<String, List<Employee>> readAllDataFromTeam(String teamName){
        List<Employee> listOfEmployees = new ArrayList<>();
            empListElement =clickOnTeam(teamName);
            for (WebElement employee : empListElement) {
                String[] empInfo = employee.findElement(By.xpath(".//div[@class='info-block'][1]")).getText().split("\\r?\\n");
                Employee emp = new Employee();
                emp.setName(empInfo[0]);
                emp.setDept(empInfo[1]);
                listOfEmployees.add(emp);
            }
            employeeMap.put(teamName, listOfEmployees);
            return employeeMap;
    }

    public List<Employee> getEmployeeList(String teamName){
        return empArrayList.get(teamName);
    }
    public int countEmpInTeam(String teamName){
        employees= getEmployeeList(teamName);
       return employees.size();
    }

   public int sumOfEmployeeInTeamsExceptAll(){
       for (String team: teamsExceptAll) {
           totalCountOfTeams.add(countEmpInTeam(team));
       }
       for(int count : totalCountOfTeams)
           sum += count;
       return sum;
  }

    public boolean verifyNameFromTeam(String teamName, String employee) {
        List<Employee> elist = empArrayList.get(teamName);
        boolean emp = elist.stream().filter(x -> elist.equals(employee))
                .findAny()
                .equals(employee);
        return emp;
    }

    public String getDeptFromTeam(String teamName, String employee) {
        List<Employee> elist = empArrayList.get(teamName);
        String deptName = elist.stream().filter(x -> elist.equals(employee)).findFirst().get().getDept();
        return deptName;
    }

    public boolean verifyNameFromAllToOtherTeams() {
        List<Employee> list = empArrayList.get("All");
        for (Employee employee: list) {
            for(String team : teamsExceptAll) {
                if(empArrayList.get(team).contains(employee.getName()))
                break;
            }
               return  false;
        }
        return true;
    }

    public boolean verifyDeptFromAllToOtherTeams() {
        List<Employee> list = empArrayList.get("All");
        for (Employee employee: list) {
            for(String team : teamsExceptAll) {
                List<Employee> x = empArrayList.get(team);
                if(x.contains(employee.getName()))
                     if(employee.getDept().contains(getDeptFromTeam(team,employee.getName())))
                     break;
            }
            return  false;
        }
        return true;
    }

    public boolean getTeamHasEmpPhotos(String teamName){
        empListElement = clickOnTeam(teamName);
        for (WebElement emp: empListElement) {
            if(emp.findElement(By.xpath("//div[@class='image-block']")) == null)
                return false;
        }
        return  true;
    }

    public boolean verifyIfAllTeamsHasEmpPhotos(){
        for (String team: teams) {
            if(getTeamHasEmpPhotos(team) == false)
                return false;
        }
        return true;
    }

    public boolean checkGitHubLinkOfEmp(String teamName, String empName){
        empListElement = clickOnTeam(teamName);
        Stream<WebElement> link = empListElement.stream()
                .filter(x -> x.findElement(By.xpath(".//div[@class='profile-link'][2]")).isDisplayed());
        if(link != null)
            return true;
        else
            return false;
    }

}
