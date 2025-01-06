package reports;

import java.util.ArrayList;
import java.util.List;

import actions.Order;
import army.Army;
import army.General;
import army.Soldier;

public class Secretary {
    private General general1, general2;
    private Army army1, army2;
    private List<String> reports;

    public Secretary(General general1, General general2) {
        this.general1 = general1;
        this.general2 = general2;
        this.army1 = general1.getArmy();
        this.army2 = general2.getArmy();
        this.reports = new ArrayList<String>();
    }

    public void addReport(String report) {
        reports.add(report);
    }

    public String getActionName (Order order, String generalName) {
        String actionName = "";
        switch (order.getClass().getSimpleName()) {
            case "AttackOrder":
                actionName = "Generał " + generalName + " atakuje!";
                break;
            case "ManeuverOrder":
                actionName = "Generał " + generalName + " zarządza manewry!";
                break;
            case "BuySoldierOrder":
                actionName = "Generał " + generalName + " kupuje żołnierzy!";
                break;
        }
        return actionName.toString();
    }

    public String getGeneralReport(General general) {
        List<String> generalReports = new ArrayList<String>();
        
        String report = "";

        for (Order order : general.getOrders()) {
            generalReports.add(getActionName(order, general.getName()));
        }

        for (String order : generalReports) {
            report += order + "\n";
        }
        return report.toString();
    }

    public String getRankName(int rank) {
        
        String rankName = "";
        switch (rank) {
            case 1:
                rankName = "Szeregowy";
                break;
            case 2:
                rankName = "Kapral";
                break;
            case 3:
                rankName = "Kapitan";
                break;
            case 4:
                rankName = "Major";
                break;
        }
        return rankName;
    }

    
    public String getRanksReport(Army army) {
        int []ranksArmy = new int[4];
        
        for (Soldier soldier : army.getSoldiers()) {
            ranksArmy[soldier.getRank()-1 ]++;
        }

        for (int i = 0; i < ranksArmy.length; i++) {
            reports.add("Stopień " + getRankName(i+1) + " w armii: " + ranksArmy[i] + "\n");
        }
        return reports.toString();
    }

    public void generateReport() {
        reports.add("Raport dotyczący armii:\n");
        reports.add("Armia 1:\n  - Liczba żołnierzy: " + army1.getSoldiers().size() + "\n");
        reports.add(getRanksReport(army1));
        reports.add(getGeneralReport(general1));
        reports.add("Armia 2:\n  - Liczba żołnierzy: " + army2.getSoldiers().size() + "\n");
        reports.add(getRanksReport(army2));
        reports.add(getGeneralReport(general2));
        addReport(reports.toString());
    }

    public List<String> getReports() {
        return reports;
    }

    public void printReports() {
        for (String report : reports) {
            System.out.println(report);
        }
    }
}