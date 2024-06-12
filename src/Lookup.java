
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Lookup {
    public static void main(String[] args) {
        // Maps company ID to a Company object
        HashMap<String, Company> companyData = readCompanyData("C:\\Users\\hp\\IdeaProjects\\miniHackathon\\src\\Company.csv");
        // Maps Sales Rep last name to a list of their associated companies
        HashMap<String, List<Company>> salesRepCompanies = findCompanyDataByLastName(companyData, "C:\\Users\\hp\\IdeaProjects\\miniHackathon\\src\\SalesReps.csv");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Sales Rep Last Name: ");
        String lastName = scanner.nextLine();

        List<Company> repCompanies = salesRepCompanies.get(lastName);
        if (repCompanies != null) {
            System.out.println("** Company Data for " + lastName + " **");
            for (Company company : repCompanies) {
                System.out.println(company.toString()); // Display company details using toString()
            }
        } else {
            System.out.println("Sales Rep with last name " + lastName + " not found.");
        }
    }

    // Reads company data from CSV and creates Company objects
    public static HashMap<String, Company> readCompanyData(String fileName) {
        HashMap<String, Company> companies = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String salesRepId = data[2];
                Company company = new Company(
                        data[0], // Index (optional)
                        data[1],
                        salesRepId,
                        data[3], // Name
                        data[4], // Website
                        data[5], // Country
                        data[6], // Description
                        data[7], // Founded
                        data[8], // Industry
                        data[9]  // Number of employees
                );
                companies.put(salesRepId, company);
            }
        } catch (Exception e) {
            System.out.println("Error reading company data: " + e.getMessage());
        }
        return companies;
    }

    // Reads Sales Rep data and associates companies based on SalesRepId
    public static HashMap<String, List<Company>> findCompanyDataByLastName(HashMap<String, Company> companyData, String salesRepFile) {
        HashMap<String, List<Company>> salesRepCompanies = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(salesRepFile))) {
            String line;
            reader.readLine(); // Skip header line
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String lastName = data[2];
                String salesRepId = data[0];
                List<Company> repCompanies = salesRepCompanies.computeIfAbsent(lastName, k -> new ArrayList<>());
                Company company = companyData.get(salesRepId);
                if (company != null) {
                    repCompanies.add(company);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading sales rep data: " + e.getMessage());
        }
        return salesRepCompanies;
    }
}
